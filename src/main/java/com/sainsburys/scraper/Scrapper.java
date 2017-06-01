package com.sainsburys.scraper;

import com.sainsburys.scraper.Connector.HttpConnect;
import com.sainsburys.scraper.model.Product;
import com.sainsburys.scraper.utils.Constants;
import com.sainsburys.scraper.utils.Formatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scraps the web page from the passed in URL and build a JSON with the list of product details.
 *
 * @author rdurairaj
 */
public class Scrapper {
    /**
     * Starts the scraping process, and produces JSON output.
     *
     * @param urlStr String URL of the WebPage to scrap information from.
     * @return String containing the JSON code.
     */
    public String scrape(String urlStr) {
        Connection connection = HttpConnect.establishConnection(urlStr);
        if (connection == null) {
            // Empty JSON gets returned if connection not made.
            return "{}";
        }

        // Gets the list of all products.
        Element allProductsElement = HttpConnect.getDocument(connection).select(Constants.CSS_PRODUCT_LIST).first();

        if (allProductsElement == null) {
            // If products are not found don't continue.
            return "{}";
        }

        JSONArray results = new JSONArray();
        JSONObject json = new JSONObject();
        float total = 0.0f;
        json.put("results", results);

        // Get all individual products. Discard the <li> allProducts with lastChild class.
        Elements eachProductElement = allProductsElement.getElementsByTag(Constants.TAG_LI).not(Constants.CSS_LAST_CHILD);
        for (Element productElement : eachProductElement) {
            Element productInfo = productElement.select(Constants.CSS_PRODUCT_INFO).first();
            Element productLink = productInfo.getElementsByTag(Constants.TAG_A).first();
            String productURL = productLink.attr(Constants.ATTR_HREF);

            Product product = getProduct(productURL);

            results.add(product.toJSON());
            total += product.getUnitPrice();
        }

        // Total price
        json.put("total", total);

        return json.toJSONString();
    }


    /**
     * Opens URL Connection, and returns a Product populated with scraped
     * information.
     *
     * @param productURL A String url.
     * @return Product object with data.
     */
    public Product getProduct(String productURL) {
        String title = "";
        float size = 0.0f;
        float unitPrice = 0.0f;
        String description = "";

        Connection connection = HttpConnect.establishConnection(productURL);
        if (connection == null) {
            // Empty JSON gets returned if connection not made.
            return null;
        }
        Document doc = HttpConnect.getDocument(connection);
        Element element = doc.select(Constants.CSS_PRODUCT).first();
        if (element == null) {
            return null;
        } else {
            // Title
            Element titleElement = element.getElementsByTag(Constants.TAG_H1).first();
            title = titleElement.text();

            // Size
            size = doc.toString().length() / 1024;
        }

        // Price per unit
        element = doc.select(Constants.CSS_PRODUCT_PRICE).first();
        if (element == null) {
            return null;
        } else {
            unitPrice = Formatter.formatPrice(element.text());
        }

        // Description
        element = doc.select(Constants.CSS_PRODUCT_TEXT).first();
        if (element == null) {
            return null;
        } else {
            description = element.text();
        }

        return new Product(title, size, unitPrice, description);
    }
}

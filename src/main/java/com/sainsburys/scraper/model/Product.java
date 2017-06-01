package com.sainsburys.scraper.model;

import com.sainsburys.scraper.utils.Formatter;
import org.json.simple.JSONObject;

/**
 * Pojo which holds Product Information.
 * 
 * @author rdurairaj
 */
public class Product {
    private String title;
    private float size;
    private float unitPrice;
    private String description;

    /**
     * Builds a product.
     * @param title
     * @param size
     * @param unitPrice
     * @param description
     */
    public Product(String title, float size, float unitPrice, String description) {
        this.title = title;
        this.size = size;
        this.unitPrice = unitPrice;
        this.description = description;
    }
    
    /**
     * Method returns JSON object of Product.
     * 
     * @return JSONObject.
     */
    public JSONObject toJSON() {
        JSONObject product = new JSONObject();
        product.put("title", title);
        product.put("size", size);
        product.put("unit_price", Formatter.formatPriceWithDecimals(unitPrice));
        product.put("description", description);
        
        return product;
    }

    public String getTitle() {
        return title;
    }

    public float getSize() {
        return size;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }
}
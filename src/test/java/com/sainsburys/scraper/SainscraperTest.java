package com.sainsburys.scraper;

import com.sainsburys.scraper.model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Scrapper Test
 *
 * @author rdurairaj
 */
public class SainscraperTest {
    Scrapper scrapper;

    @Before
    public void setUp() {
        scrapper = new Scrapper();
    }

    @After
    public void tearDown() {
        scrapper = null;
    }

    @Test
    public void shouldScrape() {
        String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";
        String json = scrapper.scrape(url);
        assertTrue(!json.isEmpty());
    }

    @Test
    public void shouldScrapeWithTotalAndResults() {
        String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";
        String json = scrapper.scrape(url);
        assertTrue(json.contains("total") && json.contains("results"));
    }

    @Test
    public void shouldScrapeProductInfoReturnsNullWhenNoProductsFound() {
        String adr = "http://www.linux.com";
        Product product = scrapper.getProduct(adr);
        assertNull(product);
    }

    @Test
    public void shouldScrapeProductInfoReturnsObject() {
        String adr = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-conference-pears--ripe---ready-x4-%28minimum%29";
        Product product = scrapper.getProduct(adr);

        assertNotNull(product);
        assertNotNull(product.getTitle());
        assertTrue(product.getSize() > 0);
        assertTrue(product.getUnitPrice() == 1.95f);
        assertNotNull(product.getDescription());
        assertTrue(product.getDescription().length() > 0);
    }

    @Test
    public void shouldScrapeProductInfoReturnsInfos() {
        String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";
        String json = scrapper.scrape(url);
        assertTrue(json.contains("Avocado"));
    }
}
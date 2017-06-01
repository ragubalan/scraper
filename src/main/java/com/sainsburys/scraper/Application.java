package com.sainsburys.scraper;

import com.sainsburys.scraper.utils.Validator;

/**
 * This class is the entry point to Scrape a Webpage of the passed in URL and provides JSON output
 *
 * @author rdurairaj
 */
public class Application {

    public static final void main(String[] args) {
        String urlStr = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";

        // Overwrite the URL with the command line URL, if present.
        if (args.length == 1) {
            urlStr = args[0];
        }

        if (Validator.validateURL(urlStr)) {
            Scrapper scraper = new Scrapper();
            System.out.println(scraper.scrape(urlStr));
        } else {
            System.exit(0);
        }
    }
}
package com.sainsburys.scraper.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Validator.
 *
 * @author rdurairaj
 */
public class Validator {
    /**
     * Method to validate whether the passed in URL is valid or not.
     *
     * @param urlStr String to validate as a URL.
     * @return Whether the URL is valid or not.
     */
    public static final boolean validateURL(String urlStr) {
        try {
            new URL(urlStr);
        } catch (MalformedURLException ex) {
            System.err.println("Given URL '" + urlStr + "' is not valid.");
            return false;
        }
        return true;
    }
}

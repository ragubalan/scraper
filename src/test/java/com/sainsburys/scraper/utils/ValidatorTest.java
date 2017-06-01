package com.sainsburys.scraper.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Validator Test.
 *
 * @author rdurairaj
 */
public class ValidatorTest {
    @Test
    public void shouldPassWhenValidURL() {
        String urlStr = "http://www.gmail.com";
        boolean result = Validator.validateURL(urlStr);
        assertTrue(result);
    }

    @Test
    public void shouldFailWhenInValidURL() {
        String urlStr = "fails";
        boolean result = Validator.validateURL(urlStr);
        assertFalse(result);
    }
}

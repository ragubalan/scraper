package com.sainsburys.scraper.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Formatter test.
 *
 * @author rdurairaj
 */
public class FormatterTest {
    @Test
    public void shouldFormatPrice() {
        String priceUnit = "£1/unit";
        float result = Formatter.formatPrice(priceUnit);
        assertEquals(String.valueOf(result), "1.0");
    }

    @Test
    public void shouldFormatPriceWithDecimals() {
        float priceUnit = 1.3589f;
        String result = Formatter.formatPriceWithDecimals(priceUnit);
        assertEquals(result, "1.36");
    }
}

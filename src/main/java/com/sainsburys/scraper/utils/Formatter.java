package com.sainsburys.scraper.utils;

import java.text.DecimalFormat;

/**
 * Utility class to format.
 *
 * @author rdurairaj
 */
public class Formatter {

    /**
     * Formats the passed in string to be a price with 2 decimal places.
     *
     * @param priceUnit String containing the price with £ and /unit.
     * @return value with decimal places.
     */
    public static float formatPrice(String priceUnit) {
        priceUnit = priceUnit.replace("/unit", "");
        priceUnit = priceUnit.replace("£", "");
        float ppUnit = Float.parseFloat(priceUnit);
        return ppUnit;
    }

    /**
     * Formats the passed in string to be a price with 2 decimal places.
     *
     * @param ppUnit Value of price without right decimals.
     * @return value with 2 decimal places.
     */
    public static String formatPriceWithDecimals(float ppUnit) {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(ppUnit);
    }
}

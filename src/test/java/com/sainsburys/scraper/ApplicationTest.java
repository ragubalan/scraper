package com.sainsburys.scraper;

import mockit.Expectations;
import org.junit.Test;

/**
 * Application Test
 *
 * @author rdurairaj
 */
public class ApplicationTest {

    @Test
    public void shouldScrape() {
        Application.main(new String[]{});
    }

    @Test(expected = IllegalStateException.class)
    public void shouldFailScrape() {
        new Expectations(System.class) {{
            System.exit(1);
        }};
        Application.main(new String[]{"fails"});
    }
}
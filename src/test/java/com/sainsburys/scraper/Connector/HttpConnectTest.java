package com.sainsburys.scraper.Connector;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Http connect test.
 *
 * @author rdurairaj
 */
public class HttpConnectTest {
    @Test
    public void shouldConnectWhenURLSucceeds() {
        String adr = "http://www.linux.com";
        Connection connection = HttpConnect.establishConnection(adr);
        assertNotNull(connection);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenURLFails() {
        String adr = "fails";
        Connection connection = HttpConnect.establishConnection(adr);
    }

    @Test
    public void shouldDocumentWhenURLSucceeds() {
        String adr = "http://www.linux.com";
        Connection connection = HttpConnect.establishConnection(adr);
        Document doc = HttpConnect.getDocument(connection);
        assertNotNull(doc);
    }
}

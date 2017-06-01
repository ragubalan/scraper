package com.sainsburys.scraper.Connector;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used to establish HTTP connections.
 *
 * @author rdurairaj
 */
public class HttpConnect {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0";

    /**
     * Establishes a HTTP connection using Jsoup.
     *
     * @param urlStr String URL to establish connection with.
     * @return Connection.
     */
    public static Connection establishConnection(String urlStr) {
        Connection connection = Jsoup.connect(urlStr);
        return connection;
    }

    /**
     * Returns the document from the connected location.
     * When no document can be fetched exception is thrown.
     *
     * @param connection Established connection.
     * @return Document.
     */
    public static Document getDocument(Connection connection) {
        Document doc = null;
        try {
            doc = connection.userAgent(USER_AGENT).get();
        } catch (IOException ex) {
            Logger.getLogger(HttpConnect.class.getName()).log(Level.SEVERE, "Error occurred while trying to get Document with Connection. " + connection, ex);
        }
        return doc;
    }
}

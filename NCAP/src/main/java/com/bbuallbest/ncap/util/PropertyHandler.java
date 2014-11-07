package com.bbuallbest.ncap.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by happy on 22/10/2014.
 */
public class PropertyHandler {

    private static final String NCAP_PROPERTIES = "ncap.properties";
    private Properties properties = new Properties();

    public PropertyHandler() throws IOException {
        InputStream fileStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(NCAP_PROPERTIES);
        properties.load(fileStream);
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}

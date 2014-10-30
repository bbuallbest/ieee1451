package com.bbuallbest.stim.service.util;

import com.bbuallbest.stim.util.Path;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by happy on 22/10/2014.
 */
public class StimPropertyHandler {

    private Properties properties = new Properties();

    public StimPropertyHandler() throws IOException {
        InputStream fileStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(Path.DEVICE_PROPERTIES.getPath());
//        properties.load(new FileInputStream(Path.DEVICE_PROPERTIES.getPath()));
        properties.load(fileStream);
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}

package com.bbuallbest.ncap.service.url;

/**
 * Created by happy on 03/11/2014.
 */
public enum DATA_FORMAT {
    XML(".xml"),
    JSON(".json"),
    RAW(".stream");

    private String extension;

    DATA_FORMAT(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}

package com.bbuallbest.stim.util;

/**
 * Created by happy on 22/10/2014.
 */
public enum Stim {
    META_TEDS("stim.meta.teds"),
    TEDS_PATH("stim.teds.path"),
    CHANNEL_AMOUNT("channel.amount"),
    CHANNEL_TEDS_PREFIX("channel.teds.prefix"),
    CHANNEL_TEDS_EXTENSION("channel.teds.extension"),
    CHANNEL_ID("channel."),
    CALIBRATION_TEDS_PREFIX("calibration.teds.prefix"),
    CALIBRATION_TEDS_EXTENSION("calibration.teds.extension"),
    MEASUREMENT_PATH_PREFIX("measurement.path.prefix"),
    MEASUREMENT_PATH_SUFFIX("measurement.path.suffix");

    private String property;

    Stim(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}

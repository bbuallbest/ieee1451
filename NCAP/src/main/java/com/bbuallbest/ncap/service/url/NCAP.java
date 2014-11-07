package com.bbuallbest.ncap.service.url;

/**
 * Created by happy on 03/11/2014.
 */
public enum NCAP {
    STIM_IP("stim.ip"),
    STIM_PROTOCOL("stim.protocol"),
    STIM_PORT("stim.port"),
    STIM_CHANNELS_AMOUNT("stim.channels.amount"),
    STIM_META_TEDS_URI("stim.uri.meta.teds"),
    STIM_CHANNEL_TEDS_URI_PREFIX("stim.uri.channel.teds.prefix"),
    STIM_CHANNEL_TEDS_URI_SUFFIX("stim.uri.channel.teds.suffix"),
    STIM_CALIBRATION_TEDS_URI_SUFFIX("stim.uri.calibration.teds.suffix"),
    STIM_MEASUREMEBT_URI_SUFFIX("stim.uri.measurement.suffix");

    private String property;

    NCAP(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}

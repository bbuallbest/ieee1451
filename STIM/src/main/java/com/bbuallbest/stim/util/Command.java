package com.bbuallbest.stim.util;

/**
 * Created by happy on 22/10/2014.
 */
public enum Command {
    MODPROBE_GPIO("modprobe.gpio"),
    MODPROBE_THERM("modprobe.therm");

    private String property;

    Command(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}

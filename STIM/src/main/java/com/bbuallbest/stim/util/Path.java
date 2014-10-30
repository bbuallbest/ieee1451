package com.bbuallbest.stim.util;

/**
 * Created by happy on 22/10/2014.
 */
public enum Path {
    STIM_DIR("/home/pi/stim/"),
    TEDS_DIR("/home/pi/stim/teds/"),
//    DEVICE_PROPERTIES("/home/pi/stim/stim.properties"),
    DEVICE_PROPERTIES("stim.properties"),
//    COMMAND_PROPERTIES("/home/pi/stim/command.properties");
    COMMAND_PROPERTIES("command.properties");

    private String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

package com.bbuallbest.stim.service.measurement;

/**
 * Created by happy on 19/10/2014.
 */
public class MeasurementReader {
    private String path;

    public void getMeasurementValue() {

    }

//    private String buildPath(String deviceName) {
//        return new StringBuilder(PATH_PREFIX)
//                .append(deviceName)
//                .append(PATH_SUFFIX)
//                .toString();
//    }

    private double parseLineToDouble(String line) {
        String number = line.substring(29, 34);
        return Double.parseDouble(number) / 1000;
    }
}

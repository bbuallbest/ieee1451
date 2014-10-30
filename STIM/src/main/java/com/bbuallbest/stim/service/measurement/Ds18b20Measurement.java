package com.bbuallbest.stim.service.measurement;

import com.bbuallbest.stim.entity.Measurement;
import com.bbuallbest.stim.service.util.StimPropertyHandler;
import com.bbuallbest.stim.util.Stim;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * Created by happy on 19/10/2014.
 */
public class Ds18b20Measurement implements MeasurementService {

//    private static final String PATH_PREFIX = "/sys/bus/w1/devices/";
//    private static final String PATH_SUFFIX = "/w1_slave";
//    private static final String ID_1 = "28-0000039e958b";
    private static final int MEASUREMENT_START_POSITION = 29;
    private static final int MEASUREMENT_END_POSITION = 34;

    @Inject
    private StimPropertyHandler propertyHandler;

    public double measureTemp(int channelNumber) {
        BufferedReader reader = null;
        String destinationLine = null;
        String channelId = propertyHandler.getProperty(Stim.CHANNEL_ID.getProperty() + channelNumber);
        try {
            reader = new BufferedReader(new FileReader(buildPath(channelId)));
            reader.readLine();
            destinationLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (destinationLine != null)
            return parseLineToDouble(destinationLine);
        return 0;
    }

    private String buildPath(String deviceName) {
        return new StringBuilder(propertyHandler.getProperty(Stim.MEASUREMENT_PATH_PREFIX.getProperty()))
                .append(deviceName)
                .append(propertyHandler.getProperty(Stim.MEASUREMENT_PATH_SUFFIX.getProperty()))
                .toString();
    }

    private double parseLineToDouble(String line) {
        String number = line.substring(MEASUREMENT_START_POSITION, MEASUREMENT_END_POSITION);
        return Double.parseDouble(number) / 1000;
    }

    @Override
    public Measurement measure(int channel) {
        String channelsAmount = propertyHandler.getProperty(Stim.CHANNEL_AMOUNT.getProperty());
        if(Integer.parseInt(channelsAmount) < channel + 1)
            return null;

        return new Measurement(measureTemp(channel), System.currentTimeMillis());
    }
}

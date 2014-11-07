package com.bbuallbest.ncap.service.url;

import com.bbuallbest.ncap.util.PropertyHandler;

import java.io.IOException;

/**
 * Created by happy on 03/11/2014.
 */
public class NCAPPropertyObject {

    private PropertyHandler propertyHandler;

    private String stimIp;
    private String stimProtocol;
    private String stimPort;
    private int stimChannelsAmount;
    private String stimMetaTedsUri;
    private String stimChannelTedsUriPrefix;
    private String stimChannelTedsUriSuffix;
    private String stimCalibrationTedsUriSuffix;
    private String stimMeasurementUriSuffix;

    public NCAPPropertyObject() {
        try {
            propertyHandler = new PropertyHandler();
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        stimIp = propertyHandler.getProperty(NCAP.STIM_IP.getProperty());
        stimPort = propertyHandler.getProperty(NCAP.STIM_PORT.getProperty());
        stimProtocol = propertyHandler.getProperty(NCAP.STIM_PROTOCOL.getProperty());
        stimChannelsAmount = Integer
                .parseInt(propertyHandler.getProperty(NCAP.STIM_CHANNELS_AMOUNT.getProperty()));
        stimMetaTedsUri = propertyHandler.getProperty(NCAP.STIM_META_TEDS_URI.getProperty());
        stimChannelTedsUriPrefix = propertyHandler.getProperty(NCAP.STIM_CHANNEL_TEDS_URI_PREFIX.getProperty());
        stimChannelTedsUriSuffix = propertyHandler.getProperty(NCAP.STIM_CHANNEL_TEDS_URI_SUFFIX.getProperty());
        stimCalibrationTedsUriSuffix = propertyHandler.getProperty(NCAP.STIM_CALIBRATION_TEDS_URI_SUFFIX.getProperty());
        stimMeasurementUriSuffix = propertyHandler.getProperty(NCAP.STIM_MEASUREMEBT_URI_SUFFIX.getProperty());
    }

    public PropertyHandler getPropertyHandler() {
        return propertyHandler;
    }

    public String getStimIp() {
        return stimIp;
    }

    public String getStimProtocol() {
        return stimProtocol;
    }

    public String getStimPort() {
        return stimPort;
    }

    public int getStimChannelsAmount() {
        return stimChannelsAmount;
    }

    public String getStimMetaTedsUri() {
        return stimMetaTedsUri;
    }

    public String getStimChannelTedsUriPrefix() {
        return stimChannelTedsUriPrefix;
    }

    public String getStimChannelTedsUriSuffix() {
        return stimChannelTedsUriSuffix;
    }

    public String getStimCalibrationTedsUriSuffix() {
        return stimCalibrationTedsUriSuffix;
    }

    public String getStimMeasurementUriSuffix() {
        return stimMeasurementUriSuffix;
    }
}

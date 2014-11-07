package com.bbuallbest.ncap.service.url;

/**
 * Created by happy on 03/11/2014.
 */
public interface UrlBuilder {
    String buildMetaTedsUrl(DATA_FORMAT format);
    String buildChannelTedsUrl(int channelNumber, DATA_FORMAT format);
    String buildCalibrationTedsUrl(int channelNumber, DATA_FORMAT format);
    String buildMeasurementUrl(int channelNumber, DATA_FORMAT format);
}

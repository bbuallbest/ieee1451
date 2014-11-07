package com.bbuallbest.ncap.service.url;

import com.bbuallbest.ncap.util.PropertyHandler;

import java.io.IOException;

/**
 * Created by happy on 03/11/2014.
 */
public class PropertyUrlBuilder implements UrlBuilder {

    private NCAPPropertyObject property = new NCAPPropertyObject();

    @Override
    public String buildMetaTedsUrl(DATA_FORMAT format) {
        StringBuilder url = new StringBuilder();
        url.append(buildStimDomain());
        url.append(property.getStimMetaTedsUri());
        url.append(format.getExtension());
        return url.toString();
    }

    @Override
    public String buildChannelTedsUrl(int channelNumber, DATA_FORMAT format) {
        StringBuilder url = new StringBuilder();
        url.append(buildStimDomain());
        url.append(property.getStimChannelTedsUriPrefix());
        url.append("" + channelNumber);
        url.append(property.getStimChannelTedsUriSuffix());
        url.append(format.getExtension());
        return url.toString();
    }

    @Override
    public String buildCalibrationTedsUrl(int channelNumber, DATA_FORMAT format) {
        StringBuilder url = new StringBuilder();
        url.append(buildStimDomain());
        url.append(property.getStimChannelTedsUriPrefix());
        url.append("" + channelNumber);
        url.append(property.getStimCalibrationTedsUriSuffix());
        url.append(format.getExtension());
        return url.toString();
    }

    @Override
    public String buildMeasurementUrl(int channelNumber, DATA_FORMAT format) {
        StringBuilder url = new StringBuilder();
        url.append(buildStimDomain());
        url.append(property.getStimChannelTedsUriPrefix());
        url.append("" + channelNumber);
        url.append(property.getStimMeasurementUriSuffix());
        url.append(format.getExtension());
        return url.toString();
    }

    private String buildStimDomain() {
        StringBuilder domain = new StringBuilder();
        domain.append(property.getStimProtocol());
        domain.append(property.getStimIp());
        domain.append(property.getStimPort());
        return domain.toString();
    }
}

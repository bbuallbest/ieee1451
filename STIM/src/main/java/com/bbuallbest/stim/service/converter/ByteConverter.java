package com.bbuallbest.stim.service.converter;

import com.bbuallbest.stim.entity.Measurement;
import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.entity.teds.MetaTeds;

/**
 * Created by happy on 30/10/2014.
 */
public interface ByteConverter {
    byte[] convertMetaTeds(MetaTeds metaTeds);
    byte[] convertChannelTeds(ChannelTeds channelTeds);
    byte[] convertMeasurement(Measurement measurement);
}

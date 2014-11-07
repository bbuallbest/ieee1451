package com.bbuallbest.ncap.service.client;

import com.bbuallbest.ncap.entity.Measurement;
import com.bbuallbest.ncap.entity.teds.CalibrationTeds;
import com.bbuallbest.ncap.entity.teds.ChannelTeds;
import com.bbuallbest.ncap.entity.teds.MetaTeds;

/**
 * Created by happy on 06/11/2014.
 */
public interface StimClient {
    MetaTeds getMetaTeds();
    ChannelTeds getChannelTeds(int channel);
    CalibrationTeds getCalibrationTeds(int channel);
    Measurement getMeasurement(int channel);
}

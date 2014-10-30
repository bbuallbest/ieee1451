package com.bbuallbest.stim.service.teds;

import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.entity.teds.MetaTeds;

/**
 * Created by happy on 21/10/2014.
 */
public interface TedsService {
    MetaTeds getMetaTeds();
    ChannelTeds getChannelTeds(int channelNumber);
}

package com.bbuallbest.stim.rest.config;

import com.bbuallbest.stim.rest.resources.ChannelResource;
import com.bbuallbest.stim.rest.resources.MetaResource;
import com.bbuallbest.stim.service.measurement.Ds18b20Measurement;
import com.bbuallbest.stim.service.measurement.MeasurementService;
import com.bbuallbest.stim.service.teds.TedsService;
import com.bbuallbest.stim.service.teds.XmlTedsService;
import com.bbuallbest.stim.service.util.StimPropertyHandler;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class RestConfig extends ResourceConfig{
    public RestConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(XmlTedsService.class)
                        .to(TedsService.class)
                        .in(Singleton.class);
                bind(StimPropertyHandler.class)
                        .to(StimPropertyHandler.class)
                        .in(Singleton.class);
                bind(Ds18b20Measurement.class)
                        .to(MeasurementService.class)
                        .in(Singleton.class);
            }
        });
        register(MetaResource.class);
        register(ChannelResource.class);
    }
}

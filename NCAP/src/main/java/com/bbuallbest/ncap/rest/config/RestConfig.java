package com.bbuallbest.ncap.rest.config;

import com.bbuallbest.ncap.rest.resources.StimResource;
import com.bbuallbest.ncap.rest.resources.TestResource;
import com.bbuallbest.ncap.service.client.RaspberryJsonStimClient;
import com.bbuallbest.ncap.service.client.StimClient;
import com.bbuallbest.ncap.service.url.PropertyUrlBuilder;
import com.bbuallbest.ncap.service.url.UrlBuilder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

/**
 * Created by happy on 31/10/2014.
 */

@ApplicationPath("/rest")
public class RestConfig extends ResourceConfig{
    public RestConfig() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(PropertyUrlBuilder.class)
                        .to(UrlBuilder.class);
//                        .in(Singleton.class);
                bind(RaspberryJsonStimClient.class)
                        .to(StimClient.class)
                        .in(Singleton.class);

            }
        });
        register(StimResource.class);
        register(TestResource.class);
    }
}

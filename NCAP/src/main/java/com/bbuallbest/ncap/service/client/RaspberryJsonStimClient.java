package com.bbuallbest.ncap.service.client;

import com.bbuallbest.ncap.entity.Measurement;
import com.bbuallbest.ncap.entity.teds.CalibrationTeds;
import com.bbuallbest.ncap.entity.teds.ChannelTeds;
import com.bbuallbest.ncap.entity.teds.MetaTeds;
import com.bbuallbest.ncap.service.url.DATA_FORMAT;
import com.bbuallbest.ncap.service.url.UrlBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class RaspberryJsonStimClient implements StimClient{

    @Inject
    private UrlBuilder urlBuilder;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Client client = ClientBuilder.newClient();

    @Override
    public MetaTeds getMetaTeds() {
        MetaTeds metaTeds = null;
        WebTarget webTarget = client.target(urlBuilder.buildMetaTedsUrl(DATA_FORMAT.JSON));
        String entity = generateResponse(webTarget);

        try {
            metaTeds = objectMapper.readValue(entity, MetaTeds.class);
            System.out.println(metaTeds.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metaTeds;
    }

    @Override
    public ChannelTeds getChannelTeds(int channel) {
        return null;
    }

    @Override
    public CalibrationTeds getCalibrationTeds(int channel) {
        return null;
    }

    @Override
    public Measurement getMeasurement(int channel) {
        return null;
    }

    private String generateResponse(WebTarget webTarget) {
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        return response.readEntity(String.class);
    }
}

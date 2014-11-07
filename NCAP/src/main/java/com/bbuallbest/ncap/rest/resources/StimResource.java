package com.bbuallbest.ncap.rest.resources;

import com.bbuallbest.ncap.entity.teds.MetaTeds;
import com.bbuallbest.ncap.service.client.StimClient;
import com.bbuallbest.ncap.service.url.UrlBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by happy on 31/10/2014.
 */

@Path("/stim/{stimNumber}")
public class StimResource {

    @Inject
    private StimClient stimClient;

    @Inject
    private UrlBuilder urlBuilder;

//    @GET
//    @Path("/testmetateds")
//    @Produces("text/html")
//    public Response testGetMetaTeds() {
//
//        Client client = ClientBuilder.newClient();
//        WebTarget webTarget = client.target("http://192.168.1.12:8080/rest/meta/teds.json");
//
//        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
//        Response response = builder.get();
//
//        System.out.println(response.getStatus());
//
//        String entity = response.readEntity(String.class);
//
//        System.out.println(entity);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            MetaTeds metaTeds = objectMapper.readValue(entity, MetaTeds.class);
//            System.out.println(metaTeds.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return Response.ok().entity("<html><body>Success</body></html>").build();
//    }

    @GET
    @Path("/meta/teds")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMetaTeds() {
        MetaTeds metaTeds = stimClient.getMetaTeds();
        System.out.println(metaTeds);
        return Response.ok().entity(metaTeds).build();
    }
}
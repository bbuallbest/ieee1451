package com.bbuallbest.stim.rest.resources;

import com.bbuallbest.stim.service.converter.ByteConverter;
import com.bbuallbest.stim.service.teds.TedsService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

@Path("/meta")
public class MetaResource {

    @Inject
    private TedsService tedsService;

    @Inject
    private ByteConverter byteConverter;

    @GET
    @Path("/teds.json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonMetaTeds() {
        return Response
                .ok()
                .entity(tedsService.getMetaTeds())
                .build();
    }

    @GET
    @Path("/teds.xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response getXmlMetaTeds() {
        return Response
                .ok()
                .entity(tedsService.getMetaTeds())
                .build();
    }

    @GET
    @Path("/teds.stream")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRawMetaTeds() {
        StreamingOutput stream = new StreamingOutput() {
            @Override
            public void write(OutputStream out) throws IOException {
                out.write(byteConverter.convertMetaTeds(tedsService.getMetaTeds()));
            }
        };
        return Response
                .ok(stream)
                .build();
    }
}

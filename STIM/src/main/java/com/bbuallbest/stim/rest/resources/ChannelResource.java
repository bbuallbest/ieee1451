package com.bbuallbest.stim.rest.resources;

import com.bbuallbest.stim.entity.Measurement;
import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.service.measurement.Ds18b20Measurement;
import com.bbuallbest.stim.service.measurement.MeasurementService;
import com.bbuallbest.stim.service.teds.TedsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by happy on 19/10/2014.
 */

@Path("/channel/{channel}")
public class ChannelResource {

    @Inject
    private TedsService tedsService;
    @Inject
    private MeasurementService measurementService;

    @GET
    @Path("/measurement.json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonMeasurement(@PathParam("channel") int channelNumber) {
        Measurement measurement = measurementService.measure(channelNumber);

        if(measurement == null)
            return Response.status(404).build();

        return Response
                .ok()
                .entity(measurement)
                .build();
    }

    @GET
    @Path("/measurement.xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response getXmlMeasurement(@PathParam("channel") int channelNumber) {
        Measurement measurement = measurementService.measure(channelNumber);

        if(measurement == null)
            return Response.status(404).build();

        return Response
                .ok()
                .entity(measurement)
                .build();
    }

    @GET
    @Path("/teds.json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonChannelTeds(@PathParam("channel") int channelNumber) {
        ChannelTeds teds = tedsService.getChannelTeds(channelNumber);

        if(teds == null)
            return Response.status(404).build();

        return Response
                .ok()
                .entity(teds)
                .build();    }

    @GET
    @Path("/teds.xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response getXmlChannelTeds(@PathParam("channel") int channelNumber) {
        ChannelTeds teds = tedsService.getChannelTeds(channelNumber);

        if(teds == null)
            return Response.status(404).build();

        return Response
                .ok()
                .entity(teds)
                .build();
    }
}

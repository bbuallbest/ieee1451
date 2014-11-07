package com.bbuallbest.stim.rest.resources;

import com.bbuallbest.stim.entity.Measurement;
import com.bbuallbest.stim.entity.teds.CalibrationTeds;
import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.service.converter.ByteConverter;
import com.bbuallbest.stim.service.measurement.MeasurementService;
import com.bbuallbest.stim.service.teds.TedsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

@Path("/channel/{channel}")
public class ChannelResource {

    @Inject
    private TedsService tedsService;

    @Inject
    private MeasurementService measurementService;

    @Inject
    private ByteConverter byteConverter;

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
    @Path("/measurement.stream")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRawMeasurement(@PathParam("channel") int channelNumber) {
        final Measurement measurement = measurementService.measure(channelNumber);
        StreamingOutput stream;

        if(measurement == null)
            return Response.status(404).build();

        stream = new StreamingOutput() {
            @Override
            public void write(OutputStream out) throws IOException {
                out.write(byteConverter.convertMeasurement(measurement));
            }
        };
        return Response
                .ok(stream)
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
                .build();
    }

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

    @GET
    @Path("/teds.stream")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRawChannelTeds(@PathParam("channel") int channelNumber) {
        final ChannelTeds teds = tedsService.getChannelTeds(channelNumber);
        StreamingOutput stream;

        if(teds == null)
            return Response.status(404).build();

        stream = new StreamingOutput() {
            @Override
            public void write(OutputStream out) throws IOException {
                out.write(byteConverter.convertChannelTeds(teds));
            }
        };

        return Response
                .ok(stream)
                .build();
    }


    @GET
    @Path("/calibration/teds.json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonCalibrationTeds(@PathParam("channel") int channelNumber) {
        CalibrationTeds teds = tedsService.getCalibrationTeds(channelNumber);

        if(teds == null)
            return Response.status(404).build();

        return Response
                .ok()
                .entity(teds)
                .build();
    }

    @GET
    @Path("/calibration/teds.xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response getXmlCalibrationTeds(@PathParam("channel") int channelNumber) {
        CalibrationTeds teds = tedsService.getCalibrationTeds(channelNumber);

        if(teds == null)
            return Response.status(404).build();

        return Response
                .ok()
                .entity(teds)
                .build();
    }

    @GET
    @Path("/calibration/teds.stream")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRawCalibrationTeds(@PathParam("channel") int channelNumber) {
        final CalibrationTeds teds = tedsService.getCalibrationTeds(channelNumber);
        StreamingOutput stream;

        stream = new StreamingOutput() {
            @Override
            public void write(OutputStream out) throws IOException {
                out.write(byteConverter.convertCalibrationTeds(teds));
            }
        };

        return Response
                .ok(stream)
                .build();
    }
}

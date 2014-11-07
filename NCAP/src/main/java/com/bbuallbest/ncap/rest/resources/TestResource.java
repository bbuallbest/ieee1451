package com.bbuallbest.ncap.rest.resources;

import com.bbuallbest.ncap.service.url.DATA_FORMAT;
import com.bbuallbest.ncap.service.url.PropertyUrlBuilder;
import com.bbuallbest.ncap.service.url.UrlBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by happy on 03/11/2014.
 */

@Path("/test")
public class TestResource {

    @GET
    @Path("/urlbuilder")
    public Response testUrlBuilder() {
        UrlBuilder builder = new PropertyUrlBuilder();

        System.out.println("Calibration TEDS");
        System.out.println(builder.buildCalibrationTedsUrl(1, DATA_FORMAT.JSON));
        System.out.println(builder.buildCalibrationTedsUrl(1, DATA_FORMAT.XML));
        System.out.println(builder.buildCalibrationTedsUrl(1, DATA_FORMAT.RAW));

        System.out.println("Meta TEDS");
        System.out.println(builder.buildMetaTedsUrl(DATA_FORMAT.JSON));
        System.out.println(builder.buildMetaTedsUrl(DATA_FORMAT.XML));
        System.out.println(builder.buildMetaTedsUrl(DATA_FORMAT.RAW));

        System.out.println("Measurement");
        System.out.println(builder.buildMeasurementUrl(0, DATA_FORMAT.JSON));
        System.out.println(builder.buildMeasurementUrl(0, DATA_FORMAT.XML));
        System.out.println(builder.buildMeasurementUrl(0, DATA_FORMAT.RAW));

        System.out.println("Channel TEDS");
        System.out.println(builder.buildChannelTedsUrl(0, DATA_FORMAT.JSON));
        System.out.println(builder.buildChannelTedsUrl(0, DATA_FORMAT.XML));
        System.out.println(builder.buildChannelTedsUrl(0, DATA_FORMAT.RAW));

        return Response.ok("<html><body>Success!</body></html>").build();
    }
}

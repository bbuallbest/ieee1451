package com.bbuallbest.stim.service.converter;

import com.bbuallbest.stim.entity.Measurement;
import com.bbuallbest.stim.entity.teds.CalibrationTeds;
import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.entity.teds.MetaTeds;
import com.bbuallbest.stim.entity.teds.util.*;
import com.bbuallbest.stim.service.encoder.ByteEncodable;
import com.bbuallbest.stim.service.encoder.ByteEncoder;
import com.bbuallbest.stim.service.encoder.util.ArrayUtil;

import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by happy on 30/10/2014.
 */
public class StimByteConverter implements ByteConverter{

    private static final int META_INFO_SIZE = 4;
    private static final int IN_HEAD = 0;
    private static final int INT_BYTES_AMOUNT = 4;

    @Override
    public byte[] convertMetaTeds(MetaTeds metaTeds) {
        List<byte[]> listOfByteArray = new LinkedList<byte[]>();
        int length = 0;

        // reserve place for length header
        listOfByteArray.add(new byte[4]);
        listOfByteArray.add(intToByteArray(metaTeds.getId()));
        listOfByteArray.add(new ByteEncoder<DataStructure>().encode(metaTeds.getDataStructure()));
        listOfByteArray.add(new ByteEncoder<Timing>().encode(metaTeds.getTiming()));
        listOfByteArray.add(new ByteEncoder<Identification>().encode(metaTeds.getIdentification()));
        length = calculateLength(listOfByteArray);

        System.out.println("length=" + length);

        System.out.println("before add head:");
        byte[] arr1 = ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
        System.out.println(DatatypeConverter.printHexBinary(arr1));

        listOfByteArray.add(IN_HEAD, intToByteArray(length));
        listOfByteArray.add(intToByteArray(calculateCheckSum(length)));

        System.out.println("element amount - " + listOfByteArray.size());
        System.out.println("after");
        System.out.println("-------start hex--------");

        byte[] arr = ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);

        System.out.println(DatatypeConverter.printHexBinary(arr));
        System.out.println("-------stop  hex--------");

        return ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
    }

    @Override
    public byte[] convertChannelTeds(ChannelTeds channelTeds) {
        List<byte[]> listOfByteArray = new LinkedList<byte[]>();
        int length = 0;

        listOfByteArray.add(new byte[0]);
        listOfByteArray.add(new ByteEncoder<DataStructure>().encode(channelTeds.getDataStructure()));
        listOfByteArray.add(new ByteEncoder<Transducer>().encode(channelTeds.getTransducer()));
        listOfByteArray.add(new ByteEncoder<DataConverter>().encode(channelTeds.getDataConverter()));
        listOfByteArray.add(new ByteEncoder<Identification>().encode(channelTeds.getIdentification()));
        length = calculateLength(listOfByteArray);

        listOfByteArray.add(IN_HEAD, intToByteArray(length));
        listOfByteArray.add(intToByteArray(calculateCheckSum(length)));

        byte[] arr = ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);

        return ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
    }

    @Override
    public byte[] convertCalibrationTeds(CalibrationTeds calibrationTeds) {
        List<byte[]> listOfByteArray = new LinkedList<byte[]>();
        int length = 0;

        listOfByteArray.add(new byte[0]);
        listOfByteArray.add(intToByteArray(calibrationTeds.getTemplateId()));
        listOfByteArray.add(intToByteArray(calibrationTeds.getDomainParameter()));
        listOfByteArray.add(intToByteArray(calibrationTeds.getDataSet().size()));
        for (Data data : calibrationTeds.getDataSet()) {
            listOfByteArray.add(new ByteEncoder<Data>().encode(data));
        }
        length = calculateLength(listOfByteArray);

        listOfByteArray.add(IN_HEAD, intToByteArray(length));
        listOfByteArray.add(intToByteArray(calculateCheckSum(length)));

        byte[] arr = ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);

        return ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
    }

    @Override
    public byte[] convertMeasurement(Measurement measurement) {
        List<byte[]> listOfByteArray = new LinkedList<byte[]>();
        int length = 0;

        listOfByteArray.add(new byte[0]);
        listOfByteArray.add(new ByteEncoder<Measurement>().encode(measurement));
        length = calculateLength(listOfByteArray);

        listOfByteArray.add(IN_HEAD, intToByteArray(length));
        listOfByteArray.add(intToByteArray(calculateCheckSum(length)));

        byte[] arr = ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);

        return ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
    }

    private byte[] intToByteArray(int integer) {
        return ByteBuffer.allocate(INT_BYTES_AMOUNT).putInt(integer).array();
    }

    private int calculateLength(List<byte[]> list) {
        int counter = 0;
        for (byte[] bytes : list)
            counter+= bytes.length;
        return counter + META_INFO_SIZE;
    }

    private int calculateCheckSum(int length) {
        return Integer.MAX_VALUE - length;
    }

}

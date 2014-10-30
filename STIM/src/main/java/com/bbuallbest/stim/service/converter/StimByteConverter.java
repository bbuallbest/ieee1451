package com.bbuallbest.stim.service.converter;

import com.bbuallbest.stim.entity.Measurement;
import com.bbuallbest.stim.entity.teds.ChannelTeds;
import com.bbuallbest.stim.entity.teds.MetaTeds;
import com.bbuallbest.stim.entity.teds.util.DataStructure;
import com.bbuallbest.stim.entity.teds.util.Identification;
import com.bbuallbest.stim.entity.teds.util.Timing;
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

    private static final int META_INFO_SIZE = 8;
    private static final int IN_HEAD = 0;
    private static final int INT_BYTES_AMOUNT = 4;

    @Override
    public byte[] convertMetaTeds(MetaTeds metaTeds) {
        List<byte[]> listOfByteArray = new LinkedList<byte[]>();
        int length = 0;
        System.out.println("MetaTeds = " + metaTeds);
        listOfByteArray.add(intToByteArray(metaTeds.getId()));
        listOfByteArray.add(new ByteEncoder<Identification>().encode(metaTeds.getIdentification()));
        listOfByteArray.add(new ByteEncoder<DataStructure>().encode(metaTeds.getDataStructure()));
        listOfByteArray.add(new ByteEncoder<Timing>().encode(metaTeds.getTiming()));
        length = calculateLength(listOfByteArray);
        System.out.println("length=" + length);
        listOfByteArray.add(IN_HEAD, intToByteArray(length));
        listOfByteArray.add(intToByteArray(calculateCheckSum(length)));

        System.out.println("-------start hex--------");
        byte[] arr = ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
        System.out.println(DatatypeConverter.printHexBinary(arr));
        System.out.println("-------stop  hex--------");

        return ArrayUtil.convertListOfByteArraysToByteArray(listOfByteArray);
    }

    @Override
    public byte[] convertChannelTeds(ChannelTeds channelTeds) {
        return new byte[0];
    }

    @Override
    public byte[] convertMeasurement(Measurement measurement) {
        return new byte[0];
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

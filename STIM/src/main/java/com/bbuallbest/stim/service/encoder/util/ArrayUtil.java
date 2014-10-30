package com.bbuallbest.stim.service.encoder.util;

import java.util.List;

/**
 * Created by happy on 30/10/2014.
 */
public class ArrayUtil {

    public static byte[] convertListOfByteArraysToByteArray(List<byte[]> list) {
        byte[] array = null;
        int size = 0;
        int counter = 0;

        for (byte[] bytes : list)
            size+= bytes.length;

        array = new byte[size];

        for (byte[] bytes : list) {
            copyArray(bytes, array, counter);
            counter+= bytes.length;
        }

        return array;
    }

    public static void copyArray(byte[] from, byte[] to, int toArrayStartPosition) {
        if (from.length > to.length)
            throw new IllegalArgumentException("Destination array size is less than source array size.");
        for (byte concrateByte : from) {
            to[toArrayStartPosition++] = concrateByte;
        }
    }

}

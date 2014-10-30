package com.bbuallbest.stim.service.encoder;

import com.bbuallbest.stim.service.encoder.util.ArrayUtil;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by happy on 29/10/2014.
 */
public class ByteEncoder<K extends EncodableMarker> implements ByteEncodable<K> {

    private static final int STRING_LENGTH_HEADER_BYTES_AMOUNT = 2;
    private static final int START_POSITION = 0;
    private static final int STRING_BODY_START_POSITION = 2;
    private static final int SHORT_SIZE_IN_BYTES = 2;
    private static final int INT_SIZE_IN_BYTES = 4;
    private static final int DOUBLE_SIZE_IN_BYTES = 8;
    private static final int LONG_SIZE_IN_BYTES = 8;

    private Class<K> type;

    @Override
    public byte[] encode(K type) {
        List<byte[]> byteArrayList = new LinkedList<byte[]>();

        Field[] classFields = type.getClass().getDeclaredFields();
        for (Field field : classFields) {
            try {
                field.setAccessible(true);
                byteArrayList.add(standartTypeToCharacters(field, type));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ArrayUtil.convertListOfByteArraysToByteArray(byteArrayList);
    }

    private byte[] standartTypeToCharacters(Field field, K instance) throws IllegalAccessException {
        if(field.getType() == String.class) {
            return stringToByteArrayWithHeader(field, instance);
        } if (field.getType() == int.class) {
            ByteBuffer integerInBytes = ByteBuffer.allocate(INT_SIZE_IN_BYTES);
            integerInBytes.putInt(field.getInt(instance));
            return integerInBytes.array();
        } if (field.getType() == long.class) {
            ByteBuffer longInBytes = ByteBuffer.allocate(LONG_SIZE_IN_BYTES);
            longInBytes.putLong(field.getLong(instance));
            return longInBytes.array();
        } if (field.getType() == double.class) {
            ByteBuffer doubleInBytes = ByteBuffer.allocate(DOUBLE_SIZE_IN_BYTES);
            doubleInBytes.putDouble(field.getDouble(instance));
            return doubleInBytes.array();
        }
        throw new ClassCastException("Unknown field type.");
    }

//    private byte[] convertListOfByteArraysToByteArray(List<byte[]> list) {
//        byte[] array = null;
//        int size = 0;
//        int counter = 0;
//
//        for (byte[] bytes : list)
//            size+= bytes.length;
//
//        array = new byte[size];
//
//        for (byte[] bytes : list) {
//            copyArray(bytes, array, counter);
//            counter+= bytes.length;
//        }
//
//        return array;
//    }
//
//    private void copyArray(byte[] from, byte[] to, int toArrayStartPosition) {
//        if (to.length > from.length)
//            throw new IllegalArgumentException("Destination array size is less than source array size.");
//        for (byte concrateByte : from) {
//            to[toArrayStartPosition++] = concrateByte;
//        }
//    }

    private byte[] stringToByteArrayWithHeader(Field field, K instance) throws IllegalAccessException {
        short stringLength = 0;
        byte[] stringLengthAsArray;
        byte[] fromStringBytes = ((String) field.get(instance)).getBytes();
        byte[] resultBytes = new byte[STRING_LENGTH_HEADER_BYTES_AMOUNT + fromStringBytes.length];

        stringLength = (short) fromStringBytes.length;
        stringLengthAsArray = ByteBuffer.allocate(SHORT_SIZE_IN_BYTES).putShort(stringLength).array();
        ArrayUtil.copyArray(stringLengthAsArray, resultBytes, START_POSITION);
        ArrayUtil.copyArray(fromStringBytes, resultBytes, STRING_BODY_START_POSITION);

        return resultBytes;
    }
}

package com.bbuallbest.stim.service.encoder;

/**
 * Created by happy on 29/10/2014.
 */
public interface ByteEncodable<From> {
    byte[] encode(From type);
}

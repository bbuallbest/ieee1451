package com.bbuallbest.stim.entity.teds.util;

import com.bbuallbest.stim.service.encoder.ByteEncodable;
import com.bbuallbest.stim.service.encoder.EncodableMarker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class DataConverter implements EncodableMarker{

    @XmlElement(name = "channel-reade-time")
    private double channelReadTime;

    @XmlElement(name = "channel-write-time")
    private double channelWriteTime;

    @XmlElement(name = "channel-sampling-time")
    private double channelSamplingTime;

    public double getChannelReadTime() {
        return channelReadTime;
    }

    public void setChannelReadTime(double channelReadTime) {
        this.channelReadTime = channelReadTime;
    }

    public double getChannelWriteTime() {
        return channelWriteTime;
    }

    public void setChannelWriteTime(double channelWriteTime) {
        this.channelWriteTime = channelWriteTime;
    }

    public double getChannelSamplingTime() {
        return channelSamplingTime;
    }

    public void setChannelSamplingTime(double channelSamplingTime) {
        this.channelSamplingTime = channelSamplingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataConverter that = (DataConverter) o;

        if (Double.compare(that.channelReadTime, channelReadTime) != 0) return false;
        if (Double.compare(that.channelSamplingTime, channelSamplingTime) != 0) return false;
        if (Double.compare(that.channelWriteTime, channelWriteTime) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(channelReadTime);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(channelWriteTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(channelSamplingTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DataConverter{" +
                "channelReadTime=" + channelReadTime +
                ", channelWriteTime=" + channelWriteTime +
                ", channelSamplingTime=" + channelSamplingTime +
                '}';
    }
}

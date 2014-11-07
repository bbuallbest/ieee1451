package com.bbuallbest.stim.entity;

import com.bbuallbest.stim.service.encoder.EncodableMarker;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "measurement")
public class Measurement implements EncodableMarker{

    @XmlElement
    private int channel;

    @XmlElement
    private double value;

    @XmlElement
    private long timestamp;

    public Measurement() {}

    public Measurement(int channel, double value, long timestamp) {
        this.channel = channel;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        if (channel != that.channel) return false;
        if (timestamp != that.timestamp) return false;
        if (Double.compare(that.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = channel;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "channel=" + channel +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}

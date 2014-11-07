package com.bbuallbest.ncap.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "measurement")
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        if (channel != that.channel) return false;
        if (id != that.id) return false;
        if (timestamp != that.timestamp) return false;
        if (Double.compare(that.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + channel;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", channel=" + channel +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}

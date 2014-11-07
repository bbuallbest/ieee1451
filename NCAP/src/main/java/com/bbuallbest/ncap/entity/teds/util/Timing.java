package com.bbuallbest.ncap.entity.teds.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Timing {

    @XmlElement
    private double worstUpdateTime;

    @XmlElement
    private double worstReadeTime;

    @XmlElement
    private double worstWriteTime;

    @XmlElement
    private double worstSamplingTime;

    @XmlElement
    private double ioResponseTime;

    public double getWorstUpdateTime() {
        return worstUpdateTime;
    }

    public void setWorstUpdateTime(double worstUpdateTime) {
        this.worstUpdateTime = worstUpdateTime;
    }

    public double getWorstReadeTime() {
        return worstReadeTime;
    }

    public void setWorstReadeTime(double worstReadeTime) {
        this.worstReadeTime = worstReadeTime;
    }

    public double getWorstWriteTime() {
        return worstWriteTime;
    }

    public void setWorstWriteTime(double worstWriteTime) {
        this.worstWriteTime = worstWriteTime;
    }

    public double getWorstSamplingTime() {
        return worstSamplingTime;
    }

    public void setWorstSamplingTime(double worstSamplingTime) {
        this.worstSamplingTime = worstSamplingTime;
    }

    public double getIoResponseTime() {
        return ioResponseTime;
    }

    public void setIoResponseTime(double ioResponseTime) {
        this.ioResponseTime = ioResponseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timing that = (Timing) o;

        if (Double.compare(that.ioResponseTime, ioResponseTime) != 0) return false;
        if (Double.compare(that.worstReadeTime, worstReadeTime) != 0) return false;
        if (Double.compare(that.worstSamplingTime, worstSamplingTime) != 0) return false;
        if (Double.compare(that.worstUpdateTime, worstUpdateTime) != 0) return false;
        if (Double.compare(that.worstWriteTime, worstWriteTime) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(worstUpdateTime);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(worstReadeTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(worstWriteTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(worstSamplingTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ioResponseTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Timing{" +
                "worstUpdateTime=" + worstUpdateTime +
                ", worstReadeTime=" + worstReadeTime +
                ", worstWriteTime=" + worstWriteTime +
                ", worstSamplingTime=" + worstSamplingTime +
                ", ioResponseTime=" + ioResponseTime +
                '}';
    }
}

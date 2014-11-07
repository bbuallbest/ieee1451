package com.bbuallbest.ncap.entity.teds.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class DataStructure {

    @XmlElement
    private int calibrationKey;

    @XmlElement
    private int standartFamily;

    @XmlElement
    private int majorVersion;

    @XmlElement
    private int implementedChannels;

    public int getCalibrationKey() {
        return calibrationKey;
    }

    public void setCalibrationKey(int calibrationKey) {
        this.calibrationKey = calibrationKey;
    }

    public int getStandartFamily() {
        return standartFamily;
    }

    public void setStandartFamily(int standartFamily) {
        this.standartFamily = standartFamily;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getImplementedChannels() {
        return implementedChannels;
    }

    public void setImplementedChannels(int implementedChannels) {
        this.implementedChannels = implementedChannels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataStructure that = (DataStructure) o;

        if (calibrationKey != that.calibrationKey) return false;
        if (implementedChannels != that.implementedChannels) return false;
        if (majorVersion != that.majorVersion) return false;
        if (standartFamily != that.standartFamily) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = calibrationKey;
        result = 31 * result + standartFamily;
        result = 31 * result + majorVersion;
        result = 31 * result + implementedChannels;
        return result;
    }

    @Override
    public String toString() {
        return "DataStructure{" +
                "calibrationKey=" + calibrationKey +
                ", standartFamily=" + standartFamily +
                ", majorVersion=" + majorVersion +
                ", implementedChannels=" + implementedChannels +
                '}';
    }
}

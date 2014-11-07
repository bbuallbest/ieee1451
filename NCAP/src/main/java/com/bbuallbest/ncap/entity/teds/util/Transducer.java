package com.bbuallbest.ncap.entity.teds.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Transducer {

    @XmlElement
    private int lowerRangeLimit;

    @XmlElement
    private int upperRangeLimit;

    @XmlElement
    private String physicalUnits;

    @XmlElement
    private int type;

    public int getLowerRangeLimit() {
        return lowerRangeLimit;
    }

    public void setLowerRangeLimit(int lowerRangeLimit) {
        this.lowerRangeLimit = lowerRangeLimit;
    }

    public int getUpperRangeLimit() {
        return upperRangeLimit;
    }

    public void setUpperRangeLimit(int upperRangeLimit) {
        this.upperRangeLimit = upperRangeLimit;
    }

    public String getPhysicalUnits() {
        return physicalUnits;
    }

    public void setPhysicalUnits(String physicalUnits) {
        this.physicalUnits = physicalUnits;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transducer that = (Transducer) o;

        if (lowerRangeLimit != that.lowerRangeLimit) return false;
        if (type != that.type) return false;
        if (upperRangeLimit != that.upperRangeLimit) return false;
        if (!physicalUnits.equals(that.physicalUnits)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lowerRangeLimit;
        result = 31 * result + upperRangeLimit;
        result = 31 * result + physicalUnits.hashCode();
        result = 31 * result + type;
        return result;
    }

    @Override
    public String toString() {
        return "Transducer{" +
                "lowerRangeLimit=" + lowerRangeLimit +
                ", upperRangeLimit=" + upperRangeLimit +
                ", physicalUnits='" + physicalUnits + '\'' +
                ", type=" + type +
                '}';
    }
}

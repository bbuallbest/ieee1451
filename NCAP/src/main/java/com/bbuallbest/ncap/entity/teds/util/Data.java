package com.bbuallbest.ncap.entity.teds.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by happy on 31/10/2014.
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Data {

    @XmlElement
    private double domainValue;

    @XmlElement
    private double rangeValue;

    public Data() {}

    public double getDomainValue() {
        return domainValue;
    }

    public void setDomainValue(double domainValue) {
        this.domainValue = domainValue;
    }

    public double getRangeValue() {
        return rangeValue;
    }

    public void setRangeValue(double rangeValue) {
        this.rangeValue = rangeValue;
    }
}

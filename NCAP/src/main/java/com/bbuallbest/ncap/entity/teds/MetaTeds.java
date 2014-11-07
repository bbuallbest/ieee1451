package com.bbuallbest.ncap.entity.teds;

import com.bbuallbest.ncap.entity.teds.util.DataStructure;
import com.bbuallbest.ncap.entity.teds.util.Identification;
import com.bbuallbest.ncap.entity.teds.util.Timing;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "metaTeds")
@XmlSeeAlso({Identification.class,
             DataStructure.class,
             Timing.class})
public class MetaTeds {

    @XmlAttribute
    private int id;

    @XmlElement
    private Identification identification;

    @XmlElement
    private Timing timing;

    @XmlElement
    private DataStructure dataStructure;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DataStructure getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(DataStructure dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {
        return "MetaTeds{" +
                "id=" + id +
                ", dataStructure=" + dataStructure +
                ", timing=" + timing +
                ", identification=" + identification +
                '}';
    }
}

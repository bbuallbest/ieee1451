package com.bbuallbest.ncap.entity.teds;

import com.bbuallbest.ncap.entity.teds.util.DataConverter;
import com.bbuallbest.ncap.entity.teds.util.DataStructure;
import com.bbuallbest.ncap.entity.teds.util.Identification;
import com.bbuallbest.ncap.entity.teds.util.Transducer;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "channelTeds")
@XmlSeeAlso({Identification.class,
             DataConverter.class,
             DataStructure.class,
             Transducer.class})
public class ChannelTeds {

    @XmlElement
    private DataStructure dataStructure;

    @XmlElement
    private Transducer transducer;

    @XmlElement
    private DataConverter dataConverter;

    @XmlElement
    private Identification identification;

    public DataStructure getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(DataStructure dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Transducer getTransducer() {
        return transducer;
    }

    public void setTransducer(Transducer transducer) {
        this.transducer = transducer;
    }

    public DataConverter getDataConverter() {
        return dataConverter;
    }

    public void setDataConverter(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelTeds that = (ChannelTeds) o;

        if (!dataConverter.equals(that.dataConverter)) return false;
        if (!dataStructure.equals(that.dataStructure)) return false;
        if (!identification.equals(that.identification)) return false;
        if (!transducer.equals(that.transducer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataStructure.hashCode();
        result = 31 * result + transducer.hashCode();
        result = 31 * result + dataConverter.hashCode();
        result = 31 * result + identification.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ChannelTeds{" +
                "dataStructure=" + dataStructure +
                ", transducer=" + transducer +
                ", dataConverter=" + dataConverter +
                ", identification=" + identification +
                '}';
    }
}

package com.bbuallbest.stim.entity.teds;

import com.bbuallbest.stim.entity.teds.util.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "calibrationTeds")
@XmlSeeAlso({Data.class})
public class CalibrationTeds {

    @XmlElement
    private int templateId;

    @XmlElement
    private int domainParameter;

    @XmlElementWrapper(name = "dataSet")
    @XmlElement(name = "data")
    private List<Data> dataSet;

    public CalibrationTeds() {}

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getDomainParameter() {
        return domainParameter;
    }

    public void setDomainParameter(int domainParameter) {
        this.domainParameter = domainParameter;
    }

    public List<Data> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<Data> dataSet) {
        this.dataSet = dataSet;
    }
}

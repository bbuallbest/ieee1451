package com.bbuallbest.stim.entity.teds.util;

import com.bbuallbest.stim.service.encoder.EncodableMarker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Identification implements EncodableMarker{

    @XmlElement
    private String uuid;

    @XmlElement
    private String manufacturer;

    @XmlElement
    private String model;

    @XmlElement
    private int revision;

    @XmlElement(name = "serial-number")
    private String serialNumber;

    @XmlElement
    private String description;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identification that = (Identification) o;

        if (revision != that.revision) return false;
        if (!description.equals(that.description)) return false;
        if (!manufacturer.equals(that.manufacturer)) return false;
        if (!model.equals(that.model)) return false;
        if (!serialNumber.equals(that.serialNumber)) return false;
        if (!uuid.equals(that.uuid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + revision;
        result = 31 * result + serialNumber.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Identification{" +
                "uuid='" + uuid + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", revision=" + revision +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

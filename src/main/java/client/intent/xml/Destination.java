package client.intent.xml;


import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;


@Setter
public class Destination {
    @XmlAttribute(name = "ICCType")
    public String ICCType;
    @XmlAttribute(name = "name")
    public String name;
    @XmlAttribute(name = "method")
    public String method;
    @XmlAttribute(name = "unit")
    public String unit;
    @XmlAttribute(name = "action")
    public String action;
    @XmlAttribute(name = "extras")
    public String extras;
    @XmlAttribute(name = "flags")
    public String flags;
    @XmlAttribute(name = "category")
    public String category;
    @XmlAttribute(name = "data")
    public String data;
    @XmlAttribute(name = "type")
    public String type;


    @XmlTransient
    public String getICCType() {
        return ICCType;
    }


    @XmlTransient
    public String getName() {
        return name;
    }


    @XmlTransient
    public String getMethod() {
        return method;
    }


    @XmlTransient
    public String getUnit() {
        return unit;
    }


    @XmlTransient
    public String getAction() {
        return action;
    }


    @XmlTransient
    public String getExtras() {
        return extras;
    }


    @XmlTransient
    public String getFlags() {
        return flags;
    }

    @XmlTransient
    public String getCategory() {
        return category;
    }

    @XmlTransient
    public String getData() {
        return data;
    }

    @XmlTransient
    public String getType() {
        return type;
    }
}

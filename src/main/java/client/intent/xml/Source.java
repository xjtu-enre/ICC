package client.intent.xml;

import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;


@Setter
public class Source {

    @XmlAttribute(name = "name")
    public String name;
    @XmlAttribute(name = "type")
    public String type;
    @XmlElement(name="destination")
    public List<Destination> destination;



    @XmlTransient
    public String getName() {
        return name;
    }


    @XmlTransient
    public String getType() {
        return type;
    }


    @XmlTransient
    public List<Destination> getDestination() {
        return destination;
    }
}
package client.intent.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Data
@XmlRootElement(name = "root")
public class XMLRoot {

    @XmlElement(name="source")
    public List<Source> source;


    @XmlTransient
    public List<Source> getSource() {
        return source;
    }

    public void setSource(List<Source> source) {
        this.source = source;
    }
}
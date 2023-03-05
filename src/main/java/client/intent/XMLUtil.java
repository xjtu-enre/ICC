package client.intent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
public class XMLUtil {

    public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshal = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshal.unmarshal(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    public static Object convertXmlFileToObject(Class<?> clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStreamReader isr=new InputStreamReader(new FileInputStream(xmlPath),"UTF-8");
            xmlObject = unmarshaller.unmarshal(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

}

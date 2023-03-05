package client.intent;

import client.intent.xml.XMLRoot;
import client.intent.xml.Source;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadXML {

    private String iccXml;

    public ReadXML(String iccXml) {
        this.iccXml = iccXml;
    }

    public XMLRoot xmlToObject(){
        String path = this.iccXml;
        XMLRoot root = (XMLRoot) XMLUtil.convertXmlFileToObject(XMLRoot.class, path);
        List<Source> source = root.getSource();
        for(int i = 0 ; i < source.size();i++){
            if(source.get(i).destination != null) {
                for (int j = 0; j < source.get(i).destination.size(); j++) {
                    String method = source.get(i).destination.get(j).method;
                    method = method.replace(" ", "");
                    method = method.replace("<", "");
                    method = method.replace(">", "");
                    method = method.replace(":", ".");
                    method = method.replace("void", "");
                    while (method.contains("(")) {
                        method = method.replaceAll("\\([^()]*\\)", "");
                    }
                    source.get(i).destination.get(j).method = method;
                    //System.out.println(source.get(i).destination.get(j).method);
                    if (source.get(i).destination.get(j).unit != null) {

                        String unit = source.get(i).destination.get(j).unit;
                        String skh = "(?<=\\<)[^\\>]+";
                        Pattern pattern = Pattern.compile(skh);
                        Matcher matcher = pattern.matcher(unit);
                        boolean is = matcher.find();
                        if (is) {
                            source.get(i).destination.get(j).unit = matcher.group();
                            String unit_str[] = source.get(i).destination.get(j).unit.split(" ");
                            source.get(i).destination.get(j).unit = unit_str[2];
                            source.get(i).destination.get(j).unit = source.get(i).destination.get(j).unit.replaceAll("\\([^()]*\\)", "");
                            //System.out.println(matcher.group());
                        }
                    }
                }
            }
        }
        // System.out.println(source.get(0).getName());
        return root;
    }

}

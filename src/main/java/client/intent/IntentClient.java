package client.intent;

import client.intent.xml.Source;
import client.intent.xml.XMLRoot;
import com.iscas.iccbot.MyConfig;
import com.iscas.iccbot.analyze.utils.TimeUtilsofProject;
import com.iscas.iccbot.client.BaseClient;
import com.iscas.iccbot.client.statistic.model.StatisticResult;
import entity.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import util.ArgParser;
import util.SingleCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.iscas.iccbot.Main.*;

@Slf4j
public class IntentClient {
    private String iccXml;

    private  SingleCollection sc = null;

    public IntentClient(String iccXml, SingleCollection sc) {
        this.iccXml = iccXml;
        this.sc = sc;
    }

    public String getIccXml() {
        return iccXml;
    }

    public void setIccXml(String iccXml) {
        this.iccXml = iccXml;
    }

    public  StatisticResult  intentParser() {
        StatisticResult result = startAnalyze();
        ReadXML readXML = new ReadXML(this.iccXml);
        XMLRoot xmlRoot = readXML.xmlToObject();
        setComponent(this.sc, xmlRoot);
        List<RootXY> rootXYList  = setICCMethod(this.sc, xmlRoot);
        setICCVariable(this.sc, xmlRoot,rootXYList);
        setIccDependency(this.sc,xmlRoot,rootXYList);
        deleteIrregularIccDependency(this.sc);
        return result;
        //System.out.println("agf");
    }


    private void deleteIrregularIccDependency(SingleCollection sc) {

        for (int i = 0 , len =  sc.getEnreDTO().getCells().size() ; i < len ; i++){
            if (sc.getEnreDTO().getCells().get(i).getDest() == -1){
                sc.getEnreDTO().getCells().remove(i);
                len--;
                i--;
            }
        }
    }

    public void setIccDependency(SingleCollection sc, XMLRoot xmlRoot , List<RootXY> rootXYList) {
        List<Source> source = xmlRoot.getSource();
        List<EntityDTO> variables = sc.getEnreDTO().getVariables();
        for (int root_i = 0; root_i < source.size(); root_i++) {
            if (source.get(root_i).destination != null) {
                for (int root_j = 0; root_j < source.get(root_i).destination.size(); root_j++) {
                    String srcName = source.get(root_i).getName();
                    String destName = source.get(root_i).destination.get(root_j).getName();
                    Integer src_id = null, dest_id = null;
                    LocationDTO location =null;

                    for (Map.Entry<Integer,String> entry: sc.getIdToQualifiedNameMap().entrySet()){
                        if (entry.getValue().equals(srcName)){
                            src_id = entry.getKey();
                        }
                        if (entry.getValue().equals(destName)){
                            dest_id = entry.getKey();
                        }
                    }


                    for (int j = 0 ; j < rootXYList.size() ; j++) {
                        if (rootXYList.get(j).getRootX() == root_i && rootXYList.get(j).getRootY() == root_j) {
                            //location = ((MethodEntityDTO) variables.get(var_i)).getLocation();
                            location = rootXYList.get(j).getLocation();
                        }

                    }


                    /*
                    for (int var_i = 0; var_i < variables.size(); var_i++) {
                        if (variables.get(var_i).getQualifiedName().equals(srcName)) {
                            src_id = variables.get(var_i).getId();
                        }
                        if (variables.get(var_i).getQualifiedName().equals(destName)) {
                            dest_id = variables.get(var_i).getId();
                        }
                        for (int j = 0 ; j < rootXYList.size() ; j++) {
                            if (rootXYList.get(j).getRootX() == root_i && rootXYList.get(j).getRootY() == root_j) {
                                if (variables.get(var_i) instanceof MethodEntityDTO)
                                {
                                    location = ((MethodEntityDTO) variables.get(var_i)).getLocation();
                                }

                            }

                        }
                    }

                    */
                    if (src_id != null) {
                        CellDTO cellDTO = new CellDTO();
                        cellDTO.setSrc(src_id);
                        if (dest_id != null)
                            cellDTO.setDest(dest_id);
                        else
                            cellDTO.setDest(-1);
                        ValuesDTO values = new ValuesDTO();
                        values.setIccMechanism("Intent Mechanism");
                        values.setIccCategory(source.get(root_i).destination.get(root_j).getICCType());
                        values.getRelations().put("ICC", 1);
                        if (location!=null)
                            values.setLoc(location);
                        else
                            values.setLoc(new LocationDTO(0,0,0,0));
                        cellDTO.setValues(values);
                        sc.getEnreDTO().getCells().add(cellDTO);
                    }
                }
            }
        }
    }

    public void setICCVariable(SingleCollection sc, XMLRoot xmlRoot,List<RootXY> rootXYList) {
        List<Source> source = xmlRoot.getSource();
        //List<VariableEntityDTO> variableList = new ArrayList<>();
        List<EntityDTO> variables = sc.getEnreDTO().getVariables();

        for (int i = 0; i < rootXYList.size(); i++) {
            for (int j = 0; j < variables.size(); j++) {
                EntityDTO dto = variables.get(j);
                if (dto instanceof InternalEntityDTO && dto instanceof VariableEntityDTO) {
                    InternalEntityDTO interDTO = (InternalEntityDTO) dto;
                    VariableEntityDTO varDTO = (VariableEntityDTO) dto;
                    if (rootXYList.get(i).getMethodID() == interDTO.getParentId() && varDTO.getRawType().equals("Intent")) {
                        ICCVariableAttributeDTO iccVariableAttributeDTO = new ICCVariableAttributeDTO();
                        iccVariableAttributeDTO.setAction(source.get(rootXYList.get(i).getRootX()).destination.get(rootXYList.get(i).getRootY()).getAction());
                        iccVariableAttributeDTO.setCategory(source.get(rootXYList.get(i).getRootX()).destination.get(rootXYList.get(i).getRootY()).getCategory());
                        iccVariableAttributeDTO.setData(source.get(rootXYList.get(i).getRootX()).destination.get(rootXYList.get(i).getRootY()).getData());
                        iccVariableAttributeDTO.setType(source.get(rootXYList.get(i).getRootX()).destination.get(rootXYList.get(i).getRootY()).getType());
                        iccVariableAttributeDTO.setExtras(source.get(rootXYList.get(i).getRootX()).destination.get(rootXYList.get(i).getRootY()).getExtras());
                        iccVariableAttributeDTO.setFlags(source.get(rootXYList.get(i).getRootX()).destination.get(rootXYList.get(i).getRootY()).getFlags());
                        varDTO.setIccVariableAttribute(iccVariableAttributeDTO);
                    }
                }
            }
        }
    }


    public void setComponent(SingleCollection sc , XMLRoot xmlRoot){
        List<Source> source = xmlRoot.getSource();
        List<EntityDTO> variables = sc.getEnreDTO().getVariables();
        //List<ClassEntityDTO> componentList = new ArrayList<ClassEntityDTO>();
        for (int root_i = 0; root_i < source.size(); root_i++) {
            for (int var_i = 0; var_i < variables.size(); var_i++) {
                EntityDTO dto = variables.get(var_i);
                if (source.get(root_i).getName().equals(dto.getQualifiedName()) && dto instanceof ClassEntityDTO && !source.get(root_i).getType().equals("NotComponentSource")) {
                    EntityDTO dtoClass = sc.getEnreDTO().getVariables().get(var_i);
                    ClassEntityDTO classDTO = (ClassEntityDTO) dtoClass;
                    ComponentDTO componentDTO = new ComponentDTO();
                    componentDTO.setComponentCategory(source.get(root_i).getType());
                    classDTO.setComponent(componentDTO);
                    sc.getIdToQualifiedNameMap().put(classDTO.getId(),classDTO.getQualifiedName());
                    //break;
                }
            }
        }
        for (int var_i = 0; var_i < variables.size(); var_i++) {
            for (int root_i = 0; root_i < source.size(); root_i++) {
                if (source.get(root_i).destination != null) {
                    for (int root_j = 0; root_j < source.get(root_i).destination.size(); root_j++) {
                        EntityDTO dto = variables.get(var_i);
                        if (source.get(root_i).destination.get(root_j).getName().equals(dto.getQualifiedName()) && dto instanceof ClassEntityDTO){
                            EntityDTO dtoClass = sc.getEnreDTO().getVariables().get(var_i);
                            ClassEntityDTO classDTO = (ClassEntityDTO) dtoClass;
                            if(classDTO.getCategory().equals("Class")  && !source.get(root_i).getType().equals("NotComponentSource"))
                            {
                                ComponentDTO componentDTO = new ComponentDTO();
                                componentDTO.setComponentCategory(source.get(root_i).getType());
                                classDTO.setComponent(componentDTO);
                                sc.getIdToQualifiedNameMap().put(classDTO.getId(),classDTO.getQualifiedName());
                                break;
                            }
                        }

                    }
                }
            }
        }
    }

    private List <RootXY> setICCMethod(SingleCollection sc, XMLRoot xmlRoot) {
        List<Source> source = xmlRoot.getSource();
        List<RootXY> rootXYList = new ArrayList<>();
        List<MethodEntityDTO> methodList = new ArrayList<>();
        List<EntityDTO> variables = sc.getEnreDTO().getVariables();
        for (int root_i = 0; root_i < source.size(); root_i++) {
            if (source.get(root_i).destination != null) {
                for (int root_j = 0; root_j < source.get(root_i).destination.size(); root_j++) {
                    for (int var_i = 0; var_i < variables.size(); var_i++) {
                        EntityDTO dto = variables.get(var_i);
                        //System.out.println(source.get(root_i).destination.get(root_j).method);
                        if (source.get(root_i).destination.get(root_j).method.equals(dto.getQualifiedName()) && dto instanceof MethodEntityDTO) {
                            MethodEntityDTO methodDTO = (MethodEntityDTO) dto;
                            ICCMethodAttributeDTO iccMethodAttribute = new ICCMethodAttributeDTO();
                            iccMethodAttribute.setSend(true);
                            iccMethodAttribute.setMechanismType("Intent");
                            methodDTO.setIccMethodAttribute(iccMethodAttribute);
                            methodList.add(methodDTO);
                            RootXY rootXY = new RootXY();
                            rootXY.setMethodID(methodDTO.getId());
                            rootXY.setRootX(root_i);
                            rootXY.setRootY(root_j);
                            LocationDTO locationDTO = methodDTO.getLocation();
                            rootXY.setLocation(locationDTO);
                            rootXYList.add(rootXY);
                        }
                    }
                }
            }
        }
        return rootXYList;
    }





    public  void argParser(ArgParser.Args args) {
        //String iccArgs = "java -jar ICCBot.jar  -path apk/ -name " + args.getApkPath() + " -outputDir " + args.getOutputDir() + " -androidJar lib/platforms -time 30 -maxPathNumber 100 -client CTGClient";
        // Analyze args
        // change FlowDroid max analysis time to 360 min (6 hours)
        int timeLimit = 360;
        String[] iccArgs = new String[]{
                "-path",
                args.getPath(),
                "-name",
                args.getName(),
                "-outputDir",
                args.getOutputDir(),
                "-time",
                String.valueOf(timeLimit),
        };
        CommandLine mCmd = getCommandLine(iccArgs);
        if (mCmd == null) {
            return;
        }
        analyzeArgs(mCmd);

        //main(iccArgs);
    }

    public static StatisticResult  startAnalyze() {
        log.info("Analyzing " + MyConfig.getInstance().getAppName());
        BaseClient client = getClient();

        TimeUtilsofProject.setTotalTimer(client);
        long startTime = System.currentTimeMillis();

        client.start();
        StatisticResult result = client.getResult();
        long endTime = System.currentTimeMillis();
        //log.info("---------------------------------------");
        //log.info("Analyzing " + MyConfig.getInstance().getAppName() + " Finish...\n");
        log.info(MyConfig.getInstance().getClient() + " time = " + (endTime - startTime) / 1000 + " seconds");
        return result;
    }

}

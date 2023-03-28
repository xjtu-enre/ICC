package client;

import TempOutput.CreateFileUtil;
import client.intent.IntentClient;
import com.iscas.iccbot.client.statistic.model.StatisticResult;
import entity.dto.CellDTO;
import entity.dto.EnreDTO;
import entity.dto.ValuesDTO;
import org.json.JSONObject;
import org.json.JSONTokener;
import util.ArgParser;
import util.EnreFormatParser;
import util.SingleCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

public class ICCMain {
    private static final SingleCollection sc = SingleCollection.getInstance();

    public static void main(String[] args) throws Exception {
        ArgParser.Args arguments = ArgParser.parseArgs(args);
        callEnre(arguments);
        EnreDTO enre = readJson(arguments.getEnreJson());
        sc.setEnreDTO(enre);
        IntentClient intentClient = new IntentClient(getXmlFile(arguments.getOutputDir() + File.separator + arguments.getName().substring(0, arguments.getName().length() - 4)),sc);
        intentClient.argParser(arguments);
        StatisticResult result = intentClient.intentParser();

        //MessengerClient messengerClient = new MessengerClient(sc,result);
        //messengerClient.messengerParser();
        enhanceEnre();
        // writeBack(arguments, enre);
        write(arguments, enre);
        exit(0);
    }

    public static EnreDTO readJson(String filepath) {
        EnreDTO res;
        JSONObject enreObj;
        try (Reader in = new FileReader(filepath)) {
            JSONTokener tok = new JSONTokener(in);
            enreObj = new JSONObject(tok);
            res = EnreFormatParser.parse(enreObj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static String getXmlFile(String xmlPath){
        xmlPath += File.separator + "CTGResult" + File.separator + "CTG.xml";
        return xmlPath;
    }

    private static void enhanceEnre() {
        EnreDTO enre = sc.getEnreDTO();
        Map<String, Integer> relationNum = enre.getRelationNum();
        for (CellDTO cell : enre.getCells()) {
            ValuesDTO values = cell.getValues();
            Map<String, Integer> relationMap = values.getRelations();
            for (Map.Entry<String, Integer> entry : relationMap.entrySet()) {
                if (entry.getKey().equals("ICC")) {
                    Integer val = relationNum.getOrDefault("ICC", 0);
                    relationNum.put("ICC", val + 1);
                }
            }
        }
    }

    private static void callEnre(ArgParser.Args args) {
        if (!args.isCallEnre()) {
            return;
        }
        TemplateWork work = new TemplateWork();
        String[] enreArgs = new String[]{
                "java",
                args.getProjectPath(),
                args.getProjectName(),
        };
        work.workflow(enreArgs);
    }

    private static void write(ArgParser.Args args, EnreDTO enre) {
        File out = new File(args.getOutputJson());
        String filepath = out.getParent();
        String filename = out.getName().substring(0, out.getName().length() - 5);
        CreateFileUtil.createJsonFile(filepath, filename, enre);
    }

    private static void writeBack(ArgParser.Args args, EnreDTO enre) {
        String outputJsonFile = args.getOutputJson();
        List<JSONObject> cellArray = new ArrayList<>();
        JSONObject curCell = new JSONObject();
        String key;
        Integer value;
        JSONObject curValues;
        JSONObject loction;
        for (CellDTO cell : enre.getCells()) {
            curCell = new JSONObject();
            curCell.put("src", cell.getSrc());
            curCell.put("dest", cell.getDest());
            curValues = new JSONObject();
            loction = new JSONObject();
            //if(cell.getValues().getLoc().getStartLine())
            loction.put("startLine",cell.getValues().getLoc().getStartLine());
            loction.put("endLine",cell.getValues().getLoc().getEndLine());
            loction.put("startColumn",cell.getValues().getLoc().getStartColumn());
            loction.put("endColumn",cell.getValues().getLoc().getEndColumn());
            ValuesDTO valuesDTO = cell.getValues();
            curValues.put("loc", loction);
            curValues.put("iccMechanism",valuesDTO.getIccMechanism());
            curValues.put("iccCategory",valuesDTO.getIccCategory());
            for (Map.Entry<String, Integer> entry : valuesDTO.getRelations().entrySet()) {
                key = entry.getKey();
                value = (Integer) entry.getValue();
                curValues.put(key, value);
            }

            curCell.put("values", curValues);
            cellArray.add(curCell);
        }
        try (FileWriter out = new FileWriter(outputJsonFile)) {
            JSONObject res = new JSONObject();
            res.put("schemaVersion", enre.getSchemaVersion());
            res.put("variables", enre.getVariables());
            res.put("cells", cellArray);
            res.put("entityNum", enre.getEntityNum());
            res.put("relationNum", enre.getRelationNum());
            res.put("categories", enre.getCategories());
            out.write(res.toString(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

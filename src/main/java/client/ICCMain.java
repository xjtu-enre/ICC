package client;

import client.intent.IntentClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.iscas.iccbot.client.statistic.model.StatisticResult;
import entity.adapter.*;
import entity.dto.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import util.ArgParser;
import util.EnreFormatParser;
import util.SingleCollection;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

public class ICCMain {
    private static final SingleCollection sc = SingleCollection.getInstance();

    public static void main(String[] args) throws Exception {
        ArgParser.Args arguments = ArgParser.parseArgs(args);
        EnreDTO enre = readJson(arguments.getEnreJson());
        sc.setEnreDTO(enre);
        //setScMap(sc);
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

    private static void write(ArgParser.Args args, EnreDTO enre) {
        try (JsonWriter out = new JsonWriter(new BufferedWriter(new FileWriter(args.getOutputJson())))) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(EnreDTO.class, new EnreDTOAdapter(
                    new CellDTOAdapter(),
                    new MapAdapter(),
                    new CategoryDTOAdapter(),
                    new EntityDTOAdapter()
            ));
            Gson gson = builder.create();
            out.setIndent("  ");
            gson.toJson(enre, EnreDTO.class, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setScMap(SingleCollection sc) {
        List<EntityDTO> variables = sc.getEnreDTO().getVariables();
        for (int var_i = 0; var_i < variables.size(); var_i++) {
            EntityDTO dto = variables.get(var_i);
            if (dto instanceof ClassEntityDTO){
                sc.getIdToQualifiedNameMap().put(dto.getId(),dto.getQualifiedName());
            }
        }
    }
}
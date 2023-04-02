package client.messenger;

import com.iscas.iccbot.client.obj.model.ctg.IntentSummaryModel;
import com.iscas.iccbot.client.statistic.model.StatisticResult;
import entity.dto.*;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JVirtualInvokeExpr;
import util.SingleCollection;

import java.util.*;

public class MessengerClient {
    private SingleCollection sc = null;
    StatisticResult result = null;

    public SingleCollection getSc() {
        return sc;
    }

    public void setSc(SingleCollection sc) {
        this.sc = sc;
    }

    public MessengerClient(SingleCollection sc, StatisticResult result) {
        this.sc = sc;
        this.result = result;
    }

    public void messengerParser(){
        List<ClassEntityDTO> messengerClassDTO = findMemberVar();
        intentBasedParsing(messengerClassDTO);
        System.out.println("xs");
        //staticVarBasedParsing();
    }

    private void intentBasedParsing(List<ClassEntityDTO> messengerClassDTO) {
        //Map<String, Set<IntentSummaryModel>> intentSummarySendTypeMap =
        Set<IntentSummaryModel> toICC =result.getAllICCStatistic().getIntentSummarySendTypeMap().get("toICC");
        Map<String, String> messengerMap = new HashMap<String, String>();
        for (IntentSummaryModel intentSummaryModel : toICC){
            for (int i = 0 ; i < intentSummaryModel.getSendIntent2ICCList().size() ; i++){
                JInvokeStmt stmt = (JInvokeStmt) intentSummaryModel.getSendIntent2ICCList().get(i);
                JVirtualInvokeExpr expr = (JVirtualInvokeExpr) stmt.getInvokeExprBox().getValue();
                System.out.println(expr.getMethodRef().getDeclaringClass().getName()); // 源组件名称

                System.out.println(expr.getMethodRef().getName());
                List<String> setDestinationList = intentSummaryModel.getSetDestinationList();
                System.out.println(setDestinationList.get(0)); //目标组件名称

                messengerMap.put(new String(expr.getMethodRef().getDeclaringClass().getName()),setDestinationList.get(0));
            }
        }


        Iterator<String> iterator = messengerMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            CellDTO cellDTO = new CellDTO();
            ValuesDTO valuesDTO = new ValuesDTO();
            valuesDTO.setIccMechanism("Messenger Mechanism");
            valuesDTO.setIccCategory("Intent Based");
            //valuesDTO.getRelationMap().put("ICC", 1);
            for (int i = 0 ; i < sc.getEnreDTO().getVariables().size(); i++){
                for (int j = 0 ; j < messengerClassDTO.size() ; j++) {
                    if (sc.getEnreDTO().getVariables().get(i) instanceof ClassEntityDTO && sc.getEnreDTO().getVariables().get(i).getQualifiedName().equals(key)
                    && sc.getEnreDTO().getVariables().get(i).getId() == messengerClassDTO.get(j).getId()) {
                        //System.out.println(key + "　：" + messengerMap.get(key));
                        cellDTO.setSrc(sc.getEnreDTO().getVariables().get(i).getId());
                    }
                    if (sc.getEnreDTO().getVariables().get(i) instanceof ClassEntityDTO && sc.getEnreDTO().getVariables().get(i).getQualifiedName().equals(messengerMap.get(key))
                    &&  sc.getEnreDTO().getVariables().get(i).getId() == messengerClassDTO.get(j).getId()) {
                        cellDTO.setDest(sc.getEnreDTO().getVariables().get(i).getId());
                    }
                }

            }
            cellDTO.setValues(valuesDTO);
            valuesDTO.setLoc(new LocationDTO(0,0,0,0));
            sc.getEnreDTO().getCells().add(cellDTO);
        }


    }
    //private void staticVarBasedParsing() {}



    public List<ClassEntityDTO> findMemberVar(){
        List<EntityDTO> variables = sc.getEnreDTO().getVariables();
        List<ClassEntityDTO> messengerClass = new ArrayList<>();
        for (int i = 0 ; i < variables.size() ; i++){
            if (variables.get(i) instanceof VariableEntityDTO){
                VariableEntityDTO varDTO = (VariableEntityDTO) variables.get(i);
                if (varDTO.getCategory().equals("Variable") && varDTO.getRawType().endsWith(".Messenger")){
                    for (int j = 0 ; j < variables.size() ; j++){
                        if (variables.get(j).getId() == varDTO.getParentId() && variables.get(j) instanceof ClassEntityDTO){
                                ClassEntityDTO classDTO = (ClassEntityDTO) variables.get(j);
                                messengerClass.add(classDTO);//得到定义成员变量所在的类
                                System.out.println(classDTO.getQualifiedName());
                            }
                        }
                    }
                }
            }
        return messengerClass;
        }



    }


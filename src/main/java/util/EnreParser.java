package util;

import entity.dto.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class EnreParser {

    private static Object get(JSONObject obj, String key) {
        if (obj.has(key)) {
            return obj.get(key);
        }
        return null;
    }

    private static ParameterDTO buildParameterDTO(JSONObject varObj) {
        if (!varObj.has("parameter")) {
            return null;
        }
        JSONObject parObj = (JSONObject) varObj.get("parameter");
        return new ParameterDTO(
                (String) parObj.get("types"),
                (String) parObj.get("names")
        );
    }

    private static EnhancementDTO buildEnhancementDTO(JSONObject varObj) {
        if (!varObj.has("enhancement")) {
            return null;
        }
        JSONObject enObj = (JSONObject) varObj.get("enhancement");
        return new EnhancementDTO(
                (Boolean) enObj.get("isGetter"),
                (Boolean) enObj.get("isRecursive"),
                (Boolean) enObj.get("isStatic"),
                (Boolean) enObj.get("isConstructor"),
                (Boolean) enObj.get("isOverride"),
                (Boolean) enObj.get("isSetter"),
                (Boolean) enObj.get("isPublic"),
                (Boolean) enObj.get("isDelegator"),
                (Boolean) enObj.get("isSynchronized"),
                (Boolean) enObj.get("isAbstract")
        );
    }

    private static LocationDTO buildLocationDTO(JSONObject obj, String key) {
        if (!obj.has(key)) {
            return null;
        }
        JSONObject locObj = (JSONObject) obj.get(key);
        if (!locObj.has("startLine")) {
            return null;
        }
        return new LocationDTO(
                (Integer) locObj.get("startLine"),
                (Integer) locObj.get("endLine"),
                (Integer) locObj.get("startColumn"),
                (Integer) locObj.get("endColumn")
        );
    }

    private static ValuesDTO buildValuesDTO(JSONObject obj) {
        if (!obj.has("values")) {
            return null;
        }
        JSONObject valuesObj = (JSONObject) obj.get("values");
        LocationDTO locDTO = buildLocationDTO(valuesObj, "loc");
        ValuesDTO valuesDTO = new ValuesDTO(locDTO);
        String key = "loc";
        Integer value;
        Iterator<String> it = valuesObj.keys();
        while (it.hasNext() && key.equals("loc")) {
            key = it.next();
        }
        value = (Integer) valuesObj.get(key);
        valuesDTO.getRelationMap().put(key, value);
        return valuesDTO;
    }

    private static List<Integer> buildInnerType(JSONObject varObj) {
        if (!varObj.has("innerType")) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for (Object innerTypeObj: (JSONArray) varObj.get("innerType")) {
            Integer innerType = (Integer) innerTypeObj;
            res.add(innerType);
        }
        return res;
    }

    private static AdditionalBinDTO buildAdditionalBinDTO(JSONObject obj) {
        if (!obj.has("additionalBin")) {
            return null;
        }
        JSONObject additionalBinObj = (JSONObject) obj.get("additionalBin");
        if (additionalBinObj.has("binNum") && additionalBinObj.has("binPath")) {
            return new AdditionalBinDTO(
                    (Integer) additionalBinObj.get("binNum"),
                    (String) additionalBinObj.get("binPath")
            );
        }
        return null;
    }

    private static EntityDTO buildEntityDTO(JSONObject varObj) {
        EntityDTO res;
        Integer id = (Integer) varObj.get("id");
        String name = (String) varObj.get("name");
        String qualifiedName = (String) varObj.get("qualifiedName");
        Boolean external = (Boolean) varObj.get("external");
        if (external) {
            res = new ExternalEntityDTO(id, name, qualifiedName);
        } else {
            String category = (String) varObj.get("category");
            Integer parentId = (Integer) varObj.get("parentId");
            String file = (String) get(varObj, "File");
            String rawType = (String) get(varObj, "rawType");
            Integer anonymousBindVar = (Integer) get(varObj, "anonymousBindVar");
            Integer anonymousRank = (Integer) get(varObj, "anonymousRank");
            String modifiers = (String) get(varObj, "modifiers");
            Boolean global = (Boolean) get(varObj, "global");
            AdditionalBinDTO additionalBin = buildAdditionalBinDTO(varObj);
            LocationDTO location = buildLocationDTO(varObj, "location");
            List<Integer> innerType = buildInnerType(varObj);
            EnhancementDTO enhancement = buildEnhancementDTO(varObj);
            ParameterDTO parameter = buildParameterDTO(varObj);
            switch (category) {
                case "Package":
                    res = new PackageEntityDTO(id, name, qualifiedName, parentId);
                    break;
                case "File":
                    res = new FileEntityDTO(id, name, qualifiedName, parentId, file, additionalBin);
                    break;
                case "Class":
                    if (anonymousRank == null || anonymousBindVar == null) {
                        res = new ClassEntityDTO(id, name, qualifiedName, parentId, rawType, location,
                                modifiers, file, additionalBin, innerType);
                    } else {
                        res = new ClassEntityDTO(id, name, qualifiedName, parentId, rawType, location,
                                modifiers, anonymousRank, anonymousBindVar, file, additionalBin);
                    }
                    break;
                case "Enum":
                    res = new EnumEntityDTO(id, name, qualifiedName, parentId,
                            additionalBin, location, modifiers, rawType, file);
                    break;
                case "Enum Constant":
                    res = new EnumConstantEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin);
                    break;
                case "Annotation":
                    res = new AnnotationEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin, location, modifiers, rawType);
                    break;
                case "Annotation Member":
                    res = new AnnotationMemberEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin, location, rawType);
                    break;
                case "Interface":
                    res = new InterfaceEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin, location, modifiers, rawType);
                    break;
                case "Method":
                    res = new MethodEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin, enhancement, location, modifiers, parameter, rawType);
                    break;
                // TODO finish other entity types
                case "Module":
                    res = null;
                    break;
                case "Record":
                    res = null;
                    break;
                case "Type Parameter":
                    res = new TypeParameterEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin, location, rawType);
                    break;
                case "Variable":
                    res = new VariableEntityDTO(id, name, qualifiedName, parentId,
                            file, additionalBin, global, location, modifiers, rawType);
                    break;
                default:
                    throw new NoSuchElementException("No such entity: " + category);
            }
        }
        return res;
    }

    private static <T> void buildMapDTO(JSONObject obj, Map<String, T> map) {
        Iterator<String> it = obj.keys();
        while (it.hasNext()) {
            String key = it.next();
            T value = (T) obj.get(key);
            map.put(key, value);
        }
    }

    private static void buildCategoryDTO(JSONArray obj, List<CategoryDTO> list) {
        for (Object category : obj) {
            JSONObject categoryObj = (JSONObject) category;
            CategoryDTO categoryDTO = new CategoryDTO((String) categoryObj.get("name"));
            list.add(categoryDTO);
        }
    }

    public static EnreDTO parse(JSONObject obj) {
        EnreDTO enre = new EnreDTO((String) obj.get("schemaVersion"));
        for (Object cell: (JSONArray) obj.get("cells")) {
            JSONObject cellObj = (JSONObject) cell;
            Integer src = (Integer) cellObj.get("src");
            Integer dest = (Integer) cellObj.get("dest");
            ValuesDTO valuesDTO = buildValuesDTO(cellObj);
            CellDTO cellDTO = new CellDTO(src, dest, valuesDTO);
            enre.getCells().add(cellDTO);
        }
        for (Object variable : (JSONArray) obj.get("variables")) {
            EntityDTO entityDTO = buildEntityDTO((JSONObject) variable);
            enre.getVariables().add(entityDTO);
        }
        buildMapDTO((JSONObject) obj.get("entityNum"), enre.getEntityNum());
        buildMapDTO((JSONObject) obj.get("relationNum"), enre.getRelationNum());
        buildCategoryDTO((JSONArray) obj.get("categories"), enre.getCategories());
        return enre;
    }
}

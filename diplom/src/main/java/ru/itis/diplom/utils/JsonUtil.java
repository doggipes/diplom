package ru.itis.diplom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import ru.itis.diplom.model.dto.TemplateDTO;

import java.io.IOException;

@UtilityClass
public class JsonUtil {

    public String objectToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(o);
            System.out.println(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

    public Object jsonToObject(String json, String className) {
        ObjectMapper mapper = new ObjectMapper();
        Object o = new Object();
        try {
            o = mapper.readValue(json, Class.forName(className));
        } catch (JsonProcessingException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

}

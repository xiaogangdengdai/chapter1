package org.smart4j.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public JsonUtil() {
    }

    public static <T> String toJson(T obj) {
        try {
            String json = OBJECT_MAPPER.writeValueAsString(obj);
            return json;
        } catch (Exception var3) {
            LOGGER.error("convert POJO to JSON failure", var3);
            throw new RuntimeException(var3);
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        try {
            T pojo = OBJECT_MAPPER.readValue(json, type);
            return pojo;
        } catch (Exception var4) {
            LOGGER.error("convert JSON to POJO failure", var4);
            throw new RuntimeException(var4);
        }
    }
}

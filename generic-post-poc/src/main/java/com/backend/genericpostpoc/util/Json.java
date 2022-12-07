package com.backend.genericpostpoc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json {

    private static ObjectMapper objectMapper = getObjectMapper();

    private static ObjectMapper getObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultObjectMapper.registerModule(new JavaTimeModule());
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clas) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clas);
    }

    public static JsonNode toJsonNode(Object obj) {
        return objectMapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateString(node, false);
    }

    public static String preetyStringify(JsonNode node) throws JsonProcessingException {
        return generateString(node, true);
    }

    private static String generateString(JsonNode node, boolean preety) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        if (preety)
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        return objectWriter.writeValueAsString(node);

    }
}

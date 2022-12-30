package com.gsk.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;

public class UserDeSerializer implements Serializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Object data) {
        try {
            String type = data.getClass()
                    .getName();
            byte[] typeBytes = type.getBytes();
            byte[] dataBytes = objectMapper.writeValueAsBytes(data);
            ByteBuffer buffer = ByteBuffer.allocate(500 + typeBytes.length + dataBytes.length);
            buffer.putInt(typeBytes.length);
            buffer.put(typeBytes);
            buffer.put(dataBytes);
            return buffer.array();
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error serializing object", e);
        }
    }
}

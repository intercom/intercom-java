package io.intercom.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ValueNode;

import java.io.IOException;

class CustomAttributeDeserializer extends StdDeserializer<CustomAttribute> {

    private static final long serialVersionUID = 5069924730975394938L;

    public CustomAttributeDeserializer() {
        super(CustomAttribute.class);
    }

    @Override
    public CustomAttribute deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        CustomAttribute cda = null;
        final String currentName = jp.getParsingContext().getCurrentName();
        final ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        final ValueNode vNode = mapper.readTree(jp);
        if (vNode.asToken().isScalarValue()) {
            if (vNode.getNodeType() == JsonNodeType.BOOLEAN) {
                cda = new CustomAttribute<Boolean>(currentName, vNode.asBoolean(), Boolean.class);
            } else if (vNode.getNodeType() == JsonNodeType.STRING) {
                cda = new CustomAttribute<String>(currentName, vNode.asText(), String.class);
            } else if (vNode.getNodeType() == JsonNodeType.NUMBER) {
                final NumericNode nNode = (NumericNode) vNode;
                if (currentName.endsWith("_at")) {
                    cda = new CustomAttribute<Long>(currentName, vNode.longValue(), Long.class);
                } else if (nNode.isInt()) {
                    cda = new CustomAttribute<Integer>(currentName, vNode.intValue(), Integer.class);
                } else if (nNode.isFloat()) {
                    cda = new CustomAttribute<Float>(currentName, vNode.floatValue(), Float.class);
                } else if (nNode.isDouble()) {
                    cda = new CustomAttribute<Double>(currentName, vNode.doubleValue(), Double.class);
                } else if (nNode.isLong()) {
                    cda = new CustomAttribute<Long>(currentName, vNode.longValue(), Long.class);
                } else {
                    cda = new CustomAttribute<String>(currentName, vNode.asText(), String.class);
                }
            } else {
                cda = new CustomAttribute<String>(currentName, vNode.asText(), String.class);
            }
        }
        return cda;
    }
}

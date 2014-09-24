package io.intercom.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ValueNode;

import java.io.IOException;

class TopicDeserializer extends StdDeserializer<Subscription.Topic> {

    private static final long serialVersionUID = 7679767772794559452L;

    public TopicDeserializer() {
        super(CustomAttribute.class);
    }

    @Override
    public Subscription.Topic deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        final ValueNode vNode = mapper.readTree(jp);
        return Subscription.Topic.valueOf(vNode.asText());
    }
}

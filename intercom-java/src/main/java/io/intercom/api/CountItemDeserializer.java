package io.intercom.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Map;

class CountItemDeserializer extends StdDeserializer<Counts.CountItem> {

    private static final long serialVersionUID = 8226175715446656115L;

    public CountItemDeserializer() {
        super(Counts.CountItem.class);
    }

    @Override
    public Counts.CountItem deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final TreeNode treeNode = jp.getCodec().readTree(jp);
        final Map.Entry<String, JsonNode> next = ((ObjectNode) treeNode).fields().next();
        return new Counts.CountItem(next.getKey(), next.getValue().asLong());
    }
}

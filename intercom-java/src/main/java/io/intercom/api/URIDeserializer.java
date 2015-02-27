package io.intercom.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ValueNode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

class URIDeserializer extends StdDeserializer<URI> {


    public URIDeserializer() {
        super(URI.class);
    }

    @Override
    public URI deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        final ValueNode vNode = mapper.readTree(jp);
        try {
            final URL url = new URL(vNode.asText());
            return new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), url.getRef());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

package io.intercom.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

class TopicSerializer extends StdSerializer<Subscription.Topic> {

    public TopicSerializer() {
        super(Subscription.Topic.class);
    }

    @Override
    public void serialize(Subscription.Topic value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
        jgen.writeObject(value.toString());
    }
}

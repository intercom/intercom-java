package io.intercom.api;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.intercom.api.Counts;

import java.io.IOException;

class CountItemSerializer extends StdSerializer<Counts.CountItem> {

    public CountItemSerializer() {
        super(Counts.CountItem.class);
    }

    @Override
    public void serialize(Counts.CountItem value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonGenerationException {
        jgen.writeStartObject();
        jgen.writeNumberField(value.getName(), value.getValue());
        jgen.writeEndObject();
    }
}

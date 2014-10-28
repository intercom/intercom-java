package io.intercom.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

class CustomAttributeSerializer extends StdSerializer<CustomAttribute> {

    public CustomAttributeSerializer() {
        super(CustomAttribute.class);
    }

    @Override
    public void serialize(CustomAttribute value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
        // the field name has already been written
        jgen.writeObject(value.getValue());
    }
}

package io.intercom.api;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MapperSupport {

    public static ObjectMapper objectMapper() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final ObjectMapper INSTANCE = new Holder().configure(new ObjectMapper());

        private ObjectMapper configure(ObjectMapper om) {
            return om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
                    .configure(SerializationFeature.INDENT_OUTPUT, true)
                    .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                    .configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                    .registerModule(customAttributeModule());
        }

        private SimpleModule customAttributeModule() {
            final SimpleModule customAttributeModule = new SimpleModule(
                    "IntercomClientModule",
                    new Version(1, 0, 0, null, "", "")
            );
            customAttributeModule.addDeserializer(CustomAttribute.class, new CustomAttributeDeserializer());
            customAttributeModule.addSerializer(CustomAttribute.class, new CustomAttributeSerializer());
            customAttributeModule.addDeserializer(Subscription.Topic.class, new TopicDeserializer());
            customAttributeModule.addSerializer(Subscription.Topic.class, new TopicSerializer());
            customAttributeModule.addSerializer(Counts.CountItem.class, new CountItemSerializer());
            customAttributeModule.addDeserializer(Counts.CountItem.class, new CountItemDeserializer());
            return customAttributeModule;
        }
    }
}

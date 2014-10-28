package io.intercom.api;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("UnusedDeclaration")
public class CustomAttribute<T> {

    @SuppressWarnings("unchecked")
    private static final ArrayList<? extends Class<? extends Serializable>> CLASSES = Lists.newArrayList(String.class, Long.class, Float.class, Double.class, Boolean.class, Integer.class);

    public static StringAttribute newStringAttribute(String name, String value) {
        return new StringAttribute(name, value);
    }

    public static BooleanAttribute newBooleanAttribute(String name, boolean value) {
        return new BooleanAttribute(name, value);
    }

    public static DoubleAttribute newDoubleAttribute(String name, double value) {
        return new DoubleAttribute(name, value);
    }

    public static LongAttribute newLongAttribute(String name, long value) {
        return new LongAttribute(name, value);
    }

    public static IntegerAttribute newIntegerAttribute(String name, int value) {
        return new IntegerAttribute(name, value);
    }

    public static FloatAttribute newFloatAttribute(String name, float value) {
        return new FloatAttribute(name, value);
    }

    public static class StringAttribute extends CustomAttribute<String> {

        private StringAttribute(String name, String value) {
            super(name, value, String.class);
        }

        private StringAttribute(String name, String value, Class<String> clazz) {
            super(name, value, clazz);
        }
    }

    public static class BooleanAttribute extends CustomAttribute<Boolean> {

        private BooleanAttribute(String name, boolean value) {
            super(name, value, Boolean.class);
        }

        private BooleanAttribute(String name, boolean value, Class<Boolean> clazz) {
            super(name, value, clazz);
        }
    }

    public static class DoubleAttribute extends CustomAttribute<Double> {

        private DoubleAttribute(String name, double value, Class<Double> clazz) {
            super(name, value, clazz);
        }

        private DoubleAttribute(String name, double value) {
            super(name, value, Double.class);
        }
    }

    public static class FloatAttribute extends CustomAttribute<Float> {

        private FloatAttribute(String name, float value, Class<Float> clazz) {
            super(name, value, clazz);
        }

        private FloatAttribute(String name, float value) {
            super(name, value, Float.class);
        }
    }

    public static class IntegerAttribute extends CustomAttribute<Integer> {

        private IntegerAttribute(String name, int value) {
            super(name, value, Integer.class);
        }

        private IntegerAttribute(String name, int value, Class<Integer> clazz) {
            super(name, value, clazz);
        }
    }

    public static class LongAttribute extends CustomAttribute<Long> {

        public LongAttribute(String name, long value, Class<Long> clazz) {
            super(name, value, clazz);
        }

        public LongAttribute(String name, long value) {
            super(name, value, Long.class);
        }

    }

    private String name;

    private T value;

    private Class<T> clazz;

    public CustomAttribute(String name, T value, Class<T> clazz) {
        //noinspection SuspiciousMethodCalls
        if (!CLASSES.contains(clazz)) {
            throw new InvalidException(String.format("cannot accept class type [%s] for custom attribute", clazz.getName()));
        }
        this.name = name;
        this.value = value;
        this.clazz = clazz;

    }

    public Class<T> getValueClass() {
        return clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public <C> C as(Class<C> c) {
        //noinspection unchecked
        return (C) getValue();
    }

    public long longValue() {
        return as(Long.class);
    }

    public String textValue() {
        return as(String.class);
    }

    public boolean booleanValue() {
        return as(Boolean.class);
    }

    public float floatValue() {
        return as(Float.class);
    }

    public double doubleValue() {
        return as(Double.class);
    }

    public int integerValue() {
        return as(Integer.class);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomAttribute that = (CustomAttribute) o;

        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        //noinspection RedundantIfStatement
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "CustomAttribute{" +
            "name='" + name + '\'' +
            ", value=" + value +
            ", clazz=" + clazz +
            '}';
    }
}

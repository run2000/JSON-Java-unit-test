package org.json.junit;

import java.io.StringReader;
import java.math.BigDecimal;

/**
 * Implement MyBean
 */
public class MySuperBean implements MyBean {

    @Override
    public Integer getIntKey() {
        return 42;
    }

    @Override
    public Double getDoubleKey() {
        return -23.45e7d;
    }

    @Override
    public String getStringKey() {
        return "hello world!";
    }

    @Override
    public String getEscapeStringKey() {
        return "h\be\tllo w\u1234orld!";
    }

    @Override
    public Boolean isTrueKey() {
        return true;
    }

    @Override
    public Boolean isFalseKey() {
        return false;
    }

    @Override
    public StringReader getStringReaderKey() {
        return new StringReader("") {};
    }

    public Number getNumber() {
        System.out.println("Super called");
        return new BigDecimal("123.456");
    }
}

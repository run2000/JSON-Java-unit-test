package org.json.stream;

import org.json.JSONObject;
import org.json.stream.JSONStreamReader.ParseState;
import org.json.stream.JSONStreamReader.ValueType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Test cases for JSONStreamReader.
 *
 * @version 2016-6-29
 */
public final class ParserTest {

    private static final String OBJECT_1 = "{}";
    private static final String OBJECT_2 = "{ \"key\": 1.0 }";
    private static final String OBJECT_3 = "{ \"key\": 1.0, \"key2\": true }";
    private static final String OBJECT_4 = "{ \"key\": { }, \"key2\": [ 1, true ]}";
    private static final String OBJECT_5 = "{ \"key\": { \"a\": 1, \"b\": \"2\" }, \"key2\": { \"1\": true }}";

    private static final String ARRAY_1 = "[]";
    private static final String ARRAY_2 = "[ \"test\" ]";
    private static final String ARRAY_3 = "[ \"test\", 4, null, false ]";
    private static final String ARRAY_4 = "[ [ { \"key\": 4 }, false ]]";

    private static final String STRING_1 = "\"\"";
    private static final String STRING_2 = "\"This is a test.\\r\\n\"";
    private static final String STRING_3 = "\"This is a unicode \\u0032.\"";
    private static final String STRING_4 = "\"This was\\b\\b\\bis\\ta \\\"quoted\\\" string\\f\"";
    private static final String SHORT = "This was\\b\\b\\bis\\ta \\\"quoted\\\" string.\\f";
    private static final String STRING_5 = '"' +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT + SHORT +
            '"';

    private static final String NUMBER_1 = "0.0";
    private static final String NUMBER_2 = "42";
    private static final String NUMBER_3 = "-5";
    private static final String NUMBER_4 = "3.14159";
    private static final String NUMBER_5 = "2e+10";

    private static final String TRUE_1 = "true";
    private static final String FALSE_1 = "false";
    private static final String NULL_1 = "null";


    @Test
    public void testSimpleObject() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObject1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(1.0d), parser.nextValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObject2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(1.0d), parser.nextValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Boolean.TRUE, parser.nextValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObject3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(1), parser.nextValue());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Boolean.TRUE, parser.nextValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObjectSkip() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.skipToEndObject());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.skipToEndObject());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleArray() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArray1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("test", parser.nextValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArray2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(ValueType.STRING_VALUE, parser.getValueType());
        Assert.assertEquals("test", parser.nextValue());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(ValueType.NUMBER_VALUE, parser.getValueType());
        Assert.assertEquals(Integer.valueOf(4), parser.nextValue());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(ValueType.NULL_VALUE, parser.getValueType());
        Assert.assertEquals(JSONObject.NULL, parser.nextValue());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(ValueType.BOOLEAN_VALUE, parser.getValueType());
        Assert.assertEquals(Boolean.FALSE, parser.nextValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArray3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_ARRAY, parser.skipToEndObject());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleStringTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("This is a test.\r\n", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString2Typed() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("This is a test.\r\n", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("This is a unicode \u0032.", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString3Typed() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("This is a unicode \u0032.", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("This was\b\b\bis\ta \"quoted\" string\f", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString4Typed() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals("This was\b\b\bis\ta \"quoted\" string\f", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString5() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_5);

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());

        StringBuilder builder = new StringBuilder();
        parser.appendNextStringValue(builder);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());

        Assert.assertEquals(3300, builder.length());
    }

    @Test
    public void testSimpleFalse() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(FALSE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertSame(Boolean.FALSE, parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleFalseTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(FALSE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertFalse(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleTrue() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(TRUE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertSame(Boolean.TRUE, parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleTrueTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(TRUE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertTrue(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNull() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NULL_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertSame(JSONObject.NULL, parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(0.0d), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumberDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(0.0d, parser.nextDoubleValue(), 0.00000000001d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());

        Assert.assertEquals("JSONStreamReader at 3 [character 4 line 1]", parser.toString());
    }

    @Test
    public void testSimpleNumberNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(0.0d), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());

        Assert.assertEquals("JSONStreamReader at 3 [character 4 line 1]", parser.toString());
    }

    @Test
    public void testSimpleNumber2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(42), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2TypedInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(42, parser.nextIntValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2TypedLong() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(42L, parser.nextLongValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2TypedDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(42.0d, parser.nextDoubleValue(), 0.00000000001d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2Number() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(42), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2BigInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(new BigInteger("42"), parser.nextBigIntegerValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2BigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("42"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(-5), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3TypedInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(-5, parser.nextIntValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3TypedLong() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(-5L, parser.nextLongValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3Number() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(-5), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3BigInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(new BigInteger("-5"), parser.nextBigIntegerValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3BigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("-5"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(3.14159d), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4TypedDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(3.14159d, parser.nextDoubleValue(), 0.00000000001d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4TypedNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(3.14159d), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4TypedBigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("3.14159"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(2e+10d), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5TypedDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(2e+10d, parser.nextDoubleValue(), 0.1d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5TypedNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(2e+10d), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5TypedBigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("2e+10"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }
}

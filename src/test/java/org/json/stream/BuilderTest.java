package org.json.stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for JSONObjectBuilder.
 *
 * @version 2016-7-1
 */
public final class BuilderTest {

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
    private static final String SHORT = "This was\\b\\b\\bis\\ta \\\"quoted\\\" string.\\f"; // 33
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
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONObject);

        JSONObject jsonObject = (JSONObject) value;
        Assert.assertEquals(0, jsonObject.length());
    }

    @Test
    public void testSimpleObject2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_1);
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(parser);
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(0, jsonObject.length());
    }

    @Test
    public void testObject1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_2);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONObject);

        JSONObject jsonObject = (JSONObject) value;
        Assert.assertEquals(1, jsonObject.length());
        Assert.assertTrue(jsonObject.has("key"));
        Assert.assertEquals(Double.valueOf(1.0d), jsonObject.get("key"));
    }

    @Test
    public void testObject1A() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_2);
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(parser);
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(1, jsonObject.length());
        Assert.assertTrue(jsonObject.has("key"));
        Assert.assertEquals(Double.valueOf(1.0d), jsonObject.get("key"));
    }

    @Test
    public void testObject2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_3);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONObject);

        JSONObject jsonObject = (JSONObject) value;
        Assert.assertEquals(2, jsonObject.length());

        Assert.assertTrue(jsonObject.has("key"));
        Assert.assertEquals(Double.valueOf(1.0d), jsonObject.get("key"));
        Assert.assertTrue(jsonObject.has("key2"));
        Assert.assertEquals(Boolean.TRUE, jsonObject.get("key2"));
    }

    @Test
    public void testObject2A() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_3);
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(parser);
        Assert.assertNotNull(jsonObject);
        Assert.assertEquals(2, jsonObject.length());

        Assert.assertTrue(jsonObject.has("key"));
        Assert.assertEquals(Double.valueOf(1.0d), jsonObject.get("key"));
        Assert.assertTrue(jsonObject.has("key2"));
        Assert.assertEquals(Boolean.TRUE, jsonObject.get("key2"));
    }

    @Test
    public void testObject3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_4);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONObject);

        JSONObject jsonObject = (JSONObject) value;
        Assert.assertEquals(2, jsonObject.length());

        Assert.assertTrue(jsonObject.has("key"));
        Assert.assertTrue(jsonObject.get("key") instanceof JSONObject);
        Assert.assertEquals(0, jsonObject.getJSONObject("key").length());

        Assert.assertTrue(jsonObject.has("key2"));
        Assert.assertTrue(jsonObject.get("key2") instanceof JSONArray);
        Assert.assertEquals(2, jsonObject.getJSONArray("key2").length());

        Assert.assertEquals(Integer.valueOf(1), jsonObject.getJSONArray("key2").get(0));
        Assert.assertEquals(Boolean.TRUE, jsonObject.getJSONArray("key2").get(1));

    }

    @Test
    public void testObject3A() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_4);
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(parser);
        Assert.assertNotNull(jsonObject);

        Assert.assertEquals(2, jsonObject.length());
        Assert.assertTrue(jsonObject.has("key"));
        Assert.assertTrue(jsonObject.get("key") instanceof JSONObject);
        Assert.assertEquals(0, jsonObject.getJSONObject("key").length());

        Assert.assertTrue(jsonObject.has("key2"));
        Assert.assertTrue(jsonObject.get("key2") instanceof JSONArray);
        Assert.assertEquals(2, jsonObject.getJSONArray("key2").length());

        Assert.assertEquals(Integer.valueOf(1), jsonObject.getJSONArray("key2").get(0));
        Assert.assertEquals(Boolean.TRUE, jsonObject.getJSONArray("key2").get(1));

    }

    @Test
    public void testObject4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_5);
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(parser);
        Assert.assertNotNull(jsonObject);

        Assert.assertEquals(2, jsonObject.length());
        Assert.assertTrue(jsonObject.has("key"));

        JSONObject obj1 = jsonObject.getJSONObject("key");

        Assert.assertNotNull(obj1);
        Assert.assertEquals(2, obj1.length());

        Assert.assertTrue(jsonObject.has("key2"));
        JSONObject obj2 = jsonObject.getJSONObject("key2");

        Assert.assertNotNull(obj2);
        Assert.assertEquals(1, obj2.length());
    }

    @Test
    public void testSimpleArray() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_1);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONArray);

        JSONArray jsonArray = (JSONArray) value;
        Assert.assertEquals(0, jsonArray.length());
    }

    @Test
    public void testSimpleArray2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_1);
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(parser);
        Assert.assertNotNull(jsonArray);

        Assert.assertEquals(0, jsonArray.length());
    }

    @Test
    public void testArray1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_2);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONArray);

        JSONArray jsonArray = (JSONArray) value;
        Assert.assertEquals(1, jsonArray.length());
        Assert.assertEquals("test", jsonArray.get(0));
    }

    @Test
    public void testArray1A() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_2);
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(parser);
        Assert.assertNotNull(jsonArray);

        Assert.assertEquals(1, jsonArray.length());
        Assert.assertEquals("test", jsonArray.get(0));
    }

    @Test
    public void testArray2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_3);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONArray);

        JSONArray jsonArray = (JSONArray) value;
        Assert.assertEquals(4, jsonArray.length());
        Assert.assertEquals("test", jsonArray.get(0));
        Assert.assertEquals(Integer.valueOf(4), jsonArray.get(1));
        Assert.assertEquals(JSONObject.NULL, jsonArray.get(2));
        Assert.assertEquals(Boolean.FALSE, jsonArray.get(3));
    }

    @Test
    public void testArray2A() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_3);
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(parser);
        Assert.assertNotNull(jsonArray);

        Assert.assertEquals(4, jsonArray.length());
        Assert.assertEquals("test", jsonArray.get(0));
        Assert.assertEquals(Integer.valueOf(4), jsonArray.get(1));
        Assert.assertEquals(JSONObject.NULL, jsonArray.get(2));
        Assert.assertEquals(Boolean.FALSE, jsonArray.get(3));
    }

    @Test
    public void testArray3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_4);
        Object value = JSONObjectBuilder.buildJSONValue(parser);
        Assert.assertTrue(value instanceof JSONArray);

        JSONArray jsonArray = (JSONArray) value;
        Assert.assertEquals(1, jsonArray.length());

        JSONArray array1 = jsonArray.getJSONArray(0);
        Assert.assertNotNull(array1);
        Assert.assertEquals(2, array1.length());

        JSONObject object1 = array1.getJSONObject(0);
        Assert.assertNotNull(object1);
        Assert.assertEquals(1, object1.length());

        Assert.assertTrue(object1.has("key"));
        Assert.assertEquals(4, object1.getInt("key"));

        Assert.assertFalse(array1.getBoolean(1));
    }

    @Test
    public void testArray3A() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_4);
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(parser);
        Assert.assertNotNull(jsonArray);

        Assert.assertEquals(1, jsonArray.length());

        JSONArray array1 = jsonArray.getJSONArray(0);
        Assert.assertNotNull(array1);
        Assert.assertEquals(2, array1.length());

        JSONObject object1 = array1.getJSONObject(0);
        Assert.assertNotNull(object1);
        Assert.assertEquals(1, object1.length());

        Assert.assertTrue(object1.has("key"));
        Assert.assertEquals(4, object1.getInt("key"));

        Assert.assertFalse(array1.getBoolean(1));
    }

    @Test
    public void testSimpleString() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_1);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof String);

        String str = (String) value;
        Assert.assertEquals("", str);
    }

    @Test
    public void testSimpleString2() throws Exception {
        Object value = JSONObjectBuilder.buildJSONValue(STRING_2);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof String);

        String str = (String) value;
        Assert.assertEquals("This is a test.\r\n", str);
    }

    @Test
    public void testSimpleString3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_3);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof String);

        String str = (String) value;
        Assert.assertEquals("This is a unicode \u0032.", str);
    }

    @Test
    public void testSimpleString4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_4);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof String);

        String str = (String) value;
        Assert.assertEquals("This was\b\b\bis\ta \"quoted\" string\f", str);
    }

    @Test
    public void testSimpleString5() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_5);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof String);

        String str = (String) value;
        Assert.assertEquals(3300, str.length());
    }

    @Test
    public void testSimpleFalse() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(FALSE_1);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Boolean);

        Boolean bool = (Boolean)value;
        Assert.assertSame(Boolean.FALSE, bool);
    }

    @Test
    public void testSimpleTrue() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(TRUE_1);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Boolean);

        Boolean bool = (Boolean)value;
        Assert.assertSame(Boolean.TRUE, bool);
    }

    @Test
    public void testSimpleNull() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NULL_1);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertSame(JSONObject.NULL, value);
    }

    @Test
    public void testSimpleNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Double);

        Double dbl = (Double) value;
        Assert.assertEquals(Double.valueOf(0.0d), dbl);
    }

    @Test
    public void testSimpleNumber2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Integer);

        Integer in = (Integer) value;
        Assert.assertEquals(Integer.valueOf(42), in);
    }

    @Test
    public void testSimpleNumber3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Integer);

        Integer in = (Integer) value;
        Assert.assertEquals(Integer.valueOf(-5), in);
    }

    @Test
    public void testSimpleNumber4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Double);

        Double dbl = (Double) value;
        Assert.assertEquals(Double.valueOf(3.14159d), dbl);
    }

    @Test
    public void testSimpleNumber5() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Double);

        Double dbl = (Double) value;
        Assert.assertEquals(Double.valueOf(2e+10d), dbl);
    }
}

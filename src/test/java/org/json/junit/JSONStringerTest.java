package org.json.junit;

import static org.junit.Assert.*;

import org.json.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;

//import com.jayway.jsonpath.*;


/**
 * Tests for JSON-Java JSONStringer and JSONWriter.
 */
public class JSONStringerTest {

    /**
     * Object with a null key.
     * Expects a JSONException.
     */
    @Test
    public void nullKeyException() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.object();
        try {
            jsonStringer.key(null);
            assertTrue("Expected an exception", false);
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Null key.",
                    e.getMessage());
        }
    }

    /**
     * Add a key with no object.
     * Expects a JSONException.
     */
    @Test
    public void outOfSequenceException() {
        JSONStringer jsonStringer = new JSONStringer();
        try {
            jsonStringer.key("hi");
            assertTrue("Expected an exception", false);
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Misplaced key.",
                    e.getMessage());
        }
    }

    /**
     * Misplace an array.
     * Expects a JSONException
     */
    @Test
    public void missplacedArrayException() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.object().endObject();
        try {
            jsonStringer.array();
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Misplaced array.",
                    e.getMessage());
        }
    }

    /**
     * Missplace an endErray.
     * Expects a JSONException
     */
    @Test
    public void missplacedEndArrayException() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.object();
        try {
            jsonStringer.endArray();
            fail("Should be endObject");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Misplaced endArray.",
                    e.getMessage());
        }
    }

    /**
     * Missplace an endObject.
     * Expects a JSONException
     */
    @Test
    public void missplacedEndObjectException() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.array();
        try {
            jsonStringer.endObject();
            fail("Should be endArray");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Misplaced endObject.",
                    e.getMessage());
        }
    }

    /**
     * Missplace an object.
     * Expects a JSONException.
     */
    @Test
    public void missplacedObjectException() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.object().endObject();
        try {
            jsonStringer.object();
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Misplaced object.",
                    e.getMessage());
        }
    }

    /**
     * Missplace a null value.
     * Expects a JSONException.
     */
    @Test
    public void missplacedNullValueException() {
        JSONStringer jsonStringer = new JSONStringer();

        try {
            jsonStringer.nullValue();
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Value out of sequence.",
                    e.getMessage());
        }
    }

    /**
     * Write a null value.
     * Expects a result.
     */
    @Test
    public void intentionalNullValue() {
        JSONStringer jsonStringer = new JSONStringer(true);

        try {
            String result = jsonStringer.nullValue().toString();
            assertEquals("null", result);
        } catch (JSONException e) {
            assertNull("Expected an exception message",
                    e);
        }
    }

    /**
     * Missplace a boolean value.
     * Expects a JSONException.
     */
    @Test
    public void missplacedBooleanValueException() {
        JSONStringer jsonStringer = new JSONStringer();

        try {
            jsonStringer.value(false);
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Value out of sequence.",
                    e.getMessage());
        }
    }

    /**
     * Write a boolean value.
     * Expects a result.
     */
    @Test
    public void intentionalBooleanValue() {
        JSONStringer jsonStringer = new JSONStringer(true);

        try {
            String result = jsonStringer.value(true).toString();
            assertEquals("true", result);
        } catch (JSONException e) {
            assertNull("Expected an exception message",
                    e);
        }
    }

    /**
     * Missplace a long value.
     * Expects a JSONException.
     */
    @Test
    public void missplacedLongValueException() {
        JSONStringer jsonStringer = new JSONStringer();

        try {
            jsonStringer.value(24L);
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Value out of sequence.",
                    e.getMessage());
        }
    }

    /**
     * Write a long value.
     * Expects a result.
     */
    @Test
    public void intentionalLongValue() {
        JSONStringer jsonStringer = new JSONStringer(true);

        try {
            String result = jsonStringer.value(24L).toString();
            assertEquals("24", result);
        } catch (JSONException e) {
            assertNull("Expected an exception message",
                    e);
        }
    }

    /**
     * Missplace a double value.
     * Expects a JSONException.
     */
    @Test
    public void missplacedDoubleValueException() {
        JSONStringer jsonStringer = new JSONStringer();

        try {
            jsonStringer.value(3.14d);
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Value out of sequence.",
                    e.getMessage());
        }
    }

    /**
     * Write a double value.
     * Expects a result.
     */
    @Test
    public void intentionalDoubleValue() {
        JSONStringer jsonStringer = new JSONStringer(true);

        try {
            String result = jsonStringer.value(3.14d).toString();
            assertEquals("3.14", result);
        } catch (JSONException e) {
            assertNull("Expected an exception message",
                    e);
        }
    }

    /**
     * Missplace a String value.
     * Expects a JSONException.
     */
    @Test
    public void missplacedStringValueException() {
        JSONStringer jsonStringer = new JSONStringer();

        try {
            jsonStringer.value("testing 123");
            fail("Should be done");
        } catch (JSONWriterException e) {
            assertEquals("Expected an exception message",
                    "Value out of sequence.",
                    e.getMessage());
        }
    }

    /**
     * Write a String value.
     * Expects a result.
     */
    @Test
    public void intentionalStringValue() {
        JSONStringer jsonStringer = new JSONStringer(true);

        try {
            String result = jsonStringer.value("testing 123").toString();
            assertEquals("\"testing 123\"", result);
        } catch (JSONException e) {
            assertNull("Expected an exception message",
                    e);
        }
    }

    /**
     * Exceeds implementation max nesting depth.
     * Expects a JSONException
     */
    @Test
    public void exceedNestDepthException() {
        try {
            JSONStringer s = new JSONStringer();
            s.object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
            s.key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object().
            key("k").object().key("k").object().key("k").object().key("k").object().key("k").object();
//            fail("Expected an exception message");
        } catch (JSONException e) {
            fail("Expected arbitrary depth success");
        }
    }

    /**
     * Build a JSON doc using JSONString API calls,
     * then convert to JSONObject
     */
    @Test
    public void simpleObjectString() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.object();
        jsonStringer.key("trueValue").value(true);
        jsonStringer.key("falseValue").value(false);
        jsonStringer.key("nullValue").value(null);
        jsonStringer.key("stringValue").value("hello world!");
        jsonStringer.key("complexStringValue").value("h\be\tllo w\u1234orld!");
        jsonStringer.key("intValue").value(42);
        jsonStringer.key("doubleValue").value(-23.45e67);
        jsonStringer.endObject();
        String str = jsonStringer.toString();
        JSONObject jsonObject = new JSONObject(str);

        // validate JSON content
//        Object doc = Configuration.defaultConfiguration().jsonProvider().parse(jsonObject.toString());
//        assertTrue("expected 7 top level items", ((Map<?,?>)(JsonPath.read(doc, "$"))).size() == 7);
        assertEquals("expected 7 top level items", 7, jsonObject.toMap().size());
        assertTrue("expected true", Boolean.TRUE.equals(jsonObject.query("/trueValue")));
        assertTrue("expected false", Boolean.FALSE.equals(jsonObject.query("/falseValue")));
        assertTrue("expected null", JSONObject.NULL.equals(jsonObject.query("/nullValue")));
        assertTrue("expected hello world!", "hello world!".equals(jsonObject.query("/stringValue")));
        assertTrue("expected h\be\tllo w\u1234orld!", "h\be\tllo w\u1234orld!".equals(jsonObject.query("/complexStringValue")));
        assertTrue("expected 42", Integer.valueOf(42).equals(jsonObject.query("/intValue")));
        assertTrue("expected -23.45e67", Double.valueOf(-23.45e67).equals(jsonObject.query("/doubleValue")));
    }

    /**
     * Build a JSON doc using JSONString API calls,
     * then convert to JSONArray
     */
    @Test
    public void simpleArrayString() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.array();
        jsonStringer.value(true);
        jsonStringer.value(false);
        jsonStringer.value(null);
        jsonStringer.value("hello world!");
        jsonStringer.value(42);
        jsonStringer.value(-23.45e67);
        jsonStringer.endArray();
        String str = jsonStringer.toString();
        JSONArray jsonArray = new JSONArray(str);

        // validate JSON content
//        Object doc = Configuration.defaultConfiguration().jsonProvider().parse(jsonArray.toString());
//        assertTrue("expected 6 top level items", ((List<?>)(JsonPath.read(doc, "$"))).size() == 6);
        assertEquals("expected 6 top level items", 6, jsonArray.toList().size());
        assertTrue("expected true", Boolean.TRUE.equals(jsonArray.query("/0")));
        assertTrue("expected false", Boolean.FALSE.equals(jsonArray.query("/1")));
        assertTrue("expected null", JSONObject.NULL.equals(jsonArray.query("/2")));
        assertTrue("expected hello world!", "hello world!".equals(jsonArray.query("/3")));
        assertTrue("expected 42", Integer.valueOf(42).equals(jsonArray.query("/4")));
        assertTrue("expected -23.45e67", Double.valueOf(-23.45e67).equals(jsonArray.query("/5")));
    }

    @Test
    public void writeAppendable() {
        MyJSONAppendable app = new MyJSONAppendable();
        JSONStringer writer = new JSONStringer(2);

        writer.object();
        writer.key("data").value(app);
        writer.endObject();

//        System.out.println(writer.toString());
    }

    /**
     * Build a nested JSON doc using JSONString API calls, then convert to
     * JSONObject. Will create a long cascade of output by reusing the
     * returned values..
     */
    @Test
    public void complexObjectString() {
        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.object().
            key("trueValue").value(true).
            key("falseValue").value(false).
            key("nullValue").value(null).
            key("stringValue").value("hello world!").
            key("object2").object().
            key("k1").value("v1").
            key("k2").value("v2").
            key("k3").value("v3").
            key("array1").array().
            value(1).
            value(2).
            object().
            key("k4").value("v4").
            key("k5").value("v5").
            key("k6").value("v6").
            key("array2").array().
            value(5).
            value(6).
            value(7).
            value(8).
            endArray().
            endObject().
            value(3).
            value(4).
            endArray().
            endObject().
            key("complexStringValue").value("h\be\tllo w\u1234orld!").
            key("intValue").value(42).
            key("doubleValue").value(-23.45e67).
            endObject();
        String str = jsonStringer.toString();
        JSONObject jsonObject = new JSONObject(str);

        // validate JSON content
//        Object doc = Configuration.defaultConfiguration().jsonProvider().parse(jsonObject.toString());
//        assertTrue("expected 8 top level items", ((Map<?,?>)(JsonPath.read(doc, "$"))).size() == 8);
//        assertTrue("expected 4 object2 items", ((Map<?,?>)(JsonPath.read(doc, "$.object2"))).size() == 4);
//        assertTrue("expected 5 array1 items", ((List<?>)(JsonPath.read(doc, "$.object2.array1"))).size() == 5);
//        assertTrue("expected 4 array[2] items", ((Map<?,?>)(JsonPath.read(doc, "$.object2.array1[2]"))).size() == 4);
//        assertTrue("expected 4 array1[2].array2 items", ((List<?>)(JsonPath.read(doc, "$.object2.array1[2].array2"))).size() == 4);

        assertEquals("expected 8 top level items", 8, jsonObject.toMap().size());
        assertEquals("expected 4 /object2 items", 4, ((JSONObject)jsonObject.query("/object2")).toMap().size());
        assertEquals("expected 5 /object2/array1 items", 5, ((JSONArray)jsonObject.query("/object2/array1")).toList().size());
        assertEquals("expected 4 /object2/array1/2 items", 4, ((JSONObject)jsonObject.query("/object2/array1/2")).toMap().size());
        assertEquals("expected 4 /object2/array1/2/array2 items", 4, ((JSONArray)jsonObject.query("/object2/array1/2/array2")).toList().size());
        assertTrue("expected true", Boolean.TRUE.equals(jsonObject.query("/trueValue")));
        assertTrue("expected false", Boolean.FALSE.equals(jsonObject.query("/falseValue")));
        assertTrue("expected null", JSONObject.NULL.equals(jsonObject.query("/nullValue")));
        assertTrue("expected hello world!", "hello world!".equals(jsonObject.query("/stringValue")));
        assertTrue("expected 42", Integer.valueOf(42).equals(jsonObject.query("/intValue")));
        assertTrue("expected -23.45e67", Double.valueOf(-23.45e67).equals(jsonObject.query("/doubleValue")));
        assertTrue("expected h\be\tllo w\u1234orld!", "h\be\tllo w\u1234orld!".equals(jsonObject.query("/complexStringValue")));
        assertTrue("expected v1", "v1".equals(jsonObject.query("/object2/k1")));
        assertTrue("expected v2", "v2".equals(jsonObject.query("/object2/k2")));
        assertTrue("expected v3", "v3".equals(jsonObject.query("/object2/k3")));
        assertTrue("expected 1", Integer.valueOf(1).equals(jsonObject.query("/object2/array1/0")));
        assertTrue("expected 2", Integer.valueOf(2).equals(jsonObject.query("/object2/array1/1")));
        assertTrue("expected v4", "v4".equals(jsonObject.query("/object2/array1/2/k4")));
        assertTrue("expected v5", "v5".equals(jsonObject.query("/object2/array1/2/k5")));
        assertTrue("expected v6", "v6".equals(jsonObject.query("/object2/array1/2/k6")));
        assertTrue("expected 5", Integer.valueOf(5).equals(jsonObject.query("/object2/array1/2/array2/0")));
        assertTrue("expected 6", Integer.valueOf(6).equals(jsonObject.query("/object2/array1/2/array2/1")));
        assertTrue("expected 7", Integer.valueOf(7).equals(jsonObject.query("/object2/array1/2/array2/2")));
        assertTrue("expected 8", Integer.valueOf(8).equals(jsonObject.query("/object2/array1/2/array2/3")));
        assertTrue("expected 3", Integer.valueOf(3).equals(jsonObject.query("/object2/array1/3")));
        assertTrue("expected 4", Integer.valueOf(4).equals(jsonObject.query("/object2/array1/4")));
    }

    public static void main(String[] args) throws Exception {
        //
        JUnitCore.runClasses(JSONStringerTest.class);

        Thread.sleep(8000L);

        for(int i = 0; i < 20000; i++) {
            JUnitCore.runClasses(JSONStringerTest.class);
        }
    }
}

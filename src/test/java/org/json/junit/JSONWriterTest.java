package org.json.junit;

import org.json.JSONAppendable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONWriter;
import org.json.JSONWriterException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JSON.org
 * @version 2016-08-04
 */
public class JSONWriterTest {

    // Taken from http://www.json.org/ front page
    private static final String CORPUS =
        "<p><b>JSON</b> (JavaScript Object Notation) is a lightweight data-interchange\n" +
        "  format. It is easy for humans to read and write. It is easy for machines to\n" +
        "  parse and generate. It is based on a subset of the\n" +
        "  <a href=\"http://javascript.crockford.com/\">JavaScript\n" +
        "  Programming Language</a>,\n" +
        "  <a href=\"http://www.ecma-international.org/publications/files/ecma-st/ECMA-262.pdf\">Standard\n" +
        "  ECMA-262 3rd Edition - December 1999</a>. JSON is a text format that is completely\n" +
        "  language independent but uses conventions that are familiar to programmers of\n" +
        "  the C-family of languages, including C, C++, C#, Java, JavaScript, Perl, Python,\n" +
        "  and many others. These properties make JSON an ideal data-interchange language.</p>\n" +
        "<p>JSON is built on two structures:</p>\n" +
        "<ul>\n" +
        "  <li>A collection of name/value pairs. In various languages, this is realized\n" +
        "    as an <i>object</i>, record, struct, dictionary, hash table, keyed list, or\n" +
        "    associative array.</li>\n" +
        "  <li>An ordered list of values. In most languages, this is realized as an <i>array</i>,\n" +
        "    vector, list, or sequence.</li>\n" +
        "</ul>\n" +
        "<p>These are universal data structures. Virtually all modern\n" +
        "programming languages support them in one form or another. It makes sense\n" +
        "that a data format that is interchangeable with programming languages also\n" +
        "be based on these structures.</p>\n" +
        "<p>In JSON, they take on these forms:</p>\n" +
        "<p>An <i>object</i> is an unordered set of name/value pairs. An object\n" +
        "  begins with <tt>{</tt>&nbsp;<small>(left brace)</small> and ends\n" +
        "  with <tt>}</tt>&nbsp;<small>(right brace)</small>. Each name is followed\n" +
        "  by <tt>:</tt>&nbsp;<small>(colon)</small> and the name/value pairs are\n" +
        "  separated by <tt>,</tt>&nbsp;<small>(comma)</small>.</p>\n" +
        "\n" +
        "<p><img src=\"object.gif\" width=\"598\" height=\"113\"></p>\n" +
        "\n" +
        "<p>An <i>array</i> is an ordered collection of values. An array begins\n" +
        "  with <tt>[</tt>&nbsp;<small>(left bracket)</small> and ends\n" +
        "  with <tt>]</tt>&nbsp;<small>(right bracket)</small>. Values are separated\n" +
        "  by <tt>,</tt>&nbsp;<small>(comma)</small>.</p>\n" +
        "\n" +
        "<p><img src=\"array.gif\" width=\"598\" height=\"113\"></p>\n" +
        "\n" +
        "<p>A <i>value</i> can be a <i>string</i> in double quotes, or a <i>number</i>,\n" +
        "  or <tt>true</tt> or <tt>false</tt> or <tt>null</tt>, or an <i>object</i> or\n" +
        "  an <i>array</i>. These structures can be nested.</p>\n" +
        "\n" +
        "<p><img src=\"value.gif\" width=\"598\" height=\"278\"></p>\n" +
        "\n" +
        "<p>A <i>string</i> is a sequence of zero or more Unicode characters, wrapped\n" +
        "  in double quotes, using backslash escapes. A character is represented as a\n" +
        "  single character string. A string is very much like a C or Java string.</p>\n" +
        "\n" +
        "<p><img src=\"string.gif\" width=\"598\" height=\"413\"></p>\n" +
        "\n" +
        "<p>A <i>number</i> is very much like a C or Java number, except that the octal\n" +
        "  and hexadecimal formats are not used.</p>\n" +
        "\n" +
        "<p><img src=\"number.gif\" height=\"266\" width=\"598\"></p>\n" +
        "\n" +
        "<p>Whitespace can be inserted between any pair of tokens. Excepting\n" +
        "  a few encoding details, that completely describes the language.</p>";

    @Test
    public void testWriteString() {
        CountingAppender a = new CountingAppender();
        JSONWriter writer = new JSONWriter(a);

        writer.array();
        writer.value(CORPUS);
        writer.endArray();

//        System.out.println("Corpus length: " + CORPUS.length());
//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());

        JSONArray array = new JSONArray();
        array.put(CORPUS);
        a = new CountingAppender();

        array.write(a);

//        System.out.println("Corpus length: " + CORPUS.length());
//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testWriteObject() throws Exception {
        CountingAppender a = new CountingAppender();
        JSONWriter writer = new JSONWriter(a);

        writer.object();
        writer.key("nullValue").nullValue();
        writer.key("trueKey").value(true);
        writer.key("falseKey").value(false);
        writer.key("trueStrKey").value("true");
        writer.key("falseStrKey").value("false");
        writer.key("stringKey").value("hello world!");
        writer.key("intKey").value(42);
        writer.key("intStrKey").value("43");
        writer.key("longKey").value(1234567890123456789L);
        writer.key("longStrKey").value("987654321098765432");
        writer.key("doubleKey").value(42.0d);
        writer.key("doubleStrKey").value("00001.000");
        writer.key("arrayKey").array().value(1).value(2).value(3).endArray();
        writer.key("objectKey").object().key("myKey").value("myVal").endObject();
        writer.endObject();

//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testObjectWrite() throws Exception {
        String str =
                "{"+
                        "\"trueKey\":true,"+
                        "\"falseKey\":false,"+
                        "\"trueStrKey\":\"true\","+
                        "\"falseStrKey\":\"false\","+
                        "\"stringKey\":\"hello world!\","+
                        "\"intKey\":42,"+
                        "\"intStrKey\":\"43\","+
                        "\"longKey\":1234567890123456789,"+
                        "\"longStrKey\":\"987654321098765432\","+
                        "\"doubleKey\":-23.45e7,"+
                        "\"doubleStrKey\":\"00001.000\","+
                        "\"arrayKey\":[0,1,2],"+
                        "\"objectKey\":{\"myKey\":\"myVal\"}"+
                        "}";

        CountingAppender a = new CountingAppender();
        JSONObject obj = new JSONObject(str);
        obj.write(a);

//        System.out.println("Corpus length: " + str.length());
//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testWriteArray() throws Exception {
        CountingAppender a = new CountingAppender();
        JSONWriter writer = new JSONWriter(a);

        writer.array();
        writer.nullValue();
        writer.value(true);
        writer.value(false);
        writer.value("true");
        writer.value("false");
        writer.value("hello");
        writer.value(23.45e-4d);
        writer.value("23.45");
        writer.value(42.0d);
        writer.value("43");
        writer.array().value("world").endArray();
        writer.object().
                key("key1").value("value1").
                key("key2").value("value2").
                key("key3").value("value3").
                key("key4").value("value4").
                endObject();
        writer.value(0);
        writer.value("-1");
        writer.endArray();

//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testArrayWrite() throws Exception {
        String arrayStr =
                "["+
                        "null,"+
                        "true,"+
                        "false,"+
                        "\"true\","+
                        "\"false\","+
                        "\"hello\","+
                        "23.45e-4,"+
                        "\"23.45\","+
                        "42,"+
                        "\"43\","+
                        "["+
                        "\"world\""+
                        "],"+
                        "{"+
                        "\"key1\":\"value1\","+
                        "\"key2\":\"value2\","+
                        "\"key3\":\"value3\","+
                        "\"key4\":\"value4\""+
                        "},"+
                        "0,"+
                        "\"-1\""+
                        "]";

        CountingAppender a = new CountingAppender();
        JSONArray arr = new JSONArray(arrayStr);
        arr.write(a);

//        System.out.println("Corpus length: " + arrayStr.length());
//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testNestedObject1() {
        CountingAppender a = new CountingAppender();
        JSONObject obj = new JSONObject();
        obj.putOnce("key1", "value1");
        obj.putOnce("key2", "value 2");
        obj.put("key3", 42);
        obj.put("key4", 3.14d);
        obj.put("key5", true);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("sub1", "sub value 1");
        map1.put("sub2", Long.valueOf(42));
        map1.put("sub3", Double.valueOf(3.14d));
        map1.put("sub4", Boolean.FALSE);

        obj.put("key6", map1);

        List<Object> list1 = new ArrayList<>();
        list1.add("list 1");
        list1.add(Long.valueOf(42));
        list1.add(Double.valueOf(3.14d));
        list1.add(Boolean.FALSE);
        list1.add(JSONObject.NULL);

        obj.put("key7", list1);

        JSONWriter writer = new JSONWriter(a);

        writer.array();
        writer.value(true);
        writer.value(42);
        writer.value(3.14d);
        writer.value(obj);
        writer.endArray();

//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testNestedObject2() {
        CountingAppender a = new CountingAppender();
        JSONString jsonString = () -> {
            throw new JSONException("JSON String value");
        };
        JSONObject obj = new JSONObject();
        obj.putOnce("key1", "value1");
        obj.putOnce("key2", "value 2");
        obj.put("key3", 42);
        obj.put("key4", 3.14d);
        obj.put("key5", true);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("sub1", "sub value 1");
        map1.put("sub2", Long.valueOf(42));
        map1.put("sub3", Double.valueOf(3.14d));
        map1.put("sub4", Boolean.FALSE);
        map1.put("sub5", jsonString);

        obj.put("key6", map1);

        List<Object> list1 = new ArrayList<>();
        list1.add("list 1");
        list1.add(Long.valueOf(42));
        list1.add(Double.valueOf(3.14d));
        list1.add(Boolean.FALSE);
        list1.add(JSONObject.NULL);

        obj.put("key7", list1);

        try {
            JSONWriter writer = new JSONWriter(a);

            writer.array();
            writer.value(true);
            writer.value(42);
            writer.value(3.14d);
            writer.value(obj);
            writer.endArray();

//            System.out.println("Encoded length: " + a.getLength());
//            System.out.println("Append calls: " + a.getCount());
//            System.out.println("Biggest sequence: " + a.getBiggest());
//            System.out.println("Single char appends: " + a.getSingleChars());
//            System.out.println("Text: " + a.getText());
            Assert.fail("Expected exception");
        } catch (JSONWriterException e) {
            Assert.assertEquals("/3/key6/sub5", e.getJSONPointer());
        }
    }

    @Test
    public void testNestedObject3() {
        CountingAppender a = new CountingAppender();
        Map<String, Object> obj = new HashMap<>();
        obj.put("key1", "value1");
        obj.put("key2", "value 2");
        obj.put("key3", 42);
        obj.put("key4", 3.14d);
        obj.put("key5", true);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("sub1", "sub value 1");
        map1.put("sub2", Long.valueOf(42));
        map1.put("sub3", Double.valueOf(3.14d));
        map1.put("sub4", Boolean.FALSE);

        obj.put("key6", map1);

        List<Object> list1 = new ArrayList<>();
        list1.add("list 1");
        list1.add(Long.valueOf(42));
        list1.add(Double.valueOf(3.14d));
        list1.add(Boolean.FALSE);
        list1.add(JSONObject.NULL);

        obj.put("key7", list1);

        JSONWriter writer = new JSONWriter(a, 2);

        writer.array();
        writer.value(true);
        writer.value(42);
        writer.value(3.14d);
        writer.value(obj);
        writer.endArray();

//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    @Test
    public void testNestedObject4() {
        CountingAppender a = new CountingAppender();
        JSONAppendable jsonAppendable = (appendable) -> {
            throw new JSONException("JSON String value");
        };
        Map<String, Object> obj = new HashMap<>();
        obj.put("key1", "value1");
        obj.put("key2", "value 2");
        obj.put("key3", 42);
        obj.put("key4", 3.14d);
        obj.put("key5", true);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("sub1", "sub value 1");
        map1.put("sub2", Long.valueOf(42));
        map1.put("sub3", Double.valueOf(3.14d));
        map1.put("sub4", Boolean.FALSE);

        obj.put("key6", map1);

        List<Object> list1 = new ArrayList<>();
        list1.add("list 1");
        list1.add(Long.valueOf(42));
        list1.add(Double.valueOf(3.14d));
        list1.add(Boolean.FALSE);
        list1.add(jsonAppendable);
        list1.add(JSONObject.NULL);

        obj.put("key7", list1);

        try {
            JSONWriter writer = new JSONWriter(a, 2);

            writer.array();
            writer.value(true);
            writer.value(42);
            writer.value(3.14d);
            writer.value(obj);
            writer.endArray();

//            System.out.println("Encoded length: " + a.getLength());
//            System.out.println("Append calls: " + a.getCount());
//            System.out.println("Biggest sequence: " + a.getBiggest());
//            System.out.println("Single char appends: " + a.getSingleChars());
//            System.out.println("Text: " + a.getText());
            Assert.fail("Expected exception");
        } catch (JSONWriterException e) {
            Assert.assertEquals("/3/key7/4", e.getJSONPointer());
        }
    }

    @Test
    public void testNestedObject5() {
//        CountingAppender a = new CountingAppender();
        StringBuilder a = new StringBuilder();
        JSONObject obj = new JSONObject();
        obj.putOnce("key1", "value1");
        obj.putOnce("key2", "value 2");
        obj.put("key3", 42);
        obj.put("key4", 3.14d);
        obj.put("key5", true);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("sub1", "sub value 1");
        map1.put("sub2", Long.valueOf(42));
        map1.put("sub3", Double.valueOf(3.14d));
        map1.put("sub4", Boolean.FALSE);

        List<Object> list1 = new ArrayList<>();
        list1.add("list 1");
        list1.add(Long.valueOf(42));
        list1.add(Double.valueOf(3.14d));
        list1.add(Boolean.FALSE);
        list1.add(JSONObject.NULL);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("subsub1", "sub-sub value 1");
        map2.put("subsub2", Long.valueOf(12));
        map2.put("subsub3", Double.valueOf(2.7172d));
        map2.put("subsub4", Boolean.TRUE);

        List<Object> list2 = new ArrayList<>();
        list2.add("sublist 1");
        list2.add(Long.valueOf(33));
        list2.add(Double.valueOf(12.1d));
        list2.add(JSONObject.NULL);
        list2.add(Boolean.FALSE);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("subsubsub1", "sub-sub-sub value 1");
        map3.put("subsubsub2", Long.valueOf(21));
        map3.put("subsubsub3", Double.valueOf(1.1d));
        map3.put("subsubsub4", Boolean.TRUE);

        List<Object> list3 = new ArrayList<>();
        list3.add("subsublist 1");
        list3.add(Long.valueOf(99));
        list3.add(Double.valueOf(Math.E));
        list3.add(JSONObject.NULL);
        list3.add(Boolean.FALSE);

        map2.put("subsub5", list3);
        map2.put("subsub6", map3);

        list2.add(map3);
        list2.add(list3);

        for(int i = 10; i < 5010; i++) {
            //
            map1.put("list" + i, list2);
            map1.put("map" + i, map2);
        }

        for(int i = 0; i < 5000; i++) {
            list1.add(map2);
            list1.add(list2);
        }

        obj.put("key6", map1);
        obj.put("key7", list1);

        JSONWriter writer = new JSONWriter(a, 4);

        writer.array();
        writer.value(true);
        writer.value(42);
        writer.value(Math.PI);
        writer.value(obj);
        writer.endArray();

//        System.out.println("Encoded length: " + a.getLength());
//        System.out.println("Append calls: " + a.getCount());
//        System.out.println("Biggest sequence: " + a.getBiggest());
//        System.out.println("Single char appends: " + a.getSingleChars());
//        System.out.println("Text: " + a.getText());
    }

    /**
     * Main method for profiling with VisualVM. Runs once to "warm up" the
     * JVM, then waits for 10 seconds to allow VisualVM to attached to the
     * process. Finally, runs through the tests a sufficient number of times
     * to get a CPU profile of where time is spent.
     *
     * @param args ignored
     */
    public static void main(String[] args) throws Exception {
        JUnitCore.runClasses(JSONWriterTest.class);
        Thread.sleep(10000);
        long now = System.currentTimeMillis();
        for(int i = 0; i < 2500; i++)
            JUnitCore.runClasses(JSONWriterTest.class);
        
        System.out.println(System.currentTimeMillis() - now);
    }

    private static final class CountingAppender implements Appendable {
        private int count = 0;
        private int biggest = 0;
        private int singleChars = 0;
        private final StringBuilder builder = new StringBuilder();

        @Override
        public Appendable append(CharSequence csq) throws IOException {
            count++;
            final int len = csq.length();
            if(len > biggest) {
                biggest = len;
            }
            if(len == 1) {
                singleChars++;
            }
            builder.append(csq);
            return this;
        }

        @Override
        public Appendable append(CharSequence csq, int start, int end) throws IOException {
            count++;
            final int len = end - start;
            if(len > biggest) {
                biggest = len;
            }
            if(len == 1) {
                singleChars++;
            }
            builder.append(csq, start, end);
            return this;
        }

        @Override
        public Appendable append(char c) throws IOException {
            count++;
            singleChars++;
            if(biggest == 0) {
                biggest = 1;
            }
            builder.append(c);
            return this;
        }

        public int getLength() {
            return builder.length();
        }

        public int getCount() {
            return count;
        }

        public int getBiggest() {
            return biggest;
        }

        public int getSingleChars() {
            return singleChars;
        }

        public String getText() {
            return builder.toString();
        }
    }
}

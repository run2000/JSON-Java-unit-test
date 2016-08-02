package org.json.stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

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
    private static final String NUMBER_6 = "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847564823378678316527120190914564856692346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160943305727036575959195309218611738193261179310511854807446237996274956735188575272489122793818301194912983367336244065664308602139494639522473719070217986094370277053921717629317675238467481846766940513200056812714526356082778577134275778960917363717872146844090122495343014654958537105079227968925892354201995611212902196086403441815981362977477130996051870721134999999837297804995105973173281609631859502445945534690830264252230825334468503526193118817101000313783875288658753320838142061717766914730359825349042875546873115956286388235378759375195778185778053217122680661300192787661119590921642019893809525720106548586327886593615338182796823030195203530185296899577362259941389124972177528347913151557485724245415069595082953311686172785588907509838175463746493931925506040092770167113900984882401285836160356370766010471018194295559619894676783744944825537977472684710404753464620804668425906949129331367702898915210475216205696602405803815019351125338243003558764024749647326391419927260426992279678235478163600934172164121992458631503028618297455570674983850549458858692699569092721079750930295532116534498720275596023648066549911988183479775356636980742654252786255181841757467289097777279380008164706001614524919217321721477235014144197356854816136115735255213347574184946843852332390739414333454776241686251898356948556209921922218427255025425688767179049460165346680498862723279178608578438382796797668145410095388378636095068006422512520511739298489608412848862694560424196528502221066118630674427862203919494504712371378696095636437191728746776465757396241389086583264599581339047802759009946576407895126946839835259570982582262052248940772671947826848260147699090264013639443745530506820349625245174939965143142980919065925093722169646151570985838741059788595977297549893016175392846813826868386894277415599185592524595395943104997252468084598727364469584865383673622262609912460805124388439045124413654976278079771569143599770012961608944169486855584840635342207222582848864815845602850601684273945226746767889525213852254995466672782398645659611635488623057745649803559363456817432411251507606947945109659609402522887971089314566913686722874894056010150330861792868092087476091782493858900971490967598526136554978189312978482168299894872265880485756401427047755513237964145152374623436454285844479526586782105114135473573952311342716610213596953623144295248493718711014576540359027993440374200731057853906219838744780847848968332144571386875194350643021845319104848100537061468067491927819119793995206141966342875444064374512371819217999839101591956181467514269123974894090718649423196156794520809514655022523160388193014209376213785595663893778708303906979207734672218256259966150142150306803844773454920260541466592520149744285073251866600213243408819071048633173464965145390579626856100550810665879699816357473638405257145910289706414011097120628043903975951567715770042033786993600723055876317635942187312514712053292819182618612586732157919841484882916447060957527069572209175671167229109816909152801735067127485832228718352093539657251210835791513698820914442100675103346711031412671113699086585163983150197016515116851714376576183515565088490998985998238734552833163550764791853589322618548963213293308985706420467525907091548141654985946163718027098199430992448895757128289059232332609729971208443357326548938239119325974636673058360414281388303203824903758985243744170291327656180937734440307074692112019130203303801976211011004492932151608424448596376698389522868478312355265821314495768572624334418930396864262434107732269780280731891544110104468232527162010526522721116603966655730925471105578537634668206531098965269186205647693125705863566201855810072936065987648611";

    private static final String TRUE_1 = "true";
    private static final String FALSE_1 = "false";
    private static final String NULL_1 = "null";

    private static final String OBJECT_TEST_1 = "{"+
            "\"trueKey\":true,"+
            "\"falseKey\":false,"+
            "\"nullKey\":null,"+
            "\"stringKey\":\"hello world!\","+
            "\"escapeStringKey\":\"h\be\tllo w\u1234orld!\","+
            "\"intKey\":42,"+
            "\"doubleKey\":-23.45e67"+
            "}";

    private static final String OBJECT_TEST_2 = "{"+
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

    private static final String OBJECT_TEST_3 = "{"+
            "\"numberWithDecimals\":299792.457999999984,"+
            "\"largeNumber\":12345678901234567890,"+
            "\"preciseNumber\":0.2000000000000000111,"+
            "\"largeExponent\":-23.45e2327"+
            "}";

    private static final String ARRAY_TEST_1 = "["+
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
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(ARRAY_1);
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
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(ARRAY_2);
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
    public void testSimpleString5A() throws Exception {
        JSONArray value = new JSONArray('[' + STRING_5 + ']');

        Assert.assertNotNull(value);

        String str = value.getString(0);
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

    @Test
    public void testSimpleNumber6() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_6);
        Object value = JSONObjectBuilder.buildJSONValue(parser);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof Double);

        Double dbl = (Double) value;
        Assert.assertEquals(Double.valueOf(NUMBER_6), dbl);
    }

    /**
     * Create a JSONArray doc with a variety of different elements.
     * Confirm that the values can be accessed via the get[type]() API methods.
     * Retrofitted from the JSONArrayTest test class.
     */
    @Test
    public void testGetArrayValues() {
        JSONArray jsonArray = JSONObjectBuilder.buildJSONArray(
                new StringReader(ARRAY_TEST_1));

        // booleans
        Assert.assertTrue("Array true",
                true == jsonArray.getBoolean(0));
        Assert.assertTrue("Array false",
                false == jsonArray.getBoolean(1));
        Assert.assertTrue("Array string true",
                true == jsonArray.getBoolean(2));
        Assert.assertTrue("Array string false",
                false == jsonArray.getBoolean(3));
        // strings
        Assert.assertTrue("Array value string",
                "hello".equals(jsonArray.getString(4)));
        // doubles
        Assert.assertTrue("Array double",
                new Double(23.45e-4).equals(jsonArray.getDouble(5)));
        Assert.assertTrue("Array string double",
                new Double(23.45).equals(jsonArray.getDouble(6)));
        // ints
        Assert.assertTrue("Array value int",
                new Integer(42).equals(jsonArray.getInt(7)));
        Assert.assertTrue("Array value string int",
                new Integer(43).equals(jsonArray.getInt(8)));
        // nested objects
        JSONArray nestedJsonArray = jsonArray.getJSONArray(9);
        Assert.assertTrue("Array value JSONArray", nestedJsonArray != null);
        JSONObject nestedJsonObject = jsonArray.getJSONObject(10);
        Assert.assertTrue("Array value JSONObject", nestedJsonObject != null);
        // longs
        Assert.assertTrue("Array value long",
                new Long(0).equals(jsonArray.getLong(11)));
        Assert.assertTrue("Array value string long",
                new Long(-1).equals(jsonArray.getLong(12)));

        Assert.assertTrue("Array value null", jsonArray.isNull(-1));
    }

    /**
     * Exercise some JSONObject get[type] and opt[type] methods.
     * Retrofitted from the JSONObjectTest test class.
     */
    @Test
    public void testJsonObjectValues() {
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(
                new StringReader(OBJECT_TEST_2));
        Assert.assertTrue("trueKey should be true", jsonObject.getBoolean("trueKey"));
        Assert.assertTrue("opt trueKey should be true", jsonObject.optBoolean("trueKey"));
        Assert.assertTrue("falseKey should be false", !jsonObject.getBoolean("falseKey"));
        Assert.assertTrue("trueStrKey should be true", jsonObject.getBoolean("trueStrKey"));
        Assert.assertTrue("trueStrKey should be true", jsonObject.optBoolean("trueStrKey"));
        Assert.assertTrue("falseStrKey should be false", !jsonObject.getBoolean("falseStrKey"));
        Assert.assertTrue("stringKey should be string",
                jsonObject.getString("stringKey").equals("hello world!"));
        Assert.assertTrue("doubleKey should be double",
                jsonObject.getDouble("doubleKey") == -23.45e7);
        Assert.assertTrue("doubleStrKey should be double",
                jsonObject.getDouble("doubleStrKey") == 1);
        Assert.assertTrue("opt doubleKey should be double",
                jsonObject.optDouble("doubleKey") == -23.45e7);
        Assert.assertTrue("opt doubleKey with Default should be double",
                jsonObject.optDouble("doubleStrKey", Double.NaN) == 1);
        Assert.assertTrue("intKey should be int",
                jsonObject.optInt("intKey") == 42);
        Assert.assertTrue("opt intKey should be int",
                jsonObject.optInt("intKey", 0) == 42);
        Assert.assertTrue("opt intKey with default should be int",
                jsonObject.getInt("intKey") == 42);
        Assert.assertTrue("intStrKey should be int",
                jsonObject.getInt("intStrKey") == 43);
        Assert.assertTrue("longKey should be long",
                jsonObject.getLong("longKey") == 1234567890123456789L);
        Assert.assertTrue("opt longKey should be long",
                jsonObject.optLong("longKey") == 1234567890123456789L);
        Assert.assertTrue("opt longKey with default should be long",
                jsonObject.optLong("longKey", 0) == 1234567890123456789L);
        Assert.assertTrue("longStrKey should be long",
                jsonObject.getLong("longStrKey") == 987654321098765432L);
        Assert.assertTrue("xKey should not exist",
                jsonObject.isNull("xKey"));
        Assert.assertTrue("stringKey should exist",
                jsonObject.has("stringKey"));
        Assert.assertTrue("opt stringKey should string",
                jsonObject.optString("stringKey").equals("hello world!"));
        Assert.assertTrue("opt stringKey with default should string",
                jsonObject.optString("stringKey", "not found").equals("hello world!"));
        JSONArray jsonArray = jsonObject.getJSONArray("arrayKey");
        Assert.assertTrue("arrayKey should be JSONArray",
                jsonArray.getInt(0) == 0 &&
                        jsonArray.getInt(1) == 1 &&
                        jsonArray.getInt(2) == 2);
        jsonArray = jsonObject.optJSONArray("arrayKey");
        Assert.assertTrue("opt arrayKey should be JSONArray",
                jsonArray.getInt(0) == 0 &&
                        jsonArray.getInt(1) == 1 &&
                        jsonArray.getInt(2) == 2);
        JSONObject jsonObjectInner = jsonObject.getJSONObject("objectKey");
        Assert.assertTrue("objectKey should be JSONObject",
                jsonObjectInner.get("myKey").equals("myVal"));
    }

    /**
     * This test documents numeric values which could be numerically
     * handled as BigDecimal or BigInteger. Some of these will be parsed
     * as double, but with precision loss.
     * Retrofitted from the JSONObjectTest test class.
     */
    @Test
    public void testJsonValidNumberValuesNeitherLongNorIEEE754Compatible() {
        // Valid JSON Numbers, probably should return BigDecimal or BigInteger objects
        JSONObject jsonObject = JSONObjectBuilder.buildJSONObject(OBJECT_TEST_3);

        // Comes back as a double, but loses precision
        Assert.assertTrue( "numberWithDecimals currently evaluates to double 299792.458",
                jsonObject.get( "numberWithDecimals" ).equals( new Double( "299792.458" ) ) );
        Object obj = jsonObject.get( "largeNumber" );
        Assert.assertTrue("largeNumber currently evaluates to biginteger",
                new BigInteger("12345678901234567890").equals(obj));
        // comes back as a double but loses precision
        Assert.assertTrue( "preciseNumber currently evaluates to double 0.2",
                jsonObject.get( "preciseNumber" ).equals(Double.valueOf(0.2)));
        obj = jsonObject.get( "largeExponent" );
        Assert.assertTrue("largeExponent should currently evaluates as a string",
                new BigDecimal("-23.45e2327").equals(obj));
    }

    @Test
    public void testLargeArrays() throws Exception {
        char[] buff = new char[1000];
        char[] buff2 = new char[1000];
        Arrays.fill(buff, '[');
        Arrays.fill(buff2, ']');
        String result = new StringBuilder()
                .append(buff)
/*
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff)
                .append(buff2)
                .append(buff2)
                .append(buff2)
                .append(buff2)
                .append(buff2)
                .append(buff2)
                .append(buff2)
                .append(buff2)
                .append(buff2)
*/
                .append(buff2)
                .toString();

        // Unlikely to exhaust memory
        JSONArray jsonArray = JSONTrampolineBuilder.buildJSONArray(result);

        Assert.assertEquals(1, jsonArray.length());
    }

    @Test
    public void testLargeArrays2() throws Exception {
        char[] buff = new char[1000];
        char[] buff2 = new char[1000];
        Arrays.fill(buff, '[');
        Arrays.fill(buff2, ']');
        String result = new StringBuilder()
                .append(buff)
                .append(buff2)
                .toString();

        // This runs out of stack eventually
        JSONArray jsonArray2 = JSONObjectBuilder.buildJSONArray(result);
        Assert.assertEquals(1, jsonArray2.length());
    }

    @Test
    public void testLargeArrays3() throws Exception {
        char[] buff = new char[1000];
        char[] buff2 = new char[1000];
        Arrays.fill(buff, '[');
        Arrays.fill(buff2, ']');
        String result = new StringBuilder()
                .append(buff)
                .append(buff2)
                .toString();

        // This runs out of stack quickly!
        JSONArray jsonArray2 = new JSONArray(result);
        Assert.assertEquals(1, jsonArray2.length());
    }
}

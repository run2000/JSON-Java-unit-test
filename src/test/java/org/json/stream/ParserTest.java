package org.json.stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.stream.JSONStreamReader.ParseState;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
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
    private static final String NUMBER_6 = "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847564823378678316527120190914564856692346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160943305727036575959195309218611738193261179310511854807446237996274956735188575272489122793818301194912983367336244065664308602139494639522473719070217986094370277053921717629317675238467481846766940513200056812714526356082778577134275778960917363717872146844090122495343014654958537105079227968925892354201995611212902196086403441815981362977477130996051870721134999999837297804995105973173281609631859502445945534690830264252230825334468503526193118817101000313783875288658753320838142061717766914730359825349042875546873115956286388235378759375195778185778053217122680661300192787661119590921642019893809525720106548586327886593615338182796823030195203530185296899577362259941389124972177528347913151557485724245415069595082953311686172785588907509838175463746493931925506040092770167113900984882401285836160356370766010471018194295559619894676783744944825537977472684710404753464620804668425906949129331367702898915210475216205696602405803815019351125338243003558764024749647326391419927260426992279678235478163600934172164121992458631503028618297455570674983850549458858692699569092721079750930295532116534498720275596023648066549911988183479775356636980742654252786255181841757467289097777279380008164706001614524919217321721477235014144197356854816136115735255213347574184946843852332390739414333454776241686251898356948556209921922218427255025425688767179049460165346680498862723279178608578438382796797668145410095388378636095068006422512520511739298489608412848862694560424196528502221066118630674427862203919494504712371378696095636437191728746776465757396241389086583264599581339047802759009946576407895126946839835259570982582262052248940772671947826848260147699090264013639443745530506820349625245174939965143142980919065925093722169646151570985838741059788595977297549893016175392846813826868386894277415599185592524595395943104997252468084598727364469584865383673622262609912460805124388439045124413654976278079771569143599770012961608944169486855584840635342207222582848864815845602850601684273945226746767889525213852254995466672782398645659611635488623057745649803559363456817432411251507606947945109659609402522887971089314566913686722874894056010150330861792868092087476091782493858900971490967598526136554978189312978482168299894872265880485756401427047755513237964145152374623436454285844479526586782105114135473573952311342716610213596953623144295248493718711014576540359027993440374200731057853906219838744780847848968332144571386875194350643021845319104848100537061468067491927819119793995206141966342875444064374512371819217999839101591956181467514269123974894090718649423196156794520809514655022523160388193014209376213785595663893778708303906979207734672218256259966150142150306803844773454920260541466592520149744285073251866600213243408819071048633173464965145390579626856100550810665879699816357473638405257145910289706414011097120628043903975951567715770042033786993600723055876317635942187312514712053292819182618612586732157919841484882916447060957527069572209175671167229109816909152801735067127485832228718352093539657251210835791513698820914442100675103346711031412671113699086585163983150197016515116851714376576183515565088490998985998238734552833163550764791853589322618548963213293308985706420467525907091548141654985946163718027098199430992448895757128289059232332609729971208443357326548938239119325974636673058360414281388303203824903758985243744170291327656180937734440307074692112019130203303801976211011004492932151608424448596376698389522868478312355265821314495768572624334418930396864262434107732269780280731891544110104468232527162010526522721116603966655730925471105578537634668206531098965269186205647693125705863566201855810072936065987648611";

    private static final String TRUE_1 = "true";
    private static final String FALSE_1 = "false";
    private static final String NULL_1 = "null";

    private static final String OBJECT_TEST_1 = "{" +
            "\"trueKey\":true," +
            "\"falseKey\":false," +
            "\"nullKey\":null," +
            "\"stringKey\":\"hello world!\"," +
            "\"escapeStringKey\":\"h\\be\\tllo w\\u1234orld!\"," +
            "\"intKey\":42," +
            "\"doubleKey\":-23.45e67" +
            "}";

    private static final String OBJECT_TEST_2 = "{" +
            "\"trueKey\":true," +
            "\"falseKey\":false," +
            "\"trueStrKey\":\"true\"," +
            "\"falseStrKey\":\"false\"," +
            "\"stringKey\":\"hello world!\"," +
            "\"intKey\":42," +
            "\"intStrKey\":\"43\"," +
            "\"longKey\":1234567890123456789," +
            "\"longStrKey\":\"987654321098765432\"," +
            "\"doubleKey\":-23.45e7," +
            "\"doubleStrKey\":\"00001.000\"," +
            "\"arrayKey\":[0,1,2]," +
            "\"objectKey\":{\"myKey\":\"myVal\"}" +
            "}";

    private static final String OBJECT_TEST_3 = "{" +
            "\"numberWithDecimals\":299792.457999999984," +
            "\"largeNumber\":12345678901234567890," +
            "\"preciseNumber\":0.2000000000000000111," +
            "\"largeExponent\":-23.45e2327" +
            "}";

    private static final String ARRAY_TEST_1 = "[" +
            "true," +
            "false," +
            "\"true\"," +
            "\"false\"," +
            "\"hello\"," +
            "23.45e-4," +
            "\"23.45\"," +
            "42," +
            "\"43\"," +
            "[" +
            "\"world\"" +
            "]," +
            "{" +
            "\"key1\":\"value1\"," +
            "\"key2\":\"value2\"," +
            "\"key3\":\"value3\"," +
            "\"key4\":\"value4\"" +
            "}," +
            "0," +
            "\"-1\"" +
            "]";


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
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
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
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(1.0d), parser.nextValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertEquals(Boolean.TRUE, parser.nextValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObject3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertTrue(parser.currentState().isBeginStructure());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertTrue(parser.currentState().isBeginStructure());
        Assert.assertFalse(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertFalse(parser.currentState().isBeginStructure());
        Assert.assertFalse(parser.currentState().isEndStructure());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertTrue(parser.currentState().isBeginStructure());
        Assert.assertFalse(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isBeginStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertTrue(parser.currentState().isBeginStructure());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(1), parser.nextValue());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertEquals(Boolean.TRUE, parser.nextValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
        Assert.assertTrue(parser.currentState().isEndStructure());
    }

    @Test
    public void testObject4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertTrue(parser.currentState().isDocumentDelimiter());
        Assert.assertFalse(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isDocumentDelimiter());
        Assert.assertTrue(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertTrue(parser.currentState().isText());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isDocumentDelimiter());
        Assert.assertTrue(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertTrue(parser.currentState().isText());
        Assert.assertEquals("a", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertFalse(parser.currentState().isText());
        Assert.assertEquals(1, parser.nextIntValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertTrue(parser.currentState().isText());
        Assert.assertEquals("b", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertTrue(parser.currentState().isText());
        Assert.assertEquals("2", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isDocumentDelimiter());
        Assert.assertTrue(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertTrue(parser.currentState().isText());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isDocumentDelimiter());
        Assert.assertTrue(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertTrue(parser.currentState().isText());
        Assert.assertEquals("1", parser.nextKey());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertFalse(parser.currentState().isText());
        Assert.assertTrue(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isDocumentDelimiter());
        Assert.assertTrue(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertFalse(parser.currentState().isDocumentDelimiter());
        Assert.assertTrue(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
        Assert.assertTrue(parser.currentState().isDocumentDelimiter());
        Assert.assertFalse(parser.currentState().isObjectDelimiter());
        Assert.assertFalse(parser.currentState().isArrayDelimiter());
    }

    @Test
    public void testObjectSkip() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObjectSkip2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
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
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("test", parser.nextValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArray2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("test", parser.nextValue());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(4), parser.nextValue());
        Assert.assertEquals(ParseState.NULL_VALUE, parser.nextState());
        Assert.assertEquals(JSONObject.NULL, parser.nextValue());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
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
        Assert.assertEquals(ParseState.END_ARRAY, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArraySkip() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_ARRAY, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArraySkip2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals(ParseState.END_ARRAY, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleStringTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("This is a test.\r\n", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString2Typed() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("This is a test.\r\n", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("This is a unicode \u0032.", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString3Typed() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("This is a unicode \u0032.", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("This was\b\b\bis\ta \"quoted\" string\f", parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString4Typed() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("This was\b\b\bis\ta \"quoted\" string\f", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleString5() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_5);

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());

        StringBuilder builder = new StringBuilder();
        parser.appendNextStringValue(builder);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());

        Assert.assertEquals(3300, builder.length());
    }

    @Test
    public void testSkipString() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_5);

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
    }

    @Test
    public void testSkipString2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(STRING_5);

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.skipToEndStructure());
        Assert.assertTrue(parser.currentState().isEndStructure());
    }

    @Test
    public void testSimpleFalse() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(FALSE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertSame(Boolean.FALSE, parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleFalseTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(FALSE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertFalse(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleTrue() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(TRUE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertSame(Boolean.TRUE, parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleTrueTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(TRUE_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertTrue(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNull() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NULL_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NULL_VALUE, parser.nextState());
        Assert.assertSame(JSONObject.NULL, parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNullTyped() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NULL_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NULL_VALUE, parser.nextState());
        Assert.assertSame(JSONObject.NULL, parser.nextNullValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(0.0d), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumberDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(0.0d, parser.nextDoubleValue(), 0.00000000001d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());

        Assert.assertEquals("JSONStreamReader at 3 [character 4 line 1]", parser.toString());
    }

    @Test
    public void testSimpleNumberNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_1);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(0.0d), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());

        Assert.assertEquals("JSONStreamReader at 3 [character 4 line 1]", parser.toString());
    }

    @Test
    public void testSimpleNumber2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(42), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2TypedInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(42, parser.nextIntValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2TypedLong() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(42L, parser.nextLongValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2TypedDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(42.0d, parser.nextDoubleValue(), 0.00000000001d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2Number() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(42), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2BigInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigInteger("42"), parser.nextBigIntegerValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber2BigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_2);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("42"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(-5), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3TypedInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(-5, parser.nextIntValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3TypedLong() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(-5L, parser.nextLongValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3Number() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Integer.valueOf(-5), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3BigInt() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigInteger("-5"), parser.nextBigIntegerValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber3BigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_3);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("-5"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(3.14159d), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4TypedDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(3.14159d, parser.nextDoubleValue(), 0.00000000001d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4TypedNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(3.14159d), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber4TypedBigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_4);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("3.14159"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(2e+10d), parser.nextValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5TypedDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(2e+10d, parser.nextDoubleValue(), 0.1d);
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5TypedNumber() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(Double.valueOf(2e+10d), parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber5TypedBigDecimal() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_5);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("2e+10"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObjectTest1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(new StringReader(OBJECT_TEST_1));

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("trueKey", parser.nextKey());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertTrue(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("falseKey", parser.nextKey());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertFalse(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("nullKey", parser.nextKey());
        Assert.assertEquals(ParseState.NULL_VALUE, parser.nextState());
        Assert.assertEquals(JSONObject.NULL, parser.nextValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("stringKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("hello world!", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("escapeStringKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("h\be\tllo w\u1234orld!", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("intKey", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(42, parser.nextIntValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("doubleKey", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(-23.45e67d, parser.nextDoubleValue(), 1.0d);
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObjectTest2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(new StringReader(OBJECT_TEST_2));

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("trueKey", parser.nextKey());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertTrue(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("falseKey", parser.nextKey());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertFalse(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("trueStrKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("true", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("falseStrKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("false", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("stringKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("hello world!", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("intKey", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(42, parser.nextIntValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("intStrKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("43", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("longKey", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(1234567890123456789L, parser.nextLongValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("longStrKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("987654321098765432", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("doubleKey", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(-23.45e7, parser.nextDoubleValue(), 1.0d);
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("doubleStrKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("00001.000", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("arrayKey", parser.nextKey());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(0, parser.nextIntValue());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(1, parser.nextIntValue());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(2, parser.nextIntValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("objectKey", parser.nextKey());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("myKey", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("myVal", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObjectTest3() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(new StringReader(OBJECT_TEST_3));

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("numberWithDecimals", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(parser.nextDoubleValue(), 299792.458d, 0.001d);
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("largeNumber", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigInteger("12345678901234567890"), parser.nextBigIntegerValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("preciseNumber", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(0.2d, parser.nextDoubleValue(), 0.001d);
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("largeExponent", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(new BigDecimal("-23.45e2327"), parser.nextBigDecimalValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testObjectTest3Append() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(new StringReader(OBJECT_TEST_3));
        StringBuilder builder = new StringBuilder();

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("numberWithDecimals", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        parser.appendNextNumberValue(builder);
        Assert.assertEquals("299792.457999999984", builder.toString());
        builder.delete(0, builder.length());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("largeNumber", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        parser.appendNextNumberValue(builder);
        Assert.assertEquals("12345678901234567890", builder.toString());
        builder.delete(0, builder.length());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("preciseNumber", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        parser.appendNextNumberValue(builder);
        Assert.assertEquals("0.2000000000000000111", builder.toString());
        builder.delete(0, builder.length());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("largeExponent", parser.nextKey());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        parser.appendNextNumberValue(builder);
        Assert.assertEquals("-23.45e2327", builder.toString());
        builder.delete(0, builder.length());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testArrayTest1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(new StringReader(ARRAY_TEST_1));

        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertTrue(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.BOOLEAN_VALUE, parser.nextState());
        Assert.assertFalse(parser.nextBooleanValue());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("true", parser.nextStringValue());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("false", parser.nextStringValue());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("hello", parser.nextStringValue());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(23.45e-4d, parser.nextDoubleValue(), 0.0000001d);
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("23.45", parser.nextStringValue());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(42, parser.nextIntValue());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("43", parser.nextStringValue());
        Assert.assertEquals(ParseState.ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("world", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key1", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("value1", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key2", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("value2", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key3", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("value3", parser.nextStringValue());
        Assert.assertEquals(ParseState.KEY, parser.nextState());
        Assert.assertEquals("key4", parser.nextKey());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("value4", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_OBJECT, parser.nextState());
        Assert.assertEquals(ParseState.NUMBER_VALUE, parser.nextState());
        Assert.assertEquals(0L, parser.nextLongValue());
        Assert.assertEquals(ParseState.STRING_VALUE, parser.nextState());
        Assert.assertEquals("-1", parser.nextStringValue());
        Assert.assertEquals(ParseState.END_ARRAY, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSubtree1() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(ARRAY_4);
        JSONArray firstArray = null;

        while(parser.hasNext()) {
            ParseState state = parser.nextState();
            if((state == ParseState.ARRAY) && (parser.getStackDepth() == 2)) {
                firstArray = JSONObjectBuilder.buildArraySubTree(parser);
                break;
            }
        }

        Assert.assertNotNull(firstArray);
        Assert.assertEquals(2, firstArray.length());
        Assert.assertNotNull(firstArray.getJSONObject(0));
        Assert.assertTrue(firstArray.getJSONObject(0).has("key"));
        Assert.assertFalse(firstArray.getBoolean(1));
    }

    @Test
    public void testSubtree2() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(OBJECT_5);
        JSONObject firstObject = null;

        while(parser.hasNext()) {
            ParseState state = parser.nextState();
            if((state == ParseState.OBJECT) && (parser.getStackDepth() == 2)) {
                firstObject = JSONObjectBuilder.buildObjectSubTree(parser);
                break;
            }
        }

        Assert.assertNotNull(firstObject);
        Assert.assertEquals(2, firstObject.length());
        Assert.assertNotNull(firstObject.get("a"));
        Assert.assertTrue(firstObject.has("b"));
    }

    @Test
    public void testSimpleNumber6NumberDouble() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_6);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertNotNull(parser.nextNumberValue());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.nextState());
    }

    @Test
    public void testSimpleNumber6Skip() throws Exception {
        JSONStreamReader parser = new JSONStreamReader(NUMBER_6);
        Assert.assertEquals(ParseState.DOCUMENT, parser.nextState());
        Assert.assertEquals(ParseState.VALUE, parser.nextState());
        Assert.assertEquals(ParseState.END_DOCUMENT, parser.skipToEndStructure());
    }
}

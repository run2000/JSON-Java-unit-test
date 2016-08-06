package org.json.junit;

import org.json.JSONArray;
import org.json.JSONWriter;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.io.IOException;

/**
 * @author JSON.org
 * @version 2016-08-04
 */
public class TestJSONWriter {

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

        System.out.println("Corpus length: " + CORPUS.length());
        System.out.println("Encoded length: " + a.getLength());
        System.out.println("Append calls: " + a.getCount());
        System.out.println("Biggest sequence: " + a.getBiggest());
        System.out.println("Single char appends: " + a.getSingleChars());
        System.out.println("Text: " + a.getText());

        JSONArray array = new JSONArray();
        array.put(CORPUS);
        a = new CountingAppender();

        array.write(a);

        System.out.println("Corpus length: " + CORPUS.length());
        System.out.println("Encoded length: " + a.getLength());
        System.out.println("Append calls: " + a.getCount());
        System.out.println("Biggest sequence: " + a.getBiggest());
        System.out.println("Single char appends: " + a.getSingleChars());
        System.out.println("Text: " + a.getText());
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
        JUnitCore.runClasses(TestJSONWriter.class);
        Thread.sleep(10000);
        long now = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++)
            JUnitCore.runClasses(TestJSONWriter.class);
        
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

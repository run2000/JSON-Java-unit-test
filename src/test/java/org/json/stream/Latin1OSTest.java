package org.json.stream;

import org.json.util.Latin1AppendableOutputStream;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * Test the Latin1AppendableOutputStream class.
 *
 * @author run2000
 * @version 2016-09-03
 */
public final class Latin1OSTest {

    @Test
    public void testBuffer() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (Latin1AppendableOutputStream test = new Latin1AppendableOutputStream(16).with(builder)) {
            test.write("This is a test.".getBytes(StandardCharsets.ISO_8859_1));
        }

        Assert.assertEquals("This is a test.", builder.toString());
    }

    @Test
    public void testBuffer1() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (Latin1AppendableOutputStream test = new Latin1AppendableOutputStream(16).with(builder)) {
            test.write("This is a test 123.".getBytes(StandardCharsets.ISO_8859_1));
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }

    @Test
    public void testBuffer2() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (Latin1AppendableOutputStream test = new Latin1AppendableOutputStream(16).with(builder)) {
            test.write("This is ".getBytes(StandardCharsets.ISO_8859_1));
            test.write("a test 123.".getBytes(StandardCharsets.ISO_8859_1));
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }

    @Test
    public void testBufferSub() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (Latin1AppendableOutputStream test = new Latin1AppendableOutputStream(16).with(builder)) {
            test.write("This is a test.".getBytes(StandardCharsets.ISO_8859_1), 0, 15);
        }

        Assert.assertEquals("This is a test.", builder.toString());
    }

    @Test
    public void testBufferChar() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (Latin1AppendableOutputStream test = new Latin1AppendableOutputStream(16).with(builder)) {
            test.write('T');
            test.write('h');
            test.write('i');
            test.write('s');
            test.write(' ');
            test.write('i');
            test.write('s');
            test.write(' ');
            test.write('a');
            test.write(' ');
            test.write('t');
            test.write('e');
            test.write('s');
            test.write('t');
            test.write(' ');
            test.write('1');
            test.write('2');
            test.write('3');
            test.write('.');
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }
}

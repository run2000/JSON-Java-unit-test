package org.json.stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the BufferedAppendable class.
 *
 * @author run2000
 * @version 2016-7-8
 */
public final class AppendableTest {

    @Test
    public void testBuffer() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append("This is a test.");
        }

        Assert.assertEquals("This is a test.", builder.toString());
    }

    @Test
    public void testBuffer1() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append("This is a test 123.");
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }

    @Test
    public void testBuffer2() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append("This is ");
            test.append("a test 123.");
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }
    @Test
    public void testBufferSub() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append("This is a test.", 0, 15);
        }

        Assert.assertEquals("This is a test.", builder.toString());
    }

    @Test
    public void testBuffer1Sub() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append("This is a test 123.", 0, 19);
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }

    @Test
    public void testBuffer2Sub() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append("This is a test 123.", 0, 8);
            test.append("This is a test 123.", 8, 19);
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }

    @Test
    public void testBuffer2Char() throws Exception {
        StringBuffer builder = new StringBuffer();

        try (BufferedAppendable test = new BufferedAppendable(16).with(builder)) {
            test.append('T');
            test.append('h');
            test.append('i');
            test.append('s');
            test.append(' ');
            test.append('i');
            test.append('s');
            test.append(' ');
            test.append('a');
            test.append(' ');
            test.append('t');
            test.append('e');
            test.append('s');
            test.append('t');
            test.append(' ');
            test.append('1');
            test.append('2');
            test.append('3');
            test.append('.');
        }

        Assert.assertEquals("This is a test 123.", builder.toString());
    }
}

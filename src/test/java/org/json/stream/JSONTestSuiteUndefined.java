package org.json.stream;

import org.json.JSONException;
import org.json.JSONStrictTokener;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author NCULL
 * @version 3/11/2016 4:40 PM.
 */
public class JSONTestSuiteUndefined {

    public JSONTestSuiteUndefined() {
    }

    @Test
    public void i_number_double_huge_neg_exp() throws Exception {
        String filename = "i_number_double_huge_neg_exp.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_huge_exp() throws Exception {
        String filename = "i_number_huge_exp.json";

        try {
            // number parses as infinity, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_neg_int_huge_exp() throws Exception {
        String filename = "i_number_neg_int_huge_exp.json";

        try {
            // number parses as minus infinity, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_pos_double_huge_exp() throws Exception {
        String filename = "i_number_pos_double_huge_exp.json";

        try {
            // number parses as infinity, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_real_neg_overflow() throws Exception {
        String filename = "i_number_real_neg_overflow.json";

        try {
            // number parses as minus infinity, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_real_pos_overflow() throws Exception {
        String filename = "i_number_real_pos_overflow.json";

        try {
            // number parses as infinity, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_real_underflow() throws Exception {
        String filename = "i_number_real_underflow.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_too_big_neg_int() throws Exception {
        String filename = "i_number_too_big_neg_int.json";

        try {
            // NumberFormatException thrown, too big for long value
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_too_big_pos_int() throws Exception {
        String filename = "i_number_too_big_pos_int.json";

        try {
            // NumberFormatException thrown, too big for long value
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_number_very_big_negative_int() throws Exception {
        String filename = "i_number_very_big_negative_int.json";

        try {
            // NumberFormatException thrown, too big for long value
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_object_key_lone_2nd_surrogate() throws Exception {
        String filename = "i_object_key_lone_2nd_surrogate.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_1st_surrogate_but_2nd_missing() throws Exception {
        String filename = "i_string_1st_surrogate_but_2nd_missing.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_1st_valid_surrogate_2nd_invalid() throws Exception {
        String filename = "i_string_1st_valid_surrogate_2nd_invalid.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_incomplete_surrogate_and_escape_valid() throws Exception {
        String filename = "i_string_incomplete_surrogate_and_escape_valid.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_incomplete_surrogate_pair() throws Exception {
        String filename = "i_string_incomplete_surrogate_pair.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_incomplete_surrogates_escape_valid() throws Exception {
        String filename = "i_string_incomplete_surrogates_escape_valid.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_invalid_lonely_surrogate() throws Exception {
        String filename = "i_string_invalid_lonely_surrogate.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_invalid_surrogate() throws Exception {
        String filename = "i_string_invalid_surrogate.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_inverted_surrogates_Uplus1D11E() throws Exception {
        String filename = "i_string_inverted_surrogates_U+1D11E.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_lone_second_surrogate() throws Exception {
        String filename = "i_string_lone_second_surrogate.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_not_in_unicode_range() throws Exception {
        String filename = "i_string_not_in_unicode_range.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_truncated_utf8() throws Exception {
        String filename = "i_string_truncated-utf-8.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_unicode_Uplus1FFFE_nonchar() throws Exception {
        String filename = "i_string_unicode_U+1FFFE_nonchar.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_unicode_Uplus10FFFE_nonchar() throws Exception {
        String filename = "i_string_unicode_U+10FFFE_nonchar.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_unicode_UplusFDD0_nonchar() throws Exception {
        String filename = "i_string_unicode_U+FDD0_nonchar.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_unicode_UplusFFFE_nonchar() throws Exception {
        String filename = "i_string_unicode_U+FFFE_nonchar.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_UTF8_invalid_sequence() throws Exception {
        String filename = "i_string_UTF-8_invalid_sequence.json";

        try {
            // UTF-8 decoding swallows close quote, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_string_UTF16LE_with_BOM() throws Exception {
        String filename = "i_string_UTF-16LE_with_BOM.json";

        try {
            // Byte order mark found, exception thrown
            runTest(filename, StandardCharsets.UTF_16LE);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_structure_500_nested_arrays() throws Exception {
        String filename = "i_structure_500_nested_arrays.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    public void i_structure_UTF8_BOM_empty_object() throws Exception {
        String filename = "i_structure_UTF-8_BOM_empty_object.json";

        try {
            // Byte order mark found, exception thrown
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // pass
        }
    }

    private Object runTest(String filename, Charset encoding) throws Exception {

        try (InputStream inputStream = this.getClass().getResourceAsStream("/" + filename)) {
            Object result = JSONStrictTokener.parseJSONValue(inputStream, encoding);
            System.out.println(result);
            return result;
        }
    }
}

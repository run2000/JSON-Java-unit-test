package org.json.stream;

import org.json.JSONException;
import org.json.JSONStrictTokener;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author NCULL
 * @version 3/11/2016 11:41 AM.
 */
public final class JSONTestSuitePass {

    public JSONTestSuitePass() {
    }

    @Test
    public void y_array_arraysWithSpaces() throws Exception {
        String filename = "y_array_arraysWithSpaces.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_empty() throws Exception {
        String filename = "y_array_empty.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_empty_string() throws Exception {
        String filename = "y_array_empty-string.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_ending_with_newline() throws Exception {
        String filename = "y_array_ending_with_newline.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_false() throws Exception {
        String filename = "y_array_false.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_heterogeneous() throws Exception {
        String filename = "y_array_heterogeneous.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_null() throws Exception {
        String filename = "y_array_null.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_with_1_and_newline() throws Exception {
        String filename = "y_array_with_1_and_newline.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_with_leading_space() throws Exception {
        String filename = "y_array_with_leading_space.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_with_several_null() throws Exception {
        String filename = "y_array_with_several_null.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_array_with_trailing_space() throws Exception {
        String filename = "y_array_with_trailing_space.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number() throws Exception {
        String filename = "y_number.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_0ePlus1() throws Exception {
        String filename = "y_number_0e+1.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_0e1() throws Exception {
        String filename = "y_number_0e1.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_after_space() throws Exception {
        String filename = "y_number_after_space.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_double_close_to_zero() throws Exception {
        String filename = "y_number_double_close_to_zero.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_int_with_exp() throws Exception {
        String filename = "y_number_int_with_exp.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_minus_zero() throws Exception {
        String filename = "y_number_minus_zero.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_negative_int() throws Exception {
        String filename = "y_number_negative_int.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_negative_one() throws Exception {
        String filename = "y_number_negative_one.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_negative_zero() throws Exception {
        String filename = "y_number_negative_zero.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_capital_e() throws Exception {
        String filename = "y_number_real_capital_e.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_capital_e_neg_exp() throws Exception {
        String filename = "y_number_real_capital_e_neg_exp.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_capital_e_pos_exp() throws Exception {
        String filename = "y_number_real_capital_e_pos_exp.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_exponent() throws Exception {
        String filename = "y_number_real_exponent.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_fraction_exponent() throws Exception {
        String filename = "y_number_real_fraction_exponent.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_neg_exp() throws Exception {
        String filename = "y_number_real_neg_exp.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_real_pos_exponent() throws Exception {
        String filename = "y_number_real_pos_exponent.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_simple_int() throws Exception {
        String filename = "y_number_simple_int.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_number_simple_real() throws Exception {
        String filename = "y_number_simple_real.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object() throws Exception {
        String filename = "y_object.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_basic() throws Exception {
        String filename = "y_object_basic.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_duplicated_key() throws Exception {
        String filename = "y_object_duplicated_key.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // succeeds, allowed to throw an error
        }
    }

    @Test
    public void y_object_duplicated_key_and_value() throws Exception {
        String filename = "y_object_duplicated_key_and_value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
        } catch (JSONException e) {
            // succeeds, allowed to throw an error
        }
    }

    @Test
    public void y_object_empty() throws Exception {
        String filename = "y_object_empty.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_empty_key() throws Exception {
        String filename = "y_object_empty_key.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_escaped_null_in_key() throws Exception {
        String filename = "y_object_escaped_null_in_key.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_extreme_numbers() throws Exception {
        String filename = "y_object_extreme_numbers.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_long_strings() throws Exception {
        String filename = "y_object_long_strings.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_simple() throws Exception {
        String filename = "y_object_simple.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_string_unicode() throws Exception {
        String filename = "y_object_string_unicode.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_object_with_newlines() throws Exception {
        String filename = "y_object_with_newlines.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_1_2_3_bytes_UTF8_sequences() throws Exception {
        String filename = "y_string_1_2_3_bytes_UTF-8_sequences.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_accepted_surrogate_pair() throws Exception {
        String filename = "y_string_accepted_surrogate_pair.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_accepted_surrogate_pairs() throws Exception {
        String filename = "y_string_accepted_surrogate_pairs.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_allowed_escapes() throws Exception {
        String filename = "y_string_allowed_escapes.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_backslash_and_u_escaped_zero() throws Exception {
        String filename = "y_string_backslash_and_u_escaped_zero.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_backslash_doublequotes() throws Exception {
        String filename = "y_string_backslash_doublequotes.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_comments() throws Exception {
        String filename = "y_string_comments.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_double_escape_a() throws Exception {
        String filename = "y_string_double_escape_a.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_double_escape_n() throws Exception {
        String filename = "y_string_double_escape_n.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_escaped_control_character() throws Exception {
        String filename = "y_string_escaped_control_character.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_escaped_noncharacter() throws Exception {
        String filename = "y_string_escaped_noncharacter.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_in_array() throws Exception {
        String filename = "y_string_in_array.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_in_array_with_leading_space() throws Exception {
        String filename = "y_string_in_array_with_leading_space.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_last_surrogates_1_and_2() throws Exception {
        String filename = "y_string_last_surrogates_1_and_2.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_nbsp_uescaped() throws Exception {
        String filename = "y_string_nbsp_uescaped.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_nonCharacterInUTF8_Uplus1FFFF() throws Exception {
        String filename = "y_string_nonCharacterInUTF-8_U+1FFFF.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_nonCharacterInUTF8_Uplus10FFFF() throws Exception {
        String filename = "y_string_nonCharacterInUTF-8_U+10FFFF.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_nonCharacterInUTF8_UplusFFFF() throws Exception {
        String filename = "y_string_nonCharacterInUTF-8_U+FFFF.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_null_escape() throws Exception {
        String filename = "y_string_null_escape.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_one_byte_utf8() throws Exception {
        String filename = "y_string_one-byte-utf-8.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_pi() throws Exception {
        String filename = "y_string_pi.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_simple_ascii() throws Exception {
        String filename = "y_string_simple_ascii.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_space() throws Exception {
        String filename = "y_string_space.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_surrogates_Uplus1D11E_MUSICAL_SYMBOL_G_CLEF() throws Exception {
        String filename = "y_string_surrogates_U+1D11E_MUSICAL_SYMBOL_G_CLEF.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_three_byte_utf8() throws Exception {
        String filename = "y_string_three-byte-utf-8.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_two_byte_utf8() throws Exception {
        String filename = "y_string_two-byte-utf-8.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_uPlus2028_line_sep() throws Exception {
        String filename = "y_string_u+2028_line_sep.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_uPlus2029_par_sep() throws Exception {
        String filename = "y_string_u+2029_par_sep.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_uEscape() throws Exception {
        String filename = "y_string_uEscape.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_uescaped_newline() throws Exception {
        String filename = "y_string_uescaped_newline.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unescaped_char_delete() throws Exception {
        String filename = "y_string_unescaped_char_delete.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unicode() throws Exception {
        String filename = "y_string_unicode.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unicode_2() throws Exception {
        String filename = "y_string_unicode_2.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unicode_escaped_double_quote() throws Exception {
        String filename = "y_string_unicode_escaped_double_quote.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unicode_Uplus200B_ZERO_WIDTH_SPACE() throws Exception {
        String filename = "y_string_unicode_U+200B_ZERO_WIDTH_SPACE.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unicode_Uplus2064_invisible_plus() throws Exception {
        String filename = "y_string_unicode_U+2064_invisible_plus.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_unicodeEscapedBackslash() throws Exception {
        String filename = "y_string_unicodeEscapedBackslash.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_utf8() throws Exception {
        String filename = "y_string_utf8.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_string_utf16BE_no_BOM() throws Exception {
        String filename = "y_string_utf16BE_no_BOM.json";

        runTest(filename, StandardCharsets.UTF_16BE);
    }

    @Test
    public void y_string_utf16LE_no_BOM() throws Exception {
        String filename = "y_string_utf16LE_no_BOM.json";

        runTest(filename, StandardCharsets.UTF_16LE);
    }

    @Test
    public void y_string_with_del_character() throws Exception {
        String filename = "y_string_with_del_character.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_lonely_false() throws Exception {
        String filename = "y_structure_lonely_false.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_lonely_int() throws Exception {
        String filename = "y_structure_lonely_int.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_lonely_negative_real() throws Exception {
        String filename = "y_structure_lonely_negative_real.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_lonely_null() throws Exception {
        String filename = "y_structure_lonely_null.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_lonely_string() throws Exception {
        String filename = "y_structure_lonely_string.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_lonely_true() throws Exception {
        String filename = "y_structure_lonely_true.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_string_empty() throws Exception {
        String filename = "y_structure_string_empty.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_trailing_newline() throws Exception {
        String filename = "y_structure_trailing_newline.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_true_in_array() throws Exception {
        String filename = "y_structure_true_in_array.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    @Test
    public void y_structure_whitespace_array() throws Exception {
        String filename = "y_structure_whitespace_array.json";

        runTest(filename, StandardCharsets.UTF_8);
    }

    private Object runTest(String filename, Charset encoding) throws Exception {

        try (InputStream inputStream = getClass().getResourceAsStream("/" + filename)) {
            Object result = JSONStrictTokener.parseJSONValue(inputStream, encoding);
            System.out.println(result);
            return result;
        }
    }
}

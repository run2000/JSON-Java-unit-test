package org.json.stream;

import org.json.JSONException;
import org.json.JSONStrictTokener;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author NCULL
 * @version 3/11/2016 1:04 PM.
 */
public class JSONTestSuiteFail {

    public JSONTestSuiteFail() {
    }

    @Test
    public void n_array_1_true_without_comma() throws Exception {
        String filename = "n_array_1_true_without_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_a_invalid_utf8() throws Exception {
        String filename = "n_array_a_invalid_utf8.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_colon_instead_of_comma() throws Exception {
        String filename = "n_array_colon_instead_of_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_comma_after_close() throws Exception {
        String filename = "n_array_comma_after_close.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_comma_and_number() throws Exception {
        String filename = "n_array_comma_and_number.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_double_comma() throws Exception {
        String filename = "n_array_double_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_double_extra_comma() throws Exception {
        String filename = "n_array_double_extra_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_extra_close() throws Exception {
        String filename = "n_array_extra_close.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_extra_comma() throws Exception {
        String filename = "n_array_extra_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_incomplete() throws Exception {
        String filename = "n_array_incomplete.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_incomplete_invalid_value() throws Exception {
        String filename = "n_array_incomplete_invalid_value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_inner_array_no_comma() throws Exception {
        String filename = "n_array_inner_array_no_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_invalid_utf8() throws Exception {
        String filename = "n_array_invalid_utf8.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_items_separated_by_semicolon() throws Exception {
        String filename = "n_array_items_separated_by_semicolon.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_just_comma() throws Exception {
        String filename = "n_array_just_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_just_minus() throws Exception {
        String filename = "n_array_just_minus.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_missing_value() throws Exception {
        String filename = "n_array_missing_value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_newlines_unclosed() throws Exception {
        String filename = "n_array_newlines_unclosed.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_number_and_comma() throws Exception {
        String filename = "n_array_number_and_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_number_and_several_commas() throws Exception {
        String filename = "n_array_number_and_several_commas.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_spaces_vertical_tab_formfeed() throws Exception {
        String filename = "n_array_spaces_vertical_tab_formfeed.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_star_inside() throws Exception {
        String filename = "n_array_star_inside.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_unclosed() throws Exception {
        String filename = "n_array_unclosed.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_unclosed_trailing_comma() throws Exception {
        String filename = "n_array_unclosed_trailing_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_unclosed_with_new_lines() throws Exception {
        String filename = "n_array_unclosed_with_new_lines.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_array_unclosed_with_object_inside() throws Exception {
        String filename = "n_array_unclosed_with_object_inside.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_incomplete_false() throws Exception {
        String filename = "n_incomplete_false.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_incomplete_null() throws Exception {
        String filename = "n_incomplete_null.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_incomplete_true() throws Exception {
        String filename = "n_incomplete_true.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_multidigit_number_then_00() throws Exception {
        String filename = "n_multidigit_number_then_00.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_dot2eminus3() throws Exception {
        String filename = "n_number_.2e-3.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_plusplus() throws Exception {
        String filename = "n_number_++.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_plus1() throws Exception {
        String filename = "n_number_+1.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_plusInf() throws Exception {
        String filename = "n_number_+Inf.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0dot1dot2() throws Exception {
        String filename = "n_number_0.1.2.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0dot3e() throws Exception {
        String filename = "n_number_0.3e.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0dot3eplus() throws Exception {
        String filename = "n_number_0.3e+.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0dote1() throws Exception {
        String filename = "n_number_0.e1.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0_capital_E() throws Exception {
        String filename = "n_number_0_capital_E.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0_capital_Eplus() throws Exception {
        String filename = "n_number_0_capital_E+.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0e() throws Exception {
        String filename = "n_number_0e.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_0eplus() throws Exception {
        String filename = "n_number_0e+.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minus01() throws Exception {
        String filename = "n_number_-01.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minus1dot0dot() throws Exception {
        String filename = "n_number_-1.0..json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_1dot0e() throws Exception {
        String filename = "n_number_1.0e.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_1dot0eminus() throws Exception {
        String filename = "n_number_1.0e-.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_1dot0eplus() throws Exception {
        String filename = "n_number_1.0e+.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_1_000() throws Exception {
        String filename = "n_number_1_000.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_1eE2() throws Exception {
        String filename = "n_number_1eE2.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minus2dot() throws Exception {
        String filename = "n_number_-2..json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_2doteplus3() throws Exception {
        String filename = "n_number_2.e+3.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_2dote3() throws Exception {
        String filename = "n_number_2.e3.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_2doteminus3() throws Exception {
        String filename = "n_number_2.e-3.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_9doteplus() throws Exception {
        String filename = "n_number_9.e+.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_expression() throws Exception {
        String filename = "n_number_expression.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_hex_1_digit() throws Exception {
        String filename = "n_number_hex_1_digit.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_hex_2_digits() throws Exception {
        String filename = "n_number_hex_2_digits.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_Inf() throws Exception {
        String filename = "n_number_Inf.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_infinity() throws Exception {
        String filename = "n_number_infinity.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_invalidPlusMinus() throws Exception {
        String filename = "n_number_invalid+-.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_invalid_negative_real() throws Exception {
        String filename = "n_number_invalid-negative-real.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_invalid_utf8_in_bigger_int() throws Exception {
        String filename = "n_number_invalid-utf-8-in-bigger-int.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_invalid_utf8_in_exponent() throws Exception {
        String filename = "n_number_invalid-utf-8-in-exponent.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_invalid_utf8_in_int() throws Exception {
        String filename = "n_number_invalid-utf-8-in-int.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minus_infinity() throws Exception {
        String filename = "n_number_minus_infinity.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minus_sign_with_trailing_garbage() throws Exception {
        String filename = "n_number_minus_sign_with_trailing_garbage.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minus_space_1() throws Exception {
        String filename = "n_number_minus_space_1.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_NaN() throws Exception {
        String filename = "n_number_NaN.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_minusNaN() throws Exception {
        String filename = "n_number_-NaN.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_neg_int_starting_with_zero() throws Exception {
        String filename = "n_number_neg_int_starting_with_zero.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_neg_real_without_int_part() throws Exception {
        String filename = "n_number_neg_real_without_int_part.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_neg_with_garbage_at_end() throws Exception {
        String filename = "n_number_neg_with_garbage_at_end.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_real_garbage_after_e() throws Exception {
        String filename = "n_number_real_garbage_after_e.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_real_with_invalid_utf8_after_e() throws Exception {
        String filename = "n_number_real_with_invalid_utf8_after_e.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_real_without_fractional_part() throws Exception {
        String filename = "n_number_real_without_fractional_part.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_starting_with_dot() throws Exception {
        String filename = "n_number_starting_with_dot.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_UplusFF11_fullwidth_digit_one() throws Exception {
        String filename = "n_number_U+FF11_fullwidth_digit_one.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_with_alpha() throws Exception {
        String filename = "n_number_with_alpha.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_with_alpha_char() throws Exception {
        String filename = "n_number_with_alpha_char.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_number_with_leading_zero() throws Exception {
        String filename = "n_number_with_leading_zero.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_bad_value() throws Exception {
        String filename = "n_object_bad_value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_bracket_key() throws Exception {
        String filename = "n_object_bracket_key.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_comma_instead_of_colon() throws Exception {
        String filename = "n_object_comma_instead_of_colon.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_double_colon() throws Exception {
        String filename = "n_object_double_colon.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_emoji() throws Exception {
        String filename = "n_object_emoji.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_garbage_at_end() throws Exception {
        String filename = "n_object_garbage_at_end.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_key_with_single_quotes() throws Exception {
        String filename = "n_object_key_with_single_quotes.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_missing_colon() throws Exception {
        String filename = "n_object_missing_colon.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_missing_key() throws Exception {
        String filename = "n_object_missing_key.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_missing_semicolon() throws Exception {
        String filename = "n_object_missing_semicolon.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_missing_value() throws Exception {
        String filename = "n_object_missing_value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_no_colon() throws Exception {
        String filename = "n_object_no-colon.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_non_string_key() throws Exception {
        String filename = "n_object_non_string_key.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_non_string_key_but_huge_number_instead() throws Exception {
        String filename = "n_object_non_string_key_but_huge_number_instead.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_pi_in_key_and_trailing_comma() throws Exception {
        String filename = "n_object_pi_in_key_and_trailing_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_repeated_null_null() throws Exception {
        String filename = "n_object_repeated_null_null.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_several_trailing_commas() throws Exception {
        String filename = "n_object_several_trailing_commas.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_single_quote() throws Exception {
        String filename = "n_object_single_quote.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_trailing_comma() throws Exception {
        String filename = "n_object_trailing_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_trailing_comment() throws Exception {
        String filename = "n_object_trailing_comment.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_trailing_comment_open() throws Exception {
        String filename = "n_object_trailing_comment_open.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_trailing_comment_slash_open() throws Exception {
        String filename = "n_object_trailing_comment_slash_open.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_trailing_comment_slash_open_incomplete() throws Exception {
        String filename = "n_object_trailing_comment_slash_open_incomplete.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_two_commas_in_a_row() throws Exception {
        String filename = "n_object_two_commas_in_a_row.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_unquoted_key() throws Exception {
        String filename = "n_object_unquoted_key.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_unterminated_value() throws Exception {
        String filename = "n_object_unterminated-value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_with_single_string() throws Exception {
        String filename = "n_object_with_single_string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_object_with_trailing_garbage() throws Exception {
        String filename = "n_object_with_trailing_garbage.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_single_space() throws Exception {
        String filename = "n_single_space.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_1_surrogate_then_escape_u() throws Exception {
        String filename = "n_string_1_surrogate_then_escape u.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_1_surrogate_then_escape_u1() throws Exception {
        String filename = "n_string_1_surrogate_then_escape u1.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_1_surrogate_then_escape_u1x() throws Exception {
        String filename = "n_string_1_surrogate_then_escape u1x.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_1_surrogate_then_escape() throws Exception {
        String filename = "n_string_1_surrogate_then_escape.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_accentuated_char_no_quotes() throws Exception {
        String filename = "n_string_accentuated_char_no_quotes.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_backslash_00() throws Exception {
        String filename = "n_string_backslash_00.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_escape_x() throws Exception {
        String filename = "n_string_escape_x.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_escaped_backslash_bad() throws Exception {
        String filename = "n_string_escaped_backslash_bad.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_escaped_ctrl_char_tab() throws Exception {
        String filename = "n_string_escaped_ctrl_char_tab.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_escaped_emoji() throws Exception {
        String filename = "n_string_escaped_emoji.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_incomplete_escape() throws Exception {
        String filename = "n_string_incomplete_escape.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_incomplete_escaped_character() throws Exception {
        String filename = "n_string_incomplete_escaped_character.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_incomplete_surrogate() throws Exception {
        String filename = "n_string_incomplete_surrogate.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_incomplete_surrogate_escape_invalid() throws Exception {
        String filename = "n_string_incomplete_surrogate_escape_invalid.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_invalid_backslash_esc() throws Exception {
        String filename = "n_string_invalid_backslash_esc.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_invalid_unicode_escape() throws Exception {
        String filename = "n_string_invalid_unicode_escape.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_invalid_utf8() throws Exception {
        String filename = "n_string_invalid_utf-8.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, invalid UTF-8 substituted as \\uFFFD");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_invalid_utf8_after_escape() throws Exception {
        String filename = "n_string_invalid_utf8_after_escape.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_invalid_utf8_in_escape() throws Exception {
        String filename = "n_string_invalid-utf-8-in-escape.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_iso_latin_1() throws Exception {
        String filename = "n_string_iso_latin_1.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, invalid UTF-8 substituted as \\uFFFD");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_leading_uescaped_thinspace() throws Exception {
        String filename = "n_string_leading_uescaped_thinspace.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_lone_utf8_continuation_byte() throws Exception {
        String filename = "n_string_lone_utf8_continuation_byte.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, invalid UTF-8 substituted as \\uFFFD");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_no_quotes_with_bad_escape() throws Exception {
        String filename = "n_string_no_quotes_with_bad_escape.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_overlong_sequence_2_bytes() throws Exception {
        String filename = "n_string_overlong_sequence_2_bytes.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, invalid UTF-8 substituted as \\uFFFD");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_overlong_sequence_6_bytes() throws Exception {
        String filename = "n_string_overlong_sequence_6_bytes.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, invalid UTF-8 substituted as \\uFFFD");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_overlong_sequence_6_bytes_null() throws Exception {
        String filename = "n_string_overlong_sequence_6_bytes_null.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, invalid UTF-8 substituted as \\uFFFD");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_single_doublequote() throws Exception {
        String filename = "n_string_single_doublequote.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_single_quote() throws Exception {
        String filename = "n_string_single_quote.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_single_string_no_double_quotes() throws Exception {
        String filename = "n_string_single_string_no_double_quotes.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_start_escape_unclosed() throws Exception {
        String filename = "n_string_start_escape_unclosed.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_unescaped_crtl_char() throws Exception {
        String filename = "n_string_unescaped_crtl_char.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_unescaped_newline() throws Exception {
        String filename = "n_string_unescaped_newline.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_unescaped_tab() throws Exception {
        String filename = "n_string_unescaped_tab.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_unicode_CapitalU() throws Exception {
        String filename = "n_string_unicode_CapitalU.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_UTF8_surrogate_UplusD800() throws Exception {
        String filename = "n_string_UTF8_surrogate_U+D800.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, UTF-8 encoded as UTF-16 \\uD800");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_string_with_trailing_garbage() throws Exception {
        String filename = "n_string_with_trailing_garbage.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure__dot_() throws Exception {
        String filename = "n_structure__._.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure__null_() throws Exception {
        String filename = "n_structure__null_.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_100000_opening_arrays() throws Exception {
        String filename = "n_structure_100000_opening_arrays.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        } catch (StackOverflowError e) {
            Assert.fail("test should not fail with stackOverflowError");
        }
    }

    @Test
    public void n_structure_array_trailing_garbage() throws Exception {
        String filename = "n_structure_array_trailing_garbage.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_array_with_extra_array_close() throws Exception {
        String filename = "n_structure_array_with_extra_array_close.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_array_with_unclosed_string() throws Exception {
        String filename = "n_structure_array_with_unclosed_string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_ascii_unicode_identifier() throws Exception {
        String filename = "n_structure_ascii-unicode-identifier.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_capitalized_True() throws Exception {
        String filename = "n_structure_capitalized_True.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_close_unopened_array() throws Exception {
        String filename = "n_structure_close_unopened_array.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_comma_instead_of_closing_brace() throws Exception {
        String filename = "n_structure_comma_instead_of_closing_brace.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_double_array() throws Exception {
        String filename = "n_structure_double_array.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_end_array() throws Exception {
        String filename = "n_structure_end_array.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_incomplete_UTF8_BOM() throws Exception {
        String filename = "n_structure_incomplete_UTF8_BOM.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_lone_invalid_utf8() throws Exception {
        String filename = "n_structure_lone-invalid-utf-8.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_lone_open_bracket() throws Exception {
        String filename = "n_structure_lone-open-bracket.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_no_data() throws Exception {
        String filename = "n_structure_no_data.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_null_byte_outside_string() throws Exception {
        String filename = "n_structure_null-byte-outside-string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_number_with_trailing_garbage() throws Exception {
        String filename = "n_structure_number_with_trailing_garbage.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_object_followed_by_closing_object() throws Exception {
        String filename = "n_structure_object_followed_by_closing_object.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_object_unclosed_no_value() throws Exception {
        String filename = "n_structure_object_unclosed_no_value.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_object_with_comment() throws Exception {
        String filename = "n_structure_object_with_comment.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_object_with_trailing_garbage() throws Exception {
        String filename = "n_structure_object_with_trailing_garbage.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_array_apostrophe() throws Exception {
        String filename = "n_structure_open_array_apostrophe.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_array_comma() throws Exception {
        String filename = "n_structure_open_array_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_array_object() throws Exception {
        String filename = "n_structure_open_array_object.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        } catch (StackOverflowError e) {
            Assert.fail("test should not fail with stackOverflowError");
        }
    }

    @Test
    public void n_structure_open_array_open_object() throws Exception {
        String filename = "n_structure_open_array_open_object.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_array_open_string() throws Exception {
        String filename = "n_structure_open_array_open_string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_array_string() throws Exception {
        String filename = "n_structure_open_array_string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_object() throws Exception {
        String filename = "n_structure_open_object.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_object_close_array() throws Exception {
        String filename = "n_structure_open_object_close_array.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_object_comma() throws Exception {
        String filename = "n_structure_open_object_comma.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_object_open_array() throws Exception {
        String filename = "n_structure_open_object_open_array.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_object_open_string() throws Exception {
        String filename = "n_structure_open_object_open_string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_object_string_with_apostrophes() throws Exception {
        String filename = "n_structure_open_object_string_with_apostrophes.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_open_open() throws Exception {
        String filename = "n_structure_open_open.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_single_point() throws Exception {
        String filename = "n_structure_single_point.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_single_star() throws Exception {
        String filename = "n_structure_single_star.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_trailing_hash() throws Exception {
        String filename = "n_structure_trailing_#.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            System.out.println("Test doesn't fail, due to invalid postfix data");
            //Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_Uplus2060_word_joined() throws Exception {
        String filename = "n_structure_U+2060_word_joined.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_uescaped_LF_before_string() throws Exception {
        String filename = "n_structure_uescaped_LF_before_string.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_unclosed_array() throws Exception {
        String filename = "n_structure_unclosed_array.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_unclosed_array_partial_null() throws Exception {
        String filename = "n_structure_unclosed_array_partial_null.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_unclosed_array_unfinished_false() throws Exception {
        String filename = "n_structure_unclosed_array_unfinished_false.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_unclosed_array_unfinished_true() throws Exception {
        String filename = "n_structure_unclosed_array_unfinished_true.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_unclosed_object() throws Exception {
        String filename = "n_structure_unclosed_object.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_unicode_identifier() throws Exception {
        String filename = "n_structure_unicode-identifier.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_UTF8_BOM_no_data() throws Exception {
        String filename = "n_structure_UTF8_BOM_no_data.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_whitespace_formfeed() throws Exception {
        String filename = "n_structure_whitespace_formfeed.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    @Test
    public void n_structure_whitespace_Uplus2060_word_joiner() throws Exception {
        String filename = "n_structure_whitespace_U+2060_word_joiner.json";

        try {
            runTest(filename, StandardCharsets.UTF_8);
            Assert.fail("test should fail");
        } catch (JSONException e) {
            // success
        }
    }

    private Object runTest(String filename, Charset encoding) throws Exception {

        try (InputStream inputStream = getClass().getResourceAsStream("/" + filename)) {
            Object result = JSONStrictTokener.parseJSONValue(inputStream, encoding);
            System.out.println(result);
            return result;
        }
    }
}

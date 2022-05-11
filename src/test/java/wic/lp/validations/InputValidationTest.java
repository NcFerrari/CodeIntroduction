package wic.lp.validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InputValidationTest {
    @Test
    void validateCountOfParameters() throws ValidationException {
        Assertions.assertThrows(ValidationException.class, () ->
                InputValidation.validateCountOfParameters(new String[]{"1"}), "Bad count of input parameters");
        Assertions.assertThrows(ValidationException.class, () ->
                InputValidation.validateCountOfParameters(new String[]{"1", "2", "3"}), "Bad count of input parameters");
        assertTrue(InputValidation.validateCountOfParameters(new String[]{"1", "2"}));
    }

    @Test
    void validateURL() {
        Assertions.assertThrows(NullPointerException.class, () ->
                InputValidation.validateURL(null), "URL must not be null!");
        Assertions.assertThrows(ValidationException.class, () -> InputValidation.validateURL("httpx://google.com"),
                "URL: httpx://google.com is not valid. URL must be like: http://www.address.com");
        Assertions.assertThrows(ValidationException.class, () -> InputValidation.validateURL("http://google.c"),
                "URL: http://google.c is not valid. URL must be like: http://www.address.com");
        Assertions.assertThrows(ValidationException.class, () -> InputValidation.validateURL("http://.com"),
                "URL: http://.com is not valid. URL must be like: http://www.address.com");
    }
}

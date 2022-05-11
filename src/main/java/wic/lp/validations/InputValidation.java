package wic.lp.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    private static final Logger LOGGER = LoggerFactory.getLogger(InputValidation.class);
    //RULES
    private static final int PARAMETERS_COUNT = 2;
    private static final String REGEX = "http[s]?://.+\\.[a-z]{2,3}";
    //================================================ ATRIBUTY TRIDY ==================================================
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================
    //================================================= METODY TRIDY ===================================================

    /**
     * Check count of parameters.
     *
     * @param arguments
     * @throws ValidationException
     */
    public static boolean validateCountOfParameters(String[] arguments) throws ValidationException {
        if (arguments.length != PARAMETERS_COUNT) {
            throw new ValidationException("Bad count of input parameters");
        }
        LOGGER.debug("Parameters OK");
        return true;
    }

    /**
     * Check basic regex of input URL
     *
     * @param url (excepted format: http://www.web.domain
     */
    public static void validateURL(String url) throws ValidationException {
        //Following condition is not necessary because null pointer check is validated by validateCountOfParameters
        // method. Here is it if this method will be use separately.
        if (url == null) {
            throw new NullPointerException("URL must not be null!");
        }
        Pattern pat = Pattern.compile(REGEX);
        Matcher mat = pat.matcher(url);
        if (!mat.matches()) {
            throw new ValidationException(String.format("URL: %s is not valid. URL must be like: http://www.address.com",
                    url));
        }
    }

    //================================================== KONSTRUKTOR ===================================================

    private InputValidation() {
    }

    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}

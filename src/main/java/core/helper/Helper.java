package core.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Helper {

    public static String convertCamelCasesToSpaces(String camelCasesString) {
        return StringUtils.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(camelCasesString), StringUtils.SPACE));
    }

}

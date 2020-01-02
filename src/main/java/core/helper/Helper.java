package core.helper;

import org.apache.commons.lang3.StringUtils;

public class Helper {

    public static String convertCamelCasesToNormal(String camelCasesString) {
        return StringUtils.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(camelCasesString), StringUtils.SPACE));
    }
}

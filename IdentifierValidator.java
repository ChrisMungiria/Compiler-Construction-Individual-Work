import java.util.regex.Pattern;

public class IdentifierValidator {

    public static void main(String[] args) {
        // 'String' is not a valid Java identifier as it is a reserved keyword
        String invalid = "String"; 
        // 'name' is a valud Java identifier as it follows the rules of a valid identifier
        String valid = "name";
        
        // These two test whether the functions are working
        if (isValidIdentifier(invalid)) {
            System.out.println(invalid + " is a valid Java identifier.");
        } else {
            System.out.println(invalid + " is not a valid Java identifier.");
        }
        if (isValidIdentifier(valid)) {
            System.out.println(valid + " is a valid Java identifier.");
        } else {
            System.out.println(valid + " is not a valid Java identifier.");
        }
    }

    // 
    public static boolean isValidIdentifier(String identifier) {
        // Regular expression for a valid Java identifier
        // The only allowed characters for identifiers are all alphanumeric characters([A-Z],[a-z],[0-9]), ‘$‘(dollar sign) and ‘_‘ (underscore)
        String pattern = "^[a-zA-Z_$][a-zA-Z0-9_$]*$";

        // Array of Java reserved keywords
        String[] reservedKeywords = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while", "String", "int", "float"
        };

        // Check if the identifier matches the pattern and is not a reserved keyword
        return Pattern.matches(pattern, identifier) && !isReservedKeyword(identifier, reservedKeywords);
    }

    public static boolean isReservedKeyword(String identifier, String[] reservedKeywords) {
        // Check if the identifier is a reserved keyword
        for (String keyword : reservedKeywords) {
            if (identifier.equals(keyword)) {
                return true;
            }
        }
        return false;
    }
}

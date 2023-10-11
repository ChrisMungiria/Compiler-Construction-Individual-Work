import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommentIdentifier {

    public static void main(String[] args) {
        // Here is a list of strings we can use to test if our functions are. working properly
        String commentText = "//This is a comment";
        String notCommentText = "This is not a comment";
        String commentText2 = "/*This is another comment*/";
        
        // testing the various strings in action
        if(isComment(commentText)){
            System.out.println("The text '" + commentText + "', is a comment");
        }else{
            System.out.println("The text :" + commentText + ", is not a comment");
        }
        // To print on the following line
        System.out.println('\n');
        
        if(isComment(notCommentText)){
            System.out.println("The text '" + notCommentText + "', is a comment");
        }else{
            System.out.println("The text '" + notCommentText + "', is not a comment");
        }
        
        System.out.println('\n');
        
        if(isComment(commentText2)){
            System.out.println("The text '" + commentText2 + "', is a comment");
        }else{
            System.out.println("The text '" + commentText2 + "', is not a comment");
        }
    }
    
    // This is a boolean method that returns either true or false
    public static boolean isComment(String line) {
        // Regular expressions for comment patterns in Java
        String singleLineCommentPattern = "//.*";
        String multiLineCommentStartPattern = "/\\*.*";
        String multiLineCommentEndPattern = ".*\\*/";

        // Check if the line matches any of the comment patterns
        return Pattern.matches(singleLineCommentPattern, line)
                || Pattern.matches(multiLineCommentStartPattern, line)
                || Pattern.matches(multiLineCommentEndPattern, line);
    }
}

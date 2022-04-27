package model;

import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String phoneNumber = "^0[0-9]{9}";
    public static final String gender = "(male|female)";
    public static final String date = "[0-2]{1,2}-{1,2}-{4}";
    public static final String email = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+)$";
    public static boolean isvalid(String str,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}

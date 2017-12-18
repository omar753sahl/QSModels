package utils;

public class TextUtils {
    /**
     * checks if a string is null or its length is zero
     *
     * @param string the string to be checked
     * @return whether this string is empty or not
     */
    public static boolean isEmpty(String string) {
        return string != null && string.trim().isEmpty();
    }
}

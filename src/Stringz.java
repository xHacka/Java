public class Stringz {
    public static String longestStr(String[] strs) {
        if (strs.length < 1) { return ""; }

        String smallest = strs[0];
        for (String str: strs) { if (str.length() < smallest.length()) { smallest = str; } }

        return smallest;
    }
}

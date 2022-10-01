package com.eneskzlcn.frequencyfinder;

public class StringUtil {
    public static String removePunctuationsFromString(String str) {
        return str.replaceAll("\\p{Punct}", "");
    }
    public static String recoverPunctuationAndCapitalization(String str)
    {
        return removePunctuationsFromString(str).toLowerCase();
    }

}

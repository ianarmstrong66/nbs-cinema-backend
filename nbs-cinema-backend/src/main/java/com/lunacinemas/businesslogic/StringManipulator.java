package com.lunacinemas.businesslogic;

public abstract class StringManipulator {

    protected static String getRegex(String word){
        String output="";
        char[] arr = word.toLowerCase().toCharArray();
        for (char c : arr){
            output+="["+c+(c+"").toUpperCase()+"]";
        }
        return output;
    }

}

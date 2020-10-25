package com.moviematch.rest.utils;

public class ExistenceHandler {
    public static boolean isStringNullOrEmpty(String s){
        if(s == null)
            return true;
        if(s.trim().length() == 0)
            return true;
        return false;
    }
}

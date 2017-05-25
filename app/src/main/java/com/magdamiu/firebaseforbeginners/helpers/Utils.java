package com.magdamiu.firebaseforbeginners.helpers;

/**
 * Created by magdamiu on 25/05/17.
 */

public class Utils {

    public static boolean isEmpty(String string) {
        if (string != null && string.length() > 0)
            return true;
        else return false;
    }
}

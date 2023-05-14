package com.hmb.util;

public class StringUtil {
    public boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }
}

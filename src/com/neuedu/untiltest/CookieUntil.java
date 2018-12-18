package com.neuedu.untiltest;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUntil {
    public static Map<String,Cookie> getCookie(Cookie[] cookies){
        Map<String,Cookie> maps = new HashMap<>();
        if(cookies==null){
            return maps;
        }else{
            for (Cookie coo:cookies
            ) {
                maps.put(coo.getName(),coo);
            }
        }
        return maps;
    }
}

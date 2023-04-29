package com.renChao.i18n;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;


public class I18nTest {
    @Test
    public void testLocale() {
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);
        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);
    }

    @Test
    public void testI18n() throws UnsupportedEncodingException {
//        Locale locale = Locale.CHINA;
        Locale locale = Locale.US;
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        String username = new String(bundle.getString("username").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(bundle.getString("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String sex = new String(bundle.getString("sex").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String age = new String(bundle.getString("age").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("sex:" + sex);
        System.out.println("age:" + age);
    }
}

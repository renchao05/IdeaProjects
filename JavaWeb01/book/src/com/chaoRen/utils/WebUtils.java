package com.chaoRen.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String is, int defaultInt) {
        try {
            if (is == null || is.equals(""))
                return defaultInt;
            return Integer.parseInt(is);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultInt;
    }
}

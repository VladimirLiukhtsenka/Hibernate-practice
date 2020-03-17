package com.liukhtenko.ticket.validator;

import com.liukhtenko.ticket.exception.SiteException;

import javax.servlet.http.HttpServletRequest;

// FIXME: 24.01.2020 для всех типов проверки
public class Form {
    public static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req, name, ".*");
    }

    public static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        String value = req.getParameter(name);
        if (value != null && value.matches(pattern)) {
            return value;
        }
        throw new SiteException("Incorrect value of " + name);
    }

    public static byte getByte(HttpServletRequest req, String name) throws SiteException {
        try {
            return Byte.parseByte(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException("Incorrect value of " + name, e);
        }
    }


    public static long getLong(HttpServletRequest req, String name) throws SiteException {
        try {
            return Long.parseLong(req.getParameter(name));
        } catch (Exception e) {
            throw new SiteException("Incorrect value of " + name, e);
        }
    }

    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().toUpperCase().equals("POST");
    }
}

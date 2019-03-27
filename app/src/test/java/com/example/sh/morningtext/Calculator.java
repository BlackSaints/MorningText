package com.example.sh.morningtext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public double sum(double a, double b){
        return a+b;
    }

    public double substract(double a, double b){
        return a-b;
    }

    public double divide(double a, double b){
        return a/b;
    }

    public double multiply(double a, double b){
        return a*b;
    }

    public double multiply1(double a, double b){
        return a*b+1;
    }

    public boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            System.out.println("phone num is not 11");
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
            }
            return isMatch;
        }
    }

}

package com.hspedu.work;

public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str);

        System.out.println(reverse2(str,0,5));
    }

    public static String reverse(String str, int start, int end) {
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer temp = new StringBuffer(str.substring(start,end + 1));
        temp.reverse();
        stringBuffer.replace(start,end + 1,temp.toString());
        return stringBuffer.toString();
    }

    public static String reverse2(String str, int start, int end) {
        char[] chs = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j ; i++, j--) {
            temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        return String.copyValueOf(chs);
    }
}


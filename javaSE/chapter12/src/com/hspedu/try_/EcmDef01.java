package com.hspedu.try_;

import java.util.Scanner;

public class EcmDef01 {
    public static void main(String[] args) {
        try {
            if (!(args.length == 2)) {
                throw new ArrayIndexOutOfBoundsException("参数数量不对!");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println(cal(n1, n2));

        } catch (NumberFormatException e) {
            System.out.println("输入的数值错误！");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0！");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int cal(int n1, int n2) {
        return n1 / n2;
    }
}

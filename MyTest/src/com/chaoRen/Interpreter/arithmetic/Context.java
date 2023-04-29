package com.chaoRen.Interpreter.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文类（这里主要用来将变量解析成数字【当然一开始要先定义】）
 */
public class Context {
    private final Map<Expression, Integer> map = new HashMap<>();

    //定义变量
    public void add(Expression s, Integer value) {
        map.put(s, value);
    }

    //将变量转换成数字
    public int lookup(Expression s) {
        return map.get(s);
    }
}

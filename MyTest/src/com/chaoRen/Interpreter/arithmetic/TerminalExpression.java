package com.chaoRen.Interpreter.arithmetic;

/**
 * 终结符表达式（在这个例子，用来存放数字，或者代表数字的字符）
 */
public class TerminalExpression implements Expression{

    String variable;
    public TerminalExpression(String variable){
        this.variable = variable;
    }
    @Override
    public int interpreter(Context context) {
        return context.lookup(this);
    }
}

package com.chaoRen.Interpreter.readerCard;

//环境类
class Context {
    private final Expression cityPerson;

    public Context() {
        Expression city = new TerminalExpression(new String[]{"韶关", "广州"});
        Expression person = new TerminalExpression(new String[]{"老人", "妇女", "儿童"});
        cityPerson = new AndExpression(city, person);
    }

    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
        }
    }
}

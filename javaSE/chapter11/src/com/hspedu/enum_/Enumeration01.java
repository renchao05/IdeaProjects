package com.hspedu.enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.FALL);
    }
}

/**
 * 1) 构造器私有化
 * 2) 本类内部创建一组对象[四个 春夏秋冬]
 * 3) 对外暴露对象（通过为对象添加 public final static 修饰符）
 * 4) 可以提供 get 方法，但是不要提供 set 方法
 */
class Season {
    private String name;
    private String des;

    public static final Season SPRING = new Season("春天","万物生长。。。");
    public static final Season SUMMER = new Season("夏天","天气炎热。。。");
    public static final Season FALL = new Season("秋天","到处落叶。。。");
    public static final Season WINTER = new Season("冬天","白雪皑皑。。。");

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    private Season(String name, String des) {
        this.name = name;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
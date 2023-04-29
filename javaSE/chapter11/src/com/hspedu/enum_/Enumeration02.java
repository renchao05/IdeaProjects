package com.hspedu.enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        Season2 fall = Season2.FALL;
        System.out.println(fall.name());
        System.out.println(fall.toString());
        System.out.println(fall.ordinal());
        Season2[] s = Season2.values();
        System.out.println("下面是增强for循环。。。");

        for (Season2 i : s) {
            System.out.println(i);
        }
    }
}

enum Season2 {
    SPRING("春天","万物生长。。。"),
    SUMMER("夏天","天气炎热。。。"),
    FALL("秋天","到处落叶。。。"),
    WINTER("冬天","白雪皑皑。。。");
    private final String name;
    private final String des;

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    Season2(String name, String des) {
        this.name = name;
        this.des = des;
    }

//    @Override
//    public String toString() {
//        return "Season2{" +
//                "name='" + name + '\'' +
//                ", des='" + des + '\'' +
//                '}';
//    }
}

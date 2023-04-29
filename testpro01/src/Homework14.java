import java.util.Scanner;

public class Homework14 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Person P1 = new Person();
        for (; true; ) {
            int hand;
            for (; true; ) {
                hand = (int) (Math.random() * 10);
                if (hand > 0) {
                    hand = hand % 3;
                    break;
                }
            }
            System.out.println("请输入0-2数字(0是石头，1是剪刀，2是布;9表示不玩了！)：");
            P1.hand = myScanner.nextInt();
            if (P1.hand == 0 || P1.hand == 1 || P1.hand == 2) {
                P1.match(hand);
            } else if (P1.hand == 9) {
                System.out.println("你赢了" + P1.win + "次!\n你输了" + P1.lost + "次!!");
                break;
            } else {
                System.out.println("输入错误………………");
            }
        }
    }
}

class Person {
    int hand;
    int win = 0;
    int lost = 0;

    public Person(int hand, int win, int lost) {
        this.hand = hand;
        this.win = win;
        this.lost = lost;
    }

    public void match(int hand) {
        if (hand - this.hand == 1 || hand - this.hand == -2) {
            win++;
            System.out.println("你赢了" + win + "次");
        } else if (hand - this.hand == -1 || hand - this.hand == 2) {
            lost++;
            System.out.println("你输了" + lost + "次");
        }
    }
}
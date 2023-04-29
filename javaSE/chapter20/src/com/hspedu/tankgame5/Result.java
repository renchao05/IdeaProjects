package com.hspedu.tankgame5;

import java.io.*;
import java.util.List;
import java.util.Vector;

public class Result {
    public static int achievement;
    public static Node node;
    private static BufferedWriter bw;
    private static BufferedReader br;



    public static void increaseAchievement() {
        achievement++;
    }

    public static void storageResult() {
        try {
            bw = new BufferedWriter(new FileWriter("d:\\cc.txt"));
            bw.write("" + achievement);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void initResult() {
        try {
            br = new BufferedReader(new FileReader("d:\\cc.txt"));
            achievement = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\SaveOut.object"));
            Object o = ois.readObject();
            node = (Node)o;
            for (Node no : node.enemy) {
                System.out.println("对象" + no.x + "===" + no.y);
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        Node node = new Node();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\SaveOut.object"));
            oos.writeObject(node);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

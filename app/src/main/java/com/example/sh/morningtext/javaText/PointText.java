package com.example.sh.morningtext.javaText;

public class PointText {

    public int x;
    public int y;
    public int z;

    public PointText(int _x, int _y, int _z){
        x = _x;
        y = _y;
        z = _z;
        Cat cat = new Cat(1,"200");
    }

    public void setX(int _x){
        x = _x;
    }

    public double getIndance(PointText point){
        return (x - point.x)*(x - point.x)+(y - point.y)*(y - point.y)+(z - point.z)*(z - point.z);
    }

    public static void main(String[] args) {
        PointText p1= new PointText(1,2,3);
        PointText p2 = new PointText(0,0,0);
        System.out.println("indance="+p1.getIndance(p2));
        p1.setX(2);
        System.out.println("indance="+p1.getIndance(p2));
    }

}

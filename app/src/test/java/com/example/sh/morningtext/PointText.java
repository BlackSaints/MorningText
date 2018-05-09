package com.example.sh.morningtext;

public class PointText {

    public int x;
    public int y;
    public int z;

    public PointText(int _x,int _y,int _z){
        x = _x;
        y = _y;
        z = _z;
    }

    public void setX(int _x){
        x = _x;
    }

    public double getIndance(PointText point){
        return (x - point.x)*(x - point.x)+(y - point.y)*(y - point.y)+(z - point.z)*(z - point.z);
    }

    public static void main(String[] args) {
        PointText pointText = new PointText(1,2,3);
        PointText centerPoint = new PointText(0,0,0);
        System.out.println("indance="+pointText.getIndance(centerPoint));
        pointText.setX(2);
        System.out.println("indance="+pointText.getIndance(centerPoint));
    }

}

package com.example.sh.morningtext.javaText;

public class GenericDemo02 {

    public static void main(String[] args) {
        //水果盘子 不能放橘子
//        Plate<Fruit> plate = new Plate<>(new Orange());
//        Plate<Fruit> plate1 = new Plate<Orange>();

        Plate<? extends Fruit> plate = new Plate<Orange>();
//        plate.setItem(new Orange());//error plate只能读 不能存 因为不知道plate是什么类型
//        plate.setItem(new Fruit());

        Plate<Orange> orangePlate = new Plate<>();
        orangePlate.setItem(new Orange());
//        plate = orangePlate;

        Fruit fruit =  plate.getItem();
        Orange orange = (Orange) plate.getItem();
        GreenOrange greenOrange = (GreenOrange) plate.getItem();


        System.out.println("plate size = "+orangePlate.toString());
        //super只能匹配 Orange类或者父类
//        Plate<? super Orange> superPlate0 = new Plate<GreenOrange>();
        Plate<? super Orange> superPlate = new Plate<>();
        superPlate.setItem(new Orange());
//        superPlate.setItem(new Fruit());// error 只能add Orange类或者其子类
        superPlate.setItem(new GreenOrange());


    }

}

class Plate<T>{

    private T item;

    public Plate(){

    }
    public Plate(T t){
        this.item = t;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.toString()+"111";
    }
}

class Fruit{

}

class Orange extends Fruit{

}

class GreenOrange extends Orange{

}

class YellowOrange extends Orange{

}
class Pera extends Fruit{

}
package com.example.sh.morningtext.javaText;

public class Animal {

    public String name;

    public Animal(String name){
        this.name = name;
    }

    public void enjoy(){
        System.out.println("Animal叫声.....");
    }


    public static void main(String[] args){
        Dog dog = new Dog("dog");
        Bird bird = new Bird("bird");
        Lady lady = new Lady();
        lady.happy(dog);
        lady.happy(bird);

    }

}

class Lady{
    //此处业务不变，根据传进来的animal动态调用。dog，bird
    public void happy(Animal animal){
        animal.enjoy();
    }
}

class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void enjoy() {
        System.out.println("dog叫声.....");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void enjoy() {
        System.out.println("Bird叫声.....");
    }
}

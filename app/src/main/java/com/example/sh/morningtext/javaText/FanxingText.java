package com.example.sh.morningtext.javaText;

public class FanxingText implements Infa{

    public  static void main(String[] args){

        F f = new F();
        f.setType("String");
        System.out.println("type="+f.getType());;

        F f1 = new F();
        f1.setType(1);
        System.out.println("type="+f1.getType());;

        F<Double> f2 = new F<>();
        f2.setType(123.00);
        System.out.println("type="+f2.getType());;
    }


    @Override
    public Object setKey() {
        return null;
    }

    @Override
    public String setInfa(Object infa) {
        return null;
    }
}

class F<T>{

    public T type;

    public T getType(){
        if(type instanceof String){
            return (T) "String";
        }else if(type instanceof Double){
            return (T) "Double";
        }

        return type;
    }

    public void setType(T type){
        this.type = type;
    }

}


 interface Infa<T>{

    T setKey();

    String setInfa(T infa);
}

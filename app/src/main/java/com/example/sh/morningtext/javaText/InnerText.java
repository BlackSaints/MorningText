package com.example.sh.morningtext.javaText;

public class InnerText {

    public static void main(String[] args) {
        InnerText text = new InnerText();
        text.text(new Panda() {

            @Override
            public String play() {
                return "蹦极";
            }
        });
    }

    public void text(Panda panda){
        panda.setName("小熊猫欢欢");
        System.out.println(panda.getName()+"在动物园"+panda.play());
    }

    public abstract static class Panda {

        private String name;

        public void setName(String name){
            this.name = name;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public abstract String play();
    }
}

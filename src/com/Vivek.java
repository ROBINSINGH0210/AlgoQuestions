package com;

public class Vivek {
    public static void main(String[] args) {
        new Son();
       
        Father father = new Son();
        System.out.println(father); //[1]I know the result is "I'm Son" here
       
    }
}

class Father {
    public String x = "Father";

    @Override
    public String toString() {
       return "I'm Father";
    }

    public Father() {
        System.out.println(this);//[2]It is called in Father constructor
        System.out.println(this.x);
    }
}

class Son extends Father {
    public String x = "Son";

    @Override
    public String toString() {
        return "I'm Son";
    }
}
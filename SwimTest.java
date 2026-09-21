package com.tg.lambdademo1;

public class SwimTest {
    static void main() {
        method(new Swim(){

            @Override
            public void swimming() {
                System.out.println("is swimming");
            }
        });

        method(() -> System.out.println("is swimming"));

    }

    public static void method(Swim s){
        s.swimming();
    }
}

@FunctionalInterface
interface Swim{
    public abstract void swimming();
}

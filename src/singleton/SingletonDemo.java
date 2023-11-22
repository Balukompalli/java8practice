package singleton;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SingletonDemo {
    public static void main(String[] args) {

//        Singleton singleton1 = new Singleton();
//        System.out.println(singleton1);
//        Singleton singleton2 = new Singleton();
//        System.out.println(singleton2);

        Singleton singleton3 = Singleton.getSingleton();
        System.out.println(singleton3);

        Singleton singleton4 = Singleton.getSingleton();
        System.out.println(singleton4);


    }

}



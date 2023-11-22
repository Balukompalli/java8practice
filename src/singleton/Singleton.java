package singleton;

//Private singleton.Singleton reference
//private constructor
//
public class Singleton {

    private Singleton() {}

    private static final class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton(){
//        if(singleton ==null) {
//            synchronized (Singleton.class) {
//                if(singleton ==null) {
//                    singleton =  new Singleton();
//                }
//            }
//
//        }

        return SingletonHolder.singleton;
    }

}
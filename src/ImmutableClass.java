//Maker class as  final
//make variables as private, final
//No setter method
//make deep copy of object if other object like has a relationship object is avaialble in the class.

public final class ImmutableClass {

    private  final int id;
    private final String name;

    private Engine engine;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImmutableClass(int id, String name, Engine engine) {
        this.id = id;
        this.name = name;
        //this.engine =  engine;//shallow copy not suggestable to immutablity
        this.engine= new Engine(engine.speed); //only deepcopy
    }

    public static void main(String[] args) {
        Engine engine1 =  new Engine(1);
        ImmutableClass immutableClass = new ImmutableClass(1,"siva",engine1);
        System.out.println(immutableClass.getId()+":"+immutableClass.getName());
        engine1.speed=80;
        System.out.println(immutableClass.getId()+":"+immutableClass.getName()+":"+immutableClass.engine.speed);

    }
}
class Engine {
    int speed;

    public Engine(int i) {
        this.speed = i;
    }
}
// what is an interface?
// blueprint for a class. abstract classes are also blueprints of class, but it may contain other methods in addition to abs methods.

// interface methods are by default public and abstract. 
// interface can not have constructors. 
// interface can not have instance variables, but can have static and final variables. 
// by default, variables in interface are public, static and final.

// interface can not have private methods. 
// interface can not be instantiated ( cannot create object of interface). 
// interface can extend another interface ( multiple inheritance is possible this way). 
// class can implement multiple interfaces ( multiple inheritance is possible). 
// class can implement an interface using implements keyword. 
// abstract class can implement an interface using implements keyword. 
// abstract class can extend another abstract class and implement an interface at the same time.

interface Animal {
    public abstract void animalSound(); // interface method (does not have a body)
    void sleep(); // interface method (does not have a body)
    // both methods are public and abstract by default, so the public abstract keywords are not needed

     default void type() { // body method should have default keyword in interface
        System.out.println("animal is of a distinct type");
    }

    static void staticMethod() { // body method should have static keyword in interface
        System.out.println("static method in interface");
    }


}
class Dog implements Animal {
    @Override
    public void animalSound() {
        System.out.println("Woof");
    }
    @Override
    public void sleep() {
        System.out.println("Zzz");
    }
}

class learn6OOP {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // create a Dog object
        myDog.animalSound();
        myDog.sleep();
        myDog.type();
        Animal.staticMethod(); // call it directly by the class name not by the object name, will give compilation error
    }
}
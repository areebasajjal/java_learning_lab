// 1. abstraction means hiding the internal details of a class and exposing only what an object can do

// 2. cannot be used to create objects.
// 3. constains abstract and normal methods ( with implementation ).
// 4. implemented in concrete subclasses.

abstract class geometric_obj {
    private String color = "white";
    private boolean filled = false;

    public abstract double getArea(); // abstract method
    public abstract double getPerimeter(); // abstract method
}

// 5. regular classs but cant create instance of class using the new keyword

// 6. an abstract method can not be in a non abstract class
// 7. abstract super class with some abstract method -> subclass must impelement all the abs methods
// or be declared abstract itself.

abstract class Animal {

    public abstract void animalSound(); // abstract method

    public void sleep() {     // regular method
        System.out.println("Zzz");
    }
}

class Dog extends Animal {
    public void animalSound() {   // implementing the abstract method
        System.out.println("Woof");
    }
}

// 8. abstract class can have constructors and static methods
// 9. abstract methods are non static methods and can not be final or private
// 10. abs constructors can be invoked in the subclass using super keyword.
// 11. possible to define an abs class w/o abstract method.

public class learn5OOP {
    public static void main(String[] args) {
       //  Animal myAnimal = new Animal(); // can not do this. 
       // Why? Because Animal represents a general concept. Java expects you to create a specific animal:
        Dog myDog = new Dog(); // create a Dog object
        myDog.animalSound();
        myDog.sleep();
    }
}
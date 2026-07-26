// run time polymorphism --> achieved by method overriding 
// when a subclass provides a specific implementation of a method that is already defined 
// in its superclass, it is known as method overriding. 
// This allows the subclass to provide its own behavior while still maintaining the same 
// method signature as the superclass.

// at runtime , the JVM decides which method to call based on the actual object type, 
// rather than the reference type. 
// This is known as dynamic method dispatch or late binding.


// covariant return type in method overriding 
// -----------------------------> when overriding, the subclass is allowed to 
// return a subtype of the original return type. 

class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }

}

class Dog extends Animal { // dog is a subclass 

    void sound() {
        System.out.println("Dog barks.");

    }
}

class animalshelter extends Animal {
    
    void sound() {
        System.out.println("Animal shelter has many animals.");
    }

    Animal getAnimal() {
        return new Dog(); // covariant return type
    }
}


public class learn4OOP {
    public static void main (String args[]) {

        Animal a2 = new Dog();
        a2.sound();

    }
}

// can only work with inheritance 
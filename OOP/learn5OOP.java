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
// or be declared abstract itself.\

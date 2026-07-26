# OOP revison 
# about classes in java 
class -> constructor of an object or a blueprint of an object 
class contains attributes and methods (atrributes are the qualities and methods are basically what my class can do/ perform)

# about objects in java 
objects of particular classes are made in the main class using the new keyword.

# significance of the new keyword in java 
Stack                         Heap
s1: reference ──────────────> Student object
                                 name = null (default values unless specifically assigned )
                                 age = 0

# how object references work in java 
A reference variable is not the object. It stores a reference that lets Java reach the object.

FOR student = new Student();

Java evaluates the right-hand side first:

new Student() creates a new object.
It returns a reference to that object.
= stores that reference in student, replacing its previous reference.

# class/static variables vs instance variables
static variables are shared by all objects/instances of a class 
static variables store value in a common memory location. -> if one object changes the value of a static variable , all objects 
of the same class are affected. 

instance variables belong to the object of the class. e.g. name is an instance variable, if obj1 has has a name Areeba, 
and obj2 has name Sajjal, then both these variables belong to the particular instances of class, entirely independent of one another.

# class/static methods vs instance methods 
instance method belongs to the object ------> it can access both instance and class varibales.
static methods belong to the class -----> it can not access the instance members of the classes, only the ones that have been declared as static.

# why can't static methods access instance stuff?
static methods do not know which object we are currently talking about, since they belong to the class itself.
On the contrary, instance methods

# key concept that often causes confusion about access the variables in instance and static methods 
Instance-variable access requires this. 
Static-variable access requires the class, not this. 
An instance method can access both because it knows its class and also receives this. while the static method receives no this. 

# java is pass by value
understanding what pass - by - value actually is: 

   static void change(int x) {
         x = 50;
    }

   public static void main(String[] args) {
    int number = 10;
    change(number);

    System.out.println(number); // 10
} 

whenever a method is called with regards to some value passed as a paramter, java does not send the original value but a copy of that value ( so inside the method, whatever changes are happening, are happening to the copied value whereas the original value stays the same!)

# constructors
two types of constructors exist in java oop. default and parameterized.
even if you dont declare any default constructor yourself, java automatically internally makes one.
however, if you define a parameterized contructor, a defualt needs to be explicitly mentioned
otherwise error would be thrown.

# constructor overloading
Constructor overloading means defining multiple constructors in the same class with different parameter lists.
in a constructor, it is not necessary that you initialize all the values of the fieldsdefined in the class, whatever values get initialized, GOOD! the rest are automatically given a default value acc to their data type.

The constructors are overloaded because their parameter lists differ in:

Number of parameters
Parameter types
Parameter order

For example, these are valid overloads:

Student(String name) { }

Student(int age) { }

Student(String name, int age) { }

Student(int age, String name) { }

But changing only parameter names is not enough:

Student(String name) { }
Student(String university) { } // Error

Both have the same constructor signature:

Student(String)

# encapsulation
Encapsulation means:
Keep an object’s data and the operations that control that data together, while restricting direct access to its internal state.

Don’t automatically create a getter and setter for every field. Expose only the operations outside code genuinely needs.

# inheritance
1. if you define a parameterized constructor in parent class and keep the child class empty ( no default const ), error will be thrown.
2. java forbids multiple inheritance like c extends a, b to avoid ambiguity. for example, both the parents haver a display method and you call the display method with ref to object of c, now c would be confused what method to call because both of its parents have display.

# composition
strong has-a relation. contained object is provided internally in the container class and externally in aggregation.
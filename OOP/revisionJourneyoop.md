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

# why is composition often times more flexible?
a class can use another object without actually becoming that object like what happens in inheritance.

# polymorphism
core idea is that same method name can be used by diff objects that behave differently.
Ability of a method call to behave differently based on the object that uses it 

There are two types of polymorphhism
1. compile time -----> achieved by method overloading ---> static polymorphism ( early binding )

2. runtime polymorphism ----> during execution ----> achieved by method overriding --> dynamic polymorphism ( late binding )

# run time polymorphism 
same method name, parameter list.
same or covariant return type.
access modifier -> can be same or more accessible. 
static methofd -> cant be overriden -> they are hidden

constuctors , final methods , private methods, since they are not inherited --> cant be overridden

# ----> 
at compile time, java only knows type of reference and the methods available in that class. so compiler asks, does the class have this method? if yes -> compile, if not -. compile time error. 

methods -> run time decision
fields -> compile time decision.

# firlds do not use polymorphism. 
fields are resolved at compile time using the reference type, because fields are not overridden, they are hidden.

Animal a = new Dog(); 
a.type; // animal 
a.speak(); // dog barks

# upcasting 
assigning a subclass ref to a super class -> implicit -> safe at compile time.
assigning a sub class object to super class reference 

Animal a = new Dog();  ----> Dog d = new Dog();  ( same thing )
                             Animal a = d;

# down casting in polymorphism
assigning a super class object to a sub class reference. -> explicit

Animal a = new Dog(); // subclass 
Dog d = (Dog) a; // superclass ref

Dog d = (Dog) new Animal(); // class cast exception because animal can not be converted to dog

# downcasting is causing me confusion!
casting in java is basically done on references , not the actual objects.
Animal a = new Dog();
Dog d = (Dog) a;

1. actual object is dog, a is the reference that points to dog object.
2. (Dog) tells java to treat that reference as dog reference.
3. d now points to the same object.

# Casting changes or checks the reference type through which an object is accessed; it never changes the object’s actual class.

# abstraction 
The key distinction in abstract classes is:

Having a constructor: the class can initialize its part of a child object.
Being instantiable: the class is allowed to be the actual type of a complete object.

Java denies this:

Animal animal = new Animal();

because declaring Animal as abstract is an explicit promise that the class is not complete enough to represent a standalone object.

Animal animal = new Animal("Bruno");
animal.makeSound(); // abs method

what code should makeSound() execute? The method has no body. The resulting object would contain an operation that cannot be performed.

Therefore Java enforces this rule at compile time:

The runtime class of every created object must be concrete and provide implementations for all required instance methods.

# interface 
a class can implement multiple interfaces 
e.g.; class service implements smartphone, telephone, laptop.

If the class does not implement every required method, it must itself be abstract.

# when a class is extending and implementing both.
class Child extends Parent implements Interface1, Interface2 {
    // implementation
}

# confusion of where to use abstract class versus interfaces.
Use an abstract class when subclasses share identity and implementation
class teacher may eextend class employee that has abstarct method and fields of age , name , salary.

Use an interface when you need a capability or contract. 
think, could unrelated classes perform the same capability? if yes. use interface

| Question                                             | Prefer                      |
| ---------------------------------------------------- | --------------------------- |
| Do classes share common instance fields?             | Abstract class              |
| Do they need common constructor logic?               | Abstract class              |
| Do they share substantial implementation?            | Abstract class              |
| Is there a genuine `is-a` family relationship?       | Abstract class              |
| Is this mainly an ability or contract?               | Interface                   |
| Can unrelated classes implement it?                  | Interface                   |
| Might the implementation be replaced later?          | Interface                   |
| Does a class need multiple independent capabilities? | Interfaces                  |
| Do you need both shared state and capabilities?      | Abstract class + interfaces |


The accurate decision rule is:

Shared state/code and the capability only belongs to that family → abstract class alone.
Shared state/code plus a capability needed by unrelated classes → abstract class + interface.
Only a contract/capability, with no shared instance state → interface.
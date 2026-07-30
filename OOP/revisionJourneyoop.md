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

# 1. what are packages?
A package is a named group of related Java classes, interfaces, enums, and other types.

For example, a university system might be organized like this:

com.university
├── students
│   └── Student.java
├── teachers
│   └── Teacher.java
└── app
    └── Main.java

The packages could be:

com.university.students
com.university.teachers
com.university.app

com.university.students.Student

This is the class’s fully qualified name.

# 1.1 declaring a package 
The package declaration normally appears as the first statement in a Java file:

package com.university.students;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void study() {
        System.out.println(name + " is studying");
    }
}

This class belongs to:

com.university.students

The file structure should match the package:

src/
└── com/
    └── university/
        └── students/
            └── Student.java

Each dot represents another directory level:

com.university.students

becomes:

com/university/students

Important distinction:

students is the immediate package name.
com.university.students is the complete package name.
Student is the class name.
com.university.students.Student is the fully qualified class name.

# 1.2 Preventing naming conflicts

Two packages can contain classes with the same simple name:

com.school.Student // fully qualified class name is diff in both so works
com.course.Student

They are different classes because their fully qualified names differ.

# 1.3 Using a class from the same package
Suppose both files belong to com.university.students.

Student.java
package com.university.students;

public class Student {
    public void study() {
        System.out.println("Student is studying");
    }
}
StudentManager.java
package com.university.students;

public class StudentManager {

    public void manage() {
        Student student = new Student();
        student.study();
    }
}

No import is required because both classes are in the same package.

Java automatically looks inside the current package for Student.

# 1.3 Using a class from another package
Suppose Student remains here:

package com.university.students;

public class Student {
    public void study() {
        System.out.println("Student is studying");
    }
}

But Main belongs to another package:

package com.university.app;

Then you must import Student:

package com.university.app;

import com.university.students.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();
    }
}

The order is:

package packageName;

import another.package.ClassName;

public class ClassName {
}

So remember:

package → imports → class

# 1.4 What import actually does
An import does not copy a class into your file. It only allows you to use the class’s short name.

Without an import:

com.university.students.Student student =
        new com.university.students.Student();

With an import:

import com.university.students.Student;

you can write:

Student student = new Student();

These refer to the same class.

# therefore, package says where the current class belongs.
# import says which external class names may be written in short form.

## 1.5 Parent Packages and Subpackages in Java

A common mistake is thinking that Java packages work like normal parent and child folders.

For example, the folders may look like this:

```text
com/
└── shop/
    ├── Main.java
    └── service/
        └── OrderService.java
```

This looks like `service` is inside `shop`. However, Java sees them as two completely separate packages:

```text
com.shop
com.shop.service
```

Therefore:

```text
com.shop ≠ com.shop.service
```

The dots in a package name help organize the project, but they do not create an inheritance or parent-child access relationship.

### Example

Suppose `OrderService` belongs to `com.shop.service`:

```java
package com.shop.service;

public class OrderService {

    public void placeOrder() {
        System.out.println("Order placed");
    }
}
```

A class in `com.shop` can use it, but it must import it:

```java
package com.shop;

import com.shop.service.OrderService;

public class Main {

    public static void main(String[] args) {
        OrderService service = new OrderService();
        service.placeOrder();
    }
}
```

This works because:

* `OrderService` is `public`.
* `placeOrder()` is `public`.
* `Main` imports `OrderService`.

### What if `OrderService` is not public?

```java
package com.shop.service;

class OrderService {

    void placeOrder() {
        System.out.println("Order placed");
    }
}
```

Because no access modifier is written, `OrderService` has package-private access.

It can only be used by classes whose exact package is:

```text
com.shop.service
```

Therefore, this will not work:

```java
package com.shop;

import com.shop.service.OrderService; // compilation error
```

Even though the `service` folder is physically inside the `shop` folder, `com.shop` and `com.shop.service` are different packages.

## 1.5.1 Exact Same Package Rule

Package-private members are accessible only when both classes have the exact same complete package declaration.

These classes are in the same package:

```java
package com.shop.service;
```

```java
package com.shop.service;
```

These classes are not in the same package:

```java
package com.shop;
```

```java
package com.shop.service;
```

The second package name starts with the first one, but they are still separate packages.

## 1.5.2 What “Cannot Access” Means

Being in `com.shop` does not mean that a class can never use a class from `com.shop.service`.

It means that it does not automatically receive access to the package-private classes and members of `com.shop.service`.

Code in `com.shop` can still use code from `com.shop.service` when:

* The class is `public`.
* The required constructor or method is accessible.
* The class is imported, or its fully qualified name is used.

Example using an import:

```java
import com.shop.service.OrderService;
```

Example using the fully qualified name:

```java
com.shop.service.OrderService service =
        new com.shop.service.OrderService();
```

Both refer to the same class.

## 1.5.3 Important Rule About Wildcard Imports

Importing everything from `com.shop` does not import classes from its subpackages:

```java
import com.shop.*;
```

This does not import:

```text
com.shop.service.OrderService
```

You must import the subpackage separately:

```java
import com.shop.service.*;
```

or import the specific class:

```java
import com.shop.service.OrderService;
```

## 1.5.4 Simple Mental Model

Folders can be physically nested:

```text
com → shop → service
```

But Java treats packages as complete, separate names:

```text
"com.shop"
"com.shop.service"
```

Think of each complete package name as a separate address.

## Final Rule

```text
com.shop and com.shop.service are different packages.
```

A subpackage:

* Does not inherit access from its parent package.
* Does not automatically import classes from its parent package.
* Does not share package-private members with its parent package.
* Can use accessible classes through imports.

Package-private access always means:

```text
Accessible only within the exact same complete package name.
```
# conflict in importing packages when the simple names are same
ully qualified names are different:
java.util.Date ≠ java.sql.Date

Simple names are the same:
Date = Date

Therefore, the classes do not conflict inside their packages. The confusion occurs only when Java is asked to identify both using the same simple name, Date.

# classes contained in the same package are accessible like this:
Package-private accountCode is accessible.
protected method is accessible.
public method is accessible.
private field is inaccessible.

# classes contained in difference packages can only access eschothers content if public, and not otherwise.
# for a class to be accessible from other class in the same or diff package, declare it public.

if class is inaccessible, then we cant access the public methods or variables inside of it.
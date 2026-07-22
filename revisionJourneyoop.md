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



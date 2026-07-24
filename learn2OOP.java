class Person { // parent / super class
    String name;

    // Person() {

    // }

    Person(String n) {
        name = n;
    }

    void introduction() {
        System.out.println("my name is " + name);
    }
}

class student extends Person { // sub class/ child class
    int rollno;

   // default constructor is not made here hence no error regarding default constructor of the parent class 

    student(String name, int r) { 
        super(name); // super is used to invoke the const of the parent class
        rollno = r;
    }

    void display() {
        System.out.println("my name is " + super.name + " and my roll number is " + rollno);
    }

}

class Areeba extends student { // subclass/ child class
    int marks;
   
   Areeba(String name, int r, int m) { 
        super(name, r); // call the parent constructor
        marks = m;
    }

    void newdisplay() {
        System.out.println("my name is " + super.name + " and my roll number is " + rollno + " and my marks are " + marks);
    }

}





public class learn2OOP {
    public static void main(String[] args) {

    student s1 = new student("John", 101);
    Areeba a1 = new Areeba("areeba", 21, 98);

    s1.display();
    a1.newdisplay();
    s1.name = "Mike"; // changing the name of the student object
    s1.display(); // displaying the updated name of the student object
    }
}

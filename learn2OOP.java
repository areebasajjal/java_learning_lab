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

class Teacher extends Person{ // subclass/ child class
    int salary;

   // default constructor exists here hence error is being thrown regading the non-existence of the parent constructor
   // lets make parameterized constructor and call the parent in it using super.
   
   Teacher(String name, int s) { 
        super(name); // super is used to invoke the const of the parent class
        salary = s;
    }

    void display() {
        System.out.println("my name is " + super.name + " and my salary is " + salary); // super.name or just name can be used here as well since the parent class has been called in the constructor of the child class
    }

}





public class learn2OOP {
    public static void main(String[] args) {

    student s1 = new student("John", 101);
    Teacher t1 = new Teacher("Smith", 50000);

    s1.display();
    t1.display();
    s1.name = "Mike"; // changing the name of the student object
    s1.display(); // displaying the updated name of the student object
    t1.name = "Johnson"; // changing the name of the teacher object
    t1.display(); // displaying the updated name of the teacher object
    }
}

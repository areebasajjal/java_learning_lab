class student {
    String name;
    int age;
    int rollno;
    static int count;
    static String university;

    public student() { // default constrctor

    }

    public student(String n, int a, int r) { // parameterized constructor
        name = n;
        age = a;
        rollno = r;
        count++;
        university = "COMSATS";
    }

    student(String studentName) {
        name = studentName;
        age = 0;
    }

    student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }


    void incrementCount() {
        count++;
    }
    
    void studies() {
        System.out.println(name + " is studying");
    }

    void attendsSchool() {
        System.out.println(name + " is attending school");
    }

    static void university(){
        System.out.println("student belongs to " + university);
    } // static methods have no this hence they can only work with static variables.

    void display(){
        System.out.println(name + " is studying at " + university); 
        // inwardly, its this.name and student.university 

    }

    void rename(student s) {
        s.name = "ayeza";
    }

    static void replace(student student) { // copied ref takes the place of student. both s6 and student point 
        // to the same object for now.
    student = new student(); // new obj created in memory and ref of new obj is saved to student
    student.name = "Sara"; // new obj has name stored as Sara.

    // even after execution, harib and sara remain independent of eachother as they are treated independent
  }

  static void clear(student student) {
    student = null;
}

}

public class learn1OOP {
    public static void main(String[] args){
    student s1 = new student();
    s1.name = "areeba";
    s1.age = 21;

    // student s1; declation created reference variable 
    // new keyword creates the actual object. 
    // wherever we use the new keyword, a new object is created in the heap memory 

    System.out.println(student.count); // static variables can either be called by class name or the name of object 
    // ( class name is more appropriate)
    student.university();

    s1.display();

    student s2 = s1; // copies only the reference value , not the actual object.
    // two references can point to the same object. 
    // only one new was used so only one object is created in heap.
    // both s1 and s2 point to the same object that has name "areeba" and age = 21.

    System.out.println(s2.name);

    s2.name = "Sajjal";

    System.out.println(s1.name); // will print sajjal instead of areeba because s2 pointed to the 
    // same object that stored the name as areeba. so s1 and s2 had a shared object.
    // change made in one was reflected in another.

    student s3;        // local variable declared but not initialized
    student s4 = null; // initialized explicitly with no-object reference

    student s5 = new student(); // new object created in heap memory
    s5.name = "Ali";

    s5.rename(s5); // reference of s5 is copied and given to the parameter of rename s
    // now both s5 and s point to the same object in memory that currently has the name ali stored.
    // in rename method, we changed the name to ayeza. since both ref point to the same object, changes
    // in one will be reflected in the other too.

    System.out.println(s5.name);
    // This can look like pass-by-reference, but it isn’t. The reference itself was copied by value.

    student s6 = new student();
    s6.name = "harib";

    student.replace(s6); // ref of s6 is copied and sent to student parameter of the replace method
    // actual ref remains safe here.

    System.out.println(s6.name); // harib

    student s7 = new student();

    student.clear(s7);

    System.out.println(s1 == null); // false
    // The method makes its own parameter null. It cannot make the caller’s s1 null:
    // this means that student does not currently point to any obj 
    // while the caller ref can still access the actual obj

          /* Initially:

                s1 ──────────┐
                            ├────> Student object
                student ─────┘

                After student = null:

                s1 ───────────────> Student object
                student ──────────> null */
    }

    student s8 = new student("Areeba"); // const overloading 
    student s9 = new student("Areeba", 20);
    
}

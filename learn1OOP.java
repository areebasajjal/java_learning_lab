class student {
    String name;
    int age;
    int rollno;
    static int count = 0;
    static String university = "COMSATS";


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
    }
}

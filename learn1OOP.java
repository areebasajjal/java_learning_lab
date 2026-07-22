class student {
    String name;
    int age;
    int rollno;
    
    void studies() {
        System.out.println(name + "is studying");
    }

    void attendsSchool() {
        System.out.println(name + "is attending school");
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
    }
}

 class student {
    private String name;
    private int age;
    private int roll_no;

    // private means that all these data members can only be accessed from within 
    // the student class
    student() {}

    student(String n, int a, int r) {
        name = n;
        age = a;
        roll_no = r;
    }
   
    // to access these private variables from the outside, we create getts and setters, not blindly
    // but in an appropriate fashion after validating the input sent by the user from outside.

}






public class learn2OOP {
    
}

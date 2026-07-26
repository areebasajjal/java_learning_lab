class heart { // conatained class
    private int beats;

    heart() {}

    heart(int b) {
        beats = b;
    }

    int beatspmin() {
        System.out.println("The heart beats at the rate of " + beats + " per minute");
        return beats;

    }
}

class human {    // container class
    String name;
    int age;
    heart h = new heart(); // created the object of contained class in the container

    human(String n, int a, heart h){
        name = n;
        age = a;
        this.h = h;
    }

    void isAlive() {
        if (h.beatspmin() > 50 ) {
            System.err.println("human is alive");
        } else {
            System.out.println("human is dead asf");
        }
    }

}

public class learn3OOP {
    public static void main(String args []) {
        heart h = new heart(100);
        human hu = new human ("areeba", 21, h); // AGGREGATION HAPPENED weak has-a relationship

        hu.isAlive();

        // why aggregation? becaause the contained object was provided externally.

        // composition is a strong has-a relationship where the contained object is created inside the container class a
        // and cannot exist without it.
        // each heart just belongs to one human and cannot exist without it. if the human dies, the heart dies too.
        // aggregation example is a professor may teach many courses at the same time


    }
}

public class Animal {// note here with no "extends" keyword, this class implicitly extends the Object class

    String name;

    // This is a constructor, note that it's name or identifier is in PascalCase, just like the class name
    public Animal(String name) {
        // The use of the "this" keyword
        this.name = name;
    }

    public void makeSound() {
        System.out.println("I'm some kind of animal?");
    }
}

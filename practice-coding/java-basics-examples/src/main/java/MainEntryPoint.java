public class MainEntryPoint {
    // Almost every program will need a main method, and everything in java exists inside a class.
    // Here's our main method, ote that the signature will almost always be exactly this:
    public static void main(String[] args) {
        // public because it must be accessible from outside this file
        // static because we aren't yet instantiating objects, so it must be associated with the class itself
        // void because the main method never returns anything


        Dog myDogSasha = new Dog();

        Animal myPetJimmy = new Dog();

        myPetJimmy = new Cat();

        Object thingy = new String();
        thingy = new Dog();
    }
}

public class MainEntryPoint {
    // Almost every program will need a main method, and everything in java exists inside a class.
    // Here's our main method, ote that the signature will almost always be exactly this:
    public static void main(String[] args) {
        // public because it must be accessible from outside this file
        // static because we aren't yet instantiating objects, so it must be associated with the class itself
        // void because the main method never returns anything
        // String[] in the parameter list, this is where command line args go

        // This loop iterates through the string array of command line args and prints them.
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        if (args.length >= 2 && args[0].equals("dog")) {

            Dog myDogSasha = new Dog(args[1]);
            myDogSasha.makeSound();
        }



        // Runtime Polymorphism - We can have a reference to Animal that points to a dog
        Animal myPetJimmy = new Dog("Jimmy"); // Here we are simply using what's called a "string literal"

        myPetJimmy = new Cat("Jimmy");

        Object thingy = new String();
        thingy = new Dog("");


        myPetJimmy.makeSound();





    }
}

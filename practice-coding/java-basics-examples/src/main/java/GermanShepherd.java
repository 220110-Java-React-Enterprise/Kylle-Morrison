public class GermanShepherd extends Dog{
    public GermanShepherd(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!!!");
    }
}

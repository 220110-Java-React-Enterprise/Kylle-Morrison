public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override // This annotation is not explicitly required to override a method, this is syntactic sugar
    public void makeSound() {
        System.out.println("Meow!");
    }
}

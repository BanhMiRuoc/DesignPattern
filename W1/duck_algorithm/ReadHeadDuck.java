public class ReadHeadDuck extends Duck {
    public ReadHeadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("I'm a real Read Headed duck");
    }
    
}

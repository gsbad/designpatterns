public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();

        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();
        

        Duck modelDuck = new ModelDuck();

        modelDuck.performFly();
        modelDuck.performQuack();

        modelDuck.setFlyBehavior(new FlyRocketPowered());

        modelDuck.performFly();
        modelDuck.performQuack();

        modelDuck.display();
    }
}

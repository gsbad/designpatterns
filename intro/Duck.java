public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    //metodo abstract - implementacao pelas subclasses obrigatorias
    public abstract void display(); 

    //metodos concretos - herdados c essa implementaçao.
    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("Todos patos flutuam!");
    }
}
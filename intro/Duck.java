public abstract class Duck {
    FlyBehavior flyBehavior; //composition
    QuackBehavior quackBehavior; //composition

    public Duck(){}

    //metodo abstract - implementacao pelas subclasses obrigatorias
    public abstract void display(); 

    //metodos concretos - herdados c essa implementaçao.
    public void performFly(){
        this.flyBehavior.fly();
    }
    public void performQuack(){
        this.quackBehavior.quack();
    }
    public void swim(){
        System.out.println("Todos patos flutuam!");
    }

    //metodos modificiadores
    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;       
    }
}
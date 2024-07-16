package factory.mycode;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactoryTest{
    public static void main(String[] args) {
        PizzaStore lojaBrasilia = new BrasiliaPizzaStore();
        PizzaStore lojaGoias = new GoiasPizzaStore();

        System.out.println();

        Pizza pizza = lojaBrasilia.orderPizza("calabresa");
        System.out.println("Cliente brasiliense recebeu uma " + pizza.getName());

        System.out.println();

        pizza = lojaGoias.orderPizza("portuguesa");
        System.out.println("Cliente goiano recebeu uma " + pizza.getName());
    }
}

// ========================================== PIZZASTORE ABSTRATA

abstract class PizzaStore {

    public Pizza orderPizza(String type){

        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

// ========================================== PIZZASTORE'S CONCRETAS
// factory method de fato

class BrasiliaPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "calabresa":
                pizza = new BrasiliaCalabresa();
                break;
            case "portuguesa":
                pizza = new BrasiliaPortuguesa();
                break;
        
            default:
                break;
        }
        return pizza;
    }


}

class GoiasPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "calabresa":
                pizza = new GoiasCalabresa();
                break;
            case "portuguesa":
                pizza = new GoiasPortuguesa();
                break;
        
            default:
                break;
        }
        return pizza;
    }


}


// ========================================== PIZZAS CONCRETAS

class BrasiliaCalabresa extends Pizza{
    public BrasiliaCalabresa(){
        nome = "Pizza Calabresa especial de Brasilia";
        massa = "Fina";
        molho = "Molho Marinara";
        toppings.add("Calabresa da região!");
        toppings.add("Oregano especial de brasilia!");
    }
}
class BrasiliaPortuguesa extends Pizza{
    public BrasiliaPortuguesa(){
        nome = "Pizza Portuguesa especial de Brasilia";
        massa = "Extra Fina";
        molho = "Plum Tomato Sauce";
        toppings.add("Queijo fino da região!");
    }
}

class GoiasCalabresa extends Pizza{
    public GoiasCalabresa(){
        nome = "Pizza Calabresa especial de Goias";
        massa = "Fina";
        molho = "Molho Marinara";
        toppings.add("Calabresa da região!");
        toppings.add("Oregano especial de goias!");
    }
    //A pizza do goias extende cut() de Pizza, pois 
    //possui um  corte especial
    @Override
    void cut(){
        System.out.println("Fatiando em 6 pedaços no estilo goiano...");
    }
}
class GoiasPortuguesa extends Pizza{
    public GoiasPortuguesa(){
        nome = "Pizza Portuguesa especial de Goias";
        massa = "Extra Fina";
        molho = "Plum Tomato Sauce";
        toppings.add("Queijo fino da região!");
    }
    //A pizza do goias extende cut() de Pizza, pois 
    //possui um  corte especial
    @Override
    void cut(){
        System.out.println("Fatiando em 6 pedaços no estilo goiano...");
    }
}


// ========================================== PIZZA ABSTRATA
abstract class Pizza{
    String nome;
    String massa;
    String molho;
    List<String> toppings = new ArrayList<>();

    void prepare(){
        System.out.println("Preparando " + nome + "! Vai ficar bom!");
        System.out.println("Esquentando a massa!");
        System.out.println("Misturando o molho!");
        System.out.println("Adicionando os toppings:");
        for (String top : toppings) {
           System.out.println("      " + top); 
        }
    }
    void bake(){
        System.out.println("Levando ao forno por 25min a 350 graus...");
    }
    void cut(){
        System.out.println("Fatiando em 8 pedaços...");
    }
    void box(){
        System.out.println("Encaixotando!");
    }

    //metodo acessor
    public String getName(){
        return nome;
    }
}
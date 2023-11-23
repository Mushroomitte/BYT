// Step 1: Define Builder interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
}

// Step 2: Concrete Builders
class MargheritaPizzaBuilder implements PizzaBuilder {
    private StringBuilder pizza;

    public MargheritaPizzaBuilder() {
        this.pizza = new StringBuilder("Margherita Pizza");
    }

    @Override
    public void buildDough() {
        pizza.append(" with Thin Crust");
    }

    @Override
    public void buildSauce() {
        pizza.append(" and Tomato Sauce");
    }

    @Override
    public void buildTopping() {
        pizza.append(" and Mozzarella Cheese");
    }

    public String getPizza() {
        return pizza.toString();
    }
}

// Similar implementation for a different pizza type

// Step 3: Director Class
class PizzaDirector {
    public void constructPizza(PizzaBuilder pizzaBuilder) {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

// Step 4: Client Code
public class BuilderPatternExample {
    public static void main(String[] args) {
        PizzaBuilder margheritaPizzaBuilder = new MargheritaPizzaBuilder();
        PizzaDirector pizzaDirector = new PizzaDirector();

        pizzaDirector.constructPizza(margheritaPizzaBuilder);
        System.out.println(((MargheritaPizzaBuilder) margheritaPizzaBuilder).getPizza());
    }
}

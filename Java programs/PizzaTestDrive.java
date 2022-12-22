import java.util.ArrayList;
class ChicagoStyleCheesePizza extends Pizza 
{
    	public ChicagoStyleCheesePizza() 
	{
        		name = "Chicago Style Deep Dish Cheese Pizza";
        		dough = "Extra Thick Crust Dough";
        		sauce = "Plum Tomato Sauce";
        		toppings.add("Shredded Mozzarella Cheese");
    	}
    	void cut() 
	{
        		System.out.println("Cutting the pizza into square slices");
    	}
}
class NYStyleCheesePizza extends Pizza 
{
    	public NYStyleCheesePizza() 
	{
        		name = "NY Style Sauce and Cheese Pizza";
        		dough = "Thin Crust Dough";
        		sauce = "Marinara Sauce";
        		toppings.add("Grated Reggiano Cheese");
    	}
}
abstract class Pizza 
{
    	String name;
    	String dough;
    	String sauce;
    	ArrayList toppings = new ArrayList();
    	void prepare() 
	{
        		System.out.println("Preparing " + name);
        		System.out.println("Tossing dough...");
        		System.out.println("Adding sauce...");
        		System.out.println("Adding toppings : ");
        		for (int i = 0; i < toppings.size(); i++) 
		{
            			System.out.println(" " + toppings.get(i));
        		}
	}
    	void bake() 
	{
        		System.out.println("Bake for 25  minutes at 350");
    	}
	void cut() 
	{
        		System.out.println("Cutting the pizza into diagonal slices");
    	}
    	void box() 
	{
        		System.out.println("Place pizza in official PizzaStore box");
    	}
    	public String getName() 
	{
        		return name;
    	}
}
abstract class PizzaStore 
{
    	public Pizza orderPizza(String type) 
	{
        		Pizza pizza;
        		pizza = createPizza(type);
        		pizza.prepare();
        		pizza.bake();
        		pizza.cut();
        		pizza.box();
        		return pizza;
    	}
	protected abstract Pizza createPizza(String type);
}
class ChicagoPizzaStore extends PizzaStore 
{
    	public Pizza createPizza(String item) 
	{
        		if (item.equals("cheese")) 
		{
            			return new ChicagoStyleCheesePizza();
        		} 
		else 
		{
            			return null;
        		}
    	}
}
class NYPizzaStore extends PizzaStore 
{
    	public Pizza createPizza(String item) 
	{
        		if (item.equals("cheese")) 
		{
            			return new NYStyleCheesePizza();
        		} 
		else 
		{
            			return null;
        		}
    	}
}
public class PizzaTestDrive 
{
    	public static void main(String[] args) 
	{
        		PizzaStore nyStore = new NYPizzaStore();
        		Pizza pizza = nyStore.orderPizza("cheese");
        		System.out.println("Sai ordered a " + pizza.getName() + "\n");
        		PizzaStore chicagoStore = new ChicagoPizzaStore();
        		pizza = chicagoStore.orderPizza("cheese");
        		System.out.println("Jyoti ordered a " + pizza.getName() + "\n");
    	}
}
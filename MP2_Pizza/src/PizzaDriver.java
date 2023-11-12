/**
 * @author angelinahouse
 *
 */
public class PizzaDriver
	{

		public static void main(String[] args)
			{

				Pizza pizza1 = new Pizza("small", 1, 0, 1);
				Pizza pizza2 = new Pizza("large", 2, 2, 0);
				Pizza pizza3 = new Pizza(pizza2);
				Pizza pizza4 = new Pizza(pizza1);
				PizzaOrder order = new PizzaOrder(3);
				
				System.out.println(pizza1);
				System.out.println(order.addPizza(pizza1));
			    System.out.println(order.addPizza(pizza2));
			    System.out.println(order.addPizza(pizza3));
			    System.out.println(order.addPizza(pizza4));
			    System.out.println(pizza3.equals(pizza2));
			    System.out.println(order);

			}

	}

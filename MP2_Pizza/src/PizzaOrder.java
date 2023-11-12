import java.util.Arrays;

/**
 * @author angelinahouse
 *
 */
public class PizzaOrder
	{
		private int m_numPizzas;
		private Pizza[] m_order;
		/**
		 *  default constructor
		 */
		public PizzaOrder()
		{
			m_numPizzas = 1;
			m_order = new Pizza[m_numPizzas];
		    m_order[0] = new Pizza("medium", 1, 0, 0);
		}
		/**
		 * overloaded conctructor
		 * @param numPizzas
		 */

		public PizzaOrder(int numPizzas)
		{
			m_numPizzas = numPizzas;
			Pizza[] array = new Pizza[numPizzas];
			m_order = array;
		}
		/**
		 * add pizzas
		 * @param pizza
		 * @return
		 */
		public int addPizza(Pizza pizza)
		{
			for(int i =0; i < m_numPizzas; ++i)
				{
					if(this.m_order[i] != null)
						{
							continue;
						}
					else if (this.m_order[i] == null)
						{
							this.m_order[i] = pizza;
							return 1;
						}
					
				}
			return -1;
		}
		
		/**
		 * calculate costs
		 * @return
		 */
		
		public double calcTotal(){
		    double totalCost = 0;
		   
		    for(int i = 0; i < m_numPizzas; ++i)
		    	{
		    		totalCost += m_order[i].calcCost();
		    	}
		    return totalCost;
		  }

		/**
		 * to string
		 */

		public String toString()
			{
				return "PizzaOrder [m_numPizzas=" + m_numPizzas + ", m_order=" + Arrays.toString(m_order)
						+ ", calcTotal()=" + calcTotal() + "]";
			}
		
		


	}

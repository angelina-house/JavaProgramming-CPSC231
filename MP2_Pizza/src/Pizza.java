

/**
 * @author angelinahouse
 *
 */
public class Pizza
	{
		private String m_size;
		private int m_cheese;
		private int m_pepperoni;
		private int m_veggie;
		
/**
 *  default constrctor 		
 */
		
		
	/**
	 *  overloaded constructor
	 * @param m_size
	 * @param m_cheese
	 * @param m_pepperoni
	 * @param m_veggie
	 */
		
		  public Pizza(String size, int cheeseToppings, int pepperoniToppings, int veggieToppings){
			    m_size = size;
			    m_cheese = cheeseToppings;
			    m_pepperoni = pepperoniToppings;
			    m_veggie = veggieToppings;
			  }

			public Pizza()
				{
					m_size = "small";
					m_cheese = 1;
					m_pepperoni = 0;
					m_veggie = 0;
				}

			  /**
			    * Copy constructor
			    * @param og copies for member variables
			    */
			  // Copy constructor
			  public Pizza(Pizza og){
			    this.m_size = og.m_size;
			    this.m_cheese = og.m_cheese;
			    this.m_pepperoni = og.m_pepperoni;
			    this.m_veggie = og.m_veggie;
			  }

	/**
	 *  getters and setters
	 * @return
	 */
		public String getM_size()
			{
				return m_size;
			}

		public void setM_size(String m_size)
			{
				this.m_size = m_size;
			}

		public int getM_cheese()
			{
				return m_cheese;
			}

		public void setM_cheese(int m_cheese)
			{
				this.m_cheese = m_cheese;
			}

		public int getM_pepperoni()
			{
				return m_pepperoni;
			}

		public void setM_pepperoni(int m_pepperoni)
			{
				this.m_pepperoni = m_pepperoni;
			}

		public int getM_veggie()
			{
				return m_veggie;
			}

		public void setM_veggie(int m_veggie)
			{
				this.m_veggie = m_veggie;
			}

/**
 * 	calculates cost
 * @return
 */
		public double calcCost()
		{
			double cost = 0.0;
			int totalToppings = m_cheese + m_pepperoni + m_veggie;
			cost += 2.0 * totalToppings;
			
			if (m_size.equals("large"))
				{
					cost += 14.0;
				}
			else if (m_size.equals("medium"))
				{
					cost += 12.0;
				}
			else
				{
					cost += 10.0;
				}
			return cost;
		}

/**
 *  toString
 */
		public String toString()
			{
				return "Pizza [m_size=" + m_size + ", m_cheese=" + m_cheese + ", m_pepperoni=" + m_pepperoni
						+ ", m_veggie=" + m_veggie + ", calcCost()=" + calcCost() + "]";
			}
		

/**
 * equals		
 * @param otherPizza
 * @return
 */
		public boolean equals(Pizza otherPizza)
		{
			if (this.m_size.equals(otherPizza.m_size) && (this.m_cheese == otherPizza.m_cheese) && (this.m_pepperoni == otherPizza.m_pepperoni) && (this.m_veggie == otherPizza.m_veggie) )
				{
					return true;
				}
			else 
				{
					return false;
				}
		}


		 
		 

	}

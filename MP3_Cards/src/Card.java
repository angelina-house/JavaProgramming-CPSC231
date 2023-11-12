

public class Card
	{
		private int m_suit;
		private int m_value;
		
		public static final int HEARTS = 0;
		public static final int SPADES = 1;
		public static final int CLUBS = 2;
		public static final int DIAMONDS = 3;

		public static final int JACK = 11;
		public static final int QUEEN = 12;
		public static final int KING = 13;
		public static final int ACE = 14;
		
		// default constructor
		public Card()
		{
			m_suit = 0;
			m_value = 0;
		}
		
		// overloaded constructor
		public Card(int suit, int value)
		{
			if ((suit >= 0) && (suit <= 3) && (value >= 2) && (value <= 14))
				{
					m_suit = suit;
					m_value = value;	
				}
			else
				{
					System.out.println("Invalid suit or value");
				}
		}
		
		// copy constructor
		public Card(Card otherCard)
		{
			this.m_suit = otherCard.m_suit;
			this.m_value = otherCard.m_value;
		}

		// equals
		public boolean equals(Object obj)
			{
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Card other = (Card) obj;
				return m_suit == other.m_suit && m_value == other.m_value;
			}

		// getters and setters
		public int getM_suit()
			{
				return m_suit;
			}

		public void setM_suit(int m_suit)
			{
				this.m_suit = m_suit;
			}

		public int getM_value()
			{
				return m_value;
			}

		public void setM_value(int m_value)
			{
				this.m_value = m_value;
			}

		// toString
		public String toString()
			{
				String faceName;
		        String suitName;
		        
		        switch (this.m_value) 
		        	{
		            case 11: faceName = "Jack";
		                break;
		            case 12: faceName = "Queen";
		                break;
		            case 13:  faceName = "King";
		                break;
		            case 14: faceName = "Ace";
		                break;
		            default: faceName = String.valueOf(this.m_value);
		        	}

		        switch (this.m_suit) 
		        	{
		            case 0: suitName = "Hearts";
		                break;
		            case 1: suitName = "Spades";
		                break;
		            case 2: suitName = "Clubs";
		                break;
		            case 3: suitName = "Diamonds";
		                break;
		            default: suitName = "somethings wrong";
		                break;
		        	}
		        return faceName + " of " + suitName;
			}
		
	}

import java.util.LinkedList;
import java.util.Random;

public class Deck
	{
		Random rand = new Random();
		LinkedList<Card> m_cards = new LinkedList<Card>();
		
		// default constructor
		public Deck()
		{
			int suit;
			int value;
			
			for(suit = 0; suit < 4; suit++)
				{
					for(value = 2; value < 15; value++)
						{
							m_cards.add(new Card(suit, value));
						}
				}
		}
		
		// size
		public int size()
		{
			return m_cards.size();
		}
		
		// copy constructor
		public Deck( Deck otherDeck)
		{
			for(int i = 0; i < otherDeck.size(); i++)
				{
					m_cards.add(new Card(otherDeck.m_cards.get(i)));
				}
		}
		
		// deal
		public Card deal()
		{
			int randInt = rand.nextInt(size());
			
			Card cardCopy = new Card(m_cards.get(randInt));
			m_cards.remove(randInt);
			return cardCopy;
		}
		
		// discarded cards
		 public Deck(LinkedList<Card> discarded)
			 {
		        this.m_cards = discarded;
			 }

		// to string
		public String toString()
			{
				String format = "";
		        
		        for (int i = 0; i < this.m_cards.size(); i++) 
		        	{
		        		format += this.m_cards.get(i) + "\n";
		        	}

		        return format;		
		        
		        }
		
		
		
		
	}

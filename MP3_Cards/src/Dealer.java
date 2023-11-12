import java.util.LinkedList;

public class Dealer
	{
		private Deck m_deck;
		
		// default 
		public Dealer()
		{
			m_deck = new Deck();
		}
		
		//  deal
		public LinkedList<Card> deals(int n)
		{
			LinkedList<Card> dealtCards = new LinkedList<Card>();
			
			 if (!(this.m_deck.size() == 0)) 
				 {
		            for (int i = 0; i < n; i++) 
		            	{
		                dealtCards.add(this.m_deck.deal());
		            	}
				 }

		        return dealtCards;
		}
		
		//discarded cards
	    public void discarded(Deck discards) 
	    	{
	    		this.m_deck = discards;
	    	}

		
		// size
		public int size()
		{
			return m_deck.size();
		}

		// to string
		public String toString()
			{
				return this.m_deck.toString();
			}
		

		
		
	}

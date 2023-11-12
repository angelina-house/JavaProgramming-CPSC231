import java.util.LinkedList;
import java.util.*;

public class Player
	{
		Random rand = new Random();
		
		private int playerNum;
		private LinkedList<Card> hand = new LinkedList<Card>();
		private boolean hasSpoon;
		
		//  default constructor
		public Player(int playerNum, Dealer dealer) 
			{
		        this.playerNum = playerNum;
		        this.hand = dealer.deals(4);
		        this.hasSpoon = false;
			}
		
		// steal spoon
		public void stealSpoon()
		{
			this.hasSpoon = true;
			
			Game.nSpoons -= 1;
		}
		
		// check matches
	   public LinkedList<Card> checkMatches() 
		   {
		        HashMap<Integer, LinkedList<Card>> matches = new HashMap<Integer, LinkedList<Card>>();
		        int min = 1000;
		 
		        for(int i = 2; i < 15; i++) 
		        	{  
		        		matches.put(Integer.valueOf(i), new LinkedList<Card>());
		        	}
	
		        for(Integer i : matches.keySet()) 
		        	{ 
		            for(Card c : this.hand)
		            	{
		                if(c.getM_value() == i) 
		                	{
		                    matches.get(i).add(c);
		                	}
		            	}
		        	}
	
		        for(LinkedList<Card> ll : matches.values()) 
		        	{
		        		if((ll.size() < min) && (ll.size() > 0)) 
		        			{ 
		        				min = ll.size();
		        			}
		        	}
	
		        for(Integer i : matches.keySet()) 
		        	{
		        		if(matches.get(i).size() == min) 
		        			{
		        				return matches.get(i); 
		        			}
		        	}
	
		        return new LinkedList<Card>();
		   	}
		
		
		// take turn
		public Card takeTurn(Card passedCard) 
			{
		        Card cardToPass = passedCard;
		        this.hand.add(passedCard); 
		        LinkedList<Card> currMatches = checkMatches();
		        
		        for (Card c : this.hand)
		        	{ 
		            int t = 0;
		            for (Card d : this.hand) 
		            	{
		                if(c.equals(d)) 
		                	{
		                    t += 1;
		                	}
		            	}
		            if(t == 4) 
		            	{
		                stealSpoon();
		                break;
		            	}
		        	}
		        
		        for(Card c : this.hand) 
		        	{ 
			            if(currMatches.contains(c))
			            	{ 
			                cardToPass = c;
			                this.hand.remove(cardToPass);
			                break;
			            }
		        	}
	
		        return cardToPass;
	    }

		// getters
		public int getPlayerNum()
			{
				return playerNum;
			}



		public LinkedList<Card> getHand()
			{
				return hand;
			}




		public boolean hasSpoon()
			{
				return hasSpoon;
			}


		// to string
		public String toString()
			{
				return "Player [playerNum=" + playerNum + "]";
			}
		
		
		
		
		
		  
	}

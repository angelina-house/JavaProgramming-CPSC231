import java.util.LinkedList;
import java.util.Random;

public class Game
	{
		private Player[] players;
		private Dealer dealer;
		public static int nSpoons;
		
		// defualt constructor
		public Game()
			{
				nSpoons = 3;
				this.dealer = new Dealer();
				this.players = new Player[4];
				
				for(int i = 0; i < players.length; i++)
					{
						this.players[i] = new Player((i + 1), this.dealer);
					}
			}
		
		// overloaded construstor
		public Game(int numPlayers)
		{
			nSpoons = numPlayers - 1;
			this.dealer = new Dealer();
			players = new Player[numPlayers];
			
			for (int i = 0; i < players.length; i++)
				{
					this.players[i] = new Player((i+1), this.dealer);
				}
					
		}
		
		// play method
	    public int play() 
	    	{
	    		this.dealer = new Dealer();
	        
	    		while(nSpoons > 0) 
	    			{
			            LinkedList<Card> discardPile = new LinkedList<Card>(); //start a discard pile
			            
			            Card passed = new Card(); //instantiate card 
		
			            LinkedList<Card> startHand = this.dealer.deals(1); //start with one card from same dealer deck
		
			            Card start = startHand.get(0); //that card above
		
			            for(int i = 0; i < players.length; i++) 
			            	{
				                if(dealer.size() == 0)
				                	{ 
					                    Deck discard = new Deck(discardPile);
					                    this.dealer.discarded(discard);
				                	}
			                
				                if(i == 0) 
				                	{
				                		passed = players[i].takeTurn(start);
				                	}
		
				                passed = players[i].takeTurn(passed); //if not, take passed card
		
				                if(i == (players.length - 1)) 
				                	{
				                		discardPile.add(passed); 
				                	}
		
				                if(nSpoons < (players.length - 1)) 
				                	{ 
					                    Random randy = new Random();
					                    int rand = randy.nextInt(3);
					                    int randPlayer = randy.nextInt(players.length);
				
					                    if(rand == 0)
					                    	{
					                    		players[randPlayer].stealSpoon();
					                    	}
				                	}
			            	}
	    			}
	    		for (Player p : players)
	    			{
	    				if (p.hasSpoon() == false)
	    					{
	    						return p.getPlayerNum();
	    					}
	    			}
	    		
	    		return -1;
	    		
	    	}

	    // getters
		public Player[] getPlayers()
			{
				return players;
			}

		public Dealer getDealer()
			{
				return dealer;
			}

		public static int getnSpoons()
			{
				return nSpoons;
			}
	    
		
	}

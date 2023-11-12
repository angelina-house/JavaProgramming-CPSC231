Classes outline:

		Account Class:
		Account - Abstract class for both Artist and Listener accounts
		Artist - Inherits from Account and represents an artist account
		Listener - Inherits from Account and represents a listener account
		
		
		Content Class:
		Content - Abstract class for both songs and podcasts
		Song - Inherits from content and represents a song
		Podcast: Inherits from content and represents a podcast
		
		Collection Class:
		Collection - Abstract base class for both playlists and albums
		Playlist - Inherits from collection and represents a playlist
		Album - Inherits from collection and represents an album
		
		
		Driver Class:
					- Contains the main method and serves as the user interface for the music app
					- populates the app with default Songs, Artists, Podcasts, Playlists, and Albums.
					- provides menu 

Diagram: 
Driver
	l
	v
Account -> artist, listener
Content -> song, podcast
Collection -> playlist

I divided everything up the way that i did because it just made the most sense to me to do it that way. Content would hold singular objects and 
collections would hold groups of objects. Account handled the accounts (makes sense) and the driver is the club that can hit a golf ball the farthest.
In terms of challenges i didnt have any really. I just had to remember how to do stuff right. In the future i think it would be cool for this to have a 
web interface and be a web player. Basically just a knock off spotify. 




public class Podcast extends Content
	{
		private int episodeNumber;

		public Podcast(String title, String artist, int episodeNumber)
			{
				super(title, artist);
				this.episodeNumber = episodeNumber;
			}

		public int getEpisodeNumber()
			{
				return episodeNumber;
			}
	}

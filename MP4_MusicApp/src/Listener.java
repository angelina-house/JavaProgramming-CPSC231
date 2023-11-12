import java.util.ArrayList;
import java.util.List;

public class Listener extends Account
	{
		private List<Content> favorites;

		public Listener(String name)
			{
				super(name);
				favorites = new ArrayList<>();
			}

		public void favorite(Content content)
			{
				favorites.add(content);
			}

		/**
		 * @return the favorites
		 */
		public List<Content> getFavorites()
			{
				return favorites;
			}

		/**
		 * @param favorites the favorites to set
		 */
		public void setFavorites(List<Content> favorites)
			{
				this.favorites = favorites;
			}

	}

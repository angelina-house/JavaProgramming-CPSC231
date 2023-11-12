public class Playlist extends Collection
	{
		public Playlist(String title)
			{
				super(title);
			}

		public void addContent(Content content)
			{
				contentList.add(content);
			}

		public void removeContent(Content content)
			{
				contentList.remove(content);
			}

		public void shuffle()
			{
				if (contentList.isEmpty())
					{
						System.out.println("Playlist is empty.");
						return;
					}

				int randomIndex = (int) (Math.random() * contentList.size());
				Content randomContent = contentList.get(randomIndex);
				randomContent.play();
			}

		@Override
		public void play()
			{
				if (contentList.isEmpty())
					{
						System.out.println("Playlist is empty.");
						return;
					}

				for (Content content : contentList)
					{
						content.play();
					}
			}
	}

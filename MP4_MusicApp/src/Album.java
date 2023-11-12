public class Album extends Collection
	{
		public Album(String title)
			{
				super(title);
			}

		public void addContent(Content content)
			{
				contentList.add(content);
			}

		@Override
		public void play()
			{
				if (contentList.isEmpty())
					{
						System.out.println("Album is empty.");
						return;
					}

				for (Content content : contentList)
					{
						content.play();
					}
			}
	}

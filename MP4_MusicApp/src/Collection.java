import java.util.ArrayList;
import java.util.List;

public abstract class Collection implements Comparable<Collection>
	{
		protected String title;
		protected List<Content> contentList;

		public Collection(String title)
			{
				this.title = title;
				this.contentList = new ArrayList<>();
			}

		public String getTitle()
			{
				return title;
			}

		public List<Content> getContentList()
			{
				return contentList;
			}

		public abstract void play();

		@Override
		public int compareTo(Collection other)
			{
				return Integer.compare(this.contentList.size(), other.contentList.size());
			}
	}

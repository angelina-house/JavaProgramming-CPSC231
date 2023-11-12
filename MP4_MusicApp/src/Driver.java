import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver
	{
		private List<Playlist> playlists;
		private List<Album> albums;
		private List<Listener> listeners;

		public Driver()
			{
				playlists = new ArrayList<>();
				albums = new ArrayList<>();
				listeners = new ArrayList<>();
				populateDefaultData();
			}

		public void run()
			{
				Scanner scanner = new Scanner(System.in);

				while (true)
					{
						printMenu();
						int choice = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character

						switch (choice) {
							case 1:
								createListenerAccount(scanner);
								break;
							case 2:
								listAllCollections();
								break;
							case 3:
								addSongToPlaylist(scanner);
								break;
							case 4:
								shufflePlaylistOrListenToAlbum(scanner);
								break;
							case 5:
								addContentToFavorites(scanner);
								break;
							case 6:
								exportFavoritesToFile(scanner);
								break;
							case 7:
								System.out.println("Exiting the program...");
								return;
							default:
								System.out.println("Invalid choice. Please try again.");
						}
					}
			}

		private void printMenu()
			{
				System.out.println("\n------ Music Streaming App ------");
				System.out.println("1. Create a listener account");
				System.out.println("2. List all playlists and albums");
				System.out.println("3. Add songs to an existing playlist");
				System.out.println("4. Shuffle an existing playlist or listen to an album");
				System.out.println("5. Add a song or podcast to favorites");
				System.out.println("6. Export all favorites to a file");
				System.out.println("7. Exit");
				System.out.print("Enter your choice: ");
			}

		private void createListenerAccount(Scanner scanner)
			{
				System.out.print("Enter the listener's name: ");
				String name = scanner.nextLine();

				Listener listener = new Listener(name);
				listeners.add(listener);

				System.out.println("Listener account created successfully!");
			}

		private void listAllCollections()
			{
				System.out.println("\n--- Playlists ---");
				for (Playlist playlist : playlists)
					{
						System.out.println("Playlist: " + playlist.getTitle());
						System.out.println("Contents: ");
						for (Content content : playlist.getContentList())
							{
								System.out.println("- " + content.getTitle() + " by " + content.getArtist());
							}
						System.out.println();
					}

				System.out.println("--- Albums ---");
				for (Album album : albums)
					{
						System.out.println("Album: " + album.getTitle());
						System.out.println("Contents: ");
						for (Content content : album.getContentList())
							{
								System.out.println("- " + content.getTitle() + " by " + content.getArtist());
							}
						System.out.println();
					}
			}

		private void addSongToPlaylist(Scanner scanner)
			{
				if (playlists.isEmpty())
					{
						System.out.println("There are no playlists available.");
						return;
					}

				System.out.println("Available Playlists: ");
				for (int i = 0; i < playlists.size(); i++)
					{
						System.out.println((i + 1) + ". " + playlists.get(i).getTitle());
					}

				System.out.print("Select a playlist (enter the number): ");
				int playlistIndex = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				if (playlistIndex < 1 || playlistIndex > playlists.size())
					{
						System.out.println("Invalid playlist selection.");
						return;
					}

				System.out.print("Enter the title of the song: ");
				String title = scanner.nextLine();
				System.out.print("Enter the artist of the song: ");
				String artist = scanner.nextLine();

				Song song = new Song(title, artist);
				playlists.get(playlistIndex - 1).addContent(song);

				System.out.println("Song added to the playlist successfully!");
			}

		private void shufflePlaylistOrListenToAlbum(Scanner scanner)
			{
				System.out.print("Enter 'p' to shuffle a playlist or 'a' to listen to an album: ");
				String choice = scanner.nextLine();

				if (choice.equalsIgnoreCase("p"))
					{
						if (playlists.isEmpty())
							{
								System.out.println("There are no playlists available.");
								return;
							}

						System.out.println("Available Playlists: ");
						for (int i = 0; i < playlists.size(); i++)
							{
								System.out.println((i + 1) + ". " + playlists.get(i).getTitle());
							}

						System.out.print("Select a playlist (enter the number): ");
						int playlistIndex = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character

						if (playlistIndex < 1 || playlistIndex > playlists.size())
							{
								System.out.println("Invalid playlist selection.");
								return;
							}

						playlists.get(playlistIndex - 1).shuffle();
					}
				else if (choice.equalsIgnoreCase("a"))
					{
						if (albums.isEmpty())
							{
								System.out.println("There are no albums available.");
								return;
							}

						System.out.println("Available Albums: ");
						for (int i = 0; i < albums.size(); i++)
							{
								System.out.println((i + 1) + ". " + albums.get(i).getTitle());
							}

						System.out.print("Select an album (enter the number): ");
						int albumIndex = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character

						if (albumIndex < 1 || albumIndex > albums.size())
							{
								System.out.println("Invalid album selection.");
								return;
							}

						albums.get(albumIndex - 1).play();
					}
				else
					{
						System.out.println("Invalid choice.");
					}
			}

		private void addContentToFavorites(Scanner scanner)
			{
				if (listeners.isEmpty())
					{
						System.out.println("There are no listeners available.");
						return;
					}

				System.out.println("Available Listeners: ");
				for (int i = 0; i < listeners.size(); i++)
					{
						System.out.println((i + 1) + ". " + listeners.get(i).getName());
					}

				System.out.print("Select a listener (enter the number): ");
				int listenerIndex = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				if (listenerIndex < 1 || listenerIndex > listeners.size())
					{
						System.out.println("Invalid listener selection.");
						return;
					}

				Listener listener = listeners.get(listenerIndex - 1);

				System.out.print("Enter the title of the content: ");
				String title = scanner.nextLine();
				System.out.print("Enter the artist of the content: ");
				String artist = scanner.nextLine();

				Content content = new Song(title, artist);
				listener.favorite(content);

				System.out.println("Content added to favorites successfully!");
			}

		private void exportFavoritesToFile(Scanner scanner)
			{
				if (listeners.isEmpty())
					{
						System.out.println("There are no listeners available.");
						return;
					}

				System.out.println("Available Listeners: ");
				for (int i = 0; i < listeners.size(); i++)
					{
						System.out.println((i + 1) + ". " + listeners.get(i).getName());
					}

				System.out.print("Select a listener (enter the number): ");
				int listenerIndex = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				if (listenerIndex < 1 || listenerIndex > listeners.size())
					{
						System.out.println("Invalid listener selection.");
						return;
					}

				Listener listener = listeners.get(listenerIndex - 1);

				System.out.print("Enter the file name to export favorites: ");
				String fileName = scanner.nextLine();

				try (FileWriter writer = new FileWriter(fileName))
					{
						List<Content> favorites = listener.getFavorites();
						Collections.sort(favorites);

						for (Content content : favorites)
							{
								writer.write(content.getTitle() + " by " + content.getArtist() + "\n");
							}

						System.out.println("Favorites exported to file successfully!");
					}
				catch (IOException e)
					{
						System.out.println("An error occurred while exporting favorites to file.");
						e.printStackTrace();
					}
			}

		private void populateDefaultData()
			{
				// Populate default playlists
				Playlist playlist1 = new Playlist("Rock Classics");
				playlist1.addContent(new Song("Bohemian Rhapsody", "Queen"));
				playlist1.addContent(new Song("Hotel California", "Eagles"));
				playlist1.addContent(new Song("Stairway to Heaven", "Led Zeppelin"));
				playlists.add(playlist1);

				Playlist playlist2 = new Playlist("Chillout Mix");
				playlist2.addContent(new Song("All of Me", "John Legend"));
				playlist2.addContent(new Song("Thinking Out Loud", "Ed Sheeran"));
				playlist2.addContent(new Song("Stay", "Rihanna ft. Mikky Ekko"));
				playlists.add(playlist2);

				// Populate default albums
				Album album1 = new Album("Greatest Hits");
				album1.addContent(new Song("Shape of My Heart", "Sting"));
				album1.addContent(new Song("Imagine", "John Lennon"));
				album1.addContent(new Song("Yesterday", "The Beatles"));
				albums.add(album1);

				Album album2 = new Album("Pop Sensations");
				album2.addContent(new Song("Bad Guy", "Billie Eilish"));
				album2.addContent(new Song("Blinding Lights", "The Weeknd"));
				album2.addContent(new Song("Dance Monkey", "Tones and I"));
				albums.add(album2);
			}

		public static void main(String[] args)
			{
				Driver driver = new Driver();
				driver.run();
			}
	}

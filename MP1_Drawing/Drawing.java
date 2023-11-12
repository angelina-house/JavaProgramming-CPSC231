//import java.util.Arrays;

public class Drawing
	{

		public static char[][] createCanvas(int w, int h)
			{
				char[][] canvas = new char[h][w];
				for( int r =0; r < canvas.length; r++ )
					{
						for( int c=0; c <=canvas[r].length-1; c++)
							{
								//corners
								if (( r == 0 && c == 0) || (r == 0 && c == w-1) || (r == h-1 && c==0) || (r == h-1 && c == w-1))
									{
										canvas[r][c] = '+';
									}
								//top and bottom
								else if(r == 0 || r == h-1)
									{
										canvas[r][c] = '=';
									}
								//sides
								else if (c == 0 || c == w-1)
									{
										canvas[r][c] = '|';
									}
								//inside
								else
									{
										canvas[r][c] = ' ';

									}



							}
						// used to check array item placement
				        //System.out.println(Arrays.deepToString(canvas));


					}
				return canvas;

			}

		static void addCharacter(char[][]canvas, char add, int x, int y)
			{
				//adds character
				canvas[y][x] = add;
			}

		public static void printCanvas(char[][] canvas)
			{
				//loops thru array to print
				for (char[] element : canvas)
					{
						for (int c = 0; c <= element.length-1; c++)
							{
								System.out.print(element[c]);
							}
						System.out.println();
					}

			}

		public static void main(String[] args)
			{
				//call methods
				char[][]  canvas = Drawing.createCanvas(20, 5);
				Drawing.addCharacter(canvas, '<', 9, 2);
				Drawing.addCharacter(canvas, '3', 10, 2);
				Drawing.printCanvas(canvas);


			}

	}

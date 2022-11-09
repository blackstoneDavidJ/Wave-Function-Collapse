package wfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Main {

	private static final String FILE_EXT  = ".png";
	private static final int WINDOW_SIZE  = 149;
	public static void main(String[] args) {
		String resources = "C://Users//Hailey//Desktop//David Code//wfc//Wave-Function-Collapse//WaveFunction//resources//"; 
		String outputResources = "C://Users//Hailey//Desktop//David Code//wfc//Wave-Function-Collapse//WaveFunction//output_resources//";;
		ArrayList<Tile> images = setTiles(resources, FILE_EXT);
		WaveFunction wfc = new WaveFunction(images, WINDOW_SIZE, 50);
		try {
			File output = new File(outputResources +"test.png");
			BufferedImage img = wfc.waveFunction();
			ImageIO.write(img, "png", output);
			System.out.println("Done.");
		}

		catch(IOException e) { e.printStackTrace(); }

		System.out.println((int) 7/2);
	}

	private static ArrayList<Tile> setTiles(String path, String ext) {
		ArrayList<Tile> images = new ArrayList<Tile>();
		try {
			Piece[][] up = new Piece[][] {
				{
					Piece.DOWN,
					Piece.RIGHT,
					Piece.LEFT
				},
				{
					Piece.DOWN,
					Piece.BLANK
				},
				{
					Piece.LEFT,
					Piece.DOWN
				},
				{
					Piece.DOWN,
					Piece.RIGHT
				}
			};

			Piece[][] down = new Piece[][] {
				{
					Piece.BLANK,
					Piece.UP
				},
				{
					Piece.BLANK,
					Piece.LEFT,
					Piece.UP
				},
				{
					Piece.LEFT,
					Piece.UP
				},
				{
					Piece.RIGHT,
					Piece.UP
				}
			};

			Piece[][] right = new Piece[][] {
				{
					Piece.LEFT,
					Piece.DOWN
				},
				{
					Piece.LEFT,
					Piece.UP
				},
				{
					Piece.UP,
					Piece.LEFT,
					Piece.DOWN
				},
				{
					Piece.BLANK,
					Piece.LEFT
				}
			};

			Piece[][] left = new Piece[][] {
				{
					Piece.DOWN,
					Piece.RIGHT
				},
				{
					Piece.RIGHT,
					Piece.UP
				},
				{
					Piece.BLANK,
					Piece.RIGHT
				},
				{
					Piece.RIGHT,
					Piece.DOWN,
					Piece.UP
				}
			};

			Piece[][] blank = new Piece[][] {
				{
					Piece.UP
				},
				{
					Piece.DOWN
				},
				{
					Piece.RIGHT
				},
				{
					Piece.LEFT
				}
			};

			images.add(new Tile(ImageIO.read(new File(path + "up.png")),    up,     Piece.UP   ));
			images.add(new Tile(ImageIO.read(new File(path + "down.png")),  down,   Piece.DOWN ));
			images.add(new Tile(ImageIO.read(new File(path + "right.png")), right,  Piece.RIGHT));
			images.add(new Tile(ImageIO.read(new File(path + "left.png")),  left,   Piece.LEFT ));
			images.add(new Tile(ImageIO.read(new File(path + "blank.png")), blank,  Piece.BLANK));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return images;
	}
}

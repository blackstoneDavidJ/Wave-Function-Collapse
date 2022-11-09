package wfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import wfc.Tile.Piece;

public class Main {

	private static final String RESOURCES = "C:/Users/daveb/Desktop/WaveFunctionCollapse/Wave-Function-Collapse/WaveFunction/resources/";
	private static final String OUTPUT_RESOURCES = "C:/Users/daveb/Desktop/WaveFunctionCollapse/Wave-Function-Collapse/WaveFunction/output_resources/";
	private static final String FILE_EXT  = ".png";
	private static final int WINDOW_SIZE  = 500;
	public static void main(String[] args) {

		/*ArrayList<Tile> images = setTiles(RESOURCES, FILE_EXT);
		WaveFunction wfc = new WaveFunction(images, WINDOW_SIZE, 50);
		try {
			File output = new File(OUTPUT_RESOURCES +"test.png");
			BufferedImage img = wfc.waveFunction();
			ImageIO.write(img, "png", output);
			System.out.println("Done.");

			
		}

		catch(IOException e) { e.printStackTrace(); }*/

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

			images.add(new Tile(ImageIO.read(new File(RESOURCES + "up.png")),    up,     Piece.UP   ));
			images.add(new Tile(ImageIO.read(new File(RESOURCES + "down.png")),  down,   Piece.DOWN ));
			images.add(new Tile(ImageIO.read(new File(RESOURCES + "right.png")), right,  Piece.RIGHT));
			images.add(new Tile(ImageIO.read(new File(RESOURCES + "left.png")),  left,   Piece.LEFT ));
			images.add(new Tile(ImageIO.read(new File(RESOURCES + "blank.png")), blank,  Piece.BLANK));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return images;
	}
}

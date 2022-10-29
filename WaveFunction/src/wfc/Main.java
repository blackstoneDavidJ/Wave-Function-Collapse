package wfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import wfc.Tile.Piece;

public class Main {

	private static final String RESOURCES = "resources/";
	private static final String FILE_EXT  = ".png";
	public static void main(String[] args) {

		ArrayList<Tile> images = setTiles(RESOURCES, FILE_EXT);
		WaveFunction wfc = new WaveFunction(images);
		wfc.waveFunction();
	}

	private static ArrayList<Tile> setTiles(String path, String ext) {
		ArrayList<Tile> images = new ArrayList<Tile>();
		try {
			int[][] v1 = new int[][] {{}};
			int[][] v2 = new int[][] {{}};
			int[][] v3 = new int[][] {{}};
			int[][] v4 = new int[][] {{}};
			int[][] v5 = new int[][] {{}};

			images.add(new Tile(ImageIO.read(new File(path +"up" +ext)), v1, Piece.UP));
			images.add(new Tile(ImageIO.read(new File(path +"up" +ext)), v2, Piece.DOWN));
			images.add(new Tile(ImageIO.read(new File(path +"up" +ext)), v3, Piece.LEFT));
			images.add(new Tile(ImageIO.read(new File(path +"up" +ext)), v4, Piece.RIGHT));
			images.add(new Tile(ImageIO.read(new File(path +"up" +ext)), v5, Piece.BLANK));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return images;
	}
}

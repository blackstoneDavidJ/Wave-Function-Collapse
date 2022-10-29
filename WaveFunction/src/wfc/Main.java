package wfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Main {

	private static final String RESOURCES = "resources/";
	private static final String FILE_EXT  = ".png";
	public static void main(String[] args) {

		ArrayList<BufferedImage> images = setImages(RESOURCES, FILE_EXT);
		WaveFunction wfc = new WaveFunction(images);
	}

	private static ArrayList<BufferedImage> setImages(String path, String ext) {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		try {
			images.add(ImageIO.read(new File(path +"up" +ext)));
			images.add(ImageIO.read(new File(path +"down" +ext)));
			images.add(ImageIO.read(new File(path +"left" +ext)));
			images.add(ImageIO.read(new File(path +"right" +ext)));
			images.add(ImageIO.read(new File(path +"blank" +ext)));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return images;
	}
}

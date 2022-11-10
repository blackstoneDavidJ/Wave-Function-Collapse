package wfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

	private static final int WINDOW_SIZE  = 100;
	private static final int TILE_SIZE    = 50;
	public static void main(String[] args) {
		String resources = "C://Users//David//Desktop//WaveFunctionCollapse//Wave-Function-Collapse//WaveFunction//resources//";
		//String resources = "C://Users//Hailey//Desktop//David Code//wfc//Wave-Function-Collapse//WaveFunction//resources//";
		String outputResources = "C://Users//David//Desktop//WaveFunctionCollapse//Wave-Function-Collapse//WaveFunction//output_resources//"; 
		//String outputResources = "C://Users//Hailey//Desktop//David Code//wfc//Wave-Function-Collapse//WaveFunction//output_resources//";;

		TileDistributor tDistro = new TileDistributor(resources);
		WaveFunction wfc = new WaveFunction(WINDOW_SIZE, TILE_SIZE, tDistro);
		try {
			File output = new File(outputResources +"test.png");
			BufferedImage img = wfc.createWFCImage();
			ImageIO.write(img, "png", output);
			System.out.println("Done.");
		}

		catch(IOException e) { e.printStackTrace(); }
	}
}

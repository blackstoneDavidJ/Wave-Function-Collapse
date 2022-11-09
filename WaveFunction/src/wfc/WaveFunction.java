package wfc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class WaveFunction {
    
    private ArrayList<Tile> tiles;
    private int imageSize;
    private int squareSize;
    private Tile[][] grid;

    public WaveFunction(ArrayList<Tile> tiles, int imageSize, int squareSize) {
        this.tiles = tiles;
        this.imageSize = imageSize;
        this.squareSize = squareSize;
        this.grid = new Tile[squareSize][squareSize];
    }

    public BufferedImage waveFunction() {
		BufferedImage img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        BufferedImage tmp = null;
        Random rand = new Random();
        rand.setSeed(1000);
        
        int imageCount = 0;
        int x=0,y=0;
        int endX = 50, endY = 50;
        int currYStart = 0;
        int currXStart = 0;
        int tileX = 0;
        int tileY = 0;
        
        while(imageCount < Math.pow((img.getWidth() / squareSize),2)) {
            tmp = tiles.get(rand.nextInt(tiles.size()-0) + 0).getTileImage();
            while(x < endX) {
                while(y < endY) {
                    img.setRGB(x , y, tmp.getRGB(tileX, tileY));
                    y++;
                    tileY++;
                }
                x++;
                tileX++;
                tileY = 0;
                y = currYStart;
            }

            if(x >= img.getWidth()) {
                x = currXStart;
                currYStart += 50;
                endY       += 50;
                endX = 50;
                y = currYStart;
                tileX = 0;
                tileY = 0;
            }

            else {
                x = endX;
                endX += 50;
                y = currYStart;
                tileX = 0;
                tileY = 0;
            }

            imageCount++;
        }

        return img;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
package wfc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        this.grid = new Tile[imageSize / squareSize][imageSize / squareSize];
    }

    private ArrayList<Tile> wavefunction() {
        
        ArrayList<Tile> list = new ArrayList<>();
        Random rand = new Random();
        int currX = (rand.nextInt(grid.length - 0) + 0);
        int currY = (rand.nextInt(grid.length - 0) + 0);
        
        Tile currTile = tiles.get(rand.nextInt(tiles.size()-0) + 0);
        grid[currX][currY] = currTile;
        
        Piece[][] availiblePieces;

        int i = 0;
        while( i < 4) {
            availiblePieces = currTile.getVertices();

            if(currY-1 >= 0) {
                availiblePieces
            }
            //left
            if(currX-1 >= 0) {
    
            }
            //right
            if(currX+1 <= grid.length) {
    
            }
            //down
            if(currY+1 <= grid.length) {
    
            }
        }
        //up


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(grid[i][j] != null) {
                    list.add(grid[i][j]);
                }
            }
        }

        return list;
    }

    public BufferedImage createWFCImage() {
		BufferedImage img = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
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
        wavefunction();
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
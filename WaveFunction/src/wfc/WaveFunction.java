package wfc;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random.*;

import javax.naming.ldap.StartTlsRequest;

public class WaveFunction {
    
    private ArrayList<Tile> tiles;
    private int imageSize;
    private Tile[][] grid;

    public WaveFunction(ArrayList<Tile> tiles, int imageSize, int squareSize) {
        this.tiles = tiles;
        this.imageSize = imageSize;
        this.grid = new Tile[squareSize][squareSize];
    }

    public BufferedImage waveFunction() {
		BufferedImage img = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
        int startX = 0;
        int startY = 0;
        int tileX  = 0;
        int tileY  = 0;
        int initY  = 0;
        int endX   = 50;
        int endY   = 50;
        int i = 0;
        BufferedImage tmp = null;
        Random rand = new Random();
        while(i < 10) {
            tmp = tiles.get(rand.nextInt(tiles.size()-0) + 0).getTileImage();
            while(startX < endX) {
                while(startY < endY) {
                    //System.out.println("x:" +startX +" y: " +startY + " = tx: " +tileX +" ty: "+tileY +" eX: " +endX +" eY: " +endY);
                    int rgb = 0;
                    try {
                        if(tileY == 50)  { 
                            break; 
                        }
                        rgb = tmp.getRGB(tileX, tileY);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("TileX: " + tileX + " TileY: " + tileY);
                        //rgb = tmp.getRGB(tileX, tileY);
                    }
                    
                    img.setRGB(startX, startY, rgb);
                    startY++;
                    tileY++;
                }
                tileY  = 0;
                tileX++;
                startY = initY;
                startX++;

            }

            if(startX < img.getWidth()) {
                startX = endX;
                startY = 0;
                endX += 50; 
            }
            else {
                startY = endY;
                initY  = endY;
                endY  += 50;
                endX   = 50;
                startX = 0;
            }

            tileX  = 0;
            tileY  = 0;
            i++;
        }

        return img;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
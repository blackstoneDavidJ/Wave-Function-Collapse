package wfc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WaveFunction {
    private int imageSize;
    private int squareSize;
    private Piece[][] grid;
    private Boolean[][] collapsedGrid;
    private TileDistributor tDistro;

    public WaveFunction(int imageSize, int squareSize, TileDistributor tDistro) {
        this.imageSize = imageSize;
        this.squareSize = squareSize;
        this.grid = new Piece[imageSize / squareSize][imageSize / squareSize];
        this.tDistro = tDistro;
    }

    private ArrayList<BufferedImage> wavefunction() {
        Random rand = new Random();
        Piece[] options = new Piece[] { Piece.UP, Piece.DOWN, Piece.LEFT, Piece.RIGHT, Piece.BLANK };

        int startX = rand.nextInt((imageSize/squareSize) + 0) + 0;
        int startY = rand.nextInt((imageSize/squareSize) + 0) + 0;
        Piece currPiece = options[rand.nextInt(4 + 0) + 0];
        grid[startX][startY] = currPiece;

        if(startX - 1 >= 0) {
            options = tDistro.getOptions(currPiece, Orientation.WEST);
            grid[startX - 1][startY] = options[0];
        } 

        if(startX + 1 <= grid.length) {
            options = tDistro.getOptions(currPiece, Orientation.EAST);
            grid[startX + 1][startY] = options[0];
        } 

        if(startY - 1 >= 0) {
            options = tDistro.getOptions(currPiece, Orientation.NORTH);
            grid[startX][startY - 1] = options[0];
        } 

        if(startX + 1 <= grid.length) {
            options = tDistro.getOptions(currPiece, Orientation.SOUTH);
            grid[startX][startY +1] = options[0];
        } 



        return arrayToBufferedImageList(grid);
    }

    private ArrayList<BufferedImage> arrayToBufferedImageList(Piece[][] grid) {
        ArrayList<BufferedImage> list = new ArrayList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(tDistro.getTile(grid[i][j]) != null) {
                    list.add(new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB));
                }
                else {
                    list.add(tDistro.getTile(grid[i][j]));
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
        int x = 0, y = 0;
        int endX = 50, endY = 50;
        int currYStart = 0;
        int currXStart = 0;
        int tileX = 0;
        int tileY = 0;
        ArrayList<BufferedImage> tiles = wavefunction();
        while(imageCount < Math.pow((img.getWidth() / squareSize),2)) {
            tmp = tiles.get(imageCount);
            
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
}
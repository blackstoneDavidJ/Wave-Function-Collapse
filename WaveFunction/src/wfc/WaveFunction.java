package wfc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class WaveFunction {
    
    private ArrayList<Tile> tiles;
    private int size;

    public WaveFunction(ArrayList<Tile> tiles, int size) {
        this.tiles = tiles;
        this.size = size;
    }

    public BufferedImage waveFunction() {
		return new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
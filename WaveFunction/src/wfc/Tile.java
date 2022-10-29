package wfc;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private int[][] vertices;
    private Piece piece;

    public Tile(BufferedImage image, int[][] vertices, Piece piece) {
        this.image = image;
        this.vertices = vertices;
        this.piece = piece;
    }

    public BufferedImage getTileImage() {
        return image;
    }

    public int[][] getVertices() {
        return vertices;
    }

    public Piece getPiece() {
        return piece;
    }
    
    public enum Piece {
        BLANK,
        UP,
        DOWN,
        RIGHT,
        LEFT;
    }
}

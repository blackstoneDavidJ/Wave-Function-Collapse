package wfc;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private Piece[][] vertices;
    private Piece piece;

    public Tile(BufferedImage image, Piece[][] vertices, Piece piece) {
        this.image = image;
        this.vertices = vertices;
        this.piece = piece;
    }

    public BufferedImage getTileImage() {
        return image;
    }

    public Piece[][] getVertices() {
        return vertices;
    }

    public Piece getPiece() {
        return piece;
    }

}
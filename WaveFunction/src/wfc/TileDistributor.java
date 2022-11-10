package wfc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class TileDistributor {
    private HashMap<Piece, BufferedImage> tiles;
    private HashMap<Piece, Piece[][]> rules;
    private String resources;

    public TileDistributor(String resources) {
        this.resources = resources;
        tiles = new HashMap<>();
        rules = new HashMap<>();
        initTiles();
        initRules();
    }

    public BufferedImage getTile(Piece piece) {
        return tiles.get(piece);
    }

    public Piece[] getOptions(Piece prevPiece, Orientation orientation) {
        Piece[] currPieceRules = new Piece[1];

        switch(prevPiece.name()) {
            case "UP":
                currPieceRules = rules.get(Piece.UP)[orientation.getRow()];
                break;
            case "DOWN":
                currPieceRules = rules.get(Piece.DOWN)[orientation.getRow()];
                break;
            case "LEFT":
                currPieceRules = rules.get(Piece.LEFT)[orientation.getRow()];
                break;
            case "RIGHT":
                currPieceRules = rules.get(Piece.RIGHT)[orientation.getRow()];
                break;
            case "BLANK":
                currPieceRules = rules.get(Piece.BLANK)[orientation.getRow()];
                break;
        }

        return currPieceRules;
    }

    private void initTiles() {
        try 
        {
            tiles.put(Piece.UP,    ImageIO.read(new File(resources +"up.png")));
            tiles.put(Piece.DOWN,  ImageIO.read(new File(resources +"down.png")));
            tiles.put(Piece.LEFT,  ImageIO.read(new File(resources +"left.png")));
            tiles.put(Piece.RIGHT, ImageIO.read(new File(resources +"right.png")));
            tiles.put(Piece.BLANK, ImageIO.read(new File(resources +"blank.png")));
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initRules() {
        Piece[][] up = new Piece[][] {
            {
                Piece.DOWN,
                Piece.RIGHT,
                Piece.LEFT
            },
            {
                Piece.DOWN,
                Piece.BLANK
            },
            {
                Piece.LEFT,
                Piece.DOWN
            },
            {
                Piece.DOWN,
                Piece.RIGHT
            }
        };

        Piece[][] down = new Piece[][] {
            {
                Piece.BLANK,
                Piece.UP
            },
            {
                Piece.BLANK,
                Piece.LEFT,
                Piece.UP
            },
            {
                Piece.LEFT,
                Piece.UP
            },
            {
                Piece.RIGHT,
                Piece.UP
            }
        };

        Piece[][] right = new Piece[][] {
            {
                Piece.LEFT,
                Piece.DOWN
            },
            {
                Piece.LEFT,
                Piece.UP
            },
            {
                Piece.UP,
                Piece.LEFT,
                Piece.DOWN
            },
            {
                Piece.BLANK,
                Piece.LEFT
            }
        };

        Piece[][] left = new Piece[][] {
            {
                Piece.DOWN,
                Piece.RIGHT
            },
            {
                Piece.RIGHT,
                Piece.UP
            },
            {
                Piece.BLANK,
                Piece.RIGHT
            },
            {
                Piece.RIGHT,
                Piece.DOWN,
                Piece.UP
            }
        };

        Piece[][] blank = new Piece[][] {
            {
                Piece.UP
            },
            {
                Piece.DOWN
            },
            {
                Piece.RIGHT
            },
            {
                Piece.LEFT
            }
        };

        rules.put(Piece.UP, up);
        rules.put(Piece.DOWN, down);
        rules.put(Piece.LEFT, left);
        rules.put(Piece.RIGHT, right);
        rules.put(Piece.BLANK, blank);
    }
}
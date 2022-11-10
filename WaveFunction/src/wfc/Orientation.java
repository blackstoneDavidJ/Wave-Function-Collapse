package wfc;

enum Orientation {
    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3);

    private int a;
    private Orientation(int a) {
        this.a = a;
    }

    public int getRow() {
        return this.a;
    }
}
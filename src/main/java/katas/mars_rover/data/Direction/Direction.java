package katas.mars_rover.data.Direction;

public abstract class Direction {

    private final String name;
    private final String leftNeighbor;
    private final String rightNeighbor;

    public Direction(String name, String leftNeighbor, String rightNeighbor) {
        this.name = name;
        this.leftNeighbor = leftNeighbor;
        this.rightNeighbor = rightNeighbor;
    }

    public String getName() {
        return name;
    }

    public String getLeftNeighbor() {
        return leftNeighbor;
    }

    public String getRightNeighbor() {
        return rightNeighbor;
    }
}

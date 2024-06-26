package representation.pieces;

public class Edge {
    public static final int LAYERS = 3;
    public static final int POSITIONS = 4;

    // 0 - 11: unique identifier
    private final int id;
    // 0 - 1: orientation 0 if {R, U, L, D} solvable, 1 if {F, B} required
    private int orientation;

    /**
     * Creates an edge piece with the given id and default orientation.
     *
     * @param id the unique identifier of the edge piece
     */
    public Edge(int id) {
        this(id, 0); // by default oriented right
    }

    /**
     * Creates an edge piece with the given id and orientation.
     *
     * @param id          the unique identifier of the edge piece
     * @param orientation the orientation 0 if {R, U, L, D} solvable, 1 if {F, B} required
     */
    public Edge(int id, int orientation) {
        this.id = id;
        this.orientation = orientation;
    }

    /**
     * Returns the layer where the edge piece belongs.
     *
     * @return the layer where the edge piece belongs.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the orientation of the edge piece.
     *
     * @return the orientation of the edge piece.
     */
    public int getOrientation() {
        return orientation;
    }

    /**
     * Sets the orientation of the edge piece.
     *
     * @param orientation the orientation of the edge piece.
     */
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    /**
     * Flips the orientation of the edge piece.
     */
    public void flipOrientation() {
        orientation = 1 - orientation;
    }

    /**
     * Returns the layer where the edge piece belongs.
     *
     * @return the layer where the edge piece belongs.
     */
    public int getLayer() {
        return id / LAYERS;
    }

    /**
     * Returns the position of the edge piece in the layer.
     *
     * @return the position of the edge piece in the layer.
     */
    public int getPosition() {
        return id % LAYERS;
    }
}

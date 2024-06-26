package representation.pieces;

public class Corner {
    public static final int LAYERS = 2;
    public static final int POSITIONS = 4;


    // 0 - 7: unique identifier
    private final int id;
    // 0 - 2: clockwise twists required to white/yellow up/down
    private int orientation;

    /**
     * Creates a corner piece with the given id and default orientation.
     *
     * @param id the unique identifier of the corner piece
     */
    public Corner(int id) {
        this(id, 0); // by default oriented right
    }

    /**
     * Creates a corner piece with the given id and orientation.
     *
     * @param id          the unique identifier of the corner piece
     * @param orientation the clockwise twists required to white/yellow up/down
     */
    public Corner(int id, int orientation) {
        this.id = id;
        this.orientation = orientation;
    }

    /**
     * Turns the corner piece clockwise.
     */
    public void turnClockwise() {
        // add 2 = -1 mod 3 to avoid negative values
        // now we have to repeat this twice to get back to zero
        orientation = (orientation + 2) % 3;
    }

    /**
     * Turns the corner piece counter-clockwise.
     */
    public void turnCounterClockwise() {
        // add 2 = -1 mod 3 to avoid negative values
        // now its one CW turn away from zero
        orientation = (orientation + 1) % 3;
    }

    /**
     * Returns the layer where the corner piece belongs.
     *
     * @return the layer where the corner piece belongs.
     */
    public int getLayer() {
        return id / LAYERS;
    }

    /**
     * Returns the position of the corner piece in the layer.
     *
     * @return the position of the corner piece in the layer.
     */
    public int getPosition() {
        return id % LAYERS;
    }

    /**
     * Returns the clockwise twists required to white/yellow up/down.
     *
     * @return the clockwise twists required to white/yellow up/down.
     */
    public int getOrientation() {
        return orientation;
    }

    /**
     * Sets the clockwise twists required to white/yellow up/down.
     *
     * @param orientation the clockwise twists required to white/yellow up/down.
     */
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    /**
     * Returns the unique identifier of the corner piece.
     *
     * @return the unique identifier of the corner piece.
     */
    public int getId() {
        return id;
    }
}

package representation;

import representation.pieces.Corner;
import representation.pieces.Edge;

public class ArrayCubeStateRepresentation {
    // Implied standard orientation - white up green front
    // First index is layer from top up
    // Second index is position in layer from the north(west) clockwise
    // Corner legend: <North/South><West/East><Top/Bottom>
    private final Corner[][] corners;
    private final Edge[][] edges;

    /**
     * Creates a new cube state representation with standard orientation.
     */
    public ArrayCubeStateRepresentation() {
        corners = new Corner[2][4];
        for (int i = 0; i < Corner.LAYERS; i++) {
            for (int j = 0; j < Corner.POSITIONS; j++) {
                corners[i][j] = new Corner(4 * i + j);
            }
        }

        edges = new Edge[3][4];
        for (int i = 0; i < Edge.LAYERS; i++) {
            for (int j = 0; j < Edge.POSITIONS; j++) {
                edges[i][j] = new Edge(4 * i + j);
            }
        }
    }

    /**
     * Applies permutation of pieces corresponding to the right move.
     */
    public void makeRightMove() {
        int[][] cornerFacePermutation = {{0, 2}, {1, 2}, {1, 1}, {0, 1}};
        makeImpliedFaceCornerPermutation(cornerFacePermutation);
        makeRightMoveCornerOrientation();

        int[][] edgeFacePermutation = {{0, 1}, {1, 2}, {2, 1}, {1, 1}};
        makeImpliedFaceEdgePermutation(edgeFacePermutation);
        // R preserves orientation
    }

    /**
     * Applies permutation of pieces corresponding to the right move, multiple times.
     * Negative amount corresponds to the counter-clockwise move.
     *
     * @param amount the amount of right moves to be made
     */
    public void makeRightMove(int amount) {
        if (amount < -1 || amount > 3) {
            throw new IllegalArgumentException("Amount of right moves must be between 0 and 3");
        }
        // Implementing prime moves as negative amount
        if (amount == -1) {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            makeRightMove();
        }
    }

    /**
     * Applies permutation of pieces corresponding to the left move.
     */
    public void makeLeftMove() {
        int[][] cornerFacePermutation = {{0, 0}, {1, 0}, {1, 3}, {0, 3}};
        makeImpliedFaceCornerPermutation(cornerFacePermutation);
        makeLeftMoveCornerOrientation();

        int[][] edgeFacePermutation = {{0, 3}, {1, 0}, {2, 3}, {1, 3}};
        makeImpliedFaceEdgePermutation(edgeFacePermutation);
        // L preserves orientation
    }

    /**
     * Applies permutation of pieces corresponding to the left move, multiple times.
     * Negative amount corresponds to the counter-clockwise move.
     *
     * @param amount the amount of left moves to be made
     */
    public void makeLeftMove(int amount) {
        if (amount < -1 || amount > 3) {
            throw new IllegalArgumentException("Amount of left moves must be between 0 and 3");
        }
        // Implementing prime moves as negative amount
        if (amount == -1) {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            makeLeftMove();
        }
    }

    /**
     * Applies permutation of pieces corresponding to the up move.
     */
    public void makeUpMove() {
        int[][] cornerFacePermutation = {{0, 0}, {0, 3}, {0, 2}, {0, 1}};
        makeImpliedFaceCornerPermutation(cornerFacePermutation);
        // U preserves corner orientation

        int[][] edgeFacePermutation = {{0, 3}, {0, 2}, {0, 1}, {0, 0}};
        makeImpliedFaceEdgePermutation(edgeFacePermutation);
        // U preserves orientation
    }

    /**
     * Applies permutation of pieces corresponding to the up move, multiple times.
     * Negative amount corresponds to the counter-clockwise move.
     *
     * @param amount the amount of up moves to be made
     */
    public void makeUpMove(int amount) {
        if (amount < -1 || amount > 3) {
            throw new IllegalArgumentException("Amount of up moves must be between 0 and 3");
        }
        // Implementing prime moves as negative amount
        if (amount == -1) {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            makeUpMove();
        }
    }

    /**
     * Applies permutation of pieces corresponding to the down move.
     */
    public void makeDownMove() {
        int[][] cornerFacePermutation = {{1, 0}, {1, 1}, {1, 2}, {1, 3}};
        makeImpliedFaceCornerPermutation(cornerFacePermutation);
        // D preserves corner orientation

        int[][] edgeFacePermutation = {{2, 0}, {2, 1}, {2, 2}, {2, 3}};
        makeImpliedFaceEdgePermutation(edgeFacePermutation);
        // D preserves orientation
    }

    /**
     * Applies permutation of pieces corresponding to the down move, multiple times.
     * Negative amount corresponds to the counter-clockwise move.
     *
     * @param amount the amount of down moves to be made
     */
    public void makeDownMove(int amount) {
        if (amount < -1 || amount > 3) {
            throw new IllegalArgumentException("Amount of down moves must be between 0 and 3");
        }
        // Implementing prime moves as negative amount
        if (amount == -1) {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            makeDownMove();
        }
    }

    /**
     * Applies permutation of pieces corresponding to the front move.
     */
    public void makeFrontMove() {
        int[][] cornerFacePermutation = {{0, 2}, {0, 3}, {1, 3}, {1, 2}};
        makeImpliedFaceCornerPermutation(cornerFacePermutation);
        makeFrontMoveCornerOrientation();

        int[][] edgeFacePermutation = {{0, 2}, {1, 3}, {2, 2}, {1, 2}};
        makeImpliedFaceEdgePermutation(edgeFacePermutation);
        changeEdgeOrientationAlongImpliedFace(edgeFacePermutation);
    }

    /**
     * Applies permutation of pieces corresponding to the front move, multiple times.
     * Negative amount corresponds to the counter-clockwise move.
     *
     * @param amount the amount of front moves to be made
     */
    public void makeFrontMove(int amount) {
        if (amount < -1 || amount > 3) {
            throw new IllegalArgumentException("Amount of front moves must be between 0 and 3");
        }
        // Implementing prime moves as negative amount
        if (amount == -1) {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            makeFrontMove();
        }
    }

    /**
     * Applies permutation of pieces corresponding to the back move.
     */
    public void makeBackMove() {
        int[][] cornerFacePermutation = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        makeImpliedFaceCornerPermutation(cornerFacePermutation);
        makeBackMoveCornerOrientation();

        int[][] edgeFacePermutation = {{0, 0}, {1, 1}, {2, 0}, {1, 0}};
        makeImpliedFaceEdgePermutation(edgeFacePermutation);
        changeEdgeOrientationAlongImpliedFace(edgeFacePermutation);
    }

    /**
     * Applies permutation of pieces corresponding to the back move, multiple times.
     * Negative amount corresponds to the counter-clockwise move.
     *
     * @param amount the amount of back moves to be made
     */
    public void makeBackMove(int amount) {
        if (amount < -1 || amount > 3) {
            throw new IllegalArgumentException("Amount of back moves must be between 0 and 3");
        }
        // Implementing prime moves as negative amount
        if (amount == -1) {
            amount = 3;
        }

        for (int i = 0; i < amount; i++) {
            makeBackMove();
        }
    }

    /**
     * Orients corners according to the right move, should be called after makeRightMoveCornerPermutation.
     */
    private void makeRightMoveCornerOrientation() {
        // EASY TO MAKE A MISTAKE HERE
        corners[0][2].turnCounterClockwise();
        corners[1][2].turnClockwise();
        corners[1][1].turnCounterClockwise();
        corners[0][1].turnClockwise();
    }

    /**
     * Orients corners according to the left move, should be called after makeLeftMoveCornerPermutation.
     */
    private void makeLeftMoveCornerOrientation() {
        // EASY TO MAKE A MISTAKE HERE
        corners[0][0].turnCounterClockwise();
        corners[1][0].turnClockwise();
        corners[1][3].turnCounterClockwise();
        corners[0][3].turnClockwise();
    }

    /**
     * Permutes corners according to specified cycle, in direction opposite to the one specified (by cyclic left shifting).
     *
     * @param facePermutation cycle of corners to be permuted; [i][0] is layer, [i][1] is position in layer
     */
    private void makeImpliedFaceCornerPermutation(int[][] facePermutation) {
        Corner firstCorner = corners[facePermutation[0][0]][facePermutation[0][1]]; // saving 0
        corners[facePermutation[0][0]][facePermutation[0][1]] = corners[facePermutation[1][0]][facePermutation[1][1]]; // 0 <- 1
        corners[facePermutation[1][0]][facePermutation[1][1]] = corners[facePermutation[2][0]][facePermutation[2][1]]; // 1 <- 2
        corners[facePermutation[2][0]][facePermutation[2][1]] = corners[facePermutation[3][0]][facePermutation[3][1]]; // 2 <- 3
        corners[facePermutation[3][0]][facePermutation[3][1]] = firstCorner; // 3 <- 0 (saved)
    }

    /**
     * Permutes edges according to specified cycle, in direction opposite to the one specified (by cyclic left shifting).
     * i + 1 goes to i
     *
     * @param facePermutation cycle of edges to be permuted; [i][0] is layer, [i][1] is position in layer
     */
    private void makeImpliedFaceEdgePermutation(int[][] facePermutation) {
        Edge firstEdge = edges[facePermutation[0][0]][facePermutation[0][1]]; // saving 0
        edges[facePermutation[0][0]][facePermutation[0][1]] = edges[facePermutation[1][0]][facePermutation[1][1]]; // 0 <- 1
        edges[facePermutation[1][0]][facePermutation[1][1]] = edges[facePermutation[2][0]][facePermutation[2][1]]; // 1 <- 2
        edges[facePermutation[2][0]][facePermutation[2][1]] = edges[facePermutation[3][0]][facePermutation[3][1]]; // 2 <- 3
        edges[facePermutation[3][0]][facePermutation[3][1]] = firstEdge; // 3 <- 0 (saved)
    }

    /**
     * Orients corners according to the front move, should be called after makeFrontMoveCornerPermutation.
     */
    private void makeFrontMoveCornerOrientation() {
        // EASY TO MAKE A MISTAKE HERE !!!
        corners[0][2].turnClockwise();
        corners[0][3].turnCounterClockwise();
        corners[1][3].turnClockwise();
        corners[1][2].turnCounterClockwise();
    }

    /**
     * Orients corners according to the back move, should be called after makeBackMoveCornerPermutation.
     */
    private void makeBackMoveCornerOrientation() {
        // EASY TO MAKE A MISTAKE HERE !!!
        corners[0][0].turnClockwise();
        corners[0][1].turnCounterClockwise();
        corners[1][1].turnClockwise();
        corners[1][0].turnCounterClockwise();
    }

    /**
     * Flips the orientation of the edge pieces along the implied face.
     *
     * @param facePermutation set of edges to be flipped;
     */
    private void changeEdgeOrientationAlongImpliedFace(int[][] facePermutation) {
        for (int[] pair : facePermutation) {
            edges[pair[0]][pair[1]].flipOrientation();
        }
    }

    public Corner[][] getCorners() {
        return corners;
    }

    public Edge[][] getEdges() {
        return edges;
    }


}

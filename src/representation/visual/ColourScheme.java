package representation.visual;

import representation.pieces.Corner;

public class ColourScheme {
    public static Colour getCornerColour(Corner corner) {
        int id = corner.getId();
        int side = corner.getOrientation();
        return switch (id) {
            case 0 -> switch (side) {
                case 0 -> Colour.WHITE;
                case 1 -> Colour.BLUE;
                case 2 -> Colour.ORANGE;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 1 -> switch (side) {
                case 0 -> Colour.WHITE;
                case 1 -> Colour.RED;
                case 2 -> Colour.BLUE;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 2 -> switch (side) {
                case 0 -> Colour.WHITE;
                case 1 -> Colour.GREEN;
                case 2 -> Colour.RED;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 3 -> switch (side) {
                case 0 -> Colour.WHITE;
                case 1 -> Colour.ORANGE;
                case 2 -> Colour.GREEN;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 4 -> switch (side) {
                case 0 -> Colour.YELLOW;
                case 1 -> Colour.ORANGE;
                case 2 -> Colour.BLUE;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 5 -> switch (side) {
                case 0 -> Colour.YELLOW;
                case 1 -> Colour.BLUE;
                case 2 -> Colour.RED;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 6 -> switch (side) {
                case 0 -> Colour.YELLOW;
                case 1 -> Colour.RED;
                case 2 -> Colour.GREEN;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            case 7 -> switch (side) {
                case 0 -> Colour.YELLOW;
                case 1 -> Colour.GREEN;
                case 2 -> Colour.ORANGE;
                default -> throw new IllegalArgumentException("Invalid side id: " + side);
            };
            default -> throw new IllegalArgumentException("Invalid corner id: " + id);
        };
    }

    public enum Colour {
        WHITE,
        YELLOW,
        ORANGE,
        RED,
        GREEN,
        BLUE
    }
}

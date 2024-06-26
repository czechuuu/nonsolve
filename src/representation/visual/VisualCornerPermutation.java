package representation.visual;

import representation.ArrayCubeStateRepresentation;
import representation.pieces.Corner;

import java.util.Scanner;

public class VisualCornerPermutation {
    public static String getCuboidVisualRepresentation(Corner[][] corners) {
        StringBuilder sb = new StringBuilder();
        for (Corner[] cornerLayer : corners) {
            sb.append(" ");
            sb.append(cornerLayer[0].getId()).append(" ").append(cornerLayer[1].getId()).append("\n");
            sb.append(cornerLayer[3].getId()).append(" ").append(cornerLayer[2].getId()).append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayCubeStateRepresentation state = new ArrayCubeStateRepresentation();
        Corner[][] corners = state.getCorners();
        System.out.println(getCuboidVisualRepresentation(corners));
        Scanner sc = new Scanner(System.in);
        while (true) {
            String move = sc.nextLine();
            char moveType = move.charAt(0);
            switch (moveType) {
                case 'r':
                    state.makeRightMove();
                    break;
                case 'l':
                    state.makeLeftMove();
                    break;
                case 'u':
                    state.makeUpMove();
                    break;
                case 'q':
                    System.exit(0);
                default:
                    System.out.println("Invalid move");
                    continue;
            }
            clearScreen();
            System.out.println(getCuboidVisualRepresentation(corners));
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

package interaction.parsing;

import representation.ArrayCubeStateRepresentation;

import java.util.ArrayList;
import java.util.List;

public class ScrambleParser {
    private final List<Move> moves;

    public ScrambleParser(String scramble) {
        moves = new ArrayList<>();
        for (int i = 0; i < scramble.length(); i++) {
            char move = scramble.charAt(i);
            if (move == ' ') {
                continue;
            }
            if (i + 1 < scramble.length() && scramble.charAt(i + 1) == '2') {
                moves.add(new Move(move, 2));
                i++;
            } else if (i + 1 < scramble.length() && scramble.charAt(i + 1) == '\'') {
                moves.add(new Move(move, -1));
                i++;
            } else {
                // TODO handle invalid moves
                moves.add(new Move(move, 1));
            }
        }
    }

    public void applyScramble(ArrayCubeStateRepresentation state) {
        for (Move move : moves) {
            move.applyMove(state);
        }
    }

    public ArrayCubeStateRepresentation getScrambleStateInstance() {
        ArrayCubeStateRepresentation state = new ArrayCubeStateRepresentation();
        applyScramble(state);
        return state;
    }

    // static means that it doesn't have access to the outer instance variables
    private static class Move {
        private final char face;
        private final int amount;

        public Move(char face, int amount) {
            this.face = face;
            this.amount = amount;
        }

        public void applyMove(ArrayCubeStateRepresentation state) {
            switch (face) {
                case 'R':
                    state.makeRightMove(amount);
                    break;
                case 'L':
                    state.makeLeftMove(amount);
                    break;
                case 'U':
                    state.makeUpMove(amount);
                    break;
                case 'D':
                    state.makeDownMove(amount);
                    break;
                case 'F':
                    state.makeFrontMove(amount);
                    break;
                case 'B':
                    state.makeBackMove(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid move");
                    // TODO handle invalid moves
            }
        }
    }
}

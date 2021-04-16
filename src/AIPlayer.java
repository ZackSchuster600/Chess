import java.util.ArrayList;
import java.util.Random;

public class AIPlayer {

    Board board;
    String color;
    Random random = new Random();


    public AIPlayer(Board board, String color) {
        this.board = board;
        this.color = color;
    }

    public Move randomMove(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        for(Piece piece: board.boardPieces) {
            Board board1 = board.clone();
            Piece lol = piece.clone();
            if(piece.getColor().equals(color)) {
                for(int i=0; i<7; i++) {
                    for(int j=0; j<7; j++) {
                        if(lol.isLegalMove(board1, i, j)) {
                            possibleMoves.add(new Move(piece, i, j));
                        }
                    }
                }
            }
        }
        return possibleMoves.get(random.nextInt(possibleMoves.size()));
    }





























}

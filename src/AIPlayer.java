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

        for(int a=0; a<board.boardPieces.size(); a++) {
            if(board.boardPieces.get(a).getColor().equals(color)) {
                System.out.println(""+board.boardPieces.get(a).getColor()+" and "+color);
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(board.boardPieces.get(a).isLegalMove(board, i, j)) {
                            possibleMoves.add(new Move(board.boardPieces.get(a), i, j));
                        }
                    }
                }
            }
        }
        if(possibleMoves.size() > 0) {
            return possibleMoves.get(random.nextInt(possibleMoves.size()));
        } else {
            System.out.println("No legal moves found");
            return null;
        }
    }





























}

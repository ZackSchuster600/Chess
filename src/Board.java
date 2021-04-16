import java.util.ArrayList;
import java.util.Comparator;

public class Board {

    ArrayList<Piece> boardPieces = new ArrayList<Piece>();
    ArrayList<Piece> removedPieces = new ArrayList<Piece>();

    public Board() {

    }

    public Board(ArrayList<Piece> boardPieces, ArrayList<Piece> removedPieces) {
        this.boardPieces = boardPieces;
        this.removedPieces = removedPieces;
    }

    public boolean addPiece(Piece newPiece) {
        if(squareContains(newPiece.getRow(), newPiece.getCol()) != null) {
            return false;
        } else {
            boardPieces.add(newPiece);
            boardPieces.sort(new PieceComparator());
            return true;
        }

    }


    public void printBoard() {
        String oneRow = "|";
        System.out.println("---------------------------------" +
                "------------------------------------------------");
        System.out.println("|         |         |         |         |         |         |         |         |");
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(squareContains(i, j) == null) {
                    oneRow = oneRow + "         |";
                } else {
                    oneRow = oneRow + squareContains(i, j).toString();
                }
            }
            oneRow = oneRow + " " + i + " row";
            System.out.println(oneRow);
            System.out.println("|         |         |         |         |         |         |         |         |");
            oneRow = "|";
            System.out.println("---------------------------------" +
                    "------------------------------------------------");
            if(i < 7) {
                System.out.println("|         |         |         |         |         |         |         |         |");
            }
        }
        System.out.println("|Column 0 |Column 1 |Column 2 |Column 3 |Column 4 |Column 5 |Column 6 |Column 7 |");
    }

    public Piece squareContains(int row, int col) {
        for(int i=0; i< boardPieces.size(); i++) {
            if (((Piece)boardPieces.get(i)).isInSquare(row, col)) {
                return (Piece)boardPieces.get(i);
            }
        }
        return null;
    }

    public boolean movePiece(int oldRow, int oldCol, int newRow, int newCol, String color) {

        if(squareContains(oldRow, oldCol) != null) {
            if(squareContains(oldRow, oldCol).isLegalMove(this, newRow, newCol)) {
                if(squareContains(oldRow, oldCol).getColor().equals(color)) {
                    clearSquare(newRow, newCol);
                    squareContains(oldRow, oldCol).movePiece(newRow, newCol);
                    return true;
                }
            }
        }
        return false;
    }

    public void clearSquare(int row, int col) {
        if(squareContains(row, col) != null) {
            removedPieces.add(squareContains(row, col));
            boardPieces.remove(squareContains(row, col));
        }
    }

    public boolean isInCheck(String color) {

        for(int i=0; i<boardPieces.size(); i++) {
            if(boardPieces.get(i).getType() == "King") {
                if(boardPieces.get(i).getColor().equals(color)) {
                    Piece king = boardPieces.get(i);
                    for(Piece piece: boardPieces) {
                        if(piece.isLegalMove(this, king.getRow(), king.getCol())) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    public boolean gameIsOver() {
        return false;
    }

    public Board clone() {
        return new Board(boardPieces, removedPieces);
    }


}

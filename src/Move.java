public class Move {

    Piece thisPiece;
    Piece takenPiece;
    int oldRow;
    int oldCol;
    int newRow;
    int newCol;

    public Move(Piece piece, int newRow, int newCol) {
        thisPiece = piece;
        oldRow = piece.getRow();
        oldCol = piece.getCol();
        this.newRow = newRow;
        this.newCol = newCol;
    }

    public String toString() {
        return ("Row:"+oldRow+" Col:"+oldCol+" to Row:"+newRow+" Col:"+newCol);
    }

    public void doMove(Board board) {
        if(board.squareContains(newRow, newCol) != null) {
            takenPiece = board.squareContains(newRow, newCol);
            board.clearSquare(newRow, newCol);
        }
        System.out.println("Piece "+thisPiece.toString()+" at "+oldRow+","+oldCol+
        " to "+newRow+","+newCol);
        thisPiece.movePiece(newRow, newCol);
    }

    public void undoMove(Board board) {
        thisPiece.movePiece(oldRow, oldCol);
        if(takenPiece != null) {
            board.addPiece(takenPiece);
        }
    }






}

public class Move {

    Piece thisPiece;
    Piece takenPiece;
    int oldRow;
    int oldCol;
    int newRow;
    int newCol;
    int minimaxValue;

    public Move(Piece piece, int newRow, int newCol) {
        thisPiece = piece;
        oldRow = piece.getRow();
        oldCol = piece.getCol();
        this.newRow = newRow;
        this.newCol = newCol;
    }

    public Move() {

    }

    public void setMove(Move move) {
        this.thisPiece = move.thisPiece;
        this.takenPiece = move.takenPiece;
        this.oldRow = move.oldRow;
        this.oldCol = move.oldCol;
        this.newRow = move.newRow;
        this.newCol = move.newCol;
    }

    public String toString() {
        return ("Row:"+oldRow+" Col:"+oldCol+" to Row:"+newRow+" Col:"+newCol);
    }

    public void doMove(Board board) {
        board.squareContains(oldRow, oldCol).addTimeMoved();
        if(board.squareContains(newRow, newCol) != null) {
            takenPiece = board.squareContains(newRow, newCol);
            board.clearSquare(newRow, newCol);
        }
        System.out.println("Piece "+thisPiece.toString()+" at "+oldRow+","+oldCol+
        " to "+newRow+","+newCol);
        thisPiece.movePiece(newRow, newCol);
        board.boardPieces.sort(new PieceComparator());
    }

    public void undoMove(Board board) {
        thisPiece.movePiece(oldRow, oldCol);
        board.squareContains(oldRow, oldCol).subTimeMoved();
        if(takenPiece != null) {
            board.addPiece(takenPiece);
        }
        board.boardPieces.sort(new PieceComparator());
    }

    public void setMinimaxValue(int value) {
        this.minimaxValue = value;
    }






}

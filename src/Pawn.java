public class Pawn extends Piece {


    public Pawn(int row, int col, String color) {
        super(row, col, color);
    }

    public String toString() {
        if(color.equals("white")) {
            return "   pawn  |";
        } else if(color.equals("black")) {
            return ConsoleColors.RED + "   pawn  " + ConsoleColors.RESET + "|";
        } else {
            return " illgl clr";
        }
    }

    @Override
    public boolean isLegalMove(Board board, int row, int col) {
        if(row > 7 || row < 0) {
            return false;
        }
        if(col > 7 || row < 0) {
            return false;
        }

        if(color.equals("black")) {
            if(col == this.col && row == (this.row+ 1) ) {
                if(board.squareContains(row, col) == null) {
                    if(badCheckMove(board, row, col)) {
                        return false;
                    }
                    return true;
                }
            }
            if(Math.abs(col - this.col) == 1 && row == (this.row + 1)) {
                if(board.squareContains(row, col) != null) {
                    if(board.squareContains(row, col).getColor().equals("white")) {
                        if(badCheckMove(board, row, col)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            if(this.row == 1 && row == 3 && this.col == col) {
                if(board.squareContains(this.row + 1, col) == null) {
                    if(board.squareContains(row, col) == null) {
                        if(badCheckMove(board, row, col)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        if(color.equals("white")) {
            if(col == this.col && row == (this.row-1)) {
                if(board.squareContains(row, col) == null) {
                    if(badCheckMove(board, row, col)) {
                        return false;
                    }
                    return true;
                }
            }
            if(Math.abs(col - this.col) == 1 && row == (this.row - 1)) {
                if(board.squareContains(row, col) != null) {
                    if(board.squareContains(row, col).getColor().equals("black")) {
                        if(badCheckMove(board, row, col)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            if(this.row == 6 && row == 4 && this.col == col) {
                if(board.squareContains(this.row - 1, col) == null) {
                    if(board.squareContains(row, col) == null) {
                        if(badCheckMove(board, row, col)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }




}

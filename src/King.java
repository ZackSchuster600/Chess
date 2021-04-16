public class King extends Piece {

    public King(int row, int col, String color) {
        super(row, col, color);
    }

    public String toString() {
        if(color.equals("white")) {
            return "   King  |";
        } else if(color.equals("black")) {
            return ConsoleColors.RED + "   King  " + ConsoleColors.RESET + "|";
        } else {
            return " illgl clr";
        }
    }

    public boolean isLegalMove(Board board, int row, int col) {
        if(row > 7 || row < 0) {
            return false;
        }
        if(col > 7 || row < 0) {
            return false;
        }
        if(this.row == row && this.col == col) {
            return false;
        }
        if(Math.abs(row - this.row) > 1 || Math.abs(col - this.col) > 1) {
            return false;
        }

        if(color.equals("black")) {
            if(board.squareContains(row, col) == null) {
                if(badCheckMove(board, row, col)) {
                    return false;
                }
                return true;
            } else if(board.squareContains(row, col).getColor().equals("white")) {
                if(badCheckMove(board, row, col)) {
                    return false;
                }
                return true;
            }
        }

        if(color.equals("white")) {
            if(board.squareContains(row, col) == null) {
                if(badCheckMove(board, row, col)) {
                    return false;
                }
                return true;
            } else if(board.squareContains(row, col).getColor().equals("black")) {
                if(badCheckMove(board, row, col)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String getType() {
        return "King";
    }


}

import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        // get vertical and horizontal (From Rook)
        // get movable points on x-axis
        int xStart = getSource().getX();
        int xEnd = getSource().getX();
        // Get the start of x coordinate
        while (0 < xStart
                && !chessboard[xStart - 1][getSource().getY()].getChessColor().equals(this.getChessColor())) {
            if (chessboard[xStart - 1][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(xStart - 1, getSource().getY()));
                xStart--; // this is for EmptySlot, continue
            } else {
                list.add(new ChessboardPoint(xStart - 1, getSource().getY()));
                //xStart--;
                break; // this is for opponent side, eat it and stop
            }
        }
        // Get the end of x coordinate
        while (xEnd < 7
                && !chessboard[xEnd + 1][getSource().getY()].getChessColor().equals(this.getChessColor())) {
            if (chessboard[xEnd + 1][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(xEnd + 1, getSource().getY()));
                xEnd++; // this is for EmptySlot, continue
            } else {
                list.add(new ChessboardPoint(xEnd + 1, getSource().getY()));
                //xEnd++;
                break; // this is for opponent side, eat it and stop
            }
        }

        // get movable points on y-axis
        int yStart = getSource().getY();
        int yEnd = getSource().getY();
        // Get the start of y coordinate
        while (0 < yStart
                && !chessboard[getSource().getX()][yStart - 1].getChessColor().equals(this.getChessColor())) {
            if (chessboard[getSource().getX()][yStart - 1].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(getSource().getX(), yStart - 1));
                yStart--; // this is for EmptySlot, continue
            } else {
                list.add(new ChessboardPoint(getSource().getX(), yStart - 1));
                //yStart--;
                break; // this is for opponent side, eat it and stop
            }
        }
        // Get the end of x coordinate
        while (yEnd < 7
                && !chessboard[getSource().getX()][yEnd + 1].getChessColor().equals(this.getChessColor())) {
            if (chessboard[getSource().getX()][yEnd + 1].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(getSource().getX(), yEnd + 1));
                yEnd++; // this is for EmptySlot, continue
            } else {
                list.add(new ChessboardPoint(getSource().getX(), yEnd + 1));
                //yEnd++;
                break; // this is for opponent side, eat it and stop
            }
        }

        // get diagonal and skew-diagonal (From Bishop)
        // Notation: Start1 & End1 == diagonal (y=-x), Start2 & End2 == skew-diagonal (y=x)
        // This piece is for diagonal
        // this piece is to get start1
        int x1 = getSource().getX();
        int y1 = getSource().getY();
        ChessboardPoint Start1 = new ChessboardPoint(x1, y1);
        while ((0 < x1 && 0 < y1)
                && (!chessboard[x1 - 1][y1 - 1].getChessColor().equals(this.getChessColor()))) {
            if (chessboard[x1 - 1][y1 - 1].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(x1 - 1, y1 - 1));
                x1--;
                y1--;
            } else {
                list.add(new ChessboardPoint(x1 - 1, y1 - 1));
                break;
            }
        }
        // this piece is to get end1
        int x2 = getSource().getX();
        int y2 = getSource().getY();
        ChessboardPoint End1 = new ChessboardPoint(x2, y2);
        while ((x2 < 7 && y2 < 7)
                && (!chessboard[x2 + 1][y2 + 1].getChessColor().equals(this.getChessColor()))) {
            if (chessboard[x2 + 1][y2 + 1].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(x2 + 1, y2 + 1));
                x2++;
                y2++;
            } else {
                list.add(new ChessboardPoint(x2 + 1, y2 + 1));
                break;
            }
        }
        // This piece is for skew-diagonal
        // this piece is to get start2
        int x3 = getSource().getX();
        int y3 = getSource().getY();
        ChessboardPoint Start2 = new ChessboardPoint(x3, y3);
        while ((0 < x3 && y3 < 7)
                && (!chessboard[x3 - 1][y3 + 1].getChessColor().equals(this.getChessColor()))) {
            if (chessboard[x3 - 1][y3 + 1].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(x3 - 1, y3 + 1));
                x3--;
                y3++;
            } else {
                list.add(new ChessboardPoint(x3 - 1, y3 + 1));
                break;
            }
        }
        // this piece is to get end1
        int x4 = getSource().getX();
        int y4 = getSource().getY();
        ChessboardPoint End2 = new ChessboardPoint(x4, y4);
        while ((x4 < 7 && 0 < y4)
                && (!chessboard[x4 + 1][y4 - 1].getChessColor().equals(this.getChessColor()))) {
            if (chessboard[x4 + 1][y4 - 1].getChessColor().equals(ChessColor.NONE)) {
                list.add(new ChessboardPoint(x4 + 1, y4 - 1));
                x4++;
                y4--;
            } else {
                list.add(new ChessboardPoint(x4 + 1, y4 - 1));
                break;
            }
        }
        // return
        return list;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
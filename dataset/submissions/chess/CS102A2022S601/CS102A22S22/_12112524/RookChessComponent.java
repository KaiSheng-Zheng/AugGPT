import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

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

        // return
        return list;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}


import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    //user defined
    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }
    public ChessComponent(ChessColor color){
        this.chessColor = color;
    }


    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }

    /**
     * should design
     * @return
     */
    @Override

    public String toString() {
        return String.valueOf(this.name);
    }
}

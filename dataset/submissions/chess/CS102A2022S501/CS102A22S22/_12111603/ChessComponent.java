

import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessboard;
    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    protected ConcreteChessGame itsConcreteGame;
    public void setItsConcreteGame(ConcreteChessGame ccg){
        itsConcreteGame=ccg;
    }
    public ChessColor getColor(){
        return null;
    }



    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo ();
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }

}

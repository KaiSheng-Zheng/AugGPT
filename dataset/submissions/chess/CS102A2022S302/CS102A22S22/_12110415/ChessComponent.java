import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public ChessColor currentPlayer;


    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent(ChessboardPoint point, ChessColor chessColor, char name){
        this.source=point;
        this.chessColor=chessColor;
        this.name=name;
    }
    public ChessComponent(){
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }





    public abstract List<ChessboardPoint> canMoveTo();



    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}

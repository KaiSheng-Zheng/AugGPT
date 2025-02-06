import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private ChessboardPoint source;
    private ChessColor chessColor;

    ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;

    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
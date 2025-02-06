import java.util.List;
public class PawnChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    ConcreteChessGame chessGame;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public PawnChessComponent() {}
    public  List<ChessboardPoint> canMoveTo(){
        return null;
    }
}

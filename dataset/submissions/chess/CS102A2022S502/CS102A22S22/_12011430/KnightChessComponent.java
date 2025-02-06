import java.util.List;
public class KnightChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    ConcreteChessGame chessGame;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public KnightChessComponent() {}
    public  List<ChessboardPoint> canMoveTo(){
        return null;
    }
}

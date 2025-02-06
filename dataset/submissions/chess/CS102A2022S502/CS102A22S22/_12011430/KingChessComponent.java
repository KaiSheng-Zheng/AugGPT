import java.util.List;
public class KingChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    ConcreteChessGame chessGame;
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public  List<ChessboardPoint> canMoveTo(){
        return null;
    }
}

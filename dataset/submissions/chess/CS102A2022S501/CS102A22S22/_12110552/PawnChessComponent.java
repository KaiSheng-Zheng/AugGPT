import java.util.List;

public class PawnChessComponent extends  ChessComponent{
    public PawnChessComponent() {
}

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public static ChessColor color;


}

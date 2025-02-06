import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        constructor(source,chessColor,name);
        if (chessColor.equals(ChessColor.BLACK)){
            d.add(new ChessboardPoint(source.getX() + 1,source.getY() - 1));
            d.add(new ChessboardPoint(source.getX() + 1,source.getY() + 1));
        }
        else {
            d.add(new ChessboardPoint(source.getX() - 1,source.getY() - 1));
            d.add(new ChessboardPoint(source.getX() - 1,source.getY() + 1));
        }
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

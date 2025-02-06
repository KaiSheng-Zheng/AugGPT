
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessColor color;
    private ChessboardPoint chessboardPoint;

    public ChessColor getColor() {
        return color;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public RookChessComponent(ChessColor color, ChessboardPoint chessboardPoint, char name){
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        super.name=name;
    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        chessboardPoints.add(new ChessboardPoint(0,0));
        return chessboardPoints;

    }
}


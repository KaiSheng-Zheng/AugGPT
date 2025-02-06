import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {


    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor chessColor;
    private ChessboardPoint chessboardPoint;

    protected PawnChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents1) {
        this.name=name;
        this.chessColor=chessColor;
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents1;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> b = new ArrayList<>();
        b.add(new ChessboardPoint(3,5));
        return b;
    }
}

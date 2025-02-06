import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        RookChessComponent this1 = new RookChessComponent(this.getSource(), this.getChessColor(), this.name);
        this1.setChessComponents(this.getChessComponents());
        BishopChessComponent this2 = new BishopChessComponent(this.getSource(), this.getChessColor(), this.name);
        this2.setChessComponents(this.getChessComponents());
        CanMoveTo.addAll(this1.canMoveTo());
        CanMoveTo.addAll(this2.canMoveTo());
        return CanMoveTo;
    }

    public void myShowCanMoveTo(){
        List<ChessboardPoint> CanMoveTo = canMoveTo();
        for (ChessboardPoint i : CanMoveTo)
            System.out.print(i);
    }
}

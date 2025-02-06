import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        RookChessComponent rookmove = new RookChessComponent(this.getSource(), this.getChessColor(), this.name);
        rookmove.setChessComponents(this.getChessComponents());
        BishopChessComponent bishopmove = new BishopChessComponent(this.getSource(), this.getChessColor(), this.name);
        bishopmove .setChessComponents(this.getChessComponents());
        CanMoveTo.addAll(rookmove.canMoveTo());
        CanMoveTo.addAll(bishopmove.canMoveTo());
        return CanMoveTo;
    }

    public void myShowCanMoveTo(){
        List<ChessboardPoint> CanMoveTo = canMoveTo();
        for (ChessboardPoint i : CanMoveTo)
            System.out.print(i);
    }
}

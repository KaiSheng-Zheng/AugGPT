import java.util.*;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        for (int i = -1;i <= 1;i++)
            for (int j = -1;j <= 1;j++)
                if (this.getSource().offset(i, j) != null) 
                {
                    if(attack(this.getChessComponent(this.getSource().offset(i, j))) || this.getChessComponent(this.getSource().offset(i, j)).name == '_')
                    {  if (i != 0 || j != 0)
                    { CanMoveTo.add(this.getSource().offset(i, j));}}
                }
        for (int i = 0;i <= CanMoveTo.size();i++)
            CanMoveTo.remove(null);
        return CanMoveTo;
    }

    public void myShowCanMoveTo(){
        List<ChessboardPoint> CanMoveTo = canMoveTo();
        if (CanMoveTo == null)
            return;
        for (ChessboardPoint i : CanMoveTo)
            System.out.print(i);
    }
}

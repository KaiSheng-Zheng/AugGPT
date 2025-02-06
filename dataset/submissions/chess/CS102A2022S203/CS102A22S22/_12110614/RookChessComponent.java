import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public RookChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackRook = new ArrayList();
        ArrayList<ChessboardPoint> WhiteRook = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();

        if (name == 'R') {
            int NorthCount = 0;
            int EastCount = 0;
            int SouthCount = 0;
            int WestCount = 0;
            int temp ;
            int temp1;
            int temp2;
            int temp3;
            



        if(name =='R')

    {
        return BlackRook;
    } else if(name =='r')

    {
        return WhiteRook;
    } else

    {
        return new ArrayList<>();
    }
}
        return null;
    }}


import java.util.ArrayList;
import java.util.List;

class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name='N';
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            this.name='n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> KnightCanMoveTo =new ArrayList<>();
        int [][] KnightCanMove=new int[][]{{1,2},{-2,1},{-2,-1},{-1,2},{-1,-2},{2,1},{2,-1},{1,-2}};
        for (int j = 0; j < 8; j++) {
            if(source.offset(KnightCanMove[j][0],KnightCanMove[j][1])!=null&&getComponentColor(chessBoard[source.offset(KnightCanMove[j][0],KnightCanMove[j][1]).getX()][source.offset(KnightCanMove[j][0],KnightCanMove[j][1]).getY()].name)!=chessColor){
                KnightCanMoveTo.add(source.offset(KnightCanMove[j][0],KnightCanMove[j][1]));
            }
        }
        return KnightCanMoveTo;
    }
}

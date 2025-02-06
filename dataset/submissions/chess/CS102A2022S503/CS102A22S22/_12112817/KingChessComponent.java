import java.util.ArrayList;
import java.util.List;

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name='K';
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            this.name='k';
        }
    }
    ArrayList<ChessboardPoint> kingMoveTo =new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {

        final int[][] kingCanMove=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        for (int j = 0; j < 8; j++) {
            if(source.offset(kingCanMove[j][0],kingCanMove[j][1])!=null&&getComponentColor(chessBoard[source.offset(kingCanMove[j][0],kingCanMove[j][1]).getX()][source.offset(kingCanMove[j][0],kingCanMove[j][1]).getY()].toString().charAt(0))!=chessColor){
                kingMoveTo.add(source.offset(kingCanMove[j][0],kingCanMove[j][1]));
            }
        }
        return kingMoveTo;
    }
}

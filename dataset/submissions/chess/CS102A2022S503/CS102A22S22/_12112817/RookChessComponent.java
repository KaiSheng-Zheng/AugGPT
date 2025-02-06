import java.util.ArrayList;
import java.util.List;

class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name='R';
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            this.name='r';
        }
    }
    ArrayList<ChessboardPoint> RookCanMoveTo=new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int [][]canMoveUnit=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<4;i++) {
            int x=source.getX();
            int y=source.getY();
            x += canMoveUnit[i][0];
            y += canMoveUnit[i][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if (getComponentColor(chessBoard[x][y].name)== chessColor) {
                    break;
                }
                RookCanMoveTo.add(new ChessboardPoint(x, y));
                if (getComponentColor(chessBoard[x][y].name) != ChessColor.NONE) {
                    break;
                }
                x += canMoveUnit[i][0];
                y += canMoveUnit[i][1];

            }
        }return RookCanMoveTo;
    }
}

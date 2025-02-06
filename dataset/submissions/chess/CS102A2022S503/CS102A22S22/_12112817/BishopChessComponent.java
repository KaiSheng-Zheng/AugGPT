import java.util.ArrayList;
import java.util.List;

class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name='B';
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            this.name='b';
        }
    }
    ArrayList<ChessboardPoint> BishopMoveTo=new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] bishopCanMove=new int[][]{{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i=0;i<4;i++){
            int x=source.getX(),y=source.getY();
            x+=bishopCanMove[i][0];
            y+=bishopCanMove[i][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].name)==chessColor){
                    break;
                }
                BishopMoveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].name)!=ChessColor.NONE){
                    break;
                }
                x+=bishopCanMove[i][0];
                y+=bishopCanMove[i][1];
            }
        }
        return BishopMoveTo;
    }

}

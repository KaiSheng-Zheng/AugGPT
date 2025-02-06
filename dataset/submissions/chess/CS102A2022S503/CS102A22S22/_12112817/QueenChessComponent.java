import java.util.ArrayList;
import java.util.List;

class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name='Q';
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            this.name='q';
        }
    }
    ArrayList<ChessboardPoint> QueenCanMoveTo=new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int [][]QueenCanMove=new int[][]{{0,1},{0,-1},{1,1},{1,0},{1,-1},{-1,0},{-1,1},{-1,-1}};

        for (int i = 0; i < 8; i++) {
            int x=source.getX();
            int y=source.getY();
            x+=QueenCanMove[i][0];
            y+=QueenCanMove[i][1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if (getComponentColor(chessBoard[x][y].name)==chessColor){
                    break;
                }
                QueenCanMoveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].name)!=ChessColor.NONE){
                    break;
                }
                x+=QueenCanMove[i][0];
                y+=QueenCanMove[i][1];
            }

        }
        return QueenCanMoveTo;

    }
}

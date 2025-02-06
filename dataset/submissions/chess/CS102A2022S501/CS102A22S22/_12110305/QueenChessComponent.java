import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'Q';}
        else if (chessColor == ChessColor.WHITE){
            this.name = 'q';}
    }

    private final int[][] move=new int[][]{{-1,-1},{-1,1},{1,1},{1,-1},{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        for(int t =0; t<8 ; t++){
            int x=getSource().getX();int y = getSource().getY();
            x=offsetX(x,move[t][0]);
            y=offsetY(y,move[t][1]);
            while(x>=0&&x<8&&y>=0&&y<8){
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))==getChessColor()){
                    break;
                }
                moveTo.add(new ChessboardPoint(x,y));
                if(getComponentColor(chessBoard[x][y].toString().charAt(0))!=ChessColor.NONE){
                    break;
                }
                x=offsetX(x,move[t][0]);
                y=offsetY(y,move[t][1]);
            }
        }
        return moveTo;
    }


    public int offsetX(int x, int dx) {
        if (x + dx < 8 && x + dx >= 0) {
            return x + dx;
        }
        else return -1;
    }

    public int offsetY(int y, int dy) {
        if (y + dy < 8 && y + dy >= 0) {
            return y + dy;
        }
        else return -1;
    }
}
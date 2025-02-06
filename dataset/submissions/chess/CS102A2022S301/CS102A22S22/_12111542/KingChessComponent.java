import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    ChessColor chessColor;
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor, name);
        this.chessColor = chessColor;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        boolean valid=true;
        if (x<0||x>7||y<0||y>7){
            valid=false;
        }if (valid) {
            if (x-1>=0&&board[x-1][y].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x-1,y));
            }if (y-1>=0&&board[x][y-1].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x,y-1));
            }if (x-1>=0&&y-1>=0&&board[x-1][y-1].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x-1,y-1));
            }if (x+1<=7&&board[x+1][y].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x+1,y));
            }if (y+1<=7&&board[x][y+1].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x,y+1));
            }if (y+1<=7&&x+1<=7&&board[x+1][y+1].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x+1,y+1));
            }if (y+1<=7&&x-1>=0&&board[x-1][y+1].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x-1,y+1));
            }if (x+1<=7&&y-1>=0&&board[x+1][y-1].getChessColor()!=chessColor){
                list.add(new ChessboardPoint(x+1,y-1));
            }
        }
        return list;
    }
//    @Override
//    public ChessComponent copy(int x, int y) {
//        return new KingChessComponent(new ChessboardPoint(x, y), this.chessColor, this.name);
//    }
}

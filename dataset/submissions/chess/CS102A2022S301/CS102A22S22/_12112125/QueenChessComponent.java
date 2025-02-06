
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        ChessComponent[][]chessComponents=this.getChessComponents();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i=1; i<8 ; i++) {
            if (x+i>=8||y+i>=8)break;
            if (chessComponents[x+i][y+i].getName()==95)
                move.add(new ChessboardPoint(x+i,y+i));
            else if (chessComponents[x+i][y+i].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(x+i,y+i));
                break;
            }
            else break;
        }
        for (int i=1; i<8 ; i++) {
            if (x-i<0||y-i<0)break;
            if (chessComponents[x-i][y-i].getName()==95)
                move.add(new ChessboardPoint(x-i,y-i));
            else if (chessComponents[x-i][y-i].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(x-i,y-i));
                break;
            }
            else break;
        }
        for (int i=1; i<8 ; i++) {
            if (x-i<0||y+i>=8)break;
            if (chessComponents[x-i][y+i].getName()==95)
                move.add(new ChessboardPoint(x-i,y+i));
            else if (chessComponents[x-i][y+i].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(x-i,y+i));
                break;
            }
            else break;
        }
        for (int i=1; i<8 ; i++) {
            if (x+i>=8||y-i<0)break;
            if (chessComponents[x+i][y-i].getName()==95)
                move.add(new ChessboardPoint(x+i,y-i));
            else if (chessComponents[x+i][y-i].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(x+i,y-i));
                break;
            }
            else break;
        }
        for (int i =x+1; i<8 ; i++) {
            if (chessComponents[i][y].getName()==95)
                move.add(new ChessboardPoint(i,y));
            else if (chessComponents[i][y].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(i,y));
                break;
            }
            else break;
        }
        for (int i =x-1; i>=0 ; i--) {
            if (chessComponents[i][y].getName()==95)
                move.add(new ChessboardPoint(i,y));
            else if (chessComponents[i][y].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(i,y));
                break;
            }
            else break;
        }
        for (int i =y+1; i<8 ; i++) {
            if (chessComponents[x][i].getName()==95)
                move.add(new ChessboardPoint(x,i));
            else if (chessComponents[x][i].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(x,i));
                break;
            }
            else break;
        }
        for (int i =y-1; i>=0 ; i--) {
            if (chessComponents[x][i].getName()==95)
                move.add(new ChessboardPoint(x,i));
            else if (chessComponents[x][i].getChessColor()!=this.getChessColor()){
                move.add(new ChessboardPoint(x,i));
                break;
            }
            else break;
        }
        return move;
    }
}

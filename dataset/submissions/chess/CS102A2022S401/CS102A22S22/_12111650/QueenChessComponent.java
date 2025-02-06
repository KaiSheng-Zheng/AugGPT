import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint point,ChessColor color,char name){
        super(point,color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        ChessboardPoint p = getSource();
        int x = p.getX();
        int y = p.getY();
        ChessColor color = chessComponents[x][y].getChessColor();
        for (int i = x + 1; i < 8; i++) {
            if(chessComponents[i][y].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(i,y));
            }
            else {
                if(chessComponents[i][y].getChessColor() != color){
                    ans.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if(chessComponents[i][y].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(i,y));
            }
            else {
                if(chessComponents[i][y].getChessColor() != color){
                    ans.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if(chessComponents[x][i].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(x,i));
            }
            else {
                if(chessComponents[x][i].getChessColor() != color){
                    ans.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if(chessComponents[x][i].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(x,i));
            }
            else {
                if(chessComponents[x][i].getChessColor() != color){
                    ans.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        //
        boolean for1 = true;
        for(int i = x;i<=7;i++){
            for (int n = y;n<8;n++){
                if(xie(x,y,i,n)&&(i!= x&&n!= y)){
                    ChessboardPoint p1 = new ChessboardPoint(i,n);
                    if(chessComponents[i][n].getChessColor()== ChessColor.NONE){
                        ans.add(p1);
                    }
                    else{
                        if(chessComponents[i][n].getChessColor() != color){
                            ans.add(p1);
                        }
                        for1 = false;
                        break;
                    }
                }
            }
            if(!for1)break;
        }
        boolean for2 = true;
        for (int i = x;i>=0;i--){
            for (int n = y;n<8;n++){
                if(xie(x,y,i,n)&&(i!= x&&n!= y)){
                    ChessboardPoint p1 = new ChessboardPoint(i,n);
                    if(chessComponents[i][n].getChessColor()== ChessColor.NONE){
                        ans.add(p1);
                    }
                    else{
                        if(chessComponents[i][n].getChessColor() != color){
                            ans.add(p1);
                        }
                        for2 = false;
                        break;
                    }
                }
            }
            if(!for2)break;
        }
        boolean for3 = true;
        for (int i = x-1;i>=0;i--){
            for (int n = y-1;n>=0;n--){
                if(xie(x,y,i,n)&&(i!= x&&n!= y)){
                    ChessboardPoint p1 = new ChessboardPoint(i,n);
                    if(chessComponents[i][n].getChessColor() == ChessColor.NONE){
                        ans.add(p1);
                    }
                    else{
                        if(chessComponents[i][n].getChessColor() != color){
                            ans.add(p1);
                        }
                        for3 = false;
                        break;
                    }
                }
            }
            if(!for3)break;
        }
        boolean for4 = true;
        for (int i = x+1;i<=7;i++){
            for (int n = y-1;n>=0;n--){
                if(xie(x,y,i,n)&&(i!= x&&n!= y)){
                    ChessboardPoint p1 = new ChessboardPoint(i,n);
                    if(chessComponents[i][n].getChessColor() == ChessColor.NONE){
                        ans.add(p1);
                    }
                    else{
                        if(chessComponents[i][n].getChessColor() != color){
                            ans.add(p1);
                        }
                        for4 = false;
                        break;
                    }
                }
            }
            if(!for4)break;
        }
        return ans;
    }
    public boolean xie (int x,int y,int X,int Y){
        if(Math.abs(x-X)==Math.abs(y-Y)){
            return true;
        }
        else return false;
    }
}

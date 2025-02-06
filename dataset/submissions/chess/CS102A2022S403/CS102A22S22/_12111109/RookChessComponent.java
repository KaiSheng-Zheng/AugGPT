import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{
    public ChessComponent[][] c;
    public RookChessComponent(){
        c = new ChessComponent[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
    }
    public void setC(ChessComponent[][] c) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                this.c[i][j] = c[i][j];
            }
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList a = new ArrayList<ChessboardPoint>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        boolean b = false;
        for(int i=x+1;i<8;i++){
            if(b==true) break;
            if(c[i][y].getChessColor()==ChessColor.NONE) a.add(new ChessboardPoint(i,y));
            else if(c[i][y].getChessColor()!=c[x][y].getChessColor()){
                a.add(new ChessboardPoint(i,y));
                b = true;
            }
            else b=true;
        }
        b = false;
        for(int i=x-1;i>=0;i--){
            if(b==true) break;
            if(c[i][y].getChessColor()==ChessColor.NONE) a.add(new ChessboardPoint(i,y));
            else if(c[i][y].getChessColor()!=c[x][y].getChessColor()){
                a.add(new ChessboardPoint(i,y));
                b = true;
            }
            else b=true;
        }
        b = false;
        for(int j=y+1;j<8;j++){
            if(b==true) break;
            if(c[x][j].getChessColor()==ChessColor.NONE) a.add(new ChessboardPoint(x,j));
            else if(c[x][j].getChessColor()!=c[x][y].getChessColor()){
                a.add(new ChessboardPoint(x,j));
                b = true;
            }
            else b=true;
        }
        b = false;
        for(int j=y-1;j>=0;j--){
            if(b==true) break;
            if(c[x][j].getChessColor()==ChessColor.NONE) a.add(new ChessboardPoint(x,j));
            else if(c[x][j].getChessColor()!=c[x][y].getChessColor()){
                a.add(new ChessboardPoint(x,j));
                b = true;
            }
            else b=true;
        }
        return a;
    }
}
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>go=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i=1;i<=8;i++){
            if (x+i>=0&&x+i<8){
                go.add(new ChessboardPoint(x+i,y));
                if (getChessComponents()[x+i][y].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x+i][y].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                    }
                    break;
                }
            }
        }
        for (int i=-1;i>=-8;i--){
           if (x+i>=0&&x+i<8){
               go.add(new ChessboardPoint(x+i,y));
               if (getChessComponents()[x+i][y].getChessColor()!=ChessColor.NONE){
                   if (getChessComponents()[x+i][y].getChessColor()==this.getChessColor()){
                       go.remove(go.size()-1);
                   }
                   break;
               }
           }
        }
        for (int j=1;j<=8;j++){
            if (y+j>=0&&y+j<8){
                go.add(new ChessboardPoint(x,y+j));
                if (getChessComponents()[x][y+j].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x][y+j].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                    }
                    break;
                }
            }
        }
        for (int j=-1;j>=-8;j--){
            if (y+j>=0&&y+j<8){
                go.add(new ChessboardPoint(x,y+j));
                if (getChessComponents()[x][y+j].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x][y+j].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                    }
                    break;
                }
            }
        }
        return go;
    }
}

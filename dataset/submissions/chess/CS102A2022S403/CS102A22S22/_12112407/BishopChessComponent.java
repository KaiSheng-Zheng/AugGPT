import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>go=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i=1;i<=8;i++){
            if (x+i<8&&y+i<8){
                go.add(new ChessboardPoint(x+i,y+i));
                if (getChessComponents()[x+i][y+i].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x+i][y+i].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                        break;
                    }
                    break;
                }
            }
        }
        for (int i=1;i<=8;i++){
            if (x-i>=0&&y+i<8){
                go.add(new ChessboardPoint(x-i,y+i));
                if (getChessComponents()[x-i][y+i].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x-i][y+i].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                        break;
                    }
                    break;
                }
            }
        }
        for (int i=1;i<=8;i++){
            if (x+i<8&&y-i>=0){
                go.add(new ChessboardPoint(x+i,y-i));
                if (getChessComponents()[x+i][y-i].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x+i][y-i].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                        break;
                    }
                    break;
                }
            }
        }
        for (int i=1;i<=8;i++){
            if (x-i>=0&&y-i>=0){
                go.add(new ChessboardPoint(x-i,y-i));
                if (getChessComponents()[x-i][y-i].getChessColor()!=ChessColor.NONE){
                    if (getChessComponents()[x-i][y-i].getChessColor()==this.getChessColor()){
                        go.remove(go.size()-1);
                        break;
                    }
                    break;
                }
            }
        }
        return go;
    }
}
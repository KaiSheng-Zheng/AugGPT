import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>go=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i=x-1;i<=x+1;i++){
            for (int j=y-1;j<=y+1;j++){
                if (i==x&&j==y){
                    continue;
                }
                if (i>=0&&i<8&&j>=0&&j<8&&getChessComponents()[i][j].getChessColor()!=getChessColor()){
                go.add(new ChessboardPoint(i,j));}
            }
        }
        return go;
    }
}

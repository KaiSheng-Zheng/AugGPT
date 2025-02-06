import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point= new ArrayList<>();
        ChessboardPoint des=super.getSource();
        int x=des.getX();int y=des.getY();

        for (int i = -1; i <2 ; i++) {
            for (int j = -1; j <2 ; j++) {
                if(x+i>=0&&x+i<=7&&y+j>=0&&y+j<=7&&chessboard[x + i][y + j] .getChessColor()!=chessboard[x][y].getChessColor()){
                    if(i!=0||j!=0){
                        point.add(new ChessboardPoint(x+i,y+j));
                    }
                }
            }
        }

        return point;
    }
}

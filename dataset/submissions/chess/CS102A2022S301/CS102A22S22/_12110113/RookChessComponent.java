
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessColor chessColor, int i, int j,char name) {
        super (chessColor,i,j,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canList = new ArrayList<>();
        for (int i=1;x+i<8;i++){
            if (canEat(x+i,y)){
                canList.add(new ChessboardPoint(x+i,y));
                break;
            }
            if (chessboard[x+i][y].name=='_'){
                canList.add(new ChessboardPoint(x+i,y));
            }
            else {break;}
        }
        for (int i=-1;x+i>=0;i--){
            if (canEat(x+i,y)){
                canList.add(new ChessboardPoint(x+i,y));
                break;
            }
            if (chessboard[x+i][y].name=='_'){
                canList.add(new ChessboardPoint(x+i,y));
            }
            else {break;}
        }
        for (int i=1;y+i<8;i++){
            if (canEat(x,y+i)){
                canList.add(new ChessboardPoint(x,y+i));
                break;
            }
            if (chessboard[x][y+i].name=='_'){
                canList.add(new ChessboardPoint(x,y+i));
            }
            else {break;}
        }
        for (int i=-1;y+i>=0;i--){
            if (canEat(x,y+i)){
                canList.add(new ChessboardPoint(x,y+i));
                break;
            }
            if (chessboard[x][y+i].name=='_'){
                canList.add(new ChessboardPoint(x,y+i));
            }
            else {break;}
        }

        return canList;
    }
}

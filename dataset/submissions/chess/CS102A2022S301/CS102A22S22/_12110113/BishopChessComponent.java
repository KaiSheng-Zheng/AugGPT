import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor, int i, int j,char name) {
        super (chessColor,i,j,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canList = new ArrayList<>();
        for (int i=1;x+i<8&&y+i<8;i++){
            if (canEat(x+i,y+i)){
                canList.add(new ChessboardPoint(x+i,y+i));
                break;
            }
            else if (exactBlankMini(x+i,y+i)){
                canList.add(new ChessboardPoint(x+i,y+i));
            }
            else {break;}
        }
        for (int i=-1;x+i>=0&&y+i>=0;i--){
            if (canEat(x+i,y+i)){
                canList.add(new ChessboardPoint(x+i,y+i));
                break;
            }
            else if (exactBlankMini(x+i,y+i)){
                canList.add(new ChessboardPoint(x+i,y+i));
            }
            else {break;}
        }
        for (int i=1;x+i<8&&y-i>=0;i++){
            if (canEat(x+i,y-i)){
                canList.add(new ChessboardPoint(x+i,y-i));
                break;
            }
            else if (exactBlankMini(x+i,y-i)){
                canList.add(new ChessboardPoint(x+i,y-i));
            }
            else {break;}
        }
        for (int i=1;x-i>=0&&y+i<8;i++){
            if (canEat(x-i,y+i)){
                canList.add(new ChessboardPoint(x-i,y+i));
                break;
            }
            else if (exactBlankMini(x-i,y+i)){
                canList.add(new ChessboardPoint(x-i,y+i));
            }
            else {break;}
        }
        return canList;
    }
}
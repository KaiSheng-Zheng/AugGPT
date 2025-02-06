import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor, int i, int j,char name) {
        super (chessColor,i,j,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canList = new ArrayList<>();
            if (canEatPro(x+1,y)||exactBlank(x+1,y)){
                canList.add(new ChessboardPoint(x+1,y));
            }
            if (canEatPro(x+1,y+1)||exactBlank(x+1,y+1)){
                canList.add(new ChessboardPoint(x+1,y+1));
            }
            if (canEatPro(x+1,y-1)||exactBlank(x+1,y-1)){
                canList.add(new ChessboardPoint(x+1,y-1));
            }
            if (canEatPro(x,y+1)||exactBlank(x,y+1)){
                canList.add(new ChessboardPoint(x,y+1));
            }
        if (canEatPro(x,y-1)||exactBlank(x,y-1)){
            canList.add(new ChessboardPoint(x,y-1));
        }
        if (canEatPro(x-1,y)||exactBlank(x-1,y)){
            canList.add(new ChessboardPoint(x-1,y));
        }
        if (canEatPro(x-1,y-1)||exactBlank(x-1,y-1)){
            canList.add(new ChessboardPoint(x-1,y-1));
        }
        if (canEatPro(x-1,y+1)||exactBlank(x-1,y+1)){
            canList.add(new ChessboardPoint(x-1,y+1));
        }
        return canList;
    }
}
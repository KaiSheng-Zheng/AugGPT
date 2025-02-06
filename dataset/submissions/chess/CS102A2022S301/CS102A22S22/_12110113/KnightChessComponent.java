import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, int i, int j,char name) {
        super (chessColor,i,j,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canList = new ArrayList<>();
        if (canEatPro(x-1,y-2)||exactBlank(x-1,y-2)){
            canList.add(new ChessboardPoint(x-1,y-2));
        }
        if (canEatPro(x-1,y+2)||exactBlank(x-1,y+2)){
            canList.add(new ChessboardPoint(x-1,y+2));
        }
        if (canEatPro(x-2,y-1)||exactBlank(x-2,y-1)){
            canList.add(new ChessboardPoint(x-2,y-1));
        }
        if (canEatPro(x+2,y-1)||exactBlank(x+2,y-1)){
            canList.add(new ChessboardPoint(x+2,y-1));
        }
        if (canEatPro(x-2,y+1)||exactBlank(x-2,y+1)){
            canList.add(new ChessboardPoint(x-2,y+1));
        }
        if (canEatPro(x+2,y+1)||exactBlank(x+2,y+1)){
            canList.add(new ChessboardPoint(x+2,y+1));
        }
        if (canEatPro(x+1,y+2)||exactBlank(x+1,y+2)){
            canList.add(new ChessboardPoint(x+1,y+2));
        }
        if (canEatPro(x+1,y-2)||exactBlank(x+1,y-2)){
            canList.add(new ChessboardPoint(x+1,y-2));
        }
        return canList;
    }
}



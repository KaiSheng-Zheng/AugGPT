import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{


    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor currentColor = super.getChessColor();
        if(getSource().offset(2,1) != null){
            if(currentColor != chessComponents[x+2][y+1].getChessColor())
                canMoveTo.add(new ChessboardPoint(x+2,y+1));
        }
        if(getSource().offset(2,-1) != null){
            if(currentColor != chessComponents[x+2][y-1].getChessColor())
                canMoveTo.add(new ChessboardPoint(x+2,y-1));
        }
        if(getSource().offset(-2,1) != null){
            if(currentColor != chessComponents[x-2][y+1].getChessColor())
                canMoveTo.add(new ChessboardPoint(x-2,y+1));
        }
        if(getSource().offset(-2,-1) != null){
            if(currentColor != chessComponents[x-2][y-1].getChessColor())
                canMoveTo.add(new ChessboardPoint(x-2,y-1));
        }
        if(getSource().offset(1,2) != null){
            if(currentColor != chessComponents[x+1][y+2].getChessColor())
                canMoveTo.add(new ChessboardPoint(x+1,y+2));
        }
        if(getSource().offset(1,-2) != null){
            if(currentColor != chessComponents[x+1][y-2].getChessColor())
                canMoveTo.add(chessComponents[x+1][y-2].getSource());
        }
        if(getSource().offset(-1,2) != null){
            if(currentColor != chessComponents[x-1][y+2].getChessColor())
                canMoveTo.add(new ChessboardPoint(x-1,y+2));
        }
        if(getSource().offset(-1,-2) != null){
            if(currentColor != chessComponents[x-1][y-2].getChessColor())
                canMoveTo.add(new ChessboardPoint(x-1,y-2));
        }


        if(canMoveTo.size() != 0){
            return canMoveTo;
        }
        else return new ArrayList<>();
    }
}

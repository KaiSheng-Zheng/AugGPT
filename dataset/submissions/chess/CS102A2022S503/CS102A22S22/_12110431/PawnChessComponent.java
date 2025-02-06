import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        super(source, color, name, chessComponents);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<ChessboardPoint>();
        for (int x=0;x<8;x++){
            int dx=x-getSource().getX();
            for (int y=0;y<8;y++){
                int dy=y-getSource().getY();
                if (dx==1&&Math.abs(dy)==1&&chessComponents[x][y].getChessColor()==ChessColor.WHITE&&getChessColor()==ChessColor.BLACK){
                    target.add(new ChessboardPoint(x,y));
                }
                if (dx==-1&&Math.abs(dy)==1&&chessComponents[x][y].getChessColor()==ChessColor.BLACK&&getChessColor()==ChessColor.WHITE){
                    target.add(new ChessboardPoint(x,y));
                }
            }
        }
        int x= getSource().getX();
        int y= getSource().getY();
        if (x+1<8){
            if (chessComponents[x+1][y].getChessColor()==ChessColor.NONE&&getChessColor()==ChessColor.BLACK){
                target.add(new ChessboardPoint(x+1,y));
                if (y==1){
                    if (chessComponents[x+2][y].getChessColor()==ChessColor.NONE){
                    target.add(new ChessboardPoint(x+2,y));
                    }
                }
            }
        }
        if (x-1>=0){
            if (chessComponents[x-1][y].getChessColor()==ChessColor.NONE&&getChessColor()==ChessColor.WHITE){
                target.add(new ChessboardPoint(x-1,y));
                if (y==6){
                    if (chessComponents[x-2][y].getChessColor()==ChessColor.NONE){
                        target.add(new ChessboardPoint(x-2,y));
                    }
                }
            }
        }

        return target;
    }
}

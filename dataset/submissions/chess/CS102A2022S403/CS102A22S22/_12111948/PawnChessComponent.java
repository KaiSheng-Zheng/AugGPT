import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = super.getChessBoard();
        int x = super.getX();
        int y = super.getY();
        ChessComponent chess = chessComponents[x][y];
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if(super.getChessColor() == ChessColor.BLACK){
            if(x == 1){
                chessboardPoints.add(new ChessboardPoint(2,y));
                chessboardPoints.add(new ChessboardPoint(3,y));
                if(isValid(y - 1)){
                    chessboardPoints.add(new ChessboardPoint(2,y - 1));
                }
                if(isValid(y + 1)){
                    chessboardPoints.add(new ChessboardPoint(2,y + 1));
                }
            }
            else{
                if(isValid(x + 1)){
                    chessboardPoints.add(new ChessboardPoint(x + 1,y));
                    if(isValid(y - 1)){
                        chessboardPoints.add(new ChessboardPoint(x + 1,y - 1));
                    }
                    if(isValid(y + 1)){
                        chessboardPoints.add(new ChessboardPoint(x + 1,y + 1));
                    }
                }
            }
        }
        else{
            if(x == 6){
                chessboardPoints.add(new ChessboardPoint(5,y));
                chessboardPoints.add(new ChessboardPoint(4,y));
                if(isValid(y - 1)){
                    chessboardPoints.add(new ChessboardPoint(5,y - 1));
                }
                if(isValid(y + 1)){
                    chessboardPoints.add(new ChessboardPoint(5,y + 1));
                }
            }
            else{
                if(isValid(x - 1)){
                    chessboardPoints.add(new ChessboardPoint(x - 1,y));
                    if(isValid(y - 1)){
                        chessboardPoints.add(new ChessboardPoint(x - 1,y - 1));
                    }
                    if(isValid(y + 1)){
                        chessboardPoints.add(new ChessboardPoint(x - 1,y + 1));
                    }
                }
            }
        }
        List<ChessboardPoint> toDelete = new ArrayList<>();
        for(ChessboardPoint chessboardPoint : chessboardPoints){
            int targetX = chessboardPoint.getX();
            int targetY = chessboardPoint.getY();
            if(chessboardPoint.getY() != y){
                if(!chess.isOpposite(chessComponents[targetX][targetY])){
                    toDelete.add(chessboardPoint);
                }
            }
            else{
                if(chessComponents[targetX][targetY].name != '_'){
                    toDelete.add(chessboardPoint);
                }
            }
        }
        for(ChessboardPoint chessboardPoint : toDelete){
            chessboardPoints.remove(chessboardPoint);
        }
        chessboardPoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getX() == o2.getX() ? new Integer(o1.getY()).compareTo(new Integer(o2.getY())):new Integer(o1.getX()).compareTo(new Integer(o2.getX()));
            }
        });
        return chessboardPoints;
    }
    public PawnChessComponent(int x,int y){
        super(x, y);
    }
    public PawnChessComponent(){}
    public boolean isValid(int a){
        return a <= 7 & a >= 0;
    }
}

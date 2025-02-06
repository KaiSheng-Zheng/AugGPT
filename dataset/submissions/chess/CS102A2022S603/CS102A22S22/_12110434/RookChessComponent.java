import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{


    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor chessColor;
    private ChessboardPoint chessboardPoint;

    protected RookChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents1) {
        this.name=name;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents1;
        this.chessboardPoint=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return getCanMovePoints(chessboardPoint);
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> target = new ArrayList<>();
        for(int i=source.getX()-8;i<=8- source.getX();i++){
            if(chessComponents[source.getX()+i][source.getY()].getChessColor()!=chessColor) {
                target.add(source.offset(i, 0));
            }
        }
        for(int j=source.getY()-8;j<=8- source.getY();j++){
            if(chessComponents[source.getX()][source.getY()+j].getChessColor()!=chessColor)
            target.add(source.offset(0,j));
        }
        return target;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        for (int i=sourceX-8;i<=8-sourceX;i++) {
            return targetX == sourceX + i && targetY == sourceY;
        }
        for(int j=sourceY-8;j<=8-sourceY;j++){
            return targetX==sourceX && targetY ==sourceY+j;
        }
        return false;
    }
}

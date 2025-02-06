import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor chessColor;
    private ChessboardPoint chessboardPoint;

    protected BishopChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents1) {
        this.name=name;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents1;
        this.chessboardPoint=chessboardPoint;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> target = new ArrayList<>();
        for(int i= -7;i< 8 ;i++){
            if(chessComponents[source.getX()+i][source.getY()+i].getChessColor()!=chessColor) {
                target.add(source.offset(i, i));
            }if(chessComponents[source.getX()+i][source.getY()-i].getChessColor()!=chessColor) {
                target.add(source.offset(i, -i));
            }
        }return target;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        for(int i=-7;i<8;i++){
            boolean b = targetX == sourceX + i && targetY == sourceY + i && targetX <= 8&&targetY<=8;
            boolean c = targetX==sourceX+i&&targetY==sourceY-i&&targetX<=8&&targetY<=8;
            if(b){
                return true;
            }else if(c){
                return true;
            }
        }return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}


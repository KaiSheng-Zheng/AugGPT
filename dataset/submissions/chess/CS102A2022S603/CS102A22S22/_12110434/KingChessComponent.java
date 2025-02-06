import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessboardPoint chessboardPoint;
    private ChessColor color;

    public KingChessComponent(char name,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents) {
        this.name=name;
        this.chessComponents=chessComponents;
        this.chessboardPoint=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return getCanMovePoints(chessboardPoint);
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> target = new ArrayList<>();
        if(chessComponents[source.getX()+1][source.getY()+1].getChessColor()!=getChessColor()){
            target.add(source.offset(1, 1));
        }if(chessComponents[source.getX()+1][source.getY()-1].getChessColor()!=getChessColor()){
            target.add(source.offset(1, -1));
        }if(chessComponents[source.getX()][source.getY()+1].getChessColor()!=getChessColor()) {
            target.add(source.offset(0, 1));
        }if(chessComponents[source.getX()][source.getY()+1].getChessColor()!=getChessColor()) {
            target.add(source.offset(0, -1));
        }if(chessComponents[source.getX()-1][source.getY()+1].getChessColor()!=getChessColor()) {
            target.add(source.offset(-1, 1));
        }if(chessComponents[source.getX()-1][source.getY()-1].getChessColor()!=getChessColor()) {
            target.add(source.offset(-1, -1));
        }if(chessComponents[source.getX()+1][source.getY()].getChessColor()!=getChessColor()) {
            target.add(source.offset(1, 0));
        }if(chessComponents[source.getX()-1][source.getY()].getChessColor()!=getChessColor()) {
            target.add(source.offset(-1, 0));
        }
        return target;
    }

    public boolean moveChess( int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX==targetX+1&&sourceY==targetY+1){
            return true;
        }else if(sourceX==targetX+1&&sourceY==targetY){
            return true;
        }else if(sourceX==targetX+1&&sourceY==targetY-1){
            return true;
        }else if(sourceX==targetX&&sourceY==targetY+1){
            return true;
        }else if(sourceX==targetX&&sourceY==targetY-1){
            return true;
        }else if(sourceX==targetX-1&&sourceY==targetY+1){
            return true;
        }else if(sourceX==targetX-1&&sourceY==targetY){
            return true;
        }else return sourceX == targetX - 1 && sourceY == targetY - 1;
    }
}

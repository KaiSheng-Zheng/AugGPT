import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
public ChessComponent[][] chessComponents;
    public BishopChessComponent(int x, int y, char name, ChessComponent[][] chessComponent) {
        super(x, y,name);
        this.chessComponents=chessComponent;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moveChess(chessComponents,chessComponents[i][j].getChessboardPoint() )) {
                    move.add(chessComponents[i][j].getChessboardPoint());

                }
                }
            }
        if(move.size()==0){
            return new ArrayList<>();
        }else {
            return move;
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
          return true;
    }
    public boolean moveChess(ChessComponent chessComponent[][],ChessboardPoint target) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getX() - source.getY()== target.getX() - target.getY())  {
            int row;
            int col;
            if(chessComponents[source.getX()][source.getY()].getChessColor()!=chessComponents[target.getX()][target.getY()].getChessColor()){
            if(source.getX()<target.getX()){
                for(row=source.getX()+1, col = source.getY()+1;col< target.getY();row++,col++){
                if(! (chessComponents[row][col]instanceof EmptySlotComponent) ){
                    return false;
                } }return true;
            }
            else {
                for(row= target.getX()+1,col=target.getY()+1;row<source.getX();row++,col++){
                    if(! (chessComponents[row][col]instanceof EmptySlotComponent) ){
                    return false;
                }}return true;
            }
        }else return false;}
            else if(target.getX()-source.getX()== source.getY()- target.getY()){
            int row;
            int col;
            if(chessComponents[source.getX()][source.getY()].getChessColor()!=chessComponents[target.getX()][target.getY()].getChessColor()){
            for(row=Math.min(source.getX(), target.getX())+1,col=Math.max(source.getY(), target.getY())-1;row<Math.max(source.getX(), target.getX());row++,col--)  {
                if(!(chessComponents[row][col]instanceof EmptySlotComponent)){
                    return false;
                }
            }return true;
            }else return false;
            }
            else return false;
        }
}

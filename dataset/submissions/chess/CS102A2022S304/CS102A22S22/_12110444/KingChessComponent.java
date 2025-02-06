import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public ChessComponent[][] chessComponents;

    public KingChessComponent(int x, int y, char name, ChessComponent[][] chessComponent) {
        super(x, y, name);
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
        return false;
    }
    public boolean moveChess(ChessComponent chessComponent[][],ChessboardPoint target) {
        ChessboardPoint source = getChessboardPoint();
        if (chessComponent[source.getX()][source.getY()].getChessColor() != chessComponent[target.getX()][target.getY()].getChessColor()) {
        if(source.getX()== target.getX()&&Math.abs(source.getY()- target.getY())==1){
            return true;
        }
        if(source.getY()==target.getY()&&Math.abs(source.getX()-target.getX())==1){
            return true;
        }
        if(Math.abs(source.getX()-target.getX())==1&&Math.abs(source.getY()- target.getY())==1){
            return true;
        } else {return false;}}
        else {return false;}
}}

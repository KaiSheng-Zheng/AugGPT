import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (canMove(i,j) && chick(i,j)){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
    public PawnChessComponent(){}

    public PawnChessComponent(ChessboardPoint source,ChessComponent[][] chessComponents, ChessColor chessColor, char name){
        super(source,chessComponents, chessColor, name);
        this.name=name;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public boolean canMove(int x, int y){
        ChessboardPoint source = getSource();
        if (source.getY() == y){
            if (chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK){
                if (source.getX() == 1){
                    if ((source.getX()-x == -1 || source.getX()-x == -2) && (chessComponents[x][y] instanceof EmptyChessComponent)){
                        return true;
                    }
                    else {
                        return false;
                    }
                }else {
                    if (source.getX()-x != -1){
                        return false;
                    }
                }
            }
            if (chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE){
                if (source.getX() == 6){
                    return (source.getX() - x == 1 || source.getX() - x == 2) && (chessComponents[x][y] instanceof EmptyChessComponent);
                }else {
                    if (source.getX()- x != 1){
                        return false;
                    }
                }
            }
            if (!(chessComponents[x][y] instanceof EmptyChessComponent)){
                return false;
            }
        }else if (Math.abs(source.getY()-y) == 1){
            if (chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK &&  source.getX()-x == -1 && !(chessComponents[x][y] instanceof EmptyChessComponent)){
                return true;
            }
            if (chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE&& source.getX()-x ==1 && !(chessComponents[x][y] instanceof EmptyChessComponent)){
                return true;
            }
            return false;
        }
        else {
            return false;
        }
        return true;
    }

    public boolean chick(int x, int y){
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptyChessComponent){
            return true;
        }
        return false;
    }

}

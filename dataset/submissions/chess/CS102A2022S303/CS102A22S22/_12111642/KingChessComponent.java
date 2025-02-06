import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;
    public ChessColor getColor() {
        return super.getChessColor();
    }
    public KingChessComponent(ChessColor color,int x,int y,ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(x,y));
        setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        for (int i = 0; i<8 ; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint n = new ChessboardPoint(i,j);
                if(canMove(n)) output.add(n);
            }
        }
        return output;
    }
    public boolean canMove(ChessboardPoint destination){
        ChessboardPoint source = super.getSource();
        if(chessComponents[destination.getX()][destination.getY()].getChessColor() ==
                chessComponents[source.getX()][source.getY()].getChessColor())
            return false;
        if (source.getX() == destination.getX()+1||source.getX() == destination.getX()-1) {
            int col = source.getY();
            if(!(destination.getY() == col + 1 || destination.getY() == col - 1 || destination.getY() == col))
                return false;
        }
        else if (source.getY() == destination.getY()+1||source.getY() == destination.getY()-1) {
            int row = source.getX();
            if(!(destination.getX() == row + 1 || destination.getX() == row - 1 || destination.getX() == row))
                return false;
        }
        else if (source.getY() == destination.getY()){
            int row = source.getX();
            if(!(destination.getX() == row + 1 || destination.getX() == row - 1))
                return false;
        }
        else if (source.getX() == destination.getX()){
            int col = source.getY();
            if(!(destination.getY() == col + 1 || destination.getY() == col - 1))
                return false;
        }
        else {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        if(super.getChessColor() == ChessColor.BLACK)
            return String.valueOf('K');
        else return String.valueOf('k');
    }
}

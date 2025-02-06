import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent chessComponents[][] = ConcreteChessGame.chessBoard;
        int x = super.getX();
        int y = super.getY();
        ChessComponent chess = chessComponents[x][y];
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if(super.getChessColor() == ChessColor.BLACK){
            if(x == 1){
                if(chessComponents[2][y].getChessColor().equals(ChessColor.NONE)){
                    chessboardPoints.add(new ChessboardPoint(2,y));
                if(chessComponents[3][y].getChessColor().equals(ChessColor.NONE))
                    chessboardPoints.add(new ChessboardPoint(3,y));
                }
                if(isValid(y - 1)){
                    if(chess.isOpposite(chessComponents[2][y - 1]))
                        chessboardPoints.add(new ChessboardPoint(2,y - 1));
                }
                if(isValid(y + 1)){
                    if(chess.isOpposite(chessComponents[2][y + 1]))
                        chessboardPoints.add(new ChessboardPoint(2,y + 1));
                }
            }
            else{
                if(isValid(x + 1)){
                    if(chessComponents[x + 1][y].getChessColor().equals(ChessColor.NONE))
                        chessboardPoints.add(new ChessboardPoint(x + 1,y));
                    if(isValid(y - 1)){
                        if(chess.isOpposite(chessComponents[x + 1][y - 1]))
                            chessboardPoints.add(new ChessboardPoint(x + 1,y - 1));
                    }
                    if(isValid(y + 1)){
                        if(chess.isOpposite(chessComponents[x + 1][y + 1]))
                            chessboardPoints.add(new ChessboardPoint(x + 1,y + 1));
                    }
                }
            }
        }
        else{
            if(x == 6){
                if(chessComponents[5][y].getChessColor().equals(ChessColor.NONE)){
                    chessboardPoints.add(new ChessboardPoint(5,y));
                if(chessComponents[4][y].getChessColor().equals(ChessColor.NONE))
                    chessboardPoints.add(new ChessboardPoint(4,y));
                }
                if(isValid(y - 1)){
                    if(chess.isOpposite(chessComponents[5][y - 1]))
                        chessboardPoints.add(new ChessboardPoint(5,y - 1));
                }
                if(isValid(y + 1)){
                    if(chess.isOpposite(chessComponents[5][y + 1]))
                        chessboardPoints.add(new ChessboardPoint(5,y + 1));
                }
            }
            else{
                if(isValid(x - 1)){
                    if(chessComponents[x - 1][y].getChessColor().equals(ChessColor.NONE))
                        chessboardPoints.add(new ChessboardPoint(x - 1,y));
                    if(isValid(y - 1)){
                        if(chess.isOpposite(chessComponents[x - 1][y - 1]))
                            chessboardPoints.add(new ChessboardPoint(x - 1,y - 1));
                    }
                    if(isValid(y + 1)){
                        if(chess.isOpposite(chessComponents[x - 1][y + 1]))
                            chessboardPoints.add(new ChessboardPoint(x - 1,y + 1));
                    }
                }
            }
        }
        return chessboardPoints;
    }
    public PawnChessComponent(int x,int y){
        super(x, y);
    }
    public PawnChessComponent(){}
}

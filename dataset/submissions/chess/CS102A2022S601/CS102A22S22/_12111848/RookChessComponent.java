import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        for(int x = source.getX() - 1; x >= 0; x--) {
            if(chessComponents[x][source.getY()].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                break;
            }else if(chessComponents[x][source.getY()].getChessColor() == ChessColor.NONE){
                canMoveToPoints.add(new ChessboardPoint(x,source.getY()));
            }else if(chessComponents[x][source.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(x,source.getY()));
                break;
            }
        }

        for(int x = source.getX() + 1; x < 8; x++) {
            if(chessComponents[x][source.getY()].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                break;
            }else if(chessComponents[x][source.getY()].getChessColor() == ChessColor.NONE){
                canMoveToPoints.add(new ChessboardPoint(x,source.getY()));
            }else if(chessComponents[x][source.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(x,source.getY()));
                break;
            }
        }

        for(int y = source.getY() - 1; y >= 0 ; y--){
            if(chessComponents[source.getX()][y].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                break;
            }else if(chessComponents[source.getX()][y].getChessColor() == ChessColor.NONE){
                canMoveToPoints.add(new ChessboardPoint(source.getX(),y));
            }else if(chessComponents[source.getX()][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX(),y));
                break;
            }
        }

        for(int y = source.getY() + 1; y < 8 ; y++){
            if(chessComponents[source.getX()][y].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                break;
            }else if(chessComponents[source.getX()][y].getChessColor() == ChessColor.NONE){
                canMoveToPoints.add(new ChessboardPoint(source.getX(),y));
            }else if(chessComponents[source.getX()][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX(),y));
                break;
            }
        }

        return canMoveToPoints;
    }
}

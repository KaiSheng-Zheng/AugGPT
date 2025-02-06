import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent() {
    }


    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint,color,name);
    }

    public PawnChessComponent(ChessColor white) {
        super(white);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        ChessComponent[][] chessboard = getChessboard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint destination = new ChessboardPoint(i,j);
                if(canMove(chessboard,destination)){
                    points.add(new ChessboardPoint(i,j));
                }
            }
        }
        return points;
    }


    public boolean canMove(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if(getChessColor() == ChessColor.WHITE){
            if(source.getX()==1&&
                    source.getY()==destination.getY()
                    && destination.getX()>source.getX()
                    && destination.getX()-source.getX()<=2
                    && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.NONE
                    && chessComponents[source.getX()+1][source.getY()].getChessColor() == ChessColor.NONE){
                return true;
            }else if (source.getY()==destination.getY()
                    && destination.getX()>source.getX()
                    && destination.getX()-source.getX()<=1
                    && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.NONE){
                return true;
            }else return chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK
                    && destination.getX() > source.getX()
                    && 2 == (source.getX() - destination.getX()) * (source.getX() - destination.getX())
                    + (source.getY() - destination.getY()) * (source.getY() - destination.getY());
        }else if(getChessColor() == ChessColor.BLACK){ /////////////////////////////////////
            if(source.getX()==6&&
                    source.getY()==destination.getY()
                    && destination.getX()<source.getX()
                    && destination.getX()-source.getX()>=-2
                    && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.NONE
                    && chessComponents[source.getX()-1][source.getY()].getChessColor() == ChessColor.NONE){
                return true;
            }else if (source.getY()==destination.getY()
                    && destination.getX()<source.getX()
                    && destination.getX()-source.getX()>=-1
                    && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.NONE){
                return true;
            }else return chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE
                    && destination.getX() < source.getX()
                    && 2 == (source.getX() - destination.getX()) * (source.getX() - destination.getX())
                    + (source.getY() - destination.getY()) * (source.getY() - destination.getY());
        }
        return false;
    }
}

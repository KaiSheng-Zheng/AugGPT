import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movePointList = new ArrayList<>();
        ChessComponent[][] chessComponents = ConcreteChessGame.chessComponentsStatic;
        int sourceX = super.getSource().getX();
        int sourceY = super.getSource().getY();
        ChessColor color = getChessColor();
        ChessColor oppositeColor = (color == ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
        if (color==ChessColor.WHITE){
            if (sourceX-1 >= 0 && chessComponents[sourceX-1][sourceY].getName() == '_') {
                movePointList.add(new ChessboardPoint(sourceX-1, sourceY));
                if (sourceX==6 && chessComponents[sourceX-2][sourceY].getName() == '_'){
                    movePointList.add(new ChessboardPoint(sourceX-2, sourceY));
                }
            }
            if (sourceX-1 >= 0 && sourceY-1 >= 0 && chessComponents[sourceX-1][sourceY-1].getChessColor() == oppositeColor){
                movePointList.add(new ChessboardPoint(sourceX-1, sourceY-1));
            }
            if (sourceX-1 >= 0 && sourceY+1 <= 7 && chessComponents[sourceX-1][sourceY+1].getChessColor() == oppositeColor){
                movePointList.add(new ChessboardPoint(sourceX-1, sourceY+1));
            }
        }else if (color==ChessColor.BLACK){
            if (sourceX+1 <= 7 && chessComponents[sourceX+1][sourceY].getName() == '_') {
                movePointList.add(new ChessboardPoint(sourceX+1, sourceY));
                if (sourceX==1 && chessComponents[sourceX+2][sourceY].getName() == '_'){
                    movePointList.add(new ChessboardPoint(sourceX+2, sourceY));
                }
            }
            if (sourceX+1 <= 7 && sourceY-1 >= 0 && chessComponents[sourceX+1][sourceY-1].getChessColor() == oppositeColor){
                movePointList.add(new ChessboardPoint(sourceX+1, sourceY-1));
            }
            if (sourceX+1 <= 7 && sourceY+1 <= 7 && chessComponents[sourceX+1][sourceY+1].getChessColor() == oppositeColor){
                movePointList.add(new ChessboardPoint(sourceX+1, sourceY+1));
            }
        }
        return movePointList;
    }
}

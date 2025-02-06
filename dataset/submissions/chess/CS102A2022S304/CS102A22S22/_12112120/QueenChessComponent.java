

import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public QueenChessComponent(ChessboardPoint point,ChessColor color,ChessComponent[][] chessComponents){
        super(point,color);
        setChessComponents(chessComponents);
    }
    @Override
    public String toString(){
        if(this.getChessColor()==ChessColor.BLACK) return "Q";
        else return "q";
    }

    public boolean canM(ChessboardPoint point){
        ChessboardPoint source = getSource();
        if (source.getX() == point.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), point.getY()) + 1;
                 col < Math.max(source.getY(), point.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == point.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), point.getX()) + 1;
                 row < Math.max(source.getX(), point.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getX() + source.getY() == point.getX() + point.getY()) {
            for (int col = Math.min(source.getY(), point.getY()) + 1;
                 col < Math.max(source.getY(), point.getY()); col++) {
                int row = source.getX() + source.getY() - col;
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getX() - source.getY() == point.getX() - point.getY()) {
            for (int col = Math.min(source.getY(), point.getY()) + 1;
                 col < Math.max(source.getY(), point.getY()); col++) {
                int row = source.getX() - source.getY() + col;
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return this.getChessColor() != chessComponents[point.getX()][point.getY()].getChessColor();
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> List=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point=new ChessboardPoint(i,j);
                if(canM(point)){
                    List.add(point);
                }
            }
        }
        return List;
    }
}


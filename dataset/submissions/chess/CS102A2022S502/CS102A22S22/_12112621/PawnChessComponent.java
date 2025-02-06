import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(x, y, chessColor,name,chessboard);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ableToMoveTo(getChessboard()[i][j])){
                    result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }

    public boolean ableToMoveTo(ChessComponent b) {
        ChessboardPoint source = getSource();
        ChessboardPoint target = b.getSource();

        int col = source.getY();

        if (getChessColor() == ChessColor.WHITE){
            if (source.getY() == target.getY() && !(getChessboard()[source.getX() - 1][col] instanceof EmptySlotComponent)){
                return false;
            }else{
                if (source.getX() == 6){
                    if (source.getY() == target.getY() && (target.getX() == 4  || target.getX() == 5) && (getChessboard()[target.getX()][target.getY()] instanceof EmptySlotComponent)) {
                        for (int i = Math.min(source.getX(), target.getX()) + 1;
                             i < Math.max(source.getX(), target.getX()); i++) {
                            if (!(getChessboard()[i][col] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }return true;
                    }
                }else{
                    if (source.getY() == target.getY() && source.getX() - target.getX() == 1) {
                        for (int i = Math.min(source.getX(), target.getX()) + 1;
                             i < Math.max(source.getX(), target.getX()); i++) {
                            if (!(getChessboard()[i][col] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }return true;
                    }
                }

                if (source.getX() - target.getX() == 1 && Math.abs(source.getY() - target.getY()) == 1){
                    return !(b instanceof EmptySlotComponent) && (b.getChessColor() != getChessColor());
                }
                return false;
            }
        }

        if (getChessColor() == ChessColor.BLACK ){
            if (source.getY() == target.getY() && !(getChessboard()[source.getX() + 1][col] instanceof EmptySlotComponent)){
                return false;
            }else{
                if (source.getX() == 1){
                    if (source.getY() == target.getY() && (target.getX() == 2  || target.getX() == 3) && (getChessboard()[target.getX()][target.getY()] instanceof EmptySlotComponent)) {
                        for (int i = Math.min(source.getX(), target.getX()) + 1;
                             i < Math.max(source.getX(), target.getX()); i++) {
                            if (!(getChessboard()[i][col] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }return true;
                    }
                }else{
                    if (source.getY() == target.getY() && source.getX() - target.getX() == -1) {
                        for (int i = Math.min(source.getX(), target.getX()) + 1;
                             i < Math.max(source.getX(), target.getX()); i++) {
                            if (!(getChessboard()[i][col] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }return true;
                    }
                }

                if (source.getX() - target.getX() == -1 && Math.abs(source.getY() - target.getY()) == 1){
                    return !(b instanceof EmptySlotComponent) && (b.getChessColor() != getChessColor());
                }
                return false;
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        super(name,source,chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> rook = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        for (int i = row+1; i < 8; i++) {
            if (getChessComponents()[i][col].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[i][col].getChessColor() != getChessColor()){
                if (getChessComponents()[i][col].getChessColor() == ChessColor.NONE){
                    rook.add(new ChessboardPoint(i,col));
                }else{
                    rook.add(new ChessboardPoint(i,col));
                    break;
                }
            }
        }
        for (int i = row-1; i > -1; i--) {
            if (getChessComponents()[i][col].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[i][col].getChessColor() != getChessColor()){
                if (getChessComponents()[i][col].getChessColor() == ChessColor.NONE){
                    rook.add(new ChessboardPoint(i,col));
                }else{
                    rook.add(new ChessboardPoint(i,col));
                    break;
                }
            }
        }
        for (int i = col+1; i < 8; i++) {
            if (getChessComponents()[row][i].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row][i].getChessColor() != getChessColor()){
                if (getChessComponents()[row][i].getChessColor() == ChessColor.NONE) {
                    rook.add(new ChessboardPoint(row, i));
                }else{
                    rook.add(new ChessboardPoint(row, i));
                    break;
                }
            }
        }
        for (int i = col-1; i > -1; i--) {
            if (getChessComponents()[row][i].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row][i].getChessColor() != getChessColor()){
                if (getChessComponents()[row][i].getChessColor() == ChessColor.NONE) {
                    rook.add(new ChessboardPoint(row, i));
                }else{
                    rook.add(new ChessboardPoint(row, i));
                    break;
                }
            }
        }

        return rook;
    }

}

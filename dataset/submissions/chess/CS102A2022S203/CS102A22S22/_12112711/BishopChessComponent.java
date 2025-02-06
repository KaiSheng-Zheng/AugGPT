import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        super(name,source,chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> bishop = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        for (int i = Math.max(row,col)+1,row1= getSource().getX()+1,col1 = getSource().getY()+1; i < 8; i++,row1++,col1++) {
            if (getChessComponents()[row1][col1].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row1][col1].getChessColor() != getChessColor()){
                if (getChessComponents()[row1][col1].getChessColor() == ChessColor.NONE) {
                    bishop.add(new ChessboardPoint(row1, col1));
                }else{
                    bishop.add(new ChessboardPoint(row1, col1));
                    break;
                }
            }
        }
        for (int i = Math.min(row,col)-1,row1= getSource().getX()-1,col1 = getSource().getY()-1; i > -1; i--,row1--,col1--) {
            if (getChessComponents()[row1][col1].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row1][col1].getChessColor() != getChessColor()){
                if (getChessComponents()[row1][col1].getChessColor() == ChessColor.NONE) {
                    bishop.add(new ChessboardPoint(row1, col1));
                }else{
                    bishop.add(new ChessboardPoint(row1, col1));
                    break;
                }
            }
        }
        for (int i = Math.min(7-row,col)-1,row1= getSource().getX()+1,col1 = getSource().getY()-1; i > -1; i--,row1++,col1--) {
            if (getChessComponents()[row1][col1].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row1][col1].getChessColor() != getChessColor()){
                if (getChessComponents()[row1][col1].getChessColor() == ChessColor.NONE) {
                    bishop.add(new ChessboardPoint(row1, col1));
                }else{
                    bishop.add(new ChessboardPoint(row1, col1));
                    break;
                }
            }
        }
        for (int i = Math.min(row,7-col)-1,row1= getSource().getX()-1,col1 = getSource().getY()+1; i > -1; i--,row1--,col1++) {
            if (getChessComponents()[row1][col1].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row1][col1].getChessColor() != getChessColor()){
                if (getChessComponents()[row1][col1].getChessColor() == ChessColor.NONE) {
                    bishop.add(new ChessboardPoint(row1, col1));
                }else{
                    bishop.add(new ChessboardPoint(row1, col1));
                    break;
                }
            }
        }

        return bishop;
    }
}

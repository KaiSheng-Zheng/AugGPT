import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        super(name,source,chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> queen = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        for (int i = row+1; i < 8; i++) {
            if (getChessComponents()[i][col].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[i][col].getChessColor() != getChessColor()){
                if (getChessComponents()[i][col].getChessColor() == ChessColor.NONE){
                    queen.add(new ChessboardPoint(i,col));
                }else{
                    queen.add(new ChessboardPoint(i,col));
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
                    queen.add(new ChessboardPoint(i,col));
                }else{
                    queen.add(new ChessboardPoint(i,col));
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
                    queen.add(new ChessboardPoint(row, i));
                }else{
                    queen.add(new ChessboardPoint(row, i));
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
                    queen.add(new ChessboardPoint(row, i));
                }else{
                    queen.add(new ChessboardPoint(row, i));
                    break;
                }
            }
        }

        for (int i = Math.max(row,col)+1,row1= getSource().getX()+1,col1 = getSource().getY()+1; i < 8; i++,row1++,col1++) {
            if (getChessComponents()[row1][col1].getChessColor() == getChessColor()){
                break;
            }
            if (getChessComponents()[row1][col1].getChessColor() != getChessColor()){
                if (getChessComponents()[row1][col1].getChessColor() == ChessColor.NONE) {
                    queen.add(new ChessboardPoint(row1, col1));
                }else{
                    queen.add(new ChessboardPoint(row1, col1));
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
                    queen.add(new ChessboardPoint(row1, col1));
                }else{
                    queen.add(new ChessboardPoint(row1, col1));
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
                    queen.add(new ChessboardPoint(row1, col1));
                }else{
                    queen.add(new ChessboardPoint(row1, col1));
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
                    queen.add(new ChessboardPoint(row1, col1));
                }else{
                    queen.add(new ChessboardPoint(row1, col1));
                    break;
                }
            }
        }

        return queen;
    }
}

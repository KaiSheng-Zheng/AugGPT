import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name) {
        super(name);
    }

    public RookChessComponent(char name, ChessboardPoint source) {
        super(name, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int row = getSource().getX();
        int col = getSource().getY();
        //find points on the ChessBoard, and add them to the List
        ArrayList<ChessboardPoint> rookDest = new ArrayList<>();
        for (int i = 1;i<=7;i++){
            if (row+i <= 7){
                if (getChessBoard()[row+i][col].getName()=='_'){
                    rookDest.add(new ChessboardPoint(row+i,col));
                }else if (getChessBoard()[row+i][col].getName() != '_' && !getChessBoard()[row+i][col].getChessColor().equals(getChessColor())){
                    rookDest.add(new ChessboardPoint(row+i,col));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row-i >= 0){
                if (getChessBoard()[row-i][col].getName()=='_'){
                    rookDest.add(new ChessboardPoint(row-i,col));
                }else if (getChessBoard()[row-i][col].getName()!='_' && !getChessBoard()[row-i][col].getChessColor().equals(getChessColor())){
                    rookDest.add(new ChessboardPoint(row-i,col));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (col+i <= 7){
                if (getChessBoard()[row][col+i].getName()=='_'){
                    rookDest.add(new ChessboardPoint(row,col+i));
                }else if (getChessBoard()[row][col+i].getName()!='_' && !getChessBoard()[row][col+i].getChessColor().equals(getChessColor())){
                    rookDest.add(new ChessboardPoint(row,col+i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (col-i >= 0){
                if (getChessBoard()[row][col-i].getName()=='_'){
                    rookDest.add(new ChessboardPoint(row,col-i));
                }else if (getChessBoard()[row][col-i].getName()!='_' && !getChessBoard()[row][col-i].getChessColor().equals(getChessColor())){
                    rookDest.add(new ChessboardPoint(row,col-i));
                    break;
                }else break;
            }else break;
        }

        return rookDest;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

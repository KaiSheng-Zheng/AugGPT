import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(char name) {
        super(name);
    }

    public BishopChessComponent(char name, ChessboardPoint source) {
        super(name, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int row = getSource().getX();
        int col = getSource().getY();
        //find points on the ChessBoard, and add them to the List
        ArrayList<ChessboardPoint> bishopDest = new ArrayList<>();
        for (int i = 1;i<=7;i++){
            if (row+i<=7 && col+i<=7){
                if (getChessBoard()[row+i][col+i].getName()=='_'){
                    bishopDest.add(new ChessboardPoint(row+i,col+i));
                }else if (getChessBoard()[row+i][col+i].getName()!='_' && !getChessBoard()[row+i][col+i].getChessColor().equals(getChessColor())){
                    bishopDest.add(new ChessboardPoint(row+i,col+i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row+i<=7 && col-i>=0){
                if (getChessBoard()[row+i][col-i].getName()=='_'){
                    bishopDest.add(new ChessboardPoint(row+i,col-i));
                }else if (getChessBoard()[row+i][col-i].getName()!='_' && !getChessBoard()[row+i][col-i].getChessColor().equals(getChessColor())){
                    bishopDest.add(new ChessboardPoint(row+i,col-i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row-i>=0 && col+i<=7){
                if (getChessBoard()[row-i][col+i].getName()=='_'){
                    bishopDest.add(new ChessboardPoint(row-i,col+i));
                }else if (getChessBoard()[row-i][col+i].getName()!='_' && !getChessBoard()[row-i][col+i].getChessColor().equals(getChessColor())){
                    bishopDest.add(new ChessboardPoint(row-i,col+i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row-i>=0 && col-i>=0){
                if (getChessBoard()[row-i][col-i].getName()=='_'){
                    bishopDest.add(new ChessboardPoint(row-i,col-i));
                }else if (getChessBoard()[row-i][col-i].getName()!='_' && !getChessBoard()[row-i][col-i].getChessColor().equals(getChessColor())){
                    bishopDest.add(new ChessboardPoint(row-i,col-i));
                    break;
                }else break;
            }else break;
        }

        return bishopDest;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

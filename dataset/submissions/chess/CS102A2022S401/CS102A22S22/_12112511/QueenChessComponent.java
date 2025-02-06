import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char name) {
        super(name);
    }

    public QueenChessComponent(char name, ChessboardPoint source) {
        super(name, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int row = getSource().getX();
        int col = getSource().getY();
        //find points on the ChessBoard, and add them to the List
        ArrayList<ChessboardPoint> queenDest = new ArrayList<>();
        straight(row,col,queenDest);
        tilt(row,col,queenDest);

        return queenDest;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void straight(int row,int col,List<ChessboardPoint> queenDest){
        for (int i = 1;i<=7;i++){
            if (row+i <= 7){
                if (getChessBoard()[row+i][col].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row+i,col));
                }else if (getChessBoard()[row+i][col].getName() != '_' && !getChessBoard()[row+i][col].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row+i,col));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row-i >= 0){
                if (getChessBoard()[row-i][col].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row-i,col));
                }else if (getChessBoard()[row-i][col].getName()!='_' && !getChessBoard()[row-i][col].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row-i,col));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (col+i <= 7){
                if (getChessBoard()[row][col+i].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row,col+i));
                }else if (getChessBoard()[row][col+i].getName()!='_' && !getChessBoard()[row][col+i].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row,col+i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (col-i >= 0){
                if (getChessBoard()[row][col-i].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row,col-i));
                }else if (getChessBoard()[row][col-i].getName()!='_' && !getChessBoard()[row][col-i].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row,col-i));
                    break;
                }else break;
            }else break;
        }
    }

    private void tilt(int row, int col, List<ChessboardPoint> queenDest){
        for (int i = 1;i<=7;i++){
            if (row+i<=7 && col+i<=7){
                if (getChessBoard()[row+i][col+i].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row+i,col+i));
                }else if (getChessBoard()[row+i][col+i].getName()!='_' && !getChessBoard()[row+i][col+i].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row+i,col+i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row+i<=7 && col-i>=0){
                if (getChessBoard()[row+i][col-i].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row+i,col-i));
                }else if (getChessBoard()[row+i][col-i].getName()!='_' && !getChessBoard()[row+i][col-i].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row+i,col-i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++){
            if (row-i>=0 && col+i<=7){
                if (getChessBoard()[row-i][col+i].getName()=='_'){
                    queenDest.add(new ChessboardPoint(row-i,col+i));
                }else if (getChessBoard()[row-i][col+i].getName()!='_' && !getChessBoard()[row-i][col+i].getChessColor().equals(getChessColor())){
                    queenDest.add(new ChessboardPoint(row-i,col+i));
                    break;
                }else break;
            }else break;
        }
        for (int i = 1;i<=7;i++) {
            if (row-i>=0 && col-i>=0) {
                if (getChessBoard()[row - i][col - i].getName() == '_') {
                    queenDest.add(new ChessboardPoint(row - i, col - i));
                } else if (getChessBoard()[row - i][col - i].getName() != '_' && !getChessBoard()[row - i][col - i].getChessColor().equals(getChessColor())) {
                    queenDest.add(new ChessboardPoint(row - i, col - i));
                    break;
                }else break;
            }else break;
        }
    }
}

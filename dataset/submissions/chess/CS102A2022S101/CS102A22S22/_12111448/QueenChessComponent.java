import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
     QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    QueenChessComponent() {
    }
    //!!!!!!!!!!!!!!!!!!!!!!!
    // NOT consider whether the queen goes across another chess
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int x= getSource().getX();
        int y= getSource().getY();
        for (int i = 1; x+i < 8; i++) {
            int row=x+i;
            if (chessComponents[row][y] instanceof EmptySlotComponent){
                ans.add(new ChessboardPoint(row,y));
            }
            else if (!chessComponents[row][y].getChessColor().equals(this.getChessColor())){
                ans.add(new ChessboardPoint(row,y));
                break;
            }
            else {
                break;
            }
        }
        for (int i = 1; x-i >= 0; i++) {
            int row=x-i;
            if (chessComponents[row][y] instanceof EmptySlotComponent){
                ans.add(new ChessboardPoint(row,y));
            }
            else if (!chessComponents[row][y].getChessColor().equals(this.getChessColor())){
                ans.add(new ChessboardPoint(row,y));
                break;
            }
            else {
                break;
            }
        }
        for (int i = 1; y+i < 8; i++) {
            int column=y+i;
            if (chessComponents[x][column] instanceof EmptySlotComponent){
                ans.add(new ChessboardPoint(x,column));
            }
            else if (!chessComponents[x][column].getChessColor().equals(this.getChessColor())){
                ans.add(new ChessboardPoint(x,column));
                break;
            }
            else {
                break;
            }
        }
        for (int i = 1; y-i >=0 ; i++) {
            int column=y-i;
            if (chessComponents[x][column] instanceof EmptySlotComponent){
                ans.add(new ChessboardPoint(x,column));
            }
            else if (!chessComponents[x][column].getChessColor().equals(this.getChessColor())){
                ans.add(new ChessboardPoint(x,column));
                break;
            }
            else {
                break;
            }
        }
        for (int i =1; x+i < 8; i++) {
            int row=x+i;
            int column=y+i;
            if (column<=7){
                if (chessComponents[row][column] instanceof EmptySlotComponent){
                    ans.add(new ChessboardPoint(row,column));
                }
                else if (!chessComponents[row][column].getChessColor().equals(this.getChessColor())){
                    ans.add(new ChessboardPoint(row,column));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }

            //at the beginning, the chess must be in the board.
            // but as i++, maybe it will leave the chess board
            // so once the chess has left, it will not go back
        }
        for (int i =1; x-i >= 0; i++) {
            int row=x-i;
            int column=y-i;
            if (column>=0 ){
                if (chessComponents[row][column] instanceof EmptySlotComponent){
                    ans.add(new ChessboardPoint(row,column));
                }
                else if (!chessComponents[row][column].getChessColor().equals(this.getChessColor())){
                    ans.add(new ChessboardPoint(row,column));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }

        }
        for (int i =1; x+i < 8; i++) {
            int row=x+i;
            int column=y-i;
            if (column>=0 && column<=7){
                if (chessComponents[row][column] instanceof EmptySlotComponent){
                    ans.add(new ChessboardPoint(row,column));
                }
                else if (!chessComponents[row][column].getChessColor().equals(this.getChessColor())){
                    ans.add(new ChessboardPoint(row,column));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        for (int i =1; x-i >= 0; i++) {
            int row=x-i;
            int column=y+i;
            if (column<=7){
                if (chessComponents[row][column] instanceof EmptySlotComponent){
                    ans.add(new ChessboardPoint(row,column));
                }
                else if (!chessComponents[row][column].getChessColor().equals(this.getChessColor())){
                    ans.add(new ChessboardPoint(row,column));
                    break;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }

        }
        return ans;
    }
}
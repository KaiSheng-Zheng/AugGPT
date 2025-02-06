import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    RookChessComponent() {
    }

    //!!!!!!!!!!!!!!!!!!1
    //NOT consider whether this chess cross others
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
        return ans;
    }
}
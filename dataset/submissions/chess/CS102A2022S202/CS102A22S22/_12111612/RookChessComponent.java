import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        for (int i=getSource().getX()-1;i>=0 && getSource().getX()>=1;i--){
            ChessboardPoint temp = new ChessboardPoint(i, getSource().getY());
            if (chessComponents[temp.getX()][temp.getY()].getChessColor()==ChessColor.NONE){
                result.add(temp);
            }
            else {
                if (chessComponents[temp.getX()][temp.getY()].getChessColor()!=getChessColor()){
                    result.add(temp);
                }
                break;
            }
        }
        for (int i=getSource().getX()+1;i<8 && getSource().getX()<7;i++){
            ChessboardPoint temp = new ChessboardPoint(i, getSource().getY());
            if (chessComponents[temp.getX()][temp.getY()].getChessColor()==ChessColor.NONE){
                result.add(temp);
            }
            else {
                if (chessComponents[temp.getX()][temp.getY()].getChessColor()!=getChessColor()){
                    result.add(temp);
                }
                break;
            }
        }

        for (int i=getSource().getY()-1;i>=0 && getSource().getY()>=1;i--){
            ChessboardPoint temp = new ChessboardPoint(getSource().getX(), i);
            if (chessComponents[temp.getX()][temp.getY()].getChessColor()==ChessColor.NONE){
                result.add(temp);
            }
            else {
                if (chessComponents[temp.getX()][temp.getY()].getChessColor()!=getChessColor()){
                    result.add(temp);
                }
                break;
            }
        }
        for (int i=getSource().getY()+1;i<8 && getSource().getY()<7;i++){
            ChessboardPoint temp = new ChessboardPoint(getSource().getX(), i);
            if (chessComponents[temp.getX()][temp.getY()].getChessColor()==ChessColor.NONE){
                result.add(temp);
            }
            else {
                if (chessComponents[temp.getX()][temp.getY()].getChessColor()!=getChessColor()){
                    result.add(temp);
                }
                break;
            }
        }

        return result;

    }
}

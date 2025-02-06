import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        for (int i=getSource().getX()-1;i>=0 && getSource().getX()>=1;i--){
            if ((getSource().getX()+getSource().getY())-i>=0 && (getSource().getX()+getSource().getY())-i<8){
                ChessboardPoint temp = new ChessboardPoint(i,(getSource().getX()+getSource().getY())-i);
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
        }
        for (int i=getSource().getX()+1;i<8 && getSource().getX()<7;i++){
            if ((getSource().getX()+getSource().getY())-i>=0 && (getSource().getX()+getSource().getY())-i<8){
                ChessboardPoint temp = new ChessboardPoint(i,(getSource().getX()+getSource().getY())-i);
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
        }

        for (int i=getSource().getX()-1;i>=0 && getSource().getX()>=1;i--){
            if ((getSource().getY()-getSource().getX())+i>=0 && (getSource().getY()-getSource().getX())+i<8){
                ChessboardPoint temp = new ChessboardPoint(i,(getSource().getY()-getSource().getX())+i);
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
        }
        for (int i=getSource().getX()+1;i<8 && getSource().getX()<7;i++){
            if ((getSource().getY()-getSource().getX())+i>=0 && (getSource().getY()-getSource().getX())+i<8){
                ChessboardPoint temp = new ChessboardPoint(i,(getSource().getY()-getSource().getX())+i);
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
        }
        return result;
    }
}

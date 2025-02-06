import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        for(int i = 1;getSource().getX()+i<8;i++){
            if(ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()].getChessColor()==ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()+i), getSource().getY()));
            }
            else if(ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()].getChessColor()!=getChessColor()
            &&ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()].getChessColor()!=ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()+i), getSource().getY()));
                break;
            }
            else{
                break;
            }
        }
        for(int i = 1;getSource().getX()-i>=0;i++){
            if(ChessComponent.chessComponents[getSource().getX()-i][getSource().getY()].getChessColor()==ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()-i), getSource().getY()));
            }
            else if(ChessComponent.chessComponents[getSource().getX()-i][getSource().getY()].getChessColor()!=getChessColor()
            &&ChessComponent.chessComponents[getSource().getX()-i][getSource().getY()].getChessColor()!=ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()-i), getSource().getY()));
                break;
            }
            else{
                break;
            }
        }
        for(int i = 1;getSource().getY()+i<8;i++){
            if(ChessComponent.chessComponents[getSource().getX()][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()), getSource().getY()+i));
            }
            else if(ChessComponent.chessComponents[getSource().getX()][getSource().getY()+i].getChessColor()!=getChessColor()
            &&ChessComponent.chessComponents[getSource().getX()][getSource().getY()+i].getChessColor()!=ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()), getSource().getY()+i));
                break;
            }
            else{
                break;
            }
        }
        for(int i = 1;getSource().getX()-i>=0;i++){
            if(ChessComponent.chessComponents[getSource().getX()][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()), getSource().getY()-i));
            }
            else if(ChessComponent.chessComponents[getSource().getX()][getSource().getY()-i].getChessColor()!=getChessColor()
            &&ChessComponent.chessComponents[getSource().getX()][getSource().getY()-i].getChessColor()!=ChessColor.NONE){
                points.add(new ChessboardPoint((getSource().getX()), getSource().getY()-i));
                break;
            }
            else{
                break;
            }
        }
        return points;
    }
}

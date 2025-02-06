import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = 1; i < Math.min(8-getSource().getX(),8- getSource().getY()); i++) {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()+i][getSource().getY()+i].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i));
            if(ConcreteChessGame.getChessBoard()[getSource().getX()+i][getSource().getY()+i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = 1; i <= Math.min(getSource().getX(), getSource().getY()); i++) {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()-i][getSource().getY()-i].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i));
            if(ConcreteChessGame.getChessBoard()[getSource().getX()-i][getSource().getY()-i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = 1; i <= Math.min(7-getSource().getX(), getSource().getY()); i++) {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()+i][getSource().getY()-i].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i));
            if(ConcreteChessGame.getChessBoard()[getSource().getX()+i][getSource().getY()-i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = 1; i <= Math.min(getSource().getX(), 7-getSource().getY()); i++) {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()-i][getSource().getY()+i].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i));
            if(ConcreteChessGame.getChessBoard()[getSource().getX()-i][getSource().getY()+i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }

        return arrayList;
    }
}

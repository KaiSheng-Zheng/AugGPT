import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = getSource().getX()+1; i < 8; i++) {
            if(ConcreteChessGame.getChessBoard()[i][getSource().getY()].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(i, getSource().getY()));
            if(ConcreteChessGame.getChessBoard()[i][getSource().getY()].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = getSource().getX()-1; i >= 0; i--) {
            if(ConcreteChessGame.getChessBoard()[i][getSource().getY()].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(i, getSource().getY()));
            if(ConcreteChessGame.getChessBoard()[i][getSource().getY()].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = getSource().getY()+1; i < 8; i++) {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()][i].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(getSource().getX(), i));
            if(ConcreteChessGame.getChessBoard()[getSource().getX()][i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = getSource().getY()-1; i >= 0; i--) {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()][i].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                break;
            }
            arrayList.add(new ChessboardPoint(getSource().getX(), i));
            if(ConcreteChessGame.getChessBoard()[getSource().getX()][i].getChessColor()!=ChessColor.NONE){
                break;
            }

        }
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

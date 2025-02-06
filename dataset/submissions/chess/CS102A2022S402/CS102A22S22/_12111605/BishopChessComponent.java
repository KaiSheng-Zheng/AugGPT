import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint) {
        this.setName(name);
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> List = new ArrayList<>();
        for (int i = 1; i+getSource().getX() <8&&i+getSource().getY()<8 ; i++) {
            if (getChessComponents()[i+getSource().getX()][i+getSource().getY()].getChessColor()!=getChessColor()) {
                int box=0;
                for (int j = 1; j < i; j++) {
                    if (getChessComponents()[j + getSource().getX()][j + getSource().getY()].getChessColor() != ChessColor.NONE) {
                        box++;
                    }
                }
                if (box==0){
                    List.add(new ChessboardPoint(i+getSource().getX(),i+getSource().getY()));
                }
            }
        }


        for (int i = 1; -i+getSource().getX()>=0 && i+getSource().getY()<8 ; i++) {
            if (getChessComponents()[-i+getSource().getX()][i+getSource().getY()].getChessColor()!=getChessColor()) {
                int box=0;
                for (int j = 1; j < i; j++) {
                    if (getChessComponents()[-j + getSource().getX()][j + getSource().getY()].getChessColor() != ChessColor.NONE) {
                        box++;
                    }
                }
                if (box==0){
                    List.add(new ChessboardPoint(-i+getSource().getX(),i+getSource().getY()));
                }
            }
        }

        for (int i = 1; i+getSource().getX() <8&& -i+getSource().getY()>=0 ; i++) {
            if (getChessComponents()[i+getSource().getX()][ -i+getSource().getY()].getChessColor()!=getChessColor()) {
                int box=0;
                for (int j = 1; j < i; j++) {
                    if (getChessComponents()[j + getSource().getX()][-j + getSource().getY()].getChessColor() != ChessColor.NONE) {
                        box++;
                    }
                }
                if (box==0){
                    List.add(new ChessboardPoint(i+getSource().getX(),-i+getSource().getY()));
                }
            }
        }

        for (int i = 1; -i+getSource().getX() >=0&& -i+getSource().getY()>=0 ; i++) {
            if (getChessComponents()[-i+getSource().getX()][-i+getSource().getY()].getChessColor()!=getChessColor()) {
                int box=0;
                for (int j = 1; j < i; j++) {
                    if (getChessComponents()[-j + getSource().getX()][-j + getSource().getY()].getChessColor() != ChessColor.NONE) {
                        box++;
                    }
                }
                if (box==0){
                    List.add(new ChessboardPoint(-i+getSource().getX(),-i+getSource().getY()));
                }
            }
        }
        return List;
    }


}

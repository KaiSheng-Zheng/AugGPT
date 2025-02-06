import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent( ChessboardPoint source, ChessColor chessColor, char name) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != getSource().getX() && j != getSource().getY()){
                    if (j - getSource().getY() == getSource().getX() - i && getChessComponents()[i][j].getChessColor() != getChessColor()){
                        if (j - getSource().getY() == 1){
                            arrayList.add(new ChessboardPoint(i,j));
                        }else {
                            for (int k = 1; k < 9 && getSource().getY() + k < j; k++) {
                                if (getChessComponents()[i + k][j - k].getChessColor() != ChessColor.NONE){
                                    break;
                                }
                                if (getSource().getY() + k == j -1){
                                    arrayList.add(new ChessboardPoint(i,j));
                                }
                            }
                        }
                    }
                    if (getSource().getY() - j == getSource().getX() - i && getChessComponents()[i][j].getChessColor() != getChessColor()){
                        if (getSource().getX() - i == 1){
                            arrayList.add(new ChessboardPoint(i,j));
                        }else {
                            for (int k = 1; k < 9 && i + k < getSource().getX(); k++) {
                                if (getChessComponents()[i + k][j + k].getChessColor() != ChessColor.NONE){
                                    break;
                                }
                                if (i + k == getSource().getX() - 1){
                                    arrayList.add(new ChessboardPoint(i,j));
                                }
                            }
                        }
                    }
                    if (getSource().getY() - j == i - getSource().getX() && getChessComponents()[i][j].getChessColor() != getChessColor()){
                        if (getSource().getY() - j == 1){
                            arrayList.add(new ChessboardPoint(i,j));
                        }else {
                            for (int k = 1; k < 9 && j + k < getSource().getY(); k++) {
                                if (getChessComponents()[i - k][j + k].getChessColor() != ChessColor.NONE){
                                    break;
                                }
                                if (j + k == getSource().getY() - 1){
                                    arrayList.add(new ChessboardPoint(i,j));
                                }
                            }
                        }
                    }
                    if (i - getSource().getX() == j - getSource().getY() && getChessComponents()[i][j].getChessColor() != getChessColor()){
                        if (i - getSource().getX() == 1){
                            arrayList.add(new ChessboardPoint(i,j));
                        }else {
                            for (int k = 1;getSource().getX() + k < i; k++) {
                                if (getChessComponents()[getSource().getX() + k][getSource().getY() + k].getChessColor() != ChessColor.NONE){
                                    break;
                                }
                                if (getSource().getX() + k == i - 1){
                                    arrayList.add(new ChessboardPoint(i,j));
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}

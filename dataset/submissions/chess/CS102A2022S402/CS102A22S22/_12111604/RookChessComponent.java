import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent( ChessboardPoint source, ChessColor chessColor, char name) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getSource().getX() == i && getSource().getY() != j && getChessComponents()[i][j].getChessColor() != getChessColor()){
                    int row = getSource().getX();
                    for (int col = Math.min(getSource().getY(),j)+1; col < Math.max(getSource().getY(), j); col++) {
                        if (getChessComponents()[row][col].getChessColor() != ChessColor.NONE){
                            break;
                        }
                        if (col == Math.max(getSource().getY(), j) - 1){
                            arrayList.add(new ChessboardPoint(i,j));
                        }
                    }
                    if (Math.abs(getSource().getY() - j) == 1 && getChessComponents()[i][j].getChessColor() != getChessColor()){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                }
                if (getSource().getY() == j && getSource().getX() != i && getChessComponents()[i][j].getChessColor() != getChessColor()){
                    int col = getSource().getY();
                    for (int row = Math.min(getSource().getX(), i) + 1 ; row < Math.max(getSource().getX(), i); row++ ){
                        if (getChessComponents()[row][col].getChessColor() != ChessColor.NONE){
                            break;
                        }
                        if (row == Math.max(getSource().getX(),i) - 1){
                            arrayList.add(new ChessboardPoint(i,j));
                        }
                    }
                    if (Math.abs(getSource().getX() - i) == 1 && getChessComponents()[i][j].getChessColor() != getChessColor()){
                        arrayList.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return arrayList;

    }
}

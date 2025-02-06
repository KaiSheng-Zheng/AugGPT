import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x, int y, ChessColor chessColor, char name) {
        this.setSource(x, y);
        this.setChessColor(chessColor);
        this.setName(name);
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        this.setChessboard(chessComponents); // construct a chessComponents of 8*8
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessboardPoint source = new ChessboardPoint(x, y);
        List<ChessboardPoint> coordinates = new ArrayList<>();
        // diagonal 13
        boolean flag = true;
        for (int i = -1; i > -8; i--) {
            if (source.offset(i, i) != null){
                if (this.getChessboard()[x + i][y + i].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(i, i));
                } else if (this.getChessboard()[x + i][y + i].getChessColor() != this.getChessColor()){
                    coordinates.add(source.offset(i, i));
                    flag = false;
                } else {
                    flag = false;
                }
            }
            if (!flag){
                break;
            }
        }
        flag = true;
        for (int i = 1; i < 8; i++) {
            if (source.offset(i, i) != null){
                if (this.getChessboard()[x + i][y + i].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(i, i));
                } else if (this.getChessboard()[x + i][y + i].getChessColor() != this.getChessColor()){
                    coordinates.add(source.offset(i, i));
                    flag = false;
                } else {
                    flag = false;
                }
            }
            if (!flag){
                break;
            }
        }
        // diagonal 24
        flag = true;
        for (int i = -1; i > -8; i--) {
            if (source.offset(-i, i) != null){
                if (this.getChessboard()[x - i][y + i].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(-i, i));
                } else if (this.getChessboard()[x - i][y + i].getChessColor() != this.getChessColor()){
                    coordinates.add(source.offset(-i, i));
                    flag = false;
                } else {
                    flag = false;
                }
            }
            if (!flag){
                break;
            }
        }
        flag = true;
        for (int i = 1; i < 8; i++) {
            if (source.offset(-i, i) != null){
                if (this.getChessboard()[x - i][y + i].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(-i, i));
                } else if (this.getChessboard()[x - i][y + i].getChessColor() != this.getChessColor()){
                    coordinates.add(source.offset(-i, i));
                    flag = false;
                } else {
                    flag = false;
                }
            }
            if (!flag){
                break;
            }
        }
        return coordinates;
    }
}

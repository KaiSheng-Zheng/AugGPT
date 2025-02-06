import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, ChessColor chessColor, char name) {
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

        if (source.offset(1,2) != null){
            if (this.getChessboard()[x + 1][y + 2].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(1,2));
            }
        }
        if (source.offset(2,1) != null){
            if (this.getChessboard()[x + 2][y + 1].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(2,1));
            }
        }
        if (source.offset(2,-1) != null){
            if (this.getChessboard()[x + 2][y - 1].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(2,-1));
            }
        }
        if (source.offset(1,-2) != null){
            if (this.getChessboard()[x + 1][y - 2].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(1,-2));
            }
        }
        if (source.offset(-1,-2) != null){
            if (this.getChessboard()[x - 1][y - 2].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(-1,-2));
            }
        }
        if (source.offset(-2,-1) != null){
            if (this.getChessboard()[x - 2][y - 1].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(-2,-1));
            }
        }
        if (source.offset(-2,1) != null){
            if (this.getChessboard()[x - 2][y + 1].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(-2,1));
            }
        }
        if (source.offset(-1,2) != null){
            if (this.getChessboard()[x - 1][y + 2].getChessColor() != this.getChessColor()){
                coordinates.add(source.offset(-1,2));
            }
        }
        return coordinates; // clockwise
    }
}

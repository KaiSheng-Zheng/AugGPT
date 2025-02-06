import java.util.ArrayList;
import java.util.List;


public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name, ChessColor chessColor, ChessboardPoint chessboardPoint) {
        this.setName(name);
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> List = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(i - getSource().getX()) == 1 && Math.abs(j - getSource().getY()) == 2 && getChessComponents()[i][j].getChessColor()!=getChessColor())
                ||(Math.abs(i - getSource().getX()) == 2 && Math.abs(j - getSource().getY()) == 1&&getChessComponents()[i][j].getChessColor()!=getChessColor())){
                    List.add(new ChessboardPoint(i,j));
                }
            }
        }
        return List;
    }


}

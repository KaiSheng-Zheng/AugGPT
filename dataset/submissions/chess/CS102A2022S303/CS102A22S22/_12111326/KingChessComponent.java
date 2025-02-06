import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (this.getSource().getX() + i > 7 || this.getSource().getX() + i < 0 || this.getSource().getY() + j < 0 || this.getSource().getY() + j > 7) {
                    continue;
                }
                if (this.getChessboard()[this.getSource().getX() + i][this.getSource().getY() + j].getChessColor().equals(ChessColor.NONE)) {
                    move.add(this.getSource().offset(i, j));
                } else if (!this.getChessboard()[this.getSource().getX() + i][this.getSource().getY() + j].getChessColor().equals(this.getChessColor())) {
                    move.add(this.getSource().offset(i, j));
                }
            }
        }

        return move;
    }

    public KingChessComponent() {
    }


}

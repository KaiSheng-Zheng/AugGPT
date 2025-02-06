import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.pow((Math.abs(this.getSource().getX() - i)), 2) + Math.pow((Math.abs(this.getSource().getY() - j)), 2) == 5) {
                    if (this.getChessColor() == ChessColor.WHITE) {
                        if (this.getChessboard().get(i).charAt(j) >= 65 && this.getChessboard().get(i).charAt(j) <= 90||this.getChessboard().get(i).charAt(j)==95)
                            chessboardPoints.add(new ChessboardPoint(i, j));
                    } else {
                        if (this.getChessboard().get(i).charAt(j) >= 97 && this.getChessboard().get(i).charAt(j) <= 122||this.getChessboard().get(i).charAt(j)==95){
                            chessboardPoints.add(new ChessboardPoint(i, j));
                    }
                    }
                }
            }
        }
        return chessboardPoints;
    }

    @Override
    public String toString() {
        return getChessColor() == ChessColor.WHITE ? "n" : "N";
    }

    @Override
    public void giveValueTo(ChessComponent target) {
        target = new KnightChessComponent();
        target.setChessColor(this.getChessColor());
        target.setSource(new ChessboardPoint(this.getSource().getX(), this.getSource().getY()));
    }
}

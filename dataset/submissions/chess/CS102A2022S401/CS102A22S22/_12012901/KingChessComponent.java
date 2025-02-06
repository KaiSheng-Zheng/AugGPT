import java.util.*;

public class KingChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public KingChessComponent(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        ArrayList<ChessComponent> chessComponents1 = new ArrayList<ChessComponent>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents1.add(chessComponents[i][j]);
            }
        }
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        for (int i = 0; i < 8; i++) {
            int x = this.getSource().getX()+dx[i];
            int y = this.getSource().getY()+dy[i];
            if ((0 <= x) && (x <= 7) && (0 <= y) && (y <= 7)) {
                for (ChessComponent chessComponent : chessComponents1) {
                    if ((chessComponent.getSource().getX() == x) && (chessComponent.getSource().getY() == y)) {
                        if (chessComponent.getChessColor() != this.getChessColor()) {
                            out.add(new ChessboardPoint(x, y));
                        }
                        break;
                    }
                }
            }
        }
        Collections.sort(out);
        return out;
    }

}

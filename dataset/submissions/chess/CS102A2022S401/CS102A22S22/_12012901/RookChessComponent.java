import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RookChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public RookChessComponent(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> out = new ArrayList<ChessboardPoint>();
        ArrayList<ChessComponent> chessComponents1 = new ArrayList<ChessComponent>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents1.add(chessComponents[i][j]);
            }
        }
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int x0 = getSource().getX();
        int y0 = getSource().getY();

        for (int i = 0; i < 4; i++){
            int x = x0;
            int y = y0;
            while (true){
                x += dx[i];
                y += dy[i];
                int m = 0;
                if ((0 <= x) && (x <= 7) && (0 <= y) && (y <= 7)) {
                    for (ChessComponent chessComponent : chessComponents1) {
                        if ((chessComponent.getSource().getX() == x) && (chessComponent.getSource().getY() == y)) {
                            if ((chessComponent.getChessColor() != this.getChessColor()) && (chessComponent.getChessColor()==ChessColor.NONE)) {
                                out.add(new ChessboardPoint(x, y));

                            }else if((chessComponent.getChessColor() != this.getChessColor()) && (chessComponent.getChessColor()!=ChessColor.NONE)){
                                out.add(new ChessboardPoint(x, y));
                                m = 1;
                            }else if(chessComponent.getChessColor() == this.getChessColor()){
                                m = 1;
                            }
                            break;
                        }
                    }
                }else{
                    break;
                }

                if (m==1) {
                    break;
                }
            }

        }
        Collections.sort(out);
        return out;
    }

}


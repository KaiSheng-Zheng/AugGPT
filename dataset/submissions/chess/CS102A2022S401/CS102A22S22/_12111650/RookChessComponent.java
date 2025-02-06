import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint point, ChessColor color, char name) {
        super(point, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        ChessboardPoint rook = getSource();
        int x = rook.getX();
        int y = rook.getY();
        ChessColor color = chessComponents[x][y].getChessColor();
        for (int i = x + 1; i < 8; i++) {
            if(chessComponents[i][y].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(i,y));
            }
            else {
                if(chessComponents[i][y].getChessColor() != color){
                    ans.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if(chessComponents[i][y].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(i,y));
            }
            else {
                if(chessComponents[i][y].getChessColor() != color){
                    ans.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if(chessComponents[x][i].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(x,i));
            }
            else {
                if(chessComponents[x][i].getChessColor() != color){
                    ans.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if(chessComponents[x][i].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(x,i));
            }
            else {
                if(chessComponents[x][i].getChessColor() != color){
                    ans.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        return ans;
    }
}

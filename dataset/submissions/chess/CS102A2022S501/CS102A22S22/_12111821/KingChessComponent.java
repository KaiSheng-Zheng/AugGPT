import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(int x, int y, ChessColor color, char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int x = super.getSource().getX(), y = super.getSource().getY();
        ChessColor cc = super.getChessColor();
        int xs, ys;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(i == j && i == 0) continue;
                xs = x + i;
                ys = y + j;
                if(validate(xs, ys) == 1){
                    if(game[xs][ys].getChessColor().equals(cc)) continue;
                    ans.add(game[xs][ys].getSource());
                }
            }
        }
        return ans;
    }
}

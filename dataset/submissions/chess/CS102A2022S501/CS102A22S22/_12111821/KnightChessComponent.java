import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, ChessColor color, char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int x = super.getSource().getX(), y = super.getSource().getY();
        ChessColor cc = super.getChessColor();
        int xs, ys;
        int[][] direction = {{2,1}, {2,-1}, {-2, 1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        for(int i = 0; i < 8; i++){
            int[] step = direction[i];
            xs = x + step[0];
            ys = y + step[1];
            if(validate(xs, ys) == 1){
                if(game[xs][ys].getChessColor().equals(cc)) continue;
                ans.add(game[xs][ys].getSource());
            }
        }
        return ans;
    }
}

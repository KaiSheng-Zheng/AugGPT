import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x, int y, ChessColor color, char name){
        super(x, y, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int x = super.getSource().getX(), y = super.getSource().getY();
        ChessColor cc = super.getChessColor();
        int xs, ys;
        int[][] direction = {{1,1}, {0,1}, {-1, 1}, {1,0},{-1,0}, {1,-1},{0,-1},{-1,-1}};
        for(int i = 0; i < 8; i++){
            int[] step = direction[i];
            for(int j = 1; j < 8; j++){
                xs = x + step[0]*j;
                ys = y + step[1]*j;
                if(validate(xs,ys) == 1){
                    if(game[xs][ys].name != '_') {
                        if(!game[xs][ys].getChessColor().equals(cc))
                            ans.add(game[xs][ys].getSource());
                        break;
                    }
                    ans.add(game[xs][ys].getSource());
                }
                else break;
            }
        }
        return ans;
    }
}

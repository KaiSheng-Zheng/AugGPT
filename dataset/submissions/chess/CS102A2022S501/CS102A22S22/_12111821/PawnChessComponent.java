import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, ChessColor color, char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int x = super.getSource().getX(), y = super.getSource().getY();
        ChessColor cc = super.getChessColor();
        int flag = 0;
        int xs, ys = y;
        if (cc.equals(ChessColor.BLACK))
            flag = 1;
        else if(cc.equals(ChessColor.WHITE))
            flag = -1;
        xs = x + flag;
        if(validate(xs,ys) == 1) {
            if (game[xs][ys].name == '_') {
                ans.add(game[xs][ys].getSource());
            }
        }
        if((x == 1 && cc.equals(ChessColor.BLACK)) || (x == 6 && cc.equals(ChessColor.WHITE))){
            xs = x + 2*flag;
            if(game[xs-flag][ys].name == '_' && game[xs][ys].name == '_'){
                ans.add(game[xs][ys].getSource());
            }
        }
        xs = x + flag;
        ys = y + 1;
        if(validate(xs,ys) == 1){
            if(!game[xs][ys].getChessColor().equals(cc) && !game[xs][ys].getChessColor().equals(ChessColor.NONE))
                ans.add(game[xs][ys].getSource());
        }
        ys = y - 1;
        if(validate(xs,ys) == 1){
            if(!game[xs][ys].getChessColor().equals(cc) && !game[xs][ys].getChessColor().equals(ChessColor.NONE))
                ans.add(game[xs][ys].getSource());
        }
        return ans;
    }
}

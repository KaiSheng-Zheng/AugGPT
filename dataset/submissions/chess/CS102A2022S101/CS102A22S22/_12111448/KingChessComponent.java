
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    KingChessComponent() {
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!
    // NOT consider whether there has another king in these 8 blocks
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y =this.getSource().getY();
        List<ChessboardPoint> ans = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int row=x+i;
                int column=y+j;
                if (i!=0 || j!=0){
                    if (row>=0 && row<=7 && column>=0 && column<=7 &&
                            chessComponents[row][column].getChessColor()!=this.getChessColor()){
                        ans.add(new ChessboardPoint(row,column));
                    }
                }
            }
        }
        return ans;
    }

}
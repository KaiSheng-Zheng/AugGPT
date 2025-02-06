import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        for (int x = 0;x<8;x++){
            for (int y = 0;y<8;y++){
                if(Math.abs(this.getSource().getX() - x) <= 1 && Math.abs(this.getSource().getY() - y) <= 1){
                    output.add(new ChessboardPoint(x,y));
                }
            }
        }
        return output;
    }
}

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        for(int x = 0;x<8;x++){
            for(int y = 0;y<8;y++){
                if(Math.abs(x - this.getSource().getX()) * Math.abs(y - this.getSource().getY()) == 2){
                    output.add(new ChessboardPoint(x,y));
                }
            }
        }
        return output;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, char name){
        super();
        setSource(source);
        if(name == 'R'){
            setChessColor(ChessColor.BLACK);
        }
        if(name == 'r'){
            setChessColor(ChessColor.WHITE);
        }
        this.name = name;
    }
    public RookChessComponent(char name){
        super();
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[] dx = new int[]{1,0,-1,0}, dy = new int[]{0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int x = getSource().getX()+dx[i], y = getSource().getY()+dy[i];
            while (0 <= x && x < 8 && 0 <= y && y < 8){
                if(chessboard[x][y].getChessColor().equals(ChessColor.NONE)){
                    canMoveTo.add(new ChessboardPoint(x,y));
                } else if (!chessboard[x][y].getChessColor().equals(this.getChessColor())) {
                    canMoveTo.add(new ChessboardPoint(x, y));
                    break;
                } else {
                    break;
                }
                x = x + dx[i];
                y = y + dy[i];
            }
        }
        Collections.sort(canMoveTo);
        return canMoveTo;
    }

}

import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name,ChessboardPoint point,ChessColor color){
        super.name = name;
        super.setSource(point);
        super.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        
        int X = getSource().getX();
        int Y = getSource().getY();
        ArrayList steps = new ArrayList<>();
        ChessComponent chess = chessboard[X][Y];
        for (int i = 1; i < 8; i++) { 
            if (JudgeContain(steps, chess, X+i, Y)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {  
            if (JudgeContain(steps, chess, X-i, Y)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) { 
            if (JudgeContain(steps, chess, X, Y-i)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {  
            if (JudgeContain(steps, chess, X, Y+i)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {  
            if (JudgeContain(steps, chess, X+i, Y+i)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {  
            if (JudgeContain(steps, chess, X-i, Y+i)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {  
            if (JudgeContain(steps, chess, X-i, Y-i)) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) { 
            if (JudgeContain(steps, chess, X+i, Y-i)) {
                break;
            }

        }
        return steps;
    }

}

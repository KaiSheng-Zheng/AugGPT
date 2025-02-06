import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name,ChessboardPoint point,ChessColor color){
       super.name = name;
        super.setSource(point);
        super.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int X = getSource().getX();
        int Y = getSource().getY();
        List chessBoard = new ArrayList<>();
         ChessComponent chess = chessboard[X][Y];
             int x;int y;
            x= X+2;y = Y+1;
            JudgeContain(chessBoard, chess, x, y);
            x = X+1;y = Y+2;
            JudgeContain(chessBoard, chess, x, y);
            x= X-1;y = Y-2;
            JudgeContain(chessBoard, chess, x, y);
            x= X-2;y = Y-1;
            JudgeContain(chessBoard, chess, x, y);
            x= X-1;y = Y+2;
            JudgeContain(chessBoard, chess, x, y);
            x= X-2;y = Y+1;
            JudgeContain(chessBoard, chess, x, y);
            x= X+1;y = Y-2;
            JudgeContain(chessBoard, chess, x, y);
            x= X+2;y = Y-1;
            JudgeContain(chessBoard, chess, x, y);
        return chessBoard;
    }
}
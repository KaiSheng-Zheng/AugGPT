import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char name,ChessboardPoint point,ChessColor color){
        super.name = name;
        super.setSource(point);
        super.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessComponent chess = chessboard[X][Y];
        ArrayList<ChessboardPoint> chessBoard = new ArrayList<>();
        int x;int y;
           x= X+1;y = Y+1;
            JudgeContain(chessBoard, chess, x, y);
            x = X+1;y = Y;
            JudgeContain(chessBoard, chess, x, y);
            x= X+1;y = Y-1;
            JudgeContain(chessBoard, chess, x, y);
            x= X;y = Y+1;
            JudgeContain(chessBoard, chess, x, y);
            x= X-1;y = Y;
            JudgeContain(chessBoard, chess, x, y);
            x= X;y = Y-1;
            JudgeContain(chessBoard, chess, x, y);
            x= X-1;y = Y+1;
            JudgeContain(chessBoard, chess, x, y);
            x= X-1;y = Y-1;
            JudgeContain(chessBoard, chess, x, y);

        return chessBoard;
    }
}
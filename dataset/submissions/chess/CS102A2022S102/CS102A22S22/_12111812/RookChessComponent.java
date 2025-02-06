import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent chessComponents[][] = ConcreteChessGame.chessBoard;
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessComponent chess = chessComponents[x][y];
        for(int i = 2;i <= 8;i += 2) {
            for (int j = 1; j < 8; j++) {
                int sinAngle = (int) Math.round(Math.sin(i * 0.7854) * 1.3);
                int cosAngle = (int) Math.round(Math.cos(i * 0.7854) * 1.3);
                int targetX = x + j * cosAngle;
                int targetY = y + j * sinAngle;
                if (isValid(targetX) && isValid(targetY)) {
                    if (chessComponents[targetX][targetY].name != '_') {
                        if (chess.isOpposite(chessComponents[targetX][targetY])) {
                            chessboardPoints.add(new ChessboardPoint(targetX, targetY));
                        }
                        break;
                    } else {
                        chessboardPoints.add(new ChessboardPoint(targetX, targetY));
                    }
                } else {
                    break;
                }
            }
        }
        return chessboardPoints;
    }
    public RookChessComponent(int x,int y){
        super(x,y);
    }
    public RookChessComponent(){}
}

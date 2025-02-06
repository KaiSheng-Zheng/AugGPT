import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int timer = 1;
        while (y + timer < 8 && ConcreteChessGame.getChessComponents1()[x][y + timer].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if (ConcreteChessGame.getChessComponents1()[x][y + timer].getChessColor() == ChessColor.NONE) {
                chess.add(new ChessboardPoint(x, y + timer));
                timer++;
            }
             else {
                chess.add(new ChessboardPoint(x, y + timer));
                break;
            }
        }
        timer = 1;
        while (y - timer >= 0 && ConcreteChessGame.getChessComponents1()[x][y - timer].getChessColor() != ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if (ConcreteChessGame.getChessComponents1()[x][y - timer].getChessColor() == ChessColor.NONE) {
                chess.add(new ChessboardPoint(x, y - timer));
                timer++;
            }
            else {
                chess.add(new ChessboardPoint(x, y - timer));
                break;
            }
        }
        timer=1;
        while (x+timer<8&&ConcreteChessGame.getChessComponents1()[x+timer][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if(ConcreteChessGame.getChessComponents1()[x+timer][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x+timer,y));
                timer++;
            }
       else {
            chess.add(new ChessboardPoint(x+timer,y));
            break;
        }
        }
        timer=1;
        while (x-timer>=0&&ConcreteChessGame.getChessComponents1()[x-timer][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if(ConcreteChessGame.getChessComponents1()[x-timer][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x - timer, y));
                timer++;
            }
           else  {
                chess.add(new ChessboardPoint(x - timer, y));
                break;
            }
        }
        return chess;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }
}

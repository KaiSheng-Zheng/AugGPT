import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int timer = 1;
        while (y+timer<8 && ConcreteChessGame.getChessComponents1()[x][y+timer].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if(ConcreteChessGame.getChessComponents1()[x][y+timer].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y+timer));
                timer++;
            }
            else {
                chess.add(new ChessboardPoint(x,y+timer));
                break;
            }
        }
        timer=1;
        while (y-timer>=0 && ConcreteChessGame.getChessComponents1()[x][y-timer].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if(ConcreteChessGame.getChessComponents1()[x][y-timer].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y-timer));
            timer++;
            }
        else {
            chess.add(new ChessboardPoint(x,y-timer));
            break;
        }
        }
        timer=1;
        while (x+timer<8&&ConcreteChessGame.getChessComponents1()[x+timer][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {if(ConcreteChessGame.getChessComponents1()[x+timer][y].getChessColor()==ChessColor.NONE) {
            chess.add(new ChessboardPoint(x+timer,y));
            timer++;
        }
        else {
            chess.add(new ChessboardPoint(x+timer,y));
            break;
        }
        }
        timer=1;
        while (x>=timer && ConcreteChessGame.getChessComponents1()[x-timer][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
            if(ConcreteChessGame.getChessComponents1()[x-timer][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x - timer, y));
                timer++;
            }
            else {
                chess.add(new ChessboardPoint(x - timer, y));
                break;
            }
        }
        x=getSource().getX()+1;
        y=getSource().getY()+1;
        while (x<8&&y<8&&ConcreteChessGame.getChessComponents1()[x][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y));
                x++;
                y++;
            }
            else {
                chess.add(new ChessboardPoint(x,y));
                break;
            }

        }
        x=getSource().getX()-1;
        y=getSource().getY()-1;
        while (x>=0&&y>=0&&ConcreteChessGame.getChessComponents1()[x][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y));
                x--;
                y--;
            }
            else {
                chess.add(new ChessboardPoint(x,y));
                break;
            }

        }

        x=getSource().getX()+1;
        y=getSource().getY()-1;
        while (x<8&&y>=0&&ConcreteChessGame.getChessComponents1()[x][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y));
                x++;
                y--;}
            else {
                chess.add(new ChessboardPoint(x,y));
                break;
            }

        }

        x=getSource().getX()-1;
        y=getSource().getY()+1;
        while (x>=0&&y<8&&ConcreteChessGame.getChessComponents1()[x][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE)
            {  chess.add(new ChessboardPoint(x,y));
                x--;
                y++;}
            else {
                chess.add(new ChessboardPoint(x,y));
                break;
            }

        }

        return chess;
    }
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
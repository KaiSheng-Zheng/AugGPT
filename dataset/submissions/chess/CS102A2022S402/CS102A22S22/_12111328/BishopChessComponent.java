import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        int x=getSource().getX()+1;
        int y=getSource().getY()+1;
        while (x<8 && y<8&& ConcreteChessGame.getChessComponents1()[x][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y));
                x++;
                y++;}
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
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y));
                x--;
                y++;}
            else {
                chess.add(new ChessboardPoint(x,y));
                break;
            }
        }
        x=getSource().getX()-1;
        y=getSource().getY()-1;
        while (x>=0 && y>=0&&ConcreteChessGame.getChessComponents1()[x][y].getChessColor()!=ConcreteChessGame.getChessComponents1()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getChessComponents1()[x][y].getChessColor()==ChessColor.NONE) {
                chess.add(new ChessboardPoint(x,y));
                x--;
                y--;}
            else {
                chess.add(new ChessboardPoint(x,y));
                break;
            }
        }

        return chess;
    }
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
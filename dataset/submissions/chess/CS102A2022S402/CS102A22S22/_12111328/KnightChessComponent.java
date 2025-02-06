import java.util.ArrayList;
import java.util.List;


public class KnightChessComponent  extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if(x>=-1&&x<7){
            if(y>=-2&&y<6&&ConcreteChessGame.getChessComponents1()[x+1][y+2].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x+1,y+2));
            }
            if(y>=2&&y<10&&ConcreteChessGame.getChessComponents1()[x+1][y-2].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()){
                chess.add(new ChessboardPoint(x+1,y-2));
            }
        }
        if(x>=1&&x<9){
            if(y>=-2&&y<6&&ConcreteChessGame.getChessComponents1()[x-1][y+2].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()){
            chess.add(new ChessboardPoint(x-1,y+2));
            }
            if(y>=2&&y<10&&ConcreteChessGame.getChessComponents1()[x-1][y-2].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor())
            {
                chess.add(new ChessboardPoint(x-1,y-2));
            }
        }
        if(x>=-2&&x<6){
            if(y>=-1&&y<7&&ConcreteChessGame.getChessComponents1()[x+2][y+1].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x+2,y+1));
            }
            if(y>=1&&y<9&&ConcreteChessGame.getChessComponents1()[x+2][y-1].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x+2,y-1));
            }
        }
        if(x>=2&&x<10){
            if(y>=-1&&y<7&&ConcreteChessGame.getChessComponents1()[x-2][y+1].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x-2,y+1));
            }
            if(y>=1&&y<9&&ConcreteChessGame.getChessComponents1()[x-2][y-1].getChessColor()!=ConcreteChessGame.getChessComponents1()[x][y].getChessColor()) {
                chess.add(new ChessboardPoint(x-2,y-1));
            }
        }
        return chess;
    }
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}

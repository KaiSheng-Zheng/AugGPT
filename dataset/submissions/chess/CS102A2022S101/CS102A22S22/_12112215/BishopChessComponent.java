import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ConcreteChessGame concreteChessGame;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ConcreteChessGame concreteChessGame) {
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name = name;
        this.concreteChessGame=concreteChessGame;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        int x=this.getChessboardPoint().getX();
        int y=this.getChessboardPoint().getY();
        for (int i = 1; i <8 ; i++) {
            if(!isOutOfBound(x-i,y-i)&&
            this.concreteChessGame.getChess(x-i,y-i).getChessColor()==ChessColor.NONE) {
                list.add(new ChessboardPoint(x - i, y - i));
                continue;
            }
            if(!isOutOfBound(x-i,y-i)&&
            this.concreteChessGame.getChess(x-i,y-i).getChessColor()==this.getChessColor()) {
                break;
            }
            if(!isOutOfBound(x-i,y-i) &&
            this.concreteChessGame.getChess(x-i,y-i).getChessColor()!=this.getChessColor()&&
            this.concreteChessGame.getChess(x-i,y-i).getChessColor()!=ChessColor.NONE){
                list.add(new ChessboardPoint(x-i,y-i));
                break;
            }
        }
        for (int i = 1; i <8 ; i++) {
            if(!isOutOfBound(x+i,y+i)&&
            this.concreteChessGame.getChess(x+i,y+i).getChessColor()==ChessColor.NONE){
                list.add(new ChessboardPoint(x+i,y+i));
                continue;
            }
            if(!isOutOfBound(x+i,y+i)&&
            this.concreteChessGame.getChess(x+i,y+i).getChessColor()==this.getChessColor()) {
                break;
            }
            if(!isOutOfBound(x+i,y+i) &&
            this.concreteChessGame.getChess(x+i,y+i).getChessColor()!=this.getChessColor()&&
            this.concreteChessGame.getChess(x+i,y+i).getChessColor()!=ChessColor.NONE){
                list.add(new ChessboardPoint(x+i,y+i));
                break;
            }
        }
        for (int i = 1; i <8 ; i++) {
            if(!isOutOfBound(x-i,y+i)&&
            this.concreteChessGame.getChess(x-i,y+i).getChessColor()==ChessColor.NONE){
                list.add(new ChessboardPoint(x-i,y+i));
                continue;
            }
            if(!isOutOfBound(x-i,y+i)&&
            this.concreteChessGame.getChess(x-i,y+i).getChessColor()==this.getChessColor()) {
                break;
            }
            if(!isOutOfBound(x-i,y+i)&&
            this.concreteChessGame.getChess(x-i,y+i).getChessColor()!=this.getChessColor()&&
            this.concreteChessGame.getChess(x-i,y+i).getChessColor()!=ChessColor.NONE){
                list.add(new ChessboardPoint(x-i,y+i));
                break;
            }
        }
        for (int i = 1; i <8 ; i++) {
            if(!isOutOfBound(x+i,y-i)&&
            this.concreteChessGame.getChess(x+i,y-i).getChessColor()==ChessColor.NONE) {
                list.add(new ChessboardPoint(x + i, y - i));
                continue;
            }
            if(!isOutOfBound(x+i,y-i)&&
            this.concreteChessGame.getChess(x+i,y-i).getChessColor()==this.getChessColor()) {
                break;
            }
            if(!isOutOfBound(x+i,y-i)&&
            this.concreteChessGame.getChess(x+i,y-i).getChessColor()!=this.getChessColor()&&
            this.concreteChessGame.getChess(x+i,y-i).getChessColor()!=ChessColor.NONE){
                list.add(new ChessboardPoint(x+i,y-i));
                break;
                }
            }
        return list;
    }
}
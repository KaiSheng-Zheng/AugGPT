import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ConcreteChessGame concreteChessGame;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ConcreteChessGame concreteChessGame) {
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
        if(y-1>=0) {
            for (int i = y - 1; i == 0; i--) {
                if (this.concreteChessGame.getChess(x, i).getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x, i));
                } else {
                    if (this.concreteChessGame.getChess(x, i).getChessColor() == this.getChessColor()) {
                        break;
                    }
                    if (this.concreteChessGame.getChess(x, i).getChessColor() != this.getChessColor()) {
                        list.add(new ChessboardPoint(x, i));
                        break;
                    }
                }
            }
        }
        if(y+1<8) {
            for (int i = y + 1; i < 8; i++) {
                if (this.concreteChessGame.getChess(x, i).getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x, i));
                } else {
                    if (this.concreteChessGame.getChess(x, i).getChessColor() == this.getChessColor()) {
                        break;
                    }
                    if (this.concreteChessGame.getChess(x, i).getChessColor() != this.getChessColor()) {
                        list.add(new ChessboardPoint(x, i));
                        break;
                    }
                }
            }
        }
        if(x-1>=0) {
            for (int i = x - 1; i == 0; i--) {
                if (this.concreteChessGame.getChess(i, y).getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(i, y));
                } else {
                    if (this.concreteChessGame.getChess(i, y).getChessColor() == this.getChessColor()) {
                        break;
                    }
                    if (this.concreteChessGame.getChess(i, y).getChessColor() != this.getChessColor()) {
                        list.add(new ChessboardPoint(i, y));
                        break;
                    }
                }
            }
        }
        if(x+1<8) {
            for (int i = this.getChessboardPoint().getX() + 1; i < 8; i++) {
                if (this.concreteChessGame.getChess(i, y).getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(i, y));
                } else {
                    if (this.concreteChessGame.getChess(i, y).getChessColor() == this.getChessColor()) {
                        break;
                    }
                    if (this.concreteChessGame.getChess(i, y).getChessColor() != this.getChessColor()) {
                        list.add(new ChessboardPoint(i, y));
                        break;
                    }
                }
            }
        }
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

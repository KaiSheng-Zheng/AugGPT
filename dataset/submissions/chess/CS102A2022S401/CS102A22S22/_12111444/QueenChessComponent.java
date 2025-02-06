import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public QueenChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        if(getChessColor().equals(ChessColor.BLACK)){
            name = 'Q';
        }else{
            name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int i = -7;
        while(0<=(x+i) && (x+i)<=7 && !ConcreteChessGame.chessComponent[x+i][y].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+i),y));
            i++;
        }
        int j = -7;
        while(0<=(y+j) && (y+j)<=7 && !ConcreteChessGame.chessComponent[x][y+j].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint(x,(y+j)));
            j++;
        }
        int m = -7;
        while(0<=(x+m) && (x+m)<=7 && 0<=(y+m) && (y+m) <=7 && !ConcreteChessGame.chessComponent[x+m][y+m].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+m),(y+m)));
            m++;
        }
        int n = -7;
        while(0<=(x-n) && (x-n)<=7 && 0<=(y+n) && (y+n) <=7 && !ConcreteChessGame.chessComponent[x-n][y+n].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x-n),(y+n)));
            n++;
        }
        return move;
    }
}
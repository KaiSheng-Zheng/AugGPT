

import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public BishopChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        if(getChessColor().equals(ChessColor.BLACK)){
            name = 'B';
        }else{
            name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int i = 0;
        while((x+i)<=7 && (y+i)<=7 && !ConcreteChessGame.chessComponent[x+i][y+i].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+i),(y+i)));
            i++;
        }
        int m = 0;
        while((x-m)>=0 && (y-m)>=0 && !ConcreteChessGame.chessComponent[x-m][y-m].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x-m),(y-m)));
            m++;
        }
        int n = 0;
        while((x-n)>=0 && (y+n)<=7 && !ConcreteChessGame.chessComponent[x-n][y+n].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x-n),(y-n)));
            n++;
        }
        int j = 0;
        while((x+j)<=7 && (y-j)>=0 && !ConcreteChessGame.chessComponent[x+j][y-j].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+j),(y-j)));
            j++;
        }
        return move;
    }
}

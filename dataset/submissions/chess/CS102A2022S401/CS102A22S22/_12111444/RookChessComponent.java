import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public RookChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        if(getChessColor().equals(ChessColor.BLACK)){
            name = 'R';
        }else{
            name = 'r';
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
        return move;
    }
}

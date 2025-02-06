import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public PawnChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        if(getChessColor().equals(ChessColor.BLACK)){
            name = 'P';
        }else{
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if(ConcreteChessGame.chessComponent[x][y].chessColor.equals(ChessColor.BLACK)){
            if((x+1)<=7 && !ConcreteChessGame.chessComponent[x+1][y].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x+1),y));
            }
        }
        if(ConcreteChessGame.chessComponent[x][y].chessColor.equals(ChessColor.WHITE)){
            if((x-1)>=0 && !ConcreteChessGame.chessComponent[x-1][y].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x-1),y));
            }
        }
        return move;
    }
}

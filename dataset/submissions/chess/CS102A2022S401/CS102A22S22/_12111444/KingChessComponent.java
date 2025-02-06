import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public KingChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        if(getChessColor().equals(ChessColor.BLACK)){
            name = 'K';
        }else{
            name = 'k';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        int x = source.getX();
        int y = source.getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if((x+1)<=7 && !ConcreteChessGame.chessComponent[x+1][y].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+1),y));
        }
        if((x-1)>=0 && !ConcreteChessGame.chessComponent[x-1][y].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x-1),y));
        }
        if((y+1)<=7 && !ConcreteChessGame.chessComponent[x][y+1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint(x,(y+1)));
        }
        if((y-1)>=0 && !ConcreteChessGame.chessComponent[x][y-1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint(x,(y-1)));
        }
        if((x+1)<=7 && (y+1)<=7 && !ConcreteChessGame.chessComponent[x+1][y+1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+1),(y+1)));
        }
        if((x-1)>=0 && (y-1)>=0 && !ConcreteChessGame.chessComponent[x-1][y-1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x-1),(y-1)));
        }
        if((x-1)>=0 && (y+1)<=7 && !ConcreteChessGame.chessComponent[x-1][y+1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x-1),(y+1)));
        }
        if((x+1)<=7 && (y-1)>=0 && !ConcreteChessGame.chessComponent[x+1][y-1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
            move.add(new ChessboardPoint((x+1),(y-1)));
        }
        return move;
    }
}
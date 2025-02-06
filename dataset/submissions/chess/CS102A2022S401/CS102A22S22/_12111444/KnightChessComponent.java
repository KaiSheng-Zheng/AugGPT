import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        if(getChessColor().equals(ChessColor.BLACK)){
            name = 'N';
        }else{
            name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
            if((x+1)<=7 && (y-2)>=0 && !ConcreteChessGame.chessComponent[x+1][y-2].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x+1),(y-2)));
            }
            if((x-1)>=0 && (y+2)<=7 && !ConcreteChessGame.chessComponent[x-1][y+2].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x-1),(y+2)));
            }
            if((x+1)<=7 && (y+2)<=7 && !ConcreteChessGame.chessComponent[x+1][y+2].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x+1),(y+2)));
            }
            if((x-1)>=0 && (y-2)>=0 && !ConcreteChessGame.chessComponent[x-1][y-2].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x-1),(y-2)));
            }
            if((x+2)<=7 && (y+1)<=7 && !ConcreteChessGame.chessComponent[x+2][y+1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x+2),(y+1)));
            }
            if((x-2)>=0 && (y-1)>=0 && !ConcreteChessGame.chessComponent[x-2][y-1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x-2),(y-1)));
            }
            if((x+2)<=7 && (y-1)>=0 && !ConcreteChessGame.chessComponent[x+2][y-1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x+2),(y-1)));
            }
            if((x-2)>=0 && (y+1)<=7 && !ConcreteChessGame.chessComponent[x-2][y+1].chessColor.equals(ConcreteChessGame.chessComponent[x][y].chessColor)){
                move.add(new ChessboardPoint((x-2),(y+1)));
            }
        return move;
    }
}
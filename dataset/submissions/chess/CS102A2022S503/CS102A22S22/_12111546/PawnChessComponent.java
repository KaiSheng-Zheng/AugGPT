import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> returnList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(new ChessboardPoint(i, j)))
                    returnList.add(new ChessboardPoint(i, j));
            }
        }

        return returnList;
    }


    public boolean canMoveTo(ChessboardPoint destination) {

    
        if (getChessColor()==ChessColor.WHITE
                && getSource().getX()==6) {
            
            if (destination.getX() ==5 && getSource().getY() == destination.getY()
                    &&game.getChess(destination.getX(), destination.getY()).getChessColor() == ChessColor.NONE)return true;
            
            if (destination.getX() ==4 && getSource().getY() == destination.getY()
                    &&game.getChess(5, destination.getY()).getChessColor() == ChessColor.NONE
                    &&game.getChess(4, destination.getY()).getChessColor() == ChessColor.NONE)return true;
        
            if (destination.getX() ==5
                    && (destination.getY()==getSource().getY()+1 || destination.getY()==getSource().getY()-1)
                    &&game.getChess(5, destination.getY()).getChessColor() == ChessColor.BLACK)return true;
            return false;
        }

        else if (getChessColor()==ChessColor.BLACK
                && getSource().getX()==1){

            
            if (destination.getX() ==2 && getSource().getY() == destination.getY()
                    &&game.getChess(destination.getX(), destination.getY()).getChessColor() == ChessColor.NONE)return true;
            
            if (destination.getX() ==3 && getSource().getY() == destination.getY()
                    &&game.getChess(2, destination.getY()).getChessColor() == ChessColor.NONE
                    &&game.getChess(3, destination.getY()).getChessColor() == ChessColor.NONE)return true;
            
            if (destination.getX() ==2
                    && (destination.getY()==getSource().getY()+1 || destination.getY()==getSource().getY()-1)
                    &&game.getChess(2, destination.getY()).getChessColor() == ChessColor.WHITE)return true;

            return false;
        }

        else if (getChessColor()==ChessColor.WHITE
                && getSource().getX()<6){
            if (((getSource().getX()==(destination.getX()+1) && getSource().getY()==destination.getY())
                    && game.getChess(destination.getX(),destination.getY()).getChessColor()==ChessColor.NONE)

                    ||((getSource().getX()==(destination.getX()+1) && getSource().getY()==(destination.getY()+1))
                    && game.getChess(destination.getX(),destination.getY()).getChessColor()==ChessColor.BLACK)

                    ||((getSource().getX()==(destination.getX()+1) && getSource().getY()==(destination.getY()-1))
                    && game.getChess(destination.getX(),destination.getY()).getChessColor()==ChessColor.BLACK))
                return true;

            return false;
        }


        else if (getChessColor()==ChessColor.BLACK
                && getSource().getX()>1){

            if (((getSource().getX()==(destination.getX()-1) && getSource().getY()==destination.getY())
                    && game.getChess(destination.getX(),destination.getY()).getChessColor()==ChessColor.NONE)

                    ||((getSource().getX()==(destination.getX()-1) && getSource().getY()==(destination.getY()+1))
                    && game.getChess(destination.getX(),destination.getY()).getChessColor()==ChessColor.WHITE)

                    ||((getSource().getX()==(destination.getX()-1) && getSource().getY()==(destination.getY()-1))
                    && game.getChess(destination.getX(),destination.getY()).getChessColor()==ChessColor.WHITE))
                return true;

            return false;
        }else {
            return false;
        }
    }
}

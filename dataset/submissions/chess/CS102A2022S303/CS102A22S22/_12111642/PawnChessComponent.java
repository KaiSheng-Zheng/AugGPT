import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;
    public PawnChessComponent(ChessColor color,int x,int y,ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(x,y));
        setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        for (int i = 0; i<8 ; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint n = new ChessboardPoint(i,j);
                if(canMove(n)) output.add(n);
            }
        }
        return output;
    }
    public boolean canMove(ChessboardPoint destination){
        ChessboardPoint source = super.getSource();
        if(//(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) &&
                chessComponents[destination.getX()][destination.getY()].getChessColor() ==
                chessComponents[source.getX()][source.getY()].getChessColor())
            return false;
        if (source.getY() == destination.getY()) {
            if(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return false;
            if(super.getChessColor() == ChessColor.WHITE){
                if(source.getX() != 6){if(source.getX() != destination.getX() + 1) return false;}
                else{ if(source.getX() != destination.getX() + 1 && source.getX() != destination.getX()+2)
                        return false;
                    else{
                    if(source.getX() == destination.getX()+2){
                        if (!(chessComponents[source.getX()-1][source.getY()] instanceof EmptySlotComponent))
                            return false;}
                }
                }}
            else{
                if(source.getX() != 1){if(source.getX() != destination.getX() -1) return false;}
                else{ if(source.getX() != destination.getX() - 1 && source.getX() != destination.getX()-2)
                    return false;
                    else{
                    if(source.getX() == destination.getX()-2){
                        if (!(chessComponents[destination.getX() - 1][source.getY()] instanceof EmptySlotComponent))
                            return false;}
                }
                }}
        }else if(source.getY() == destination.getY()+1 || source.getY() == destination.getY() -1){
            if(super.getChessColor() == ChessColor.BLACK){
                if(source.getX() != destination.getX() - 1) return false;
                if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)
                    return false;
            }
            else{
                if(source.getX() != destination.getX() + 1) return false;
                if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)
                    return false;
            }
        }

        else return false;

        return true;
    }
    @Override
    public String toString() {
        if(super.getChessColor() == ChessColor.BLACK)
            return String.valueOf('P');
        else return String.valueOf('p');
    }
}

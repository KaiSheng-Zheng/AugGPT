import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public String toString() {
        ChessColor chessColor = super.getChessColor();
        if (chessColor == ChessColor.WHITE) {
            this.name = 'p';
        }
        if (chessColor == ChessColor.BLACK) {
            this.name = 'P';
        }
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMove(new ChessboardPoint(i, j))){
                    canMoveTo.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(ChessboardPoint target){
        List<ChessboardPoint> chessboardPoints =canMoveTo();
        for (ChessboardPoint chessboardPoint:chessboardPoints){
            if (target.getX()==chessboardPoint.getX() && target.getY()==chessboardPoint.getY())return true;
        }
        return false;
    }

    public boolean canMove(ChessboardPoint destination) {
        ChessboardPoint source = super.getSource();
        if(chessComponents[destination.getX()][destination.getY()].getChessColor() == 
                chessComponents[source.getX()][source.getY()].getChessColor()){
            return false;}
        if (source.getY() == destination.getY()) {
            if(chessComponents[destination.getX()][destination.getY()].getChessColor()!=ChessColor.NONE) return false;
            if(super.getChessColor() == ChessColor.WHITE){
                if(source.getX() != 6){
                    if(source.getX() != destination.getX() + 1) {return false;}}
                else{ 
                    if(source.getX() != destination.getX() + 1 && source.getX() != destination.getX()+2){
                        return false;}
                else{
                    if(source.getX() == destination.getX()+2){
                        if (chessComponents[source.getX()-1][source.getY()].getChessColor()!=ChessColor.NONE)
                            return false;}}}}
            else{
                if(source.getX() != 1){
                    if(source.getX() != destination.getX() -1) {return false;}}
                else{ 
                    if(source.getX() != destination.getX() - 1 && source.getX() != destination.getX()-2) {
                        return false;}
                else{
                    if(source.getX() == destination.getX()-2){
                        if (chessComponents[destination.getX() - 1][source.getY()].getChessColor()!=ChessColor.NONE)
                            return false;}}}}}
        else if(source.getY() == destination.getY()+1 || source.getY() == destination.getY() -1){
             if(super.getChessColor() == ChessColor.BLACK){
                if(source.getX() != destination.getX() - 1) return false;
                if (chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE)
                    return false;
            }
            else{
                if(source.getX() != destination.getX() + 1) return false;
                if (chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE)
                    return false;
            }
        }
        else{ 
            return false;}
        return true;
    }
}
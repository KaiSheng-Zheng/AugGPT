import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        boolean notEaten = true;

        //left upper
        while (--x >= 0 && --y >= 0 && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x,y)) && notEaten){
            chessboardPoints.add(new ChessboardPoint(x,y));
            if (this.getChessColor() == ChessColor.BLACK){
                if (Character.isLowerCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            } else {
                if (Character.isUpperCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            }
        }
        x = this.getSource().getX();
        y = this.getSource().getY();
        notEaten = true;

        //right upper
        while (++x < 8 && --y >= 0 && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x,y)) && notEaten){
            chessboardPoints.add(new ChessboardPoint(x,y));
            if (this.getChessColor() == ChessColor.BLACK){
                if (Character.isLowerCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            } else {
                if (Character.isUpperCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            }
        }
        x = this.getSource().getX();
        y = this.getSource().getY();
        notEaten = true;

        // left lower
        while (--x >= 0 && ++y < 8 && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x,y)) && notEaten){
            chessboardPoints.add(new ChessboardPoint(x,y));
            if (this.getChessColor() == ChessColor.BLACK){
                if (Character.isLowerCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            } else {
                if (Character.isUpperCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            }
        }
        x = this.getSource().getX();
        y = this.getSource().getY();
        notEaten = true;

        // right lower
        while (++x < 8 && ++y < 8 && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x,y)) && notEaten){
            chessboardPoints.add(new ChessboardPoint(x,y));
            if (this.getChessColor() == ChessColor.BLACK){
                if (Character.isLowerCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            } else {
                if (Character.isUpperCase(getChessBoard().getChess(x,y).getName())){
                    notEaten = false;
                }
            }
        }

        //sort
        Collections.sort(chessboardPoints);
        return chessboardPoints;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    RookChessComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        if(ConcreteChessGame.chessComponents2[x][y].name == 'r'){
            this.chessColor = ChessColor.WHITE;
        }
        else{
            this.chessColor = ChessColor.BLACK;
        }
        this.source = source;
    }

    public ChessColor getChessColor(){return chessColor;}

    RookChessComponent(ChessColor chessColor, ChessboardPoint source){
        if(chessColor == ChessColor.WHITE){
            name = 'r';
            this.chessColor = chessColor;
        }
        else if(chessColor == ChessColor.BLACK){
            name = 'R';
            this.chessColor = chessColor;
        }
        this.source = source;
    }

    public int getX(){return source.getX();}

    public int getY(){return source.getY();}

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> validPoints = new ArrayList<>();
        ChessComponent[][] newLoc = ConcreteChessGame.chessComponents2;
        int x = source.getX();
        int y = source.getY();
        for(int i = x+1; i<8; i++){
            if(newLoc[i][y] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by rook (down)1." + "(%d,%d)\n", i,y);
            }
            else if(Character.isUpperCase(newLoc[i][y].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by rook (down)2." + "(%d,%d)\n", i,y);
                break;
            }
            else{
                break;
            }
        }
        for(int i = x-1; i>=0; i--){
            if(newLoc[i][y] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by rook (up)1." + "(%d,%d)\n", i,y);
            }
            else if(Character.isUpperCase(newLoc[i][y].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by rook (up)2." + "(%d,%d)\n", i,y);
                break;
            }
            else{
                break;
            }
        }
        for(int i = y+1; i<8; i++){
            if(newLoc[x][i] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by rook (right)1." + "(%d,%d)\n", x,i);
            }
            else if(Character.isUpperCase(newLoc[x][i].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by rook (right)2." + "(%d,%d)\n", x,i);
                break;
            }
            else{
                break;
            }
        }
        for(int i = y-1; i>=0; i--){
            if(newLoc[x][i] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by rook (left)1." + "(%d,%d)\n", i,y);
            }
            else if(Character.isUpperCase(newLoc[x][i].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by rook (left)2." + "(%d,%d)\n", i,y);
                break;
            }
            else{
                break;
            }
        }
        return validPoints;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
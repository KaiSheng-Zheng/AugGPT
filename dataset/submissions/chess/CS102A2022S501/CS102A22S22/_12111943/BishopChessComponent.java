import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    BishopChessComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        if(ConcreteChessGame.chessComponents2[x][y].name == 'b'){
            this.chessColor = ChessColor.WHITE;
        }
        else{
            this.chessColor = ChessColor.BLACK;
        }
        this.source = source;
    }

    public ChessColor getChessColor(){return chessColor;}

    BishopChessComponent(ChessColor chessColor, ChessboardPoint source){
        if(chessColor == ChessColor.WHITE){
            name = 'b';
            this.chessColor = chessColor;
        }
        else if(chessColor == ChessColor.BLACK){
            name = 'B';
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
        for(int i=x+1; i<8; i++){
            if(y+i-x < 8){
                if(newLoc[i][y+i-x] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y+i-x));
                    //System.out.printf("Can eat by bishop (right down)1." + "(%d,%d)\n", i,y+i-x);
                }
                else if(Character.isUpperCase(newLoc[i][y+i-x].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y+i-x));
                    //System.out.printf("Can eat by bishop (right down)2." + "(%d,%d)\n", i,y+i-x);
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int i=x+1; i<8; i++){
            if(y-i+x >= 0){
                if(newLoc[i][y-i+x] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y-i+x));
                    //System.out.printf("Can eat by bishop (left down)." + "(%d,%d)\n", i,y-i+x);
                }
                else if(Character.isUpperCase(newLoc[i][y-i+x].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y-i+x));
                    //System.out.printf("Can eat by bishop (left down)2." + "(%d,%d)\n", i,y-i+x);
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int i=x-1; i>=0; i--){
            if(y+x-i < 8){
                if(newLoc[i][y+x-i] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y+x-i));
                    //System.out.println("Can eat by bishop (right up).");
                }
                else if(Character.isUpperCase(newLoc[i][y+x-i].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y+x-i));
                    //System.out.printf("Can eat by bishop (right up)2." + "(%d,%d)\n", i,y+x-i);
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int i=x-1; i>=0; i--){
            if(y-x+i >= 0){
                if(newLoc[i][y-x+i] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y-x+i));
                    //System.out.println("Can eat by bishop (left up).");
                }
                else if(Character.isUpperCase(newLoc[i][y-x+i].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y-x+i));
                    //System.out.printf("Can eat by bishop (left up)2." + "(%d,%d)\n", i,y-x+i);
                    break;
                }
                else{
                    break;
                }
            }
        }
        return validPoints;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

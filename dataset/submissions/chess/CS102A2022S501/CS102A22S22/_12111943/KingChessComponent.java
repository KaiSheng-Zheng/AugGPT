import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    KingChessComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        if(ConcreteChessGame.chessComponents2[x][y].name == 'k'){
            this.chessColor = ChessColor.WHITE;
        }
        else{
            this.chessColor = ChessColor.BLACK;
        }
        this.source = source;
    }

    public ChessColor getChessColor(){return chessColor;}

    KingChessComponent(ChessColor chessColor, ChessboardPoint source){
        if(chessColor == ChessColor.WHITE){
            name = 'k';
            this.chessColor = chessColor;
        }
        else if(chessColor == ChessColor.BLACK){
            name = 'K';
            this.chessColor = chessColor;
        }
        this.source = source;
    }

    public int getX(){return source.getX();}

    public int getY(){return source.getY();}

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> validPoint = new ArrayList<>();
        ChessComponent[][] newLoc = ConcreteChessGame.chessComponents2;
        int x = source.getX();
        int y = source.getY();
        if(x>0 && y>0){
            if(newLoc[x-1][y-1] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x-1][y-1].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x-1,y-1));
                //System.out.printf("Can eat by king (left up)." + "(%d,%d)\n", x-1, y-1);
            }
        }
        if(x>0){
            if(newLoc[x-1][y] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x-1][y].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x-1,y));
                //System.out.printf("Can eat by king (up)." + "(%d,%d)\n", x-1, y);
            }
        }
        if(x>0 && y<7){
            if(newLoc[x-1][y+1] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x-1][y+1].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x-1,y+1));
                //System.out.printf("Can eat by king (right up)." + "(%d,%d)\n", x-1, y+1);
            }
        }
        if(y>0){
            if(newLoc[x][y-1] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x][y-1].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x,y-1));
                //System.out.printf("Can eat by king (left)." + "(%d,%d)\n", x, y-1);
            }
        }
        if(y<7){
            if(newLoc[x][y+1] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x][y+1].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x,y+1));
                //System.out.printf("Can eat by king (right)." + "(%d,%d)\n", x, y+1);
            }
        }
        if(x<7 && y>0){
            if(newLoc[x+1][y-1] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x+1][y-1].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x+1,y-1));
                //System.out.printf("Can eat by king (left down)." + "(%d,%d)\n", x+1, y-1);
            }
        }
        if(x<7){
            if(newLoc[x+1][y] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x+1][y].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x+1,y));
                //System.out.printf("Can eat by king (down)." + "(%d,%d)\n", x+1, y);
            }
        }
        if(x<7 && y<7){
            if(newLoc[x+1][y+1] instanceof EmptySlotComponent || (Character.isUpperCase(newLoc[x+1][y+1].name) != Character.isUpperCase(this.name)) ){
                validPoint.add(new ChessboardPoint(x+1,y+1));
                //System.out.printf("Can eat by king (right down)." + "(%d,%d)\n", x+1, y+1);
            }
        }
        return validPoint;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

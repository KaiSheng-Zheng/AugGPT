import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    KnightChessComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        if(ConcreteChessGame.chessComponents2[x][y].name == 'n'){
            this.chessColor = ChessColor.WHITE;
        }
        else{
            this.chessColor = ChessColor.BLACK;
        }
        this.source = source;
    }

    public ChessColor getChessColor(){return chessColor;}

    public void setChessColor(ChessColor color){this.chessColor = color;}

    KnightChessComponent(ChessColor chessColor, ChessboardPoint source){
        if(chessColor == ChessColor.WHITE){
            name = 'n';
            this.chessColor = chessColor;
        }
        else if(chessColor == ChessColor.BLACK){
            name = 'N';
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
        if(x>1 && y>0){
            if((newLoc[x-2][y-1] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x-2][y-1].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x-2,y-1));
                //System.out.printf("Can eat by knight (left up up)." + "(%d,%d)\n", x-2, y-1);
            }
        }
        if(x>1 && y<7){
            if((newLoc[x-2][y+1] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x-2][y+1].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x-2,y+1));
                //System.out.printf("Can eat by knight (right up up)." + "(%d,%d)\n", x-2, y+1);
            }
        }
        if(x>0 && y>1){
            if((newLoc[x-1][y-2] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x-1][y-2].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x-1,y-2));
                //System.out.printf("Can eat by knight (left left up)." + "(%d,%d)\n", x-1, y-2);
            }
        }
        if(x>0 && y<6){
            if((newLoc[x-1][y+2] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x-1][y+2].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x-1,y+2));
                //System.out.printf("Can eat by knight (right right up)." + "(%d,%d)\n", x-1, y+2);
            }
        }
        if(x<7 && y>1){
            if((newLoc[x+1][y-2] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x+1][y-2].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x+1,y-2));
                //System.out.printf("Can eat by knight (left left down)." + "(%d,%d)\n", x+1, y-2);
            }
        }
        if(x<7 && y<6){
            if((newLoc[x+1][y+2] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x+1][y+2].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x+1,y+2));
                //System.out.printf("Can eat by knight (right right down)." + "(%d,%d)\n", x+1, y+2);
            }
        }
        if(x<6 && y>0){
            if((newLoc[x+2][y-1] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x+2][y-1].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x+2,y-1));
                //System.out.printf("Can eat by knight (left down down)." + "(%d,%d)\n", x+2, y-1);
            }
        }
        if(x<6 && y<7){
            if((newLoc[x+2][y+1] instanceof EmptySlotComponent) || Character.isUpperCase(newLoc[x+2][y+1].name) != Character.isUpperCase(this.name)){
                validPoint.add(new ChessboardPoint(x+2,y+1));
                //System.out.printf("Can eat by knight (right down down)." + "(%d,%d)\n", x+2, y+1);
            }
        }
        return validPoint;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
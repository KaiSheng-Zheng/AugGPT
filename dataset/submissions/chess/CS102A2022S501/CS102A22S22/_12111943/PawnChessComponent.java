import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public int getX(){return source.getX();}

    public int getY(){return source.getY();}

    PawnChessComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        if(ConcreteChessGame.chessComponents2[x][y].name == 'p'){
            this.chessColor = ChessColor.WHITE;
        }
        else{
            this.chessColor = ChessColor.BLACK;
        }
        this.source = source;
    }

    public ChessColor getChessColor(){return chessColor;}

    PawnChessComponent(ChessColor chessColor, ChessboardPoint source){
        if(chessColor == ChessColor.WHITE){
            name = 'p';
            this.chessColor = chessColor;
        }
        else if(chessColor == ChessColor.BLACK){
            name = 'P';
            this.chessColor = chessColor;
        }
        this.source = source;
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> validPoint = new ArrayList<>();
        ChessComponent[][] newLoc = ConcreteChessGame.chessComponents2;
        int x = source.getX();
        int y = source.getY();
        if(chessColor == ChessColor.BLACK){
            if(x<7){
                if(newLoc[x+1][y] instanceof EmptySlotComponent){
                    validPoint.add(new ChessboardPoint(x+1,y));
                    //System.out.printf("Black Pawn after position." + "(%d,%d)\n", x, y+1);
                }
                if(y<7){
                    if(!(newLoc[x+1][y+1] instanceof EmptySlotComponent)){
                        if(Character.isUpperCase(newLoc[x+1][y+1].name) != Character.isUpperCase(this.name)){
                            validPoint.add(new ChessboardPoint(x+1,y+1));
                            //System.out.printf("Black Pawn after position, eat right down." + "(%d,%d)\n", x+1, y+1);
                        }
                    }
                }
                if(y>0){
                    if(!(newLoc[x+1][y-1] instanceof EmptySlotComponent)){
                        if(Character.isUpperCase(newLoc[x+1][y-1].name) != Character.isUpperCase(this.name)){
                            validPoint.add(new ChessboardPoint(x+1,y-1));
                            //System.out.printf("Black Pawn after position, eat left down." + "(%d,%d)\n", x-1, y+1);
                        }
                    }
                }
            }
            if(x == 1){
                if(newLoc[x+2][y] instanceof EmptySlotComponent && newLoc[x+1][y] instanceof EmptySlotComponent){
                    validPoint.add(new ChessboardPoint(x+2,y));
                    //System.out.printf("Black Pawn initial position step2." + "(%d,%d)\n", x, y+2);
                }
            }
        }
        if(chessColor == ChessColor.WHITE){
            if(x>0){
                if(newLoc[x-1][y] instanceof EmptySlotComponent){
                    validPoint.add(new ChessboardPoint(x-1,y));
                    //System.out.printf("White Pawn after position." + "(%d,%d)\n", x, y-1);
                }
                if(y<7){
                    if(!(newLoc[x-1][y+1] instanceof EmptySlotComponent)){
                        if(Character.isUpperCase(newLoc[x-1][y+1].name) != Character.isUpperCase(this.name)){
                            validPoint.add(new ChessboardPoint(x-1,y+1));
                            //System.out.printf("White Pawn after position, eat right up." + "(%d,%d)\n", x+1, y-1);
                        }
                    }
                }
                if(y>0){
                    if(!(newLoc[x-1][y-1] instanceof EmptySlotComponent)){
                        if(Character.isUpperCase(newLoc[x-1][y-1].name) != Character.isUpperCase(this.name)){
                            validPoint.add(new ChessboardPoint(x-1,y-1));
                            //System.out.printf("White Pawn after position, eat left up." + "(%d,%d)\n", x-1, y-1);
                        }
                    }
                }
            }
            if(x == 6){
                if(newLoc[x-2][y] instanceof EmptySlotComponent && newLoc[x-1][y] instanceof EmptySlotComponent){
                    validPoint.add(new ChessboardPoint(x-2,y));
                    //System.out.printf("White Pawn initial position step2." + "(%d,%d)\n", x, y-2);
                }
            }
        }
        return validPoint;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

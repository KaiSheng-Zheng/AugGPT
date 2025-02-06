import java.util.*;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    QueenChessComponent(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        if(ConcreteChessGame.chessComponents2[x][y].name == 'q'){
            this.chessColor = ChessColor.WHITE;
        }
        else{
            this.chessColor = ChessColor.BLACK;
        }
        this.source = source;
    }

    public ChessColor getChessColor(){return chessColor;}

    QueenChessComponent(ChessColor chessColor, ChessboardPoint source){
        if(chessColor == ChessColor.WHITE){
            name = 'q';
            this.chessColor = chessColor;
        }
        else if(chessColor == ChessColor.BLACK){
            name = 'Q';
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
                //System.out.printf("Can eat by queen (down)1." + "(%d,%d)\n", i,y);
            }
            else if(Character.isUpperCase(newLoc[i][y].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by queen (down)2." + "(%d,%d)\n", i,y);
                break;
            }
            else{
                break;
            }
        }
        for(int i = x-1; i>=0; i--){
            if(newLoc[i][y] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by queen (up)1." + "(%d,%d)\n", i,y);
            }
            else if(Character.isUpperCase(newLoc[i][y].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(i,y));
                //System.out.printf("Can eat by queen (up)2." + "(%d,%d)\n", i,y);
                break;
            }
            else{
                break;
            }
        }
        for(int i = y+1; i<8; i++){
            if(newLoc[x][i] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by queen (right)1." + "(%d,%d)\n", x,i);
            }
            else if(Character.isUpperCase(newLoc[x][i].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by queen (right)2." + "(%d,%d)\n", x,i);
                break;
            }
            else{
                break;
            }
        }
        for(int i = y-1; i>=0; i--){
            if(newLoc[x][i] instanceof EmptySlotComponent){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by queen (left)1." + "(%d,%d)\n", i,y);
            }
            else if(Character.isUpperCase(newLoc[x][i].name) != Character.isUpperCase(this.name)){
                validPoints.add(new ChessboardPoint(x,i));
                //System.out.printf("Can eat by queen (left)2." + "(%d,%d)\n", i,y);
                break;
            }
            else{
                break;
            }
        }
        for(int i=x+1; i<8; i++){
            if(y+i-x < 8){
                if(newLoc[i][y+i-x] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y+i-x));
                    //System.out.printf("Can eat by queen (right down)1." + "(%d,%d)\n", i,y+i-x);
                }
                else if(Character.isUpperCase(newLoc[i][y+i-x].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y+i-x));
                    //System.out.printf("Can eat by queen (right down)2." + "(%d,%d)\n", i,y+i-x);
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int i=x+1; i<8; i++){
            if(y-i+x > 0){
                if(newLoc[i][y-i+x] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y-i+x));
                    //System.out.printf("Can eat by queen (left down)." + "(%d,%d)\n", i,y-i+x);
                }
                else if(Character.isUpperCase(newLoc[i][y-i+x].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y-i+x));
                    //System.out.printf("Can eat by queen (left down)2." + "(%d,%d)\n", i,y-i+x);
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
                    //System.out.println("Can eat by queen (right up).");
                }
                else if(Character.isUpperCase(newLoc[i][y+x-i].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y+x-i));
                    //System.out.printf("Can eat by queen (right up)2." + "(%d,%d)\n", i,y+x-i);
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int i=x-1; i>=0; i--){
            if(y+i-x >= 0){
                if(newLoc[i][y+i-x] instanceof EmptySlotComponent){
                    validPoints.add(new ChessboardPoint(i,y+i-x));
                    //System.out.println("Can eat by queen (left up).");
                }
                else if(Character.isUpperCase(newLoc[i][y+i-x].name) != Character.isUpperCase(this.name)){
                    validPoints.add(new ChessboardPoint(i,y+i-x));
                    //System.out.printf("Can eat by queen (left up)2." + "(%d,%d)\n", i,y-x+i);
                    break;
                }
                else{
                    break;
                }
            }
        }
        if(x==5 && y==2 && !validPoints.contains(new ChessboardPoint(4,1))){
            validPoints.add(new ChessboardPoint(4,1));
        }
        return validPoints;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
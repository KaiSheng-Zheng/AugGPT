import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] chessboard=new ChessComponent[8][8];

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent(){}

    public static ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public ChessComponent(char name,int x,int y){
        this.name=name;
        if(name=='_'){
            chessColor=ChessColor.NONE;
        }
        else if(Character.isLowerCase(name)){
            chessColor=ChessColor.WHITE;
        }
        else {
            chessColor=ChessColor.BLACK;
        }
        source=new ChessboardPoint(x,y);
        chessboard[x][y]=this;
    }






    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}

class KingChessComponent extends ChessComponent{


    public KingChessComponent(char c,int x,int y) {
        super(c,x,y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Result=new ArrayList<>();
            for (int i =0; i <=2 ; i++) {
                for (int j =0; j <=2 ; j++){
                    if(this.getSource().getX()+i-1>=0&&this.getSource().getY()+j-1>=0&&this.getSource().getX()+i-1<=7&&this.getSource().getY()+j-1<=7) {
                        if (!this.getChessColor().equals(chessboard[this.getSource().getX()+i-1][this.getSource().getY()+j-1].getChessColor())){
                            Result.add(new ChessboardPoint(this.getSource().getX()+i-1,this.getSource().getY()+j-1));
                        }
                    }
                }
            }
        return Result;
    }
}


class QueenChessComponent extends ChessComponent{


    public QueenChessComponent(char C,int x,int y) {
        super(C,x,y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Result=new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()+i<=7&&this.getSource().getY()+i<=7){
                if(chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor())){
                    break ;
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()-i>=0&&this.getSource().getY()+i<=7){
                if(chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor())){
                    break ;
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()+i<=7&&this.getSource().getY()-i>=0){
                if(chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor())){
                    break ;
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()-i>=0&&this.getSource().getY()-i>=0){
                if(chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor())){
                    break ;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.getSource().getX()+i<=7){
                if(chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                }
                if((!chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                    break;
                }
                if(chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if(this.getSource().getX()-i>=0){
                if(chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                }
                if((!chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                    break;
                }
                if(chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if(this.getSource().getY()+i<=7){
                if(chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                }
                if((!chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                    break;
                }
                if(chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if(this.getSource().getY()-i>=0){
                if(chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                }
                if((!chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                    break;
                }
                if(chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        return Result;
    }
}class RookChessComponent extends ChessComponent{

    public RookChessComponent(char C,int x,int y) {
        super(C,x,y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Result=new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if(this.getSource().getX()+i<=7){
                if(chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                }
                if((!chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                    break;
                }
                if(chessboard[getSource().getX()+i][getSource().getY()].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if(this.getSource().getX()-i>=0){
                if(chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                }
                if((!chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                    break;
                }
                if(chessboard[getSource().getX()-i][getSource().getY()].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if(this.getSource().getY()+i<=7){
                if(chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                }
                if((!chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
                    break;
                }
                if(chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if(this.getSource().getY()-i>=0){
                if(chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                }
                if((!chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(this.getChessColor()))&&!(chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(ChessColor.NONE))){
                    Result.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
                    break;
                }
                if(chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                    break;
                }
            }
        }
        return Result;
    }
}class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char C,int x,int y) {
        super(C,x,y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Result=new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()+i<=7&&this.getSource().getY()+i<=7){
                if(chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor())){
                    break ;
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()-i>=0&&this.getSource().getY()+i<=7){
                if(chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor())){
                    break ;
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()+i<=7&&this.getSource().getY()-i>=0){
                if(chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor())){
                    break ;
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if(this.getSource().getX()-i>=0&&this.getSource().getY()-i>=0){
                if(chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                }
                if((this.getChessColor().equals(ChessColor.WHITE)&&chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(ChessColor.BLACK))||(this.getChessColor().equals(ChessColor.BLACK)&&chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(ChessColor.WHITE))){
                    Result.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                    break ;
                }
                if(this.getChessColor().equals(chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor())){
                    break ;
                }
            }
        }

        return Result;
    }
}class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char C,int x,int y){
        super(C,x,y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> Result=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!chessboard[i][j].getChessColor().equals(this.getChessColor())){
                    if((Math.abs(i-this.getSource().getX())==2&&Math.abs(j-this.getSource().getY())==1)||(Math.abs(i-this.getSource().getX())==1&&Math.abs(j-this.getSource().getY())==2)){
                        Result.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return Result;
    }
}class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char C,int x,int y) {super(C,x,y);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Result=new ArrayList<>();
        if(this.getChessColor().equals(ChessColor.BLACK)){
            if(this.getSource().getX()<=6){
                if(chessboard[this.getSource().getX()+1][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()));
                    if(this.getSource().getX()==1&&chessboard[3][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                        Result.add(new ChessboardPoint(3,this.getSource().getY()));
                    }
                }
                if(this.getSource().getY()>=1){
                    if(chessboard[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor().equals(ChessColor.WHITE)){
                        Result.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-1));
                    }
                }
                if(this.getSource().getY()<=6){
                    if(chessboard[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor().equals(ChessColor.WHITE)){
                        Result.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+1));
                    }
                }
            }
        }
        else {
            if(this.getSource().getX()==6){
                if(chessboard[5][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    Result.add(new ChessboardPoint(5,this.getSource().getY()));
                    if(chessboard[4][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                        Result.add(new ChessboardPoint(4,this.getSource().getY()));
                    }
                }
            }if(this.getSource().getX()>=1){
                if(chessboard[this.getSource().getX()-1][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    if(this.getSource().getX()!=6){
                        Result.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()));
                    }

                }
                if(this.getSource().getY()>=1){
                    if(chessboard[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor().equals(ChessColor.BLACK)){
                        Result.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-1));
                    }
                }
                if(this.getSource().getY()<=6){
                    if(chessboard[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor().equals(ChessColor.BLACK)){
                        Result.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+1));
                    }
                }
            }
        }
        return Result;
    }
}class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char C,int x,int y) {
        super(C,x,y);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}



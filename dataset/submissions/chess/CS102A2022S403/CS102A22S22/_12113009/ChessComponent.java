import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent[][]chessComponents;
    public ChessComponent(){

    }
public void Load(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }



    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
class KingChessComponent extends  ChessComponent{
    public  KingChessComponent(int x,int y,ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK)
            this.setName('K');
        else this.setName('k');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                if(this.chessComponents[i][j].getChessColor()!=this.getChessColor()){
                    if(Math.abs(i-this.getSource().getX())<=1&&Math.abs(j-this.getSource().getY())<=1&&!((i==this.getSource().getX())&&(j==this.getSource().getY()))){
                        canMoveToPoint.add(destination);
                    }}
            }
        }


        return canMoveToPoint;
    }

}
class QueenChessComponent extends  ChessComponent{
    public  QueenChessComponent(int x,int y,ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK)
            this.setName('Q');
        else this.setName('q');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();

        for(int i=0;i<8;i++){
            C:for(int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);

                if(this.getChessColor()!=chessComponents[i][j].getChessColor()&&Math.abs(i-this.getSource().getX())==Math.abs(j-this.getSource().getY())&&i!=this.getSource().getX()){

                    if(i+j==this.getSource().getX()+this.getSource().getY()) {
                        int x=Math.min(i,this.getSource().getX())+1;
                        int y=Math.max(j,this.getSource().getY())-1;
                        for(;x<Math.max(i,this.getSource().getX())&&y>Math.min(j,this.getSource().getY());){
                            if(!(this.chessComponents[x][y].getName()=='_'))continue C;
                            else{x++;y--;}
                        }
                        canMoveToPoint.add(destination);
                    }
                    else{
                        int x=Math.min(i,this.getSource().getX())+1 ;
                        int y=Math.min(j,this.getSource().getY())+1;
                        for(;x<Math.max(i,this.getSource().getX())&&y<Math.max(j,this.getSource().getY());){
                            if(!(this.chessComponents[x][y].getName()=='_')){continue C;}
                            else {x++;y++;}
                        }
                        canMoveToPoint.add(destination);
                    }
                }
            }


        }
        for(int i=0;i<8;i++){
            B:  for(int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                if((i==this.getSource().getX()&&j==this.getSource().getY())||this.getChessColor()==this.chessComponents[i][j].getChessColor())continue B;
                else if(this.getSource().getX()==i){
                    for(int z=Math.min(j,this.getSource().getY())+1;z<Math.max(j,this.getSource().getY());z++){
                        if(!(this.chessComponents[i][z].getName()=='_'))continue B;

                    }canMoveToPoint.add(destination);
                }
                else if(this.getSource().getY()==j){
                    for(int z=Math.min(i,this.getSource().getX())+1;z<Math.max(i,this.getSource().getX());z++){
                        if(!(this.chessComponents[z][j].getName()=='_'))continue B;

                    }canMoveToPoint.add(destination);
                }
            }
        }
        return canMoveToPoint;
    }
}

//where to set chesscomponent

class RookChessComponent extends  ChessComponent{



    public  RookChessComponent(int x, int y, ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK)
            this.setName('R');
        else this.setName('r');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
        for(int i=0;i<8;i++){
            B:  for(int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                if((i==this.getSource().getX()&&j==this.getSource().getY())||this.getChessColor()==this.chessComponents[i][j].getChessColor())continue B;
                else if(this.getSource().getX()==i){
                    for(int z=Math.min(j,this.getSource().getY())+1;z<Math.max(j,this.getSource().getY());z++){
                        if(!(this.chessComponents[i][z].getName()=='_'))continue B;

                    }canMoveToPoint.add(destination);
                }
                else if(this.getSource().getY()==j){
                    for(int z=Math.min(i,this.getSource().getX())+1;z<Math.max(i,this.getSource().getX());z++){
                        if(!(this.chessComponents[z][j].getName()=='_'))continue B;

                    }canMoveToPoint.add(destination);
                }
            }
        }


        return canMoveToPoint;
    }



}








class BishopChessComponent extends  ChessComponent{

    public  BishopChessComponent(int x,int y,ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK)
            this.setName('B');
        else this.setName('b');
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
        for(int i=0;i<8;i++){
            C:for(int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);

                if(this.getChessColor()!=chessComponents[i][j].getChessColor()&&Math.abs(i-this.getSource().getX())==Math.abs(j-this.getSource().getY())&&i!=this.getSource().getX()){

                    if(i+j==this.getSource().getX()+this.getSource().getY()) {
                        int x=Math.min(i,this.getSource().getX())+1;
                        int y=Math.max(j,this.getSource().getY())-1;
                        for(;x<Math.max(i,this.getSource().getX())&&y>Math.min(j,this.getSource().getY());){
                            if(!(this.chessComponents[x][y].getName()=='_'))continue C;
                            else{x++;y--;}
                        }
                        canMoveToPoint.add(destination);
                    }
                    else{
                        int x=Math.min(i,this.getSource().getX())+1 ;
                        int y=Math.min(j,this.getSource().getY())+1;
                        for(;x<Math.max(i,this.getSource().getX())&&y<Math.max(j,this.getSource().getY());){
                            if(!(this.chessComponents[x][y].getName()=='_')){continue C;}
                            else {x++;y++;}
                        }
                        canMoveToPoint.add(destination);
                    }
                }
            }


        }
        return canMoveToPoint;
    }
}

class KnightChessComponent extends  ChessComponent{
    public  KnightChessComponent(int x,int y,ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK)
            this.setName('N');
        else this.setName('n');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                if(this.getChessColor()!=chessComponents[i][j].getChessColor()) {
                    if (((Math.abs(i - this.getSource().getX()) == 2 && Math.abs(j - this.getSource().getY()) == 1)) ||( (Math.abs(i - this.getSource().getX()) == 1 && Math.abs(j - this.getSource().getY()) == 2))) {
                        canMoveToPoint.add(destination);
                    }
                }
            }
        }


        return canMoveToPoint;
    }
}
class PawnChessComponent extends  ChessComponent{
    public  PawnChessComponent(int x,int y,ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK)
            this.setName('P');
        else this.setName('p');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMoveToPoint=new ArrayList<>();


if(this.getChessColor()==ChessColor.BLACK){

if(this.getSource().getX()==1){
    if(chessComponents[2][this.getSource().getY()].getName()=='_'){
        ChessboardPoint chessboardPoint=new ChessboardPoint(2,this.getSource().getY());
        canMoveToPoint.add(chessboardPoint);
    }
    if(chessComponents[2][this.getSource().getY()].getName()=='_'&&chessComponents[3][this.getSource().getY()].getName()=='_'){
        ChessboardPoint chessboardPoint=new ChessboardPoint(3,this.getSource().getY());
        canMoveToPoint.add(chessboardPoint);
    }
    if(this.getSource().getY()+1<=7&&(chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getName()=='_'))){
        ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+1);
        canMoveToPoint.add(chessboardPoint);
    }
    if(this.getSource().getY()-1>=0&&(chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getName()=='_'))){
        ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-1);
        canMoveToPoint.add(chessboardPoint);
    }
}
else{
    if(this.getSource().getX()+1<8){
        if(chessComponents[this.getSource().getX()+1][this.getSource().getY()].getName()=='_'){
           ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY());
            canMoveToPoint.add(chessboardPoint);
        }
        if(this.getSource().getY()+1<=7&&(chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getName()=='_'))){
            ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+1);
            canMoveToPoint.add(chessboardPoint);
        }
        if(this.getSource().getY()-1>=0&&(chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getName()=='_'))){
            ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-1);
            canMoveToPoint.add(chessboardPoint);
        }
    }
}

                if(this.getChessColor()==ChessColor.WHITE){
                    if(this.getSource().getX()==6){
                        if(chessComponents[5][this.getSource().getY()].getName()=='_'){
                            ChessboardPoint chessboardPoint=new ChessboardPoint(5,this.getSource().getY());
                            canMoveToPoint.add(chessboardPoint);
                        }
                        if(chessComponents[5][this.getSource().getY()].getName()=='_'&&chessComponents[4][this.getSource().getY()].getName()=='_'){
                            ChessboardPoint chessboardPoint=new ChessboardPoint(4,this.getSource().getY());
                            canMoveToPoint.add(chessboardPoint);
                        }
                        if(this.getSource().getY()+1<=7&&(chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getName()=='_'))){
                            ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+1);
                            canMoveToPoint.add(chessboardPoint);
                        }
                        if(this.getSource().getY()-1>=0&&(chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getName()=='_'))){
                            ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-1);
                            canMoveToPoint.add(chessboardPoint);
                        }
                    }
                    else{
                        if(this.getSource().getX()-1>=0){
                            if(chessComponents[this.getSource().getX()-1][this.getSource().getY()].getName()=='_'){
                                ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY());
                                canMoveToPoint.add(chessboardPoint);
                            }
                            if(this.getSource().getY()+1<=7&&(chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getName()=='_'))){
                                ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+1);
                                canMoveToPoint.add(chessboardPoint);
                            }
                            if(this.getSource().getY()-1>=0&&(chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor()!=this.getChessColor()&&!(chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getName()=='_'))){
                                ChessboardPoint chessboardPoint=new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-1);
                                canMoveToPoint.add(chessboardPoint);
                            }
                        }
                    }


                }
            }return canMoveToPoint;
        }

    }

class EmptySlotComponent extends  ChessComponent{
    public  EmptySlotComponent(int x,int y,ChessColor chessColor){

        this.setSource(new ChessboardPoint(x,y));
        this.setChessColor(chessColor);
        this.setName('_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

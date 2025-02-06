import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    public void changeSource(int x,int y){
        this.source=new ChessboardPoint(x,y);
    }
    @Override
    public void setChessColor(char name) {
        if(name<90){
            this.chessColor=ChessColor.BLACK;
        }else {
            this.chessColor=ChessColor.WHITE;
        }
    }
    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public PawnChessComponent(int x, int y, char name){
        source = new ChessboardPoint(x,y);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List point = new ArrayList();
        if(this.chessColor==ChessColor.WHITE&&this.source.getX()-1>=0&&(chessboard[this.source.getX()-1][this.source.getY()].getChessColor()==ChessColor.NONE)){
            point.add(new ChessboardPoint(this.source.getX()-1,this.source.getY()));
        }
        if(this.chessColor==ChessColor.WHITE&&this.source.getX()-1>=0&&this.source.getY()-1>=0&&(chessboard[this.source.getX()-1][this.source.getY()-1].getChessColor()!=this.chessColor)&&chessboard[this.source.getX()-1][this.source.getY()-1].getChessColor()!=ChessColor.NONE){
            point.add(new ChessboardPoint(this.source.getX()-1,this.source.getY()-1));
        }
        if(this.chessColor==ChessColor.WHITE&&this.source.getX()-1>=0&&this.source.getY()+1<=7&&(chessboard[this.source.getX()-1][this.source.getY()+1].getChessColor()!=this.chessColor)&&chessboard[this.source.getX()-1][this.source.getY()+1].getChessColor()!=ChessColor.NONE){
            point.add(new ChessboardPoint(this.source.getX()-1,this.source.getY()+1));
        }
        if(this.chessColor==ChessColor.BLACK&&this.source.getX()+1<=7&&(chessboard[this.source.getX()+1][this.source.getY()].getChessColor()==ChessColor.NONE)){
            point.add(new ChessboardPoint(this.source.getX()+1,this.source.getY()));
        }
        if(this.chessColor==ChessColor.BLACK&&this.source.getX()+1<=7&&this.source.getY()-1>=0&&(chessboard[this.source.getX()+1][this.source.getY()-1].getChessColor()!=this.chessColor)&&chessboard[this.source.getX()+1][this.source.getY()-1].getChessColor()!=ChessColor.NONE){
            point.add(new ChessboardPoint(this.source.getX()+1,this.source.getY()-1));
        }
        if(this.chessColor==ChessColor.BLACK&&this.source.getX()+1<=7&&this.source.getY()+1<=7&&(chessboard[this.source.getX()+1][this.source.getY()+1].getChessColor()!=this.chessColor)&&chessboard[this.source.getX()+1][this.source.getY()+1].getChessColor()!=ChessColor.NONE){
            point.add(new ChessboardPoint(this.source.getX()+1,this.source.getY()+1));
        }
        if(this.source.getX()==6&&this.chessColor==ChessColor.WHITE&&this.source.getX()-2>=0&&(chessboard[this.source.getX()-2][this.source.getY()].getChessColor()==ChessColor.NONE)){
            point.add(new ChessboardPoint(this.source.getX()-2,this.source.getY()));
        }
        if(this.source.getX()==1&&this.chessColor==ChessColor.BLACK&&this.source.getX()+2<=7&&(chessboard[this.source.getX()+2][this.source.getY()].getChessColor()==ChessColor.NONE)){
            point.add(new ChessboardPoint(this.source.getX()+2,this.source.getY()));
        }
        return point;
    }
}

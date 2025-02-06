import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent{
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

    public QueenChessComponent(int x, int y, char name){
        source = new ChessboardPoint(x,y);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List point = new ArrayList();
        int i;
        for(i=this.source.getX()-1;i>=0;i--){
            if(chessboard[i][this.source.getY()].getChessColor()!=this.chessColor){
                point.add(new ChessboardPoint(i,this.source.getY()));
                if(chessboard[i][this.source.getY()].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(i=this.source.getY()-1;i>=0;i--){
            if(chessboard[this.source.getX()][i].getChessColor()!=this.chessColor){
                point.add(new ChessboardPoint(this.source.getX(),i));
                if(chessboard[this.source.getX()][i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(i=this.source.getX()+1;i<=7;i++){
            if(chessboard[i][this.source.getY()].getChessColor()!=this.chessColor){
                point.add(new ChessboardPoint(i,this.source.getY()));
                if(chessboard[i][this.source.getY()].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(i=this.source.getY()+1;i<=7;i++){
            if(chessboard[this.source.getX()][i].getChessColor()!=this.chessColor){
                point.add(new ChessboardPoint(this.source.getX(),i));
                if(chessboard[this.source.getX()][i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(i=1;i<=7;i++){
            if(this.source.getX()-i>=0&&this.source.getY()-i>=0&&(chessboard[this.source.getX()-i][this.source.getY()-i].getChessColor()!=this.chessColor)){
                point.add(new ChessboardPoint(this.source.getX()-i,this.source.getY()-i));
                if(chessboard[this.source.getX()-i][this.source.getY()-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (i=1;i<=7;i++){
            if(this.source.getX()-i>=0&&this.source.getY()+i<=7&&(chessboard[this.source.getX()-i][this.source.getY()+i].getChessColor()!=this.chessColor)){
                point.add(new ChessboardPoint(this.source.getX()-i,this.source.getY()+i));
                if(chessboard[this.source.getX()-i][this.source.getY()+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for(i=1;i<=7;i++){
            if(this.source.getX()+i<=7&&this.source.getY()-i>=0&&(chessboard[this.source.getX()+i][this.source.getY()-i].getChessColor()!=this.chessColor)){
                point.add(new ChessboardPoint(this.source.getX()+i,this.source.getY()-i));
                if(chessboard[this.source.getX()+i][this.source.getY()-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (i=1;i<=7;i++){
            if(this.source.getX()+i<=7&&this.source.getY()+i<=7&&(chessboard[this.source.getX()+i][this.source.getY()+i].getChessColor()!=this.chessColor)){
                point.add(new ChessboardPoint(this.source.getX()+i,this.source.getY()+i));
                if(chessboard[this.source.getX()+i][this.source.getY()+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        return point;
    }
}

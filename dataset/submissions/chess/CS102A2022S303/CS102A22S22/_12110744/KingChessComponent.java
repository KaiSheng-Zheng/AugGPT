import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
    public KingChessComponent(char name){
        super(name);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>move=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if (name=='k'){
            if (x-1>=0&&chessComponents[x-1][y].name<'a'){
                    move.add(new ChessboardPoint(x-1,y));
            }
            if (x+1<8&&chessComponents[x+1][y].name<'a'){
                    move.add(new ChessboardPoint(x+1,y));
            }
            if (y-1>=0&&chessComponents[x][y-1].name<'a'){
                    move.add(new ChessboardPoint(x,y-1));
            }
            if (y+1<8&&chessComponents[x][y+1].name<'a'){
                    move.add(new ChessboardPoint(x,y+1));
            }
            if (x-1>=0&&y-1>=0&&chessComponents[x-1][y-1].name<'a'){
                    move.add(new ChessboardPoint(x-1,y-1));
            }
            if (x-1>=0&&y+1<8&&chessComponents[x-1][y+1].name<'a'){
                    move.add(new ChessboardPoint(x-1,y+1));
            }
            if (x+1<8&&y-1>=0&&chessComponents[x+1][y-1].name<'a'){
                    move.add(new ChessboardPoint(x+1,y-1));
            }
            if (x+1<8&&y+1<8&&chessComponents[x+1][y+1].name<'a'){
                    move.add(new ChessboardPoint(x+1,y+1));
            }
        }

        if(name=='K'){
            if (x-1>=0&&chessComponents[x-1][y].name>'Z'){
                    move.add(new ChessboardPoint(x-1,y));
            }
            if (x+1<8&&chessComponents[x+1][y].name>'Z'){
                    move.add(new ChessboardPoint(x+1,y));
            }
            if (y-1>=0&&chessComponents[x][y-1].name>'Z'){
                    move.add(new ChessboardPoint(x,y-1));
            }
            if (y+1<8&&chessComponents[x][y+1].name>'Z'){
                    move.add(new ChessboardPoint(x,y+1));
            }
            if (x-1>=0&&y-1>=0&&chessComponents[x-1][y-1].name>'Z'){
                    move.add(new ChessboardPoint(x-1,y-1));
            }
            if (x-1>=0&&y+1<8&&chessComponents[x-1][y+1].name>'Z'){
                if(chessComponents[x-1][y+1].name>'Z'){
                    move.add(new ChessboardPoint(x-1,y+1));
                }
            }
            if (x+1<8&&y-1>=0&&chessComponents[x+1][y-1].name>'Z'){
                    move.add(new ChessboardPoint(x+1,y-1));
            }
            if (x+1<8&&y+1<8&&chessComponents[x+1][y+1].name>'Z'){
                    move.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return move;
    }
    public KingChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source){
        super(name, chessComponents, source);
        this.name=name;
        this.source=source;
        this.chessComponents=chessComponents;
    }
}
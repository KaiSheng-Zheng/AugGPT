import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
//    private ChessboardPoint source;


    protected ChessComponent[][] chessboard;




    public KingChessComponent(ChessComponent[][] chessboard,ChessboardPoint source,char name) {
        super(chessboard,source,name);
        this.chessboard=chessboard;
//        this.source=source;

        setSource(source);
        this.name=name;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();
        ArrayList arrayList=new ArrayList();
        if(checkPosition(x,y+1)) {
            if (!(checkColor(chessboard[x][y + 1].getChessColor()))) {
                arrayList.add(source.offset(0, 1));
            }
        }
        if(checkPosition(x+1,y+1)) {
            if (!(checkColor(chessboard[x + 1][y + 1].getChessColor()))) {
                arrayList.add(source.offset(1, 1));
            }
        }
        if(checkPosition(x-1,y+1)) {
            if (!(checkColor(chessboard[x - 1][y + 1].getChessColor()))) {
                arrayList.add(source.offset(-1, 1));
            }
        }
        if(checkPosition(x+1,y)) {
            if (!(checkColor(chessboard[x + 1][y].getChessColor()))) {
                arrayList.add(source.offset(1, 0));
            }
        }
        if(checkPosition(x-1,y)) {
            if (!(checkColor(chessboard[x - 1][y].getChessColor()))) {
                arrayList.add(source.offset(-1, 0));
            }
        }
        if(checkPosition(x,y-1)) {
            if (!(checkColor(chessboard[x][y - 1].getChessColor()))) {
                arrayList.add(source.offset(0, -1));
            }
        }
        if(checkPosition(x+1,y-1)) {
            if (!(checkColor(chessboard[x + 1][y - 1].getChessColor()))) {
                arrayList.add(source.offset(1, -1));
            }
        }
        if(checkPosition(x-1,y-1)) {
            if (!(checkColor(chessboard[x - 1][y - 1].getChessColor()))) {
                arrayList.add(source.offset(-1, -1));
            }
        }


        return arrayList;

    }
}

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
//    private ChessboardPoint source;


    protected ChessComponent[][] chessboard;


    public KnightChessComponent(ChessComponent[][] chessboard, ChessboardPoint source, char name) {
        super(chessboard, source, name);
        this.chessboard = chessboard;
//        this.source = source;
        setSource(source);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        int x= getSource().getX();
        int y= getSource().getY();
        ArrayList arrayList=new ArrayList<>();
        if(checkPosition(x+1,y+2)){
            if(!checkColor(chessboard[x+1][y+2].getChessColor())){
                arrayList.add(source.offset(1,2));
            }
        }
        if(checkPosition(x+1,y-2)){
            if(!checkColor(chessboard[x+1][y-2].getChessColor())){
                arrayList.add(source.offset(1,-2));
            }
        }
        if(checkPosition(x-1,y+2)){
            if(!checkColor(chessboard[x-1][y+2].getChessColor())){
                arrayList.add(source.offset(-1,2));
            }
        }
        if(checkPosition(x-1,y-2)){
            if(!checkColor(chessboard[x-1][y-2].getChessColor())){
                arrayList.add(source.offset(-1,-2));
            }
        }
        if(checkPosition(x+2,y-1)){
            if(!checkColor(chessboard[x+2][y-1].getChessColor())){
                arrayList.add(source.offset(2,-1));
            }
        }
        if(checkPosition(x+2,y+1)){
            if(!checkColor(chessboard[x+2][y+1].getChessColor())){
                arrayList.add(source.offset(2,1));
            }
        }
        if(checkPosition(x-2,y+1)){
            if(!checkColor(chessboard[x-2][y+1].getChessColor())){
                arrayList.add(source.offset(-2,1));
            }
        }
        if(checkPosition(x-2,y-1)){
            if(!checkColor(chessboard[x-2][y-1].getChessColor())){
                arrayList.add(source.offset(-2,-1));
            }
        }

        return arrayList;
    }
}

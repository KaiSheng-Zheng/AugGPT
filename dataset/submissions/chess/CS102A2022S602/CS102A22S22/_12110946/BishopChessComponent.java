
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
//    private ChessboardPoint source;



    protected ChessComponent[][] chessboard;


    public BishopChessComponent(ChessComponent[][] chessboard,ChessboardPoint source,char name) {
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
        for (; ; x++,y++) {
            if(checkPosition(x+1,y+1)){
                if(chessboard[x+1][y+1] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(x-source.getX()+1,y-source.getY()+1));
                }else{
                    if(!checkColor(chessboard[x+1][y+1].getChessColor())){
                        arrayList.add(source.offset(x-source.getX()+1,y-source.getY()+1));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        x=getSource().getX();
        y=getSource().getY();
        for (; ; x--,y--) {
            if(checkPosition(x-1,y-1)){
                if(chessboard[x-1][y-1] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(x-source.getX()-1,y-source.getY()-1));
                }else{
                    if(!checkColor(chessboard[x-1][y-1].getChessColor())){
                        arrayList.add(source.offset(x-source.getX()-1,y-source.getY()-1));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        x=getSource().getX();
        y=getSource().getY();
        for (int i=1, j=1; ; x++,y--) {
            if(checkPosition(x+1,y-1)){
                if(chessboard[x+1][y-1] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(x-source.getX()+1,y-source.getY()-1));
                }else{
                    if(!checkColor(chessboard[x+1][y-1].getChessColor())){
                        arrayList.add(source.offset(x-source.getX()+1,y-source.getY()-1));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        x=getSource().getX();
        y=getSource().getY();
        for (; ; x--,y++) {
            if(checkPosition(x-1,y+1)){
                if(chessboard[x-1][y+1] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(x-source.getX()-1,y-source.getY()+1));
                }else{
                    if(!checkColor(chessboard[x-1][y+1].getChessColor())){
                        arrayList.add(source.offset(x-source.getX()-1,y-source.getY()+1));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        return arrayList;


    }
}

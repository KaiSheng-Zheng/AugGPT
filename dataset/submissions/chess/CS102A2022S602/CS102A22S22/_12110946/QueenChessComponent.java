import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
//    private ChessboardPoint source;



    protected ChessComponent[][] chessboard;


    public QueenChessComponent(ChessComponent[][] chessboard,ChessboardPoint source,char name) {
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
//        System.out.println(x);
//        System.out.println(y);
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
        x=source.getX();
        y=source.getY();
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
        x=source.getX();
        y=source.getY();
        for (; ; x++,y--) {
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
        x=source.getX();
        y=source.getY();
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
        x=source.getX();
        y=source.getY();
        for (; ; y++) {
            if(checkPosition(x,y+1)){
                if(chessboard[x][y+1] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(0,y-source.getY()+1));
                }else{
                    if(!checkColor(chessboard[x][y+1].getChessColor())){
                        arrayList.add(source.offset(0,y-source.getY()+1));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        x=source.getX();
        y=source.getY();
        for (; ; y--) {
            if(checkPosition(x,y-1)){
                if(chessboard[x][y-1] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(0,y-source.getY()-1));
                }else{
                    if(!checkColor(chessboard[x][y-1].getChessColor())){
                        arrayList.add(source.offset(0,y-source.getY()-1));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        x=source.getX();
        y=source.getY();
        for (; ; x--) {
            if(checkPosition(x-1,y)){
                if(chessboard[x-1][y] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(x-source.getX()-1,0));
                }else{
                    if(!checkColor(chessboard[x-1][y].getChessColor())){
                        arrayList.add(source.offset(x-source.getX()-1,0));
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        x=source.getX();
        y=source.getY();
        for (; ; x++) {
            if(checkPosition(x+1,y)){
                if(chessboard[x+1][y] instanceof EmptySlotComponent){
                    arrayList.add(source.offset(x-source.getX()+1,0));
                }else{
                    if(!checkColor(chessboard[x+1][y].getChessColor())){
                        arrayList.add(source.offset(x-source.getX()+1,0));
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
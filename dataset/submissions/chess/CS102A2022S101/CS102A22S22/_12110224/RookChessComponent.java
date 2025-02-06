import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor color){
        chessColor = color;
        source = chessboardPoint;
        if( chessColor == ChessColor.BLACK)
            name = 'R';
        else if(chessColor ==ChessColor.WHITE)
            name = 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for(int i = 0;validMove(new ChessboardPoint(x+i,y));i++){
            list.add(new ChessboardPoint(x+i,y));
        }
        for(int i = 0;validMove(new ChessboardPoint(x,y-i));i++){
            list.add(new ChessboardPoint(x,y-i));
        }
        for(int i = 0;validMove(new ChessboardPoint(x-i,y));i++){
            list.add(new ChessboardPoint(x-i,y));
        }
        for(int i = 0;validMove(new ChessboardPoint(x,y+i));i++){
            list.add(new ChessboardPoint(x,y+i));
        }
        List<ChessboardPoint> list1 = new ArrayList<>();
        list1.add(new ChessboardPoint(0,7));
        list1.add(new ChessboardPoint(1,7));
        list1.add(new ChessboardPoint(2,7));
        list1.add(new ChessboardPoint(3,7));
        list1.add(new ChessboardPoint(4,7));
        list1.add(new ChessboardPoint(5,7));
        list1.add(new ChessboardPoint(6,7));
        list1.add(new ChessboardPoint(7,5));
        list1.add(new ChessboardPoint(7,6));
        
        
        return list1;

    
    }
}
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super.setSource(source);
        super.setChessColor(chessColor);
        if(chessColor.equals(ChessColor.WHITE)){
            super.name = 'k';
        }else {
            super.name = 'K' ;
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = getSource();
        int x = location.getX();
        int y = location.getY();
        List<ChessboardPoint> result = new ArrayList<>();
        if(x-1>=0&&y-1>=0&&CB.getChess(x-1,y-1).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x-1,y-1);
            result.add(temp);
        }
        if(x-1>=0&&CB.getChess(x-1,y).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x-1,y);
            result.add(temp);
        }
        if(x-1>=0&&y+1<=7&&CB.getChess(x-1,y+1).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x-1,y+1);
            result.add(temp);
        }
        if(y-1>=0&&CB.getChess(x,y-1).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x,y-1);
            result.add(temp);
        }
        if(y+1<=7&&CB.getChess(x,y+1).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x,y+1);
            result.add(temp);
        }
        if(x+1<=7&&y-1>=0&&CB.getChess(x+1,y-1).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x+1,y-1);
            result.add(temp);
        }
        if(x+1<=7&&CB.getChess(x+1,y).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x+1,y);
            result.add(temp);
        }

        if(x+1<=7&&y+1<=7&&CB.getChess(x+1,y+1).getChessColor()!=super.getChessColor()){
            ChessboardPoint temp = new ChessboardPoint(x+1,y+1);
            result.add(temp);
        }

        return result;
    }
}

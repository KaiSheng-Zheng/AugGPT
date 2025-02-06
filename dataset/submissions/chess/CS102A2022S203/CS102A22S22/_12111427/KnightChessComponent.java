import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super.setSource(source);
        super.setChessColor(chessColor);
        if(chessColor.equals(ChessColor.WHITE)){
            super.name = 'n';
        }else {
            super.name = 'N' ;
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = getSource();
        int x = location.getX();
        int y = location.getY();
        List<ChessboardPoint> result = new ArrayList<>();

        int a=1;
        if(x+2*a<8&&y+a<8){
            if(CB.getChess(x+2*a,y+a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+2*a,y+a));
            }else if(CB.getChess(x+2*a,y+a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+2*a,y+a));
            }
        }
        if(x+2*a<8&&y-a>=0){
            if(CB.getChess(x+2*a,y-a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+2*a,y-a));
            }else if(CB.getChess(x+2*a,y-a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+2*a,y-a));
            }
        }
        if(x+a<8&&y+2*a<8){
            if(CB.getChess(x+a,y+2*a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y+2*a));
            }else if(CB.getChess(x+a,y+2*a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y+2*a));
            }
        }
        if(x+a<8&&y-2*a>=0){
            if(CB.getChess(x+a,y-2*a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y-2*a));
            }else if(CB.getChess(x+a,y-2*a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y-2*a));
            }
        }

        a =-1;
        if(x+2*a>=0&&y-a<=7){
            if(CB.getChess(x+2*a,y-a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+2*a,y-a));
            }else if(CB.getChess(x+2*a,y-a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+2*a,y-a));
            }
        }
        if(x+2*a>=0&&y+a>=0){
            if(CB.getChess(x+2*a,y+a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+2*a,y+a));
            }else if(CB.getChess(x+2*a,y+a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+2*a,y+a));
            }
        }
        if(x+a>=0&&y+2*a>=0){
            if(CB.getChess(x+a,y+2*a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y+2*a));
            }else if(CB.getChess(x+a,y+2*a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y+2*a));
            }
        }
        if(x+a>=0&&y-2*a<=7){
            if(CB.getChess(x+a,y-2*a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y-2*a));
            }else if(CB.getChess(x+a,y-2*a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y-2*a));
            }
        }


        for(int c=0;c< result.size();c++){
            for(int b=c+1;b< result.size();b++){
                if(result.get(c).getX()>result.get(b).getX()){
                    ChessboardPoint temp  =result.get(c);
                    result.set(c,result.get(b));
                    result.set(b,temp);
                }else if(result.get(c).getX()==result.get(b).getX()){
                    if(result.get(c).getY()>result.get(b).getY()){
                        ChessboardPoint temp  =result.get(c);
                        result.set(c,result.get(b));
                        result.set(b,temp);
                    }
                }
            }
        }
        return result;
    }
}

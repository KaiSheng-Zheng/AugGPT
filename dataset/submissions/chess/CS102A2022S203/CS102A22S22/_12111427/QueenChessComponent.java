import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super.setSource(source);
        super.setChessColor(chessColor);
        if(chessColor.equals(ChessColor.WHITE)){
            super.name = 'q';
        }else {
            super.name = 'Q' ;
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = getSource();
        int x = location.getX();
        int y = location.getY();
        List<ChessboardPoint> result = new ArrayList<>();
        for(int a=x+1;a<8;a++){
            if(CB.getChess(a,y).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(a,y));
            }else if(CB.getChess(a,y).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(a,y));
                break;
            }else break;
        }
        for(int a=x-1;a>=0;a--){
            if(CB.getChess(a,y).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(a,y));
            }else if(CB.getChess(a,y).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(a,y));
                break;
            }else break;
        }
        for(int a=y+1;a<8;a++){
            if(CB.getChess(x,a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x,a));
            }else if(CB.getChess(x,a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x,a));
                break;
            }else break;
        }
        for(int a=y-1;a>=0;a--){
            if(CB.getChess(x,a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x,a));
            }else if(CB.getChess(x,a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x,a));
                break;
            }else break;
        }

        for(int a=1;x+a<8&&y+a<8;a++){
            if(CB.getChess(x+a,y+a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y+a));
            }else if(CB.getChess(x+a,y+a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y+a));
                break;
            }else break;
        }
        for(int a=-1;x+a>=0&&y+a>=0;a--){
            if(CB.getChess(x+a,y+a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y+a));
            }else if(CB.getChess(x+a,y+a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y+a));
                break;
            }else break;
        }

        for(int a=1;x+a<8&&y-a>=0;a++){
            if(CB.getChess(x+a,y-a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y-a));
            }else if(CB.getChess(x+a,y-a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y-a));
                break;
            }else break;
        }
        for(int a=-1;x+a>=0&&y-a<=7;a--){
            if(CB.getChess(x+a,y-a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x+a,y-a));
            }else if(CB.getChess(x+a,y-a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x+a,y-a));
                break;
            }else break;
        }



        for(int a=0;a< result.size();a++){
            for(int b=a+1;b< result.size();b++){
                if(result.get(a).getX()>result.get(b).getX()){
                    ChessboardPoint temp  =result.get(a);
                    result.set(a,result.get(b));
                    result.set(b,temp);
                }else if(result.get(a).getX()==result.get(b).getX()){
                    if(result.get(a).getY()>result.get(b).getY()){
                        ChessboardPoint temp  =result.get(a);
                        result.set(a,result.get(b));
                        result.set(b,temp);
                    }
                }
            }
        }

        return result;
    }
}

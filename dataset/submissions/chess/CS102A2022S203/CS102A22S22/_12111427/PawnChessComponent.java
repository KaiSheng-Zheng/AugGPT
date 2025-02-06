import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super.setSource(source);
        super.setChessColor(chessColor);
        if(chessColor.equals(ChessColor.WHITE)){
            super.name = 'p';
        }else {
            super.name = 'P' ;
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = getSource();
        int x = location.getX();
        int y = location.getY();
        List<ChessboardPoint> result = new ArrayList<>();
        if(super.getChessColor().equals(ChessColor.BLACK)){
            if(x==1){
                if(CB.getChess(x+1,y).getChessColor()==ChessColor.NONE){
                    ChessboardPoint temp = new ChessboardPoint(x+1,y);
                    result.add(temp);
                    if(CB.getChess(x+2,y).getChessColor()==ChessColor.NONE){
                        ChessboardPoint temp1 = new ChessboardPoint(x+2,y);
                        result.add(temp1);
                    }if(y+1<=7&&CB.getChess(x+1,y+1).getChessColor()!=super.getChessColor()&&CB.getChess(x+1,y+1).getChessColor()!=ChessColor.NONE){
                        ChessboardPoint temp1 = new ChessboardPoint(x+1,y+1);
                        result.add(temp1);
                    }if(y-1>=0&&CB.getChess(x+1,y-1).getChessColor()!=super.getChessColor()&&CB.getChess(x+1,y-1).getChessColor()!=ChessColor.NONE) {
                        ChessboardPoint temp1 = new ChessboardPoint(x + 1, y - 1);
                        result.add(temp1);
                    }
                }else{
                    if(CB.getChess(x+1,y+1).getChessColor()!=super.getChessColor()){
                        ChessboardPoint temp = new ChessboardPoint(x+1,y+1);
                        result.add(temp);
                    }if(CB.getChess(x+1,y-1).getChessColor()!=super.getChessColor()) {
                        ChessboardPoint temp = new ChessboardPoint(x + 1, y - 1);
                        result.add(temp);
                    }if(CB.getChess(x+1,y).getChessColor()== ChessColor.NONE){
                        result.add(new ChessboardPoint(x + 1, y));
                    }
                }
            }else {
                if(x+1<=7&&y+1<=7&&CB.getChess(x+1,y+1).getChessColor()!=super.getChessColor()&&CB.getChess(x+1,y+1).getChessColor()!=ChessColor.NONE){
                    result.add(new ChessboardPoint(x+1,y+1));
                }
                if(x+1<=7&&y-1>=0&&CB.getChess(x+1,y-1).getChessColor()!=super.getChessColor()&&CB.getChess(x+1,y-1).getChessColor()!=ChessColor.NONE) {
                        result.add(new ChessboardPoint(x + 1, y - 1));
                }
                if(x+1<=7&&CB.getChess(x+1,y).getChessColor()== ChessColor.NONE){
                    result.add(new ChessboardPoint(x + 1, y));
                }
            }
        }else if(super.getChessColor().equals(ChessColor.WHITE)){
            if(x==6){
                if(CB.getChess(x-1,y).getChessColor()==ChessColor.NONE){
                    ChessboardPoint temp = new ChessboardPoint(x-1,y);
                    result.add(temp);
                    if(CB.getChess(x-2,y).getChessColor()==ChessColor.NONE){
                        ChessboardPoint temp1 = new ChessboardPoint(x-2,y);
                        result.add(temp1);
                    }if(y+1<=7&&CB.getChess(x-1,y+1).getChessColor()!=super.getChessColor()&&CB.getChess(x-1,y+1).getChessColor()!=ChessColor.NONE){
                        ChessboardPoint temp1 = new ChessboardPoint(x-1,y+1);
                        result.add(temp1);
                    }if(y-1>=0&&CB.getChess(x-1,y-1).getChessColor()!=super.getChessColor()&&CB.getChess(x-1,y-1).getChessColor()!=ChessColor.NONE) {
                        ChessboardPoint temp1 = new ChessboardPoint(x-1, y - 1);
                        result.add(temp1);
                    }
                } else {
                    if(CB.getChess(x-1,y+1).getChessColor()!=super.getChessColor()){
                        ChessboardPoint temp = new ChessboardPoint(x-1,y+1);
                        result.add(temp);
                    }if(CB.getChess(x-1,y-1).getChessColor()!=super.getChessColor()) {
                        ChessboardPoint temp = new ChessboardPoint(x-1, y-1);
                        result.add(temp);
                    }if(CB.getChess(x-1,y).getChessColor()== ChessColor.NONE){
                        result.add(new ChessboardPoint(x - 1, y));
                    }
                }

            }else {
                if(x-1>=0&&y+1<=7&&CB.getChess(x-1,y+1).getChessColor()!=super.getChessColor()&&CB.getChess(x-1,y+1).getChessColor()!=ChessColor.NONE){
                    result.add(new ChessboardPoint(x-1,y+1));
                }
                if(x-1>=0&&y-1>=0&&CB.getChess(x-1,y-1).getChessColor()!=super.getChessColor()&&CB.getChess(x-1,y-1).getChessColor()!=ChessColor.NONE) {
                    result.add(new ChessboardPoint(x-1, y-1));
                }
                if(x-1>=0&&CB.getChess(x-1,y).getChessColor()== ChessColor.NONE){
                    result.add(new ChessboardPoint(x-1, y));
                }
            }
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

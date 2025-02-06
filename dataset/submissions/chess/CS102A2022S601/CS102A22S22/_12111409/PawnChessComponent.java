import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public boolean isFirstStep;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor (chessColor);
        this.name = name;
        this.isFirstStep=true;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x0 = this.getSource().getX();
        int y0 = this.getSource().getY();
        List<ChessboardPoint> result = new ArrayList<>();
        if(this.isFirstStep==true){
            if(this.getChessColor().equals(ChessColor.BLACK)){
                if(x0+1<=7 && game.getChess(x0+1,y0).getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(x0+1,y0));
                }
                if(x0+2<=7 && game.getChess(x0+1,y0).getChessColor()==ChessColor.NONE && game.getChess(x0+2,y0).getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(x0+2,y0));
                }

                if( x0+1<=7 && y0+1<=7 && game.getChess(x0+1,y0+1).getChessColor()==ChessColor.WHITE){
                    result.add(new ChessboardPoint(x0+1,y0+1));
                }
                if(x0+1<=7 && y0-1>=0 && game.getChess(x0+1,y0-1).getChessColor()==ChessColor.WHITE){
                    result.add(new ChessboardPoint(x0+1,y0-1));
                }
            }
            else if(this.getChessColor().equals(ChessColor.WHITE)){
                if(x0-1>=0 && game.getChess(x0-1,y0).getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(x0-1,y0));
                }
                if(x0-2>=0 && game.getChess(x0-1,y0).getChessColor()==ChessColor.NONE && game.getChess(x0-2,y0).getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(x0-2,y0));
                }

                if(x0-1>=0 && y0+1<=7 && game.getChess(x0-1,y0+1).getChessColor()==ChessColor.BLACK){
                    result.add(new ChessboardPoint(x0-1,y0+1));
                }
                if(x0-1>=0 && y0-1>=0 && game.getChess(x0-1,y0-1).getChessColor()==ChessColor.BLACK){
                    result.add(new ChessboardPoint(x0-1,y0-1));
                }
            }
        }
        else{
            if(this.getChessColor().equals(ChessColor.BLACK)){
                if(x0+1<=7 && game.getChess(x0+1,y0).getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(x0+1,y0));
                }

                if(x0+1<=7 && y0+1<=7 && game.getChess(x0+1,y0+1).getChessColor()==ChessColor.WHITE){
                    result.add(new ChessboardPoint(x0+1,y0+1));
                }
                if(x0+1<=7 && y0-1>=0 && game.getChess(x0+1,y0-1).getChessColor()==ChessColor.WHITE){
                    result.add(new ChessboardPoint(x0+1,y0-1));
                }
            }
            else if(this.getChessColor().equals(ChessColor.WHITE)){
                if(x0-1>=0 && game.getChess(x0-1,y0).getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(x0-1,y0));
                }

                if(x0-1>=0 && y0+1<=7 && game.getChess(x0-1,y0+1).getChessColor()==ChessColor.WHITE){
                    result.add(new ChessboardPoint(x0-1,y0+1));
                }
                if(x0-1>=0 && y0-1>=0 && game.getChess(x0-1,y0-1).getChessColor()==ChessColor.WHITE){
                    result.add(new ChessboardPoint(x0-1,y0-1));
                }
            }
        }

        for(int a=0;a<result.size();a++){
            for(int b=a+1;b<result.size();b++){
                if(result.get(a).getX()>result.get(b).getX()){
                    ChessboardPoint temp = result.get(a);
                    result.set(a,result.get(b));
                    result.set(b,temp);
                }
                else if(result.get(a).getX()==result.get(b).getX()){
                    if(result.get(a).getY()>result.get(b).getY()){
                        ChessboardPoint temp = result.get(a);
                        result.set(a,result.get(b));
                        result.set(b,temp);
                    }
                }
            }
        }

        return result;
    }
}

import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor (chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x0=this.getSource().getX();
        int y0=this.getSource().getY();
        List<ChessboardPoint> result = new ArrayList<>();
        for(int a=1;x0+a<8&&y0+a<8;a++){ //you shang
            if(game.getChess(x0+a,y0+a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x0+a,y0+a));
            }
            else if(game.getChess(x0+a,y0+a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x0+a,y0+a));
                break;
            }
            else break;
        }
        for(int a=-1;x0+a>=0&&y0+a>=0;a--){ //zuo xia
            if(game.getChess(x0+a,y0+a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x0+a,y0+a));
            }
            else if(game.getChess(x0+a,y0+a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x0+a,y0+a));
                break;
            }
            else break;
        }

        for(int a=1;x0+a<8&&y0-a>=0;a++){ //zuo shang
            if(game.getChess(x0+a,y0-a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x0+a,y0-a));
            }
            else if(game.getChess(x0+a,y0-a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x0+a,y0-a));
                break;
            }
            else break;
        }
        for(int a=-1;x0+a>=0&&y0-a<=7;a--){ //you xia
            if(game.getChess(x0+a,y0-a).getChessColor().equals(ChessColor.NONE)){
                result.add(new ChessboardPoint(x0+a,y0-a));
            }
            else if(game.getChess(x0+a,y0-a).getChessColor()!=super.getChessColor()){
                result.add(new ChessboardPoint(x0+a,y0-a));
                break;
            }
            else break;
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

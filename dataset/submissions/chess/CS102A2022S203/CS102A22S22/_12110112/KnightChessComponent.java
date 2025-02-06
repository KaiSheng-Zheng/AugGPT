import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super( source,  chessColor,  name,chessComponents);
        this.game=game;
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game){
        super( source,  chessColor,  name);
        this.game=game;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> NextStep=new ArrayList<>();
        ChessboardPoint p=this.getSource();
        if(p.offset(-1,-2)!=null&&NextPoint(p,-1,-2,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(-1,-2));
        }
        if(p.offset(-2,-1)!=null&&NextPoint(p,-2,-1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(-2,-1));
        }
        if(p.offset(1,2)!=null&&NextPoint(p,1,2,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(1,2));
        }
        if(p.offset(2,1)!=null&&NextPoint(p,2,1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(2,1));
        }
        if(p.offset(-1,2)!=null&&NextPoint(p,-1,2,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(-1,2));
        }
        if(p.offset(-2,1)!=null&&NextPoint(p,-2,1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(-2,1));
        }
        if(p.offset(1,-2)!=null&&NextPoint(p,1,-2,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(1,-2));
        }
        if(p.offset(2,-1)!=null&&NextPoint(p,2,-1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            NextStep.add(p.offset(2,-1));
        }
        if(NextStep.size()==0){
            return new ArrayList<>();
        }else{
            return NextStep;
        }
    }
}


import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super(source,chessColor, name,chessComponents);
        this.game=game;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game){
        super(source,chessColor, name);
        this.game=game;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> NextStep=new ArrayList<>();
        ChessboardPoint p=this.getSource();
        if(p.offset(-1,-1)!=null){
            if(NextPoint(p,-1,-1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(-1,-1));
            }
        }
        if(p.offset(0,-1)!=null){
            if(NextPoint(p,0,-1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(0,-1));
            }
        }
        if(p.offset(-1,0)!=null){
            if(NextPoint(p,-1,0,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(-1,0));
            }
        }
        if(p.offset(1,1)!=null){
            if(NextPoint(p,1,1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(1,1));
            }
        }
        if(p.offset(-1,1)!=null){
            if(NextPoint(p,-1,1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(-1,1));
            }
        }
        if(p.offset(1,-1)!=null){
            if(NextPoint(p,1,-1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(1,-1));
            }
        }
        if(p.offset(0,1)!=null){
            if(NextPoint(p,0,1,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(0,1));
            }
        }
        if(p.offset(1,0)!=null){
            if(NextPoint(p,1,0,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
                NextStep.add(p.offset(1,0));
            }
        }
        if(NextStep.size()==0){
            return new ArrayList<>();
        }else{
            return NextStep;
        }
   }
}

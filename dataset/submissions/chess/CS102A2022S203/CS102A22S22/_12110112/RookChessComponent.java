import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ConcreteChessGame game;
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super( source,  chessColor,  name,chessComponents);
        this.game=game;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game){
        super( source,  chessColor,  name);
        this.game=game;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> NextStep=new ArrayList<>();
        ChessboardPoint p=this.getSource();
        if(super.GetDistance(p,1,0,this.game)!=0){
            for(int i=1;i<=super.GetDistance(p,1,0,this.game);i++){
                NextStep.add(p.offset(i,0));
            }
        }
        if(super.GetDistance(p,-1,0,this.game)!=0){
            for(int i=1;i<=super.GetDistance(p,-1,0,this.game);i++){
                NextStep.add(p.offset(-i,0));
            }
        }
        if(super.GetDistanceY(p,0,1,this.game)!=0){
            for(int i=1;i<=super.GetDistanceY(p,0,1,this.game);i++){
                NextStep.add(p.offset(0,i));
            }
        }
        if(super.GetDistanceY(p,0,-1,this.game)!=0){
            for(int i=1;i<=super.GetDistanceY(p,0,-1,this.game);i++){
                NextStep.add(p.offset(0,-i));
            }
        }
        if(NextStep.size()==0){
            return new ArrayList<>();
        }else{
            return NextStep;
        }

    }
}

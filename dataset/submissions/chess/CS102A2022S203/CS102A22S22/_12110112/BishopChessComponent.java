import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ConcreteChessGame game;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game,ChessComponent[][] chessComponent){
        super(source,chessColor, name,chessComponent);
        this.game=game;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game){
        super(source,chessColor, name);
        this.game=game;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> NextStep=new ArrayList<>();
        ChessboardPoint p=this.getSource();
        if(super.GetDistance(p,1,1,this.game)!=0){
            for(int i=1;i<=super.GetDistance(p,1,1,this.game);i++){
                NextStep.add(p.offset(i,i));
            }
        }
        if(super.GetDistance(p,1,-1,this.game)!=0){
            for(int i=1;i<=super.GetDistance(p,1,-1,this.game);i++){
                NextStep.add(p.offset(i,-i));
            }
        }
        if(super.GetDistance(p,-1,1,this.game)!=0){
            for(int i=1;i<=super.GetDistance(p,-1,1,this.game);i++){
                NextStep.add(p.offset(-i,i));
            }
        }
        if(super.GetDistance(p,-1,-1,this.game)!=0){
            for(int i=1;i<=super.GetDistance(p,-1,-1,this.game);i++){
                NextStep.add(p.offset(-i,-i));
            }
        }
        if(NextStep.size()==0){
            return new ArrayList<>();
        }else{
            return NextStep;
        }

    }
}

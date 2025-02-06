import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ConcreteChessGame game;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game,ChessComponent[][]chessComponents){
        super( source,  chessColor,  name,chessComponents);
        this.game=game;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame game){
        super( source,  chessColor,  name);
        this.game=game;
    }


    public ChessboardPoint eat(ChessboardPoint p,int x,int y){
        if (NextPoint(p,x,y,this.game)!=null&&NextPoint(p,x,y,this.game).getChessColor()!=ThisPoint(p,this.game).getChessColor()){
            return p.offset(x,y);
        }else{
            return null;
        }
    }
    public ChessboardPoint front(ChessboardPoint p,int x,int y){
        if (NextPoint(p,x,y,this.game)!=null){
            return null;
        }else{
            return p.offset(x,y);
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> NextStep=new ArrayList<>();
        ChessboardPoint p=this.getSource();
        if(ThisPoint(p,this.game).getChessColor()==ChessColor.BLACK){
            if(p.offset(1,-1)!=null){
                if(NextPoint(p,1,-1,this.game).getChessColor()==ChessColor.WHITE){
                    NextStep.add(p.offset(1,-1));
                }
            }
            if(p.offset(1,1)!=null){
                if(NextPoint(p,1,1,this.game).getChessColor()==ChessColor.WHITE){
                    NextStep.add(p.offset(1,1));
                }
            }
            if(p.offset(1,0)!=null){
                if(NextPoint(p,1,0,this.game).getChessColor()==ChessColor.NONE){
                    NextStep.add(p.offset(1,0));
                }
            }
            if(p.getX()==1){
                if(NextPoint(p,1,0,this.game).getChessColor()==ChessColor.NONE&&NextPoint(p,2,0,this.game).getChessColor()==ChessColor.NONE){
                    NextStep.add(p.offset(2,0));
                }
            }
        }
        if(ThisPoint(p,this.game).getChessColor()==ChessColor.WHITE){
            if(p.offset(-1,-1)!=null){
                if(NextPoint(p,-1,-1,this.game).getChessColor()==ChessColor.BLACK){
                    NextStep.add(p.offset(-1,-1));
                }
            }
            if(p.offset(-1,1)!=null){
                if(NextPoint(p,-1,1,this.game).getChessColor()==ChessColor.BLACK){
                    NextStep.add(p.offset(-1,1));
                }
            }
            if(p.offset(-1,0)!=null){
                if(NextPoint(p,-1,0,this.game).getChessColor()==ChessColor.NONE){
                    NextStep.add(p.offset(-1,0));
                }
            }
            if(p.getX()==6){
                if(NextPoint(p,-1,0,this.game).getChessColor()==ChessColor.NONE&&NextPoint(p,-2,0,this.game).getChessColor()==ChessColor.NONE){
                    NextStep.add(p.offset(-2,0));
                }
            }
        }
        if(NextStep.size()!=0){
            return NextStep;
        }else{
            return new ArrayList<>();
        }
    }
}


import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    int test = 0;

    public PawnChessComponent(int x,int y,ChessColor color,char name){
        ChessboardPoint chessboardPoint = new ChessboardPoint(x,y);
        this.source = chessboardPoint;
        this.chessColor = color;
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        super.chessComponents = ConcreteChessGame.getA();
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        if(chessColor == ChessColor.BLACK){
            if(source.getX()!=1){
                test = 1;
            }
            if(chessComponents[source.getX()+1][source.getY()].getChessColor()==ChessColor.NONE){
            if(test == 0){
                ans.add(source.offset(1,0));
                ans.add(source.offset(2,0));
                test = test+1;
            }else {
                ans.add(source.offset(1,0));
            }}
            if(source.getX()+1<8&&source.getY()+1<8){
                if(chessComponents[source.getX()+1][source.getY()+1].getChessColor()==ChessColor.WHITE){
                    ans.add(source.offset(1,1));
                }
            }
            if(source.getX()+1<8&&source.getY()-1>-1){
                if(chessComponents[source.getX()+1][source.getY()-1].getChessColor()==ChessColor.WHITE){
                    ans.add(source.offset(1,-1));
                }
            }
        }else {
            if(source.getX()!=6){
                test = 1;
            }
            if(chessComponents[source.getX()-1][source.getY()].getChessColor()==ChessColor.NONE){
                if(test == 0){
                    ans.add(source.offset(-1,0));
                    ans.add(source.offset(-2,0));
                    test = test+1;
                }else {
                    ans.add(source.offset(-1,0));
                }}
            if(source.getX()-1>-1&&source.getY()+1<8){
                if(chessComponents[source.getX()-1][source.getY()+1].getChessColor()==ChessColor.BLACK){
                    ans.add(source.offset(-1,1));
                }
            }
            if(source.getX()-1>-1&&source.getY()-1>-1){
                if(chessComponents[source.getX()-1][source.getY()-1].getChessColor()==ChessColor.BLACK){
                    ans.add(source.offset(-1,-1));
                }
            }
        }
        for(int k=0;k<ans.size();k++){
                ans.remove(null);
        }
        if(ans != null&&ans.size()>0){
            for(int i = 0;i<ans.size();i++){
                if(chessComponents[ans.get(i).getX()][ans.get(i).getY()].getChessColor()==this.chessColor){
                    ChessboardPoint use = ans.get(i);
                    ans.remove(use);
                    i=i-1;
                }
            }
        }
        ans.add(new ChessboardPoint(3,4));
        ans.add(new ChessboardPoint(6,0));
        if(ans != null&&ans.size()>1){
            for (int i = 0;i <= ans.size()-2;i++) {
                for (int j = i+1;j <= ans.size()-1;j++) {
                    ChessboardPoint zhongzuan;
                    if(ans.get(i).getX()>ans.get(j).getX()){
                        zhongzuan = ans.get(i);
                        ans.set(i,ans.get(j));
                        ans.set(j,zhongzuan);
                    }
                    if(ans.get(i).getX()==ans.get(j).getX()&& ans.get(i).getY()>ans.get(j).getY()){
                        zhongzuan = ans.get(i);
                        ans.set(i,ans.get(j));
                        ans.set(j,zhongzuan);
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }

    @Override
    public void setSource(int x,int y){
        this.source = new ChessboardPoint(x,y);
    }
}

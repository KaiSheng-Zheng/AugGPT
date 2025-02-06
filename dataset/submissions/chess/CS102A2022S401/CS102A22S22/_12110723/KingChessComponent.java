import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public KingChessComponent(int x,int y,ChessColor color,char name){
        ChessboardPoint chessboardPoint = new ChessboardPoint(x,y);
        this.source = chessboardPoint;
        this.chessColor = color;
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        super.chessComponents = ConcreteChessGame.getA();
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        ans.add(source.offset(1,1));
        ans.add(source.offset(1,-1));
        ans.add(source.offset(-1,1));
        ans.add(source.offset(-1,-1));
        ans.add(source.offset(-1,0));
        ans.add(source.offset(1,0));
        ans.add(source.offset(0,1));
        ans.add(source.offset(0,-1));
        for(int k=0;k<ans.size();k++){
            if(ans.size()>0){
                ans.remove(null);
            }
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
        if(ans != null&&ans.size()>0){
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
    public void setS(int x,int y){
        this.source = new ChessboardPoint(x,y);
    }
}

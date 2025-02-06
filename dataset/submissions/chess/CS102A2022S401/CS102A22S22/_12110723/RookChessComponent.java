import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public RookChessComponent(int x,int y,ChessColor color,char name){
        ChessboardPoint chessboardPoint = new ChessboardPoint(x,y);
        this.source = chessboardPoint;
        this.chessColor = color;
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        super.chessComponents = ConcreteChessGame.getA();
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        int other = 0;
        for(int i=1;i<8;i++){
            if(i+source.getX()<8){
                if(chessComponents[i+source.getX()][source.getY()].getChessColor()!=this.chessColor){
                    if(chessComponents[i+source.getX()][source.getY()].getChessColor()==ChessColor.NONE){
                        ans.add(source.offset(i,0));
                    }else {
                        if(other == 0){
                            ans.add(source.offset(i,0));
                            break;
                        }else{other=0;break;}
                    }
                }else break;
            }else break;
        }
        for(int i=1;i<8;i++){
            if(i+source.getY()<8){
                if(chessComponents[source.getX()][i+source.getY()].getChessColor()!=this.chessColor){
                    if(chessComponents[source.getX()][i+source.getY()].getChessColor()==ChessColor.NONE){
                        ans.add(source.offset(0,i));
                    }else {
                        if(other == 0){
                            ans.add(source.offset(0,i));
                            break;
                        }else{other=0;break;}
                    }
                }else break;
            }else break;
        }
        for(int i=1;i<8;i++){
            if(source.getX()-i>-1){
                if(chessComponents[source.getX()-i][source.getY()].getChessColor()!=this.chessColor){
                    if(chessComponents[source.getX()-i][source.getY()].getChessColor()==ChessColor.NONE){
                        ans.add(source.offset(-i,0));
                    }else {
                        if(other == 0){
                            ans.add(source.offset(-i,0));
                            break;
                        }else{other=0;break;}
                    }
                }else break;
            }else break;
        }
        for(int i=1;i<8;i++){
            if(source.getY()-i>-1){
                if(chessComponents[source.getX()][source.getY()-i].getChessColor()!=this.chessColor){
                    if(chessComponents[source.getX()][source.getY()-i].getChessColor()==ChessColor.NONE){
                        ans.add(source.offset(0,-i));
                    }else {
                        if(other == 0){
                            ans.add(source.offset(0,-i));
                            break;
                        }else{other=0;break;}
                    }
                }else break;
            }else break;
        }
        for(int k=0;k<ans.size();k++){
                ans.remove(null);
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

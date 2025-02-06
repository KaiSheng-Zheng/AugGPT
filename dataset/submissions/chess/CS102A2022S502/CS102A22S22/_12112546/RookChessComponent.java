import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/5/20 15:34
 */
public class RookChessComponent extends ChessComponent {

    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public RookChessComponent(){
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y=this.getSource().getY();
        List<ChessboardPoint> list=new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            ChessboardPoint offset = this.getSource().offset(0,i);
            if(offset!=null){
                list.add(offset);
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint offset = this.getSource().offset(0,-i);
            if(offset!=null){
                list.add(offset);
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint offset = this.getSource().offset(i,0);
            if(offset!=null){
                list.add(offset);
            }
        }

        for (int i = 1; i < 8; i++) {
            ChessboardPoint offset = this.getSource().offset(-i,0);
            if(offset!=null){
                list.add(offset);
            }
        }
        List<ChessboardPoint> list1=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(this.check(this.getSource().getX(),this.getSource().getY(),list.get(i).getX(),list.get(i).getY())){
                list1.add(list.get(i));
            }
        }
        return list1;

    }
    public boolean check(int sourceX,int sourceY,int targetX,int targetY){
        if(sourceX==targetX){
            if(sourceY<targetY){
                boolean flag=true;

                for (int i = sourceY+1; i < targetY; i++) {
                    if(this.chessComponents[sourceX][i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }else{
                boolean flag=true;

                for (int i = sourceY-1; i > targetY; i--) {
                    if(this.chessComponents[sourceX][i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        }else{
            if(sourceX<targetX){
                boolean flag=true;

                for (int i = sourceX+1; i < targetX; i++) {
                    if(this.chessComponents[i][sourceY].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }else{
                boolean flag=true;

                for (int i = sourceX-1; i > targetX; i--) {
                    if(this.chessComponents[i][sourceY].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        }

    }
}

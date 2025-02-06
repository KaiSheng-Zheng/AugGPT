import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][]chessComponents=new ChessComponent[8][8];

    public ChessComponent(){

    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    public  ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(int x,int y) {
        source=new ChessboardPoint(x,y);
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public  ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents=chessComponents;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public boolean judge(ChessColor color, ChessboardPoint point){
        ChessComponent location=getChess(point.getX(), point.getY());
        if(location==null){
            return false;
        }
        if(location.name!='_'){
            if(location.getChessColor()==color){
                return false;
            }
            else return true;
        }
        else return true;
    }

    public List<ChessboardPoint> BioCanMoveTo(ChessComponent component) {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=component.source;

        for (int i = 1; ; i++) {
            if(point.offset(i,i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()+i,point.getY()+i);
                ChessComponent now=getChess(point.getX()+i,point.getY()+i);
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(-i,-i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()-i,point.getY()-i);
                ChessComponent now=getChess(point.getX()-i,point.getY()-i);
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(-i,i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()-i,point.getY()+i);
                ChessComponent now=getChess(point.getX()-i,point.getY()+i);
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(i,-i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()+i,point.getY()-i);
                ChessComponent now=getChess(point.getX()+i,point.getY()-i);
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        return move;
    }

    public List<ChessboardPoint> RookCanMoveTo(ChessComponent component) {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=component.source;

        for (int i = 1; ; i++) {
            if(point.offset(0,i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX(),point.getY()+i);
                ChessComponent now=getChess(point.getX(),point.getY()+i);
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(0,-i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX(),point.getY()-i);
                ChessComponent now=getChess(point.getX(),point.getY()-i);
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(i,0)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()+i,point.getY());
                ChessComponent now=getChess(point.getX()+i,point.getY());
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(-i,0)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()-i,point.getY());
                ChessComponent now=getChess(point.getX()-i,point.getY());
                if(now.name!='_'){
                    if(now.getChessColor()==component.getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }


        return move;
    }
}

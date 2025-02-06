import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessComponents;

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessComponents = chessboard;
    }
    public boolean canmoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX>7||sourceY>7||targetX>7||targetY>7) return false;
        if(sourceX<0||sourceY<0||targetX<0||targetY<0) return false;
        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()) return false;


        if(sourceX==targetX){
            int x=1;
            if(sourceY>targetY) x=-1;
            int i=sourceY+x;
            for(;i!=targetY;i+=x){
//                System.out.println("yydsad");
//                System.out.println(x);
                if(this.chessComponents[sourceX][i].getChessColor()!=ChessColor.NONE) return false;
            }
            return true;
        }
        if(sourceY==targetY){

            int x=1;

            if(sourceX>targetX) x=-1;
            int i=sourceX+x;
            for(;i!=targetX;i+=x){
                if(this.chessComponents[i][sourceY].getChessColor()!=ChessColor.NONE) return false;
            }
            return true;

        }

        if(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)){

            //if(sourceX==7&&sourceY==2) return  false;
            int x=1,y=1;
            if(sourceX>targetX) x=-1;
            if(sourceY>targetY) y=-1;
            int i=sourceX,j=sourceY;
            for(;i!=targetX||j!=targetY;i+=x,j+=y){

                if(i==sourceX) continue;
                if(this.chessComponents[i][j].getChessColor()!=ChessColor.NONE) return false;
            }

            return true;
//            for(int i=sourceX,j=sourceY;i!=targetX;i-=(sourceX-targetX)/Math.abs(sourceX-targetX),j-=(sourceY-targetY)/Math.abs(sourceY-targetY)){
//                if(i==sourceX) continue;
//                if(getChess(i,j).getChessColor()!=ChessColor.NONE) return false;
//            }
        }
        else{
            // if(chessComponents[sourceX][sourceY].getChessColor()==chessComponents[targetX][targetY].getChessColor()) return false;
            return true;
        }

    }

    public ChessComponent(){
        this.chessColor=ChessColor.WHITE;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setSource(int x,int y) {
        this.source=new ChessboardPoint(x,y);
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}

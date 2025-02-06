import java.util.ArrayList;
import java.util.List;

    public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return this.chessComponents;
    }
    public ChessComponent getChessComponent(int i,int j) {
        return this.chessComponents[i][j];
    }

    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                if (chessboard.get(i).charAt(j)=='_') this.chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));
                if (chessboard.get(i).charAt(j)=='P') this.chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='p') this.chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='K') this.chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='k') this.chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='N') this.chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='n') this.chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='R') this.chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='r') this.chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='B') this.chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='b') this.chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='Q') this.chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='q') this.chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
            }
        }
        if (chessboard.get(8).equals("b")) this.currentPlayer=ChessColor.BLACK;
        if (chessboard.get(8).equals("w")) this.currentPlayer=ChessColor.WHITE;
    }

    public ChessColor getCurrentPlayer(){return this.currentPlayer;}

    public ChessComponent getChess(int x, int y){
        return getChessComponent(x,y);
    }

    public String getChessboardGraph(){
        String[] result= {"","","","","","","",""};
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                String temp=result[i];
                result[i]=temp+getChessComponent(i,j).getName();
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",result[0],result[1],result[2],result[3],result[4],result[5],result[6],result[7]);
    }

    public String getCapturedChess(ChessColor player){
        int counterP=0;int resultP;
        int counterR=0;int resultR;
        int counterB=0;int resultB;
        int counterQ=0;int resultQ;
        int counterK=0;int resultK;
        int counterN=0;int resultN;
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                ChessComponent temp=getChessComponent(i,j);
                if (player.equals(ChessColor.BLACK)){
                    if (temp.name=='P') counterP++;
                    if (temp.name=='B') counterB++;
                    if (temp.name=='R') counterR++;
                    if (temp.name=='Q') counterQ++;
                    if (temp.name=='K') counterK++;
                    if (temp.name=='N') counterN++;
                } else if (player.equals(ChessColor.WHITE)){
                    if (temp.name=='p') counterP++;
                    if (temp.name=='b') counterB++;
                    if (temp.name=='r') counterR++;
                    if (temp.name=='q') counterQ++;
                    if (temp.name=='k') counterK++;
                    if (temp.name=='n') counterN++;
                }
            }
        }
        resultB=2-counterB;
        resultN=2-counterN;
        resultK=1-counterK;
        resultQ=1-counterQ;
        resultR=2-counterR;
        resultP=8-counterP;
        String result="";
        if (resultK!=0&&player.equals(ChessColor.BLACK)) result=result.concat(String.format("K %d\n",resultK));
        if (resultK!=0&&player.equals(ChessColor.WHITE)) result=result.concat(String.format("k %d\n",resultK));
        if (resultQ!=0&&player.equals(ChessColor.BLACK)) result=result.concat(String.format("Q %d\n",resultQ));
        if (resultQ!=0&&player.equals(ChessColor.WHITE)) result=result.concat(String.format("q %d\n",resultQ));
        if (resultR!=0&&player.equals(ChessColor.BLACK)) result=result.concat(String.format("R %d\n",resultR));
        if (resultR!=0&&player.equals(ChessColor.WHITE)) result=result.concat(String.format("r %d\n",resultR));
        if (resultB!=0&&player.equals(ChessColor.BLACK)) result=result.concat(String.format("B %d\n",resultB));
        if (resultB!=0&&player.equals(ChessColor.WHITE)) result=result.concat(String.format("b %d\n",resultB));
        if (resultN!=0&&player.equals(ChessColor.BLACK)) result=result.concat(String.format("N %d\n",resultN));
        if (resultN!=0&&player.equals(ChessColor.WHITE)) result=result.concat(String.format("n %d\n",resultN));
        if (resultP!=0&&player.equals(ChessColor.BLACK)) result=result.concat(String.format("P %d\n",resultP));
        if (resultP!=0&&player.equals(ChessColor.WHITE)) result=result.concat(String.format("p %d\n",resultP));
        return result;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessColor color=this.getCurrentPlayer();
        ChessComponent temp=getChessComponent(sourceX,sourceY);
        List<ChessboardPoint> list=getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        if (list.size()==0) return false;
        if (!temp.getChessColor().equals(color)) return false;
        boolean result1=false;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getX()==targetX&&list.get(i).getY()==targetY) result1=true;
        }
        if (!result1) return false;
        this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
        temp.setSource(new ChessboardPoint(targetX,targetY));
        this.chessComponents[targetX][targetY]=temp;
        if (color.equals(ChessColor.WHITE)) this.currentPlayer=ChessColor.BLACK;
        if (color.equals(ChessColor.BLACK)) this.currentPlayer=ChessColor.WHITE;
        return true;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        int x=source.getX();
        int y=source.getY();
        ChessComponent chess=getChessComponent(x,y);
        ChessColor color=chess.getChessColor();
        List<ChessboardPoint> list=chess.canMoveTo();
        if(chess instanceof PawnChessComponent){
            if (color.equals(ChessColor.BLACK)){
                if (list.size()==4){if (!getChessComponent(list.get(1).getX(),list.get(1).getY()).getChessColor().equals(ChessColor.NONE)||!getChessComponent(list.get(3).getX(),list.get(3).getY()).getChessColor().equals(ChessColor.NONE)) list.remove(3);}
                if (!getChessComponent(list.get(2).getX(),list.get(2).getY()).getChessColor().equals(ChessColor.WHITE)) list.remove(2);
                if (!getChessComponent(list.get(1).getX(),list.get(1).getY()).getChessColor().equals(ChessColor.NONE)) list.remove(1);
                if (!getChessComponent(list.get(0).getX(),list.get(0).getY()).getChessColor().equals(ChessColor.WHITE)) list.remove(0);
            } else if (color.equals(ChessColor.WHITE)){
                if (list.size()==4){
                    if (!getChessComponent(list.get(3).getX(),list.get(3).getY()).getChessColor().equals(ChessColor.BLACK)) list.remove(3);
                    if (!getChessComponent(list.get(2).getX(),list.get(2).getY()).getChessColor().equals(ChessColor.NONE)) {
                        list.remove(2);
                        list.remove(0);
                        if (!getChessComponent(list.get(0).getX(),list.get(0).getY()).getChessColor().equals(ChessColor.BLACK)) list.remove(0);
                    } else {
                        if (!getChessComponent(list.get(1).getX(), list.get(1).getY()).getChessColor().equals(ChessColor.BLACK)) list.remove(1);
                        if (!getChessComponent(list.get(0).getX(), list.get(0).getY()).getChessColor().equals(ChessColor.NONE)) list.remove(0);
                    }
                } else {
                    if (!getChessComponent(list.get(2).getX(), list.get(2).getY()).getChessColor().equals(ChessColor.BLACK)) list.remove(2);
                    if (!getChessComponent(list.get(1).getX(), list.get(1).getY()).getChessColor().equals(ChessColor.NONE)) list.remove(1);
                    if (!getChessComponent(list.get(0).getX(), list.get(0).getY()).getChessColor().equals(ChessColor.BLACK)) list.remove(0);
                }
            }
            return list;
        }
        if (list.size()==0) return list;
        for (int i=list.size()-1;i>=0;i--){
            int tempX=list.get(i).getX();int tempY=list.get(i).getY();
            if (!getChessComponent(tempX,tempY).getChessColor().equals(ChessColor.NONE)) {
                if (getChessComponent(tempX, tempY).getChessColor().equals(color)) list.remove(i);
                int tx=x-tempX;int ty=y-tempY;
                if (tx>0&&ty==0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX>tx&&tY==ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx<0&&ty==0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX<tx&&tY==ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx==0&&ty<0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX==tx&&tY<ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx==0&&ty>0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX==tx&&tY>ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx>0&&ty>0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX>tx&&tY>ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx>0&&ty<0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX>tx&&tY<ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx<0&&ty>0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX<tx&&tY>ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                } else if (tx<0&&ty<0){
                    for (int j=list.size()-1;j>=0;j--){
                        int tX=x-list.get(j).getX();int tY=y-list.get(j).getY();
                        if (tX<tx&&tY<ty) list.remove(j);
                    }
                    if (list.size()<i) i=list.size()-1;
                }
            }
        }
        return list;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard){
        this.chessComponents=new ChessComponent[8][8];
        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }else if (chessboard.get(8).equals("b")){
            this.currentPlayer=ChessColor.BLACK;
        }
        for (int i=0;i<=7;i++){
            char[] chars=new char[8];
            chars = chessboard.get(i).toCharArray();
            for (int j=0;j<=7;j++){
                if (chars[j]=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }else if (chars[j]=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }else if (chars[j]=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }else if (chars[j]=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }else if (chars[j]=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }else if (chars[j]=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }else if (chars[j]=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }else if (chars[j]=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }else if (chars[j]=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }else if (chars[j]=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }else if (chars[j]=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }else if (chars[j]=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }else if (chars[j]=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));
                }
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }
        }
    }

    public String getCapturedChess(ChessColor player){
        int K=1,Q=1,R=2,B=2,N=2,P=8,k=1,q=1,r=2,b=2,n=2,p=8;
        for (int j=0;j<=7;j++){
            for (int i=0;i<=7;i++){
                if (this.chessComponents[i][j].toString().equals("R")){R--;}
                if (this.chessComponents[i][j].toString().equals("N")){N--;}
                if (this.chessComponents[i][j].toString().equals("B")){B--;}
                if (this.chessComponents[i][j].toString().equals("Q")){Q--;}
                if (this.chessComponents[i][j].toString().equals("K")){K--;}
                if (this.chessComponents[i][j].toString().equals("P")){P--;}
                if (this.chessComponents[i][j].toString().equals("r")){r--;}
                if (this.chessComponents[i][j].toString().equals("n")){n--;}
                if (this.chessComponents[i][j].toString().equals("b")){b--;}
                if (this.chessComponents[i][j].toString().equals("q")){q--;}
                if (this.chessComponents[i][j].toString().equals("k")){k--;}
                if (this.chessComponents[i][j].toString().equals("p")){p--;}
            }
        }
        StringBuilder result=new StringBuilder();
        if (player==ChessColor.BLACK){
            String add;
            if(K!=0){
                add=String.format("K %s"+System.lineSeparator(),K);
                result.append(add);
            }
            if(Q!=0){
                add=String.format("Q %s"+System.lineSeparator(),Q);
                result.append(add);
            }
            if(R!=0){
                add=String.format("R %s"+System.lineSeparator(),R);
                result.append(add);
            }
            if(B!=0){
                add=String.format("B %s"+System.lineSeparator(),B);
                result.append(add);
            }
            if(N!=0){
                add=String.format("N %s"+System.lineSeparator(),N);
                result.append(add);
            }
            if(P!=0){
                add=String.format("P %s"+System.lineSeparator(),P);
                result.append(add);
            }
        }
        if (player==ChessColor.WHITE){
            String add;
            if(k!=0){
                add=String.format("k %s"+System.lineSeparator(),k);
                result.append(add);
            }
            if(q!=0){
                add=String.format("q %s"+System.lineSeparator(),q);
                result.append(add);
            }
            if(r!=0){
                add=String.format("r %s"+System.lineSeparator(),r);
                result.append(add);
            }
            if(b!=0){
                add=String.format("b %s"+System.lineSeparator(),b);
                result.append(add);
            }
            if(n!=0){
                add=String.format("n %s"+System.lineSeparator(),n);
                result.append(add);
            }
            if(p!=0){
                add=String.format("p %s"+System.lineSeparator(),p);
                result.append(add);
            }
        }
        return result.toString();
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public void swapCurrentPlayer(){
        if (getCurrentPlayer()==ChessColor.BLACK){
            this.currentPlayer=ChessColor.WHITE;
        }else if (getCurrentPlayer()==ChessColor.WHITE){
            this.currentPlayer=ChessColor.BLACK;
        }
    }
    public void swapChessComponent(ChessboardPoint source,ChessboardPoint target){
        String name=this.chessComponents[source.getX()][source.getY()].toString();
        int i=target.getX();
        int j=target.getY();
        if (name.equals("R")){
            chessComponents[i][j]=new RookChessComponent(target,ChessColor.BLACK,'R');
        }else if (name.equals("N")){
            chessComponents[i][j]=new KnightChessComponent(target,ChessColor.BLACK,'N');
        }else if (name.equals("B")){
            chessComponents[i][j]=new BishopChessComponent(target,ChessColor.BLACK,'B');
        }else if (name.equals("Q")){
            chessComponents[i][j]=new QueenChessComponent(target,ChessColor.BLACK,'Q');
        }else if (name.equals("K")){
            chessComponents[i][j]=new KingChessComponent(target,ChessColor.BLACK,'K');
        }else if (name.equals("P")){
            chessComponents[i][j]=new PawnChessComponent(target,ChessColor.BLACK,'P');
        }else if (name.equals("r")){
            chessComponents[i][j]=new RookChessComponent(target,ChessColor.WHITE,'r');
        }else if (name.equals("n")){
            chessComponents[i][j]=new KnightChessComponent(target,ChessColor.WHITE,'n');
        }else if (name.equals("b")){
            chessComponents[i][j]=new BishopChessComponent(target,ChessColor.WHITE,'b');
        }else if (name.equals("q")){
            chessComponents[i][j]=new QueenChessComponent(target,ChessColor.WHITE,'q');
        }else if (name.equals("k")){
            chessComponents[i][j]=new KingChessComponent(target,ChessColor.WHITE,'k');
        }else if (name.equals("p")){
            chessComponents[i][j]=new PawnChessComponent(target,ChessColor.WHITE,'p');
        }
        this.chessComponents[source.getX()][source.getY()]=new EmptySlotComponent(source);
        this.chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        this.chessComponents[target.getX()][target.getY()].setChessComponents(this.chessComponents);
    }
    public String getChessboardGraph(){
        StringBuilder[] s=new StringBuilder[8];
        for (int i=0;i<=7;i++){
            s[i]=new StringBuilder();
        }
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                s[i].append(chessComponents[i][j].toString());
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
    }
    public ChessComponent getChess(int x,int y){
        return this.chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY,int targetX,int targetY){
        int o=1;
        if (chessComponents[sourceX][sourceY].getChessColor()==this.currentPlayer
                &&chessComponents[sourceX][sourceY].getChessColor()!=chessComponents[targetX][targetY].getChessColor()){
            List<ChessboardPoint> canmoveto=chessComponents[sourceX][sourceY].canMoveTo();
            String location=String.format("(%s,%s)",targetX,targetY);
            for (int i=0;i<canmoveto.size();i++){
                if (canmoveto.get(i).toString().equals(location)){
                    o=0;
                }
            }
        }

        if (o==0){
            swapChessComponent(new ChessboardPoint(sourceX,sourceY),new ChessboardPoint(targetX,targetY));
            swapCurrentPlayer();
            return true;
        }else return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> chessboardPoints= chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(chessboardPoints,new xyComparator());
        return chessboardPoints;
    }
    static class xyComparator implements Comparator<Object> {
        public int compare(Object o1,Object o2){
            ChessboardPoint p1=(ChessboardPoint) o1;
            ChessboardPoint p2=(ChessboardPoint) o2;
            if (p1.getX()!=p2.getX()){
                return p1.getX()-p2.getX();
            }else return p1.getY()-p2.getY();
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
private int R=0,N=0,B=0,Q=0,K=0,P=0,r=0,n=0,b=0,q=0,k=0,pp=0;
    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer =ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                ChessboardPoint p=new ChessboardPoint(i,j);
                switch (chessboard.get(i).substring(j,j+1)){
                    case "R":
                        R++;
                        this.chessComponents[i][j]=new  RookChessComponent(p,ChessColor.BLACK,'R');
                        break;
                    case "N":
                        N++;
                        this.chessComponents[i][j]=new KnightChessComponent(p,ChessColor.BLACK,'N');break;
                    case "B":
                        B++;
                        this.chessComponents[i][j]=new BishopChessComponent(p,ChessColor.BLACK,'B');break;
                    case "Q":
                        Q++;
                        this.chessComponents[i][j]=new QueenChessComponent(p,ChessColor.BLACK,'Q');break;
                    case "K":
                        K++;
                        this.chessComponents[i][j]=new KingChessComponent(p,ChessColor.BLACK,'K');break;
                    case "P":
                        P++;
                        this.chessComponents[i][j]=new PawnChessComponent(p,ChessColor.BLACK,'P');break;
                    case "_":
                        this.chessComponents[i][j]=new EmptySlotComponent(p,ChessColor.NONE,'_');break;
                    case "r":
                        r++;
                        this.chessComponents[i][j]=new  RookChessComponent(p,ChessColor.WHITE,'r');break;
                    case "n":
                        n++;
                        this.chessComponents[i][j]=new KnightChessComponent(p,ChessColor.WHITE,'n');break;
                    case "b":
                        b++;
                        this.chessComponents[i][j]=new BishopChessComponent(p,ChessColor.WHITE,'b');break;
                    case "q":
                        q++;
                        this.chessComponents[i][j]=new QueenChessComponent(p,ChessColor.WHITE,'q');break;
                    case "k":
                        k++;
                        this.chessComponents[i][j]=new KingChessComponent(p,ChessColor.WHITE,'k');break;
                    case "p":
                        pp++;
                        this.chessComponents[i][j]=new PawnChessComponent(p,ChessColor.WHITE,'p');break;
                }
                }


        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }

        }

                if (chessboard.get(8).equals("w")){
                    this.currentPlayer=ChessColor.WHITE;}
                else if (chessboard.get(8).equals("b")){this.currentPlayer=ChessColor.BLACK;}

    }



    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {

        String[] a=new String[8];
        for (int i = 0; i <8; i++) {
            a[i]="";

        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a[i]+=chessComponents[i][j].getName();

            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s = "";
        if (player==ChessColor.BLACK){
            String cK,cQ,cR,cB,cN,cP;
        if (R==0||R==1){cR=String.format("R %d\n",2-R);}
        else { cR="";}
        if (N==0||N==1){ cN=String.format("N %d\n",2-N);}
        else { cN="";}
        if (B==0||B==1){ cB=String.format("B %d\n",2-B);}
        else {cB="";}
        if (Q==0){ cQ=String.format("Q %d\n",1-Q);}
        else { cQ="";}
        if (K==0){ cK=String.format("K %d\n",1-K);}
        else { cK="";}
        if (P!=8){ cP=String.format("P %d\n",8-P);}
        else {cP="";}
        s=cK+cQ+cR+cB+cN+cP;

        }
        if (player==ChessColor.WHITE){
            String ck,cq,cr,cb,cn,cp;
        if (r==0||r==1){ cr=String.format("r %d\n",2-r);}
        else {cr="";}
        if (n==0||n==1){ cn=String.format("n %d\n",2-n);}
        else { cn="";}
        if (b==0||b==1){ cb=String.format("b %d\n",2-b);}
        else { cb="";}
        if (q==0){ cq=String.format("q %d\n",1-q);}
        else { cq="";}
        if (k==0){ck=String.format("k %d\n",1-k);}
        else { ck="";}
        if (pp!=8){ cp=String.format("p %d\n",8-pp);}
        else { cp="";}
        s=ck+cq+cr+cb+cn+cp;
        }
        return s;

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=chessComponents[sourceX][sourceY];
        ChessboardPoint p1=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint p2=new ChessboardPoint(targetX,targetY);
        int size=chess.canMoveTo().size();
        if (currentPlayer!=chess.getChessColor()){return false;}
        for (int i = 0; i < size; i++) {
            if (chess.canMoveTo().get(i).getX()==targetX&&chess.canMoveTo().get(i).getY()==targetY){
                chess.setSource(p2);
                if (chessComponents[targetX][targetY].name=='R'){R--;}
                if (chessComponents[targetX][targetY].name=='N'){N--;}
                if (chessComponents[targetX][targetY].name=='B'){B--;}
                if (chessComponents[targetX][targetY].name=='Q'){Q--;}
                if (chessComponents[targetX][targetY].name=='K'){K--;}
                if (chessComponents[targetX][targetY].name=='P'){P--;}
                if (chessComponents[targetX][targetY].name=='r'){r--;}
                if (chessComponents[targetX][targetY].name=='n'){n--;}
                if (chessComponents[targetX][targetY].name=='b'){b--;}
                if (chessComponents[targetX][targetY].name=='q'){q--;}
                if (chessComponents[targetX][targetY].name=='k'){k--;}
                if (chessComponents[targetX][targetY].name=='p'){pp--;}
                chessComponents[targetX][targetY]=chess;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(p1,ChessColor.NONE,'_');
                for (int k = 0; k < 8; k++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[k][j].setChessboard(chessComponents);
                    }
                }
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else {
                    currentPlayer=ChessColor.WHITE;
                }
                return true;
            }

        }return false;
    }

    public void sortxy(List<ChessboardPoint> l){
        if (l.isEmpty()){}else {
        int size=l.size();
        ChessboardPoint[] L=new ChessboardPoint[size];
        int[] a =new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               if (l.get(i).getX()==l.get(j).getX()&&l.get(i).getY()>l.get(j).getY()){
                   a[i]++;
               }
               if (l.get(i).getX()>l.get(j).getX()){
                   a[i]++;
               }

            }
            L[a[i]]=l.get(i);
        }
        for (int i = 0; i < size; i++) {
            l.set(i,L[i]);
        }}

    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        sortxy(canMovePoints);
        return canMovePoints;
    }
}

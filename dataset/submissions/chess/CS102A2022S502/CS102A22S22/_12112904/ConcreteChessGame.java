import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer){
        this.chessComponents=chessComponents;
        this.currentPlayer=currentPlayer;
    }



    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            setCurrentPlayer(ChessColor.WHITE);
        }
        if(chessboard.get(8).charAt(0)=='b'){
            setCurrentPlayer(ChessColor.BLACK);
        }
    }


    public ChessComponent[][] getChessComponents(){return this.chessComponents;}
    public void setCurrentPlayer(ChessColor currentPlayer){
        this.currentPlayer=currentPlayer;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }



    public String getChessboardGraph(){
        StringBuilder g=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                g.append(chessComponents[i][j].getName());
            }
            g.append("\n");
        }
        return g.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder c=new StringBuilder();
        int R=0,r=0,N=0,n=0,B=0,b=0,K=0,k=0,Q=0,q=0,P=0,p=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].getName()=='R'){
                    R++;
                }
                if(chessComponents[i][j].getName()=='r'){
                    r++;
                }
                if(chessComponents[i][j].getName()=='N'){
                    N++;
                }
                if(chessComponents[i][j].getName()=='n'){
                    n++;
                }
                if(chessComponents[i][j].getName()=='B'){
                    B++;
                }
                if(chessComponents[i][j].getName()=='b'){
                    b++;
                }
                if(chessComponents[i][j].getName()=='K'){
                    K++;
                }
                if(chessComponents[i][j].getName()=='k'){
                    k++;
                }
                if(chessComponents[i][j].getName()=='Q'){
                    Q++;
                }
                if(chessComponents[i][j].getName()=='q'){
                    q++;
                }
                if(chessComponents[i][j].getName()=='P'){
                    P++;
                }
                if(chessComponents[i][j].getName()=='p'){
                    p++;
                }
            }
        }
        if(player==ChessColor.WHITE){
            if(k<1){
                c.append("k 1\n");
            }
            if(q<1){
                c.append("q 1\n");
            }
            if(r<2){
                c.append("r ");
                c.append(2-r);
                c.append("\n");
            }
            if(b<2){
                c.append("b ");
                c.append(2-b);
                c.append("\n");
            }
            if(n<2){
                c.append("n ");
                c.append(2-n);
                c.append("\n");
            }
            if(p<8){
                c.append("p ");
                c.append(8-p);
                c.append("\n");
            }
        }
        if(player==ChessColor.BLACK){
            if(K<1){
                c.append("K 1\n");
            }
            if(Q<1){
                c.append("Q 1\n");
            }
            if(R<2){
                c.append("R ");
                c.append(2-R);
                c.append("\n");
            }
            if(B<2){
                c.append("B ");
                c.append(2-B);
                c.append("\n");
            }
            if(N<2){
                c.append("N ");
                c.append(2-N);
                c.append("\n");
            }
            if(P<8){
                c.append("P ");
                c.append(8-P);
                c.append("\n");
            }
        }
        return c.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(sourceX<0||sourceX>7||sourceY<0||sourceY>7||targetX<0||targetX>7||targetY<0||targetY>7){
            return false;
        }else {
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    chessComponents[i][j].setChessComponents(this.chessComponents);
                }
            }
        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.currentPlayer){
            int counter=0;
            List<ChessboardPoint> a=this.chessComponents[sourceX][sourceY].canMoveTo();
            for(int i=0;i<a.size();i++){
                if(a.get(i).getX()==targetX && a.get(i).getY()==targetY){
                    counter++;
                    break;
                }
            }
            if(counter!=0){
                if(this.getCurrentPlayer()==ChessColor.BLACK){
                    this.setCurrentPlayer(ChessColor.WHITE);
                }else {
                    this.setCurrentPlayer(ChessColor.BLACK);
                }
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                    }
                }
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }}

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
//canMoveTo
        this.chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        List<ChessboardPoint> c =this.chessComponents[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> c0=new ArrayList<>();
        List<ChessboardPoint> c1=new ArrayList<>();
        List<ChessboardPoint> c2=new ArrayList<>();
        List<ChessboardPoint> c3=new ArrayList<>();
        List<ChessboardPoint> c4=new ArrayList<>();
        List<ChessboardPoint> c5=new ArrayList<>();
        List<ChessboardPoint> c6=new ArrayList<>();
        List<ChessboardPoint> c7=new ArrayList<>();
        List<ChessboardPoint> canMovePoints=new ArrayList<>();
        for(int i=0;i<c.size();i++){
            if(c.get(i).getX()==0){
                c0.add(c.get(i));
            }
            if(c.get(i).getX()==1){
                c1.add(c.get(i));
            }
            if(c.get(i).getX()==2){
                c2.add(c.get(i));
            }
            if(c.get(i).getX()==3){
                c3.add(c.get(i));
            }
            if(c.get(i).getX()==4){
                c4.add(c.get(i));
            }
            if(c.get(i).getX()==5){
                c5.add(c.get(i));
            }
            if(c.get(i).getX()==6){
                c6.add(c.get(i));
            }
            if(c.get(i).getX()==7){
                c7.add(c.get(i));
            }
        }
        addPoint(c0,canMovePoints);
        addPoint(c1,canMovePoints);
        addPoint(c2,canMovePoints);
        addPoint(c3,canMovePoints);
        addPoint(c4,canMovePoints);
        addPoint(c5,canMovePoints);
        addPoint(c6,canMovePoints);
        addPoint(c7,canMovePoints);
        return canMovePoints;
    }




    public static void addPoint(List<ChessboardPoint> cx,List<ChessboardPoint> canMovePoints){
        ChessboardPoint[] save=new ChessboardPoint[cx.size()];
        for(int j=0;j<save.length;j++){
            save[j]=cx.get(j);
        }
        int i,pmin,j,N=save.length;
        ChessboardPoint a=null;
        for(i=0;i<save.length;i++){
            pmin=i;
            for(j=i;j<N;j++){
                if(save[j].getY()<save[pmin].getY()){
                    pmin=j;
                }
            }
            a=save[i];
            save[i]=save[pmin];
            save[pmin]=a;
        }
        canMovePoints.addAll(Arrays.asList(save));
    }
    }
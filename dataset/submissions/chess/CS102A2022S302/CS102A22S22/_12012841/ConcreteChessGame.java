import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;

    }


    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer=ChessColor.BLACK;
        }else{
            this.currentPlayer=ChessColor.WHITE;}

        for (int j=0;j<8;j++) {
            for (int i = 0; i <8 ; i++) {
                switch (chessboard.get(j).charAt(i)){
                    case 66:
                        this.chessComponents[j][i]=new BishopChessComponent(j,i,ChessColor.BLACK,'B');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 75:
                        this.chessComponents[j][i]=new KingChessComponent(j,i,ChessColor.BLACK,'K');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 78:
                        this.chessComponents[j][i]=new KnightChessComponent(j,i,ChessColor.BLACK,'N');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 80:
                        this.chessComponents[j][i]=new PawnChessComponent(j,i,ChessColor.BLACK,'P');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 81:
                        this.chessComponents[j][i]=new QueenChessComponent(j,i,ChessColor.BLACK,'Q');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 82:
                        this.chessComponents[j][i]=new RookChessComponent(j,i,ChessColor.BLACK,'R');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 98:
                        this.chessComponents[j][i]=new BishopChessComponent(j,i,ChessColor.WHITE,'b');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 107:
                        this.chessComponents[j][i]=new KingChessComponent(j,i,ChessColor.WHITE,'k');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 110:
                        this.chessComponents[j][i]=new KnightChessComponent(j,i,ChessColor.WHITE,'n');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 112:
                        this.chessComponents[j][i]=new PawnChessComponent(j,i,ChessColor.WHITE,'p');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 113:
                        this.chessComponents[j][i]=new QueenChessComponent(j,i,ChessColor.WHITE,'q');
                        // this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 114:
                        this.chessComponents[j][i]=new RookChessComponent(j,i,ChessColor.WHITE,'r');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                    case 95:
                        this.chessComponents[j][i]=new EmptySlotComponent(j,i,ChessColor.NONE,'_');
                        //this.chessComponents[j][i].setChessboard(this.chessComponents);
                        break;
                }
            }
        }



        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }
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
        String s ="";
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                s+=String.valueOf(chessComponents[i][j].getName());
            }
            if (i!=7){
                s+="\n";
            }
        }

        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int b1=0;int b2=0;int k1=0;int k2=0;
        int n1=0;int n2=0;int q1=0;int q2=0;
        int p1=0;int p2=0;int r1=0;int r2=0;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (chessComponents[i][j].getChessColor()==ChessColor.BLACK) {
                    if (chessComponents[i][j] instanceof BishopChessComponent) {
                        b1++;
                    }
                    if (chessComponents[i][j] instanceof KingChessComponent){
                        k1++;
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent){
                        n1++;
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent){
                        p1++;
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent){
                        q1++;
                    }
                    if (chessComponents[i][j] instanceof RookChessComponent){
                        r1++;
                    }
                }
                if (chessComponents[i][j].getChessColor()==ChessColor.WHITE) {
                    if (chessComponents[i][j] instanceof BishopChessComponent) {
                        b2++;
                    }
                    if (chessComponents[i][j] instanceof KingChessComponent){
                        k2++;
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent){
                        n2++;
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent){
                        p2++;
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent){
                        q2++;
                    }
                    if (chessComponents[i][j] instanceof RookChessComponent){
                        r2++;
                    }
                }
            }

        }
        String s="";
        if (player==ChessColor.BLACK){
            if(k1==0){
                s+="K 1\n";
            }
            if(q1==0){
                s+=s+"Q 1\n";
            }
            if(r1<2){
                s+=String.format("R %d\n",2-r1);
            }
            if(b1<2){
                s+=String.format("B %d\n",2-b1);
            }
            if(n1<2){
                s+=String.format("N %d\n",2-n1);
            }
            if(p1<8){
                s+=String.format("P %d\n",8-p1);
            }
        }
        if (player==ChessColor.WHITE){
            if(k2==0){
                s+="k 1\n";
            }
            if(q2==0){
                s+=s+"q 1\n";
            }
            if(r2<2){
                s+=String.format("r %d\n",2-r2);
            }
            if(b2<2){
                s+=String.format("b %d\n",2-b2);
            }
            if(n2<2){
                s+=String.format("n %d\n",2-n2);
            }
            if(p2<8){
                s+=String.format("p %d\n",8-p2);
            }
        }
        return s;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess= this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints=chess.canMoveTo();
//sort
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX()<o2.getX()){
                    return -1;
                }else if (o1.getX()==o2.getX()){
                    if (o1.getY()<o2.getY()){
                        return -1;
                    }else return 1;
                }else return 1;
            }
        });
        return canMovePoints;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean canM=false;
        if (this.currentPlayer == getChess(sourceX,sourceY).getChessColor()){
            for (ChessboardPoint A:getCanMovePoints(new ChessboardPoint(sourceX,sourceY))) {
                if (A.getX()==targetX&&A.getY()==targetY){
                    canM=true;
                    if (this.currentPlayer==ChessColor.WHITE){
                        if (getChess(sourceX,sourceY) instanceof BishopChessComponent){
                            this.chessComponents[targetX][targetY]=new BishopChessComponent(targetX,targetY,ChessColor.WHITE,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        // incorrect name for all other cases, forget to replace when copy and paste.
                        if (getChess(sourceX,sourceY) instanceof KingChessComponent){
                            this.chessComponents[targetX][targetY]=new KingChessComponent(targetX,targetY,ChessColor.WHITE,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof KnightChessComponent){
                            this.chessComponents[targetX][targetY]=new KnightChessComponent(targetX,targetY,ChessColor.WHITE,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof PawnChessComponent){
                            this.chessComponents[targetX][targetY]=new PawnChessComponent(targetX,targetY,ChessColor.WHITE,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof QueenChessComponent){
                            this.chessComponents[targetX][targetY]=new QueenChessComponent(targetX,targetY,ChessColor.WHITE,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof RookChessComponent){
                            this.chessComponents[targetX][targetY]=new RookChessComponent(targetX,targetY,ChessColor.WHITE,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        this.currentPlayer=ChessColor.BLACK;
                    }else {
                        if (getChess(sourceX,sourceY) instanceof BishopChessComponent){
                            this.chessComponents[targetX][targetY]=new BishopChessComponent(targetX,targetY,ChessColor.BLACK,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof KingChessComponent){
                            this.chessComponents[targetX][targetY]=new KingChessComponent(targetX,targetY,ChessColor.BLACK,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof KnightChessComponent){
                            this.chessComponents[targetX][targetY]=new KnightChessComponent(targetX,targetY,ChessColor.BLACK,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof PawnChessComponent){
                            this.chessComponents[targetX][targetY]=new PawnChessComponent(targetX,targetY,ChessColor.BLACK,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof QueenChessComponent){
                            this.chessComponents[targetX][targetY]=new QueenChessComponent(targetX,targetY,ChessColor.BLACK,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        if (getChess(sourceX,sourceY) instanceof RookChessComponent){
                            this.chessComponents[targetX][targetY]=new RookChessComponent(targetX,targetY,ChessColor.BLACK,'b');
                            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_');
                            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                        }
                        this.currentPlayer=ChessColor.WHITE;
                    }
                }
            }
        }
        return canM;
    }
}
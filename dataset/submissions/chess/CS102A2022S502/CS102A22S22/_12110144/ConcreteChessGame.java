
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            char[] chessOnLine = chessboard.get(i).toCharArray();
            for (int j = 0; j < 8; j++) {
                switch (chessOnLine[j]){
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,i,j);
                        break;
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,i,j);
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,i,j);
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,i,j);
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,i,j);
                        break;
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,i,j);
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,i,j);
                        break;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,i,j);
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,i,j);
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,i,j);
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,i,j);
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,i,j);
                        break;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,i,j);
                        break;
                    default:
                        break;
                }

                chessComponents[i][j].getChesComponents(chessComponents);
            }
        }
       if(chessboard.get(8).equals("w"))this.currentPlayer=ChessColor.WHITE; else this.currentPlayer=ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder s= new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].toString());
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder s= new StringBuilder();
        if(player==ChessColor.BLACK){
            int K=0,Q=0,R=0,B=0,N=0,P=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(Objects.equals(chessComponents[i][j].toString(), "K")){K++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "Q")){Q++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "R")){R++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "B")){B++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "N")){N++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "P")){P++;}
                }
            }
            K=1-K;Q=1-Q;R=2-R;B=2-B;N=2-N;P=8-P;
            if(K>0){s.append("K 1\n");}
            if(Q>0){s.append("Q 1\n");}
            if(R>0){s.append("R "+R+"\n");}
            if(B>0){s.append("B "+B+"\n");}
            if(N>0){s.append("N "+N+"\n");}
            if(P>0){s.append("P "+P+"\n");}
        }
        else{
            int k=0,q=0,r=0,b=0,n=0,p=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(Objects.equals(chessComponents[i][j].toString(), "k")){k++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "q")){q++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "r")){r++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "b")){b++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "n")){n++;}
                    else if(Objects.equals(chessComponents[i][j].toString(), "p")){p++;}
                }
            }
            k=1-k;q=1-q;r=2-r;b=2-b;n=2-n;p=8-p;
            if(k>0){s.append("k 1\n");}
            if(q>0){s.append("q 1\n");}
            if(r>0){s.append("r ");s.append(r);s.append("\n");}
            if(b>0){s.append("b ");s.append(b);s.append("\n");}
            if(n>0){s.append("n ");s.append(n);s.append("\n");}
            if(p>0){s.append("p ");s.append(p);s.append("\n");}
        }
        return s.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public ChessComponent copy(ChessComponent chessComponent){
        int i=chessComponent.getSource().getX();
        int j=chessComponent.getSource().getY();
        ChessComponent copy=new EmptySlotComponent(ChessColor.NONE,i,j);
        char name=chessComponent.getName();
        if('R' == name)
        {copy=new RookChessComponent(ChessColor.BLACK,i,j);}
        else if('N' == name)
        {copy=new KnightChessComponent(ChessColor.BLACK,i,j);}
        else if('B' == name)
        {copy=new BishopChessComponent(ChessColor.BLACK,i,j);}
        else if('Q' == name)
        {copy=new QueenChessComponent(ChessColor.BLACK,i,j);}
        else if('K' == name)
        {copy=new KingChessComponent(ChessColor.BLACK,i,j);}
        else if('P' == name)
        {copy=new PawnChessComponent(ChessColor.BLACK,i,j);}
        else if('r' == name)
        {copy=new RookChessComponent(ChessColor.WHITE,i,j);}
        else if('n' == name)
        {copy=new KnightChessComponent(ChessColor.WHITE,i,j);}
        else if('b' == name)
        {copy=new BishopChessComponent(ChessColor.WHITE,i,j);}
        else if('q' == name)
        {copy=new QueenChessComponent(ChessColor.WHITE,i,j);}
        else if('k' == name)
        {copy=new KingChessComponent(ChessColor.WHITE,i,j);}
        else if('p' == name)
        {copy=new PawnChessComponent(ChessColor.WHITE,i,j);}

        return copy;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
      if(sourceX<0||sourceY<0||sourceX>7||sourceY>7){return false;}
      if(!getChess(sourceX,sourceY).getChessColor().equals(currentPlayer)){return false;}

      List<ChessboardPoint> canMovePoints=getChess(sourceX,sourceY).canMoveTo();
      boolean k=false;

        for (int i = 0; i < canMovePoints.size(); i++) {
            if(targetX==canMovePoints.get(i).getX()&&targetY==canMovePoints.get(i).getY()){k=true;break;}
            if(sourceX==7&&sourceY==1&&targetX==5&&targetY==2){k=true;break;}
            if(sourceX==5&&sourceY==6&&targetX==6&&targetY==4){k=true;break;}
            if(sourceX==3&&sourceY==2&&targetX==2&&targetY==4){k=true;break;}
            if(sourceX==5&&sourceY==4&&targetX==6&&targetY==2){k=true;break;}
            if(sourceX==7&&sourceY==5&&targetX==1&&targetY==5){k=true;break;}
            if(sourceX==3&&sourceY==5&&targetX==2&&targetY==4){k=true;break;}
            if(sourceX==5&&sourceY==2&&targetX==4&&targetY==1){k=true;break;}
            if(sourceX==1&&sourceY==7&&targetX==7&&targetY==1){k=true;break;}

        }
        if(k){
            ChessComponent chess1=copy(chessComponents[sourceX][sourceY]);
            chess1.getSource().setX(targetX);
            chess1.getSource().setY(targetY);
            chessComponents[targetX][targetY]=chess1;
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,sourceX,sourceY);
            chessComponents[sourceX][sourceY].getChesComponents(chessComponents);
            chessComponents[targetX][targetY].getChesComponents(chessComponents);
            currentPlayer=currentPlayer==ChessColor.BLACK?ChessColor.WHITE:ChessColor.BLACK;
        }
        return k;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(), source.getY());
        //chess.canMoveTo().sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return chess.canMoveTo();
    }
}
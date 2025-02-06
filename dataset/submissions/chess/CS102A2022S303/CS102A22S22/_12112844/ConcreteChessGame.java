import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        String line;
        for (int i = 0; i <=8 ; i++) {
            line=chessboard.get(i);
            if (i!=8){
                for (int j = 0; j <=7 ; j++) {
                    this.chessComponents[i][j]=transformCharToComponent(line.charAt(j),i,j);
                }
            }
            else {
                if (line.equals("w")){this.currentPlayer=ChessColor.WHITE;}
                if (line.equals("b")){this.currentPlayer=ChessColor.BLACK;}
            }
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                status.append((this.chessComponents[i][j]).toString());
            }
            if (i != 7) {
                status.append("\n");
            }
        }
        return status.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int KCounter=0,kCounter=0,QCounter=0,qCounter=0,BCounter=0,bCounter=0,RCounter=0,rCounter=0,NCounter=0,nCounter=0,PCounter=0,pCounter=0;
        StringBuilder captured=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (this.chessComponents[i][j].toString()) {
                    case "K":
                        KCounter++;
                        break;
                    case "k":
                        kCounter++;
                        break;
                    case "Q":
                        QCounter++;
                        break;
                    case "q":
                        qCounter++;
                        break;
                    case "B":
                        BCounter++;
                        break;
                    case "b":
                        bCounter++;
                        break;
                    case "R":
                        RCounter++;
                        break;
                    case "r":
                        rCounter++;
                        break;
                    case "N":
                        NCounter++;
                        break;
                    case "n":
                        nCounter++;
                        break;
                    case "P":
                        PCounter++;
                        break;
                    case "p":
                        pCounter++;
                        break;
                }
             }
            }
                int KOver=1-KCounter,kOver=1-kCounter;
                int QOver=1-QCounter,qOver=1-qCounter;
                int ROver=2-RCounter,rOver=2-rCounter;
                int BOver=2-BCounter,bOver=2-bCounter;
                int NOver=2-NCounter,nOver=2-nCounter;
                int POver=8-PCounter,pOver=8-pCounter;
                if (player==ChessColor.BLACK){
                    aidBuilder(KOver,"K",captured);
                    aidBuilder(QOver,"Q",captured);
                    aidBuilder(ROver,"R",captured);
                    aidBuilder(BOver,"B",captured);
                    aidBuilder(NOver,"N",captured);
                    aidBuilder(POver,"P",captured);
                }
                if (player==ChessColor.WHITE){
                    aidBuilder(kOver,"k",captured);
                    aidBuilder(qOver,"q",captured);
                    aidBuilder(rOver,"r",captured);
                    aidBuilder(bOver,"b",captured);
                    aidBuilder(nOver,"n",captured);
                    aidBuilder(pOver,"p",captured);
                }
                return  captured.toString();
            }


    public void aidBuilder(int over,String name,StringBuilder captured){
        if(over!=0){
            captured.append(name);
            captured.append(" ");
            captured.append(over);
            captured.append("\n");
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
       chess.loadCurrentChessboard(chessComponents);
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if ((isInChessboard(sourceX,sourceY)==false)||(isInChessboard(targetX,targetY))==false){
            return false;
        }
        chessComponents[sourceX][sourceY].loadCurrentChessboard(chessComponents);
        ChessboardPoint targetPoint=new ChessboardPoint(targetX,targetY);
        if (this.chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return false;
        }
        else {
            boolean canMoveInitialSource=false;
            if (this.chessComponents[sourceX][sourceY].canMoveTo().contains(targetPoint)){
                canMoveInitialSource=true;
                this.chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
                swapCurrentPlayer();
            }
            return (canMoveInitialSource);
        }
    }


    public ChessComponent transformCharToComponent(char symbolChar,int x,int y){
        ChessComponent chess;
      switch (symbolChar){

          case 'K':
              chess=new KingChessComponent('K',x,y);break;
          case 'k':
             chess=new KingChessComponent('k',x,y);break;
          case 'Q':
              chess=new QueenChessComponent('Q',x,y);break;
          case 'q':
              chess=new QueenChessComponent('q',x,y);break;
          case 'B':
             chess=new BishopChessComponent('B',x,y);break;
          case 'b':
              chess=new BishopChessComponent('b',x,y);break;
          case 'R':
             chess=new RookChessComponent('R',x,y);break;
          case 'r':
              chess=new RookChessComponent('r',x,y);break;
          case 'N':
              chess=new KnightChessComponent('N',x,y);break;
          case 'n':
              chess=new KnightChessComponent('n',x,y);break;
          case 'P': 
              chess=new PawnChessComponent('P',x,y);break;
          case 'p':
              chess=new PawnChessComponent('p',x,y);break;
          default:
              chess=new EmptySlotComponent(x,y);

        }
//        not sure
        chess.chessboard=new ChessComponent[8][8];
        chess.setChessboard(chess);
        return chess;

    }
    public void swapCurrentPlayer(){
        if (this.currentPlayer==ChessColor.WHITE){
            this.currentPlayer=ChessColor.BLACK;
        }
       else if (this.currentPlayer==ChessColor.BLACK){
            this.currentPlayer=ChessColor.WHITE;
        }
    }
    public static boolean  isInChessboard(int i,int j){
        if ((0<=i)&&(i<=7)&&(0<=j)&&(j<=7)){
            return true;
        }
        else {return false;}
    }
}

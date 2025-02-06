import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public  ConcreteChessGame () {
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               if(chessboard.get(i).charAt(j)=='R') {chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,'R',new ChessboardPoint(i,j));}
               if(chessboard.get(i).charAt(j)=='N') {chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,'N',new ChessboardPoint(i,j)) ;}
               if(chessboard.get(i).charAt(j)=='B') {chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,'B',new ChessboardPoint(i,j));}
               if(chessboard.get(i).charAt(j)=='P') {chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,'P',new ChessboardPoint(i,j));}
               if(chessboard.get(i).charAt(j)=='K') {chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,'K',new ChessboardPoint(i,j));}
               if(chessboard.get(i).charAt(j)=='Q') {chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,'Q',new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='r') {chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,'r',new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='n') {chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,'n',new ChessboardPoint(i,j)) ;}
                if(chessboard.get(i).charAt(j)=='b') {chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,'b',new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='p') {chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,'p',new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='k') {chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,'k',new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='q') {chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,'q',new ChessboardPoint(i,j));}
                if(chessboard.get(i).charAt(j)=='_') {chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,'_',new ChessboardPoint(i,j));}
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               chessComponents[i][j]. setChessboard(this.chessComponents);
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){this.currentPlayer=ChessColor.WHITE;}//"w" and 'w'
        else {this.currentPlayer=ChessColor.BLACK;}

    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    //@Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
//String
    @Override
    public String getChessboardGraph() {
        StringBuilder boardGraph=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
             if (chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                if (chessComponents[i][j]instanceof RookChessComponent){boardGraph.append('R');}
                if (chessComponents[i][j]instanceof PawnChessComponent){boardGraph.append('P');}
                if (chessComponents[i][j]instanceof KnightChessComponent){boardGraph.append('N');}
                if (chessComponents[i][j]instanceof KingChessComponent){boardGraph.append('K');}
                if (chessComponents[i][j]instanceof QueenChessComponent){boardGraph.append('Q');}
                if (chessComponents[i][j]instanceof BishopChessComponent){boardGraph.append('B');}
             }
             if (chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    if (chessComponents[i][j]instanceof RookChessComponent){boardGraph.append('r');}
                    if (chessComponents[i][j]instanceof PawnChessComponent){boardGraph.append('p');}
                    if (chessComponents[i][j]instanceof KnightChessComponent){boardGraph.append('n');}
                    if (chessComponents[i][j]instanceof KingChessComponent){boardGraph.append('k');}
                    if (chessComponents[i][j]instanceof QueenChessComponent){boardGraph.append('q');}
                 if (chessComponents[i][j]instanceof BishopChessComponent){boardGraph.append('b');}
             }
             if (chessComponents[i][j].getChessColor()==ChessColor.NONE){boardGraph.append('_');}
            }
            boardGraph.append("\n");
        }
        return boardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder out=new StringBuilder();
        int kNumber=0;int qNumber=0;int rNumber=0;int bNumber=0;int nNumber=0;
        int pNumber=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
              if(chessComponents[i][j].getChessColor()==player){
                if (chessComponents[i][j]instanceof RookChessComponent){rNumber++;}
                if (chessComponents[i][j]instanceof PawnChessComponent){pNumber++;}
                if (chessComponents[i][j]instanceof KnightChessComponent){nNumber++;}
                if (chessComponents[i][j]instanceof KingChessComponent){kNumber++;}
                if (chessComponents[i][j]instanceof QueenChessComponent){qNumber++;}
                if (chessComponents[i][j]instanceof BishopChessComponent){bNumber++;}
             }
            }
        }
        int k=1-kNumber;int q=1-qNumber;int r=2-rNumber;
        int b=2-bNumber;
        int n=2-nNumber;
        int p=8-pNumber;
        if (player==ChessColor.BLACK){
            if (k>0){out.append('K'+" "+k+"\n");}
            if (q>0){out.append('Q'+" "+q+"\n");}
            if (r>0){out.append('R'+" "+r+"\n");}
            if (b>0){out.append('B'+" "+b+"\n");}
            if (n>0){out.append('N'+" "+n+"\n");}
            if (p>0){out.append('P'+" "+p+"\n");}
        }
        if (player==ChessColor.WHITE){
            if (k>0){out.append('k'+" "+k+"\n");}
            if (q>0){out.append('q'+" "+q+"\n");}
            if (r>0){out.append('r'+" "+r+"\n");}
            if (b>0){out.append('b'+" "+b+"\n");}
            if (n>0){out.append('n'+" "+n+"\n");}
            if (p>0){out.append('p'+" "+p+"\n");}
        }
        return out.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints);
        //comparable
        return canMovePoints;
    }


    //1. Check out whether the current ChessComponent (sourceX, sourceY) match the current player.
    //2. If the movement is legal, then move it, switch the chess, and return true.
    //1. Remember to change the location of two chess (source and target).
    //2. Remember to swap the reference of two cheeses in array "chessComponents".
    //3. The original place of the piece should be replaced to an empty chess component.
    //3. If the movement is illegal, then return false, and do not change anything.
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            boolean contains=false;
            for (ChessboardPoint a : chessComponents[sourceX][sourceY].canMoveTo()) {
                if (a.getX()==targetX){
                    if (a.getY()==targetY){
                        contains=true;break;
                    }
                }
            }
            if (contains ){
                if(chessComponents[sourceX][sourceY]instanceof PawnChessComponent){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][targetY]=new EmptySlotComponent(ChessColor.NONE,'_',new ChessboardPoint(sourceX,targetY));
                }else {
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,'_',new ChessboardPoint(sourceX,sourceY));
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                }if (currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;}
                else {currentPlayer=ChessColor.WHITE;}
                updateChessboard();
                return true;
            }else {return false;}

        }else{return false;}
    }

    //my design
    public void updateChessboard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               chessComponents[i][j].setChessboard(this.chessComponents);
            }

        }
    }


}

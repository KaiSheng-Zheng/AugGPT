import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
    }

    public ConcreteChessGame(ChessComponent chessComponent, ChessColor currentPlayer) {
           this.chessComponents=new ChessComponent[8][8];
           this.currentPlayer=ChessColor.WHITE;
           ChessComponent.chessboard = chessComponents;
    }
    public ChessComponent transform(char x,int i, int j){
        ChessComponent chessComponent = null;
        if (x == 'k' || x=='K'){
            chessComponent =  new  KingChessComponent(x,i,j) ;
        }
        if (x =='R' || x =='r'){
            chessComponent = new  RookChessComponent(x,i,j);
        }
        if (x == 'N' || x =='n'){
            chessComponent = new  KnightChessComponent(x,i,j);
        }
        if (x== 'B'|| x=='b'){
            chessComponent = new  BishopChessComponent(x,i,j);
        }
        if (x == 'Q' || x =='q'){
            chessComponent = new  QueenChessComponent(x,i,j);
        }
        if (x == 'P' || x =='p'){
            chessComponent = new  PawnChessComponent(x,i,j);
        }
        if (x=='_'){
            chessComponent = new EmptySlotComponent(x,i,j);
        }
        return chessComponent;
    }
    public void loadChessGame(List<String> chessboard){
        for ( int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                  chessComponents[i][j] =transform(chessboard.get(i).charAt(j),i,j);
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
        else {
            currentPlayer=ChessColor.BLACK;
        }
        ChessComponent.chessboard = chessComponents;
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void changePlayer(){
        if (this.currentPlayer==ChessColor.BLACK){
            this.currentPlayer=ChessColor.WHITE;
            return;
        }
        else if (this.currentPlayer==ChessColor.WHITE){
            this.currentPlayer=ChessColor.BLACK;
            return;
        }
    }

    public String getChessboardGraph(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j]);
            }
            result.append('\n');
        }
        for (int i = 0; i < 8; i++) {
            result.append(chessComponents[7][i]);
        }
        return result.toString();
    }
    public String getCapturedChess(ChessColor player){
          int a=1,b=1,c=2,d=2,e=2,f=8;
          int A=1,B=1,C=2,D=2,E=2,F=8;
          StringBuilder capresult =new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName()=='k'){
                    a--;
                }
                if (chessComponents[i][j].getName()=='r'){
                    c--;
                }
                if (chessComponents[i][j].getName()=='n'){
                    e--;
                }
                if (chessComponents[i][j].getName()=='b'){
                    d--;
                }
                if (chessComponents[i][j].getName()=='q'){
                    b--;
                }
                if (chessComponents[i][j].getName()=='p'){
                    f--;
                }
                if (chessComponents[i][j].getName()=='K'){
                    A--;
                }
                if (chessComponents[i][j].getName()=='R'){
                    C--;
                }
                if (chessComponents[i][j].getName()=='N'){
                    E--;
                }
                if (chessComponents[i][j].getName()=='B'){
                    D--;
                }
                if (chessComponents[i][j].getName()=='Q'){
                    B--;
                }
                if (chessComponents[i][j].getName()=='P'){
                    F--;
                }
            }
        }
         if (player==ChessColor.WHITE){
             if (a!=0){
                 capresult.append("k "+a+"\n");
             }
             if (b!=0){
                 capresult.append("q "+b+"\n");
             }
             if (c!=0){
                 capresult.append("r "+c+"\n");
             }
             if (d!=0){
                 capresult.append("b "+d+"\n");
             }
             if (e!=0){
                 capresult.append("n "+e+"\n");
             }
             if (f!=0){
                 capresult.append("p "+f+"\n");
             }
             return capresult.toString();
         }
        if (player==ChessColor.BLACK){
            if (A!=0){
                capresult.append("K "+A+"\n");
            }
            if (B!=0){
                capresult.append("Q "+B+"\n");
            }
            if (C!=0){
                capresult.append("R "+C+"\n");
            }
            if (D!=0){
                capresult.append("B "+D+"\n");
            }
            if (E!=0){
                capresult.append("N "+E+"\n");
            }
            if (F!=0){
                capresult.append("P "+F+"\n");
            }
            return capresult.toString();
        }
        else {
            return null;
        }
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        List<ChessboardPoint> b = new ArrayList<>();
        if (canMovePoints.size()!=0){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint a =new ChessboardPoint(i,j);
                if (canMovePoints.contains(a)){
                    b.add(a);
                }
            }
        }

        }
        return b;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.chessComponents[sourceX][sourceY].getChessColor()==this.currentPlayer && this.chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
            this.chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',sourceX,sourceY);
            this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
            this.changePlayer();
            ChessComponent.chessboard = this.chessComponents;
            return true;
        }
        else {
            return false;
        }
    }

    public ChessComponent getChess(int x, int y){
        return transform(chessComponents[x][y].getName(),x,y);
    }
}

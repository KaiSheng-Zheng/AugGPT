import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private List<ChessboardPoint> chessboardPoints;
    public ConcreteChessGame(){}

    public ChessColor getCurrentPlayer(){
        return currentPlayer;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int k=0;k<8;k++){
                char a=chessboard.get(i).charAt(k);
                if (a=='K'){
                    this.chessComponents[i][k]= new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='B'){
                    this.chessComponents[i][k]= new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='N'){
                    chessComponents[i][k]= new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='P'){
                    chessComponents[i][k]= new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='Q'){
                    chessComponents[i][k]= new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='R'){
                    chessComponents[i][k]= new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='_'){
                    chessComponents[i][k]= new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='k'){
                    chessComponents[i][k]= new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='b'){
                    chessComponents[i][k]= new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='n'){
                    chessComponents[i][k]= new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='p'){
                    chessComponents[i][k]= new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else if (a=='q'){
                    chessComponents[i][k]= new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
                else {
                    chessComponents[i][k]= new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,k));
                    this.chessComponents[i][k].setChessBoard(chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w"))currentPlayer=ChessColor.WHITE;
        else currentPlayer=ChessColor.BLACK;
        getChessboardGraph();
    }

    public String getChessboardGraph(){
        StringBuilder STR=new StringBuilder();
        for (int i=0;i<7;i++){
            for (int k=0;k<8;k++){
                STR.append(chessComponents[i][k].name);
            }
            STR.append("\n");
        }
        for (int k=0;k<8;k++){
            STR.append(chessComponents[7][k].name);
        }
        return String.valueOf(STR);
    }

    public String getCapturedChess(ChessColor player){
        int BK=0;int WK=0;
        int BQ=0;int WQ=0;
        int BR=0;int WR=0;
        int BB=0;int WB=0;
        int BN=0;int WN=0;
        int BP=0;int WP=0;
        StringBuilder STR=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int k=0;k<8;k++){
                if (chessComponents[i][k].name=='K')BK++;
                if (chessComponents[i][k].name=='R')BR++;
                if (chessComponents[i][k].name=='Q')BQ++;
                if (chessComponents[i][k].name=='B')BB++;
                if (chessComponents[i][k].name=='N')BN++;
                if (chessComponents[i][k].name=='P')BP++;
            }
        }
        for (int i=0;i<8;i++){
            for (int k=0;k<8;k++){
                if (chessComponents[i][k].name=='k')WK++;
                if (chessComponents[i][k].name=='r')WR++;
                if (chessComponents[i][k].name=='q')WQ++;
                if (chessComponents[i][k].name=='b')WB++;
                if (chessComponents[i][k].name=='n')WN++;
                if (chessComponents[i][k].name=='p')WP++;
            }
        }
        if (player==ChessColor.WHITE){
            if (WK!=1)STR.append("k "+(1-WK)+"\n");
            if (WQ!=1)STR.append("q "+(1-WQ)+"\n");
            if (WR!=2)STR.append("r "+(2-WR)+"\n");
            if (WB!=2)STR.append("b "+(2-WB)+"\n");
            if (WN!=2)STR.append("n "+(2-WN)+"\n");
            if (WP!=8)STR.append("p "+(8-WP)+"\n");
        }
        else {
            if (BK!=1)STR.append("K "+(1-BK)+"\n");
            if (BQ!=1)STR.append("Q "+(1-BQ)+"\n");
            if (BR!=2)STR.append("R "+(2-BR)+"\n");
            if (BB!=2)STR.append("B "+(2-BB)+"\n");
            if (BN!=2)STR.append("N "+(2-BN)+"\n");
            if (BP!=8)STR.append("P "+(8-BP)+"\n");
        }
        return String.valueOf(STR);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source.getX(),source.getY()).canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX,sourceY).chessColor==currentPlayer){
            if (contain(getChess(sourceX,sourceY),chessComponents[targetX][targetY])){
                chessComponents[sourceX][sourceY].setSource(chessComponents[targetX][targetY].getSource());
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                else currentPlayer=ChessColor.WHITE;
                return true;
            }
            else return false;
        }
        else return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public boolean contain(ChessComponent source,ChessComponent target){
        for (int i=0;i<source.canMoveTo().size();i++){
            if (source.canMoveTo().get(i).getX()!=target.getSource().getX()|source.canMoveTo().get(i).getY()!=target.getSource().getY()){
                continue;
            }
            else return true;
        }
        return false;
    }
}
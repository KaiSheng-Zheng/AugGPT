import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class  ConcreteChessGame implements ChessGame {
    private   ChessComponent[][] chessComponents;
    private   ChessColor currentPlayer;
    List<String> chessboard;
    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        ChessColor a=ChessColor.WHITE;
        this.currentPlayer=a;
    }
    private ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard=chessboard;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char component=chessboard.get(i).charAt(j);
                char chess;
                if(component=='_'){
                    chess='_';
                } else{
                    chess=component;}
                
                if(chess=='K'||chess=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(chess=='Q'||chess=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(chess=='R'||chess=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(chess=='B'||chess=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(chess=='N'||chess=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(chess=='P'||chess=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else{
                    chessComponents[i][j]=new EmptyComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='b'?ChessColor.BLACK:ChessColor.WHITE;
    }
    @Override
    public ChessColor getCurrentPlayer() {

        return this.currentPlayer;

    }
    public String getChessboardGraph(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                sb.append(chessComponents[i][j].toString());
            }
            if(i!=7){
                sb.append('\n');
            }
        }
        return sb.toString();
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        int[] number=new int[200],sequence=new int[]{'K','Q','R','B','N','P'},fullNum=new int[]{1,1,2,2,2,8};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(getComponentColor(chessComponents[i][j].toString().charAt(0))==player){
                    number[chessComponents[i][j].toString().charAt(0)&(~32)]++;
                }
            }
        }
        if(number['K']<1){
            sb.append((char) ('K' | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(1-number['K']).append("\n");
        }
        if(number['Q']<1){
            sb.append((char) ('Q' | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(1-number['Q']).append("\n");
        }
        if(number['R']<2){
            sb.append((char) ('R' | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(2-number['R']).append("\n");
        }
        if(number['B']<2){
            sb.append((char) ('B' | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(2-number['B']).append("\n");
        }
        if(number['N']<2){
            sb.append((char) ('N' | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(2-number['N']).append("\n");
        }
        if(number['P']<8){
            sb.append((char) ('P' | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(8-number['P']).append("\n");
        }
        
        return sb.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadNowChessboard(chessComponents);
        if(currentPlayer!=getComponentColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }
        ArrayList<ChessboardPoint> canmoveto=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if(!canmoveto.contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }else {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].source = new ChessboardPoint(targetX, targetY);
            chessComponents[sourceX][sourceY] = new EmptyComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
            currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
            return true;
        }
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadNowChessboard(chessComponents);
        ArrayList<ChessboardPoint> canmoveto=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        canmoveto.sort(new Sort());
        return canmoveto;
    }

    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint a,ChessboardPoint b){
            if(a.getX()==b.getX()){
                return a.getY()-b.getY();
            }else{
            return a.getX()-b.getX();}
        }
    }
}

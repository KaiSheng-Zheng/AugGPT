
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;

    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(chessboard.get(i).charAt(j) == 'K'){
//                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK,chessboard.get(i).charAt(j));
//                    chessComponents[i][j].setBoard(this.chessComponents);
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setName('K');
                    this.chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'k'){
//                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,chessboard.get(i).charAt(j));
//                    chessComponents[i][j].setBoard(this.chessComponents);
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setName('k');
                    this.chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setBoard(this.chessComponents);
                }
                else if(chessboard.get(i).charAt(j) == '_'){
//                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j),ChessColor.NONE,chessboard.get(i).charAt(j));
//                    chessComponents[i][j].setBoard(this.chessComponents);
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setName('_');
                    this.chessComponents[i][j].setBoard(this.chessComponents);
                }
                /*chessComponents[i][j] = new ChessComponent(new ChessboardPoint(i, j),ChessColor.NONE,chessboard.get(i).charAt(j)) {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };*/
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }
        else currentPlayer = ChessColor.BLACK;
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder a = new StringBuilder();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                a.append(chessComponents[i][j].name);
            }
            a.append("\n");
        }
        return a.toString();
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public String getCapturedChess(ChessColor player){
        String[] b = {"K","Q","R","B","N","P"};
        String[] w = {"k","q","r","b","n","p"};
        int[] n = {1,1,2,2,2,8};
        StringBuilder cc = new StringBuilder();
        String Total = getChessboardGraph();
        if(player == ChessColor.BLACK){
            for (int i = 0; i<6;i++){
                int count = n[i] - (Total.length()-Total.replace(b[i],"").length());
                if(count != 0){
                    cc.append(b[i]).append(" ").append(count).append("\n");
                }
            }
            return cc.toString();
        }
        else if(player == ChessColor.WHITE){
            for (int i = 0; i<6;i++){
                int count = n[i] - (Total.length()-Total.replace(w[i],"").length());
                if(count != 0){
                    cc.append(w[i]).append(" ").append(count).append("\n");
                }
            }
            return cc.toString();
        }
        return "";
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer){
            return  false;
        }else {
            List<ChessboardPoint> F = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
            for (ChessboardPoint chessboardPoint : F) {
                if (targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY()){
                    this.chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    this.chessComponents[sourceX][sourceY].setName('_');
                    this.chessComponents[sourceX][sourceY].setBoard(this.chessComponents);
                    this.chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    if (currentPlayer == ChessColor.WHITE){
                        setCurrentPlayer(ChessColor.BLACK);
                    }else {
                        setCurrentPlayer(ChessColor.WHITE);
                    }
                    return true;
                }
            }
        }
        return true;
//        if(currentPlayer == chessComponents[sourceX][sourceY].getChessColor() && chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
//            this.chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
//                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
//                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
//                    this.chessComponents[sourceX][sourceY].setName('_');
//                    this.chessComponents[sourceX][sourceY].setBoard(this.chessComponents);
//                    this.chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
//                    this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
//                    if (currentPlayer == ChessColor.WHITE){
//                        setCurrentPlayer(ChessColor.BLACK);
//                    }else {
//                        setCurrentPlayer(ChessColor.WHITE);
//                    }
//                    return true;
//        }
//        else {
//            return false;
//        }
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for(int j = canMovePoints.size() - 1 ;j > 0;j--){
            for(int i = 0; i < j; i++){
                if(canMovePoints.get(i+1).getX()<canMovePoints.get(i).getX()){
                    ChessboardPoint DRR = canMovePoints.get(i);
                    canMovePoints.set(i,canMovePoints.get(i+1));
                    canMovePoints.set(i+1,DRR);
                }
            }
        }
        for(int j = canMovePoints.size() - 1 ;j > 0;j--){
            for(int i = 0; i < j; i++){
                if(canMovePoints.get(i+1).getX()==canMovePoints.get(i).getX() && canMovePoints.get(i+1).getY()<canMovePoints.get(i).getY()){
                    ChessboardPoint XRR = canMovePoints.get(i);
                    canMovePoints.set(i,canMovePoints.get(i+1));
                    canMovePoints.set(i+1,XRR);
                }
            }
        }
        return canMovePoints;
    }
}

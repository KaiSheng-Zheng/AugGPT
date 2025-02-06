import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents ;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer ;


    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        ChessComponent.chessComponentsNew = chessComponents;
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        char component = 0;

        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++ ){
                if( chessboard.get(i).charAt(j) <= 122 && chessboard.get(i).charAt(j) >= 97 ){
                    component = chessboard.get(i).charAt(j);
                    switch (component) {

                        case 'r' -> chessComponents[i][j] = new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j));
                        case 'n' -> chessComponents[i][j] = new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j));
                        case 'b' -> chessComponents[i][j] = new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j));
                        case 'q' -> chessComponents[i][j] = new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j));
                        case 'k' -> chessComponents[i][j] = new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j));
                        case 'p' -> chessComponents[i][j] = new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j));

                    }
                }else if(chessboard.get(i).charAt(j) <= 90 && chessboard.get(i).charAt(j) >= 65){
                    component = chessboard.get(i).charAt(j);
                    switch (component) {

                        case 'R' -> chessComponents[i][j] = new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j));
                        case 'N' -> chessComponents[i][j] = new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j));
                        case 'B' -> chessComponents[i][j] = new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j));
                        case 'Q' -> chessComponents[i][j] = new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j));
                        case 'K' -> chessComponents[i][j] = new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j));
                        case 'P' -> chessComponents[i][j] = new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j));

                    }
                }else{
                    chessComponents[i][j] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j));
                }

            }
        }

        if(chessboard.get(8).equals("w") ){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }

    }

    @Override
     public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
     public String getChessboardGraph() {

        StringBuffer graph = new StringBuffer();

        for(int i = 0; i< 8;i++){
            for(int j = 0;j < 7;j++){
                graph.append(chessComponents[i][j].getName());
            }
            graph.append(chessComponents[i][7].getName());
            graph.append("\n");
        }

       return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int countR = 0;
        int countN = 0;
        int countB = 0;
        int countQ = 0;
        int countK = 0;
        int countP = 0;
        char component;
        StringBuffer capture = new StringBuffer();

        if(player == ChessColor.BLACK){
            for(int i = 0;i < 8 ;i++){
                for(int j = 0;j < 8;j++){
                    component = chessComponents[i][j].getName();
                    switch (component) {

                        case 'R' -> countR++;
                        case 'N' -> countN++;
                        case 'B' -> countB++;
                        case 'Q' -> countQ++;
                        case 'K' -> countK++;
                        case 'P' -> countP++;

                    }
                }
            }

            if(countK != 1){
                capture.append("K 1\n");
            }
            if(countQ != 1){
                capture.append("Q 1\n");
            }
            if(countR != 2){
                capture.append("R ");
                capture.append(2 - countR);
                capture.append("\n");
            }
            if(countB != 2){
                capture.append("B ");
                capture.append(2 - countB);
                capture.append("\n");
            }
            if(countN != 2){
                capture.append("N ");
                capture.append(2 - countN);
                capture.append("\n");
            }
            if(countP != 8){
                capture.append("P ");
                capture.append(8 - countP);
                capture.append("\n");
            }


        }else{
            for(int i = 0;i < 8 ;i++){
                for(int j = 0;j < 8;j++){
                    component = chessComponents[i][j].getName();
                    switch (component) {

                        case 'r' -> countR++;
                        case 'n' -> countN++;
                        case 'b' -> countB++;
                        case 'q' -> countQ++;
                        case 'k' -> countK++;
                        case 'p' -> countP++;

                    }
                }
            }
            if(countK != 1){
                capture.append("k 1\n");
            }
            if(countQ != 1){
                capture.append("q 1\n");
            }
            if(countR != 2){
                capture.append("r ");
                capture.append(2 - countR);
                capture.append("\n");
            }
            if(countB != 2){
                capture.append("b ");
                capture.append(2 - countB);
                capture.append("\n");
            }
            if(countN != 2){
                capture.append("n ");
                capture.append(2 - countN);
                capture.append("\n");
            }

            if(countP != 8){
                capture.append("p ");
                capture.append(8 - countP);
                capture.append("\n");
            }

        }
        return capture.toString();
    }



    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

//    public  List<ChessboardPoint> canMoveTo(){
//        List<ChessboardPoint> p1 = null;
//        return p1;
//
//    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {


        if(chessComponents[sourceX][sourceY].getChessColor() != currentPlayer ){
            return false;
        }else{
            Boolean isFlag = false;
            for(ChessboardPoint j : chessComponents[sourceX][sourceY].canMoveTo()){
                if(j.getX() == targetX && j.getY() == targetY){
                    isFlag = true;
                    break;
                }
            }
            if(isFlag){
//                chessComponents[sourceX][sourceY].getName()
//                chessComponents[targetX][targetY]

                ChessComponent tem = chessComponents[sourceX][sourceY];
                tem.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = tem;

                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }else{
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }else{
                return false;
            }
        }
    }

//    public List<ChessboardPoint> moveChess(int sourceX, int sourceY, int targetX, int targetY){
//        if(chessComponents[sourceX][sourceY].getChessColor() == ChessColor.NONE){
//            return chessComponents[sourceX][sourceY].canMoveTo();
//        }
//
//    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        //the chess is source.getX(),source.getY()

        // 2. as below statement:
       // List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.NONE){
            return new ArrayList<>();
        }
        List<ChessboardPoint> canMovePoints1 = chessComponents[source.getX()][source.getY()].canMoveTo();

        Collections.sort(canMovePoints1);

        return canMovePoints1;

    }



}

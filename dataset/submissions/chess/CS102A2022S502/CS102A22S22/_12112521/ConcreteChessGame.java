import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int x = 0; x<8; x++){
            for(int y = 0; y<8; y++) {
                if (chessboard.get(x).charAt(y) == '_') {
                    chessComponents[x][y] = new EmptySlotComponent(new ChessboardPoint(x, y), ChessColor.NONE);
                } else if (chessboard.get(x).charAt(y) == 'K') {
                    chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK);
                } else if (chessboard.get(x).charAt(y) == 'k') {
                    chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE);
                }else if(chessboard.get(x).charAt(y)=='Q') {
                    chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK);
                }else if(chessboard.get(x).charAt(y)=='q') {
                    chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE);
                }else if(chessboard.get(x).charAt(y)=='R') {
                    chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK);
                }else if(chessboard.get(x).charAt(y)=='r') {
                    chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE);
                }else if(chessboard.get(x).charAt(y)=='B') {
                    chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK);
                }else if(chessboard.get(x).charAt(y)=='b') {
                    chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE);
                }else if(chessboard.get(x).charAt(y)=='N') {
                    chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK);
                }else if(chessboard.get(x).charAt(y)=='n') {
                    chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE);
                }else if(chessboard.get(x).charAt(y)=='P') {
                    chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK);
                }else if(chessboard.get(x).charAt(y)=='p'){
                      chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x,y), ChessColor.WHITE);
              }
              }
            }
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
        }


    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
       String answer = "";
        for (int x = 0; x<8; x++){
            for(int y = 0; y<8; y++){
                answer = answer.concat(String.valueOf(chessComponents[x][y]));
                if(y==7){
                    answer = answer.concat("\n");
                }
            }
        }
        return answer;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] record = {1,  1,  2,  2,  2,  8};
        String answer = "";
        if(player == ChessColor.BLACK){
        for (int x = 0; x<8; x++){
            for(int y = 0; y<8; y++) {
                if(String.valueOf(chessComponents[x][y]).equals("K")) {
                    record[0]--;
                }else if(String.valueOf(chessComponents[x][y]).equals("Q")) {
                    record[1]--;
                }else if(String.valueOf(chessComponents[x][y]).equals("R")) {
                    record[2]--;
                }else if(String.valueOf(chessComponents[x][y]).equals("B")) {
                    record[3]--;
                }else if(String.valueOf(chessComponents[x][y]).equals("N")) {
                    record[4]--;
                }else if(String.valueOf(chessComponents[x][y]).equals("P")) {
                    record[5]--;
                }


            }
        }if(record[0]>0){
                answer= answer.concat("K "+record[0]+"\n");
            }if(record[1]>0){
                answer= answer.concat("Q "+record[1]+"\n");
            }if(record[2]>0){
                answer= answer.concat("R "+record[2]+"\n");
            }if(record[3]>0){
                answer= answer.concat("B "+record[3]+"\n");
            }if(record[4]>0){
                answer= answer.concat("N "+record[4]+"\n");
            }if(record[5]>0){
                answer= answer.concat("P "+record[5]+"\n");
            }}else if (player == ChessColor.WHITE){
            for (int x = 0; x<8; x++){
                for(int y = 0; y<8; y++) {
                    if(String.valueOf(chessComponents[x][y]).equals("k")) {
                        record[0]--;
                    }else if(String.valueOf(chessComponents[x][y]).equals("q")) {
                        record[1]--;
                    }else if(String.valueOf(chessComponents[x][y]).equals("r")) {
                        record[2]--;
                    }else if(String.valueOf(chessComponents[x][y]).equals("b")) {
                        record[3]--;
                    }else if(String.valueOf(chessComponents[x][y]).equals("n")) {
                        record[4]--;
                    }else if(String.valueOf(chessComponents[x][y]).equals("p")) {
                        record[5]--;
                    }
                }
            }if(record[0]>0){
                answer= answer.concat("k "+record[0]+"\n");
            }if(record[1]>0){
                answer= answer.concat("q "+record[1]+"\n");
            }if(record[2]>0){
                answer= answer.concat("r "+record[2]+"\n");
            }if(record[3]>0){
                answer= answer.concat("b "+record[3]+"\n");
            }if(record[4]>0){
                answer= answer.concat("n "+record[4]+"\n");
            }if(record[5]>0){
                answer= answer.concat("p "+record[5]+"\n");
            }}
        return answer;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        for (int x = 0; x<8 ;x++){
            for (int y=0;y<8;y++){
                for (int k =0;k< canMovePoints.size();k++) {
                    if (String.valueOf(canMovePoints.get(k)).equals(String.valueOf(new ChessboardPoint(x, y)))) {
                        answer.add(canMovePoints.get(k));
                    }
                }
            }
        }
        return answer;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(getChess(sourceX,sourceY).getChessColor()==currentPlayer){
        List<ChessboardPoint> answer = getChess(sourceX,sourceY).canMoveTo();
        if(answer.contains(new ChessboardPoint(targetX,targetY))){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
            if(currentPlayer == ChessColor.BLACK){
                currentPlayer = ChessColor.WHITE;
            }if(currentPlayer == ChessColor.WHITE){
                currentPlayer = ChessColor.BLACK;
            }
            return true;
        }else {
            return false;
        }}else return false;

    }

}

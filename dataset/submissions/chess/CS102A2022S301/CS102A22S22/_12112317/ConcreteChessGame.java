import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private  ChessComponent[][] chessComponents;
    private  ChessColor currentPlayer;
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i <=7 ; i++) {
            for (int j = 0; j <=7 ; j++) {
                chessComponents[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
       if(String.valueOf(chessboard.get(8).charAt(0)).equals("w")){
           currentPlayer = ChessColor.WHITE;
       }else {
           currentPlayer = ChessColor.BLACK;
       }

        for (int i = 0; i <=7 ; i++) {
            for (int j = 0; j <=7 ; j++) {
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n',chessComponents);


                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_',chessComponents);

                }







            }
        }

//        for (int i = 0; i <=7 ; i++) {
//            for (int j = 0; j <=7 ; j++) {
//                chessComponents[i][j].setChessComponents(chessComponents);
//            }
//        }
    }


    public ChessColor getCurrentPlayer(){

        return this.currentPlayer;
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];

    }
    public String getChessboardGraph(){
        List<String> row = new ArrayList<>();
        for (int i = 0; i <=10000 ; i++) {
            row.add("");
        }
        for (int i = 0; i <=7 ; i++) {
            String every = "";
            for (int j = 0; j <=7 ; j++) {
               every = every.concat(String.valueOf(chessComponents[i][j].name));
            }
            row.set(i,every);
        }
        String result = "";
        for (int i = 0; i <=7 ; i++) {
            result = result.concat(row.get(i));
            result = result.concat("\n");
        }

        return result;

    }
    public String getCapturedChess(ChessColor player){
        if(player.equals(ChessColor.BLACK)){
            int king = 1;
            int queen = 1;
            int rook = 2;
            int bishop = 2;
            int knight = 2;
            int pawn = 8;
            for (int i = 0; i <=7 ; i++) {
                for (int j = 0; j <=7 ; j++) {
                    if(String.valueOf(chessComponents[i][j].name).equals("K")){
                        king--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("Q")){
                        queen--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("R")){
                        rook--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("B")){
                        bishop--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("N")){
                        knight--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("P")){
                        pawn--;
                    }
                }
            }
            String result = "";
            if(king!=0){
                result = result.concat("K "+king+"\n");
            }
            if(queen!=0){
                result = result.concat("Q "+queen+"\n");
            }
            if(rook!=0){
                result = result.concat("R "+rook+"\n");
            }
            if(bishop!=0){
                result = result.concat("B "+bishop+"\n");
            }
            if(knight!=0){
                result = result.concat("N "+knight+"\n");
            }
            if(pawn!=0){
                result = result.concat("P "+pawn+"\n");
            }
            return result;
        }else{
            int king = 1;
            int queen = 1;
            int rook = 2;
            int bishop = 2;
            int knight = 2;
            int pawn = 8;
            for (int i = 0; i <=7 ; i++) {
                for (int j = 0; j <=7 ; j++) {
                    if(String.valueOf(chessComponents[i][j].name).equals("k")){
                        king--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("q")){
                        queen--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("r")){
                        rook--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("b")){
                        bishop--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("n")){
                        knight--;
                    }else if(String.valueOf(chessComponents[i][j].name).equals("p")){
                        pawn--;
                    }
                }
            }
            String result = "";
            if(king!=0){
                result = result.concat("k "+king+"\n");
            }
            if(queen!=0){
                result = result.concat("q "+queen+"\n");
            }
            if(rook!=0){
                result = result.concat("r "+rook+"\n");
            }
            if(bishop!=0){
                result = result.concat("b "+bishop+"\n");
            }
            if(knight!=0){
                result = result.concat("n "+knight+"\n");
            }
            if(pawn!=0){
                result = result.concat("p "+pawn+"\n");
            }
            return result;
        }


    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        return canMovePoints;
    }


    public boolean moveChess(int sourceX,int sourceY,int targetX,int targetY){
        int count = 0;
        if(chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            count = 0;
            if(chessComponents[sourceX][sourceY].canMoveTo().size()>=1){
                for (int i = 0; i <=chessComponents[sourceX][sourceY].canMoveTo().size()-1 ; i++) {
                    if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY){
                        count = 1;
                    }
                }
            }else{
                count = 0;
            }
           
        }
        if(count==1){
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(sourceX,sourceY));
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',chessComponents);
             if(currentPlayer.equals(ChessColor.BLACK) ){
                currentPlayer = ChessColor.WHITE;
            }else if(currentPlayer.equals(ChessColor.WHITE)){
                currentPlayer = ChessColor.BLACK;
            }

            return true;
        }
        return false;


    }


}

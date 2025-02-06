import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    public static ChessComponent[][] cb= new ChessComponent[8][8];
    public void loadChessGame(List<String> chessboard){
        RookChessComponent rookChessComponent = new RookChessComponent(ChessColor.WHITE);
        rookChessComponent.cleanup();
        BishopChessComponent bishopChessComponent = new BishopChessComponent(ChessColor.WHITE);
        bishopChessComponent.cleanup();
        KingChessComponent kingChessComponent = new KingChessComponent(ChessColor.WHITE);
        kingChessComponent.cleanup();
        KnightChessComponent knightChessComponent = new KnightChessComponent(ChessColor.WHITE);
        knightChessComponent.cleanup();
        PawnChessComponent pawnChessComponent = new PawnChessComponent(ChessColor.WHITE);
        pawnChessComponent.cleanup();
        QueenChessComponent queenChessComponent = new QueenChessComponent(ChessColor.WHITE);
        queenChessComponent.cleanup();
        for (int i = 0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK);
                }if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE);
                }if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE);
                }
                chessComponents[i][j].name = chessboard.get(i).charAt(j);
                chessComponents[i][j].setPos(i,j);
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }if (chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
        cb = chessComponents;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                sb.append(chessComponents[i][j].name);
            }
            if(i != 7){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder sb = new StringBuilder();
        if (player == ChessColor.BLACK){

            if (KingChessComponent.getCntblack() != 1){
                sb.append("K " + (1 - KingChessComponent.getCntblack()) + "\n");
            }
            if(QueenChessComponent.getCntblack() != 1){
                sb.append("Q " + (1 - QueenChessComponent.getCntblack()) + "\n");
            }
            if (RookChessComponent.getCntblack() != 2){
                sb.append("R " + (2 - RookChessComponent.getCntblack()) + "\n");
            }
            if(BishopChessComponent.getCntblack() != 2){
                sb.append("B " + (2 - BishopChessComponent.getCntblack()) + "\n");
            }
            if (KnightChessComponent.getCntblack() != 2){
                sb.append("N " + (2 - KnightChessComponent.getCntblack()) + "\n");
            }
            if (PawnChessComponent.getCntblack() != 8){
                sb.append("P " + (8 - PawnChessComponent.getCntblack()) + "\n");
            }
        }else if(player == ChessColor.WHITE){
            if (KingChessComponent.getCntwhite() != 1){
                sb.append("k " + (1 - KingChessComponent.getCntwhite()) + "\n");
            }
            if(QueenChessComponent.getCntwhite() != 1){
                sb.append("q " + (1 - QueenChessComponent.getCntwhite()) + "\n");
            }
            if (RookChessComponent.getCntwhite() != 2){
                sb.append("r " + (2 - RookChessComponent.getCntwhite()) + "\n");
            }
            if(BishopChessComponent.getCntwhite() != 2){
                sb.append("b " + (2 - BishopChessComponent.getCntwhite()) + "\n");
            }
            if (KnightChessComponent.getCntwhite() != 2){
                sb.append("n " + (2 - KnightChessComponent.getCntwhite()) + "\n");
            }
            if (PawnChessComponent.getCntwhite() != 8){
                sb.append("p " + (8 - PawnChessComponent.getCntwhite()) + "\n");
            }
        }
        return sb.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
//        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        System.out.println(chess.getColor());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX() != o2.getX())
                    return o1.getX() - o2.getX();
                return o1.getY() - o2.getY();
            }
        });
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        // did not replace the source chess component
        if(this.getChess(sourceX, sourceY).canMoveTo().contains(new ChessboardPoint(targetX,targetY)) && currentPlayer == this.getChess(sourceX, sourceY).getColor()){
            getChess(sourceX, sourceY).setPos(targetX,targetY);
            chessComponents[targetX][targetY].beEaten();
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            if (currentPlayer == ChessColor.WHITE){
                currentPlayer = ChessColor.BLACK;
            }else{
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        }else{
            return  false;
        }
    }

}

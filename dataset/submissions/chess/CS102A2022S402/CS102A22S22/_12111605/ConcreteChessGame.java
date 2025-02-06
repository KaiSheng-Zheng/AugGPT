import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ConcreteChessGame() {
        chessComponents =new  ChessComponent[8][8];
        currentPlayer= ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) >= 97 && chessboard.get(i).charAt(j) <= 122) {
                    if (chessboard.get(i).charAt(j) == 'r') {
                        chessComponents[i][j]=new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'n') {
                        chessComponents[i][j]=new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'b') {
                        chessComponents[i][j]=new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'q') {
                        chessComponents[i][j]=new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'k') {
                        chessComponents[i][j]=new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'p') {
                        chessComponents[i][j]=new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j));
                    }

                } else if (chessboard.get(i).charAt(j) >= 65 && chessboard.get(i).charAt(j) <= 90) {
                    if (chessboard.get(i).charAt(j) == 'R') {
                        chessComponents[i][j]=new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'N') {
                        chessComponents[i][j]=new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'B') {
                        chessComponents[i][j]=new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'Q') {
                        chessComponents[i][j]=new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'K') {
                        chessComponents[i][j]=new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'P') {
                        chessComponents[i][j]=new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j));
                    }
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j));
                }
                if (chessboard.get(8).charAt(0) == 'w') {
                    currentPlayer = ChessColor.WHITE;
                } else if (chessboard.get(8).charAt(0) == 'b') {
                    currentPlayer = ChessColor.BLACK;
                }
            }
        }
        loadChessGameForComponents();
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j].name);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int KingBlack =1;
        int QueenBlack =1;
        int RooksBlack =2;
        int BishopsBlack =2;
        int KnightsBlack =2;
        int PawnsBlack =8;

        int KingWhite = 1;
        int QueenWhite =1;
        int RooksWhite =2;
        int BishopsWhite =2;
        int KnightsWhite =2;
        int PawnsWhite =8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j]instanceof KingChessComponent && chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    KingBlack--;
                }
                if (chessComponents[i][j]instanceof QueenChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    QueenBlack--;
                }
                if (chessComponents[i][j]instanceof RookChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    RooksBlack--;
                }
                if (chessComponents[i][j] instanceof BishopChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    BishopsBlack--;
                }
                if (chessComponents[i][j]instanceof KnightChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    KnightsBlack--;
                }
                if (chessComponents[i][j]instanceof PawnChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    PawnsBlack--;
                }


                if (chessComponents[i][j]instanceof KingChessComponent && chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    KingWhite--;
                }
                if (chessComponents[i][j]instanceof QueenChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    QueenWhite--;
                }
                if (chessComponents[i][j]instanceof RookChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    RooksWhite--;
                }
                if (chessComponents[i][j] instanceof BishopChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    BishopsWhite--;
                }
                if (chessComponents[i][j]instanceof KnightChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    KnightsWhite--;
                }
                if (chessComponents[i][j]instanceof PawnChessComponent&& chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    PawnsWhite--;
                }
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (KingBlack != 0) {
                stringBuilder.append("K ").append(KingBlack).append("\n");
            }
            if (QueenBlack != 0) {
                stringBuilder.append("Q ").append(QueenBlack).append("\n");
            }
            if (RooksBlack != 0) {
                stringBuilder.append("R ").append(RooksBlack).append("\n");
            }
            if (BishopsBlack != 0) {
                stringBuilder.append("B ").append(BishopsBlack).append("\n");
            }
            if (KnightsBlack != 0) {
                stringBuilder.append("N ").append(KnightsBlack).append("\n");
            }
            if (PawnsBlack != 0) {
                stringBuilder.append("P ").append(PawnsBlack).append("\n");
            }
        }else if (player == ChessColor.WHITE){
            if (KingWhite != 0) {
                stringBuilder.append("k ").append(KingWhite).append("\n");
            }
            if (QueenWhite != 0) {
                stringBuilder.append("q ").append(QueenWhite).append("\n");
            }
            if (RooksWhite != 0) {
                stringBuilder.append("r ").append(RooksWhite).append("\n");
            }
            if (BishopsWhite != 0) {
                stringBuilder.append("b ").append(BishopsWhite).append("\n");
            }
            if (KnightsWhite != 0) {
                stringBuilder.append("n ").append(KnightsWhite).append("\n");
            }
            if (PawnsWhite != 0) {
                stringBuilder.append("p ").append(PawnsWhite).append("\n");
            }



        }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        ArrayList<ChessboardPoint> canMoved = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < canMovePoints.size(); k++) {
                    if (canMovePoints.get(k).getX()==i&&canMovePoints.get(k).getY()==j){
                        canMoved.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return canMoved;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()!=getCurrentPlayer())return false;
        for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
            if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX
                    &&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY
            && chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
                ChessComponent chessComponent=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY]=chessComponent;
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                if (getCurrentPlayer()==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else {
                    currentPlayer=ChessColor.WHITE;
                }
                loadChessGameForComponents();
                return true;
            }
        }
        return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public void loadChessGameForComponents(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                getChessComponents()[i][j].loadChessGame(getChessComponents(),getCurrentPlayer());
            }
        }
    }
}

import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;


    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        currentPlayer= ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'n' || chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent();
                }
                if (chessboard.get(i).charAt(j) == 'q' || chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent();
                }
                if (chessboard.get(i).charAt(j) == 'p' || chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent();
                }
                if (chessboard.get(i).charAt(j) == 'k' || chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent();
                }
                if (chessboard.get(i).charAt(j) == 'b' || chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent();
                }
                if (chessboard.get(i).charAt(j) == 'r' || chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent();
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
                this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                this.chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                if (chessboard.get(i).charAt(j) >= 'A' && chessboard.get(i).charAt(j) <= 'Z') {
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) >= 'a' && chessboard.get(i).charAt(j) <= 'z') {
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
            }
            ChessComponent.setChessComponents(this.chessComponents.clone());
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder = new StringBuilder();
        if (player == ChessColor.BLACK) {
            int Knight = 2, Pawn = 8, Bishop = 2, Rook = 2, King = 1, Queen = 1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'K') {King--;}
                    if (chessComponents[i][j].getName() == 'N') {Knight--;}
                    if (chessComponents[i][j].getName() == 'R') {Rook--;}
                    if (chessComponents[i][j].getName() == 'P') {Pawn--;}
                    if (chessComponents[i][j].getName() == 'Q') {Queen--;}
                    if (chessComponents[i][j].getName() == 'B') {Bishop--;}
                }
            }
            if (King != 0) {stringBuilder.append("K ").append(King);}
            if (Queen != 0) {stringBuilder.append("\nQ ").append(Queen);}
            if (Rook != 0) {stringBuilder.append("\nR ").append(Rook);}
            if (Bishop != 0) {stringBuilder.append("\nB ").append(Bishop);}
            if (Knight != 0) {stringBuilder.append("\nN ").append(Knight);}
            if (Pawn!=0){stringBuilder.append("\nP ").append(Pawn);}
        }
        else if (player == ChessColor.WHITE) {
            int Knight = 2, Pawn = 8, Bishop = 2, Rook = 2, King = 1, Queen = 1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'k') {King--;}
                    if (chessComponents[i][j].getName() == 'n') {Knight--;}
                    if (chessComponents[i][j].getName() == 'r') {Rook--;}
                    if (chessComponents[i][j].getName() == 'p') {Pawn--;}
                    if (chessComponents[i][j].getName() == 'q') {Queen--;}
                    if (chessComponents[i][j].getName() == 'b') {Bishop--;}
                }
            }
            if (King != 0) {stringBuilder.append("k ").append(King);}
            if (Queen != 0) {stringBuilder.append("\nq ").append(Queen);}
            if (Rook != 0) {stringBuilder.append("\nr ").append(Rook);}
            if (Bishop != 0) {stringBuilder.append("\nb ").append(Bishop);}
            if (Knight != 0) {stringBuilder.append("\nn ").append(Knight);}
            if (Pawn!=0){stringBuilder.append("\np ").append(Pawn);}
        }
        return stringBuilder.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = this.getChess(source.getX(),source.getY()).canMoveTo();
        canMovePoints.sort((c1,c2)->Float.compare(c1.getY(),c2.getY()));
        canMovePoints.sort((c1,c2)->Float.compare(c1.getX(),c2.getX()));
        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);
        if (currentPlayer==chessComponents[sourceX][sourceY].getChessColor()&&chessComponents[sourceX][sourceY].canMoveTo().contains(target)) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setName('_');
            chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            ChessComponent.setChessComponents(this.chessComponents);
            return true;
        }
        return false;
        }


}
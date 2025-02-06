import java.util.List;

public class ConcreteChessGame implements ChessGame{
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessComponent[][] chessComponents;

    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        String str;
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                str = chessboard.get(i).substring(j,j + 1);
                switch (str) {
                    case "K" -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    case "k" -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    case "Q" -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    case "q" -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    case "R" -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    case "r" -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    case "N" -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    case "n" -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    case "B" -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    case "b" -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    case "P" -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    case "p" -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    case "_" -> chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder chessboardGraph = new StringBuilder();
        char name;
        for(int i =0;i < 8;i++){
            for(int j = 0;j < 8;j++) {
                name = chessComponents[i][j].name;
                chessboardGraph.append(name);
            }
        }
        String string = chessboardGraph.toString();
        String str;
        str = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",string.substring(0,8),string.substring(8,16),string.substring(16,24),
                string.substring(24,32),string.substring(32,40),string.substring(40,48),string.substring(48,56),string.substring(56,64));
        return str;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        char name;
        int countKing = 0;
        int countQueen = 0;
        int countRook = 0;
        int countBishop = 0;
        int countKnight = 0;
        int countPawn = 0;
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++) {
                name = chessComponents[i][j].name;
                stringBuilder.append(name);
            }
        }
        if(player == ChessColor.BLACK){
            for(int i = 0;i < stringBuilder.toString().length();i++){
                if(stringBuilder.substring(i,i + 1).equals("K")){
                    countKing++;
                }if(stringBuilder.substring(i,i + 1).equals("Q")){
                    countQueen++;
                }if(stringBuilder.substring(i,i + 1).equals("R")){
                    countRook++;
                }if(stringBuilder.substring(i,i + 1).equals("B")){
                    countBishop++;
                }if(stringBuilder.substring(i,i + 1).equals("N")){
                    countKnight++;
                }if(stringBuilder.substring(i,i + 1).equals("P")){
                    countPawn++;
                }
            }
            if(countKing == 0){str.append("K 1\n");}

            if(countQueen == 0){str.append("Q 1\n");}

            if(countRook == 1){str.append("R 1\n");}
            if(countRook == 0){str.append("R 2\n");}

            if(countBishop == 1){str.append("B 1\n");}
            if(countBishop == 0){str.append("B 2\n");}

            if(countKnight == 1){str.append("N 1\n");}
            if(countKnight == 0){str.append("N 2\n");}

            if(countPawn == 7){str.append("P 1\n");}
            if(countPawn == 6){str.append("P 2\n");}
            if(countPawn == 5){str.append("P 3\n");}
            if(countPawn == 4){str.append("P 4\n");}
            if(countPawn == 3){str.append("P 5\n");}
            if(countPawn == 2){str.append("P 6\n");}
            if(countPawn == 1){str.append("P 7\n");}
            if(countPawn == 0){str.append("P 8\n");}
        }
        if(player == ChessColor.WHITE){
            for(int i = 0;i < stringBuilder.toString().length();i++){
                if(stringBuilder.substring(i,i + 1).equals("k")){
                    countKing++;
                }if(stringBuilder.substring(i,i + 1).equals("q")){
                    countQueen++;
                }if(stringBuilder.substring(i,i + 1).equals("r")){
                    countRook++;
                }if(stringBuilder.substring(i,i + 1).equals("b")){
                    countBishop++;
                }if(stringBuilder.substring(i,i + 1).equals("n")){
                    countKnight++;
                }if(stringBuilder.substring(i,i + 1).equals("p")){
                    countPawn++;
                }
            }
            if(countKing == 0){str.append("k 1\n");}

            if(countQueen == 0){str.append("q 1\n");}

            if(countRook == 1){str.append("r 1\n");}
            if(countRook == 0){str.append("r 2\n");}

            if(countBishop == 1){str.append("b 1\n");}
            if(countBishop == 0){str.append("b 2\n");}

            if(countKnight == 1){str.append("n 1\n");}
            if(countKnight == 0){str.append("n 2\n");}

            if(countPawn == 7){str.append("p 1\n");}
            if(countPawn == 6){str.append("p 2\n");}
            if(countPawn == 5){str.append("p 3\n");}
            if(countPawn == 4){str.append("p 4\n");}
            if(countPawn == 3){str.append("p 5\n");}
            if(countPawn == 2){str.append("p 6\n");}
            if(countPawn == 1){str.append("p 7\n");}
            if(countPawn == 0){str.append("p 8\n");}
        }
        return str.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        char name;
        name = chessComponents[x][y].name;
        switch (name){
            case 'K' -> {return new KingChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK,'K');}
            case 'k' -> {return new KingChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE,'k');}
            case 'Q' -> {return new QueenChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK,'Q');}
            case 'q' -> {return new QueenChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE,'q');}
            case 'R' -> {return new RookChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK,'R');}
            case 'r' -> {return new RookChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE,'r');}
            case 'N' -> {return new KnightChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK,'N');}
            case 'n' -> {return new KnightChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE,'n');}
            case 'B' -> {return new BishopChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK,'B');}
            case 'b' -> {return new BishopChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE,'b');}
            case 'P' -> {return new PawnChessComponent(new ChessboardPoint(x, y),ChessColor.BLACK,'P');}
            case 'p' -> {return new PawnChessComponent(new ChessboardPoint(x, y),ChessColor.WHITE,'p');}
            case '_' -> {return new EmptySlotComponent(new ChessboardPoint(x, y),ChessColor.NONE,'_');}
        }
        return null;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){//not sure
        if(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)) != null) {
            for (int i = 0; i < getCanMovePoints(new ChessboardPoint(sourceX, sourceY)).size(); i++) {
                if(targetX >= 0 && targetX < 8 && targetY >= 0 && targetY < 8) {
                    if (getCanMovePoints(new ChessboardPoint(sourceX, sourceY)).get(i).getX() == new ChessboardPoint(targetX, targetY).getX()
                            && getCanMovePoints(new ChessboardPoint(sourceX, sourceY)).get(i).getY() == new ChessboardPoint(targetX, targetY).getY()
                            // points that can move   are able to move to the target coordinate
                            && ((currentPlayer == ChessColor.BLACK && getChess(sourceX, sourceY).getChessColor() == ChessColor.BLACK)
                            // using chess's name to judge whether the currentPlayer is suitable(BLACK, name is UpperCase
                            || (currentPlayer == ChessColor.WHITE && getChess(sourceX, sourceY).getChessColor() == ChessColor.WHITE))
                        // using chess's name to judge whether the currentPlayer is suitable(WHITE, name is LowerCase
                    ) {
                        char name;
                        name = chessComponents[sourceX][sourceY].name;
                        switch (name) {
                            case 'K' -> chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'K');
                            case 'k' -> chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'k');
                            case 'Q' -> chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'Q');
                            case 'q' -> chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'q');
                            case 'R' -> chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'R');
                            case 'r' -> chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'r');
                            case 'N' -> chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'N');
                            case 'n' -> chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'n');
                            case 'B' -> chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'B');
                            case 'b' -> chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'b');
                            case 'P' -> chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'P');
                            case 'p' -> chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'p');
                            case '_' -> chessComponents[targetX][targetY] = new EmptySlotComponent(new ChessboardPoint(targetX, targetY), ChessColor.NONE, '_');
                        }
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                        if(currentPlayer == ChessColor.BLACK){
                            currentPlayer = ChessColor.WHITE;
                        }else if(currentPlayer == ChessColor.WHITE){
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
            // 1. find chess according to source
            //ChessComponent chess = getChess(source.getX(), source.getY()); // not sure
            ChessComponent chess = chessComponents[source.getX()][source.getY()];
            chess.setChessboard(chessComponents);
            // 2. as below statement:
            List<ChessboardPoint> canMovePoints0 = chess.canMoveTo();
            // 3.sort canMovePoints0 by x - y ascending order
            if(canMovePoints0 != null) {
                for (int i = 0; i < canMovePoints0.size(); i++) {
                    for (int j = 0; j < canMovePoints0.size() - 1; j++) {
                        if (canMovePoints0.get(j).getX() > canMovePoints0.get(j + 1).getX()) { // sort by x
                            ChessboardPoint chessboardPoint = canMovePoints0.get(j);
                            canMovePoints0.set(j, canMovePoints0.get(j + 1));
                            canMovePoints0.set(j + 1, chessboardPoint);
                        }if(canMovePoints0.get(j).getX() == canMovePoints0.get(j + 1).getX() &&
                                // if x is equal sort by y (not sure)
                                canMovePoints0.get(j).getY() > canMovePoints0.get(j + 1).getY()){
                            ChessboardPoint chessboardPoint = canMovePoints0.get(j);
                            canMovePoints0.set(j, canMovePoints0.get(j + 1));
                            canMovePoints0.set(j + 1, chessboardPoint);
                        }
                    }
                }
            }
            return canMovePoints0;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[] chessComponents = new ChessComponent[1];
        char name;
        for(int i =0;i < 8;i++){
            for(int j = 0;j < 8;j++) {
                name = this.chessComponents[i][j].name;
                switch (name){
                    case 'K' -> chessComponents[0] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    case 'k' -> chessComponents[0] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    case 'Q' -> chessComponents[0] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    case 'q' -> chessComponents[0] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    case 'R' -> chessComponents[0] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    case 'r' -> chessComponents[0] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    case 'N' -> chessComponents[0] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    case 'n' -> chessComponents[0] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    case 'B' -> chessComponents[0] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    case 'b' -> chessComponents[0] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    case 'P' -> chessComponents[0] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    case 'p' -> chessComponents[0] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    case '_' -> chessComponents[0] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'_');
                }
            }
        }
        return chessComponents[0].canMoveTo();
    }
}

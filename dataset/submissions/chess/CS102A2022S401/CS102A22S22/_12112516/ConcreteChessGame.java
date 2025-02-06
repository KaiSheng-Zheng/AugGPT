import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    public List<String> chessboard;


    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        setChessComponents();
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
        ChessComponent.chessComponents = this.chessComponents;
    }

    @Override
    public void setCurrentPlayer(ChessColor chessColor) {
        this.currentPlayer = chessColor;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        if (this.chessboard.isEmpty()) {
            return null;
        } else {
            return chessboard.get(0) + "\n" + chessboard.get(1) + "\n" + chessboard.get(2) + "\n" + chessboard.get(3)
                    + "\n" + chessboard.get(4) + "\n" + chessboard.get(5) + "\n" + chessboard.get(6) + "\n" + chessboard.get(7);
        }
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        byte multiplier;
        if (player == ChessColor.BLACK) {
            multiplier = 0;
        } else {
            multiplier = 1;
        }
        return getResult(multiplier);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess;
        chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> tempCanMoveToPoints;
        tempCanMoveToPoints = chess.canMoveTo();

        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        for (int j = 0; j <= 7; j++) {
            List<ChessboardPoint> temp = new ArrayList<>();
            for (ChessboardPoint tempCanMoveToPoint : tempCanMoveToPoints) {
                if (tempCanMoveToPoint.getX() == j) {
                    temp.add(tempCanMoveToPoint);
                }
            }

            List<Integer> forTemp = new ArrayList<>();
            for (ChessboardPoint chessboardPoint : temp) {
                forTemp.add(chessboardPoint.getX() + chessboardPoint.getY());
            }
            forTemp.sort(Comparator.naturalOrder());

            List<ChessboardPoint> tempTemp = new ArrayList<>();
            for (Integer integer : forTemp) {
                for (ChessboardPoint chessboardPoint : temp) {
                    if ((chessboardPoint.getX() + chessboardPoint.getY()) == integer) {
                        tempTemp.add(chessboardPoint);
                    }
                }
            }

            canMoveToPoints.addAll(tempTemp);
        }
        return canMoveToPoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);

        ChessComponent sourceChess = getChess(sourceX, sourceY);
        ChessComponent targetChess = getChess(targetX, targetY) ;
        if (currentPlayer.equals(sourceChess.getChessColor())) {
            if (sourceChess.getName() == '_') {
                return false;
            }
            if (has(target, sourceChess)) {
                /*sourceChess.setSource(new ChessboardPoint(targetX, targetY));
                sourceChess.setChessColor(currentPlayer);
                this.chessComponents[targetX][targetY] = sourceChess;
                this.chessComponents[targetX][targetY].setChessColor(sourceChess.getChessColor());
                this.chessComponents[targetX][targetY].setSource(targetChess.getSource());
                this.chessComponents[targetX][targetY].setName(sourceChess.name);*/

                /*EmptySlotComponent E = new EmptySlotComponent();
                E.setChessColor(ChessColor.NONE);
                E.setName('_');
                E.setSource(new ChessboardPoint(sourceX, sourceY));
                this.chessComponents[sourceX][sourceY] = E;
                this.chessComponents[sourceX][sourceY].setName('_');
                this.chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                this.chessComponents[sourceX][sourceY].setSource(sourceChess.getSource());*/
                targetChess.setSource(new ChessboardPoint(sourceX, sourceY));
                sourceChess.setSource(new ChessboardPoint(targetX, targetY));
                this.chessComponents[targetX][targetY] = sourceChess;
                this.chessComponents[sourceX][sourceY] = targetChess;
                EmptySlotComponent emptySlotComponent = new EmptySlotComponent();
                emptySlotComponent.setName('_');
                emptySlotComponent.setChessColor(ChessColor.NONE);
                emptySlotComponent.setSource(targetChess.getSource());
                this.chessComponents[sourceX][sourceY] = emptySlotComponent;


                ChessComponent nowTargetChess = getChess(targetX, targetY);
                getChess(targetX, targetY);
                if (nowTargetChess.getChessColor() == ChessColor.WHITE) {
                    setCurrentPlayer(ChessColor.BLACK);
                }
                if (nowTargetChess.getChessColor() == ChessColor.BLACK) {
                    setCurrentPlayer(ChessColor.WHITE);
                }
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    public void setChessComponents(){
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case '_' -> {
                        EmptySlotComponent E = new EmptySlotComponent();
                        E.setChessColor(ChessColor.NONE);
                        E.setName('_');
                        E.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = E;
                    }
                    case 'R' -> {
                        RookChessComponent R = new RookChessComponent();
                        R.setSource(new ChessboardPoint(i, j));
                        R.setName('R');
                        R.setChessColor(ChessColor.BLACK);
                        chessComponents[i][j] = R;
                    }
                    case 'r' -> {
                        RookChessComponent r = new RookChessComponent();
                        r.setSource(new ChessboardPoint(i, j));
                        r.setName('r');
                        r.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = r;
                    }
                    case 'B' -> {
                        BishopChessComponent B = new BishopChessComponent();
                        B.setSource(new ChessboardPoint(i, j));
                        B.setChessColor(ChessColor.BLACK);
                        B.setName('B');
                        chessComponents[i][j] = B;
                    }
                    case 'b' -> {
                        BishopChessComponent b = new BishopChessComponent();
                        b.setSource(new ChessboardPoint(i, j));
                        b.setChessColor(ChessColor.WHITE);
                        b.setName('b');
                        chessComponents[i][j] = b;
                    }
                    case 'K' -> {
                        KingChessComponent K = new KingChessComponent();
                        K.setChessColor(ChessColor.BLACK);
                        K.setName('K');
                        K.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = K;
                    }
                    case 'k' -> {
                        KingChessComponent k = new KingChessComponent();
                        k.setChessColor(ChessColor.WHITE);
                        k.setName('k');
                        k.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = k;
                    }
                    case 'N' -> {
                        KnightChessComponent N = new KnightChessComponent();
                        N.setChessColor(ChessColor.BLACK);
                        N.setName('N');
                        N.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = N;
                    }
                    case 'n' -> {
                        KnightChessComponent n = new KnightChessComponent();
                        n.setChessColor(ChessColor.WHITE);
                        n.setName('n');
                        n.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = n;
                    }
                    case 'P' -> {
                        PawnChessComponent P = new PawnChessComponent();
                        P.setChessColor(ChessColor.BLACK);
                        P.setName('P');
                        P.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = P;
                    }
                    case 'p' -> {
                        PawnChessComponent p = new PawnChessComponent();
                        p.setChessColor(ChessColor.WHITE);
                        p.setName('p');
                        p.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = p;
                    }
                    case 'Q' -> {
                        QueenChessComponent Q = new QueenChessComponent();
                        Q.setChessColor(ChessColor.BLACK);
                        Q.setSource(new ChessboardPoint(i, j));
                        Q.setName('Q');
                        chessComponents[i][j] = Q;
                    }
                    case 'q' -> {
                        QueenChessComponent q = new QueenChessComponent();
                        q.setName('q');
                        q.setChessColor(ChessColor.WHITE);
                        q.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = q;
                    }
                }
            }
        }
    }

    public String getResult(byte multiplier) {
        int numR = 0, numK = 0, numN = 0, numQ = 0, numB = 0, numP = 0;
        String result = "";
        if(multiplier == 0){
            for (int i = 0; i < chessboard.size() - 1; i++) {
                for (int j = 0; j < chessboard.get(i).length(); j++) {
                    int substitution = chessboard.get(i).charAt(j) - multiplier * 32;
                    switch (substitution) {
                        case 82 -> numR += 1;
                        case 75 -> numK += 1;
                        case 78 -> numN += 1;
                        case 66 -> numB += 1;
                        case 80 -> numP += 1;
                        case 81 -> numQ += 1;
                    }
                }
            }
            if (numK != 1) {
                result = result + ((char) ('K' + multiplier * 32)) + ' ' + (1 - numK) + "\n";
            }
            if (numQ != 1) {
                result = result + ((char) ('Q' + multiplier * 32)) + ' ' + (1 - numQ) + "\n";
            }
            if (numR != 2) {
                result = result + ((char) ('R' + multiplier * 32)) + ' ' + (2 - numR) + "\n";
            }
            if (numB != 2) {
                result = result + ((char) ('B' + multiplier * 32)) + ' ' + (2 - numB) + "\n";
            }
            if (numN != 2) {
                result = result + ((char) ('N' + multiplier * 32)) + ' ' + (2 - numN) + "\n";
            }
            if (numP != 8) {
                result = result + ((char) ('P' + multiplier * 32)) + ' ' + (8 - numP) + "\n";
            }
        }
        else{
            for (int i = 0; i < chessboard.size() - 1; i++) {
                for (int j = 0; j < chessboard.get(i).length(); j++) {
                    int substitution = chessboard.get(i).charAt(j);
                    switch (substitution) {
                        case 114 -> numR += 1;
                        case 107 -> numK += 1;
                        case 110 -> numN += 1;
                        case 98 -> numB += 1;
                        case 112 -> numP += 1;
                        case 113 -> numQ += 1;
                    }
                }
            }
            if (numK != 1) {
                result = result + 'k' + ' ' + (1 - numK) + "\n";
            }
            if (numQ != 1) {
                result = result + 'q' + ' ' + (1 - numQ) + "\n";
            }
            if (numR != 2) {
                result = result + 'r' + ' ' + (2 - numR) + "\n";
            }
            if (numB != 2) {
                result = result + 'b' + ' ' + (2 - numB) + "\n";
            }
            if (numN != 2) {
                result = result + 'n' + ' ' + (2 - numN) + "\n";
            }
            if (numP != 8) {
                result = result + 'p' + ' ' + (8 - numP) + "\n";
            }
        }
        return result;
    }

    public boolean has(ChessboardPoint chessboardPoint, ChessComponent chessComponent){
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(chessComponent.getSource());
        for (ChessboardPoint point : chessboardPoints) {
            if (point.getX() == chessboardPoint.getX() && point.getY() == chessboardPoint.getY()) {
                return true;
            }
        }
        return false;
    }
}


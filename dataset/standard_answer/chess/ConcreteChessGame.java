
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //set ChessboardPoint
                switch (chessboard.get(i).charAt(j)) {
                    case 'p': {
                        this.chessComponents[i][j] = new PawnChessComponent();
                        this.chessComponents[i][j].setName('p');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    }
                    case 'k': {
                        this.chessComponents[i][j] = new KingChessComponent();
                        this.chessComponents[i][j].setName('k');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    }
                    case 'r': {
                        this.chessComponents[i][j] = new RookChessComponent();
                        this.chessComponents[i][j].setName('r');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    }
                    case 'n': {
                        this.chessComponents[i][j] = new KnightChessComponent();
                        this.chessComponents[i][j].setName('n');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    }
                    case 'b': {
                        this.chessComponents[i][j] = new BishopChessComponent();
                        this.chessComponents[i][j].setName('b');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    }
                    case 'q': {
                        this.chessComponents[i][j] = new QueenChessComponent();
                        this.chessComponents[i][j].setName('q');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    }
                    case 'P': {
                        this.chessComponents[i][j] = new PawnChessComponent();
                        this.chessComponents[i][j].setName('P');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    }
                    case 'K': {
                        this.chessComponents[i][j] = new KingChessComponent();
                        this.chessComponents[i][j].setName('K');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    }
                    case 'R': {
                        this.chessComponents[i][j] = new RookChessComponent();
                        this.chessComponents[i][j].setName('R');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    }
                    case 'N': {
                        this.chessComponents[i][j] = new KnightChessComponent();
                        this.chessComponents[i][j].setName('N');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    }
                    case 'B': {
                        this.chessComponents[i][j] = new BishopChessComponent();
                        this.chessComponents[i][j].setName('B');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    }
                    case 'Q': {
                        this.chessComponents[i][j] = new QueenChessComponent();
                        this.chessComponents[i][j].setName('Q');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    }
                    case '_': {
                        this.chessComponents[i][j] = new EmptySlotComponent();
                        this.chessComponents[i][j].setName('_');
                        this.chessComponents[i][j].setSource(i, j);
                        this.chessComponents[i][j].setChessComponents(chessComponents);
                        this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                    }
                }
            }
        }
        //
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    @Override
    public ChessComponent getChess(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        } else {
            return this.chessComponents[x][y];
        }
    }

    @Override
    public String getChessboardGraph() {
        String str = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str = str.concat(chessComponents[i][j].toString());
            }
            str = str.concat("\n");
        }
        return str;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder s = new StringBuilder();
        int Rr = 2;
        int Nn = 2;
        int Bb = 2;
        int Qq = 1;
        int Kk = 1;
        int Pp = 8;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'r') {
                        Rr--;
                    }
                    if (chessComponents[i][j].getName() == 'n') {
                        Nn--;
                    }
                    if (chessComponents[i][j].getName() == 'b') {
                        Bb--;
                    }
                    if (chessComponents[i][j].getName() == 'q') {
                        Qq--;
                    }
                    if (chessComponents[i][j].getName() == 'k') {
                        Kk--;
                    }
                    if (chessComponents[i][j].getName() == 'p') {
                        Pp--;
                    }
                }
            }
            if (Kk != 0) {
                s.append('k').append(' ').append(Kk);
                s.append('\n');
            }
            if (Qq != 0) {
                s.append('q').append(' ').append(Qq);
                s.append('\n');
            }
            if (Rr != 0) {
                s.append('r').append(' ').append(Rr);
                s.append('\n');
            }
            if (Bb != 0) {
                s.append('b').append(' ').append(Bb);
                s.append('\n');
            }
            if (Nn != 0) {
                s.append('n').append(' ').append(Nn);
                s.append('\n');
            }
            if (Pp != 0) {
                s.append('p').append(' ').append(Pp);
                s.append('\n');
            }
        }

        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'R') {
                        Rr--;
                    }
                    if (chessComponents[i][j].getName() == 'N') {
                        Nn--;
                    }
                    if (chessComponents[i][j].getName() == 'B') {
                        Bb--;
                    }
                    if (chessComponents[i][j].getName() == 'Q') {
                        Qq--;
                    }
                    if (chessComponents[i][j].getName() == 'K') {
                        Kk--;
                    }
                    if (chessComponents[i][j].getName() == 'P') {
                        Pp--;
                    }
                }
            }
            if (Kk != 0) {
                s.append('K').append(' ').append(Kk);
                s.append('\n');
            }
            if (Qq != 0) {
                s.append('Q').append(' ').append(Qq);
                s.append('\n');
            }
            if (Rr != 0) {
                s.append('R').append(' ').append(Rr);
                s.append('\n');
            }
            if (Bb != 0) {
                s.append('B').append(' ').append(Bb);
                s.append('\n');
            }
            if (Nn != 0) {
                s.append('N').append(' ').append(Nn);
                s.append('\n');
            }
            if (Pp != 0) {
                s.append('P').append(' ').append(Pp);
                s.append('\n');
            }
        }
        return s.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess1 = getChess(sourceX, sourceY);
        ChessComponent chess2 = getChess(targetX, targetY);

        if (chess1.getChessColor() != this.currentPlayer) {
            return false;
        } else if (!chess1.canMoveTo().contains(chess2.getSource())) {
            return false;
        } else {
            chess1.setSource(targetX, targetY);

            chessComponents[targetX][targetY] = chess1;
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(targetX,targetY);

            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setName('_');
            chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);


            if (getCurrentPlayer()==ChessColor.WHITE)
            {setCurrentPlayer(ChessColor.BLACK);}
            else {setCurrentPlayer(ChessColor.WHITE);}
            return true;
        }
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}


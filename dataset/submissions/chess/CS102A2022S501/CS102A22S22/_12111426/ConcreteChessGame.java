import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(chessboard.get(chessboard.size() - 1), "w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'p' || chessboard.get(i).charAt(j) == 'P') {
                    ChessComponent a = new PawnChessComponent();
                    a.setSource(new ChessboardPoint(i,j));
                    a.name = chessboard.get(i).charAt(j);
                    if (chessboard.get(i).charAt(j) == 'p') {
                        a.setChessColor(ChessColor.WHITE);
                    } else {
                        a.setChessColor(ChessColor.BLACK);
                    }
                    this.chessComponents[i][j] = a;
                    a.setChessComponents(chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'r' || chessboard.get(i).charAt(j) == 'R') {
                    ChessComponent b = new RookChessComponent();
                    b.setSource(new ChessboardPoint(i,j));
                    b.name = chessboard.get(i).charAt(j);
                    if (chessboard.get(i).charAt(j) == 'r') {
                        b.setChessColor(ChessColor.WHITE);
                    } else {
                        b.setChessColor(ChessColor.BLACK);
                    }
                    this.chessComponents[i][j] = b;
                    b.setChessComponents(chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'b' || chessboard.get(i).charAt(j) == 'B') {
                    ChessComponent c = new BishopChessComponent();
                    c.setSource(new ChessboardPoint(i,j));
                    c.name = chessboard.get(i).charAt(j);
                    if (chessboard.get(i).charAt(j) == 'b') {
                        c.setChessColor(ChessColor.WHITE);
                    } else {
                        c.setChessColor(ChessColor.BLACK);
                    }
                    this.chessComponents[i][j] = c;
                    c.setChessComponents(chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'q' || chessboard.get(i).charAt(j) == 'Q') {
                    ChessComponent d = new QueenChessComponent();
                    d.setSource(new ChessboardPoint(i,j));
                    d.name = chessboard.get(i).charAt(j);
                    if (chessboard.get(i).charAt(j) == 'q') {
                        d.setChessColor(ChessColor.WHITE);
                    } else {
                        d.setChessColor(ChessColor.BLACK);
                    }
                    this.chessComponents[i][j] = d;
                    d.setChessComponents(chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'k' || chessboard.get(i).charAt(j) == 'K') {
                    ChessComponent e = new KingChessComponent();
                    e.setSource(new ChessboardPoint(i,j));
                    e.name = chessboard.get(i).charAt(j);
                    if (chessboard.get(i).charAt(j) == 'k') {
                        e.setChessColor(ChessColor.WHITE);
                    } else {
                        e.setChessColor(ChessColor.BLACK);
                    }
                    this.chessComponents[i][j] = e;
                    e.setChessComponents(chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'n' || chessboard.get(i).charAt(j) == 'N') {
                    ChessComponent f = new KnightChessComponent();
                    f.setSource(new ChessboardPoint(i,j));
                    f.name = chessboard.get(i).charAt(j);
                    if (chessboard.get(i).charAt(j) == 'n') {
                        f.setChessColor(ChessColor.WHITE);
                    } else {
                        f.setChessColor(ChessColor.BLACK);
                    }
                    this.chessComponents[i][j] = f;
                    f.setChessComponents(chessComponents);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    ChessComponent g = new EmptySlotComponent();
                    g.setSource(new ChessboardPoint(i,j));
                    g.name = chessboard.get(i).charAt(j);
                    g.setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j] = g;
                    g.setChessComponents(chessComponents);
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String[] b = new String[8];
        for (int i = 0; i < 8; i++) {
            StringBuilder a = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                a.append(this.chessComponents[i][j]);
            }
            b[i] = a.toString();
        }
        StringBuilder C = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            C.append(b[i]).append("\n");
        }
        return C.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.chessComponents[i][j].name == 'k') {
                        ++c1;
                    }
                    if (this.chessComponents[i][j].name == 'q') {
                        c2 = c2 + 1;
                    }
                    if (this.chessComponents[i][j].name == 'r') {
                        c3 = c3 + 1;
                    }
                    if (this.chessComponents[i][j].name == 'b') {
                        c4 = c4 + 1;
                    }
                    if (this.chessComponents[i][j].name == 'n') {
                        c5 = c5 + 1;
                    }
                    if (this.chessComponents[i][j].name == 'p') {
                        c6 = c6 + 1;
                    }
                }
            }
            ArrayList<String> a = new ArrayList<>();
            if (c1<1) {
                a.add(String.format("k %d", 1 - c1));
            }
            if (c2 < 1) {
                a.add(String.format("q %d", 1 - c2));
            }
             if (c3 < 2) {
                a.add(String.format("r %d", 2 - c3));
            }
             if (c4< 2) {
                a.add(String.format("b %d", 2 - c4));
            }
             if (c5 < 2) {
                a.add(String.format("n %d", 2 - c5));
            }
            if (c6 < 8) {
                a.add(String.format("p %d", 8 - c6));
            }
            StringBuilder p = new StringBuilder();
            for (int i = 0; i < a.size(); i++) {
                p.append(a.get(i)).append("\n");
            }
            return p.toString();
        } else {
            if (player == ChessColor.BLACK) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (this.chessComponents[i][j].name == 'K') {
                            ++c1;
                        }
                            if (this.chessComponents[i][j].name == 'Q') {
                                ++c2;
                            }
                            if (this.chessComponents[i][j].name == 'R') {
                                ++c3;
                            }
                            if (this.chessComponents[i][j].name == 'B') {
                                ++c4;
                            }
                            if (this.chessComponents[i][j].name == 'N') {
                                ++c5;
                            }
                            if (this.chessComponents[i][j].name == 'P') {
                                ++c6;
                            }
                        }
                    }
                ArrayList<String> a = new ArrayList<>();
                if(c1<1){
                    a.add(String.format("K %d",1-c1));
                }
                if (c2 < 1) {
                    a.add(String.format("Q %d", 1 - c2));
                }
                if (c3 < 2) {
                    a.add(String.format("R %d", 2 - c3));
                }
                if (c4 < 2) {
                    a.add(String.format("B %d", 2 - c4));
                }
                if (c5 < 2) {
                    a.add(String.format("N %d", 2 - c5));
                }
                if (c6 < 8) {
                    a.add(String.format("P %d", 8 - c6));
                }
                StringBuilder p = new StringBuilder();
                for (int i = 0; i < a.size(); i++) {
                    p.append(a.get(i)).append("\n");
                }
                return p.toString();

            }
        }return null;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getY));
        canMovePoints.sort(Comparator.comparingInt(ChessboardPoint::getX));
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            if (contains(getChess(sourceX,sourceY),targetX,targetY)){
                   this.chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                   this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                   this.chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                   this.chessComponents[sourceX][sourceY].setName('_');
                   this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if (this.currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else if (this.currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }
                return true;

            }return false;
        }return false;
    }
    public boolean contains(ChessComponent a,int targetX,int targetY){
        for (int i=0;i<a.canMoveTo().size();i++){
            if (a.canMoveTo().get(i).getX()==targetX&&a.canMoveTo().get(i).getY()==targetY){
                return true;
            }
        }return false;
    }
}

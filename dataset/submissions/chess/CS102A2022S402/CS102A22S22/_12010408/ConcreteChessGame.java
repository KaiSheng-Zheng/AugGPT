import java.util.*;

public class ConcreteChessGame extends ChessComponent implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char a = chessboard.get(i).charAt(j);
                if (a == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),
                            ChessColor.BLACK, 'K', this.chessComponents);
                } else if (a == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),
                            ChessColor.WHITE, 'k', this.chessComponents);
                } else if (a == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j),
                            ChessColor.BLACK, 'Q', this.chessComponents);
                } else if (a == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j),
                            ChessColor.WHITE, 'q', this.chessComponents);
                } else if (a == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j),
                            ChessColor.BLACK, 'R', this.chessComponents);
                } else if (a == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j),
                            ChessColor.WHITE, 'r', this.chessComponents);
                } else if (a == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j),
                            ChessColor.BLACK, 'B', this.chessComponents);
                } else if (a == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j),
                            ChessColor.WHITE, 'b', this.chessComponents);
                } else if (a == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j),
                            ChessColor.BLACK, 'N', this.chessComponents);
                } else if (a == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j),
                            ChessColor.WHITE, 'n', this.chessComponents);
                } else if (a == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j),
                            ChessColor.BLACK, 'P', this.chessComponents);
                } else if (a == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j),
                            ChessColor.WHITE, 'p', this.chessComponents);
                } else {
                    this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j),
                            ChessColor.NONE, '_', this.chessComponents);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "b")) this.currentPlayer = ChessColor.BLACK;
        else this.currentPlayer = ChessColor.WHITE;
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
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(this.chessComponents[i][j].name);
            }
            s.append("\n");
        }
        return s.substring(0, s.length());
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int p = 0;
        StringBuilder s = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.chessComponents[i][j].name == 'K') k++;
                    else if (this.chessComponents[i][j].name == 'Q') q++;
                    else if (this.chessComponents[i][j].name == 'R') r++;
                    else if (this.chessComponents[i][j].name == 'B') b++;
                    else if (this.chessComponents[i][j].name == 'N') n++;
                    else if (this.chessComponents[i][j].name == 'P') p++;
                }
            }
            if (k == 0) s.append("K 1\n");
            if (q == 0) s.append("Q 1\n");
            if (r < 2) s.append("R ").append(2 - r).append("\n");
            if (b < 2) s.append("B ").append(2 - b).append("\n");
            if (n < 2) s.append("N ").append(2 - n).append("\n");
            if (p < 8) s.append("P ").append(8 - p).append("\n");
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.chessComponents[i][j].name == 'k') k++;
                    else if (this.chessComponents[i][j].name == 'q') q++;
                    else if (this.chessComponents[i][j].name == 'r') r++;
                    else if (this.chessComponents[i][j].name == 'b') b++;
                    else if (this.chessComponents[i][j].name == 'n') n++;
                    else if (this.chessComponents[i][j].name == 'p') p++;
                }
            }
            if (k == 0) s.append("k 1\n");
            if (q == 0) s.append("q 1\n");
            if (r < 2) s.append("r ").append(2 - r).append("\n");
            if (b < 2) s.append("b ").append(2 - b).append("\n");
            if (n < 2) s.append("n ").append(2 - n).append("\n");
            if (p < 8) s.append("p ").append(8 - p).append("\n");
        }
        return s.substring(0, s.length());
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        int a = canMovePoints.size();
        if (a != 0) {
            for (int i = 0; i < a - 1; i++) {
                for (int j = i; j >= 0; j--) {
                    if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                        ChessboardPoint p = canMovePoints.get(j + 1);
                        canMovePoints.set(j + 1, canMovePoints.get(j));
                        canMovePoints.set(j, p);
                    } else if (canMovePoints.get(j).getX() == canMovePoints.get(j + 1).getX()) {
                        if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                            ChessboardPoint p = canMovePoints.get(j + 1);
                            canMovePoints.set(j + 1, canMovePoints.get(j));
                            canMovePoints.set(j, p);
                        }
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent a = getChess(sourceX, sourceY);
        if (a.getChessColor() == getCurrentPlayer()) {
            ChessboardPoint s = new ChessboardPoint(sourceX, sourceY);
            List<ChessboardPoint> b = getCanMovePoints(s);
            if (b.size() != 0) {
                for (ChessboardPoint chessboardPoint : b) {
                    if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                        if (getCurrentPlayer() == ChessColor.BLACK) this.currentPlayer = ChessColor.WHITE;
                        else this.currentPlayer = ChessColor.BLACK;
                        List<String> chessboard = getChessboard();
                        if (sourceX != targetX) {
                            StringBuilder sS = new StringBuilder(chessboard.get(sourceX));
                            StringBuilder tS = new StringBuilder(chessboard.get(targetX));
                            tS.replace(targetY, targetY + 1, String.valueOf(chessComponents[sourceX][sourceY].name));
                            sS.replace(sourceY, sourceY + 1, "_");
                            chessboard.set(sourceX,sS.substring(0,sS.length()));
                            chessboard.set(targetX,tS.substring(0,tS.length()));
                        }else {
                            StringBuilder tS = new StringBuilder(chessboard.get(targetX));
                            tS.replace(targetY, targetY + 1, String.valueOf(chessComponents[sourceX][sourceY].name));
                            tS.replace(sourceY, sourceY + 1, "_");
                            chessboard.set(targetX,tS.substring(0,tS.length()));
                        }
                        loadChessGame(chessboard);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if (name == 'K' || name == 'k')
            return new KingChessComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
        else if (name == 'Q' || name == 'q')
            return new QueenChessComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
        else if (name == 'R' || name == 'r')
            return new RookChessComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
        else if (name == 'B' || name == 'b')
            return new BishopChessComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
        else if (name == 'N' || name == 'n')
            return new KnightChessComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
        else if (name == 'P' || name == 'p')
            return new PawnChessComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
        else
            return new EmptySlotComponent(this.getSource(),this.getChessColor(),this.name,chessComponents).canMoveTo();
    }

    public List<String> getChessboard(){
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                s.append(this.chessComponents[i][j].name);
            }
            chessboard.add(i,s.substring(0,s.length()));
        }
        if (getCurrentPlayer() == ChessColor.BLACK) chessboard.add(8,"b");
        else chessboard.add(8,"w");
        return chessboard;
    }
}

class KingChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        ChessboardPoint b = this.getSource().offset(1, 1);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(1, 0);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(1, -1);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(0, 1);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(0, -1);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(-1, 1);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(-1, 0);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        b = this.getSource().offset(-1, -1);
        if (b != null) {
            if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
        }
        return a;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
            this.setSource(source);
            this.setChessColor(color);
            this.name = name;
            this.chessComponents = chessComponents;
        }
}

class QueenChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(i, i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(i, 0);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(i, -i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(0, i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(0, -i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(-i, i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(-i, 0);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(-i, -i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
        return a;
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        this.setSource(source);
        this.setChessColor(color);
        this.name = name;
        this.chessComponents = chessComponents;
    }
}

class RookChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> a = new ArrayList<>();
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(i, 0);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(0, i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(0, -i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(-i, 0);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            return a;
        }

        public RookChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
            this.setSource(source);
            this.setChessColor(color);
            this.name = name;
            this.chessComponents = chessComponents;
        }
    }

class BishopChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> a = new ArrayList<>();
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(i, i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(i, -i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(-i, i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            for (int i = 1; i < 8; i++) {
                ChessboardPoint b = this.getSource().offset(-i, -i);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == this.getChessColor()) {
                        break;
                    } else if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(b);
                    } else {
                        a.add(b);
                        break;
                    }
                }else break;
            }
            return a;
        }

        public BishopChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
            this.setSource(source);
            this.setChessColor(color);
            this.name = name;
            this.chessComponents = chessComponents;
        }
    }

class KnightChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> a = new ArrayList<>();
            ChessboardPoint b = this.getSource().offset(1,2);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(1,-2);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(-1,2);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(-1,-2);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(2,1);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(2,-1);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(-2,1);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            b = this.getSource().offset(-2,-1);
            if (b != null){
                if (this.chessComponents[b.getX()][b.getY()].getChessColor() != this.getChessColor()) a.add(b);
            }
            return a;
        }

        public KnightChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
            this.setSource(source);
            this.setChessColor(color);
            this.name = name;
            this.chessComponents = chessComponents;
        }
    }

class PawnChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> a = new ArrayList<>();
            ChessboardPoint b;
            if (this.getChessColor() == ChessColor.WHITE){
                if (this.getSource().getX() == 6){
                    b = this.getSource().offset(-1,0);
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE){
                        a.add(b);
                        b = this.getSource().offset(-2,0);
                        if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) a.add(b);
                    }
                }else {
                    b = this.getSource().offset(-1,0);
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) a.add(b);
                }
                b = this.getSource().offset(-1,1);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.BLACK) a.add(b);
                }
                b = this.getSource().offset(-1,-1);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.BLACK) a.add(b);
                }
            }else {
                if (this.getSource().getX() == 1){
                    b = this.getSource().offset(1,0);
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE){
                        a.add(b);
                        b = this.getSource().offset(2,0);
                        if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) a.add(b);
                    }
                }else {
                    b = this.getSource().offset(1,0);
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.NONE) a.add(b);
                }
                b = this.getSource().offset(1,1);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.WHITE) a.add(b);
                }
                b = this.getSource().offset(1,-1);
                if (b != null) {
                    if (this.chessComponents[b.getX()][b.getY()].getChessColor() == ChessColor.WHITE) a.add(b);
                }
            }
            return a;
        }

        public PawnChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
            this.setSource(source);
            this.setChessColor(color);
            this.name = name;
            this.chessComponents = chessComponents;
        }
    }

class EmptySlotComponent extends ChessComponent{

    ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        this.setSource(source);
        this.setChessColor(color);
        this.name = name;
    }
}

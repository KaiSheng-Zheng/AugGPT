import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int t = 0; t < 8; t++) {
                chessComponents[i][t] = fa(chessboard.get(i).substring(t, t + 1), i, t);
                chessComponents[i][t].setChessColor(faa(chessboard.get(i).substring(t, t + 1)));
                chessComponents[i][t].setName(chessboard.get(i).substring(t, t + 1).charAt(0));
                chessComponents[i][t].setSource(new ChessboardPoint(i, t));

            }
        }
        if (chessboard.get(8).equals("w"))
            currentPlayer = ChessColor.WHITE;
        if (chessboard.get(8).equals("b"))
            currentPlayer = ChessColor.BLACK;
    }

    public ChessComponent fa(String A, int i, int t) {
        RookChessComponent r = new RookChessComponent();
        r.setChessComponents(chessComponents);
        //r.setChessboardPoint(new ChessboardPoint(i, t));

        KnightChessComponent n = new KnightChessComponent();
        n.setChessComponents(chessComponents);
      //  n.setChessboardPoint(new ChessboardPoint(i, t));

        BishopChessComponent b = new BishopChessComponent();
        b.setChessComponents(chessComponents);
        //b.setChessboardPoint(new ChessboardPoint(i, t));

        QueenChessComponent q = new QueenChessComponent();
        q.setChessComponents(chessComponents);
      //  q.setChessboardPoint(new ChessboardPoint(i, t));

        KingChessComponent k = new KingChessComponent();
        k.setChessComponents(chessComponents);
       // k.setChessboardPoint(new ChessboardPoint(i, t));

        PawnChessComponent p = new PawnChessComponent();
        p.setChessComponents(chessComponents);
        //p.setChessboardPoint(new ChessboardPoint(i, t));

        EmptySlotComponent e = new EmptySlotComponent();
        e.setChessComponents(chessComponents);
       // e.setChessboardPoint(new ChessboardPoint(i, t));
        if (A.equals("R") || A.equals("r"))
            return r;
        if (A.equals("N") || A.equals("n"))
            return n;
        if (A.equals("B") || A.equals("b"))
            return b;
        if (A.equals("Q") || A.equals("q"))
            return q;
        if (A.equals("K") || A.equals("k"))
            return k;
        if (A.equals("P") || A.equals("p"))
            return p;
        else
            return e;
    }

    public ChessColor faa(String A) {
        if (A.equals("R") || A.equals("N") || A.equals("B") || A.equals("Q") || A.equals("K") || A.equals("P"))
            return ChessColor.BLACK;
        if (A.equals("r") || A.equals("n") || A.equals("b") || A.equals("q") || A.equals("k") || A.equals("p"))
            return ChessColor.WHITE;
        else
            return ChessColor.NONE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    public String getChessboardGraph() {
        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int t = 0; t <= 8; t++) {
                if (t + 1 > chessComponents[i].length) {
                    a = a.concat("\n");
                    break;
                }
                if (chessComponents[i][t] instanceof RookChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("R");
                if (chessComponents[i][t] instanceof RookChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("r");
                if (chessComponents[i][t] instanceof KnightChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("N");
                if (chessComponents[i][t] instanceof KnightChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("n");
                if (chessComponents[i][t] instanceof BishopChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("B");
                if (chessComponents[i][t] instanceof BishopChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("b");
                if (chessComponents[i][t] instanceof QueenChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("Q");
                if (chessComponents[i][t] instanceof QueenChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("q");
                if (chessComponents[i][t] instanceof KingChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("K");
                if (chessComponents[i][t] instanceof KingChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("k");
                if (chessComponents[i][t] instanceof PawnChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("P");
                if (chessComponents[i][t] instanceof PawnChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("p");
                if (chessComponents[i][t] instanceof EmptySlotComponent)
                    a = a.concat("_");
            }
        }
        return a;
    }

    public String getCapturedChess(ChessColor player) {
        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int t = 0; t <= 8; t++) {
                if (t + 1 > chessComponents[i].length) {
                    a = a.concat("\n");
                    break;
                }
                if (chessComponents[i][t] instanceof RookChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("R");
                if (chessComponents[i][t] instanceof RookChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("r");
                if (chessComponents[i][t] instanceof KnightChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("N");
                if (chessComponents[i][t] instanceof KnightChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("n");
                if (chessComponents[i][t] instanceof BishopChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("B");
                if (chessComponents[i][t] instanceof BishopChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("b");
                if (chessComponents[i][t] instanceof QueenChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("Q");
                if (chessComponents[i][t] instanceof QueenChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("q");
                if (chessComponents[i][t] instanceof KingChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("K");
                if (chessComponents[i][t] instanceof KingChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("k");
                if (chessComponents[i][t] instanceof PawnChessComponent && chessComponents[i][t].getChessColor() == ChessColor.BLACK)
                    a = a.concat("P");
                if (chessComponents[i][t] instanceof PawnChessComponent && chessComponents[i][t].getChessColor() == ChessColor.WHITE)
                    a = a.concat("p");
                if (chessComponents[i][t] instanceof EmptySlotComponent)
                    a = a.concat("-");
            }
        }
        int a0 = 1;
        int a1 = 1;
        int a2 = 2;
        int a3 = 2;
        int a4 = 2;
        int a5 = 8;
        int A0 = 1;
        int A1 = 1;
        int A2 = 2;
        int A3 = 2;
        int A4 = 2;
        int A5 = 8;
        for (int i = 0; i < a.length(); i++) {
            if (a.substring(i, i + 1).equals("K"))
                A0--;
            if (a.substring(i, i + 1).equals("Q"))
                A1--;
            if (a.substring(i, i + 1).equals("R"))
                A2--;
            if (a.substring(i, i + 1).equals("B"))
                A3--;
            if (a.substring(i, i + 1).equals("N"))
                A4--;
            if (a.substring(i, i + 1).equals("P"))
                A5--;
            if (a.substring(i, i + 1).equals("k"))
                a0--;
            if (a.substring(i, i + 1).equals("q"))
                a1--;
            if (a.substring(i, i + 1).equals("r"))
                a2--;
            if (a.substring(i, i + 1).equals("b"))
                a3--;
            if (a.substring(i, i + 1).equals("n"))
                a4--;
            if (a.substring(i, i + 1).equals("p"))
                a5--;
        }
        String b = "";
        if (player == ChessColor.BLACK) {
            if (A0 != 0)
                b = b + "K " + A0 + "\n";
            if (A1 != 0)
                b = b + "Q " + A1 + "\n";
            if (A2 != 0)
                b = b + "R " + A2 + "\n";
            if (A3 != 0)
                b = b + "B " + A3 + "\n";
            if (A4 != 0)
                b = b + "N " + A4 + "\n";
            if (A5 != 0)
                b = b + "P " + A5 + "\n";
        } else {
            if (a0 != 0)
                b = b + "k " + a0 + "\n";
            if (a1 != 0)
                b = b + "q " + a1 + "\n";
            if (a2 != 0)
                b = b + "r " + a2 + "\n";
            if (a3 != 0)
                b = b + "b " + a3 + "\n";
            if (a4 != 0)
                b = b + "n " + a4 + "\n";
            if (a5 != 0)
                b = b + "p " + a5 + "\n";
        }

        return b;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
            if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX &&
                    chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY&&
                    chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
               EmptySlotComponent E = new EmptySlotComponent();
              chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].getSource().setX(targetX);
                chessComponents[targetX][targetY].getSource().setY(targetY);
               chessComponents[sourceX][sourceY]=E;
                E.setSource(new ChessboardPoint(sourceX, sourceY));
                E.setChessColor(ChessColor.NONE);
                E.setName('_');
                if (currentPlayer == ChessColor.BLACK)
                    currentPlayer = ChessColor.WHITE;
                else
                    currentPlayer = ChessColor.BLACK;
                return true;
            }
        }
        return false;

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        getCanMovePoints=chessComponents[source.getX()][source.getY()].canMoveTo();
        return getCanMovePoints;
    }
}


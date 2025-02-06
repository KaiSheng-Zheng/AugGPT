
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public List<String> chessboard;


    public void loadChessGame(List<String> chessboard){
        this.chessboard = chessboard;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        setChessComponents(i,j, new RookChessComponent(i,j,ChessColor.BLACK,'R',this.chessComponents));
                        break;
                    case 'N':
                        setChessComponents(i,j, new KnightChessComponent(i,j,ChessColor.BLACK,'N',this.chessComponents));
                        break;
                    case 'B':
                        setChessComponents(i,j, new BishopChessComponent(i,j,ChessColor.BLACK,'B',this.chessComponents));
                        break;
                    case 'Q':
                        setChessComponents(i,j, new QueenChessComponent(i,j,ChessColor.BLACK,'Q',this.chessComponents));
                        break;
                    case 'K':
                        setChessComponents(i,j, new KingChessComponent(i,j,ChessColor.BLACK,'K',this.chessComponents));
                        break;
                    case 'P':
                        setChessComponents(i,j, new PawnChessComponent(i,j,ChessColor.BLACK,'P',this.chessComponents));
                        break;
                    case 'r':
                        setChessComponents(i,j, new RookChessComponent(i,j,ChessColor.WHITE,'r',this.chessComponents));
                        break;
                    case 'n':
                        setChessComponents(i,j, new KnightChessComponent(i,j,ChessColor.WHITE,'n',this.chessComponents));
                        break;
                    case 'b':
                        setChessComponents(i,j, new BishopChessComponent(i,j,ChessColor.WHITE,'b',this.chessComponents));
                        break;
                    case 'q':
                        setChessComponents(i,j, new QueenChessComponent(i,j,ChessColor.WHITE,'q',this.chessComponents));
                        break;
                    case 'k':
                        setChessComponents(i,j, new KingChessComponent(i,j,ChessColor.WHITE,'k',this.chessComponents));
                        break;
                    case 'p':
                        setChessComponents(i,j, new PawnChessComponent(i,j,ChessColor.WHITE,'p',this.chessComponents));
                        break;
                    case '_':
                        setChessComponents(i,j, new EmptySlotComponent(i,j,ChessColor.NONE,'_',this.chessComponents));
                }
            }
        }

        if (chessboard.get(8).contains("w")){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",chessboard.get(0),chessboard.get(1),chessboard.get(2),chessboard.get(3),chessboard.get(4),chessboard.get(5),chessboard.get(6),chessboard.get(7));
    }

    public String getCapturedChess(ChessColor player){
        if (player == ChessColor.BLACK){
            int k = 0,q = 0,r = 0,b = 0,n = 0,p = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)){
                        k++;
                    }else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)){
                        q++;
                    }else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)){
                        r++;
                    }else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)){
                        b++;
                    }else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)){
                        n++;
                    }else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)){
                        p++;
                    }
                }
            }

            k = 1 - k;
            q = 1 - q;
            r = 2 - r;
            b = 2 - b;
            n = 2 - n;
            p = 8 - p;

            ArrayList<String> output =  new ArrayList<>();

            if (k != 0){
                output.add("K "+ k);
            }
            if (q != 0){
                output.add("Q "+ q);
            }
            if (r != 0){
                output.add("R "+ r);
            }
            if (b != 0){
                output.add("B "+ b);
            }
            if (n != 0){
                output.add("N "+ n);
            }
            if (p != 0){
                output.add("P "+ p);
            }

            StringBuilder result = new StringBuilder();

            if (output.size() == 0){
                return "";
            }else if (output.size() == 1){
                return output.get(0);
            }else{
                for (int i = 0; i < output.size() - 1; i++) {
                    result.append(output.get(i)).append("\n");
                }
                result.append(output.get(output.size() - 1));
                return new String(result);

            }
        }else{
            int k = 0,q = 0,r = 0,b = 0,n = 0,p = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                        k++;
                    }else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                        q++;
                    }else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                        r++;
                    }else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                        b++;
                    }else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                        n++;
                    }else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)){
                        p++;
                    }
                }
            }

            k = 1 - k;
            q = 1 - q;
            r = 2 - r;
            b = 2 - b;
            n = 2 - n;
            p = 8 - p;

            ArrayList<String> output =  new ArrayList<>();

            if (k != 0){
                output.add("k "+ k);
            }
            if (q != 0){
                output.add("q "+ q);
            }
            if (r != 0){
                output.add("r "+ r);
            }
            if (b != 0){
                output.add("b "+ b);
            }
            if (n != 0){
                output.add("n "+ n);
            }
            if (p != 0){
                output.add("p "+ p);
            }

            StringBuilder result = new StringBuilder();

            if (output.size() == 0){
                return "";
            }else if (output.size() == 1){
                return output.get(0);
            }else{
                for (int i = 0; i < output.size() - 1; i++) {
                    result.append(output.get(i)).append("\n");
                }
                result.append(output.get(output.size() - 1));
                return new String(result);
            }

        }


    }

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent temp1 = chessComponents[sourceX][sourceY];
        ChessComponent temp2 = chessComponents[targetX][targetY];
        ChessboardPoint s1 = chessComponents[sourceX][sourceY].getSource();
        ChessboardPoint s2 = chessComponents[targetX][targetY].getSource();

        if (!(chessComponents[sourceX][sourceY].getChessColor() == currentPlayer)){
            return false;
        }

        if (chessComponents[sourceX][sourceY].ableToMoveTo(chessComponents[targetX][targetY])){
            chessComponents[targetX][targetY] = temp1;
            chessComponents[sourceX][sourceY].setSource(s2);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_',chessComponents);

            if (currentPlayer == ChessColor.WHITE){
                currentPlayer = ChessColor.BLACK;
            }else{
                currentPlayer = ChessColor.WHITE;
            }
            return true;
         }else {
            return false;
        }

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public void setChessComponents(int i, int j , ChessComponent chessComponents) {
        this.chessComponents[i][j] = chessComponents;
    }

    public ChessComponent getChessComponents(int i , int j) {
        return chessComponents[i][j];
    }


}

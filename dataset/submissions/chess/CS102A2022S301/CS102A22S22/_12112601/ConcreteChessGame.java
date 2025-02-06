
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {

// A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]


    private ChessComponent[][] chessComponents=new ChessComponent[8][8];


// What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.


    private ChessColor currentPlayer;


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            char[] temp= chessboard.get(i).toCharArray();
            for (int j=0;j<8;j++){
                chessComponents[i][j]=construct(temp[j],i,j,chessComponents);
            }
        }
        currentPlayer= Objects.equals(chessboard.get(8), "w") ?ChessColor.WHITE:ChessColor.BLACK;
    }
    public ChessComponent construct(char c,int i,int j,ChessComponent[][] chessComponents){
        return switch (c) {
            case '_' -> new EmptySlotComponent(c, i, j,chessComponents);
            case 'r', 'R' ->new RookChessComponent(c, i, j,chessComponents);
            case 'n', 'N' ->new KnightChessComponent(c, i, j,chessComponents);
            case 'b', 'B' ->new BishopChessComponent(c, i, j,chessComponents);
            case 'q', 'Q' ->new QueenChessComponent(c, i, j,chessComponents);
            case 'k', 'K' ->new KingChessComponent(c, i, j,chessComponents);
            case 'p', 'P' ->new PawnChessComponent(c, i, j,chessComponents);
            default -> null;
        };
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
        StringBuilder s=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                s.append(chessComponents[i][j].name);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Integer,Integer> components=new HashMap<>();
        StringBuilder s=new StringBuilder();
        components.put((int) 'k',0);
        components.put((int) 'q',0);
        components.put((int) 'r',0);
        components.put((int) 'b',0);
        components.put((int) 'n',0);
        components.put((int) 'p',0);
        components.put((int) 'K',0);
        components.put((int) 'Q',0);
        components.put((int) 'R',0);
        components.put((int) 'B',0);
        components.put((int) 'N',0);
        components.put((int) 'P',0);

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(chessComponents[i][j].name!='_'){
                    int t=components.get((int)chessComponents[i][j].name)+1;
                    components.put((int) chessComponents[i][j].name, t);
                }
            }
        }

        int k,q,r,n,b,p;
        if(player==ChessColor.WHITE){
            k=1-components.get((int)'k');
            q=1-components.get((int)'q');
            r=2-components.get((int)'r');
            b=2-components.get((int)'b');
            n=2-components.get((int)'n');
            p=8-components.get((int)'p');
            if(k!=0){
                s.append("k ").append(k).append("\n");
            }
            if(q!=0){
                s.append("q ").append(q).append("\n");
            }
            if(r!=0){
                s.append("r ").append(r).append("\n");
            }
            if(b!=0){
                s.append("b ").append(b).append("\n");
            }
            if(n!=0){
                s.append("n ").append(n).append("\n");
            }
            if(p!=0){
                s.append("p ").append(p).append("\n");
            }

        } else {
            k=1-components.get((int)'K');
            q=1-components.get((int)'Q');
            r=2-components.get((int)'R');
            b=2-components.get((int)'B');
            n=2-components.get((int)'N');
            p=8-components.get((int)'P');

            if(k!=0){
                s.append("K ").append(k).append("\n");
            }
            if(q!=0){
                s.append("Q ").append(q).append("\n");
            }
            if(r!=0){
                s.append("R ").append(r).append("\n");
            }
            if(b!=0){
                s.append("B ").append(b).append("\n");
            }
            if(n!=0){
                s.append("N ").append(n).append("\n");
            }
            if(p!=0){
                s.append("P ").append(p).append("\n");
            }
        }
        return s.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean b=false;
        chessComponents[sourceX][sourceY].setChessComponents(chessComponents);
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY()&&chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)) {
                b = true;
                break;
            }
        }
        if(b){
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
            ChessComponent temp=chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY]=temp;
            chessComponents[sourceX][sourceY]=new EmptySlotComponent('_',sourceX,sourceY,null);
            if (currentPlayer==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }else {
                currentPlayer=ChessColor.WHITE;
            }
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
            }
        }
        return b;
    }
}

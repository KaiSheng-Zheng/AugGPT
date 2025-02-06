import java.nio.file.Paths;
import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }

    public void loadChessGame(List<String> chessboard){
        this.currentPlayer=chessboard.get(8).equals("w")? ChessColor.WHITE : ChessColor.BLACK;
        for(int i=0;i<8;i++){
            String row=chessboard.get(i);
            for(int j=0;j<8;j++){
                switch (row.charAt(j)) {
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                    default -> chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j),chessComponents);
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
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder graph=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                if(chessComponents[i][j] instanceof RookChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        graph.append("R");
                    }
                    else
                        graph.append("r");
                }
                else if(chessComponents[i][j] instanceof KnightChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        graph.append("N");
                    }
                    else
                        graph.append("n");
                }
                else if(chessComponents[i][j] instanceof BishopChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        graph.append("B");
                    }
                    else
                        graph.append("b");
                }
                else if(chessComponents[i][j] instanceof KingChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        graph.append("K");
                    }
                    else
                        graph.append("k");
                }
                else if(chessComponents[i][j] instanceof QueenChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        graph.append("Q");
                    }
                    else
                        graph.append("q");
                }
                else if(chessComponents[i][j] instanceof PawnChessComponent){
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        graph.append("P");
                    }
                    else
                        graph.append("p");
                }
                else{
                    graph.append("_");
                }
            }
            graph.append("\n");
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int r=0,n=0,b=0,k=0,q=0,p=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                if(chessComponents[i][j] instanceof RookChessComponent){
                    if(chessComponents[i][j].getChessColor()==player){
                        r++;
                    }
                }
                else if(chessComponents[i][j] instanceof KnightChessComponent){
                    if(chessComponents[i][j].getChessColor()==player){
                        n++;
                    }
                }
                else if(chessComponents[i][j] instanceof BishopChessComponent){
                    if(chessComponents[i][j].getChessColor()==player){
                        b++;
                    }
                }
                else if(chessComponents[i][j] instanceof KingChessComponent){
                    if(chessComponents[i][j].getChessColor()==player){
                        k++;
                    }
                }
                else if(chessComponents[i][j] instanceof QueenChessComponent){
                    if(chessComponents[i][j].getChessColor()==player){
                        q++;
                    }
                }
                else if(chessComponents[i][j] instanceof PawnChessComponent){
                    if(chessComponents[i][j].getChessColor()==player){
                        p++;
                    }
                }
            }
        }

        StringBuilder captured=new StringBuilder();

        if(k<1){
            captured.append("k "+(1-k));
            captured.append("\n");
        }

        if(q<1){
            captured.append("q "+(1-q));
            captured.append("\n");
        }

        if(r<2){
            captured.append("r "+(2-r));
            captured.append("\n");
        }

        if(b<2){
            captured.append("b "+(2-b));
            captured.append("\n");
        }

        if(n<2){
            captured.append("n "+(2-n));
            captured.append("\n");
        }

        if(p<8){
            captured.append("p "+(8-p));
        }

        if(player==ChessColor.BLACK){
            return captured.toString().toUpperCase(Locale.ROOT);
        }
        return captured.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List <ChessboardPoint> result= chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(result, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()<o2.getX()) return -1;
                else if(o1.getX()>o2.getX()) return 1;
                else{
                    if(o1.getY()<o2.getY()) return -1;
                    else if(o1.getY()>o2.getY()) return 1;
                    else return 0;
                }
            }
        });
        return result;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor()!=getCurrentPlayer()){
            return false;
        }

        if(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).contains(new ChessboardPoint(targetX,targetY))){
            if(chessComponents[sourceX][sourceY] instanceof PawnChessComponent){
                ((PawnChessComponent) chessComponents[sourceX][sourceY]).setFirstMove(false);
            }
            swapChessComponents(chessComponents[sourceX][sourceY],chessComponents[targetX][targetY]);
            swapColor();
            return true;
        }
        return false;
    }

    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
        if (!(chess2 instanceof EmptySlotComponent)) {
            chess2 = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(chess2.getSource().getX(),chess2.getSource().getY()),chessComponents);
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getSource().getX(), col1 = chess1.getSource().getY();
        chessComponents[row1][col1] = chess1;
        int row2 = chess2.getSource().getX(), col2 = chess2.getSource().getY();
        chessComponents[row2][col2] = chess2;
    }

    public void swapColor(){
        currentPlayer=(currentPlayer==ChessColor.BLACK?ChessColor.WHITE:ChessColor.BLACK);
    }
}

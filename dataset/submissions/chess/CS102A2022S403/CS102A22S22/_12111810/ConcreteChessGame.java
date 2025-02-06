import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = ChessComponent.chessComponents;
        this.currentPlayer = getCurrentPlayer();
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0;i<8;i++){
            String ln = chessboard.get(i);
            for(int j = 0;j<8;j++){
                ChessboardPoint ne = new ChessboardPoint(i,j);
                if(ln.charAt(j)>='A'&&ln.charAt(j)<='Z'){
                    if(chessboard.get(i).charAt(j)=='K'){
                        this.chessComponents[i][j] = new KingChessComponent(ne,ChessColor.BLACK,'K');
                    }
                    else if(chessboard.get(i).charAt(j)=='Q'){
                        this.chessComponents[i][j] = new QueenChessComponent(ne,ChessColor.BLACK,'Q');
                    }
                    else if(chessboard.get(i).charAt(j)=='R'){
                        this.chessComponents[i][j] = new RookChessComponent(ne,ChessColor.BLACK,'R');
                    }
                    else if(chessboard.get(i).charAt(j)=='B'){
                        this.chessComponents[i][j] = new BishopChessComponent(ne,ChessColor.BLACK,'B');
                    }
                    else if(chessboard.get(i).charAt(j)=='N'){
                        this.chessComponents[i][j] = new KnightChessComponent(ne,ChessColor.BLACK,'N');
                    }
                    else if(chessboard.get(i).charAt(j)=='P'){
                        this.chessComponents[i][j] = new PawnChessComponent(ne,ChessColor.BLACK,'P');
                    }
                }
                else if(ln.charAt(j)>='a'&&ln.charAt(j)<='z'){
                    if(chessboard.get(i).charAt(j)=='k'){
                        this.chessComponents[i][j] = new KingChessComponent(ne,ChessColor.WHITE,'k');
                    }
                    else if(chessboard.get(i).charAt(j)=='q'){
                        this.chessComponents[i][j] = new QueenChessComponent(ne,ChessColor.WHITE,'q');
                    }
                    else if(chessboard.get(i).charAt(j)=='r'){
                        this.chessComponents[i][j] = new RookChessComponent(ne,ChessColor.WHITE,'r');
                    }
                    else if(chessboard.get(i).charAt(j)=='b'){
                        this.chessComponents[i][j] = new BishopChessComponent(ne,ChessColor.WHITE,'b');
                    }
                    else if(chessboard.get(i).charAt(j)=='n'){
                        this.chessComponents[i][j] = new KnightChessComponent(ne,ChessColor.WHITE,'n');
                    }
                    else if(chessboard.get(i).charAt(j)=='p'){
                        this.chessComponents[i][j] = new PawnChessComponent(ne,ChessColor.WHITE,'p');
                    }
                }
                else{
                    this.chessComponents[i][j] = new EmptySlotComponent(ne,ChessColor.NONE,'_');
                }
            }
        }
        if(Objects.equals(chessboard.get(8), "w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        else{
            this.currentPlayer = ChessColor.BLACK;
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
        StringBuilder graph = new StringBuilder();
        StringBuilder all = new StringBuilder();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                all.append(chessComponents[i][j]);
            }
        }
        String fin = all.toString();
        for(int i = 0;i<7;i++){
            graph.append(fin.substring(8*i,8*(i+1)));
            graph.append("\n");
        }
        graph.append(fin.substring(56,64));
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int wk1 = 0;
        int wq = 0;
        int wr = 0;
        int wb = 0;
        int wk2 = 0;
        int wp = 0;
        int bk1 = 0;
        int bq = 0;
        int br = 0;
        int bb = 0;
        int bk2 = 0;
        int bp = 0;
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(chessComponents[i][j].name=='K'){
                    bk1+=1;
                }
                else if(chessComponents[i][j].name=='k'){
                    wk1+=1;
                }
                else if(chessComponents[i][j].name=='Q'){
                    bq+=1;
                }
                else if(chessComponents[i][j].name=='q'){
                    wq+=1;
                }
                else if(chessComponents[i][j].name=='R'){
                    br+=1;
                }
                else if(chessComponents[i][j].name=='r'){
                    wr+=1;
                }
                else if(chessComponents[i][j].name=='B'){
                    bb+=1;
                }
                else if(chessComponents[i][j].name=='b'){
                    wb+=1;
                }
                else if(chessComponents[i][j].name=='N'){
                    bk2+=1;
                }
                else if(chessComponents[i][j].name=='n'){
                    wk2+=1;
                }
                else if(chessComponents[i][j].name=='P'){
                    bp+=1;
                }
                else if(chessComponents[i][j].name=='p'){
                    wp+=1;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if(player==ChessColor.WHITE) {
            if (wk1 == 0) {
                result.append("k 1");
                result.append("\n");
            }
            if (wq == 0) {
                result.append("q 1\n");
            }
            if (wr != 2) {
                result.append(String.format("r %d\n",2-wr));
            }
            if (wb != 2) {
                result.append(String.format("b %d\n",2-wb));
            }
            if (wk2 != 2) {
                result.append(String.format("n %d\n",2-wk2));
            }
            if (wp != 8) {
                result.append(String.format("p %d\n",8-wp));
            }
            return result.toString();
        }
        else {
            StringBuilder res = new StringBuilder();
            if (bk1 == 0) {
                res.append("K 1\n");
            }
            if (bq == 0) {
                res.append("Q 1\n");
            }
            if (br != 2) {
                res.append(String.format("R %d\n",2-br));
            }
            if (bb != 2) {
                res.append(String.format("B %d\n",2-bb));
            }
            if (bk2 != 2) {
                res.append(String.format("N %d\n",2-bk2));
            }
            if (bp != 8) {
                res.append(String.format("P %d\n",8-bp));
            }
            return res.toString();
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> points = getChess(source.getX(),source.getY()).canMoveTo();
        ChessboardPoint middle = new ChessboardPoint(0,0);
        for(int i = 0;i<points.size()-1;i++){
            for(int j = 0;j< points.size()-1-i;j++){
                if(points.get(j).getX()>points.get(j+1).getX()){
                    middle = points.get(j);
                    points.set(j,points.get(j+1));
                    points.set(j+1,middle);
                }
                else if(points.get(j).getX()==points.get(j+1).getX()){
                    if(points.get(j).getY()>points.get(j+1).getY()){
                        middle = points.get(j);
                        points.set(j,points.get(j+1));
                        points.set(j+1,middle);
                    }
                }
            }
        }
       return points;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint sources = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint targets = new ChessboardPoint(targetX,targetY);
        if(getChess(sourceX,sourceY).getChessColor()==getCurrentPlayer()) {
            if (getCanMovePoints(sources).size() == 0) {
                return false;
            }
            boolean judge = false;
            for(int i = 0;i<getCanMovePoints(sources).size();i++) {
                if (getCanMovePoints(sources).get(i).getX() == targetX && getCanMovePoints(sources).get(i).getY() == targetY) {
                    judge = true;
                }
            }
            if(!judge) {
                return false;
            }
            else {
                    EmptySlotComponent emptySlotComponent = new EmptySlotComponent(sources, ChessColor.NONE, '_');
                    if(getChess(sourceX,sourceY).name=='K'){
                        KingChessComponent kingChessComponent1 = new KingChessComponent(targets,ChessColor.BLACK,'K');
                        chessComponents[targetX][targetY] = kingChessComponent1;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='k'){
                        KingChessComponent kingChessComponent2 = new KingChessComponent(targets,ChessColor.WHITE,'k');
                        chessComponents[targetX][targetY] = kingChessComponent2;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='Q'){
                        QueenChessComponent queenChessComponent1 = new QueenChessComponent(targets,ChessColor.BLACK,'Q');
                        chessComponents[targetX][targetY] = queenChessComponent1;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='q'){
                        QueenChessComponent queenChessComponent2 = new QueenChessComponent(targets,ChessColor.WHITE,'q');
                        chessComponents[targetX][targetY] = queenChessComponent2;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='R'){
                        RookChessComponent rookChessComponent1 = new RookChessComponent(targets,ChessColor.BLACK,'R');
                        chessComponents[targetX][targetY] = rookChessComponent1;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='r'){
                        RookChessComponent rookChessComponent2 = new RookChessComponent(targets,ChessColor.WHITE,'r');
                        chessComponents[targetX][targetY] = rookChessComponent2;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='B'){
                        BishopChessComponent bishopChessComponent1 = new BishopChessComponent(targets,ChessColor.BLACK,'B');
                        chessComponents[targetX][targetY] = bishopChessComponent1;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='b'){
                        BishopChessComponent bishopChessComponent2 = new BishopChessComponent(targets,ChessColor.WHITE,'b');
                        chessComponents[targetX][targetY] = bishopChessComponent2;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='N'){
                        KnightChessComponent knightChessComponent1 = new KnightChessComponent(targets,ChessColor.BLACK,'N');
                        chessComponents[targetX][targetY] = knightChessComponent1;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='n'){
                        KnightChessComponent knightChessComponent2 = new KnightChessComponent(targets,ChessColor.WHITE,'n');
                        chessComponents[targetX][targetY] = knightChessComponent2;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='P'){
                        PawnChessComponent pawnChessComponent1 = new PawnChessComponent(targets,ChessColor.BLACK,'P');
                        chessComponents[targetX][targetY] = pawnChessComponent1;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    else if(getChess(sourceX,sourceY).name=='p'){
                        PawnChessComponent pawnChessComponent2 = new PawnChessComponent(targets,ChessColor.WHITE,'p');
                        chessComponents[targetX][targetY] = pawnChessComponent2;
                        chessComponents[sourceX][sourceY] = emptySlotComponent;
                    }
                    if (getCurrentPlayer() == ChessColor.BLACK) {
                        this.currentPlayer = ChessColor.WHITE;
                    } else {
                        this.currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
        else {
            return false;
        }
        }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
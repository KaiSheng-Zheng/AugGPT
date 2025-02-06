import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public ConcreteChessGame(ChessColor currentPlayer, ChessComponent[][]chessComponents){
        this.currentPlayer=currentPlayer;
        this.chessComponents=chessComponents;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ConcreteChessGame(){}

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String>chessboard){
        for(int i=0;i<chessComponents.length;i++){
            for(int j=0;j<chessComponents[i].length;j++){
                if(chessboard.get(i).charAt(j)==82){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                if(chessboard.get(i).charAt(j)==78){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if(chessboard.get(i).charAt(j)==66){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if(chessboard.get(i).charAt(j)==75){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK, 'K');
                }
                if(chessboard.get(i).charAt(j)==80){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if(chessboard.get(i).charAt(j)==81){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if(chessboard.get(i).charAt(j)==95){
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
                if(chessboard.get(i).charAt(j)==114){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if(chessboard.get(i).charAt(j)==110){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if(chessboard.get(i).charAt(j)==98){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if(chessboard.get(i).charAt(j)==107){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if(chessboard.get(i).charAt(j)==112){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if(chessboard.get(i).charAt(j)==113){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            setCurrentPlayer(ChessColor.WHITE);
        }
        if(chessboard.get(8).charAt(0)=='b'){
            setCurrentPlayer(ChessColor.BLACK);
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
        StringBuilder a=new StringBuilder();
        for(int i=0;i<chessComponents.length;i++){
            for (int j=0;j<chessComponents[i].length;j++){
                a.append(chessComponents[i][j].name);
            }
            a.append("\n");
        }
        return a.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            int a[] = new int[6];
            for(int i=0;i<a.length;i++){
                a[i]=0;
            }
            StringBuilder str=new StringBuilder();
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j].name=='R') {
                        a[0]++;
                    }
                    if(chessComponents[i][j].name=='N'){
                        a[1]++;
                    }
                    if(chessComponents[i][j].name=='B'){
                        a[2]++;
                    }
                    if(chessComponents[i][j].name=='K'){
                        a[3]++;
                    }
                    if(chessComponents[i][j].name=='P'){
                        a[4]++;
                    }
                    if(chessComponents[i][j].name=='Q'){
                        a[5]++;
                    }
                }
            }
            if(a[3]!=1){
                str.append("K 1\n");
            }
            if(a[5]!=1){
                str.append("Q 1\n");
            }
            if(a[0]!=2){
                str.append("R "+(2-a[0])+"\n");
            }
            if(a[2]!=2){
                str.append("B "+(2-a[2])+"\n");
            }
            if(a[1]!=2){
                str.append("N "+(2-a[1])+"\n");
            }
            if(a[4]!=8){
                str.append("P "+(8-a[4])+"\n");
            }
            return str.toString();
        }else {
            int a[] = new int[6];
            for(int i=0;i<a.length;i++){
                a[i]=0;
            }
            StringBuilder str=new StringBuilder();
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j].name=='r') {
                        a[0]++;
                    }
                    if(chessComponents[i][j].name=='n'){
                        a[1]++;
                    }
                    if(chessComponents[i][j].name=='b'){
                        a[2]++;
                    }
                    if(chessComponents[i][j].name=='k'){
                        a[3]++;
                    }
                    if(chessComponents[i][j].name=='p'){
                        a[4]++;
                    }
                    if(chessComponents[i][j].name=='q'){
                        a[5]++;
                    }
                }
            }
            if(a[3]!=1){
                str .append("k 1\n");
            }
            if(a[5]!=1){
                str.append("q 1\n");
            }
            if(a[0]!=2){
                str.append("r "+(2-a[0])+"\n");
            }
            if(a[2]!=2){
                str.append("b "+(2-a[2])+"\n");
            }
            if(a[1]!=2){
                str.append("n "+(2-a[1])+"\n");
            }
            if(a[4]!=8){
                str.append("p "+(8-a[4])+"\n");
            }
            return str.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        this.chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        int row = source.getX();
        int col = source.getY();
        List<ChessboardPoint> canMove = chessComponents[row][col].canMoveTo();
        List<ChessboardPoint> a1 = new ArrayList<>();
        List<ChessboardPoint> b1 = new ArrayList<>();
        List<ChessboardPoint> c1 = new ArrayList<>();
        List<ChessboardPoint> d1 = new ArrayList<>();
        List<ChessboardPoint> e1 = new ArrayList<>();
        List<ChessboardPoint> f1 = new ArrayList<>();
        List<ChessboardPoint> g1 = new ArrayList<>();
        List<ChessboardPoint> h1 = new ArrayList<>();
        List<ChessboardPoint> result1 = new ArrayList<>();
        for (int i = 0; i < canMove.size(); i++) {
            if (canMove.get(i).getX() == 0) {
                a1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 1) {
                b1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 2) {
                c1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 3) {
                d1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 4) {
                e1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 5) {
                f1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 6) {
                g1.add(canMove.get(i));
            }
            if (canMove.get(i).getX() == 7) {
                h1.add(canMove.get(i));
            }
        }
        for (int j = 0; j < a1.size() - 1; j++) {
            for (int i = 0; i < a1.size() - j - 1; i++) {
                if (a1.get(i + 1).getY() < a1.get(i).getY()) {
                    ChessboardPoint a = a1.get(i);
                    ChessboardPoint b = a1.get(i + 1);
                    a1.set(i, b);
                    a1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < b1.size() - 1; j++) {
            for (int i = 0; i < b1.size() - 1 - j; i++) {
                if (b1.get(i).getY() > b1.get(i + 1).getY()) {
                    ChessboardPoint a = b1.get(i);
                    ChessboardPoint b = b1.get(i + 1);
                    b1.set(i, b);
                    b1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < c1.size() - 1; j++) {
            for (int i = 0; i < c1.size() - 1 - j; i++) {
                if (c1.get(i).getY() > c1.get(i + 1).getY()) {
                    ChessboardPoint a = c1.get(i);
                    ChessboardPoint b = c1.get(i + 1);
                    c1.set(i, b);
                    c1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < d1.size() - 1; j++) {
            for (int i = 0; i < d1.size() - 1 - j; i++) {
                if (d1.get(i).getY() > d1.get(i + 1).getY()) {
                    ChessboardPoint a = d1.get(i);
                    ChessboardPoint b = d1.get(i + 1);
                    d1.set(i, b);
                    d1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < e1.size() - 1; j++) {
            for (int i = 0; i < e1.size() - 1 - j; i++) {
                if (e1.get(i).getY() > e1.get(i + 1).getY()) {
                    ChessboardPoint a = e1.get(i);
                    ChessboardPoint b = e1.get(i + 1);
                    e1.set(i, b);
                    e1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < f1.size() - 1; j++) {
            for (int i = 0; i < f1.size() - 1 - j; i++) {
                if (f1.get(i).getY() > f1.get(i + 1).getY()) {
                    ChessboardPoint a = f1.get(i);
                    ChessboardPoint b = f1.get(i + 1);
                    f1.set(i, b);
                    f1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < g1.size() - 1; j++) {
            for (int i = 0; i < g1.size() - 1 - j; i++) {
                if (g1.get(i).getY() > g1.get(i + 1).getY()) {
                    ChessboardPoint a = g1.get(i);
                    ChessboardPoint b = g1.get(i + 1);
                    g1.set(i, b);
                    g1.set(i + 1, a);
                }
            }
        }
        for (int j = 0; j < h1.size() - 1; j++) {
            for (int i = 0; i < h1.size() - 1 - j; i++) {
                if (h1.get(i).getY() > h1.get(i + 1).getY()) {
                    ChessboardPoint a = h1.get(i);
                    ChessboardPoint b = h1.get(i + 1);
                    h1.set(i, b);
                    h1.set(i + 1, a);
                }
            }
        }
        result1.addAll(a1);
        result1.addAll(b1);
        result1.addAll(c1);
        result1.addAll(d1);
        result1.addAll(e1);
        result1.addAll(f1);
        result1.addAll(g1);
        result1.addAll(h1);
        return result1;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int x = 0;
        if (sourceX >= 8 || sourceY >= 8 || targetX >= 8 || targetY >= 8) {
            return false;
        } else {
            if (this.chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer) {
                List<ChessboardPoint> a = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).getX() == targetX && a.get(i).getY() == targetY) {
                        x++;
                    }
                }
                if (x != 0) {
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                    if (this.currentPlayer == ChessColor.BLACK) {
                        currentPlayer=ChessColor.WHITE;
                    } else if(this.currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
}


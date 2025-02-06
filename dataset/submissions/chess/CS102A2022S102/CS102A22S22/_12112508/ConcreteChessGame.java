import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessComponents.length; i++){
            for (int j = 0; j < chessComponents[i].length; j++){
                char name = chessboard.get(i).charAt(j);
                switch (name){
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('K');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('Q');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('B');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('N');
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('R');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('P');
                        break;
                        //black chess
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('k');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('q');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('b');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('n');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('r');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('p');
                        break;
                        //white chess
                    default:
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].setName('_');
                }

                /*chessComponents[i][j].name = chessboard.get(i).charAt(j);
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                if (chessboard.get(i).charAt(j) >= 'A' && chessboard.get(i).charAt(j) <= 'Z'){
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                } else if (chessboard.get(i).charAt(j) >= 'a' && chessboard.get(i).charAt(j) <= 'z') {
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }else {
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }*/
            }
        }
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                component.setChessComponents(this.chessComponents);
            }
        }



        if (chessboard.get(chessboard.size() - 1).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (x < chessComponents.length && x >= 0){
            if (y < chessComponents[x].length && y >= 0){
                return chessComponents[x][y];
            }
        }
        return null;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++){
            for (int j = 0; j < chessComponents[i].length; j++){
                graph.append(chessComponents[i][j]);
            }
            if (i < chessComponents.length - 1){
                graph.append("\n");
            }
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String lose = "";
        int K = 0, Q = 0, R = 0, B = 0, N = 0, P = 0, k = 0, q = 0, r = 0, b = 0, n = 0, p = 0;
        for (int i = 0; i < chessComponents.length; i++){
            for (int j = 0; j < chessComponents[i].length; j++){
                if (chessComponents[i][j].name == 'K'){
                    K++;
                } else if (chessComponents[i][j].name == 'Q'){
                    Q++;
                } else if (chessComponents[i][j].name == 'R'){
                    R++;
                }else if (chessComponents[i][j].name == 'B'){
                    B++;
                }else if (chessComponents[i][j].name == 'N'){
                    N++;
                }else if (chessComponents[i][j].name == 'P'){
                    P++;
                }else if (chessComponents[i][j].name == 'k'){
                    k++;
                }else if (chessComponents[i][j].name == 'q'){
                    q++;
                }else if (chessComponents[i][j].name == 'r'){
                    r++;
                }else if (chessComponents[i][j].name == 'b'){
                    b++;
                }else if (chessComponents[i][j].name == 'n'){
                    n++;
                }else if (chessComponents[i][j].name == 'p'){
                    p++;
                }
            }
        }
        if (player == ChessColor.BLACK){
            if (K < 1){
                lose += "K 1\n";
            }
            if (Q < 1){
                lose += "Q 1\n";
            }
            if (R < 2){
                lose += String.format("R %s\n", 2 - R);
            }
            if (B < 2){
                lose += String.format("B %s\n", 2 - B);
            }
            if (N < 2){
                lose += String.format("N %s\n", 2 - N);
            }
            if (P < 8){
                lose += String.format("P %s\n", 8 - P);
            }
            return lose;
        }else if (player == ChessColor.WHITE){
            if (k < 1){
                lose += "k 1\n";
            }
            if (q < 1){
                lose += "q 1\n";
            }
            if (r < 2){
                lose += String.format("r %s\n", 2 - r);
            }
            if (b < 2){
                lose += String.format("b %s\n", 2 - b);
            }
            if (n < 2){
                lose += String.format("n %s\n", 2 - n);
            }
            if (p < 8){
                lose += String.format("p %s\n", 8 - p);
            }
            return lose;
        }
        return lose;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> points = new ArrayList<>();
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        points = chess.canMoveTo();
        ChessboardPoint temp;
        for (int i = 0; i < points.size(); i++){
            for (int j = 0; j < points.size() - 1 - i; j++){
                if (points.get(j).getX() > points.get(j + 1).getX()){
                    temp = points.get(j);
                    points.set(j, points.get(j + 1));
                    points.set(j + 1, temp);
                }
            }
        }

        for (int i = 0; i < points.size(); i++){
            for (int j = 0; j < points.size() - 1 - i;j++){
                if ((points.get(j).getX() == points.get(j + 1).getX()) && (points.get(j).getY() > points.get(j + 1).getY())){
                    temp = points.get(j);
                    points.set(j, points.get(j + 1));
                    points.set(j + 1, temp);
                }
            }
        }


        return points;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        /*for (ChessComponent[] component : chessComponents) {
            for (ChessComponent chessComponent : component) {
                chessComponent.setChessComponents(this.chessComponents);
            }
        }*/
        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
        ChessboardPoint destination = new ChessboardPoint(targetX, targetY);
        if (chessComponent.getChessColor() == this.currentPlayer){
            //chessComponent.setChessComponents(this.chessComponents);
            List<ChessboardPoint> canMovePoints = chessComponent.canMoveTo();
            for (ChessboardPoint canMovePoint : canMovePoints) {
                if (destination.getX() == canMovePoint.getX() && destination.getY() == canMovePoint.getY()) {
                    ChessComponent moveComponent;
                    if (chessComponent instanceof KingChessComponent){
                        moveComponent = new KingChessComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }else if (chessComponent instanceof QueenChessComponent){
                        moveComponent = new QueenChessComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }else if (chessComponent instanceof BishopChessComponent){
                        moveComponent = new BishopChessComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }else if (chessComponent instanceof KnightChessComponent){
                        moveComponent = new KnightChessComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }else if (chessComponent instanceof RookChessComponent){
                        moveComponent = new RookChessComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }else if (chessComponent instanceof PawnChessComponent){
                        moveComponent = new PawnChessComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }else {
                        moveComponent = new EmptySlotComponent();
                        moveComponent.setChessColor(chessComponent.getChessColor());
                        moveComponent.setSource(new ChessboardPoint(targetX, targetY));
                        moveComponent.setName(chessComponent.name);
                        moveComponent.setChessComponents(this.chessComponents);
                    }

                    chessComponents[targetX][targetY] = moveComponent;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setChessComponents(this.chessComponents);


                    if (this.currentPlayer == ChessColor.BLACK){
                        this.currentPlayer = ChessColor.WHITE;
                    }else if (this.currentPlayer == ChessColor.WHITE){
                        this.currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }

        return false;
    }

}

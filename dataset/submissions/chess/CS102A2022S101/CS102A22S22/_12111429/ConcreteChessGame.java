import java.util.*;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public void loadChessGame(List<String> chessboard){

        for(int i = 0; i < 8; i++){
            char[] col = chessboard.get(i).toCharArray();

            for(int j = 0; j < 8; j++){

                if(col[j] == 'k'){
                    KingChessComponent king = new KingChessComponent();
                    this.chessComponents[i][j] = king;
                    king.setChessColor(ChessColor.WHITE);
                    king.setName('k');
                }
                else if(col[j] == 'q'){
                    QueenChessComponent queen = new QueenChessComponent();
                    this.chessComponents[i][j] = queen;
                    queen.setChessColor(ChessColor.WHITE);
                    queen.setName('q');
                }
                else if(col[j] == 'r'){
                    RookChessComponent rook = new RookChessComponent();
                    this.chessComponents[i][j] = rook;
                    rook.setChessColor(ChessColor.WHITE);
                    rook.setName('r');
                }
                else if(col[j] == 'b'){
                    BishopChessComponent bishop = new BishopChessComponent();
                    this.chessComponents[i][j] = bishop;
                    bishop.setChessColor(ChessColor.WHITE);
                    bishop.setName('b');
                }
                else if(col[j] == 'n'){
                    KnightChessComponent knight = new KnightChessComponent();
                    this.chessComponents[i][j] = knight;
                    knight.setChessColor(ChessColor.WHITE);
                    knight.setName('n');
                }
                else if(col[j] == 'p'){
                    PawnChessComponent pawn = new PawnChessComponent();
                    this.chessComponents[i][j] = pawn;
                    pawn.setChessColor(ChessColor.WHITE);
                    pawn.setName('p');
                }

                else if(col[j] == 'K'){
                    KingChessComponent King = new KingChessComponent();
                    this.chessComponents[i][j] = King;
                    King.setChessColor(ChessColor.BLACK);
                    King.setName('K');
                }
                else if(col[j] == 'Q'){
                    QueenChessComponent Queen = new QueenChessComponent();
                    this.chessComponents[i][j] = Queen;
                    Queen.setChessColor(ChessColor.BLACK);
                    Queen.setName('Q');
                }
                else if(col[j] == 'R'){
                    RookChessComponent Rook = new RookChessComponent();
                    this.chessComponents[i][j] = Rook;
                    Rook.setChessColor(ChessColor.BLACK);
                    Rook.setName('R');
                }
                else if(col[j] == 'B'){
                    BishopChessComponent Bishop = new BishopChessComponent();
                    this.chessComponents[i][j] = Bishop;
                    Bishop.setChessColor(ChessColor.BLACK);
                    Bishop.setName('B');
                }
                else if(col[j] == 'N'){
                    KnightChessComponent Knight = new KnightChessComponent();
                    this.chessComponents[i][j] = Knight;
                    Knight.setChessColor(ChessColor.BLACK);
                    Knight.setName('N');
                }
                else if(col[j] == 'P'){
                    PawnChessComponent Pawn = new PawnChessComponent();
                    this.chessComponents[i][j] = Pawn;
                    Pawn.setChessColor(ChessColor.BLACK);
                    Pawn.setName('P');
                }

                else if(col[j] == '_'){
                    EmptySlotComponent empty = new EmptySlotComponent();
                    this.chessComponents[i][j] = empty;
                    empty.setChessColor(ChessColor.NONE);
                    empty.setName('_');
                }
            }
            if(chessboard.size() == 9){
                if(chessboard.get(8).equalsIgnoreCase("b"))
                    this.currentPlayer = ChessColor.BLACK;
                else
                    this.currentPlayer = ChessColor.WHITE;

            }
        }

    }


    public String getChessboardGraph(){
        StringBuilder chessboardGraph = new StringBuilder();

        for(int i = 0; i < this.chessComponents.length; i++){
            StringBuilder point = new StringBuilder();
            for(int j = 0; j < this.chessComponents.length; j++)
                point.append(this.chessComponents[i][j]);

            chessboardGraph.append(point).append("\n");
        }
        return chessboardGraph.toString();
    }



    public String getCapturedChess(ChessColor player){

        List<String> Chessboard = new ArrayList<String>(Arrays.asList(getChessboardGraph().split("\n")));
        loadChessGame(Chessboard);

        int kingNumber = 0;
        int queenNumber = 0;
        int rookNumber = 0;
        int bishopNumber = 0;
        int knightNumber = 0;
        int pawnNumber = 0;


        if(player == ChessColor.WHITE){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(getChess(i,j).toString().equals("k"))
                        kingNumber++;

                    else if(getChess(i,j).toString().equals("q"))
                        queenNumber++;

                    else if(getChess(i,j).toString().equals("r"))
                        rookNumber++;

                    else if(getChess(i,j).toString().equals("b"))
                        bishopNumber++;

                    else if(getChess(i,j).toString().equals("n"))
                        knightNumber++;

                    else if(getChess(i,j).toString().equals("p"))
                        pawnNumber++;
                }
            }

        }
        else if(player == ChessColor.BLACK){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(getChess(i,j).toString().equals("K"))
                        kingNumber++;

                    else if(getChess(i,j).toString().equals("Q"))
                        queenNumber++;

                    else if(getChess(i,j).toString().equals("R"))
                        rookNumber++;

                    else if(getChess(i,j).toString().equals("B"))
                        bishopNumber++;

                    else if(getChess(i,j).toString().equals("N"))
                        knightNumber++;

                    else if(getChess(i,j).toString().equals("P"))
                        pawnNumber++;
                }
            }
        }


        List<Integer> numberOfPieces = new ArrayList<Integer>();

        int capturedKing = 1 - kingNumber;
        numberOfPieces.add(capturedKing);

        int capturedQueen = 1 - queenNumber;
        numberOfPieces.add(capturedQueen);

        int capturedRook = 2 - rookNumber;
        numberOfPieces.add(capturedRook);

        int capturedBishop = 2 - bishopNumber;
        numberOfPieces.add(capturedBishop);

        int capturedKnight = 2 - knightNumber;
        numberOfPieces.add(capturedKnight);

        int capturedPawn = 8 - pawnNumber;
        numberOfPieces.add(capturedPawn);


        StringBuilder Piece = new StringBuilder();

        for(int i = 0; i < numberOfPieces.size(); i++){
            if(numberOfPieces.get(i) > 0){

                if(player == ChessColor.WHITE){
                    if(i == 0)
                        Piece.append("k ").append(capturedKing).append("\n");
                    else if(i == 1)
                        Piece.append("q ").append(capturedQueen).append("\n");
                    else if(i == 2)
                        Piece.append("r ").append(capturedRook).append("\n");
                    else if(i == 3)
                        Piece.append("b ").append(capturedBishop).append("\n");
                    else if(i == 4)
                        Piece.append("n ").append(capturedKnight).append("\n");
                    else if(i == 5)
                        Piece.append("p ").append(capturedPawn).append("\n");
                }
                else {
                    if (i == 0)
                        Piece.append("K ").append(capturedKing).append("\n");
                    else if (i == 1)
                        Piece.append("Q ").append(capturedQueen).append("\n");
                    else if (i == 2)
                        Piece.append("R ").append(capturedRook).append("\n");
                    else if (i == 3)
                        Piece.append("B ").append(capturedBishop).append("\n");
                    else if (i == 4)
                        Piece.append("N ").append(capturedKnight).append("\n");
                    else if (i == 5)
                        Piece.append("P ").append(capturedPawn).append("\n");
                }
            }
        }
        return String.valueOf(Piece);
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if((sourceX < 0 || sourceX >= 8) || (targetX < 0 || targetX >= 8) || (sourceY < 0 || sourceY >= 8) || (targetY < 0 || targetY >= 8))
            return false;

        ChessComponent Source = getChess(sourceX, sourceY);
        ChessComponent Target = getChess(targetX, targetY);

        if(Source instanceof EmptySlotComponent || Source.getChessColor() != this.currentPlayer){
            return false;
        }

        ChessboardPoint Points = Source.getChessboardPoint();

        if(Source.getChessColor() == this.currentPlayer && Target.getChessColor() != this.currentPlayer){
            List<ChessboardPoint> Notebook = getCanMovePoints(Points);
            for(ChessboardPoint elements : Notebook){
                if(elements.getX() == targetX && elements.getY() == targetY){
                    EmptySlotComponent empty = new EmptySlotComponent();
                    empty.setName('_');
                    chessComponents[targetX][targetY] = Source;

                    if(getCurrentPlayer() == ChessColor.WHITE)
                        this.currentPlayer = ChessColor.BLACK;
                    else
                        this.currentPlayer = ChessColor.WHITE;
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();

        ChessComponent ChessPoint = getChess(x, y);
        ChessPoint.setChessComponents(chessComponents);

        List<ChessboardPoint> canMovePoints = chessComponents[x][y].canMoveTo();


        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX() > o2.getX()) {
                    if(o1.getY() > o2.getY())
                        return -1;
                    return 1;
                }
                return 1;
            }
        });

        return canMovePoints;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return getCanMovePoints(canMoveTo().get(0));
    }
}

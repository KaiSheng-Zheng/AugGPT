import java.util.List;
import java.util.Locale;
import java.util.Arrays;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public void BubbleSort(List<ChessboardPoint> array){
        for(int i=0;i<array.size()-1;i++){
            for(int j=0;j<array.size()-1-i;j++){
                if((array.get(j).getX() > array.get(j+1).getX())||((array.get(j).getX() == array.get(j+1).getX())&&(array.get(j).getY() > array.get(j + 1).getY()))){
                    ChessboardPoint temp = array.get(j);
                    array.set(j,array.get(j + 1));
                    array.set(j + 1,temp);
                }
            }
        }


    }

    public void loadChessGame(List<String> chessboard){
        char M = chessboard.get(8).charAt(0);
        if (M == 'w'){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               char V = chessboard.get(i).charAt(j);
               switch (V){
                   case 'p' : this.chessComponents[i][j] = new PawnChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setName('p');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                   case 'P' : this.chessComponents[i][j] = new PawnChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('P');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'n' : this.chessComponents[i][j] = new KnightChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setName('n');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                   case 'N' : this.chessComponents[i][j] = new KnightChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('N');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'b' : this.chessComponents[i][j] = new BishopChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('b');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'B' : this.chessComponents[i][j] = new BishopChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('B');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'q' : this.chessComponents[i][j] = new QueenChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('q');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'Q' : this.chessComponents[i][j] = new QueenChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('Q');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'k' : this.chessComponents[i][j] = new KingChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('k');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'K' : this.chessComponents[i][j] = new KingChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('K');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case '_' : this.chessComponents[i][j] = new EmptySlotChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('_');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'r' : this.chessComponents[i][j] = new RookChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('r');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;
                   case 'R' : this.chessComponents[i][j] = new RookChessComponent();
                       this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                       this.chessComponents[i][j].setName('R');
                       this.chessComponents[i][j].setChessboard(this.chessComponents);
                       break;


               }
            }
        }


    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        StringBuilder Hate = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String a = String.valueOf(this.chessComponents[i][j].getName());

               Hate.append(a);

            }

        }
        String Row1 = Hate.substring(0,8);
        String Row2 = Hate.substring(8,16);
        String Row3 = Hate.substring(16,24);
        String Row4 = Hate.substring(24,32);
        String Row5 = Hate.substring(32,40);
        String Row6 = Hate.substring(40,48);
        String Row7 = Hate.substring(48,56);
        String Row8 = Hate.substring(56,64);
        String CurrentP;
        if (getCurrentPlayer() == ChessColor.BLACK){
            CurrentP = "b";
        }else {
            CurrentP = "w";
        }

        return Row1 + "\n" + Row2 + "\n" + Row3 + "\n" + Row4 + "\n" + Row5 + "\n" + Row6 + "\n" + Row7 + "\n" + Row8;
    }
    public String getCapturedChess(ChessColor player){
        int PawnCounter = 0;
        int KnightCounter = 0;
        int QueenCounter = 0;
        int BishopCounter = 0;
        int RookCounter = 0;
        int KingCounter = 0;
        int BPawnCounter = 0;
        int BKnightCounter = 0;
        int BQueenCounter = 0;
        int BBishopCounter = 0;
        int BRookCounter = 0;
        int BKingCounter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char b = chessComponents[i][j].getName();

                switch (b){
                        case'P': BPawnCounter++;break;
                        case'N': BKnightCounter++;break;
                        case'Q': BQueenCounter++;break;
                        case'R': BRookCounter++;break;
                        case'B': BBishopCounter++;break;
                        case'K': BKingCounter++;break;
                        case'p': PawnCounter++;break;
                        case'n': KnightCounter++;break;
                        case'q': QueenCounter++;break;
                        case'r': RookCounter++;break;
                        case'b': BishopCounter++;break;
                        case'k': KingCounter++;break;

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (player == ChessColor.BLACK){
            if(1 - BKingCounter != 0){
                sb.append("K");
                sb.append(" ");
                sb.append(1 - BKingCounter);
                sb.append("\n");
            }
            if (1 - BQueenCounter != 0){
                sb.append("Q");
                sb.append(" ");
                sb.append(1 - BQueenCounter);
                sb.append("\n");
            }
            if (2 - BRookCounter != 0){
                sb.append("R");
                sb.append(" ");
                sb.append(2 - BRookCounter);
                sb.append("\n");
            }
            if (2 - BBishopCounter != 0){
                sb.append("B");
                sb.append(" ");
                sb.append(2 - BBishopCounter);
                sb.append("\n");
            }
            if (2 - BKnightCounter != 0){
                sb.append("N");
                sb.append(" ");
                sb.append(2 - BKnightCounter);
                sb.append("\n");
            }
            if (8 - BPawnCounter != 0){
                sb.append("P");
                sb.append(" ");
                sb.append(8 - BPawnCounter);
                sb.append("\n");
            }
        }else {
            if(1 - KingCounter != 0){
                sb.append("k");
                sb.append(" ");
                sb.append(1 - KingCounter);
                sb.append("\n");
            }
            if (1 - QueenCounter != 0){
                sb.append("q");
                sb.append(" ");
                sb.append(1 - QueenCounter);
                sb.append("\n");
            }
            if (2 - RookCounter != 0){
                sb.append("r");
                sb.append(" ");
                sb.append(2 - RookCounter);
                sb.append("\n");
            }
            if (2 - BishopCounter != 0){
                sb.append("b");
                sb.append(" ");
                sb.append(2 - BishopCounter);
                sb.append("\n");
            }
            if (2 - KnightCounter != 0){
                sb.append("n");
                sb.append(" ");
                sb.append(2 - KnightCounter);
                sb.append("\n");
            }
            if (8 - PawnCounter != 0){
                sb.append("p");
                sb.append(" ");
                sb.append(8 - PawnCounter);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent ThisChess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> CanMovePoints = ThisChess.canMoveTo();
        BubbleSort(CanMovePoints);

        return CanMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        boolean CheckPlayer = (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer);
        if (!CheckPlayer){
            return  false;
        }else {
            List<ChessboardPoint> Final = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
            for (ChessboardPoint chessboardPoint : Final) {
                if ((targetX == chessboardPoint.getX()) && (targetY == chessboardPoint.getY())){
                    this.chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotChessComponent();
                    this.chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    this.chessComponents[sourceX][sourceY].setName('_');
                    this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                    chessComponents[targetX][targetY].setChessboard(this.chessComponents);
                    if (currentPlayer == ChessColor.BLACK){
                        setCurrentPlayer(ChessColor.WHITE);
                    }else {
                        setCurrentPlayer(ChessColor.BLACK);
                    }
                    return true;

                }


            }

        }
        return true;
    }


}

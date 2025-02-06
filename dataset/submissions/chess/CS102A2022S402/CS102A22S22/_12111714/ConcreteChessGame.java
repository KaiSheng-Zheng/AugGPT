import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessComponents = new ChessComponent[8][8];
        for (int string = 0;string<8;string++){
            for (int charm = 0;charm<8;charm++){
                if(chessboard.get(string).charAt(charm) == 'R' || chessboard.get(string).charAt(charm) == 'r'){
                    this.chessComponents[string][charm] = new RookChessComponent();
                }
                else if(chessboard.get(string).charAt(charm) == 'N' || chessboard.get(string).charAt(charm) == 'n'){
                    this.chessComponents[string][charm] = new KnightChessComponent();
                }
                else if(chessboard.get(string).charAt(charm) == 'B' || chessboard.get(string).charAt(charm) == 'b'){
                    this.chessComponents[string][charm] = new BishopChessComponent();
                }
                else if(chessboard.get(string).charAt(charm) == 'Q' || chessboard.get(string).charAt(charm) == 'q'){
                    this.chessComponents[string][charm] = new QueenChessComponent();
                }
                else if(chessboard.get(string).charAt(charm) == 'K' || chessboard.get(string).charAt(charm) == 'k'){
                    this.chessComponents[string][charm] = new KingChessComponent();
                }
                else if(chessboard.get(string).charAt(charm) == 'P' || chessboard.get(string).charAt(charm) == 'p'){
                    this.chessComponents[string][charm] = new PawnChessComponent();
                }
                else{
                    this.chessComponents[string][charm] = new EmptySlotComponent();
                }

                if(chessboard.get(string).charAt(charm) >= 65 && chessboard.get(string).charAt(charm) <= 90){
                    this.chessComponents[string][charm].setChessColor(ChessColor.BLACK);
                }
                else if(chessboard.get(string).charAt(charm) >= 97 && chessboard.get(string).charAt(charm) <= 122){
                    this.chessComponents[string][charm].setChessColor(ChessColor.WHITE);
                }

                chessComponents[string][charm].name = chessboard.get(string).charAt(charm);

                chessComponents[string][charm].setChessComponents(chessComponents);
            }
        }
        this.currentPlayer = (chessboard.get(8).charAt(0) == 'w'?ChessColor.WHITE:ChessColor.BLACK);
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return  this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    public void switchPlayer(){
        this.currentPlayer = (this.currentPlayer == ChessColor.BLACK?ChessColor.WHITE:ChessColor.BLACK);
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder output = new StringBuilder();
        for(int x = 0;x<8;x++){
            for (int y = 0;y<8;y++){
                output.append(code(this.chessComponents[x][y]));
            }
            output.append("\n");
        }
        output.delete(output.length()-1,output.length());
        return output.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 0,Q = 0,R = 0,B = 0,N = 0,P = 0;
        StringBuilder output = new StringBuilder();

        for (int x = 0;x<8;x++){
            for (int y = 0;y<8;y++){
                if(this.chessComponents[x][y].getChessColor() == player){
                    if(this.chessComponents[x][y] instanceof RookChessComponent){
                        R++;
                    }
                    if(this.chessComponents[x][y] instanceof QueenChessComponent){
                        Q++;
                    }
                    if(this.chessComponents[x][y] instanceof KingChessComponent){
                        K++;
                    }
                    if(this.chessComponents[x][y] instanceof KnightChessComponent){
                        N++;
                    }
                    if(this.chessComponents[x][y] instanceof PawnChessComponent){
                        P++;
                    }
                    if(this.chessComponents[x][y] instanceof BishopChessComponent){
                        B++;
                    }
                }
            }
        }

        if(1 - K > 0){
            output.append(player == ChessColor.BLACK ? "K" : "k").append(" ").append(1 - K).append("\n");
        }
        if(1 - Q > 0){
            output.append(player == ChessColor.BLACK ? "Q" : "q").append(" ").append(1 - Q).append("\n");
        }
        if(2 - R > 0){
            output.append(player == ChessColor.BLACK ? "R" : "r").append(" ").append(2 - R).append("\n");
        }
        if(2 - B > 0){
            output.append(player == ChessColor.BLACK ? "B" : "b").append(" ").append(2 - B).append("\n");
        }
        if(2 - N > 0){
            output.append(player == ChessColor.BLACK ? "N" : "n").append(" ").append(2 - N).append("\n");
        }
        if(8 - P > 0){
            output.append(player == ChessColor.BLACK ? "P" : "p").append(" ").append(8 - P).append("\n");
        }

        return output.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> input = this.chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(input);
        return input;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        if(this.chessComponents[sourceX][sourceY].canMoveTo().contains(target)){
            if(!(this.chessComponents[targetX][targetY] instanceof EmptySlotComponent)){
                this.chessComponents[targetX][targetY] = new EmptySlotComponent();
            }

            this.chessComponents[sourceX][sourceY].movement++;

            ChessComponent chess = this.chessComponents[targetX][targetY];

            this.chessComponents[targetX][targetY] = this.chessComponents[sourceX][sourceY];
            this.chessComponents[sourceX][sourceY] = chess;

            this.chessComponents[targetX][targetY].setSource(target);
            this.chessComponents[sourceX][sourceY].setSource(source);

            this.switchPlayer();

            for(int x = 0;x<8;x++){
                for(int y = 0;y<8;y++){
                    this.chessComponents[x][y].setChessComponents(chessComponents);
                }
            }

            return true;
        }
        return false;
    }

    public static String code(ChessComponent chessComponent){
        if(chessComponent instanceof KingChessComponent){
            return (chessComponent.getChessColor() == ChessColor.BLACK?"K":"k");
        }
        else if(chessComponent instanceof KnightChessComponent){
            return (chessComponent.getChessColor() == ChessColor.BLACK?"N":"n");
        }
        else if(chessComponent instanceof QueenChessComponent){
            return (chessComponent.getChessColor() == ChessColor.BLACK?"Q":"q");
        }
        else if(chessComponent instanceof BishopChessComponent){
            return (chessComponent.getChessColor() == ChessColor.BLACK?"B":"b");
        }
        else if(chessComponent instanceof RookChessComponent){
            return (chessComponent.getChessColor() == ChessColor.BLACK?"R":"r");
        }
        else if(chessComponent instanceof PawnChessComponent){
            return (chessComponent.getChessColor() == ChessColor.BLACK?"P":"p");
        }
        else{
            return "_";
        }
    }
}

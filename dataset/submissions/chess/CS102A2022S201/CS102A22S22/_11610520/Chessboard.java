import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Chessboard extends JComponent {
    private static final int CHESSBOARD_SIZE = 8;

    private final ChessComponent[][] chessComponents = new  ChessComponent[CHESSBOARD_SIZE][CHESSBOARD_SIZE];

    public void setCurrentColor(ChessColor currentColor) {
        this.currentColor = currentColor;
    }

    private ChessColor currentColor = ChessColor.BLACK;
    private final ClickController clickController = new ClickController(this);
    private final int CHESS_SIZE;

    private static int stepNumber=0;



    public void setStepNumber(int stepNumber) {
        Chessboard.stepNumber = stepNumber;
    }

    public Chessboard(int width, int height) {
        setLayout(null); 
        setSize(width, height);
        CHESS_SIZE = width / 8;
        System.out.printf("chessboard size = %d, chess size = %d\n", width, CHESS_SIZE);

        initiateChessPieces();
    }

    public  ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getCurrentColor() {
        return currentColor;
    }

    public void putChessOnBoard( ChessComponent chessComponent) {
        int row = chessComponent.getChessboardPoint().getX(), col = chessComponent.getChessboardPoint().getY();

        if (chessComponents[row][col] != null) {
            remove(chessComponents[row][col]);
        }
        add(chessComponents[row][col] = chessComponent);
    }



    public void swapChessComponents( ChessComponent chess1,  ChessComponent chess2) {
        if (!(chess2 instanceof EmptySlotComponent)) {
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        chessComponents[row1][col1] = chess1;
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        chessComponents[row2][col2] = chess2;

        chess1.repaint();
        chess2.repaint();
        if(chess1 instanceof PawnChessComponent && ((PawnChessComponent) chess1).isUpgrade()){

        }
        else if(KingChessComponent.black_castling_right){
            chess1 = chessComponents[0][7];
            chess2 = chessComponents[0][5];
            chess1.swapLocation(chess2);
            row1 = chess1.getChessboardPoint().getX();
            col1 = chess1.getChessboardPoint().getY();
            chessComponents[row1][col1] = chess1;
            row2 = chess2.getChessboardPoint().getX();
            col2 = chess2.getChessboardPoint().getY();
            chessComponents[row2][col2] = chess2;
            chess1.repaint();
            chess2.repaint();
            KingChessComponent.black_castling_right = false;
        }else if(KingChessComponent.white_castling_right){
            chess1 = chessComponents[7][7];
            chess2 = chessComponents[7][5];
            chess1.swapLocation(chess2);
            row1 = chess1.getChessboardPoint().getX();
            col1 = chess1.getChessboardPoint().getY();
            chessComponents[row1][col1] = chess1;
            row2 = chess2.getChessboardPoint().getX();
            col2 = chess2.getChessboardPoint().getY();
            chessComponents[row2][col2] = chess2;
            chess1.repaint();
            chess2.repaint();
            KingChessComponent.white_castling_right = false;
        }else if(KingChessComponent.black_castling_left){
            chess1 = chessComponents[0][0];
            chess2 = chessComponents[0][3];
            chess1.swapLocation(chess2);
            row1 = chess1.getChessboardPoint().getX();
            col1 = chess1.getChessboardPoint().getY();
            chessComponents[row1][col1] = chess1;
            row2 = chess2.getChessboardPoint().getX();
            col2 = chess2.getChessboardPoint().getY();
            chessComponents[row2][col2] = chess2;
            chess1.repaint();
            chess2.repaint();
            KingChessComponent.black_castling_left = false;
        }else if(KingChessComponent.white_castling_left){
            chess1 = chessComponents[7][0];
            chess2 = chessComponents[7][3];
            chess1.swapLocation(chess2);
            row1 = chess1.getChessboardPoint().getX();
            col1 = chess1.getChessboardPoint().getY();
            chessComponents[row1][col1] = chess1;
            row2 = chess2.getChessboardPoint().getX();
            col2 = chess2.getChessboardPoint().getY();
            chessComponents[row2][col2] = chess2;
            chess1.repaint();
            chess2.repaint();
            KingChessComponent.white_castling_left = false;
        }
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if(chess1.canMoveTo(chessComponents,new ChessboardPoint(i,j))){
                    if(chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() != chess1.getChessColor()){
                        boolean attacked = true;
                        System.out.println("------------------------------");
                        for (int k = 0; k <8 ; k++) {
                            for (int l = 0; l <8 ; l++) {
                                if (chessComponents[i][j].canMoveTo(chessComponents,new ChessboardPoint(k,l))){
                                    System.out.println(i);
                                    System.out.println(j);
                                    System.out.println("******************************");
                                    for (int m = 0; m <8 ; m++) {
                                        for (int n = 0; n <8 ; n++) {
                                            if (chessComponents[i][j].getChessColor()!=chess1.getChessColor() && chess1.canMoveTo(chessComponents,new ChessboardPoint(m,n))){
                                                System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                                            }else{
                                                attacked = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(attacked){
                            System.out.println(chess1.getChessColor().toString()+"win!");
                        }
                    }
                }
            }
        }

    }

    public void initiateEmptyChessboard() {
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                putChessOnBoard(new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE));
            }
        }
    }

    public void initiateChessPieces() {
        initiateEmptyChessboard();
        initRookOnBoard(0, 0, ChessColor.BLACK);
        initRookOnBoard(0, CHESSBOARD_SIZE - 1, ChessColor.BLACK);
        initRookOnBoard(CHESSBOARD_SIZE - 1, 0, ChessColor.WHITE);
        initRookOnBoard(CHESSBOARD_SIZE - 1, CHESSBOARD_SIZE - 1, ChessColor.WHITE);

        initKingOnBoard(0, 4, ChessColor.BLACK);
        initKingOnBoard(CHESSBOARD_SIZE - 1, 4, ChessColor.WHITE);

        initQueenOnBoard(0, 3, ChessColor.BLACK);
        initQueenOnBoard(CHESSBOARD_SIZE - 1, 3, ChessColor.WHITE);

        initBishopOnBoard(0, 2, ChessColor.BLACK);
        initBishopOnBoard(0, 5, ChessColor.BLACK);
        initBishopOnBoard(CHESSBOARD_SIZE - 1, 2, ChessColor.WHITE);
        initBishopOnBoard(CHESSBOARD_SIZE - 1, 5, ChessColor.WHITE);

        initKnightOnBoard(0, 1, ChessColor.BLACK);
        initKnightOnBoard(0, 6, ChessColor.BLACK);
        initKnightOnBoard(CHESSBOARD_SIZE - 1, 1, ChessColor.WHITE);
        initKnightOnBoard(CHESSBOARD_SIZE - 1, 6, ChessColor.WHITE);

        for (int i = 0; i <8 ; i++) {
            initPawnOnBoard(1, i, ChessColor.BLACK);
        }
        for (int i = 0; i <8 ; i++) {
            initPawnOnBoard(6, i, ChessColor.WHITE);
        }
    }


    private void initRookOnBoard(int row, int col, ChessColor color) {
         ChessComponent chessComponent = new RookChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initKingOnBoard(int row, int col, ChessColor color) {
         ChessComponent chessComponent = new KingChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initQueenOnBoard(int row, int col, ChessColor color) {
         ChessComponent chessComponent = new QueenChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initBishopOnBoard(int row, int col, ChessColor color) {
         ChessComponent chessComponent = new BishopChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initKnightOnBoard(int row, int col, ChessColor color) {
         ChessComponent chessComponent = new KnightChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    private void initPawnOnBoard(int row, int col, ChessColor color) {
         ChessComponent chessComponent = new PawnChessComponent(new ChessboardPoint(row, col), calculatePoint(row, col), color, clickController, CHESS_SIZE);
        chessComponent.setVisible(true);
        putChessOnBoard(chessComponent);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }


    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }

    public void loadGame(int[][] chessData, int currentPlayer) {
        initiateEmptyChessboard();
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if(chessData[i][j] == 1){
                    initKingOnBoard(i,j,ChessColor.BLACK);
                }else if(chessData[i][j] == 2){
                    initQueenOnBoard(i,j,ChessColor.BLACK);
                }else if(chessData[i][j] == 3){
                    initBishopOnBoard(i,j,ChessColor.BLACK);
                }else if(chessData[i][j] == 4){
                    initKnightOnBoard(i,j,ChessColor.BLACK);
                }else if(chessData[i][j] == 5){
                    initRookOnBoard(i,j,ChessColor.BLACK);
                }else if(chessData[i][j] == 6){
                    initPawnOnBoard(i,j,ChessColor.BLACK);
                }else if(chessData[i][j] == -1){
                    initKingOnBoard(i,j,ChessColor.WHITE);
                }else if(chessData[i][j] == -2){
                    initQueenOnBoard(i,j,ChessColor.WHITE);
                }else if(chessData[i][j] == -3){
                    initBishopOnBoard(i,j,ChessColor.WHITE);
                }else if(chessData[i][j] == -4){
                    initKnightOnBoard(i,j,ChessColor.WHITE);
                }else if(chessData[i][j] == -5){
                    initRookOnBoard(i,j,ChessColor.WHITE);
                }else if(chessData[i][j] == -6) {
                    initPawnOnBoard(i, j, ChessColor.WHITE);
                }
            }
        }
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                chessComponents[i][j].repaint();
                chessComponents[i][j].setVisible(true);
            }
        }
    }

}

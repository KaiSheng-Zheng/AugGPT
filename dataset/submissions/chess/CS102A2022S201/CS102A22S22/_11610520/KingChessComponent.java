import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class KingChessComponent extends ChessComponent {
    private static Image KING_WHITE;
    private static Image KING_BLACK;

    private boolean moved = false;

    public static boolean white_castling_right = false;

    public static boolean white_castling_left = false;

    public static boolean black_castling_right = false;

    public static boolean black_castling_left = false;

    private int value;

    private Image kingImage;

    public KingChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        initiateKingImage(chessColor);
        if (this.chessColor == ChessColor.BLACK){
            this.value = 1;
        }else{
            this.value = -1;
        }
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void loadResource() throws IOException {
        if (KING_WHITE == null) {
            KING_WHITE = ImageIO.read(new File("./images/king-white.png"));
        }

        if (KING_BLACK == null) {
            KING_BLACK = ImageIO.read(new File("./images/king-black.png"));
        }
    }

    private void initiateKingImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                kingImage = KING_WHITE;
            } else if (color == ChessColor.BLACK) {
                kingImage = KING_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destinationX = destination.getX();
        int destinationY = destination.getY();
        if(this.chessColor == ChessColor.WHITE && !moved && destinationX==7 && destinationY == 6 && chessComponents[7][6] instanceof EmptySlotComponent && chessComponents[7][5] instanceof EmptySlotComponent && chessComponents[7][7] instanceof RookChessComponent && !((RookChessComponent) chessComponents[7][7]).isMoved()) {
            moved = true;
            white_castling_right= true;
        }else if(this.chessColor == ChessColor.BLACK && !moved && destinationX==0 && destinationY == 6 && chessComponents[0][6] instanceof EmptySlotComponent && chessComponents[0][5] instanceof EmptySlotComponent && chessComponents[0][7] instanceof RookChessComponent && !((RookChessComponent) chessComponents[0][7]).isMoved()) {
            moved = true;
            black_castling_right = true;
        }else if(this.chessColor == ChessColor.WHITE && !moved && destinationX==7 && destinationY == 2 && chessComponents[7][2] instanceof EmptySlotComponent && chessComponents[7][1] instanceof EmptySlotComponent && chessComponents[7][3] instanceof EmptySlotComponent && chessComponents[7][0] instanceof RookChessComponent && !((RookChessComponent) chessComponents[7][0]).isMoved()){
            moved = true;
            white_castling_left = true;
        }else if(this.chessColor == ChessColor.BLACK && !moved && destinationX==0 && destinationY == 2 && chessComponents[0][2] instanceof EmptySlotComponent && chessComponents[0][1] instanceof EmptySlotComponent && chessComponents[0][3] instanceof EmptySlotComponent && chessComponents[0][0] instanceof RookChessComponent && !((RookChessComponent) chessComponents[0][0]).isMoved()){
            moved = true;
            black_castling_left = true;
        }
        else if (Math.abs(sourceX-destinationX) <=1 && Math.abs(sourceY-destinationY) <=1) {
            moved = true;
        }else{
            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(kingImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { 
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }

}

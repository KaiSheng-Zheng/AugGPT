import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PawnChessComponent extends ChessComponent {
    private static Image PAWN_WHITE;
    private static Image PAWN_BLACK;

    private boolean firstStep = true;

    private boolean upgrade= false;

    private int value;
    private Image pawnImage;

    public void loadResource() throws IOException {
        if (PAWN_WHITE == null) {
            PAWN_WHITE = ImageIO.read(new File("./images/pawn-white.png"));
        }

        if (PAWN_BLACK == null) {
            PAWN_BLACK = ImageIO.read(new File("./images/pawn-black.png"));
        }
    }



    private void initiatePawnImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                pawnImage = PAWN_WHITE;
            } else if (color == ChessColor.BLACK) {
                pawnImage = PAWN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PawnChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiatePawnImage(color);
        if (this.chessColor == ChessColor.BLACK){
            this.value = 6;
        }else{
            this.value = -6;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isUpgrade() {
        return upgrade;
    }

    public void setUpgrade(boolean upgrade) {
        this.upgrade = upgrade;
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(this.firstStep && destination.getX() - source.getX() < 3 && destination.getY() == source.getY() && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent && this.chessColor == ChessColor.BLACK){
            this.firstStep = false;
        }else if(this.firstStep && source.getX() - destination.getX() < 3 && destination.getY() == source.getY() && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent && this.chessColor == ChessColor.WHITE){
            this.firstStep = false;
        } else if(destination.getX() - source.getX() == 1 && destination.getY() == source.getY() && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent && this.chessColor == ChessColor.BLACK){ 
            this.firstStep = false;
        }else if(destination.getX() - source.getX() == -1 && destination.getY() == source.getY() && chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent && this.chessColor == ChessColor.WHITE) {
            this.firstStep = false;
        }else if(destination.getX() - source.getX() == 1 && Math.abs(destination.getY() - source.getY())==1 && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) && this.chessColor == ChessColor.BLACK) {
            this.firstStep = false;
        }else if(destination.getX() - source.getX() == -1 && Math.abs(destination.getY() - source.getY())==1 && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) && this.chessColor == ChessColor.WHITE){
            this.firstStep = false;
        }
        else { 
            return false;
        }
        if(this.chessColor == ChessColor.BLACK && destination.getX() ==7){
            upgrade = true;
        }else if(this.chessColor == ChessColor.WHITE && destination.getX() ==0){
            upgrade = true;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pawnImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) {
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}

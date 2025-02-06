import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class KnightChessComponent extends ChessComponent {

    private static Image KNIGHT_WHITE;
    private static Image KNIGHT_BLACK;

    private int value;

    private Image knightImage;

    public KnightChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        initiateKnightImage(chessColor);
        if (this.chessColor == ChessColor.BLACK){
            this.value = 4;
        }else{
            this.value = -4;
        }
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    private void initiateKnightImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                knightImage = KNIGHT_WHITE;
            } else if (color == ChessColor.BLACK) {
                knightImage = KNIGHT_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadResource() throws IOException {
        if (KNIGHT_WHITE == null) {
            KNIGHT_WHITE = ImageIO.read(new File("./images/knight-white.png"));
        }

        if (KNIGHT_BLACK == null) {
            KNIGHT_BLACK = ImageIO.read(new File("./images/knight-black.png"));
        }
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(source.getX() - destination.getX() == 2 && source.getY() - destination.getY() == 1) {

        }else if(source.getX() - destination.getX() == 2 && source.getY() - destination.getY() == -1) {

        }else if(source.getX() - destination.getX() == 1 && source.getY() - destination.getY() == 2) {

        }else if (source.getX() - destination.getX() == -1 && source.getY() - destination.getY() == 2) {

        }else if(source.getX() - destination.getX() == 1 && source.getY() - destination.getY() == -2) {

        }else if(source.getX() - destination.getX() == -1 && source.getY() - destination.getY() == -2) {

        }else if (source.getX() - destination.getX() == -2 && source.getY() - destination.getY() == 1) {

        }else if (source.getX() - destination.getX() == -2 && source.getY() - destination.getY() == -1) {

        }
        else { 
            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(knightImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { 
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}



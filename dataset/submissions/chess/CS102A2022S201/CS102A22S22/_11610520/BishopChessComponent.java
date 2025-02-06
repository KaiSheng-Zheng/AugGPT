import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BishopChessComponent extends ChessComponent {

    private static Image BISHOP_WHITE;
    private static Image BISHOP_BLACK;

    private int value;

    private Image bishopImage;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BishopChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        initiateBishopImage(chessColor);
        if (this.chessColor == ChessColor.BLACK){
            this.value = 3;
        }else{
            this.value = -3;
        }
    }


    private void initiateBishopImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                bishopImage = BISHOP_WHITE;
            } else if (color == ChessColor.BLACK) {
                bishopImage = BISHOP_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadResource() throws IOException {
        if (BISHOP_WHITE == null) {
            BISHOP_WHITE = ImageIO.read(new File("./images/bishop-white.png"));
        }

        if (BISHOP_BLACK == null) {
            BISHOP_BLACK = ImageIO.read(new File("./images/bishop-black.png"));
        }
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getY()-destination.getY() == source.getX()-destination.getX()) {
            int row;
            int col;
            if (source.getX()<destination.getX()){
                row = source.getX()+1;
                col = source.getY()+1;
            }else{
                row = destination.getX()+1;
                col = destination.getY()+1;
            }
            for (; row < Math.max(source.getX(), destination.getX()); row++, col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    System.out.println(row);
                    System.out.println(col);
                    return false;
                }
            }
        }
        else if (source.getY() + source.getX() == destination.getX() + destination.getY()) {
            int row;
            int col;
            if (source.getX()<destination.getX()){
                row = source.getX()+1;
                col = source.getY()-1;
            }else{
                row = destination.getX()+1;
                col = destination.getY()-1;
            }
            for (; row < Math.max(source.getX(), destination.getX()); row++,col--) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else { 

            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bishopImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { 
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}



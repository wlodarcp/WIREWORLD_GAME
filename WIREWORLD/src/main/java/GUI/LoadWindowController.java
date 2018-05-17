package GUI;

import StateTable.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.scene.paint.Color.GOLD;

public class LoadWindowController {
    private FileChooser fileChooser;
    private Canvas drawingCanvas;
    private GraphicsContext graphicsContext;
    private File file;
    private Canvas temporaryCanvas;
    private BufferedImage bufferedImage;
    private BufferedImage base;
    private BufferedImage[] baseArray = new BufferedImage[4];
    private FieldsTable fieldsTable;
    //private ;

    public LoadWindowController(Canvas canvas){
        drawingCanvas = canvas;
        graphicsContext = drawingCanvas.getGraphicsContext2D();
        try {
            base = ImageIO.read(new File("src/main/java/GUI/base.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(base == null){
            graphicsContext.fillRect(0,0,800,800);

        }
        for(int i = 0; i < 4; i ++ ){
            baseArray[i] = base.getSubimage((int)(i*drawingCanvas.getWidth()/30),0,(int)(drawingCanvas.getWidth()/30),(int)(drawingCanvas.getHeight()/30));
        }

    }

    public void load() {
        file = initializeFileChooser();

        if (file != null) {
            try {
                loadImage();
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(WireWorldApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadImage() throws IOException, URISyntaxException {


        bufferedImage = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedImage,null);
        if (image.getHeight() == drawingCanvas.getHeight())
        graphicsContext.drawImage(image,0,0);
        fieldsTable = generateFieldsTable(bufferedImage);

    }

    private File initializeFileChooser() {
        fileChooser = new FileChooser();
        addExtensionFilter(new FileChooser.ExtensionFilter("png (*.png)", "*.png"));
        addExtensionFilter(new FileChooser.ExtensionFilter("jpg (*.jpg)", "*.jpg"));
        return fileChooser.showOpenDialog(new Stage());

    }
    public void addExtensionFilter(FileChooser.ExtensionFilter extensionFilter) {
        this.fileChooser.getExtensionFilters().add(extensionFilter);
    }


    public FieldsTable generateFieldsTable(BufferedImage image){
       /*
            /* narazie tempa wersja na 30 * 30 */
            FieldsTable fieldsTable = new FieldsTable(30,30);

            BufferedImage[][] fieldsBufferedImage = new BufferedImage[30][30];
            for (int y = 0; y < 30; y ++){
                for (int x = 0; x < 30; x++){
                    fieldsBufferedImage[y][x] = image.getSubimage((int)(x*(drawingCanvas.getWidth()/30)), (int)(y*(drawingCanvas.getHeight()/30)), (int)(drawingCanvas.getWidth()/30),(int)( drawingCanvas.getHeight()/30));
                    fieldsTable.findFieldByPosition(x,y).setFieldState(checkField(fieldsBufferedImage[y][x]));
                }
            }
            return fieldsTable;
    }


    private FieldState checkField(BufferedImage field){
        if(bufferedImagesEqual(field, baseArray[0]))
            return new Conductor();
        if(bufferedImagesEqual(field, baseArray[1]))
            return new Head();
        if(bufferedImagesEqual(field, baseArray[2]))
            return new Tail();
        if(bufferedImagesEqual(field, baseArray[3]))
            return new Empty();
        return null;
    }

    boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 2; x < img1.getWidth()-2; x++) {
                for (int y = 2; y < img1.getHeight()-2; y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y))
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public FieldsTable getFieldsTable() {
        return fieldsTable;
    }
}

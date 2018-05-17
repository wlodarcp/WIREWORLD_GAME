package GUI;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaveWindowController {

    private FileChooser fileChooser;
    private Canvas drawingCanvas;
    private File file;


    public SaveWindowController(Canvas drawing_canvas) {
        this.drawingCanvas = drawing_canvas;
    }

    public void save() {
        file = initializeFileChooser();

        if (file != null) {
            try {
                saveImage();
            } catch (IOException ex) {
                Logger.getLogger(WireWorldApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addExtensionFilter(FileChooser.ExtensionFilter extensionFilter) {
        this.fileChooser.getExtensionFilters().add(extensionFilter);
    }

    private File initializeFileChooser() {
        fileChooser = new FileChooser();
        addExtensionFilter(new FileChooser.ExtensionFilter("png (*.png)", "*.png"));
        addExtensionFilter(new FileChooser.ExtensionFilter("jpg (*.jpg)", "*.jpg"));
        return fileChooser.showSaveDialog(new Stage());
    }

    public void saveImage() throws IOException {

        if (this.fileChooser.getSelectedExtensionFilter().getDescription().equalsIgnoreCase("png (*.png)")) {
            saveToPNG();
        } else if (this.fileChooser.getSelectedExtensionFilter().getDescription().equalsIgnoreCase("jpg (*.jpg)")) {
            saveToJPG();
        }

    }

    private void saveToJPG() throws IOException {

        WritableImage writableImage = new WritableImage((int) drawingCanvas.getWidth(), (int) drawingCanvas.getHeight());
        drawingCanvas.snapshot(null, writableImage);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);

        BufferedImage imageRGB =
                new BufferedImage(
                        (int) writableImage.getWidth(),
                        (int) writableImage.getHeight(),
                        BufferedImage.OPAQUE);
        Graphics2D graphics = imageRGB.createGraphics();

        graphics.drawImage(bufferedImage, 0, 0, null);

        ImageIO.write(imageRGB, "jpg", file);
        graphics.dispose();
    }

    private void saveToPNG() throws IOException {

        WritableImage writableImage = new WritableImage((int) drawingCanvas.getWidth(), (int) drawingCanvas.getHeight());
        drawingCanvas.snapshot(null, writableImage);
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
        ImageIO.write(renderedImage, "png", file);

    }

}
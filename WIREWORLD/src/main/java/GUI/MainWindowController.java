package GUI;

import Draw.*;
import Elements.*;
import StateTable.*;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javafx.scene.image.ImageView;


public class MainWindowController {

    private WireWorldApp application;
    private Scene scene;
    private Pen pen;
    private double fieldWidth;
    private double fieldHeight;
    private int canvasHeightInFields;
    private int canvasWidthInFields;
    private SaveWindowController saveWindowController;
    private LoadWindowController loadWindowController;
    private Element element;


    private GraphicsContext graphicsContextAnimationCanvas;
    private GraphicsContext graphicsContextDrawingCanvas;
    @FXML
    Canvas animation_canvas;
    @FXML
    Canvas drawing_canvas;
    @FXML
    Label xPosition;
    @FXML
    Label yPosition;
    @FXML
    AnchorPane root;
    @FXML
    JFXButton wireButton;
    @FXML
    JFXButton setButton;
    @FXML
    JFXTextField heightTextField;
    @FXML
    JFXTextField widthTextField;
    @FXML
    JFXToggleButton start_togglebutton;
    @FXML
    JFXSlider tempoSlider;
    @FXML
    JFXButton saveButton;
    @FXML
    ImageView imageViewDiode;
    @FXML
    JFXColorPicker wireColor;
    @FXML
    JFXColorPicker backgroundColor;
    @FXML
    Label gensNum;


    public void initialize() {
        graphicsContextAnimationCanvas = animation_canvas.getGraphicsContext2D();
        graphicsContextDrawingCanvas = drawing_canvas.getGraphicsContext2D();
        canvasHeightInFields = Integer.parseInt(heightTextField.getText());
        canvasWidthInFields = Integer.parseInt(widthTextField.getText());
        setFieldHeight(drawing_canvas.getHeight() / canvasHeightInFields);
        setFieldWidth(drawing_canvas.getWidth() / canvasWidthInFields);
        pen = new Pen(new FieldsTable(canvasHeightInFields, canvasWidthInFields));
        graphicsContextDrawingCanvas.fillRect(0, 0, 800, 800);
        graphicsContextAnimationCanvas.fillRect(0, 0, 800, 800);
        drawGrid();


    }

    public void setPen(Pen pen) {
        this.pen = pen;
        pen.setFieldsTable(new FieldsTable(canvasHeightInFields, canvasWidthInFields));

    }

    public void setFieldWidth(double fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public void setFieldHeight(double fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public double getFieldWidth() {
        return fieldWidth;
    }

    public double getFieldHeight() {
        return fieldHeight;
    }


    public void drawGrid() {
        graphicsContextDrawingCanvas.setStroke(Color.WHITE);
        graphicsContextAnimationCanvas.setStroke(Color.WHITE);
        for (int i = 0; i < canvasHeightInFields; i++) {
            for (int j = 0; j < canvasHeightInFields; j++) {
                graphicsContextDrawingCanvas.strokeRect(fieldWidth * j, fieldHeight * i, fieldWidth, fieldHeight);
                graphicsContextAnimationCanvas.strokeRect(fieldWidth * j, fieldHeight * i, fieldWidth, fieldHeight);

            }
        }
    }

    public void paintFieldAtDrawing(int x, int y, Color color) {
        graphicsContextDrawingCanvas.setFill(color);
        graphicsContextDrawingCanvas.fillRect(getFieldWidth() * x, getFieldHeight() * y, getFieldWidth(), getFieldHeight());
        graphicsContextDrawingCanvas.setStroke(Color.WHITE);
        graphicsContextDrawingCanvas.strokeRect(getFieldWidth() * x, getFieldHeight() * y, getFieldWidth(), getFieldHeight());
    }

    public void paintFieldAtAnimation(int x, int y, Color color) {
        graphicsContextAnimationCanvas.setFill(color);
        graphicsContextAnimationCanvas.fillRect(getFieldWidth() * x, getFieldHeight() * y, getFieldWidth(), getFieldHeight());
        graphicsContextAnimationCanvas.setStroke(Color.WHITE);
        graphicsContextAnimationCanvas.strokeRect(getFieldWidth() * x, getFieldHeight() * y, getFieldWidth(), getFieldHeight());
    }

    public void mousePosition(MouseEvent e) {
        xPosition.setText(String.valueOf(e.getSceneX() - 203));
        yPosition.setText(String.valueOf(e.getSceneY() - 130));
    }

    public void fieldOnClick(MouseEvent e) {
        pen.setMouseHandler(new MouseHandler(e));
        mousePosition(e);
        if (pen.getPenState() instanceof Insert ) {
            pen.affectField(pen.getMouseHandler().getPosition(), getFieldWidth(), getFieldHeight());
            refresh(pen.getFieldsTable());
        }else{
            pen.affectField(pen.getMouseHandler().getPosition(), getFieldWidth(), getFieldHeight());
            paintFieldAtDrawing((int) (pen.getMouseHandler().getPosition().getX() / getFieldWidth()), (int) (pen.getMouseHandler().getPosition().getY() / fieldHeight), pen.getPenState().getFieldState().getColor());


        }


    }


    public void configure(WireWorldApp wireWorldApp, Scene scene) {
        this.application = wireWorldApp;
        this.scene = scene;
    }

    public void toMain() {

        application.mainWindowController.show();
    }

    private void show() {

        application.show(scene);
    }

    public void changePenStateToDrawingWire() {
        this.pen.setPenState(new DrawingWire());
    }

    public void changePenStateToDrawingTail() {
        this.pen.setPenState(new DrawingTail());
    }

    public void changePenStateToDrawingHead() {
        this.pen.setPenState(new DrawingHead());
    }

    public void changePenStateToDrawingBackground() {
        this.pen.setPenState(new DrawingBackground());
    }

    public void setSizeAttribute() {

        canvasHeightInFields = Integer.parseInt(heightTextField.getText());
        canvasWidthInFields = Integer.parseInt(widthTextField.getText());
        setFieldHeight(drawing_canvas.getHeight() / canvasHeightInFields);
        setFieldWidth(drawing_canvas.getWidth() / canvasWidthInFields);
        pen.setFieldsTable(new FieldsTable(canvasHeightInFields, canvasWidthInFields));
        drawGrid();
    }

    public void refresh(FieldsTable fieldsTable) {
        for (int i = 0; i < fieldsTable.getHeight(); i++)
            for (int j = 0; j < fieldsTable.getWidth(); j++) {
                paintFieldAtDrawing(j, i, fieldsTable.findFieldByPosition(j, i).getFieldState().getColor());
                paintFieldAtAnimation(j, i, fieldsTable.findFieldByPosition(j, i).getFieldState().getColor());
            }
    }

    public void refreshAnimationWindow(){
        if(pen != null) {
            refresh(pen.getFieldsTable());
            application.setGenerationNumber(0);
            this.showActualGenerationNum();
        }
    }

    public void clear() {
        graphicsContextDrawingCanvas.setFill(Color.BLACK);
        graphicsContextDrawingCanvas.fillRect(0, 0, 800, 800);
        FieldsTable fieldsTable = pen.getFieldsTable();
        fieldsTable.resetFieldsTable();
        if (start_togglebutton.isSelected()) {
            start_togglebutton.setSelected(false);
            this.animateController();
        }
        drawGrid();
    }


    public void animateController() {
        if (start_togglebutton.isSelected()) {
            application.setAnimationSpeed(Duration.seconds(2.1-tempoSlider.getValue()));
            application.animate();
        } else {
            application.pause();
        }
    }


    public void saveButtonAction() {
        saveWindowController = new SaveWindowController(drawing_canvas);
        saveWindowController.save();
    }

    public void loadButtonAction(){
        loadWindowController = new LoadWindowController(animation_canvas);
        loadWindowController.load();
        pen.setFieldsTable(loadWindowController.getFieldsTable());
        application.setGenerationNumber(0);
        this.showActualGenerationNum();

    }

    public void pause(){
        if (start_togglebutton.isSelected()) {
            application.pause();
            start_togglebutton.setSelected(false);
        }

    }

    public void handleSpeed(){
        tempoSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            application.setAnimationSpeed(Duration.seconds(2.1 - newValue.doubleValue()));
            if(start_togglebutton.isSelected()){
                application.stop();
                application.animate();
            }

        });
    }

    public void changeColor(){
        Conductor.setColor(wireColor.getValue());
        Empty.setColor(backgroundColor.getValue());
    }

    public void insertDiodeSmall(){
        pen.setPenState(new Insert());
        pen.setElement(new DiodeSmallLeft());
    }

    public void insertDiodeMedium(){
        pen.setPenState(new Insert());
        pen.setElement(new DiodeMedium());
    }
    public void insertDiodeLarge(){
        pen.setPenState(new Insert());
        pen.setElement(new DiodeLarge());
    }
    public void insertCustomGate(){
        pen.setPenState(new Insert());
        pen.setElement(new CustomGate());
    }

    public void showActualGenerationNum(){
        gensNum.setText(Integer.toString(application.getGenerationNumber()));
    }




}


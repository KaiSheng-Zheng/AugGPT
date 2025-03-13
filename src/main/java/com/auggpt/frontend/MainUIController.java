package com.auggpt.frontend;

import com.auggpt.backend.controller.MainController;
import com.auggpt.backend.utils.Log4j2CapturerUtils;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class MainUIController {

    @FXML
    public Label docPathLabel;
    @FXML
    public TextField docPathTextField;
    @FXML
    public Button docPathBtn;
    @FXML
    public Label codePathLabel;
    @FXML
    public TextField codePathTextField;
    @FXML
    public Button codePathBtn;
    @FXML
    public Label apiKeyLabel;
    @FXML
    public TextField apiKeyTextField;
    @FXML
    public Button launchBtn;
    @FXML
    public Label inputLabel;
    @FXML
    public Label mainPanelLabel;
    @FXML
    public TextArea logTextArea;
    @FXML
    public ChoiceBox<String> apiChoiceBox;
    @FXML
    public TextField urlTextField;

    private BlockingQueue<String> logEvents;
    private final static Logger log = LogManager.getLogger("Log");
    private MainController controller;
    private Thread logThread;
    private final static String[] API_LIST = {"openai","ollama"};

    @FXML
    private void initialize() {
        codePathTextField.setEditable(false);
        docPathTextField.setEditable(false);

        apiChoiceBox.getItems().addAll(API_LIST);
        apiChoiceBox.setValue(API_LIST[0]);

        logTextArea.setEditable(false);
        logTextArea.textProperty().addListener(
                (ChangeListener<Object>) (observable, oldValue, newValue) -> {
            logTextArea.setScrollTop(Double.MAX_VALUE); // scroll to the button
        });
        logTextArea.setWrapText(true);

        coverageChart.getData().add(new XYChart.Series<>());
        mutationChart.getData().add(new XYChart.Series<>());

        controller = new MainController();
        startLogListener();
        testChart();
        System.out.println("initialized");
    }

    private void appendLog(String message) {
        // 确保在JavaFX主线程中执行UI操作
        Platform.runLater(() -> {
            // 追加消息到日志文本区域
            logTextArea.appendText(message+"\n");
        });
    }

    private void startLogListener() {
        Log4j2CapturerUtils.captureLogs("Log");
        logEvents = Log4j2CapturerUtils.getCapturedLogs();
        logThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // 从队列中获取日志事件
                    String logMessage = logEvents.take(); // 阻塞式获取
                    // 在JavaFX主线程中追加日志
                    Platform.runLater(() -> appendLog(logMessage));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 重新设置中断状态
                    break; // 退出线程
                }
            }
        });
        logThread.start();
    }

    private void testChart(){
        Thread tmp = new Thread(() -> {
            Random rd = new Random();
            for (int i = 0; i < 100; i++) {
                updateChart(coverageChart.getData().get(0), String.valueOf(i),rd.nextDouble()*10);
                updateChart(mutationChart.getData().get(0), String.valueOf(i),rd.nextDouble()*10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tmp.start();
    }

    @FXML
    protected void selectDocPath(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        FileChooser.ExtensionFilter docFilter = new FileChooser.ExtensionFilter("document", "*.txt", "*.doc", "*.docx", "*.pdf",".md");
        fileChooser.getExtensionFilters().add(docFilter);

        // 显示文件选择对话框
        File selectedFile = fileChooser.showOpenDialog(docPathBtn.getScene().getWindow());
        if (selectedFile != null) {
            docPathTextField.setText(selectedFile.getAbsolutePath());
            controller.setPDFPath(selectedFile.getAbsolutePath());
        } else {
            docPathTextField.setText("Not selected yet");
        }
    }

    @FXML
    protected void selectCodeDirPath(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select the source program directory");

        // 显示文件选择对话框
        File selectedFile = directoryChooser.showDialog(codePathBtn.getScene().getWindow());
        if (selectedFile != null) {
            codePathTextField.setText(selectedFile.getAbsolutePath());
            controller.setProgramRootPath(selectedFile.getAbsolutePath());
        } else {
            codePathTextField.setText("Not selected yet");
        }
    }

    @FXML
    protected void launchController(){
        try{
            controller.launch();
        } catch (Exception e){
            log.error(e);
        }
    }

    @FXML
    public void confirmAPIKey(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            controller.setAPI(apiKeyTextField.getText());
        }
    }

    @FXML
    public void confirmProvider(InputMethodEvent inputMethodEvent) {
        if (inputMethodEvent.getEventType().equals(InputMethodEvent.INPUT_METHOD_TEXT_CHANGED)){
            switch (apiChoiceBox.getValue()){
                case "ollama":{
                    urlTextField.setText("127.0.0.1:11434");
                    controller.setURL(urlTextField.getText());
                    apiKeyTextField.setDisable(true);
                    apiKeyTextField.setPromptText("Ignored");
                    break;
                }
                default: case "openai":{
                    urlTextField.setText("https://api.openai.com/v1/chat/completions");
                    controller.setURL(urlTextField.getText());
                    apiKeyTextField.setDisable(false);
                    apiKeyTextField.setPromptText("sk-xxxxx");
                    break;
                }
            }
        }
    }

    @FXML
    public LineChart<String,Number> coverageChart;
    @FXML
    public LineChart<String,Number> mutationChart;
    private final static int MAX_CHART_POINT = 10;
    public void updateChart(XYChart.Series<String, Number> series, String testNumber, double coveragePercentage) {
        // 创建一个新的数据点
        XYChart.Data<String, Number> newData = new XYChart.Data<>(testNumber, coveragePercentage);
        // 在JavaFX主线程中更新图表
        Platform.runLater(() -> {
            series.getData().add(newData);
            if (series.getData().size() >= MAX_CHART_POINT){
                series.getData().remove(0);
            }
        });
    }
}

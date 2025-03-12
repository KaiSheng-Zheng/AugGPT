package com.auggpt.frontend;

import com.auggpt.backend.controller.MainController;
import com.auggpt.backend.model.FancyOutput;
import com.auggpt.backend.utils.Log4j2CapturerUtils;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
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
    public LineChart<Number,Number> coverageChart;
    @FXML
    public LineChart<Number,Number> mutationChart;
    @FXML
    public TextArea logTextArea;

    private BlockingQueue<String> logEvents;
    private final static Logger log = LogManager.getLogger("Log");
    private MainController controller;
    private Thread logThread;

    @FXML
    private void initialize() {
        codePathTextField.setEditable(false);
        docPathTextField.setEditable(false);
        logTextArea.setEditable(false);
        logTextArea.textProperty().addListener(
                (ChangeListener<Object>) (observable, oldValue, newValue) -> {
            logTextArea.setScrollTop(Double.MAX_VALUE); // scroll to the button
        });
        logTextArea.setWrapText(true);

        controller = new MainController();
        Log4j2CapturerUtils.captureLogs("Log");
        logEvents = Log4j2CapturerUtils.getCapturedLogs();
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
        } else {
            codePathTextField.setText("Not selected yet");
        }
    }


    private boolean logListenerStarted = false;

    @FXML
    protected void launchController(){
        try{
            if (!logListenerStarted) {
                startLogListener();
                logListenerStarted = true;
            }
            controller.launch();
        } catch (Exception e){
            log.error(e);
        }
    }


}

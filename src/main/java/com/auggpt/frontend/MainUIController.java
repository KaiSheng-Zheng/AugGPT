package com.auggpt.frontend;

import com.auggpt.backend.controller.MainController;
import com.auggpt.backend.model.AgentType;
import com.auggpt.backend.utils.Log4j2CapturerUtils;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
    public TextArea logTextArea;
    @FXML
    public ChoiceBox<String> apiChoiceBox;
    @FXML
    public TextField urlTextField;
    @FXML
    public Button abortBtn;
    @FXML
    public TextField modelNameTextField;
    @FXML
    public TextArea generatedMethodTextArea;
    @FXML
    public TextField userPromptTextField;
    @FXML
    public MethodCoveragePane metricsVBox;

    private BlockingQueue<String> logEvents;
    private final static Logger log = LogManager.getLogger("Log");
    private MainController controller;
    private Thread logThread;
    private final static String[] API_LIST = {"openai","deepseek","qwen","anthropic","ollama"};

    private String oldUrl = "";
    private String oldApi = "";
    private String oldModelName = "";

    private MethodCoveragePane coverageView;

    @FXML
    private void initialize() {
        codePathTextField.setEditable(false);
        docPathTextField.setEditable(false);

        apiChoiceBox.getItems().addAll(API_LIST);
        apiChoiceBox.setValue("");

        logTextArea.setEditable(false);
        logTextArea.textProperty().addListener(
                (ChangeListener<Object>) (observable, oldValue, newValue) -> {
            logTextArea.setScrollTop(Double.MAX_VALUE); // scroll to the button
        });
        logTextArea.setWrapText(true);

        controller = new MainController(this);
        startLogListener();

        Platform.runLater(() -> launchBtn.getScene()
                .getWindow()
                .setOnCloseRequest(windowEvent -> {
                    logThread.interrupt();Platform.exit();
                }));

        apiChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue){
                    case "ollama":{
                        urlTextField.setText("127.0.0.1:11434");
                        modelNameTextField.setPromptText("Your model");
                        break;
                    }
                    case "qwen":{
                        urlTextField.setText("https://dashscope-intl.aliyuncs.com/compatible-mode/v1");
                        controller.setAgentType(AgentType.QWEN_2_5_32B_INSTRUCT);
                        break;
                    }
                    case "deepseek":{
                        urlTextField.setText("https://api.deepseek.com/v1");
                        controller.setAgentType(AgentType.DEEPSEEK);
                        break;
                    }
                    case "anthropic":{
                        urlTextField.setText("https://api.anthropic.com/v1");
                        controller.setAgentType(AgentType.CLAUDE);
                        break;
                    }
                    default: case "openai":{
                        urlTextField.setText("https://api.openai.com/v1");
                        controller.setAgentType(AgentType.GPT_4o_MINI);
                        break;
                    }
                }
                apiKeyTextField.setPromptText("xxxxxxx");
                controller.setURL(urlTextField.getText());
                apiKeyTextField.setDisable(false);
                controller.setModelName(controller.agentType.getName());
                modelNameTextField.setText(controller.agentType.getName());
            }
        });
        urlTextField.focusedProperty().addListener(((observableValue, oldVal, newVal) -> {
            String url = urlTextField.getText();
            if (!newVal && !url.equals(oldUrl)){
                controller.setURL(url);
                oldUrl=url;
            }
        }));
        apiKeyTextField.focusedProperty().addListener(((observableValue, oldVal, newVal) -> {
            String api = apiKeyTextField.getText();
            if (!newVal && !api.equals(oldApi)){
                controller.setAPI(api);
                oldApi=api;
            }
        }));
        modelNameTextField.focusedProperty().addListener(((observableValue, oldVal, newVal) -> {
            String modelName = modelNameTextField.getText();
            if (!newVal && !modelName.equals(oldModelName)){
                controller.setModelName(modelName);
                oldModelName = modelName;
            }
        }));

        Platform.runLater(() -> metricsVBox.simulateRandomBatch(10));

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


    private Thread controllerThread = null;
    @FXML
    public void launchController(MouseEvent mouseEvent){
        controllerThread = new Thread(() -> {
            try {
                controller.launch();
            }catch (Exception e){
                log.error(e);
            }
        });
        controllerThread.start();
    }

    @FXML
    public void abortController(MouseEvent mouseEvent) throws InterruptedException {
        if (controllerThread != null && controllerThread.isAlive()){
            controllerThread.interrupt();
            controllerThread.join();
            log.info("Process abort.");
        }
    }

    @FXML
    public void confirmAPIKey(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            controller.setAPI(apiKeyTextField.getText());
        }
    }

    public void addOrUpdateMethodMetric(String name, double coverage){
        Platform.runLater(() -> metricsVBox.addOrUpdateMethod(name, coverage));
    }

}

//package com.auggpt.frontend.depre;
//
//import com.auggpt.backend.controller.MainController;
//import com.auggpt.backend.utils.Log4j2CapturerUtils;
//import io.qt.Nullable;
//import io.qt.charts.QChart;
//import io.qt.charts.QChartView;
//import io.qt.charts.QLineSeries;
//import io.qt.core.*;
//import io.qt.gui.QCloseEvent;
//import io.qt.gui.QPainter;
//import io.qt.gui.QTextCursor;
//import io.qt.widgets.*;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.concurrent.BlockingQueue;
//
//public class MainWindow extends QMainWindow {
//    private QPushButton btnDuePath, btnCodePath;
//    private QLineEdit txtApiKey;
//    private QPlainTextEdit logArea;
//    private QPushButton btnLaunch, btnFormat, btnSaveLog, btnGenOutput, btnSaveOutput;
//    private QChartView coverageChartView, mutationCharView;
//    private QProgressBar progressBar;
//    private MainController controller;
//    private BlockingQueue<String> logEvents;
//    private Thread logThread;
//    private Thread controllerThread;
//    private QTimer timer;
//
//    public MainWindow() {
//        initUI();
//        initBackend();
//    }
//
//    private void initBackend() {
//        controller = new MainController();
//        Log4j2CapturerUtils.captureLogs("Log");
//        logEvents = Log4j2CapturerUtils.getCapturedLogs();
//
//
//
////        this.logThread = new Thread(() -> {
////            boolean running = true;
////            while (running){
////                try {
////                    appendLog("123");
////                    Thread.sleep(100);
////                } catch (InterruptedException ignored) {
////                    Thread.currentThread().interrupt();
////                    running = false;
////                }
////            }
////            System.out.println("something");
////        });
////
////
////        logThread.start();
//    }
//
//    private void appendControllerLog() throws InterruptedException {
//        appendLog(logEvents.take());
//    }
//
//    private void initUI() {
//        setWindowTitle("AugGPT Processor");
//        setMinimumSize(1024, 768);
//
//        QWidget centralWidget = new QWidget();
//        QVBoxLayout mainLayout = new QVBoxLayout(centralWidget);
//
//        QGroupBox inputGroup = new QGroupBox("Input Settings");
//        QFormLayout inputLayout = new QFormLayout();
//        btnDuePath = createPathButton("Select Due Path...");
//        btnCodePath = createPathButton("Select Code Path...");
//        txtApiKey = new QLineEdit();
//        txtApiKey.setPlaceholderText("Enter API Key (Ubuntu format)");
//        btnLaunch = new QPushButton("Launch");
//        inputLayout.addRow("Due Path:", btnDuePath);
//        inputLayout.addRow("Code Path:", btnCodePath);
//        inputLayout.addRow("API Key:", txtApiKey);
//        inputLayout.addRow("Launch", btnLaunch);
//        inputGroup.setLayout(inputLayout);
//
//        QGroupBox processGroup = new QGroupBox("Panel");
//        QHBoxLayout processLayout = new QHBoxLayout();
//
//        QGroupBox logGroup = new QGroupBox("Log");
//        QVBoxLayout logLayout = new QVBoxLayout();
//
//        logArea = new QPlainTextEdit();
//        logArea.setReadOnly(true);
//        logLayout.addWidget(logArea);
//        logGroup.setLayout(logLayout);
//
//        QHBoxLayout btnRow = new QHBoxLayout();
//        btnFormat = new QPushButton("Format");
//        btnSaveLog = new QPushButton("Save Log As...");
//        btnGenOutput = new QPushButton("Generate Output");
//        btnSaveOutput = new QPushButton("Save Output As...");
//        btnRow.addWidget(btnFormat);
//        btnRow.addWidget(btnSaveLog);
//        btnRow.addWidget(btnGenOutput);
//        btnRow.addWidget(btnSaveOutput);
//
//        QGroupBox outputGroup = new QGroupBox("Output");
//        QVBoxLayout outputLayout = new QVBoxLayout();
//        outputLayout.addLayout(btnRow);
//        outputGroup.setLayout(outputLayout);
//
//        QGroupBox infoGroup = new QGroupBox();
//        QVBoxLayout infoLayout = new QVBoxLayout();
//        initChart();
//        infoLayout.addWidget(coverageChartView);
//        infoLayout.addWidget(mutationCharView);
//        infoGroup.setLayout(infoLayout);
//
//        outputGroup.setLayout(outputLayout);
//        processLayout.addWidget(infoGroup);
//        processLayout.addWidget(logGroup);
//        processGroup.setLayout(processLayout);
//
//        mainLayout.addWidget(inputGroup);
//        mainLayout.addWidget(processGroup);
//        mainLayout.addWidget(outputGroup);
//
////        cursor = logArea.textCursor();
////        logArea.setTextCursor(cursor);
//
//        setCentralWidget(centralWidget);
//        applyStyle();
//        connectSignals();
//    }
//
//    private void initChart() {
//        QChart covChart = new QChart();
//        covChart.setTitle("Coverage Test Result");
//        covChart.setTheme(QChart.ChartTheme.ChartThemeLight);
//        QLineSeries covSeries = new QLineSeries();
//        covSeries.setName("Coverage");
//        covChart.addSeries(covSeries);
//        covChart.createDefaultAxes();
//        coverageChartView = new QChartView(covChart);
//        coverageChartView.setRenderHint(QPainter.RenderHint.Antialiasing);
//
//        QChart mutChart = new QChart();
//        mutChart.setTitle("Mutation Test Result");
//        mutChart.setTheme(QChart.ChartTheme.ChartThemeLight);
//        QLineSeries mutSeries = new QLineSeries();
//        mutSeries.setName("Mutation Score");
//        mutChart.addSeries(mutSeries);
//        mutChart.createDefaultAxes();
//        mutationCharView = new QChartView(mutChart);
//        mutationCharView.setRenderHint(QPainter.RenderHint.Antialiasing);
//    }
//
////    private void updateChart(boolean success) {
////        QChart chart = chartView.chart();
////        chart.series().clear();
////        QLineSeries newSeries = new QLineSeries();
////        newSeries.setName(success ? "Completed" : "Failed");
////        newSeries.append(0, 0);
////        newSeries.append(1, success ? 100 : 50);
////        if (success) {
////            newSeries.setColor(new QColor(0, 255, 0));
////        }
////        chart.addSeries(newSeries);
////        chart.createDefaultAxes();
////    }
//
//    private void connectSignals() {
//        btnDuePath.clicked.connect(() ->
//                showFileDialog("Select Due File", "Text Files (*.txt)")
//        );
//        btnCodePath.clicked.connect(() ->
//                showDirectoryDialog("Select Code Directory")
//        );
//
//        btnLaunch.clicked.connect(this::launch);
//        btnFormat.clicked.connect(this::formatLogs);
//        btnSaveLog.clicked.connect(this::saveLogs);
//        btnGenOutput.clicked.connect(this::generateOutput);
//        btnSaveOutput.clicked.connect(this::saveOutput);
//
//
//    }
//
//    private void generateOutput() {
//        appendLog("Generating output...");
//    }
//
//    private void saveOutput() {
//        appendLog("Saving output...");
//    }
//
//    private void launch(){
//        btnLaunch.setDisabled(true);
//        controllerThread = new Thread(() -> {
//            try {
//                controller.launch();
//            } catch (Exception e){
//                appendLog(e.getMessage());
//            }
//        });
//        controllerThread.start();
//        try {
//            controllerThread.join();
//        } catch (InterruptedException e) {
//            appendLog(e.getMessage());
//        }
//        btnLaunch.setDisabled(false);
//    }
//
//
//
//    private void showFileDialog(String title, String filter) {
//        QFileDialog.Result<String> tmp = QFileDialog.getOpenFileName(this, title, "", filter);
//        if (tmp == null){
//            return;
//        }
//        String path = tmp.result;
//        if (!path.isEmpty()) {
//            appendLog("Selected path: " + path);
//        }
//    }
//
//    private void appendLog(String message) {
//        QTextCursor cursor = logArea.textCursor();
//        cursor.movePosition(QTextCursor.MoveOperation.End, QTextCursor.MoveMode.MoveAnchor);
//        logArea.setTextCursor(cursor);
//        logArea.appendPlainText(message);
//        QScrollBar scrollBar =  logArea.verticalScrollBar();
//        if (scrollBar != null){
//            scrollBar.setSliderPosition(scrollBar.getMaximum());
//        }
////        cursor.movePosition(QTextCursor.MoveOperation.End);
//    }
//
//    private void formatLogs() {
//        String text = logArea.toPlainText();
//        String formatted = text.replaceAll("ERROR", "[ERROR]")
//                .replaceAll("WARN", "[WARNING]");
//        logArea.setPlainText(formatted);
//    }
//
//    private void saveLogs() {
//        QFileDialog.Result<String> tmp = QFileDialog.getSaveFileName(this, "Save Logs", "", "Log Files (*.log)");
//        if (tmp == null) return;
//        String path = tmp.result;
//        if (!path.isEmpty()) {
//            try {
//                Files.write(Paths.get(path), logArea.toPlainText().getBytes());
//                appendLog("Logs saved to: " + path);
//            } catch (IOException e) {
//                appendLog("[ERROR] Failed to save logs: " + e.getMessage());
//            }
//        }
//    }
//
//    private void applyStyle() {
////        String style = "QMainWindow { background: #2E2E2E; }\n" +
////                "QGroupBox { color: #FFFFFF; border: 1px solid #404040; }\n" +
////                "QTextEdit { background: #1E1E1E; color: #CCCCCC; }\n" +
////                "QPushButton { background: #404040; color: white; padding: 5px; }\n" +
////                "QPushButton:hover { background: #505050; }\n" +
////                "QLineEdit { background: #333333; color: white; }";
////        setStyleSheet(style);
//    }
//
//    private QPushButton createPathButton(String buttonText) {
//        return new QPushButton(buttonText);
//    }
//
//    private void showDirectoryDialog(String title) {
//        String path = QFileDialog.getExistingDirectory(this, title, "");
//        if (path != null && !path.isEmpty()) {
//            appendLog("Selected path: " + path);
//        }
//    }
//
//    @Override
//    protected void closeEvent(@Nullable QCloseEvent event) {
//        super.closeEvent(event);
////        this.logThread.interrupt();
//    }
//
//    public static void main(String[] args) {
//        QApplication.initialize(args);
//        MainWindow mainWindow = new MainWindow();
//        mainWindow.show();
//        QApplication.exec();
//    }
//}

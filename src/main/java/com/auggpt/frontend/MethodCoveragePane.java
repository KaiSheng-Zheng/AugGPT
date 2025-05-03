package com.auggpt.frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;

import java.util.*;

public class MethodCoveragePane extends VBox {
    private final VBox container = new VBox(5);
    private final Map<String, Double> methodCoverageMap = new HashMap<>();
    private final double fullWidth = 230;
    private final double fullHeight = 615;
    private ScrollPane scrollPane;

    public MethodCoveragePane() {
        this.setPadding(new Insets(5));
        this.setSpacing(5);
        scrollPane = new ScrollPane(container);
//        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(fullHeight);
        this.getChildren().add(scrollPane);
    }

    public void addOrUpdateMethod(String methodName, double coverage) {
        methodCoverageMap.put(methodName, coverage);
        redraw();
    }

    private void redraw() {
        container.getChildren().clear();

        methodCoverageMap.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(entry -> {
                    String methodName = entry.getKey();
                    double coverage = entry.getValue();
                    container.getChildren().add(createNode(methodName, coverage));
                });
    }

//    private Node createNode(String methodName, double coverage) {
//        Label label = new Label(methodName);
//        label.setMaxWidth(Double.MAX_VALUE);
//        label.setAlignment(Pos.CENTER_LEFT);
//        label.setPadding(new Insets(5));
//        label.setTooltip(new Tooltip(String.format("覆盖率：%.1f%%", coverage * 100)));
//
//        Region bar = new Region();
//        bar.setMinHeight(30);
//        bar.setStyle("-fx-background-color: rgba(144,238,144,0.8);");
//
//        StackPane stack = new StackPane();
//        stack.setMaxWidth(Double.MAX_VALUE);
//        stack.setMinHeight(30);
//        stack.getChildren().addAll(bar, label);
//        StackPane.setAlignment(bar, Pos.CENTER_LEFT);
//        StackPane.setAlignment(label, Pos.CENTER_LEFT);
//
//        double barWidth = Math.max(coverage * fullWidth, 1); // 避免太窄看不到
//        bar.setMaxWidth(barWidth);
//
//        return stack;
//    }
    private Node createNode(String methodName, double coverage){
        Label label = new Label(methodName);
        label.setPadding(new Insets(5));
        label.setTooltip(new Tooltip(String.format("覆盖率：%.1f%%", coverage * 100)));
        label.setStyle("-fx-background-color: transparent;");
        label.setWrapText(false);  // 禁止自动换行
        label.setMinWidth(Region.USE_PREF_SIZE);
        label.setMaxWidth(Region.USE_COMPUTED_SIZE);

        ScrollPane scrollPane = new ScrollPane(label);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefHeight(30);

        Region bar = new Region();
        bar.setMinHeight(30);
        bar.setStyle("-fx-background-color: rgba(103,255,103,0.3);");
        double barWidth = Math.max(coverage * fullWidth, 1); // 避免太窄看不到
        bar.setMaxWidth(barWidth);
        bar.setDisable(true);

        StackPane stack = new StackPane();
        stack.setPrefWidth(fullWidth-5);
        stack.setMinHeight(30);
        stack.setStyle("-fx-border-color: transparent;");
        stack.getChildren().addAll(scrollPane,bar); // 注意替换成 scrollPane
        StackPane.setAlignment(bar, Pos.CENTER_LEFT);
        StackPane.setAlignment(scrollPane, Pos.CENTER_LEFT);

        scrollPane.setStyle(
                "-fx-background-color: rgba(0,0,0,0);");
        Node viewport = scrollPane.lookup(".viewport");
        if (viewport != null) {
            viewport.setStyle("-fx-background-color: transparent;");
        }

        return stack;

    }

    // 可选模拟方法：添加多个随机条目
    public void simulateRandomBatch(int batchSize) {
        Random rand = new Random();
        for (int i = 0; i < batchSize; i++) {
            String name = "public void methoddddddddddddddddddddddddddddddddddddddd" + (rand.nextInt(20)) + "()"; // 模拟重复
            double coverage = 0.05 + rand.nextDouble() * 0.9;
            addOrUpdateMethod(name, coverage);
        }
    }
}

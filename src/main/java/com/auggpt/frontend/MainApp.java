package com.auggpt.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // 加载FXML文件
            Parent root = FXMLLoader.load(getClass().getResource("/com/auggpt/frontend/MainController.fxml"));

            // 创建场景
            Scene scene = new Scene(root);

            // 配置主窗口
            primaryStage.setTitle("JavaFX Main Application"); // 设置窗口标题
            primaryStage.setScene(scene);                     // 设置场景
            primaryStage.setMinWidth(800);                    // 设置最小宽度
            primaryStage.setMinHeight(600);                   // 设置最小高度
            primaryStage.show();                              // 显示窗口
        } catch (Exception e) {
            // 异常处理：打印错误信息
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动JavaFX应用程序
        launch(args);
    }
}
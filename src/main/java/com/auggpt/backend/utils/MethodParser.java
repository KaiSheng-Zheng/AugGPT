package com.auggpt.backend.utils;

import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.IMethodCoverage;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    public static String parseMethod(IMethodCoverage methodCoverage) {
        // 获取方法名
        String methodName = methodCoverage.getName();

        // 获取方法描述符
        String methodDesc = methodCoverage.getDesc();

        // 解析方法描述符
        String returnType = parseReturnType(methodDesc);
        List<String> parameterTypes = parseParameterTypes(methodDesc);

        // 构造参数列表字符串
        StringBuilder parameterList = new StringBuilder();
        for (int i = 0; i < parameterTypes.size(); i++) {
            parameterList.append(parameterTypes.get(i)).append(" var").append(i + 1);
            if (i < parameterTypes.size() - 1) {
                parameterList.append(", ");
            }
        }

        // 构造完整的方法声明
        return returnType + " " + methodName + "(" + parameterList + ")";
    }

    private static String parseReturnType(String methodDesc) {
        // 方法描述符的最后一个字符是返回类型
        int lastParenIndex = methodDesc.lastIndexOf(')');
        return parseType(methodDesc.substring(lastParenIndex + 1));
    }

    private static List<String> parseParameterTypes(String methodDesc) {
        List<String> parameterTypes = new ArrayList<>();
        int startIndex = 1; // 跳过方法描述符的第一个 '('
        int endIndex = methodDesc.indexOf(')');

        while (startIndex < endIndex) {
            int arrayDepth = 0;
            while (methodDesc.charAt(startIndex) == '[') {
                arrayDepth++;
                startIndex++;
            }

            char typeChar = methodDesc.charAt(startIndex);
            String type;
            if (typeChar == 'L') {
                // 对象类型
                int semiColonIndex = methodDesc.indexOf(';', startIndex);
                type = methodDesc.substring(startIndex + 1, semiColonIndex).replace('/', '.');
                startIndex = semiColonIndex + 1;
            } else {
                // 基本类型
                type = parseType(typeChar);
                startIndex++;
            }

            // 添加数组维度
            for (int i = 0; i < arrayDepth; i++) {
                type += "[]";
            }

            parameterTypes.add(type);
        }

        return parameterTypes;
    }

    private static String parseType(String type) {
        switch (type) {
            case "V":
                return "void";
            case "I":
                return "int";
            case "Z":
                return "boolean";
            case "B":
                return "byte";
            case "C":
                return "char";
            case "D":
                return "double";
            case "F":
                return "float";
            case "J":
                return "long";
            case "S":
                return "short";
            default:
                return type; // 对象类型
        }
    }

    private static String parseType(char typeChar) {
        switch (typeChar) {
            case 'V':
                return "void";
            case 'I':
                return "int";
            case 'Z':
                return "boolean";
            case 'B':
                return "byte";
            case 'C':
                return "char";
            case 'D':
                return "double";
            case 'F':
                return "float";
            case 'J':
                return "long";
            case 'S':
                return "short";
            default:
                return typeChar + ""; // 对象类型
        }
    }

//    public static void main(String[] args) {
//        // 示例：假设你有一个 IMethodCoverage 对象
//        IMethodCoverage methodCoverage = ...; // 获取 IMethodCoverage 对象
//
//        // 解析方法并打印
//        String methodDeclaration = parseMethod(methodCoverage);
//        System.out.println(methodDeclaration);
//    }
}
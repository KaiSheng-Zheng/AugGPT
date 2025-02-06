package com.unfbx.chatgpt.utils;

import cn.hutool.core.util.StrUtil;
import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.EncodingType;
import com.knuddels.jtokkit.api.ModelType;
import com.unfbx.chatgpt.entity.chat.BaseChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.FunctionCall;
import com.unfbx.chatgpt.entity.chat.Message;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.*;



@Slf4j
public class TikTokensUtil {
    

    private static final Map<String, Encoding> modelMap = new HashMap<>();
    

    private static final EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();

    static {
        for (ModelType modelType : ModelType.values()) {
            modelMap.put(modelType.getName(), registry.getEncodingForModel(modelType));
        }
//        modelMap.put(ChatCompletion.Model.GPT_3_5_TURBO_0301.getName(), registry.getEncodingForModel(ModelType.GPT_3_5_TURBO));
        modelMap.put(ChatCompletion.Model.GPT_3_5_TURBO_0613.getName(), registry.getEncodingForModel(ModelType.GPT_3_5_TURBO));
        modelMap.put(ChatCompletion.Model.GPT_3_5_TURBO_0125.getName(), registry.getEncodingForModel(ModelType.GPT_3_5_TURBO));
        modelMap.put(ChatCompletion.Model.GPT_3_5_TURBO_16K.getName(), registry.getEncodingForModel(ModelType.GPT_3_5_TURBO));
        modelMap.put(ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName(), registry.getEncodingForModel(ModelType.GPT_3_5_TURBO));
        modelMap.put(ChatCompletion.Model.GPT_3_5_TURBO_1106.getName(), registry.getEncodingForModel(ModelType.GPT_3_5_TURBO));
        modelMap.put(ChatCompletion.Model.GPT_4_32K.getName(), registry.getEncodingForModel(ModelType.GPT_4));
//        modelMap.put(ChatCompletion.Model.GPT_4_32K_0314.getName(), registry.getEncodingForModel(ModelType.GPT_4));
//        modelMap.put(ChatCompletion.Model.GPT_4_0314.getName(), registry.getEncodingForModel(ModelType.GPT_4));
        modelMap.put(ChatCompletion.Model.GPT_4_0613.getName(), registry.getEncodingForModel(ModelType.GPT_4));
        modelMap.put(ChatCompletion.Model.GPT_4_32K_0613.getName(), registry.getEncodingForModel(ModelType.GPT_4));
        modelMap.put(ChatCompletion.Model.GPT_4_1106_PREVIEW.getName(), registry.getEncodingForModel(ModelType.GPT_4));
        modelMap.put(ChatCompletion.Model.GPT_4_VISION_PREVIEW.getName(), registry.getEncodingForModel(ModelType.GPT_4));
    }

    

    public static List<Integer> encode(@NotNull Encoding enc, String text) {
        return StrUtil.isBlank(text) ? new ArrayList<>() : enc.encode(text);
    }

    

    public static int tokens(@NotNull Encoding enc, String text) {
        return encode(enc, text).size();
    }


    

    public static String decode(@NotNull Encoding enc, @NotNull List<Integer> encoded) {
        return enc.decode(encoded);
    }

    

    public static Encoding getEncoding(@NotNull EncodingType encodingType) {
        return registry.getEncoding(encodingType);
    }

    

    public static List<Integer> encode(@NotNull EncodingType encodingType, String text) {
        if (StrUtil.isBlank(text)) {
            return new ArrayList<>();
        }
        Encoding enc = getEncoding(encodingType);
        return enc.encode(text);
    }

    

    public static int tokens(@NotNull EncodingType encodingType, String text) {
        return encode(encodingType, text).size();
    }


    

    public static String decode(@NotNull EncodingType encodingType, @NotNull List<Integer> encoded) {
        Encoding enc = getEncoding(encodingType);
        return enc.decode(encoded);
    }


    

    public static Encoding getEncoding(@NotNull String modelName) {
        return modelMap.get(modelName);
    }

    

    public static List<Integer> encode(@NotNull String modelName, String text) {
        if (StrUtil.isBlank(text)) {
            return new ArrayList<>();
        }
        Encoding enc = getEncoding(modelName);
        if (Objects.isNull(enc)) {
            log.warn("[{}] The model does not exist or does not currently support computation tokens， Return directly tokens==0");
            return new ArrayList<>();
        }
        return enc.encode(text);
    }

    

    public static int tokens(@NotNull String modelName, String text) {
        return encode(modelName, text).size();
    }


    

    public static int tokens(@NotNull String modelName, @NotNull List<Message> messages) {
        Encoding encoding = getEncoding(modelName);
        int tokensPerMessage = 0;
        int tokensPerName = 0;
        if (modelName.equals(ChatCompletion.Model.GPT_3_5_TURBO_0613.getName())
                || modelName.equals(ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName())
//                || modelName.equals(ChatCompletion.Model.GPT_4_0314.getName())
//                || modelName.equals(ChatCompletion.Model.GPT_4_32K_0314.getName())
                || modelName.equals(ChatCompletion.Model.GPT_4_0613.getName())
                || modelName.equals(ChatCompletion.Model.GPT_4_32K_0613.getName())
        ) {
            tokensPerMessage = 3;
            tokensPerName = 1;
//        }else if(modelName.equals(ChatCompletion.Model.GPT_3_5_TURBO_0301.getName())){
//            tokensPerMessage = 4;
//            tokensPerName = -1;
        }else if(modelName.contains(ChatCompletion.Model.GPT_3_5_TURBO.getName())){
            //"gpt-3.5-turbo" in model:
            log.warn("Warning: gpt-3.5-turbo may update over time. Returning num tokens assuming gpt-3.5-turbo-0613.");
            tokensPerMessage = 3;
            tokensPerName = 1;
        }else if(modelName.contains(ChatCompletion.Model.GPT_4.getName())){
            log.warn("Warning: gpt-4 may update over time. Returning num tokens assuming gpt-4-0613.");
            tokensPerMessage = 3;
            tokensPerName = 1;
        }else {
            log.warn(" Not supported model {}. See https://github.com/openai/openai-python/blob/main/chatml.md  More information .",modelName);
        }
        int sum = 0;
        for (Message msg : messages) {
            sum += tokensPerMessage;
            sum += tokens(encoding, msg.getContent());
            sum += tokens(encoding, msg.getRole());
            sum += tokens(encoding, msg.getName());
            FunctionCall functionCall = msg.getFunctionCall();
            sum += Objects.isNull(functionCall) ? 0 : tokens(encoding, functionCall.toString());
            if (StrUtil.isNotBlank(msg.getName())) {
                sum += tokensPerName;
            }
        }
        sum += 3;
        return sum;
    }

    

    public static String decode(@NotNull String modelName, @NotNull List<Integer> encoded) {
        Encoding enc = getEncoding(modelName);
        return enc.decode(encoded);
    }


    

    public static ModelType getModelTypeByName(String name) {
        if (
//                ChatCompletion.Model.GPT_3_5_TURBO_0301.getName().equals(name) ||
                        ChatCompletion.Model.GPT_3_5_TURBO_0613.getName().equals(name) ||
                        ChatCompletion.Model.GPT_3_5_TURBO_16K.getName().equals(name) ||
                        ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName().equals(name)
        ) {
            return ModelType.GPT_3_5_TURBO;
        }
        if (ChatCompletion.Model.GPT_4.getName().equals(name)
                || ChatCompletion.Model.GPT_4_32K.getName().equals(name)
//                || ChatCompletion.Model.GPT_4_32K_0314.getName().equals(name)
//                || ChatCompletion.Model.GPT_4_0314.getName().equals(name)
                || ChatCompletion.Model.GPT_4_0613.getName().equals(name)
                || ChatCompletion.Model.GPT_4_32K_0613.getName().equals(name)
        ) {
            return ModelType.GPT_4;
        }

        for (ModelType modelType : ModelType.values()) {
            if (modelType.getName().equals(name)) {
                return modelType;
            }
        }
        log.warn("[{}] The model does not exist or does not currently support computation tokens", name);
        return null;
    }
}

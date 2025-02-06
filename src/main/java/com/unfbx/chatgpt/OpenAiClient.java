package com.unfbx.chatgpt;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import cn.hutool.json.JSONUtil;
import com.unfbx.chatgpt.constant.OpenAIConst;
import com.unfbx.chatgpt.entity.Tts.TextToSpeech;
import com.unfbx.chatgpt.entity.assistant.*;
import com.unfbx.chatgpt.entity.assistant.message.MessageFileResponse;
import com.unfbx.chatgpt.entity.assistant.message.MessageResponse;
import com.unfbx.chatgpt.entity.assistant.message.ModifyMessage;
import com.unfbx.chatgpt.entity.assistant.run.*;
import com.unfbx.chatgpt.entity.assistant.thread.ThreadMessage;
import com.unfbx.chatgpt.entity.billing.BillingUsage;
import com.unfbx.chatgpt.entity.billing.CreditGrantsResponse;
import com.unfbx.chatgpt.entity.billing.Subscription;
import com.unfbx.chatgpt.entity.chat.*;
import com.unfbx.chatgpt.entity.common.DeleteResponse;
import com.unfbx.chatgpt.entity.common.OpenAiResponse;
import com.unfbx.chatgpt.entity.common.PageRequest;
import com.unfbx.chatgpt.entity.completions.Completion;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import com.unfbx.chatgpt.entity.edits.Edit;
import com.unfbx.chatgpt.entity.edits.EditResponse;
import com.unfbx.chatgpt.entity.embeddings.Embedding;
import com.unfbx.chatgpt.entity.embeddings.EmbeddingResponse;
import com.unfbx.chatgpt.entity.engines.Engine;
import com.unfbx.chatgpt.entity.files.File;
import com.unfbx.chatgpt.entity.files.UploadFileResponse;
import com.unfbx.chatgpt.entity.fineTune.Event;
import com.unfbx.chatgpt.entity.fineTune.FineTune;
import com.unfbx.chatgpt.entity.fineTune.FineTuneDeleteResponse;
import com.unfbx.chatgpt.entity.fineTune.FineTuneResponse;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJob;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJobEvent;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJobListResponse;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJobResponse;
import com.unfbx.chatgpt.entity.images.*;
import com.unfbx.chatgpt.entity.images.Image;
import com.unfbx.chatgpt.entity.models.Model;
import com.unfbx.chatgpt.entity.models.ModelResponse;
import com.unfbx.chatgpt.entity.moderations.Moderation;
import com.unfbx.chatgpt.entity.moderations.ModerationResponse;
import com.unfbx.chatgpt.entity.assistant.thread.ModifyThread;
import com.unfbx.chatgpt.entity.assistant.thread.Thread;
import com.unfbx.chatgpt.entity.assistant.thread.ThreadResponse;
import com.unfbx.chatgpt.entity.whisper.Transcriptions;
import com.unfbx.chatgpt.entity.whisper.Translations;
import com.unfbx.chatgpt.entity.whisper.WhisperResponse;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import com.unfbx.chatgpt.function.KeyRandomStrategy;
import com.unfbx.chatgpt.function.KeyStrategyFunction;
import com.unfbx.chatgpt.interceptor.DynamicKeyOpenAiAuthInterceptor;
import com.unfbx.chatgpt.interceptor.OpenAiAuthInterceptor;
import com.unfbx.chatgpt.interceptor.DefaultOpenAiAuthInterceptor;
import com.unfbx.chatgpt.plugin.PluginAbstract;
import com.unfbx.chatgpt.plugin.PluginParam;
import io.reactivex.Single;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;





@Slf4j
public class OpenAiClient {
    

    @Getter
    @NotNull
    private List<String> apiKey;
    

    @Getter
    private String apiHost;
    @Getter
    private OpenAiApi openAiApi;
    

    @Getter
    private OkHttpClient okHttpClient;
    

    @Getter
    private KeyStrategyFunction<List<String>, String> keyStrategy;

    

    @Getter
    private OpenAiAuthInterceptor authInterceptor;

    

    @Getter
    private PageRequest pageRequest = PageRequest.builder().build();

    

    public static Builder builder() {
        return new Builder();
    }

    

    private OpenAiClient(Builder builder) {
        if (CollectionUtil.isEmpty(builder.apiKey)) {
            throw new BaseException(CommonError.API_KEYS_NOT_NUL);
        }
        apiKey = builder.apiKey;

        if (StrUtil.isBlank(builder.apiHost)) {
            builder.apiHost = OpenAIConst.OPENAI_HOST;
        }
        apiHost = builder.apiHost;

        if (Objects.isNull(builder.keyStrategy)) {
            builder.keyStrategy = new KeyRandomStrategy();
        }
        keyStrategy = builder.keyStrategy;

        if (Objects.isNull(builder.authInterceptor)) {
            builder.authInterceptor = new DefaultOpenAiAuthInterceptor();
        }
        authInterceptor = builder.authInterceptor;
        authInterceptor.setApiKey(this.apiKey);
        authInterceptor.setKeyStrategy(this.keyStrategy);

        if (Objects.isNull(builder.okHttpClient)) {
            builder.okHttpClient = this.okHttpClient();
        } else {
            // Customized okhttpClient   Need to increase api keys
            builder.okHttpClient = builder.okHttpClient
                    .newBuilder()
                    .addInterceptor(authInterceptor)
                    .build();
        }
        okHttpClient = builder.okHttpClient;
        this.openAiApi = new Retrofit.Builder()
                .baseUrl(apiHost)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(OpenAiApi.class);
    }


    

    private OkHttpClient okHttpClient() {
        if (Objects.isNull(this.authInterceptor)) {
            this.authInterceptor = new DefaultOpenAiAuthInterceptor();
        }
        this.authInterceptor.setApiKey(this.apiKey);
        this.authInterceptor.setKeyStrategy(this.keyStrategy);
        return new OkHttpClient
                .Builder()
                .addInterceptor(this.authInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
    }

    

    public List<Model> models() {
        Single<ModelResponse> models = this.openAiApi.models();
        return models.blockingGet().getData();
    }

    

    public Model model(String id) {
        if (Objects.isNull(id) || "".equals(id)) {
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        Single<Model> model = this.openAiApi.model(id);
        return model.blockingGet();
    }


    

    public CompletionResponse completions(Completion completion) {
        Single<CompletionResponse> completions = this.openAiApi.completions(completion);
        return completions.blockingGet();
    }

    

    public CompletionResponse completions(String question) {
        Completion q = Completion.builder()
                .prompt(question)
                .build();
        Single<CompletionResponse> completions = this.openAiApi.completions(q);
        return completions.blockingGet();
    }

    

    @Deprecated
    public EditResponse edit(Edit edit) {
        Single<EditResponse> edits = this.openAiApi.edits(edit);
        return edits.blockingGet();
    }

    

    public ImageResponse genImages(String prompt) {
        Image image = Image.builder().prompt(prompt).build();
        return this.genImages(image);
    }

    

    public ImageResponse genImages(Image image) {
        Single<ImageResponse> edits = this.openAiApi.genImages(image);
        return edits.blockingGet();
    }

    

    public List<Item> editImages(java.io.File image, String prompt) {
        ImageEdit imageEdit = ImageEdit.builder().prompt(prompt).build();
        return this.editImages(image, null, imageEdit);
    }

    

    public List<Item> editImages(java.io.File image, ImageEdit imageEdit) {
        return this.editImages(image, null, imageEdit);
    }

    

    public List<Item> editImages(java.io.File image, java.io.File mask, ImageEdit imageEdit) {
        checkImage(image);
        checkImageFormat(image);
        checkImageSize(image);
        if (Objects.nonNull(mask)) {
            checkImageFormat(image);
            checkImageSize(image);
        }
        //  establish  RequestBody， Used for encapsulating and constructing RequestBody
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), image);
        MultipartBody.Part imageMultipartBody = MultipartBody.Part.createFormData("image", image.getName(), imageBody);
        MultipartBody.Part maskMultipartBody = null;
        if (Objects.nonNull(mask)) {
            RequestBody maskBody = RequestBody.create(MediaType.parse("multipart/form-data"), mask);
            maskMultipartBody = MultipartBody.Part.createFormData("mask", image.getName(), maskBody);
        }
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        requestBodyMap.put("prompt", RequestBody.create(MediaType.parse("multipart/form-data"), imageEdit.getPrompt()));
        requestBodyMap.put("n", RequestBody.create(MediaType.parse("multipart/form-data"), imageEdit.getN().toString()));
        requestBodyMap.put("size", RequestBody.create(MediaType.parse("multipart/form-data"), imageEdit.getSize()));
        requestBodyMap.put("response_format", RequestBody.create(MediaType.parse("multipart/form-data"), imageEdit.getResponseFormat()));
        if (!(Objects.isNull(imageEdit.getUser()) || "".equals(imageEdit.getUser()))) {
            requestBodyMap.put("user", RequestBody.create(MediaType.parse("multipart/form-data"), imageEdit.getUser()));
        }
        Single<ImageResponse> imageResponse = this.openAiApi.editImages(
                imageMultipartBody,
                maskMultipartBody,
                requestBodyMap
        );
        return imageResponse.blockingGet().getData();
    }

    

    public ImageResponse variationsImages(java.io.File image, ImageVariations imageVariations) {
        checkImage(image);
        checkImageFormat(image);
        checkImageSize(image);
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), image);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("image", image.getName(), imageBody);
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        requestBodyMap.put("n", RequestBody.create(MediaType.parse("multipart/form-data"), imageVariations.getN().toString()));
        requestBodyMap.put("size", RequestBody.create(MediaType.parse("multipart/form-data"), imageVariations.getSize()));
        requestBodyMap.put("response_format", RequestBody.create(MediaType.parse("multipart/form-data"), imageVariations.getResponseFormat()));
        if (!(Objects.isNull(imageVariations.getUser()) || "".equals(imageVariations.getUser()))) {
            requestBodyMap.put("user", RequestBody.create(MediaType.parse("multipart/form-data"), imageVariations.getUser()));
        }
        Single<ImageResponse> variationsImages = this.openAiApi.variationsImages(
                multipartBody,
                requestBodyMap
        );
        return variationsImages.blockingGet();
    }

    

    public ImageResponse variationsImages(java.io.File image) {
        checkImage(image);
        checkImageFormat(image);
        checkImageSize(image);
        ImageVariations imageVariations = ImageVariations.builder().build();
        return this.variationsImages(image, imageVariations);
    }

    

    private void checkImage(java.io.File image) {
        if (Objects.isNull(image)) {
            log.error("image Cannot be empty ");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
    }

    

    private void checkImageFormat(java.io.File image) {
        if (!(image.getName().endsWith("png") || image.getName().endsWith("PNG"))) {
            log.error("image Format error ");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
    }

    

    private void checkImageSize(java.io.File image) {
        if (image.length() > 4 * 1024 * 1024) {
            log.error("image Maximum support 4MB");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
    }

    

    public EmbeddingResponse embeddings(String input) {
        List<String> inputs = new ArrayList<>(1);
        inputs.add(input);
        Embedding embedding = Embedding.builder().input(inputs).build();
        return this.embeddings(embedding);
    }

    

    public EmbeddingResponse embeddings(List<String> input) {
        Embedding embedding = Embedding.builder().input(input).build();
        return this.embeddings(embedding);
    }

    

    public EmbeddingResponse embeddings(Embedding embedding) {
        Single<EmbeddingResponse> embeddings = this.openAiApi.embeddings(embedding);
        return embeddings.blockingGet();
    }

    

    public List<File> files() {
        Single<OpenAiResponse<File>> files = this.openAiApi.files();
        return files.blockingGet().getData();
    }

    

    public DeleteResponse deleteFile(String fileId) {
        Single<DeleteResponse> deleteFile = this.openAiApi.deleteFile(fileId);
        return deleteFile.blockingGet();
    }

    

    public UploadFileResponse uploadFile(String purpose, java.io.File file) {
        //  establish  RequestBody， Used for encapsulating and constructing RequestBody
        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file", file.getName(), fileBody);

        RequestBody purposeBody = RequestBody.create(MediaType.parse("multipart/form-data"), purpose);
        Single<UploadFileResponse> uploadFileResponse = this.openAiApi.uploadFile(multipartBody, purposeBody);
        return uploadFileResponse.blockingGet();
    }

    

    public UploadFileResponse uploadFile(java.io.File file) {
        //purpose  The default example on the official website is : fine-tune
        return this.uploadFile("fine-tune", file);
    }

    

    public File retrieveFile(String fileId) {
        Single<File> fileContent = this.openAiApi.retrieveFile(fileId);
        return fileContent.blockingGet();
    }

    

//    public ResponseBody retrieveFileContent(String fileId) {
//        Single<ResponseBody> fileContent = this.openAiApi.retrieveFileContent(fileId);
//        return fileContent.blockingGet();
//    }

    

    public ModerationResponse moderations(String input) {
        List<String> content = new ArrayList<>(1);
        content.add(input);
        Moderation moderation = Moderation.builder().input(content).build();
        return this.moderations(moderation);
    }

    

    public ModerationResponse moderations(List<String> input) {
        Moderation moderation = Moderation.builder().input(input).build();
        return this.moderations(moderation);
    }

    

    public ModerationResponse moderations(Moderation moderation) {
        Single<ModerationResponse> moderations = this.openAiApi.moderations(moderation);
        return moderations.blockingGet();
    }

    

    @Deprecated
    public FineTuneResponse fineTune(FineTune fineTune) {
        Single<FineTuneResponse> fineTuneResponse = this.openAiApi.fineTune(fineTune);
        return fineTuneResponse.blockingGet();
    }

    

    @Deprecated
    public FineTuneResponse fineTune(String trainingFileId) {
        FineTune fineTune = FineTune.builder().trainingFile(trainingFileId).build();
        return this.fineTune(fineTune);
    }

    

    @Deprecated
    public List<FineTuneResponse> fineTunes() {
        Single<OpenAiResponse<FineTuneResponse>> fineTunes = this.openAiApi.fineTunes();
        return fineTunes.blockingGet().getData();
    }

    

    @Deprecated
    public FineTuneResponse retrieveFineTune(String fineTuneId) {
        Single<FineTuneResponse> fineTune = this.openAiApi.retrieveFineTune(fineTuneId);
        return fineTune.blockingGet();
    }

    

    @Deprecated
    public FineTuneResponse cancelFineTune(String fineTuneId) {
        Single<FineTuneResponse> fineTune = this.openAiApi.cancelFineTune(fineTuneId);
        return fineTune.blockingGet();
    }

    

    @Deprecated
    public List<Event> fineTuneEvents(String fineTuneId) {
        Single<OpenAiResponse<Event>> events = this.openAiApi.fineTuneEvents(fineTuneId);
        return events.blockingGet().getData();
    }

    

    public FineTuneDeleteResponse deleteFineTuneModel(String model) {
        Single<FineTuneDeleteResponse> delete = this.openAiApi.deleteFineTuneModel(model);
        return delete.blockingGet();
    }


    

    @Deprecated
    public List<Engine> engines() {
        Single<OpenAiResponse<Engine>> engines = this.openAiApi.engines();
        return engines.blockingGet().getData();
    }

    

    @Deprecated
    public Engine engine(String engineId) {
        Single<Engine> engine = this.openAiApi.engine(engineId);
        return engine.blockingGet();
    }

    

    public <T extends BaseChatCompletion> ChatCompletionResponse chatCompletion(T chatCompletion) {
        if (chatCompletion instanceof ChatCompletion) {
            Single<ChatCompletionResponse> chatCompletionResponse = this.openAiApi.chatCompletion((ChatCompletion) chatCompletion);
            return chatCompletionResponse.blockingGet();
        }
        Single<ChatCompletionResponse> chatCompletionResponse = this.openAiApi.chatCompletionWithPicture((ChatCompletionWithPicture) chatCompletion);
        return chatCompletionResponse.blockingGet();
    }

    

    public ChatCompletionResponse chatCompletion(List<Message> messages) {
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(messages).build();
        return this.chatCompletion(chatCompletion);
    }

    

    public <R extends PluginParam, T> ChatCompletionResponse chatCompletionWithPlugin(ChatCompletion chatCompletion, PluginAbstract<R, T> plugin) {
        if (Objects.isNull(plugin)) {
            return this.chatCompletion(chatCompletion);
        }
        if (CollectionUtil.isEmpty(chatCompletion.getMessages())) {
            throw new BaseException(CommonError.MESSAGE_NOT_NUL);
        }
        List<Message> messages = chatCompletion.getMessages();
        Functions functions = Functions.builder()
                .name(plugin.getFunction())
                .description(plugin.getDescription())
                .parameters(plugin.getParameters())
                .build();
        // No value ， Set default values 
        if (Objects.isNull(chatCompletion.getFunctionCall())) {
            chatCompletion.setFunctionCall("auto");
        }
        //tip:  Overwrite your own settings functions parameter ， use plugin Constructed functions
        chatCompletion.setFunctions(Collections.singletonList(functions));
        // call OpenAi
        ChatCompletionResponse functionCallChatCompletionResponse = this.chatCompletion(chatCompletion);
        ChatChoice chatChoice = functionCallChatCompletionResponse.getChoices().get(0);
        log.debug(" Method value of construction : {}", chatChoice.getMessage().getFunctionCall());

        R realFunctionParam = (R) JSONUtil.toBean(chatChoice.getMessage().getFunctionCall().getArguments(), plugin.getR());
        T tq = plugin.func(realFunctionParam);

        FunctionCall functionCall = FunctionCall.builder()
                .arguments(chatChoice.getMessage().getFunctionCall().getArguments())
                .name(plugin.getFunction())
                .build();
        messages.add(Message.builder().role(Message.Role.ASSISTANT).content("function_call").functionCall(functionCall).build());
        messages.add(Message.builder().role(Message.Role.FUNCTION).name(plugin.getFunction()).content(plugin.content(tq)).build());
        // Set up the second time ， Parameters requested 
        chatCompletion.setFunctionCall(null);
        chatCompletion.setFunctions(null);

        ChatCompletionResponse chatCompletionResponse = this.chatCompletion(chatCompletion);
        log.debug(" Custom methods return values : {}", chatCompletionResponse.getChoices());
        return chatCompletionResponse;
    }

    

    public <R extends PluginParam, T> ChatCompletionResponse chatCompletionWithPlugin(List<Message> messages, PluginAbstract<R, T> plugin) {
        return chatCompletionWithPlugin(messages, ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName(), plugin);
    }


    

    public <R extends PluginParam, T> ChatCompletionResponse chatCompletionWithPlugin(List<Message> messages, String model, PluginAbstract<R, T> plugin) {
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(messages).model(model).build();
        return this.chatCompletionWithPlugin(chatCompletion, plugin);
    }


    

    public WhisperResponse speechToTextTranscriptions(java.io.File file, Transcriptions transcriptions) {
        // file 
        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file", file.getName(), fileBody);
        // Custom Parameters 
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        if (StrUtil.isNotBlank(transcriptions.getLanguage())) {
            requestBodyMap.put(Transcriptions.Fields.language, RequestBody.create(MediaType.parse("multipart/form-data"), transcriptions.getLanguage()));
        }
        if (StrUtil.isNotBlank(transcriptions.getModel())) {
            requestBodyMap.put(Transcriptions.Fields.model, RequestBody.create(MediaType.parse("multipart/form-data"), transcriptions.getModel()));
        }
        if (StrUtil.isNotBlank(transcriptions.getPrompt())) {
            requestBodyMap.put(Transcriptions.Fields.prompt, RequestBody.create(MediaType.parse("multipart/form-data"), transcriptions.getPrompt()));
        }
        if (StrUtil.isNotBlank(transcriptions.getResponseFormat())) {
            requestBodyMap.put(Transcriptions.Fields.responseFormat, RequestBody.create(MediaType.parse("multipart/form-data"), transcriptions.getResponseFormat()));
        }
        if (Objects.nonNull(transcriptions.getTemperature())) {
            requestBodyMap.put(Transcriptions.Fields.temperature, RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(transcriptions.getTemperature())));
        }
        Single<WhisperResponse> whisperResponse = this.openAiApi.speechToTextTranscriptions(multipartBody, requestBodyMap);
        return whisperResponse.blockingGet();
    }

    

    public WhisperResponse speechToTextTranscriptions(java.io.File file) {
        Transcriptions transcriptions = Transcriptions.builder().build();
        return this.speechToTextTranscriptions(file, transcriptions);

    }


    

    public WhisperResponse speechToTextTranslations(java.io.File file, Translations translations) {
        // file 
        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file", file.getName(), fileBody);
        // Custom Parameters 
        Map<String, RequestBody> requestBodyMap = new HashMap<>(5, 1L);

        if (StrUtil.isNotBlank(translations.getModel())) {
            requestBodyMap.put(Translations.Fields.model, RequestBody.create(MediaType.parse("multipart/form-data"), translations.getModel()));
        }
        if (StrUtil.isNotBlank(translations.getPrompt())) {
            requestBodyMap.put(Translations.Fields.prompt, RequestBody.create(MediaType.parse("multipart/form-data"), translations.getPrompt()));
        }
        if (StrUtil.isNotBlank(translations.getResponseFormat())) {
            requestBodyMap.put(Translations.Fields.responseFormat, RequestBody.create(MediaType.parse("multipart/form-data"), translations.getResponseFormat()));
        }
        requestBodyMap.put(Translations.Fields.temperature, RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(translations.getTemperature())));
        Single<WhisperResponse> whisperResponse = this.openAiApi.speechToTextTranslations(multipartBody, requestBodyMap);
        return whisperResponse.blockingGet();
    }

    

    public WhisperResponse speechToTextTranslations(java.io.File file) {
        Translations translations = Translations.builder().build();
        return this.speechToTextTranslations(file, translations);
    }

    

    private void checkSpeechFileSize(java.io.File file) {
        if (file.length() > 25 * 1204 * 1024) {
            log.warn(" Official document tips :  The file cannot exceed 25MB");
        }
    }

    

    @Deprecated
    public CreditGrantsResponse creditGrants() {
        Single<CreditGrantsResponse> creditGrants = this.openAiApi.creditGrants();
        return creditGrants.blockingGet();
    }

    

    public Subscription subscription() {
        Single<Subscription> subscription = this.openAiApi.subscription();
        return subscription.blockingGet();
    }

    

    public BillingUsage billingUsage(@NotNull LocalDate starDate, @NotNull LocalDate endDate) {
        Single<BillingUsage> billingUsage = this.openAiApi.billingUsage(starDate, endDate);
        return billingUsage.blockingGet();
    }

    

    public FineTuneJobResponse fineTuneJob(FineTuneJob fineTuneJob) {
        Single<FineTuneJobResponse> fineTuneJobResponse = this.openAiApi.fineTuneJob(fineTuneJob);
        return fineTuneJobResponse.blockingGet();
    }

    

    public FineTuneJobResponse fineTuneJob(String trainingFileId) {
        FineTuneJob fineTuneJob = FineTuneJob.builder()
                .model(FineTuneJob.Model.GPT_3_5_TURBO_1106.getName())
                .trainingFile(trainingFileId)
                .build();
        return this.fineTuneJob(fineTuneJob);
    }

    

    public FineTuneJobListResponse<FineTuneJobResponse> fineTuneJobs(String after, Integer limit) {
        Single<FineTuneJobListResponse<FineTuneJobResponse>> fineTuneJobs = this.openAiApi.fineTuneJobs(after, limit);
        return fineTuneJobs.blockingGet();
    }

    

    public FineTuneJobResponse retrieveFineTuneJob(String fineTuneJobId) {
        Single<FineTuneJobResponse> fineTuneJob = this.openAiApi.retrieveFineTuneJob(fineTuneJobId);
        return fineTuneJob.blockingGet();
    }

    

    public FineTuneJobResponse cancelFineTuneJob(String fineTuneJobId) {
        Single<FineTuneJobResponse> fineTuneJob = this.openAiApi.cancelFineTuneJob(fineTuneJobId);
        return fineTuneJob.blockingGet();
    }

    

    public FineTuneJobListResponse<FineTuneJobEvent> fineTuneJobEvents(String fineTuneJobId, String after, Integer limit) {
        Single<FineTuneJobListResponse<FineTuneJobEvent>> events = this.openAiApi.fineTuneJobEvents(fineTuneJobId, after, limit);
        return events.blockingGet();
    }

    

    public void textToSpeech(TextToSpeech textToSpeech, Callback callback) {
        Call<ResponseBody> responseBody = this.openAiApi.textToSpeech(textToSpeech);
        responseBody.enqueue(callback);
    }

    

    public ResponseBody textToSpeech(TextToSpeech textToSpeech) throws IOException {
        Call<ResponseBody> responseBody = this.openAiApi.textToSpeech(textToSpeech);
        return responseBody.execute().body();
    }

    

    public AssistantResponse assistant(Assistant assistant) {
        Single<AssistantResponse> assistantResponse = this.openAiApi.assistant(assistant);
        return assistantResponse.blockingGet();
    }

    

    public AssistantResponse retrieveAssistant(String assistantId) {
        Single<AssistantResponse> assistant = this.openAiApi.retrieveAssistant(assistantId);
        return assistant.blockingGet();
    }


    

    public AssistantResponse modifyAssistant(String assistantId, Assistant assistant) {
        Single<AssistantResponse> assistantResponse = this.openAiApi.modifyAssistant(assistantId, assistant);
        return assistantResponse.blockingGet();
    }

    

    public DeleteResponse deleteAssistant(String assistantId) {
        Single<DeleteResponse> deleteAssistant = this.openAiApi.deleteAssistant(assistantId);
        return deleteAssistant.blockingGet();
    }

    

    public AssistantListResponse<AssistantResponse> assistants(PageRequest pageRequest) {
        Single<AssistantListResponse<AssistantResponse>> assistants = this.openAiApi.assistants(pageRequest.getLimit(), pageRequest.getOrder(), pageRequest.getBefore(), pageRequest.getAfter());
        return assistants.blockingGet();
    }

    

    public AssistantFileResponse assistantFile(String assistantId, AssistantFile assistantFile) {
        Single<AssistantFileResponse> assistantFileResponse = this.openAiApi.assistantFile(assistantId, assistantFile);
        return assistantFileResponse.blockingGet();
    }

    

    public AssistantFileResponse retrieveAssistantFile(String assistantId, String fileId) {
        Single<AssistantFileResponse> assistantFileResponse = this.openAiApi.retrieveAssistantFile(assistantId, fileId);
        return assistantFileResponse.blockingGet();
    }

    

    public DeleteResponse deleteAssistantFile(String assistantId, String fileId) {
        Single<DeleteResponse> deleteResponse = this.openAiApi.deleteAssistantFile(assistantId, fileId);
        return deleteResponse.blockingGet();
    }

    

    public AssistantListResponse<AssistantFileResponse> assistantFiles(String assistantId, PageRequest pageRequest) {
        pageRequest = Optional.ofNullable(pageRequest).orElse(this.getPageRequest());
        Single<AssistantListResponse<AssistantFileResponse>> deleteResponse = this.openAiApi.assistantFiles(assistantId, pageRequest.getLimit(), pageRequest.getOrder(), pageRequest.getBefore(), pageRequest.getAfter());
        return deleteResponse.blockingGet();
    }

    

    public ThreadResponse thread(Thread thread) {
        return this.openAiApi.thread(thread).blockingGet();
    }

    

    public ThreadResponse retrieveThread(String threadId) {
        return this.openAiApi.retrieveThread(threadId).blockingGet();
    }

    

    public ThreadResponse modifyThread(String threadId, ModifyThread thread) {
        return this.openAiApi.modifyThread(threadId, thread).blockingGet();
    }

    

    public DeleteResponse deleteThread(String threadId) {
        return this.openAiApi.deleteThread(threadId).blockingGet();
    }

    

    public MessageResponse message(String threadId, ThreadMessage message) {
        return this.openAiApi.message(threadId, message).blockingGet();
    }

    

    public MessageResponse retrieveMessage(String threadId, String messageId) {
        return this.openAiApi.retrieveMessage(threadId, messageId).blockingGet();
    }

    

    public MessageResponse modifyMessage(String threadId, String messageId, ModifyMessage message) {
        return this.openAiApi.modifyMessage(threadId, messageId, message).blockingGet();
    }

    

    public AssistantListResponse<MessageResponse> messages(String threadId, PageRequest pageRequest) {
        pageRequest = Optional.ofNullable(pageRequest).orElse(this.getPageRequest());
        return this.openAiApi.messages(threadId,
                pageRequest.getLimit(),
                pageRequest.getOrder(),
                pageRequest.getBefore(),
                pageRequest.getAfter()).blockingGet();
    }

    

    public MessageFileResponse retrieveMessageFile(String threadId, String messageId, String fileId) {
        return this.openAiApi.retrieveMessageFile(threadId, messageId, fileId).blockingGet();
    }

    

    public AssistantListResponse<MessageFileResponse> messageFiles(String threadId, String messageId, PageRequest pageRequest) {
        pageRequest = Optional.ofNullable(pageRequest).orElse(this.getPageRequest());
        return this.openAiApi.messageFiles(threadId, messageId,
                pageRequest.getLimit(),
                pageRequest.getOrder(),
                pageRequest.getBefore(),
                pageRequest.getAfter()).blockingGet();
    }


    

    public RunResponse run(String threadId, Run run) {
        return this.openAiApi.run(threadId, run).blockingGet();
    }


    

    public RunResponse retrieveRun(String threadId, String runId) {
        return this.openAiApi.retrieveRun(threadId, runId).blockingGet();
    }

    

    public RunResponse modifyRun(String threadId, String runId, ModifyRun run) {
        return this.openAiApi.modifyRun(threadId, runId, run).blockingGet();
    }


    

    public AssistantListResponse<RunResponse> runs(String threadId, PageRequest pageRequest) {
        pageRequest = Optional.ofNullable(pageRequest).orElse(this.getPageRequest());
        return this.openAiApi.runs(threadId,
                pageRequest.getLimit(),
                pageRequest.getOrder(),
                pageRequest.getBefore(),
                pageRequest.getAfter()).blockingGet();
    }


    

    public RunResponse submitToolOutputs(String threadId, String runId, ToolOutputBody toolOutputs) {
        return this.openAiApi.submitToolOutputs(threadId, runId, toolOutputs).blockingGet();
    }


    

    public RunResponse cancelRun(String threadId, String runId) {
        return this.openAiApi.cancelRun(threadId, runId).blockingGet();
    }


    

    public RunResponse threadRun(ThreadRun threadRun) {
        return this.openAiApi.threadRun(threadRun).blockingGet();
    }

    

    public RunStepResponse retrieveRunStep(String threadId, String runId, String stepId) {
        if (StrUtil.isBlank(stepId)) {
            log.error("step id Cannot be empty ");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        return this.openAiApi.retrieveRunStep(threadId, runId, stepId).blockingGet();
    }


    

    public AssistantListResponse<RunStepResponse> runSteps(String threadId, String runId, PageRequest pageRequest) {
        pageRequest = Optional.ofNullable(pageRequest).orElse(this.getPageRequest());
        return this.openAiApi.runSteps(threadId, runId,
                pageRequest.getLimit(),
                pageRequest.getOrder(),
                pageRequest.getBefore(),
                pageRequest.getAfter()).blockingGet();
    }


    public static final class Builder {
        

        private @NotNull List<String> apiKey;
        

        private String apiHost;
        

        private OkHttpClient okHttpClient;

        

        private KeyStrategyFunction keyStrategy;

        

        private OpenAiAuthInterceptor authInterceptor;

        public Builder() {
        }

        

        public Builder apiHost(String val) {
            apiHost = val;
            return this;
        }

        public Builder apiKey(@NotNull List<String> val) {
            apiKey = val;
            return this;
        }

        public Builder keyStrategy(KeyStrategyFunction val) {
            keyStrategy = val;
            return this;
        }

        public Builder okHttpClient(OkHttpClient val) {
            okHttpClient = val;
            return this;
        }

        public Builder authInterceptor(OpenAiAuthInterceptor val) {
            authInterceptor = val;
            return this;
        }

        public OpenAiClient build() {
            return new OpenAiClient(this);
        }
    }
}

package com.unfbx.chatgpt;

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
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.ChatCompletionWithPicture;
import com.unfbx.chatgpt.entity.common.OpenAiResponse;
import com.unfbx.chatgpt.entity.completions.Completion;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import com.unfbx.chatgpt.entity.edits.Edit;
import com.unfbx.chatgpt.entity.edits.EditResponse;
import com.unfbx.chatgpt.entity.embeddings.Embedding;
import com.unfbx.chatgpt.entity.embeddings.EmbeddingResponse;
import com.unfbx.chatgpt.entity.engines.Engine;
import com.unfbx.chatgpt.entity.files.File;
import com.unfbx.chatgpt.entity.common.DeleteResponse;
import com.unfbx.chatgpt.entity.files.UploadFileResponse;
import com.unfbx.chatgpt.entity.fineTune.Event;
import com.unfbx.chatgpt.entity.fineTune.FineTune;
import com.unfbx.chatgpt.entity.fineTune.FineTuneDeleteResponse;
import com.unfbx.chatgpt.entity.fineTune.FineTuneResponse;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJob;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJobEvent;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJobListResponse;
import com.unfbx.chatgpt.entity.fineTune.job.FineTuneJobResponse;
import com.unfbx.chatgpt.entity.images.Image;
import com.unfbx.chatgpt.entity.images.ImageResponse;
import com.unfbx.chatgpt.entity.models.Model;
import com.unfbx.chatgpt.entity.models.ModelResponse;
import com.unfbx.chatgpt.entity.moderations.Moderation;
import com.unfbx.chatgpt.entity.moderations.ModerationResponse;
import com.unfbx.chatgpt.entity.assistant.thread.ModifyThread;
import com.unfbx.chatgpt.entity.assistant.thread.Thread;
import com.unfbx.chatgpt.entity.assistant.thread.ThreadResponse;
import com.unfbx.chatgpt.entity.whisper.WhisperResponse;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.time.LocalDate;
import java.util.Map;



public interface OpenAiApi {

    

    @GET("v1/models")
    Single<ModelResponse> models();

    

    @GET("v1/models/{id}")
    Single<Model> model(@Path("id") String id);

    

    @POST("v1/completions")
    Single<CompletionResponse> completions(@Body Completion completion);

    

    @Deprecated
    @POST("v1/edits")
    Single<EditResponse> edits(@Body Edit edit);

    

    @POST("v1/images/generations")
    Single<ImageResponse> genImages(@Body Image image);

    

    @Multipart
    @POST("v1/images/edits")
    Single<ImageResponse> editImages(@Part() MultipartBody.Part image,
                                     @Part() MultipartBody.Part mask,
                                     @PartMap() Map<String, RequestBody> requestBodyMap
    );

    

    @Multipart
    @POST("v1/images/variations")
    Single<ImageResponse> variationsImages(@Part() MultipartBody.Part image,
                                           @PartMap() Map<String, RequestBody> requestBodyMap
    );

    

    @POST("v1/embeddings")
    Single<EmbeddingResponse> embeddings(@Body Embedding embedding);


    

    @GET("v1/files")
    Single<OpenAiResponse<File>> files();

    

    @DELETE("v1/files/{file_id}")
    Single<DeleteResponse> deleteFile(@Path("file_id") String fileId);

    

    @Multipart
    @POST("v1/files")
    Single<UploadFileResponse> uploadFile(@Part MultipartBody.Part file,
                                          @Part("purpose") RequestBody purpose);


    

    @GET("v1/files/{file_id}")
    Single<File> retrieveFile(@Path("file_id") String fileId);

    

    @Streaming
    @GET("v1/files/{file_id}/content")
    Single<ResponseBody> retrieveFileContent(@Path("file_id") String fileId);


    

    @POST("v1/moderations")
    Single<ModerationResponse> moderations(@Body Moderation moderation);


    

    @Deprecated
    @POST("v1/fine-tunes")
    Single<FineTuneResponse> fineTune(@Body FineTune fineTune);

    

    @Deprecated
    @GET("v1/fine-tunes")
    Single<OpenAiResponse<FineTuneResponse>> fineTunes();


    

    @Deprecated
    @GET("v1/fine-tunes/{fine_tune_id}")
    Single<FineTuneResponse> retrieveFineTune(@Path("fine_tune_id") String fineTuneId);

    

    @Deprecated
    @POST("v1/fine-tunes/{fine_tune_id}/cancel")
    Single<FineTuneResponse> cancelFineTune(@Path("fine_tune_id") String fineTuneId);

    

    @Deprecated
    @GET("v1/fine-tunes/{fine_tune_id}/events")
    Single<OpenAiResponse<Event>> fineTuneEvents(@Path("fine_tune_id") String fineTuneId);

    

    @DELETE("v1/models/{model}")
    Single<FineTuneDeleteResponse> deleteFineTuneModel(@Path("model") String model);


    

    @Deprecated
    @GET("v1/engines")
    Single<OpenAiResponse<Engine>> engines();

    

    @Deprecated
    @GET("v1/engines/{engine_id}")
    Single<Engine> engine(@Path("engine_id") String engineId);


    

    @POST("v1/chat/completions")
    Single<ChatCompletionResponse> chatCompletion(@Body ChatCompletion chatCompletion);

    

    @POST("v1/chat/completions")
    Single<ChatCompletionResponse> chatCompletionWithPicture(@Body ChatCompletionWithPicture chatCompletion);

    

    @Multipart
    @POST("v1/audio/transcriptions")
    Single<WhisperResponse> speechToTextTranscriptions(@Part MultipartBody.Part file,
                                                       @PartMap() Map<String, RequestBody> requestBodyMap);

    

    @Multipart
    @POST("v1/audio/translations")
    Single<WhisperResponse> speechToTextTranslations(@Part MultipartBody.Part file,
                                                     @PartMap() Map<String, RequestBody> requestBodyMap);

    

    @GET("dashboard/billing/credit_grants")
    @Deprecated
    Single<CreditGrantsResponse> creditGrants();

    

    @GET("v1/dashboard/billing/subscription")
    Single<Subscription> subscription();

    

    @GET("v1/dashboard/billing/usage")
    Single<BillingUsage> billingUsage(@Query("start_date") LocalDate starDate, @Query("end_date") LocalDate endDate);

    

    @POST("v1/audio/speech")
    @Streaming
    Call<ResponseBody> textToSpeech(@Body TextToSpeech textToSpeech);


    

    @POST("v1/fine_tuning/jobs")
    Single<FineTuneJobResponse> fineTuneJob(@Body FineTuneJob fineTuneJob);

    

    @GET("v1/fine_tuning/jobs")
    Single<FineTuneJobListResponse<FineTuneJobResponse>> fineTuneJobs(@Query("after") String after, @Query("limit") Integer limit);


    

    @GET("v1/fine_tuning/jobs/{fine_tuning_job_id}")
    Single<FineTuneJobResponse> retrieveFineTuneJob(@Path("fine_tuning_job_id") String fineTuneJobId);

    

    @POST("v1/fine_tuning/jobs/{fine_tuning_job_id}/cancel")
    Single<FineTuneJobResponse> cancelFineTuneJob(@Path("fine_tuning_job_id") String fineTuneJobId);

    

    @GET("v1/fine_tuning/jobs/{fine_tuning_job_id}/events")
    Single<FineTuneJobListResponse<FineTuneJobEvent>> fineTuneJobEvents(@Path("fine_tuning_job_id") String fineTuneJobId, @Query("after") String after, @Query("limit") Integer limit);


    

    @POST("v1/assistants")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantResponse> assistant(@Body Assistant assistant);


    

    @GET("v1/assistants/{assistant_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantResponse> retrieveAssistant(@Path("assistant_id") String assistantId);

    

    @POST("v1/assistants/{assistant_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantResponse> modifyAssistant(@Path("assistant_id") String assistantId, @Body Assistant assistant);

    

    @DELETE("v1/assistants/{assistant_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<DeleteResponse> deleteAssistant(@Path("assistant_id") String assistantId);


    

    @GET("v1/assistants")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantListResponse<AssistantResponse>> assistants(@Query("limit") Integer limit, @Query("order") String order, @Query("before") String before, @Query("after") String after);

    

    @POST("v1/assistants/{assistant_id}/files")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantFileResponse> assistantFile(@Path("assistant_id") String assistantId, @Body AssistantFile assistantFile);

    

    @GET("v1/assistants/{assistant_id}/files/{file_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantFileResponse> retrieveAssistantFile(@Path("assistant_id") String assistantId, @Path("file_id") String fileId);

    

    @DELETE("v1/assistants/{assistant_id}/files/{file_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<DeleteResponse> deleteAssistantFile(@Path("assistant_id") String assistantId, @Path("file_id") String fileId);

    

    @GET("v1/assistants/{assistant_id}/files")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantListResponse<AssistantFileResponse>> assistantFiles(@Path("assistant_id") String assistantId,
                                                                        @Query("limit") Integer limit, @Query("order") String order, @Query("before") String before, @Query("after") String after);


    

    @POST("v1/threads")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<ThreadResponse> thread(@Body Thread thread);


    

    @GET("v1/threads/{thread_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<ThreadResponse> retrieveThread(@Path("thread_id") String threadId);

    

    @POST("v1/threads/{thread_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<ThreadResponse> modifyThread(@Path("thread_id") String threadId, @Body ModifyThread thread);

    

    @DELETE("v1/threads/{thread_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<DeleteResponse> deleteThread(@Path("thread_id") String threadId);

    

    @POST("v1/threads/{thread_id}/messages")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<MessageResponse> message(@Path("thread_id") String threadId, @Body ThreadMessage message);

    

    @GET("v1/threads/{thread_id}/messages/{message_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<MessageResponse> retrieveMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId);

    

    @POST("v1/threads/{thread_id}/messages/{message_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<MessageResponse> modifyMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId, @Body ModifyMessage message);

    

    @GET("v1/threads/{thread_id}/messages")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantListResponse<MessageResponse>> messages(@Path("thread_id") String threadId,
                                                            @Query("limit") Integer limit, @Query("order") String order, @Query("before") String before, @Query("after") String after);

    

    @GET("v1/threads/{thread_id}/messages/{message_id}/files/{file_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<MessageFileResponse> retrieveMessageFile(@Path("thread_id") String threadId, @Path("message_id") String messageId, @Path("file_id") String fileId);

    

    @GET("v1/threads/{thread_id}/messages/{message_id}/files")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantListResponse<MessageFileResponse>> messageFiles(@Path("thread_id") String threadId, @Path("message_id") String messageId,
                                                                @Query("limit") Integer limit, @Query("order") String order, @Query("before") String before, @Query("after") String after);


    

    @POST("v1/threads/{thread_id}/runs")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunResponse> run(@Path("thread_id") String threadId, @Body Run run);


    

    @GET("v1/threads/{thread_id}/runs/{run_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunResponse> retrieveRun(@Path("thread_id") String threadId, @Path("run_id") String runId);

    

    @POST("v1/threads/{thread_id}/runs/{run_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunResponse> modifyRun(@Path("thread_id") String threadId, @Path("run_id") String runId, @Body ModifyRun run);


    

    @GET("v1/threads/{thread_id}/runs")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantListResponse<RunResponse>> runs(@Path("thread_id") String threadId,
                                                    @Query("limit") Integer limit, @Query("order") String order, @Query("before") String before, @Query("after") String after);


    

    @POST("v1/threads/{thread_id}/runs/{run_id}/submit_tool_outputs")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunResponse> submitToolOutputs(@Path("thread_id") String threadId, @Path("run_id") String runId, @Body ToolOutputBody toolOutputs);


    

    @POST("v1/threads/{thread_id}/runs/{run_id}/cancel")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunResponse> cancelRun(@Path("thread_id") String threadId, @Path("run_id") String runId);


    

    @POST("v1/threads/runs")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunResponse> threadRun(@Body ThreadRun threadRun);

    

    @GET("v1/threads/{thread_id}/runs/{run_id}/steps/{step_id}")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<RunStepResponse> retrieveRunStep(@Path("thread_id") String threadId, @Path("run_id") String runId, @Path("step_id") String stepId);


    

    @GET("v1/threads/{thread_id}/runs/{run_id}/steps")
    @Headers("OpenAI-Beta: assistants=v1")
    Single<AssistantListResponse<RunStepResponse>> runSteps(@Path("thread_id") String threadId, @Path("run_id") String runId,
                                                            @Query("limit") Integer limit, @Query("order") String order, @Query("before") String before, @Query("after") String after);

}

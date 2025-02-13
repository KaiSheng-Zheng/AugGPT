package com.unfbx.chatgpt.entity.fineTune;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class FineTune implements Serializable {



    @NonNull
    @JsonProperty("training_file")
    private String trainingFile;

    @JsonProperty("validation_file")
    private String validationFile;


    private String model;

    @JsonProperty("n_epochs")
    @Builder.Default
    private Integer n_epochs = 4;

    @JsonProperty("batch_size")
    private Integer batchSize;

    @JsonProperty("learning_rate_multiplier")
    private Double learningRateMultiplier;

    @JsonProperty("prompt_loss_weight")
    @Builder.Default
    private Double promptLossWeight = 0.01;

    @JsonProperty("compute_classification_metrics")
    @Builder.Default
    private boolean computeClassificationMetrics = false;

    @JsonProperty("classification_n_classes")
    private Integer classificationNClasses;

    @JsonProperty("classification_betas")
    private List classificationBetas;

    private String suffix;

    public void setTrainingFile(String trainingFile) {
        this.trainingFile = trainingFile;
    }

    public void setValidationFile(String validationFile) {
        this.validationFile = validationFile;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setN_epochs(Integer n_epochs) {
        this.n_epochs = n_epochs;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public void setLearningRateMultiplier(Double learningRateMultiplier) {
        this.learningRateMultiplier = learningRateMultiplier;
    }

    public void setPromptLossWeight(Double promptLossWeight) {
        this.promptLossWeight = promptLossWeight;
    }

    public void setComputeClassificationMetrics(boolean computeClassificationMetrics) {
        this.computeClassificationMetrics = computeClassificationMetrics;
    }

    public void setClassificationNClasses(Integer classificationNClasses) {
        this.classificationNClasses = classificationNClasses;
    }

    public void setClassificationBetas(List classificationBetas) {
        this.classificationBetas = classificationBetas;
    }

    public void setSuffix(String suffix) {
        if(Objects.nonNull(suffix) && !"".equals(suffix) && suffix.length() > 40){
            log.error(" The suffix length cannot be greater than 40");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        this.suffix = suffix;
    }

    @Getter
    @AllArgsConstructor
    public enum Model {
        // or a fine-tuned model created after .
        ADA("ada"),
        BABBAGE("babbage"),
        CURIE("curie"),
        DAVINCI("davinci"),
        ;
        private final String name;
    }
}

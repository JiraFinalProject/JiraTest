package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueRequest {
    private Fields fields;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Fields {
        private CustomField project;
        private CustomField issuetype;
        private CustomField priority;
        private String summary;
        @JsonProperty("customfield_10102")
        private String epicLink;
        @JsonProperty("customfield_10104")
        private String epicName;
    }

    @Data
    @Builder
    public static class CustomField {
        private String id;
    }

}

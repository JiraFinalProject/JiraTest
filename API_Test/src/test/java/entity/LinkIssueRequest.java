package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkIssueRequest {
    private Type type;
    private Issue inwardIssue;
    private Issue outwardIssue;
    @Data
    @Builder
    public static class Type {
        private String id;
        private String name;
    }
    @Data
    @Builder
    public static class Issue {
        private String key;
    }
}

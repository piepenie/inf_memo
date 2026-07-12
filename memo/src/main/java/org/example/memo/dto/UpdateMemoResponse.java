package org.example.memo.dto;

import java.time.LocalDateTime;

public class UpdateMemoResponse {
    private final long id;
    private final String name;
    private final String context;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UpdateMemoResponse(long id, String name, String context, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.context = context;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

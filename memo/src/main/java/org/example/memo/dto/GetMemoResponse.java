package org.example.memo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetMemoResponse {
    private final long id;
    private final String name;
    private final String context;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetMemoResponse(long id, String name, String context, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.context = context;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

package org.example.memo.dto;

import lombok.Getter;

@Getter
public class UpdateMemoRequest {
    private String name;
    private String context;
}

package org.example.memo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "memos2")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;

    // 255 제한 풀기위해서 컬럼 설정을 TEXT 타입으로 만듬.
    @Column(columnDefinition = "TEXT")
    private String context;

    public Memo(String name, String context) {
        this.name = name;
        this.context = context;
    }

    public void update(String name, String context) {
        this.name = name;
        this.context = context;
    }
}

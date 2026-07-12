package org.example.memo.service;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.*;
import org.example.memo.entity.Memo;
import org.example.memo.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public CreateMemoResponse save(CreateMemoRequest request) {
        Memo memo = new Memo(
                request.getName(),
                request.getContext()
        );
        Memo saveMemo = memoRepository.save(memo);
        return new CreateMemoResponse(
                saveMemo.getId(),
                saveMemo.getName(),
                saveMemo.getContext(),
                saveMemo.getCreatedAt(),
                saveMemo.getModifiedAt()

        );
    }

    @Transactional(readOnly = true)
    public List<GetMemoResponse> getALL() {
        List<Memo> memos = memoRepository.findAll();
        List<GetMemoResponse> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            GetMemoResponse dto = new GetMemoResponse(
                    memo.getId(),
                    memo.getName(),
                    memo.getContext(),
                    memo.getCreatedAt(),
                    memo.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetMemoResponse getOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 유저입니다.")
        );
        return new GetMemoResponse(
                memo.getId(),
                memo.getName(),
                memo.getContext(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional
    public UpdateMemoResponse update(Long memoId, UpdateMemoRequest request) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 유저입니다.")
        );
        memo.update(
                request.getName(),
                request.getContext()
        );
        return new UpdateMemoResponse(
                memo.getId(),
                memo.getName(),
                memo.getContext(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long memoId) {
        boolean existence = memoRepository.existsById(memoId);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }

        memoRepository.deleteById(memoId);
    }

}

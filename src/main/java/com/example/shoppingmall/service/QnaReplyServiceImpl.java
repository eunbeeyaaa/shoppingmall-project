package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Qna;
import com.example.shoppingmall.entity.QnaReply;
import com.example.shoppingmall.repository.QnaReplyRepository;
import com.example.shoppingmall.repository.QnaRepository;
import com.example.shoppingmall.request.QnaReplyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {

    private final QnaReplyRepository qnaReplyRepository;
    private final QnaRepository qnaRepository;

    @Autowired
    public QnaReplyServiceImpl(QnaReplyRepository qnaReplyRepository, QnaRepository qnaRepository) {
        this.qnaReplyRepository = qnaReplyRepository;
        this.qnaRepository = qnaRepository;
    }

    @Override
    public List<QnaReply> getRepliesByQna(Long qnaId) {
        return qnaReplyRepository.findByQnaId(qnaId);
    }

    @Override
    public void saveReply(QnaReplyRequest request) {
        Qna qna = qnaRepository.findById(request.getQnaId())
                .orElseThrow(() -> new NoSuchElementException("문의 없음!"));

        QnaReply reply = new QnaReply();
        reply.setContent(request.getContent());
        reply.setCreatedAt(LocalDateTime.now());
        reply.setQna(qna);

        qnaReplyRepository.save(reply);
    }
}

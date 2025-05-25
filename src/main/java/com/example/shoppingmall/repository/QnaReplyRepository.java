package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.QnaReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnaReplyRepository extends JpaRepository<QnaReply, Long> {
    List<QnaReply> findByQnaId(Long qnaId);
}
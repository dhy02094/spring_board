package com.th.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.th.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
    List<Board> findByTitleContaining(String keyword);
}

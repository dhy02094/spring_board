package com.th.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.th.board.dto.BoardDto;
import com.th.board.entity.Board;
import com.th.board.repository.BoardRepository;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardlist() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                                .id(board.getId())
                                .title(board.getTitle())
                                .content(board.getContent())
                                .writer(board.getWriter())
                                .createdDate(board.getCreatedDate())
                                .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id) {
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                            .id(board.getId())
                            .title(board.getTitle())
                            .content(board.getContent())
                            .writer(board.getWriter())
                            .createdDate(board.getCreatedDate())
                            .build();
        
        return boardDto;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
    
}

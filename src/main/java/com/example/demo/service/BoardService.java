package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void write(Board board) {
		boardRepository.save(board);
	}
	
	public List<Board> boardList() {
		return boardRepository.findAll();
	}
}

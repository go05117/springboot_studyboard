package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;



@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")
	public String boardwriteForm() {
		return "boardwrite";
	}
	
	@PostMapping("/board/writepro")
	public String boardWritePro(Board board) {
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("내용 : " + board.getContent());
		
		boardService.write(board);
		
		return "";
	}
}

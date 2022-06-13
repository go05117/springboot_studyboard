package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		
		boardService.write(board);
		
		return "";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		System.out.println("테스트1");
		model.addAttribute("list", boardService.boardList());
		return "boardlist";
	}
	
	@GetMapping("/board/view")	// localhost:80/board/view?id=1
	public String boardView(Model model, Integer id) {
		model.addAttribute("board", boardService.boardView(id));
		return "boardview";
	}
}

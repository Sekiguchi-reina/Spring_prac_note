package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;
	
	@GetMapping("/vnote")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("notes", noteRepository.findAll());
		modelAndView.addObject("note",new Note());
		modelAndView.setViewName("vnote");
		return modelAndView;
	}
	
	@PostMapping("/notes")
	public String saveNote(@ModelAttribute Note note) {
		noteRepository.save(note);
		return "redirect:/vnote";
	}
	
//	public ResponseEntity<String> saveNote(@RequestBody Note note){
//		try {
//			noteRepository.save(note);
//			return ResponseEntity.ok("Note saved successfully");
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save note:" + e.getMessage());
//		}
//	}
}

package com.piGL.controllor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piGL.entity.Comment;
import com.piGL.exception.RessourceNotFoundException;
import com.piGL.service.CommentService;


@RestController
@RequestMapping("/comment")
public class CommentControllor {

	
	@Autowired
	CommentService commentService ;

	@GetMapping("/all")
	public List<Comment> getAllComment() {
		return commentService.getAllComment();
	}

	@GetMapping("/{idComment}")
	public ResponseEntity<Comment> getCommentById( @PathVariable (value = "idComment") Long idComment) throws RessourceNotFoundException {
		return commentService.getCommentById(idComment);
	}

	
	@DeleteMapping("/delete/{idComment}")
	public Map<String, Boolean> delateComment(@PathVariable (value = "idComment") Long idComment) throws RessourceNotFoundException {
		return commentService.delateComment(idComment);
	}

	@PostMapping("/ajouter")
	
	public ResponseEntity<Comment> addComment(@RequestBody Comment c) {
		return commentService.addComment(c);
	}

	@GetMapping("/allbydescrpition/{description}")
	public List<Comment> getCommentByDescription(String description) {
		return commentService.getCommentByDescription(description);
	}

	@PutMapping("/update")
	public Comment updateComment(Comment comment) {
		return commentService.updateComment(comment);
	}
	
	


	}


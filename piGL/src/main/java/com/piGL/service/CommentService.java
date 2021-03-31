package com.piGL.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.piGL.entity.Annoce;
import com.piGL.entity.Comment;
import com.piGL.exception.RessourceNotFoundException;
import com.piGL.repository.AnnoceRepository;
import com.piGL.repository.CommentRepository;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository ; 
	
	@Autowired
	AnnoceRepository annoceReository ;
	
	//get All Comment
		public List <Comment> getAllComment(){
			System.out.print("Get all Comment");
			
			List<Comment> comments = new ArrayList<Comment>();
			commentRepository.findAll().forEach(comments ::add);
			return comments;
			}
		//getComment par id 
		public ResponseEntity<Comment> getCommentById(Long idComment) throws RessourceNotFoundException {
			Comment Comment = commentRepository.findById(idComment).
					orElseThrow(()-> new RessourceNotFoundException("Comment not found"));
		 return ResponseEntity.ok().body(Comment);
		}
		//ajouter Comment
		public Comment saveComment(Comment Comment) {
			return this.commentRepository.save(Comment);
		}
		
		
		//delete Comment
		public Map<String,Boolean > delateComment (Long idComment) throws RessourceNotFoundException {
			Comment Comment = commentRepository.findById(idComment).
					orElseThrow(()-> new RessourceNotFoundException("Comment not found"));
				
			commentRepository.delete(Comment);
			Map<String , Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		//modifier Article 
		
		/*public ResponseEntity<Comment> updateComment(Long id,Comment Comment) {
			System.out.print("Update Comment");
			
			 Optional<Comment> CommentInfo = commentRepository.findById(id);
			 
			 if(CommentInfo.isPresent()) {
				 Comment comment = CommentInfo.get();
				 comment.setDescription(Comment.getDescription());
				 comment.setRef(Comment.getRef());
				 comment.setAnnoce(Comment.getAnnoce());
				 comment.setReply(Comment.getReply());
				 
				 
			
				 return new ResponseEntity<>(commentRepository.save(Comment),HttpStatus.OK);
			 }else 
			 {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
	
		}*/
		
		/* public Comment createComment(Long annoceId,
			       Comment comment) throws com.projet.pi.exception.RessourceNotFoundException {
			        return commentRepository.findByAnnoceId(annoceId).map(post -> {
			            Annoce annoce = null;
						comment.setAnnoce(annoce);
			            return commentRepository.save(comment);
			        }).orElseThrow(() -> new com.projet.pi.exception.RessourceNotFoundException("annoceId " + annoceId + " not found"));
		 }*/
		
		public ResponseEntity<Comment> addComment(Comment c) {
			
			Optional<Annoce> annoce = annoceReository.findById(c.getAnnoce().getId());
			System.out.println(c.getAnnoce().getId());
			if(annoce.isPresent()) {
				c.setAnnoce(annoce.get());
				
				commentRepository.save(c);
				
				return new ResponseEntity<Comment>(c, HttpStatus.OK);
			}
				
			return new ResponseEntity<Comment>(c, HttpStatus.NOT_FOUND);
		}
		 
		 
		///fct recuper Annoce par addresse
		public List<Comment> getCommentByDescription(String description) {
			return commentRepository.findByDescription(description);
		}
		
		// update Comment
		public Comment updateComment(Comment comment) {
			if (comment.getId() != 0) {
				Comment com = commentRepository.findById(comment.getId()).get();
				if (com != null) {
					commentRepository.save(comment);
				}
			}
			return comment;
		}



}

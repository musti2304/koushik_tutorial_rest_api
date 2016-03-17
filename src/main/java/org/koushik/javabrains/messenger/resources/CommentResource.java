package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageID") long messageID) {
		return commentService.getAllComments(messageID);
	}

	@POST
	public Comment addMessage(@PathParam("messageID") long messageID, Comment comment) {
		return commentService.addComment(messageID, comment);
	}

	@PUT
	@Path("/{commentID}")
	public Comment updateMessage(@PathParam("messageID") long messageID, @PathParam("commentID") long commentID,
			Comment comment) {
		comment.setId(commentID);
		return commentService.updateComment(messageID, comment);
	}

	@DELETE
	@Path("/{commentID}")
	public void deleteComment(@PathParam("messageID") long messageId, @PathParam("commentID") long commentId) {
		commentService.removeComment(messageId, commentId);
	}

	@GET
	@Path("/{commentID}")
	public Comment getMessage(@PathParam("messageID") long messageId, @PathParam("commentID") long commentId) {
		return commentService.getComment(messageId, commentId);
	}

}
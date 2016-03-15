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
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}

	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}

	// @GET
	// public String test() {
	// return "new sub resource";
	// }
	//
	//
	// @GET
	// @Path("/{commentID}")
	// public String test2(@PathParam("messageID") long messageID,
	// @PathParam("commentID") long commentID) {
	// return "Method to return comment ID: " + commentID + " for message " +
	// messageID;
	//
	// }
	//
}
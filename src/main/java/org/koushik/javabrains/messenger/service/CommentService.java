package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(long messageId) {
		//TODO
		return null;
	}

	public Comment getComment(long messageId, long commentId) {
		//TODO
		return null;
	}

	public Comment addComment(long messageId, Comment comment) {
		//TODO
		return null;
	}

	public Comment updateComment(long messageId, Comment comment) {
		//TODO
		return null;
	}

	public Comment removeComment(long messageId, long commentId) {
		//TODO
		return null;
	}
}

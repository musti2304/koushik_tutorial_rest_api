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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private  MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if(year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if(start >= 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") long id) {
		return messageService.getMessage(id);
	}

	@POST
	public Message addMessage(Message message) {	
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
	public void deleteMessage(@PathParam("messageID") long id) {
		messageService.removeMessage(id);
	}
	
}
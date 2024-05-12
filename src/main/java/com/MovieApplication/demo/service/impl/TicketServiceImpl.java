package com.MovieApplication.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApplication.demo.entity.Ticket;
import com.MovieApplication.demo.repository.TicketRepository;
import com.MovieApplication.demo.service.TicketService;

import jakarta.transaction.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepo;

	@Override
	public List<Ticket> getAllTickets(int mid) {
		List<Ticket> ticketlist = ticketRepo.getTicketList(mid);
		return ticketlist;
	}

	@Override
	public List<Ticket> getAllMovieTickets() {
		List<Ticket> ticketlist = ticketRepo.findAll();
		if (ticketlist != null && ticketlist.size() > 0) {
			return ticketlist;
		}
		return null;
	}

	@Override
	public boolean addTicket(Ticket ticket) {
		Ticket ticketObj = new Ticket();

		ticketObj.setNo_of_tickets(ticket.getNo_of_tickets());
		ticketObj.setMovie_id_fk(ticket.getMovie_id_fk());
		ticketObj.setUser_name_fk(ticket.getUser_name_fk());
		ticketObj.setTheatreName(ticket.getTheatreName());
		ticketObj.setIssueAt(ticket.getIssueAt());
		ticketObj.setShowTime(ticket.getShowTime());
		ticketObj.setTotalPrice(ticket.getTotalPrice());
		ticketRepo.save(ticketObj);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteTicket(int mid) {
	    int rowsDeleted = ticketRepo.deleteTicketData(mid);
	    return rowsDeleted > 0;
	}


	@Override
	public List<Ticket> getAllTicketsUser(String userName) {
		List<Ticket> ticketlist = ticketRepo.getTicketListUser(userName);
		return ticketlist;
	}

}

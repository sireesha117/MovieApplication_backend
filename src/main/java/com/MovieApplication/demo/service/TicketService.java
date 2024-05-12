package com.MovieApplication.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MovieApplication.demo.entity.Ticket;

@Service
public interface TicketService {
	public List<Ticket> getAllTickets(int mid);

	public List<Ticket> getAllTicketsUser(String userName);

	public List<Ticket> getAllMovieTickets();

	public boolean addTicket(Ticket ticket);

	public boolean deleteTicket(int mid);

}

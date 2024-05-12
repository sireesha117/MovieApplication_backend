package com.MovieApplication.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.MovieApplication.demo.entity.Ticket;
import com.MovieApplication.demo.service.impl.MovieServiceImpl;
import com.MovieApplication.demo.service.impl.TicketServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
public class TicketControllerTest {
	@Mock
	private TicketServiceImpl ticketService;
	@Mock
	private MovieServiceImpl movieService;

	@InjectMocks
	private TicketController ticketC;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(ticketC).build();
	}

	List<Ticket> ticketList = new ArrayList<Ticket>();

	@Test
	public void getAllTicketsSuccess() throws Exception {
		Ticket ticket = new Ticket();

		ticket.setMovie_id_fk(1);
		ticket.setUser_name_fk("John");
		ticket.setIssueAt("2024-03-28");
		ticket.setNo_of_tickets(2);
		ticket.setShowTime("09:30AM");
		ticket.setTotalPrice(200);

		ticketList.add(ticket);
		when(ticketService.getAllMovieTickets()).thenReturn(ticketList);

		List<Ticket> tList = ticketService.getAllMovieTickets();
		assertEquals(ticketList, tList);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ticket/alltickets").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void findTicketSuccess() throws Exception
	{
		when(ticketService.getAllTicketsUser(any())).thenReturn(ticketList);
		
		List<Ticket> tList = ticketService.getAllTicketsUser("John");
		assertEquals(ticketList, tList);
		
mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ticket/findticket/John").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
}

package com.MovieApplication.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MovieApplication.demo.entity.Ticket;
import com.MovieApplication.demo.repository.TicketRepository;
import com.MovieApplication.demo.service.impl.TicketServiceImpl;

public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTicketsSuccess() {
        Ticket ticket = new Ticket();
        ticket.setMovie_id_fk(1);
        //ticket.setUser_name_fk("John");
        ticket.setIssueAt("2024-03-28");
        ticket.setNo_of_tickets(2);
        ticket.setShowTime("09:30AM");
        ticket.setTotalPrice(200);

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        when(ticketRepository.findAll()).thenReturn(ticketList);

        List<Ticket> returnedTicketList = ticketService.getAllMovieTickets();
        assertEquals(ticketList, returnedTicketList);
    }

//    @Test
//    public void findTicketSuccess() {
//        Ticket ticket = new Ticket();
//        ticket.setMovie_id_fk(1);
//        //ticket.setUser_name_fk("John");
//        ticket.setIssueAt("2024-03-28");
//        ticket.setNo_of_tickets(2);
//        ticket.setShowTime("09:30AM");
//        ticket.setTotalPrice(200);
//
//        List<Ticket> ticketList = new ArrayList<>();
//        ticketList.add(ticket);
//
//        when(ticketRepository.getTicketListUser("John")).thenReturn(ticketList);
//
//        List<Ticket> returnedTicketList = ticketService.getAllTicketsUser("John");
//        assertEquals(ticketList, returnedTicketList);
//    }
}

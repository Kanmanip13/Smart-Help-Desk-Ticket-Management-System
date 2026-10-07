package com.helpdesk.dao;

import java.util.List;

import com.helpdesk.model.Ticket;

public interface TicketDAO {

    void createTicket(Ticket ticket);

    List<Ticket> viewTickets();

    List<Ticket> viewTicketsByUser(int userId);

    List<Ticket> viewTicketsCreatedByUser(int userId);

    void updateTicketStatus(int ticketId, String status);

    void deleteTicket(int ticketId);

    int getTotalTickets();

    void assignTicket(int ticketId, int assignedTo);
    
    boolean isTicketAssignedToUser(int ticketId, int userId);
    int getTicketsByStatus(String status);
}
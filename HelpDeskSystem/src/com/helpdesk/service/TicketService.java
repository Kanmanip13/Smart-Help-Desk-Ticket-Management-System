package com.helpdesk.service;

import java.util.List;
import java.util.ArrayList;

import com.helpdesk.dao.TicketDAO;
import com.helpdesk.dao.TicketDAOImpl;
import com.helpdesk.model.Ticket;

public class TicketService {

    private TicketDAO ticketDAO;

    public TicketService() {
        ticketDAO = new TicketDAOImpl();
    }

    public void createTicket(Ticket ticket) {

        if (ticket == null) {
            System.out.println("Ticket cannot be null");
            return;
        }

        if (ticket.getTitle() == null ||
            ticket.getTitle().trim().isEmpty()) {
            System.out.println("Ticket title cannot be empty");
            return;
        }

        if (ticket.getDescription() == null ||
            ticket.getDescription().trim().isEmpty()) {
            System.out.println("Ticket description cannot be empty");
            return;
        }

        if (ticket.getPriority() == null ||
            ticket.getPriority().trim().isEmpty()) {
            System.out.println("Ticket priority cannot be empty");
            return;
        }

        if (ticket.getStatus() == null ||
            ticket.getStatus().trim().isEmpty()) {
            System.out.println("Ticket status cannot be empty");
            return;
        }

        ticketDAO.createTicket(ticket);
    }

    public List<Ticket> viewTickets() {
        return ticketDAO.viewTickets();
    }

    public List<Ticket> viewTicketsByUser(int userId) {

        if (userId <= 0) {
            System.out.println("Invalid user ID");
            return new ArrayList<>();
        }

        return ticketDAO.viewTicketsByUser(userId);
    }

    public List<Ticket> viewTicketsCreatedByUser(int userId) {

        if (userId <= 0) {
            System.out.println("Invalid user ID");
            return new ArrayList<>();
        }

        return ticketDAO.viewTicketsCreatedByUser(userId);
    }

    public void updateTicketStatus(int ticketId, String status) {

        if (ticketId <= 0) {
            System.out.println("Invalid ticket ID");
            return;
        }

        if (status == null || status.trim().isEmpty()) {
            System.out.println("Status cannot be empty");
            return;
        }

        ticketDAO.updateTicketStatus(ticketId, status);
    }

    public void deleteTicket(int ticketId) {

        if (ticketId <= 0) {
            System.out.println("Invalid ticket ID");
            return;
        }

        ticketDAO.deleteTicket(ticketId);
    }

    public int getTotalTickets() {
        return ticketDAO.getTotalTickets();
    }

    public void assignTicket(int ticketId, int assignedTo) {

        if (ticketId <= 0) {
            System.out.println("Invalid ticket ID");
            return;
        }

        if (assignedTo <= 0) {
            System.out.println("Invalid user ID");
            return;
        }

        ticketDAO.assignTicket(ticketId, assignedTo);
    }
    public boolean isTicketAssignedToUser(int ticketId, int userId) {

        if (ticketId <= 0 || userId <= 0) {
            return false;
        }

        return ticketDAO.isTicketAssignedToUser(ticketId, userId);
    }
    public int getTicketsByStatus(String status) {

        if (status == null || status.trim().isEmpty()) {
            return 0;
        }

        return ticketDAO.getTicketsByStatus(status);
    }
}
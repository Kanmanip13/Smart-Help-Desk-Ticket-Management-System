package com.helpdesk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.helpdesk.model.Ticket;
import com.helpdesk.util.DBConnection;

public class TicketDAOImpl implements TicketDAO {

    // Create Ticket
    @Override
    public void createTicket(Ticket ticket) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO tickets "
                       + "(title, description, priority, status, assigned_to, created_by) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ticket.getTitle());
            ps.setString(2, ticket.getDescription());
            ps.setString(3, ticket.getPriority());
            ps.setString(4, ticket.getStatus());
            ps.setInt(5, ticket.getAssignedTo());
            ps.setInt(6, ticket.getCreatedBy());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Ticket Created Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // View All Tickets
    @Override
    public List<Ticket> viewTickets() {

        List<Ticket> tickets = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM tickets";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setPriority(rs.getString("priority"));
                ticket.setStatus(rs.getString("status"));
                ticket.setAssignedTo(rs.getInt("assigned_to"));
                ticket.setCreatedBy(rs.getInt("created_by"));

                tickets.add(ticket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }


    // View Tickets Assigned to Agent
    @Override
    public List<Ticket> viewTicketsByUser(int userId) {

        List<Ticket> tickets = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM tickets WHERE assigned_to = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setPriority(rs.getString("priority"));
                ticket.setStatus(rs.getString("status"));
                ticket.setAssignedTo(rs.getInt("assigned_to"));
                ticket.setCreatedBy(rs.getInt("created_by"));

                tickets.add(ticket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }


    // View Tickets Created by User
    @Override
    public List<Ticket> viewTicketsCreatedByUser(int userId) {

        List<Ticket> tickets = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM tickets WHERE created_by = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setPriority(rs.getString("priority"));
                ticket.setStatus(rs.getString("status"));
                ticket.setAssignedTo(rs.getInt("assigned_to"));
                ticket.setCreatedBy(rs.getInt("created_by"));

                tickets.add(ticket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }


    // Update Ticket Status
    @Override
    public void updateTicketStatus(int ticketId, String status) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE tickets SET status = ? WHERE ticket_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, ticketId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Ticket Status Updated Successfully");
            } else {
                System.out.println("Ticket Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Delete Ticket
    @Override
    public void deleteTicket(int ticketId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM tickets WHERE ticket_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, ticketId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Ticket Deleted Successfully");
            } else {
                System.out.println("Ticket Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Get Total Tickets
    @Override
    public int getTotalTickets() {

        int count = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM tickets";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }


    // Assign Ticket to Agent
    @Override
    public void assignTicket(int ticketId, int assignedTo) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE tickets SET assigned_to = ? WHERE ticket_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, assignedTo);
            ps.setInt(2, ticketId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Ticket Assigned Successfully");
            } else {
                System.out.println("Ticket Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Check whether ticket is assigned to a particular user
    @Override
    public boolean isTicketAssignedToUser(int ticketId, int userId) {

        boolean assigned = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT ticket_id FROM tickets "
                       + "WHERE ticket_id = ? AND assigned_to = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, ticketId);
            ps.setInt(2, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                assigned = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return assigned;
    }
    @Override
    public int getTicketsByStatus(String status) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM tickets WHERE status = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
package com.school.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.project.model.TicketSale;
import com.school.project.model.Ticket;
import com.school.project.model.User;
import com.school.project.model.TicketCache;

public class TicketSaleDAO implements BaseDAO<TicketSale> {
	
	private static TicketSaleDAO instance;

	private TicketSaleDAO() {
	}

	public static TicketSaleDAO getInstance() {
		if (instance == null) {
			instance = new TicketSaleDAO();
		}
		return instance;
	}

	@Override
	public TicketSale getByResultSet(ResultSet res) throws SQLException {
		if (res == null) {
			return null;
		}
		int id = res.getInt("id");
		Date validFrom = res.getDate("validFrom");
		Date validTo = res.getDate("validTo");
		Date soldOn = res.getDate("soldOn");
		String from = res.getString("departureStation");
		String to = res.getString("arrivalStation");
		boolean archived = res.getBoolean("archived");
		Ticket ticket = TicketCache.getInstance().getTicket(res.getInt("ticketId"));
		User user = UserDAO.getInstance().get(res.getInt("soldByUser"));
		return new TicketSale(id, validFrom, validTo, soldOn, from, to, archived, ticket, user);
	}

	@Override
	public void add(TicketSale obj) {
		if (obj == null) {
			return;
		}

		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;

		try {
			String[] returnId = { "BATCHID" };
			stat = connection.prepareStatement(
					"INSERT INTO ticketSales (id, ticketId, soldByUser, validFrom, validTo, soldOn, departureStation, arrivalStation, archived) VALUES (null,?,?,?,?,?,?,?,?);",
					returnId);
			stat.setInt(1, obj.getTicket().getId());
			stat.setInt(2, obj.getUser().getId());
			stat.setDate(3, obj.getValidFrom());
			stat.setDate(4, obj.getValidTo());
			stat.setDate(5, obj.getSoldOn());
			stat.setString(6, obj.getFrom());
			stat.setString(7, obj.getTo());
			stat.setBoolean(8, obj.isArchived());
			stat.executeUpdate();

			ResultSet genKeys = null;
			try {
				genKeys = stat.getGeneratedKeys();
				if (genKeys.next()) {
					obj.setId(genKeys.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (genKeys != null) {
					genKeys.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<TicketSale> getAll() {
		List<TicketSale> lst = new ArrayList<TicketSale>();
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;

		try {
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM ticketSales WHERE archived = 0;");

			while (res.next()) {
				lst.add(getByResultSet(res));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lst;
	}

	@Override
	public TicketSale get(int id) {
		TicketSale ticketSale = null;
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;

		try {
			stat = connection.createStatement();
			res = stat.executeQuery("SELECT * FROM ticketSales WHERE id = " + id + ";");
			if (res.next()) {
				ticketSale = getByResultSet(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ticketSale;
	}

	@Override
	public void update(TicketSale obj) {
		if (obj == null || obj.getId() == -1)
			return;

		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;

		try {
			stat = connection.prepareStatement(
					"UPDATE ticketSales SET ticketId = ?, soldByUser = ?, validFrom = ?, validTo = ?, soldOn = ?, departureStation = ?, arrivalStation = ?, archived = ? WHERE id = ?;");
			stat.setInt(1, obj.getTicket().getId());
			stat.setInt(2, obj.getUser().getId());
			stat.setDate(3, obj.getValidFrom());
			stat.setDate(4, obj.getValidTo());
			stat.setDate(5, obj.getSoldOn());
			stat.setString(6, obj.getFrom());
			stat.setString(7, obj.getTo());
			stat.setBoolean(8, obj.isArchived());
			stat.setInt(9, obj.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(TicketSale obj) {
		if(obj == null || obj.getId() == -1){return;}
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;
		
		try{
			stat = connection.prepareStatement("UPDATE ticketSales SET archived = 1 WHERE id = ?");
			stat.setInt(1, obj.getId());
			stat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stat != null){stat.close();}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

}

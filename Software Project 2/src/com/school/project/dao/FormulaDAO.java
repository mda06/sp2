package com.school.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormulaDAO {
	private static FormulaDAO instance;

	private FormulaDAO() {
	}

	public static FormulaDAO getInstance() {
		if (instance == null) instance = new FormulaDAO();
		return instance;
	}

	private void archivedAllFormulas() {
		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;

		try {
			stat = connection.prepareStatement("UPDATE formulas SET archived = 1 WHERE archived = ?");
			stat.setInt(1, 0);
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

	public void setNewFormula(String str) {
		archivedAllFormulas();
		if (str == null) { return; }

		Connection connection = DatabaseHandler.getInstance().getConnection();
		PreparedStatement stat = null;

		try {
			stat = connection.prepareStatement("INSERT INTO formulas (id, formula, archived) VALUES (null,?,?);");
			stat.setString(1, str);
			stat.setBoolean(2, false);
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

	public String getlastFormula() {
		String formula = "";
		Connection connection = DatabaseHandler.getInstance().getConnection();
		Statement stat = null;
		ResultSet res = null;
		try {
			String sql = "SELECT formula FROM formulas where archived = 0";
			stat = connection.createStatement();
			res = stat.executeQuery(sql);
			while (res.next()) {
				formula = res.getString("formula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (res != null) res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return formula;
	}
}

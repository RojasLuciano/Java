package sumat.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sumat.test.BaseTest;

public class DB_SUMAT extends BaseTest {

	private final String url = "jdbc:postgresql://ecsdev04/simat_test";
	private final String user = "postgres";
	private final String password = "psql";
	protected Connection connect = null;

	public Connection connect() {
		try {
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println("Failed " + e.getMessage());
		}
		return connect;
	}

	public void close() {
		try {
			connect.close();
			System.out.println("Desconectado.");
		} catch (Exception e) {
		}
	}

	
	public Contribuyente GenerarUsuariosNoAsociados() {
		String tdoctpodoc = null;
		String condoc = null;
		String condigver = null;
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT\r\n" + "    tdoctpodoc,\r\n" + "    condoc,\r\n"
					+ "    condigver\r\n" + "FROM\r\n" + "    personas P,\r\n" + "    tdocide T\r\n" + "WHERE\r\n"
					+ "    T .tdoccod = contdoccod\r\n"
					+ "AND contpo = 'J' and conest='A' and condigver is not null\r\n" + "AND NOT EXISTS (\r\n"
					+ "    SELECT\r\n" + "        1\r\n" + "    FROM\r\n" + "        usuwebcontribuyente C\r\n"
					+ "    WHERE\r\n" + "        C .concod = P .concod\r\n" + ")\r\n" + "LIMIT 1");
			while (rs.next()) {
				tdoctpodoc = rs.getString("tdoctpodoc");
				condoc = rs.getString("condoc");
				condigver = rs.getString("condigver");
			}
		} catch (SQLException ex) {
			System.out.println("Error " + ex);
		}
		return new Contribuyente(tdoctpodoc, condoc, condigver);
	}
	
	
	
	
	public void GenerarUsuariosNoAsociados2() {
		String tdoctpodoc = null;
		String condoc = null;
		String condigver = null;
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT\r\n" + "    tdoctpodoc,\r\n" + "    condoc,\r\n"
					+ "    condigver\r\n" + "FROM\r\n" + "    personas P,\r\n" + "    tdocide T\r\n" + "WHERE\r\n"
					+ "    T .tdoccod = contdoccod\r\n"
					+ "AND contpo = 'J' and conest='A' and condigver is not null\r\n" + "AND NOT EXISTS (\r\n"
					+ "    SELECT\r\n" + "        1\r\n" + "    FROM\r\n" + "        usuwebcontribuyente C\r\n"
					+ "    WHERE\r\n" + "        C .concod = P .concod\r\n" + ")\r\n" + "LIMIT 1");
			while (rs.next()) {
				tdoctpodoc = rs.getString("tdoctpodoc");
				condoc = rs.getString("condoc");
				condigver = rs.getString("condigver");
			}
		} catch (SQLException ex) {
			System.out.println("Error " + ex);
		}
		System.out.println(tdoctpodoc+" "+condoc+" "+condigver);
	}
	
	
	
	
	
	
	
	
	
	

	public class Contribuyente {
		private String doc_tipo;
		private String doc_doc;
		private String doc_ver;

		public Contribuyente(String doctipo, String docdoc, String docver) {
			this.doc_tipo = doctipo;
			this.doc_doc = docdoc;
			this.doc_ver = docver;
		}

		public String getDoc_tipo() {
			return doc_tipo;
		}

		public void setDoc_tipo(String doc_tipo) {
			this.doc_tipo = doc_tipo;
		}

		public String getDoc_doc() {
			return doc_doc;
		}

		public void setDoc_doc(String doc_doc) {
			this.doc_doc = doc_doc;
		}

		public String getDoc_ver() {
			return doc_ver;
		}

		public void setDoc_ver(String doc_ver) {
			this.doc_ver = doc_ver;
		}

	}

}// final
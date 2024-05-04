package JDBCProjet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBCProjet.connexion.Connexion;
import JDBCProjet.dao.IDao;
import tp4jbdc.Client;

public class ClientService implements IDao<Client>{

	@Override
	public boolean create(Client c) {
		try {
		Connection conn =Connexion.getConn();
		Statement stmt = conn.createStatement();
		try {
			String query ="INSERT INTO CLIENT (nom,prenom) VALUES('"+ c.getNom()+"','"+c.getPrenom()+"')";
			int nbl = stmt.executeUpdate(query);
			return nbl>0;
		}
		catch(SQLException e){
			System.err.println("error creating sql statement"
					+e.getMessage());
			
		}
		}
		catch(SQLException e){
			System.err.println("error creating sql statement"
					+e.getMessage());
			
		}
		return false;
		}

	@Override
	public List<Client> findAll() {
		try {
			Connection conn =Connexion.getConn();
			Statement stmt = conn.createStatement();
		try {
			List<Client> l=new ArrayList<>();
			String query ="SELECT * FROM client";
			ResultSet rs =stmt.executeQuery(query);
		while(rs.next()) {
			l.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3)));
		}
		return l;
		}
		
			catch(SQLException e){
				System.err.println("error creating sql statement"
						+e.getMessage());
				return null;
				
			}
			}
			catch(SQLException e){
				System.err.println("error creating sql statement"
						+e.getMessage());
				return null;
				
			}
				
	}

	@Override
	public Client findById(int id) {
		try {
			Connection conn =Connexion.getConn();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM client where id=?");
			stmt.setInt(1, id);
			List<Client> l=new ArrayList<>();
			ResultSet rs =stmt.executeQuery();
			rs.next();
			return new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
			catch(SQLException e){
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public boolean delete(Client c) {
		try {
			Connection conn =Connexion.getConn();
			PreparedStatement stmt = conn.prepareStatement("delete FROM client where id=?");
			stmt.setInt(1, c.getId());
			stmt.executeUpdate();
			return true;
		}
			catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean update(Client c) {
		try {
			Connection conn =Connexion.getConn();
			PreparedStatement stmt = conn.prepareStatement("Update client set nom=? where id=?");
			stmt.setString(1, c.getNom());
			stmt.setInt(2, c.getId());
			stmt.executeUpdate();
			return true;
		}
			catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}

}

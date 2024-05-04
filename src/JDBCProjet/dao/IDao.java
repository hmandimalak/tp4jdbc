package JDBCProjet.dao;

import java.util.List;

public interface IDao <T>{
	boolean create ( T o); 
	List<T> findAll ( );
	T findById (int id);
	boolean delete (T o); 
	boolean update (T o); 
}

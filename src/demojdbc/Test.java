package demojdbc;

import java.util.ArrayList;
import java.util.List;

import JDBCProjet.connexion.Connexion;
import JDBCProjet.service.ClientService;
import tp4jbdc.Client;

public class Test {
	public static void main(String[]args)
	{
		Connexion.getConn();
		ClientService cs =new ClientService();
		cs.create(new Client("samir","benabdallah"));
		List <Client>l =cs.findAll();
		for(Client lc:l) {
			System.out.println(lc.toString());
		}
		Client c=cs.findById(2);
		System.out.println("hadha find by id"+c.toString());
		cs.delete(new Client(5,"sami","benabdallah"));
		cs.update(new Client(7,"ayda","hamdi"));
	}

}

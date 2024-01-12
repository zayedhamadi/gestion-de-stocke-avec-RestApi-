package Consumer;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import Entity.Product;
import com.sun.jersey.api.client.ClientResponse;

public class ClientMain {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Client c = Client.create(new DefaultClientConfig() );
		URI uri = UriBuilder.fromUri("http://localhost:8080/RestApiSOA_KRAHTHYETY/").build();
		
		ClientResponse respense = c.resource(uri).path("api").path("/products/listAll").get(ClientResponse.class);
		
		System.out.print("---------------------------------------------------------------\n");
		String corprep = respense.getEntity(String.class) ;
		System.out.println(corprep);
		ObjectMapper mapper=new ObjectMapper();
		Product[] tabprod=mapper.readValue(corprep, Product[].class);
		System.out.print("\n ---- Liste des noms des produits ---- \n");
		for(Product p:tabprod)
		{
			System.out.println(p.getNameProduct());
			System.out.print("\n");
		}
				
				
	}
	}




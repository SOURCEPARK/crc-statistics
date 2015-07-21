package de.sourcepark.crc.statistics;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author smatyba
 */
public class StatisticsClient {
    private String serverURL = "http://equinox:9999/control/listener/register/statistics";
    
    public void register() {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);
        
        final WebResource resource = client.resource(UriBuilder.fromUri(serverURL).build());
        MultivaluedMap formData = new MultivaluedMapImpl();
        formData.add("name1", "val1");
        
        ClientResponse response = resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class, formData);
        System.out.println("Response " + response.getEntity(String.class));
        
    }
}

package org.thwick.moneytracker.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
  
public class AccountClient {
	
	private final String uri;

	public static final String ACCOUNT_RESOURCE_PATH = "/accounts";
	
    private final Client client = Client.create();

    public AccountClient(String uri) {
    	this.uri = uri;
    }
    
    public WebResource resource() {
    	return client.resource(uri).path(ACCOUNT_RESOURCE_PATH);
    }
    
    public WebResource resource(String accountId) {
    	return resource().path("/" + accountId);
    }
}

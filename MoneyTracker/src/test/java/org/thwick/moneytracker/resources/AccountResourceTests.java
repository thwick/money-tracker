package org.thwick.moneytracker.resources;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.thwick.moneytracker.models.Account;
import org.thwick.moneytracker.services.AccountService;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class AccountResourceTests extends JerseyTest {

	public static AccountService accountServiceMock = mock(AccountService.class);
	 
	@Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder("org.thwick.moneytracker.resources")
            .contextParam("contextConfigLocation", "classpath:**/testContext.xml")
            .initParam("com.sun.jersey.api.json.POJOMappingFeature", "true")
            .servletClass(SpringServlet.class)
            .contextListenerClass(ContextLoaderListener.class)
            .requestListenerClass(RequestContextListener.class)
            .build();
    }
	
//	@Override
//    public WebAppDescriptor configure() {
//        return new WebAppDescriptor.Builder()
//            	.initParam(WebComponent.RESOURCE_CONFIG_CLASS,
//                      ClassNamesResourceConfig.class.getName())
//                .initParam(
//                      ClassNamesResourceConfig.PROPERTY_CLASSNAMES,
//                      AccountResource.class.getName() + ";"
//                              + MockAccountServiceProvider.class.getName()).build();
//    }
	
    @Test
    public void test() {
    	
    	Account account = new Account();
    	account.setAccountName("test account");
    	account.setId(1L);
    	account.setRetirement(true);
    	account.setDescription("description");
    	
    	List<Account> accounts = Lists.newArrayList();
    	accounts.add(account);
    	
    	when(accountServiceMock.findAll()).thenReturn(accounts);
    	
    	WebResource webResource = this.resource();
    	String responseMsg = webResource.path("/accounts").get(String.class);
    }
    
    
    @Provider
    public static class MockAccountServiceProvider extends
           SingletonTypeInjectableProvider<Context, AccountService> {
        public MockAccountServiceProvider() {
            super(AccountService.class, accountServiceMock);
        }
    }
    
//	public static final String PACKAGE_NAME = "org.resources";
//	private WebResource ws;
//
//	public AccountResourceTests() {
//		super(new WebAppDescriptor.Builder(PACKAGE_NAME).build());
//	}
//	
//	@Override
//    protected Application configure() {
//        return new ResourceConfig(AccountResource.class);
//    }
//	
//	@Override
//	protected TestContainerFactory getTestContainerFactory() {
//	return new InMemoryTestContainerFactory();
//
//	}
//	
//	@Test
//	public void testProductResponse() throws UnsupportedEncodingException {
//		ws = resource().path("product/kamal");
//		ClientResponse response = ws.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
//		assertEquals(200, response.getStatus());
//	}
//	
//	@Test
//	public void findAll() {
//		final String hello = target("accounts").request().get();
//        assertEquals("Hello World!", hello);
//	}
//	
//	
//	@Provider
//    public static class MockAccountServiceProvider extends
//           SingletonTypeInjectableProvider {
//        public MockAccountServiceProvider() {
//            super(AccountService.class, accountServiceMock);
//        }
//	}
}

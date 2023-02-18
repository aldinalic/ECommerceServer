package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;
import it.unitn.alic.ecommerceserver.entities.ProductEntity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

public class ClientTest {

    public static void main(String[] args) throws Exception {
        remoteEJB();
    }
    private static void remoteEJB() throws NamingException {

        final Facade facade = lookupFacade();
        System.out.println("OBTAINED THE FACADE FROM JNDI");

        // TESTING SINGLE CUSTOMER AVAILABILITY
        CustomerEntity customer = facade.getCustomer(1);
        System.out.println("THIS IS HIS USERNAME: " + customer.getUsername());

        // TESTING ALL PRODUCTS AVAILABILITY
        List<ProductEntity> productList = facade.getAllProducts();
        System.out.println("THESE ARE THE PRODUCTS: ");
        for (ProductEntity singleProduct : productList) {
            System.out.println(singleProduct.getName());
        }
    }

    private static Facade lookupFacade() throws NamingException {

        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8090");
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);

        try {
            final Context ctx = new InitialContext(jndiProperties);
            System.out.println("CREATED CONTEXT FOR FACADE WITH JNDI PROPERTIES");
            return (Facade) ctx.lookup("ejb:/ECommerceServer-1.0-SNAPSHOT/FacadeEJB!it.unitn.alic.ecommerceserver.ejb.Facade");
        } catch (NamingException n) {
            System.out.println("THIS IS NAMING EXCEPTION " + n.getMessage());
        }
        return null;
    }
}
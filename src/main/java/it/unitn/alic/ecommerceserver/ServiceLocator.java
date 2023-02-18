package it.unitn.alic.ecommerceserver;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.HashMap;

public class ServiceLocator {

    private static HashMap<String, Object> cache;

    static {
        cache = new HashMap<String, Object>();
    }

    public static Object getService(String jndiName) throws NamingException {
        Object service = cache.get(jndiName);

        if (service == null) {
            InitialContext ctx = new InitialContext();

            service = ctx.lookup(jndiName);
            cache.put(jndiName, service);
        }
        return service;
    }
}
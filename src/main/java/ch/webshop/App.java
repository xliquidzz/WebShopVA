package ch.webshop;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import ch.webshop.resource.FoodResource;
import ch.webshop.resource.DrinkResource;

public class App extends Application<WebShopConfiguration> {

	public void initialize(Bootstrap<WebShopConfiguration> bootstrap) {
		
	}

	public void run(WebShopConfiguration configuration, Environment environment)
			throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		
		environment.jersey().register(new FoodResource(jdbi));
		environment.jersey().register(new DrinkResource(jdbi));
	}
	
	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}

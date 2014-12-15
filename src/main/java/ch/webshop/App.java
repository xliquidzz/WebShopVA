package ch.webshop;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import ch.webshop.resource.ArticleResource;
import ch.webshop.resource.CategoryResource;

public class App extends Application<WebShopConfiguration> {

	public void initialize(Bootstrap<WebShopConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
	}

	public void run(WebShopConfiguration configuration, Environment environment) throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

		environment.jersey().register(new CategoryResource(jdbi));
		environment.jersey().register(new ArticleResource(jdbi));
		environment.jersey().setUrlPattern("/api/*");
	}
	
	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}

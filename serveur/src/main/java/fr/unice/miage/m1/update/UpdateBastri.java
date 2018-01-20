package fr.unice.miage.m1.update;

import fr.unice.miage.m1.baseX.BaseXClient;
import fr.unice.miage.m1.xml.Database;
import fr.unice.miage.m1.xml.XQueryBuilder;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class UpdateBastri implements ServletContextListener{

	private Context context;
	private Database database;
	private BaseXClient session;
	private XQueryBuilder builder;

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		// TODO : Comment
		UpdateRunnable runnable  = new UpdateRunnable();
		Thread thread = new Thread(runnable);
	    thread.start();

	    // Connect to BaseXClient
		try {
			this.session = new BaseXClient("localhost", 1984, "admin", "admin");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create a new BaseX context
		this.context = new Context();
		try {
			// Populate baseX context
			new CreateDB("projetXML", "src/main/resources/xml").execute(this.context);
		} catch (BaseXException e) {
			e.printStackTrace();
		}

		this.database = new Database(this.context);
		this.builder = new XQueryBuilder(this.database);


		// Setting into servlet attributes to share across app instance
		contextEvent.getServletContext().setAttribute("session", this.session);
	    contextEvent.getServletContext().setAttribute("database", this.database);
	    contextEvent.getServletContext().setAttribute("builder", this.builder);
		contextEvent.getServletContext().setAttribute("context", this.context);
	}

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		// Grabbing current context form servlet Context event
		Context savedContext = (Context) contextEvent.getServletContext().getAttribute("context");

		// Bulk drop everything to re-import on next-load
		try {
			new DropDB("projetXML").execute(savedContext);
		} catch (BaseXException e) {
			e.printStackTrace();
		}
	}
}

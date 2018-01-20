package fr.unice.miage.m1.xml;

import org.basex.core.*;
import org.basex.core.cmd.XQuery;

public class Database {
	private Context context;

	public Database(Context context){
		this.context = context;
	}

	/**
	 * Execute the query and send the result
	 * @param query
	 * @return
	 */
	public String execute(XQuery query){
		try {
			return query.execute(context);
		} catch (BaseXException e) {
			e.printStackTrace();
		}

		return null;
	}

}
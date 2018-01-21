package fr.unice.miage.m1.xml;

import org.basex.core.cmd.XQuery;
import org.inria.fr.ns.cr.Crs;
import org.inria.fr.ns.cr.Crs.Cr;
import org.inria.fr.ns.cr.Crs.Cr.Responsable;
import org.inria.fr.ns.cr.Crs.Cr.Responsable.Personne;
import org.inria.fr.ns.sr.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.util.List;

public class XQueryBuilder {

	private Object database;

	public XQueryBuilder(Object database) {
		this.database = database;
	}

	/**
	 * Get all Research Centers
	 *
	 * @return
	 */
	public Crs getCenters() {
		try {
			XQuery query = new XQuery("//crs");

			JAXBContext jaxbContext = JAXBContext.newInstance(Crs.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Database db = (Database) this.database;
			String queryResult = db.execute(query);

			StringReader reader = new StringReader(queryResult);

			return (Crs) unmarshaller.unmarshal(reader);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Cr getCenter(String centerId) {
		int id;
		try {
			id = Integer.parseInt(centerId);
		} catch (NumberFormatException ex) {
			System.out.println("Incorrect id received");
			return null;
		}

		XQuery query = new XQuery("//crs");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Crs.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			Database db = (Database) this.database;

			String queryResult = db.execute(query);

			StringReader reader = new StringReader(queryResult);
			Crs crs = (Crs) unmarshaller.unmarshal(reader);
			List<Cr> listCr = crs.getCr();

			for (Cr cr : listCr) {
				if (id == cr.getIdgef()) {
					return cr;
				}
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Responsable> getResponsablesCentre(String centerId) {
		int id;
		try {
			id = Integer.parseInt(centerId);
		} catch (NumberFormatException ex) {
			System.out.println("Incorrect id received");
			return null;
		}

		// Grab every crs
		XQuery query = new XQuery("//crs");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Crs.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			Database db = (Database) this.database;

			String queryResult = db.execute(query);

			StringReader reader = new StringReader(queryResult);
			Crs crs = (Crs) unmarshaller.unmarshal(reader);
			List<Cr> listCr = crs.getCr();

			for (Cr cr : listCr) {
				if (id == cr.getIdgef()) {
					return cr.getResponsable();
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

}
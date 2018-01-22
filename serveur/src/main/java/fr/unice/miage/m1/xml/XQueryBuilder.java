package fr.unice.miage.m1.xml;

import org.basex.core.cmd.XQuery;
import org.inria.fr.ns.cr.Crs;
import org.inria.fr.ns.cr.Crs.Cr;
import org.inria.fr.ns.cr.Crs.Cr.Responsable;
import org.inria.fr.ns.sr.Entite;
import org.inria.fr.ns.sr.StructuresInria;
import org.inria.fr.ns.sr.StructureInria;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.util.List;
import java.util.ArrayList;

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

	public List<StructureInria> getEquipesParCentreDeRecherche(String centerId) {
		ArrayList<StructureInria> outputListEntite = new ArrayList<StructureInria>();
		String siid = getCenter(centerId).getSiid();
		XQuery query = new XQuery("doc(\"src/main/resources/XML/bastri.xml\")/root()");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StructuresInria.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			Database db = (Database) this.database;
			String queryResult = db.execute(query);
			StringReader reader = new StringReader(queryResult);
			StructuresInria cris = (StructuresInria) unmarshaller.unmarshal(reader);
			List<StructureInria> listCris = cris.getStructureinria();

			for (StructureInria structure : listCris) {
				List<Entite> listdesEquipes = structure.getEntite();
				for(Entite entite : listdesEquipes) {
					if(entite.getAdressegeographique().getCri().getSiid().equals(siid)) {
						outputListEntite.add(structure);
					}
				}
			}
			return outputListEntite;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getNombreEquipeParCentreDeRecherche(String centerId) {
		ArrayList<StructureInria> outputListEntite = new ArrayList<StructureInria>();
		String siid = getCenter(centerId).getSiid();
		XQuery query = new XQuery("doc(\"src/main/resources/XML/bastri.xml\")/root()");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StructuresInria.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			Database db = (Database) this.database;
			String queryResult = db.execute(query);
			StringReader reader = new StringReader(queryResult);
			StructuresInria   cris = (StructuresInria) unmarshaller.unmarshal(reader);
			List<StructureInria> listCris = cris.getStructureinria();

			for (StructureInria structure : listCris) {
				List<Entite> listdesEquipes = structure.getEntite();
				for(Entite entite : listdesEquipes) {
					if(entite.getAdressegeographique().getCri().getSiid().equals(siid)) {
						outputListEntite.add(structure);
					}
				}
			}
			return outputListEntite.size();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return 0;
	}



	public List<StructureInria> getEquipes() {
		ArrayList<StructureInria> outputListEntite = new ArrayList<StructureInria>();

		XQuery query = new XQuery("doc(\"src/main/resources/XML/bastri.xml\")/root()");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StructuresInria.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			Database db = (Database) this.database;
			String queryResult = db.execute(query);
			StringReader reader = new StringReader(queryResult);
			StructuresInria cris = (StructuresInria) unmarshaller.unmarshal(reader);
			List<StructureInria> listCris = cris.getStructureinria();

			for (StructureInria structure : listCris) {
				List<Entite> listdesEquipes = structure.getEntite();
				for(Entite entite : listdesEquipes) {
						outputListEntite.add(structure);
				}
			}
			return outputListEntite;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
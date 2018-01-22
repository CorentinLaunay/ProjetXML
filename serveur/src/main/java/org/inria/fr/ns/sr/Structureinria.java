//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.01.22 à 06:47:02 PM CET 
//


package org.inria.fr.ns.sr;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.unice.miage.m1.adapters.DateAdapter;


/**
 * 
 * 	Définition d'une EPI
 *       
 * 
 * <p>Classe Java pour structureinria element declaration.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;element name="structureinria"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="siidEquipeGroupe" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="urlTeam" type="{http://ns.inria.fr/dsi/si/app/bastri}urlTeam" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="keywords" type="{http://ns.inria.fr/dsi/si/app/bastri}keywords" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="sigle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="sigle_html" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="sigle_latex" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="typestructure" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="libellefr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="libelleen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="domaine" type="{http://ns.inria.fr/dsi/si/app/bastri}domaine" maxOccurs="2"/&gt;
 *           &lt;element name="theme" type="{http://ns.inria.fr/dsi/si/app/bastri}theme" maxOccurs="2"/&gt;
 *           &lt;element name="date_creation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *           &lt;element name="date_fermeture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="entite" type="{http://ns.inria.fr/dsi/si/app/bastri}entite" maxOccurs="unbounded"/&gt;
 *           &lt;element name="idhal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="resume" type="{http://ns.inria.fr/dsi/si/app/bastri}resume" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *         &lt;attribute name="numnatstruct" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "siidEquipeGroupe",
    "urlTeam",
    "keywords",
    "sigle",
    "sigleHtml",
    "sigleLatex",
    "typestructure",
    "libellefr",
    "libelleen",
    "domaine",
    "theme",
    "dateCreation",
    "dateFermeture",
    "entite",
    "idhal",
    "resume"
})
@XmlRootElement(name = "structureinria")
public class StructureInria
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String siidEquipeGroupe;
    protected List<UrlTeam> urlTeam;
    protected List<Keywords> keywords;
    @XmlElement(required = true)
    protected String sigle;
    @XmlElement(name = "sigle_html", required = true)
    protected String sigleHtml;
    @XmlElement(name = "sigle_latex", required = true)
    protected String sigleLatex;
    @XmlElement(required = true)
    protected String typestructure;
    protected String libellefr;
    protected String libelleen;
    @XmlElement(required = true)
    protected List<Domaine> domaine;
    @XmlElement(required = true)
    protected List<Theme> theme;
    @XmlElement(name = "date_creation", type = String.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlSchemaType(name = "date")
    protected LocalDate dateCreation;
    @XmlElement(name = "date_fermeture")
    protected String dateFermeture;
    @XmlElement(required = true)
    protected List<Entite> entite;
    protected String idhal;
    protected List<Resume> resume;
    @XmlAttribute(name = "siid")
    protected String siid;
    @XmlAttribute(name = "numnatstruct")
    protected String numnatstruct;

    /**
     * Obtient la valeur de la propriété siidEquipeGroupe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiidEquipeGroupe() {
        return siidEquipeGroupe;
    }

    /**
     * Définit la valeur de la propriété siidEquipeGroupe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiidEquipeGroupe(String value) {
        this.siidEquipeGroupe = value;
    }

    /**
     * Gets the value of the urlTeam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the urlTeam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrlTeam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UrlTeam }
     * 
     * 
     */
    public List<UrlTeam> getUrlTeam() {
        if (urlTeam == null) {
            urlTeam = new ArrayList<UrlTeam>();
        }
        return this.urlTeam;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Keywords }
     * 
     * 
     */
    public List<Keywords> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<Keywords>();
        }
        return this.keywords;
    }

    /**
     * Obtient la valeur de la propriété sigle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigle() {
        return sigle;
    }

    /**
     * Définit la valeur de la propriété sigle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigle(String value) {
        this.sigle = value;
    }

    /**
     * Obtient la valeur de la propriété sigleHtml.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigleHtml() {
        return sigleHtml;
    }

    /**
     * Définit la valeur de la propriété sigleHtml.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigleHtml(String value) {
        this.sigleHtml = value;
    }

    /**
     * Obtient la valeur de la propriété sigleLatex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigleLatex() {
        return sigleLatex;
    }

    /**
     * Définit la valeur de la propriété sigleLatex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigleLatex(String value) {
        this.sigleLatex = value;
    }

    /**
     * Obtient la valeur de la propriété typestructure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypestructure() {
        return typestructure;
    }

    /**
     * Définit la valeur de la propriété typestructure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypestructure(String value) {
        this.typestructure = value;
    }

    /**
     * Obtient la valeur de la propriété libellefr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibellefr() {
        return libellefr;
    }

    /**
     * Définit la valeur de la propriété libellefr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibellefr(String value) {
        this.libellefr = value;
    }

    /**
     * Obtient la valeur de la propriété libelleen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleen() {
        return libelleen;
    }

    /**
     * Définit la valeur de la propriété libelleen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleen(String value) {
        this.libelleen = value;
    }

    /**
     * Gets the value of the domaine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domaine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomaine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Domaine }
     * 
     * 
     */
    public List<Domaine> getDomaine() {
        if (domaine == null) {
            domaine = new ArrayList<Domaine>();
        }
        return this.domaine;
    }

    /**
     * Gets the value of the theme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the theme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Theme }
     * 
     * 
     */
    public List<Theme> getTheme() {
        if (theme == null) {
            theme = new ArrayList<Theme>();
        }
        return this.theme;
    }

    /**
     * Obtient la valeur de la propriété dateCreation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDateCreation() {
        return dateCreation;
    }

    /**
     * Définit la valeur de la propriété dateCreation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateCreation(LocalDate value) {
        this.dateCreation = value;
    }

    /**
     * Obtient la valeur de la propriété dateFermeture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFermeture() {
        return dateFermeture;
    }

    /**
     * Définit la valeur de la propriété dateFermeture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFermeture(String value) {
        this.dateFermeture = value;
    }

    /**
     * Gets the value of the entite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entite }
     * 
     * 
     */
    public List<Entite> getEntite() {
        if (entite == null) {
            entite = new ArrayList<Entite>();
        }
        return this.entite;
    }

    /**
     * Obtient la valeur de la propriété idhal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdhal() {
        return idhal;
    }

    /**
     * Définit la valeur de la propriété idhal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdhal(String value) {
        this.idhal = value;
    }

    /**
     * Gets the value of the resume property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resume property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResume().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resume }
     * 
     * 
     */
    public List<Resume> getResume() {
        if (resume == null) {
            resume = new ArrayList<Resume>();
        }
        return this.resume;
    }

    /**
     * Obtient la valeur de la propriété siid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiid() {
        return siid;
    }

    /**
     * Définit la valeur de la propriété siid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiid(String value) {
        this.siid = value;
    }

    /**
     * Obtient la valeur de la propriété numnatstruct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumnatstruct() {
        return numnatstruct;
    }

    /**
     * Définit la valeur de la propriété numnatstruct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumnatstruct(String value) {
        this.numnatstruct = value;
    }

}

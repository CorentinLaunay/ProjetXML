//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.01.22 à 06:47:02 PM CET 
//


package org.inria.fr.ns.sr;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour adressegeographique complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="adressegeographique"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cri" type="{http://ns.inria.fr/dsi/si/app/bastri}cri" minOccurs="0"/&gt;
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="refid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adressegeographique", propOrder = {
    "libelle",
    "cri",
    "ville",
    "adresse",
    "cp",
    "latitude",
    "longitude"
})
public class Adressegeographique
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String libelle;
    protected Cri cri;
    protected String ville;
    protected String adresse;
    protected String cp;
    protected String latitude;
    protected String longitude;
    @XmlAttribute(name = "siid")
    protected String siid;
    @XmlAttribute(name = "refid")
    protected String refid;
    @XmlAttribute(name = "url")
    protected String url;
    @XmlAttribute(name = "version")
    protected String version;

    /**
     * Obtient la valeur de la propriété libelle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit la valeur de la propriété libelle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
    }

    /**
     * Obtient la valeur de la propriété cri.
     * 
     * @return
     *     possible object is
     *     {@link Cri }
     *     
     */
    public Cri getCri() {
        return cri;
    }

    /**
     * Définit la valeur de la propriété cri.
     * 
     * @param value
     *     allowed object is
     *     {@link Cri }
     *     
     */
    public void setCri(Cri value) {
        this.cri = value;
    }

    /**
     * Obtient la valeur de la propriété ville.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la valeur de la propriété ville.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propriété cp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCp() {
        return cp;
    }

    /**
     * Définit la valeur de la propriété cp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCp(String value) {
        this.cp = value;
    }

    /**
     * Obtient la valeur de la propriété latitude.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Définit la valeur de la propriété latitude.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Obtient la valeur de la propriété longitude.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Définit la valeur de la propriété longitude.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
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
     * Obtient la valeur de la propriété refid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefid() {
        return refid;
    }

    /**
     * Définit la valeur de la propriété refid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefid(String value) {
        this.refid = value;
    }

    /**
     * Obtient la valeur de la propriété url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Définit la valeur de la propriété url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtient la valeur de la propriété version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Définit la valeur de la propriété version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}

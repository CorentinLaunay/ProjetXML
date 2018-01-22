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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour lien_structure_exterieure complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="lien_structure_exterieure"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date_debut" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date_fin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type_lien" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="structure_exterieure" type="{http://ns.inria.fr/dsi/si/app/bastri}structure_exterieure"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lien_structure_exterieure", propOrder = {
    "dateDebut",
    "dateFin",
    "typeLien",
    "structureExterieure"
})
public class LienStructureExterieure
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "date_debut", required = true)
    protected String dateDebut;
    @XmlElement(name = "date_fin", required = true)
    protected String dateFin;
    @XmlElement(name = "type_lien", required = true)
    protected String typeLien;
    @XmlElement(name = "structure_exterieure", required = true)
    protected StructureExterieure structureExterieure;
    @XmlAttribute(name = "version")
    protected String version;

    /**
     * Obtient la valeur de la propriété dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la valeur de la propriété dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDebut(String value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFin(String value) {
        this.dateFin = value;
    }

    /**
     * Obtient la valeur de la propriété typeLien.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeLien() {
        return typeLien;
    }

    /**
     * Définit la valeur de la propriété typeLien.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeLien(String value) {
        this.typeLien = value;
    }

    /**
     * Obtient la valeur de la propriété structureExterieure.
     * 
     * @return
     *     possible object is
     *     {@link StructureExterieure }
     *     
     */
    public StructureExterieure getStructureExterieure() {
        return structureExterieure;
    }

    /**
     * Définit la valeur de la propriété structureExterieure.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureExterieure }
     *     
     */
    public void setStructureExterieure(StructureExterieure value) {
        this.structureExterieure = value;
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

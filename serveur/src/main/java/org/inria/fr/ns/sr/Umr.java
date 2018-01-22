//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.01.22 à 04:09:03 PM CET 
//


package org.inria.fr.ns.sr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour umr complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="umr"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="directeur" type="{http://ns.inria.fr/dsi/si/app/bastri}directeur"/&gt;
 *         &lt;element name="composition" type="{http://ns.inria.fr/dsi/si/app/bastri}composition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "umr", propOrder = {
    "numero",
    "directeur",
    "composition"
})
public class Umr
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String numero;
    @XmlElement(required = true)
    protected Directeur directeur;
    protected List<Composition> composition;

    /**
     * Obtient la valeur de la propriété numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Définit la valeur de la propriété numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriété directeur.
     * 
     * @return
     *     possible object is
     *     {@link Directeur }
     *     
     */
    public Directeur getDirecteur() {
        return directeur;
    }

    /**
     * Définit la valeur de la propriété directeur.
     * 
     * @param value
     *     allowed object is
     *     {@link Directeur }
     *     
     */
    public void setDirecteur(Directeur value) {
        this.directeur = value;
    }

    /**
     * Gets the value of the composition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the composition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComposition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Composition }
     * 
     * 
     */
    public List<Composition> getComposition() {
        if (composition == null) {
            composition = new ArrayList<Composition>();
        }
        return this.composition;
    }

}

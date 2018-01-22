//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.01.22 à 06:47:02 PM CET 
//


package org.inria.fr.ns.sr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.unice.miage.m1.adapters.PrincipalAdapter;


/**
 * <p>Classe Java pour entite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="entite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sigle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="personne" type="{http://ns.inria.fr/dsi/si/app/bastri}personne"/&gt;
 *         &lt;element name="adressegeographique" type="{http://ns.inria.fr/dsi/si/app/bastri}adressegeographique"/&gt;
 *         &lt;element name="hebergeur" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="typeentite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lien_structure_exterieure" type="{http://ns.inria.fr/dsi/si/app/bastri}lien_structure_exterieure" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="principal" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="codestructure" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entite", propOrder = {
    "sigle",
    "personne",
    "adressegeographique",
    "hebergeur",
    "typeentite",
    "commentaire",
    "lienStructureExterieure"
})
public class Entite
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String sigle;
    @XmlElement(required = true)
    protected Personne personne;
    @XmlElement(required = true)
    protected Adressegeographique adressegeographique;
    @XmlElement(required = true)
    protected String hebergeur;
    @XmlElement(required = true)
    protected String typeentite;
    @XmlElement(required = true)
    protected String commentaire;
    @XmlElement(name = "lien_structure_exterieure")
    protected List<LienStructureExterieure> lienStructureExterieure;
    @XmlAttribute(name = "principal")
    @XmlJavaTypeAdapter(PrincipalAdapter.class)
    protected Boolean principal;
    @XmlAttribute(name = "codestructure")
    protected String codestructure;
    @XmlAttribute(name = "siid")
    protected String siid;

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
     * Obtient la valeur de la propriété personne.
     * 
     * @return
     *     possible object is
     *     {@link Personne }
     *     
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     * Définit la valeur de la propriété personne.
     * 
     * @param value
     *     allowed object is
     *     {@link Personne }
     *     
     */
    public void setPersonne(Personne value) {
        this.personne = value;
    }

    /**
     * Obtient la valeur de la propriété adressegeographique.
     * 
     * @return
     *     possible object is
     *     {@link Adressegeographique }
     *     
     */
    public Adressegeographique getAdressegeographique() {
        return adressegeographique;
    }

    /**
     * Définit la valeur de la propriété adressegeographique.
     * 
     * @param value
     *     allowed object is
     *     {@link Adressegeographique }
     *     
     */
    public void setAdressegeographique(Adressegeographique value) {
        this.adressegeographique = value;
    }

    /**
     * Obtient la valeur de la propriété hebergeur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHebergeur() {
        return hebergeur;
    }

    /**
     * Définit la valeur de la propriété hebergeur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHebergeur(String value) {
        this.hebergeur = value;
    }

    /**
     * Obtient la valeur de la propriété typeentite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeentite() {
        return typeentite;
    }

    /**
     * Définit la valeur de la propriété typeentite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeentite(String value) {
        this.typeentite = value;
    }

    /**
     * Obtient la valeur de la propriété commentaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Définit la valeur de la propriété commentaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaire(String value) {
        this.commentaire = value;
    }

    /**
     * Gets the value of the lienStructureExterieure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lienStructureExterieure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLienStructureExterieure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LienStructureExterieure }
     * 
     * 
     */
    public List<LienStructureExterieure> getLienStructureExterieure() {
        if (lienStructureExterieure == null) {
            lienStructureExterieure = new ArrayList<LienStructureExterieure>();
        }
        return this.lienStructureExterieure;
    }

    /**
     * Obtient la valeur de la propriété principal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isPrincipal() {
        return principal;
    }

    /**
     * Définit la valeur de la propriété principal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipal(Boolean value) {
        this.principal = value;
    }

    /**
     * Obtient la valeur de la propriété codestructure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodestructure() {
        return codestructure;
    }

    /**
     * Définit la valeur de la propriété codestructure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodestructure(String value) {
        this.codestructure = value;
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

}

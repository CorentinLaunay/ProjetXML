//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.01.22 à 06:47:02 PM CET 
//


package org.inria.fr.ns.cr;

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
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.unice.miage.m1.adapters.DateAdapter;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cr" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="numnatstructrep" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="date_ouverture" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="date_fermeture" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="sigle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="idgef" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                   &lt;element name="adressegeographique"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="cri"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                     &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="cp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                             &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="responsable" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="personne"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="gefid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="fonction" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cr"
})
@XmlRootElement(name = "crs")
public class Crs
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected List<Crs.Cr> cr;

    /**
     * Gets the value of the cr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Crs.Cr }
     * 
     * 
     */
    public List<Crs.Cr> getCr() {
        if (cr == null) {
            cr = new ArrayList<Crs.Cr>();
        }
        return this.cr;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="numnatstructrep" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="date_ouverture" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="date_fermeture" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="sigle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="idgef" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
     *         &lt;element name="adressegeographique"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="cri"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                           &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="cp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *                   &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="responsable" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="personne"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="gefid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="fonction" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numnatstructrep",
        "dateOuverture",
        "dateFermeture",
        "sigle",
        "libelle",
        "idgef",
        "adressegeographique",
        "responsable"
    })
    public static class Cr
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(required = true)
        protected String numnatstructrep;
        @XmlElement(name = "date_ouverture", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateAdapter.class)
        @XmlSchemaType(name = "date")
        protected LocalDate dateOuverture;
        @XmlElement(name = "date_fermeture", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateAdapter.class)
        @XmlSchemaType(name = "date")
        protected LocalDate dateFermeture;
        @XmlElement(required = true)
        protected String sigle;
        @XmlElement(required = true)
        protected String libelle;
        protected byte idgef;
        @XmlElement(required = true)
        protected Crs.Cr.Adressegeographique adressegeographique;
        protected List<Crs.Cr.Responsable> responsable;
        @XmlAttribute(name = "siid")
        protected String siid;

        /**
         * Obtient la valeur de la propriété numnatstructrep.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumnatstructrep() {
            return numnatstructrep;
        }

        /**
         * Définit la valeur de la propriété numnatstructrep.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumnatstructrep(String value) {
            this.numnatstructrep = value;
        }

        /**
         * Obtient la valeur de la propriété dateOuverture.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public LocalDate getDateOuverture() {
            return dateOuverture;
        }

        /**
         * Définit la valeur de la propriété dateOuverture.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateOuverture(LocalDate value) {
            this.dateOuverture = value;
        }

        /**
         * Obtient la valeur de la propriété dateFermeture.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public LocalDate getDateFermeture() {
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
        public void setDateFermeture(LocalDate value) {
            this.dateFermeture = value;
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
         * Obtient la valeur de la propriété idgef.
         * 
         */
        public byte getIdgef() {
            return idgef;
        }

        /**
         * Définit la valeur de la propriété idgef.
         * 
         */
        public void setIdgef(byte value) {
            this.idgef = value;
        }

        /**
         * Obtient la valeur de la propriété adressegeographique.
         * 
         * @return
         *     possible object is
         *     {@link Crs.Cr.Adressegeographique }
         *     
         */
        public Crs.Cr.Adressegeographique getAdressegeographique() {
            return adressegeographique;
        }

        /**
         * Définit la valeur de la propriété adressegeographique.
         * 
         * @param value
         *     allowed object is
         *     {@link Crs.Cr.Adressegeographique }
         *     
         */
        public void setAdressegeographique(Crs.Cr.Adressegeographique value) {
            this.adressegeographique = value;
        }

        /**
         * Gets the value of the responsable property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the responsable property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResponsable().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Crs.Cr.Responsable }
         * 
         * 
         */
        public List<Crs.Cr.Responsable> getResponsable() {
            if (responsable == null) {
                responsable = new ArrayList<Crs.Cr.Responsable>();
            }
            return this.responsable;
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
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="cri"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                 &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="cp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
         *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "libelle",
            "cri",
            "ville",
            "adresse",
            "cp",
            "latitude",
            "longitude"
        })
        public static class Adressegeographique
            implements Serializable
        {

            private final static long serialVersionUID = 1L;
            @XmlElement(required = true)
            protected String libelle;
            @XmlElement(required = true)
            protected Crs.Cr.Adressegeographique.Cri cri;
            @XmlElement(required = true)
            protected String ville;
            @XmlElement(required = true)
            protected String adresse;
            @XmlElement(required = true)
            protected String cp;
            protected float latitude;
            protected float longitude;
            @XmlAttribute(name = "siid")
            protected String siid;

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
             *     {@link Crs.Cr.Adressegeographique.Cri }
             *     
             */
            public Crs.Cr.Adressegeographique.Cri getCri() {
                return cri;
            }

            /**
             * Définit la valeur de la propriété cri.
             * 
             * @param value
             *     allowed object is
             *     {@link Crs.Cr.Adressegeographique.Cri }
             *     
             */
            public void setCri(Crs.Cr.Adressegeographique.Cri value) {
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
             */
            public float getLatitude() {
                return latitude;
            }

            /**
             * Définit la valeur de la propriété latitude.
             * 
             */
            public void setLatitude(float value) {
                this.latitude = value;
            }

            /**
             * Obtient la valeur de la propriété longitude.
             * 
             */
            public float getLongitude() {
                return longitude;
            }

            /**
             * Définit la valeur de la propriété longitude.
             * 
             */
            public void setLongitude(float value) {
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
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
             *       &lt;attribute name="siid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *     &lt;/extension&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Cri
                implements Serializable
            {

                private final static long serialVersionUID = 1L;
                @XmlValue
                protected String value;
                @XmlAttribute(name = "siid")
                protected String siid;

                /**
                 * Obtient la valeur de la propriété value.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Définit la valeur de la propriété value.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
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

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="personne"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="gefid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="fonction" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "personne"
        })
        public static class Responsable
            implements Serializable
        {

            private final static long serialVersionUID = 1L;
            @XmlElement(required = true)
            protected Crs.Cr.Responsable.Personne personne;
            @XmlAttribute(name = "fonction")
            protected String fonction;

            /**
             * Obtient la valeur de la propriété personne.
             * 
             * @return
             *     possible object is
             *     {@link Crs.Cr.Responsable.Personne }
             *     
             */
            public Crs.Cr.Responsable.Personne getPersonne() {
                return personne;
            }

            /**
             * Définit la valeur de la propriété personne.
             * 
             * @param value
             *     allowed object is
             *     {@link Crs.Cr.Responsable.Personne }
             *     
             */
            public void setPersonne(Crs.Cr.Responsable.Personne value) {
                this.personne = value;
            }

            /**
             * Obtient la valeur de la propriété fonction.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFonction() {
                return fonction;
            }

            /**
             * Définit la valeur de la propriété fonction.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFonction(String value) {
                this.fonction = value;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="gefid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "nom",
                "prenom"
            })
            public static class Personne
                implements Serializable
            {

                private final static long serialVersionUID = 1L;
                @XmlElement(required = true)
                protected String nom;
                @XmlElement(required = true)
                protected String prenom;
                @XmlAttribute(name = "gefid")
                protected String gefid;

                /**
                 * Obtient la valeur de la propriété nom.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNom() {
                    return nom;
                }

                /**
                 * Définit la valeur de la propriété nom.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNom(String value) {
                    this.nom = value;
                }

                /**
                 * Obtient la valeur de la propriété prenom.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPrenom() {
                    return prenom;
                }

                /**
                 * Définit la valeur de la propriété prenom.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPrenom(String value) {
                    this.prenom = value;
                }

                /**
                 * Obtient la valeur de la propriété gefid.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getGefid() {
                    return gefid;
                }

                /**
                 * Définit la valeur de la propriété gefid.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setGefid(String value) {
                    this.gefid = value;
                }

            }

        }

    }

}

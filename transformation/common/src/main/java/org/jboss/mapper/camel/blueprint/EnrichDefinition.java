//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.13 at 12:09:41 PM EST 
//


package org.jboss.mapper.camel.blueprint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enrichDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enrichDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/blueprint}noOutputDefinition">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="uri" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="strategyRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="strategyMethodName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="strategyMethodAllowNull" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="aggregateOnException" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='skip' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enrichDefinition")
public class EnrichDefinition
    extends NoOutputDefinition
{

    @XmlAttribute(name = "uri")
    protected String uri;
    @XmlAttribute(name = "ref")
    protected String ref;
    @XmlAttribute(name = "strategyRef")
    protected String strategyRef;
    @XmlAttribute(name = "strategyMethodName")
    protected String strategyMethodName;
    @XmlAttribute(name = "strategyMethodAllowNull")
    protected Boolean strategyMethodAllowNull;
    @XmlAttribute(name = "aggregateOnException")
    protected Boolean aggregateOnException;

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Gets the value of the strategyRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrategyRef() {
        return strategyRef;
    }

    /**
     * Sets the value of the strategyRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrategyRef(String value) {
        this.strategyRef = value;
    }

    /**
     * Gets the value of the strategyMethodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrategyMethodName() {
        return strategyMethodName;
    }

    /**
     * Sets the value of the strategyMethodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrategyMethodName(String value) {
        this.strategyMethodName = value;
    }

    /**
     * Gets the value of the strategyMethodAllowNull property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStrategyMethodAllowNull() {
        return strategyMethodAllowNull;
    }

    /**
     * Sets the value of the strategyMethodAllowNull property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStrategyMethodAllowNull(Boolean value) {
        this.strategyMethodAllowNull = value;
    }

    /**
     * Gets the value of the aggregateOnException property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAggregateOnException() {
        return aggregateOnException;
    }

    /**
     * Sets the value of the aggregateOnException property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAggregateOnException(Boolean value) {
        this.aggregateOnException = value;
    }

}

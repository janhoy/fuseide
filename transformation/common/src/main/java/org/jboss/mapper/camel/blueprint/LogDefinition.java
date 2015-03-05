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
 * <p>Java class for logDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="logDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/blueprint}noOutputDefinition">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="message" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loggingLevel" type="{http://camel.apache.org/schema/blueprint}loggingLevel" />
 *       &lt;attribute name="logName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="marker" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loggerRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute processContents='skip' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "logDefinition")
public class LogDefinition
    extends NoOutputDefinition
{

    @XmlAttribute(name = "message", required = true)
    protected String message;
    @XmlAttribute(name = "loggingLevel")
    protected LoggingLevel loggingLevel;
    @XmlAttribute(name = "logName")
    protected String logName;
    @XmlAttribute(name = "marker")
    protected String marker;
    @XmlAttribute(name = "loggerRef")
    protected String loggerRef;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the loggingLevel property.
     * 
     * @return
     *     possible object is
     *     {@link LoggingLevel }
     *     
     */
    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    /**
     * Sets the value of the loggingLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoggingLevel }
     *     
     */
    public void setLoggingLevel(LoggingLevel value) {
        this.loggingLevel = value;
    }

    /**
     * Gets the value of the logName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogName() {
        return logName;
    }

    /**
     * Sets the value of the logName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogName(String value) {
        this.logName = value;
    }

    /**
     * Gets the value of the marker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarker() {
        return marker;
    }

    /**
     * Sets the value of the marker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarker(String value) {
        this.marker = value;
    }

    /**
     * Gets the value of the loggerRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoggerRef() {
        return loggerRef;
    }

    /**
     * Sets the value of the loggerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoggerRef(String value) {
        this.loggerRef = value;
    }

}
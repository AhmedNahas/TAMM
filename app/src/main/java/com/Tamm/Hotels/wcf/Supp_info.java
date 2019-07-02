package com.Tamm.Hotels.wcf;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.5.6.0
//
// Created by Quasar Development 
//
//---------------------------------------------------


import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.math.BigDecimal;
import java.util.Hashtable;

public class Supp_info extends AttributeContainer implements KvmSerializable {


    public Enums.SupplementType Type = Enums.SupplementType.PerStaySupplement;
    
    public String SuppName;

    public Enums.SupmtChargeType SuppChargeType = Enums.SupmtChargeType.Included;

    public BigDecimal Price = BigDecimal.ZERO;
    
    public String Currency;
    private transient java.lang.Object __source;


    public void loadFromSoap(java.lang.Object paramObj, ExtendedSoapSerializationEnvelope __envelope) {
        if (paramObj == null)
            return;
        AttributeContainer inObj = (AttributeContainer) paramObj;
        __source = inObj;
        if (inObj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) inObj;
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                PropertyInfo info = soapObject.getPropertyInfo(i0);
                if (!loadProperty(info, soapObject, __envelope)) {
                }
            } 
        }
        if (inObj.hasAttribute("Type")) {
            java.lang.Object j = inObj.getAttribute("Type");
            if (j != null) {
                Type = Enums.SupplementType.fromString(j.toString());
            }
        }
        if (inObj.hasAttribute("SuppName")) {
            java.lang.Object j = inObj.getAttribute("SuppName");
            if (j != null) {
                SuppName = j.toString();
            }
        }
        if (inObj.hasAttribute("SuppChargeType")) {
            java.lang.Object j = inObj.getAttribute("SuppChargeType");
            if (j != null) {
                SuppChargeType = Enums.SupmtChargeType.fromString(j.toString());
            }
        }
        if (inObj.hasAttribute("Price")) {
            java.lang.Object j = inObj.getAttribute("Price");
            if (j != null) {
                Price = new BigDecimal(j.toString());
            }
        }
        if (inObj.hasAttribute("Currency")) {
            java.lang.Object j = inObj.getAttribute("Currency");
            if (j != null) {
                Currency = j.toString();
            }
        }

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        return false;
    }

    public java.lang.Object getOriginalXmlSource() {
        return __source;
    }    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }



    @Override
    public int getAttributeCount() {
        return 5;
    }

    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if (index == 0) {
            info.name = "Type";
            info.namespace = "";
            if (this.Type != null) {
                info.setValue(this.Type);
            }

        }
        if (index == 1) {
            info.name = "SuppName";
            info.namespace = "";
            if (this.SuppName != null) {
                info.setValue(this.SuppName);
            }

        }
        if (index == 2) {
            info.name = "SuppChargeType";
            info.namespace = "";
            if (this.SuppChargeType != null) {
                info.setValue(this.SuppChargeType);
            }

        }
        if (index == 3) {
            info.name = "Price";
            info.namespace = "";
            if (this.Price != null) {
                info.setValue(this.Price);
            }

        }
        if (index == 4) {
            info.name = "Currency";
            info.namespace = "";
            if (this.Currency != null) {
                info.setValue(this.Currency);
            }

        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}

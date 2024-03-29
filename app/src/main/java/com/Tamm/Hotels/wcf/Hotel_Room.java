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
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class Hotel_Room extends AttributeContainer implements KvmSerializable {


    public Integer RoomIndex = 0;
    
    public String RoomTypeName;

    public String Inclusion;

    public String RoomTypeCode;

    public String RatePlanCode;

    public RoomRate RoomRate;

    public String RoomPromtion;

    public String RoomInstructions;

    public ArrayOfSupplement Supplements;

    public String RoomEssentialInfo;

    public RoomInformation RoomAdditionalInfo;

    public CancelPolicies CancelPolicies;

    public String Amenities;

    public String MealType;
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

    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("RoomIndex")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomIndex = Integer.parseInt(j.toString());
                    }
                } else if (obj instanceof Integer) {
                    this.RoomIndex = (Integer) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomTypeName")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomTypeName = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomTypeName = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("Inclusion")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.Inclusion = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.Inclusion = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomTypeCode")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomTypeCode = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomTypeCode = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RatePlanCode")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RatePlanCode = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RatePlanCode = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomRate")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.RoomRate = (RoomRate) __envelope.get(j, RoomRate.class, false);
            }
            return true;
        }
        if (info.name.equals("RoomPromtion")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomPromtion = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomPromtion = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomInstructions")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomInstructions = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomInstructions = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("Supplements")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.Supplements = (ArrayOfSupplement) __envelope.get(j, ArrayOfSupplement.class, false);
            }
            return true;
        }
        if (info.name.equals("RoomEssentialInfo")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.RoomEssentialInfo = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.RoomEssentialInfo = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("RoomAdditionalInfo")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.RoomAdditionalInfo = (RoomInformation) __envelope.get(j, RoomInformation.class, false);
            }
            return true;
        }
        if (info.name.equals("CancelPolicies")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.CancelPolicies = (CancelPolicies) __envelope.get(j, CancelPolicies.class, false);
            }
            return true;
        }
        if (info.name.equals("Amenities")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.Amenities = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.Amenities = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("MealType")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.MealType = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.MealType = (String) obj;
                }
            }
            return true;
        }
        return false;
    }

    public java.lang.Object getOriginalXmlSource() {
        return __source;
    }    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return RoomIndex;
        }
        if (propertyIndex == 1) {
            return this.RoomTypeName != null ? this.RoomTypeName : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 2) {
            return this.Inclusion != null ? this.Inclusion : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 3) {
            return this.RoomTypeCode != null ? this.RoomTypeCode : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 4) {
            return this.RatePlanCode != null ? this.RatePlanCode : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 5) {
            return this.RoomRate != null ? this.RoomRate : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 6) {
            return this.RoomPromtion != null ? this.RoomPromtion : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 7) {
            return this.RoomInstructions != null ? this.RoomInstructions : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 8) {
            return this.Supplements != null ? this.Supplements : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 9) {
            return this.RoomEssentialInfo != null ? this.RoomEssentialInfo : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 10) {
            return this.RoomAdditionalInfo != null ? this.RoomAdditionalInfo : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 11) {
            return this.CancelPolicies != null ? this.CancelPolicies : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 12) {
            return this.Amenities != null ? this.Amenities : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 13) {
            return this.MealType != null ? this.MealType : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 14;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "RoomIndex";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomTypeName";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Inclusion";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomTypeCode";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 4) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RatePlanCode";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 5) {
            info.type = RoomRate.class;
            info.name = "RoomRate";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 6) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomPromtion";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 7) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomInstructions";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 8) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Supplements";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 9) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "RoomEssentialInfo";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 10) {
            info.type = RoomInformation.class;
            info.name = "RoomAdditionalInfo";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 11) {
            info.type = CancelPolicies.class;
            info.name = "CancelPolicies";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 12) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Amenities";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
        if (propertyIndex == 13) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "MealType";
            info.namespace = "http://TekTravel/HotelBookingApi";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}


package fr.unice.miage.m1.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PrincipalAdapter extends XmlAdapter<String, Boolean> {
    @Override
    public Boolean unmarshal(String value) {
        if(value == null) {return false;}
        return Boolean.parseBoolean(value);
    }

    @Override
    public String marshal(Boolean value) {
        return value.toString();
    }
}
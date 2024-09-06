package org.example.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Shop {

    private int count = 12;
    private double profit = 123.4;
    private String[] secretData;

    static class Goods{
        @XmlValue
        ArrayList<String> names;
    }
}

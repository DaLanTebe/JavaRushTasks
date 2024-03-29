package com.javarush.task.jdk13.task41.task4109;

public abstract class RequisitionBase extends AbstractEntity {
    public User user;
    public String name;
    public String mail;
    public String utmMark;
    public String webinarType;
    public String promoCode;

    public RequisitionBase() {
    }
    public RequisitionBase(RequisitionBase requisitionBase) {
        super(requisitionBase);
        user = (User) requisitionBase.user.clone();
        name = requisitionBase.name;
        mail = requisitionBase.mail;
        utmMark = requisitionBase.utmMark;
        webinarType = requisitionBase.webinarType;
        promoCode = requisitionBase.webinarType;
    }
}

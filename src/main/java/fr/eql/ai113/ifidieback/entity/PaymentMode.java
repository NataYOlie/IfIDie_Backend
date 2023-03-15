package fr.eql.ai113.ifidieback.entity;

import javax.persistence.*;

/**
 * THis is a POJO for Payment modes, could be Visa, Paypal, MasterCard...
 */

@Entity
public class PaymentMode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_paymentMod;
    public String paymentName;
    public String clientAccess;

    @OneToOne
    private Subscribtion subscribtion;

    /**
     * Default constructor
     */
    public PaymentMode() {
    }

    //Getters
    public int getId_paymentMod() {
        return id_paymentMod;
    }
    public String getPaymentName() {
        return paymentName;
    }
    public String getClientAccess() {
        return clientAccess;
    }

    //Setters

}
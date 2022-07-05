package org.customer.Customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Offer {
    @Id
    private Integer offerId;
    private Integer callQty;
    private Integer cost;
    private Integer dataQty;
    private Integer duration;
    private String offerName;

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getCallQty() {
        return callQty;
    }

    public void setCallQty(Integer callQty) {
        this.callQty = callQty;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDataQty() {
        return dataQty;
    }

    public void setDataQty(Integer dataQty) {
        this.dataQty = dataQty;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, callQty, cost, duration, offerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return offerId.equals(offer.offerId);
    }
}

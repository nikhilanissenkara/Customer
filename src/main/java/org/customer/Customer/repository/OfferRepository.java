package org.customer.Customer.repository;

import org.customer.Customer.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OfferRepository extends JpaRepository<Offer,Integer> {
    @Query("select o from Offer o where  o.callQty=:callQty and o.dataQty=:dataQty")
    Offer findByCallQtyAndDataQty(@Param("callQty")Integer callQty,@Param("dataQty")Integer DataQty);
}

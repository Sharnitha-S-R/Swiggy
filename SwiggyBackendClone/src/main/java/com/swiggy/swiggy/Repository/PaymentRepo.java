package com.swiggy.swiggy.Repository;

import com.swiggy.swiggy.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    Optional<Payment> findById(Long id);
    List<Payment> findByPaymentStatus(String paymentStatus);
    Payment findByTransactionId(String transactionId);
    List<Payment> findByPaymentMethod(String paymentMethod);
    List<Payment> findByPaymentStatusAndPaymentMethod(String paymentStatus, String paymentMethod);
}

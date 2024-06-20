package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.Payment;
import com.swiggy.swiggy.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepo.findById(id);
    }
    public Payment updatePayment(Long paymentId, Payment updatedPayment) {
        Optional<Payment> paymentOptional = paymentRepo.findById(paymentId);
        if (paymentOptional.isPresent()) {
            Payment existingPayment = paymentOptional.get();
            existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());
            existingPayment.setTransactionId(updatedPayment.getTransactionId());
            existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
            return paymentRepo.save(existingPayment);
        } else {
            throw new IllegalArgumentException("Payment not found");
        }
    }
}

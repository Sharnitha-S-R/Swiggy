package com.swiggy.swiggy.Service;

import com.swiggy.swiggy.Entity.MenuItem;
import com.swiggy.swiggy.Entity.Payment;
import com.swiggy.swiggy.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
}

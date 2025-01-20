package ParkingLot.Parking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Payment {
    private String paymentId;
    private String ticketId;
    private PaymentStatus paymentStatus;
    private LocalDateTime initiatedDate;
    private double amount;

    public Payment(String paymentId , String ticketId , double amount )
    {
        this.paymentId = paymentId;
        this.ticketId = ticketId;
        this.amount = amount;
    }

    public void makePayment()
    {
        this.initiatedDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.SUCCESS;
    }
}

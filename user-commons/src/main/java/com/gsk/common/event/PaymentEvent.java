package com.gsk.common.event;

import com.gsk.common.entity.OrderRequestDto;
import com.gsk.common.entity.PaymentRequestDto;
import com.gsk.common.enums.OrderStatus;
import com.gsk.common.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class PaymentEvent implements Event{

    private UUID eventId = UUID.randomUUID();
    private Date date = new Date();

    private PaymentRequestDto paymentRequestDto;
    private PaymentStatus paymentStatus;

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public PaymentEvent(PaymentRequestDto paymentRequestDto, PaymentStatus paymentStatus) {
        this.paymentRequestDto = paymentRequestDto;
        this.paymentStatus = paymentStatus;
    }
}

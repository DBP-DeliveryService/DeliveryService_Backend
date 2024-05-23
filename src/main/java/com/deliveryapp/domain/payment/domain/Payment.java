package com.deliveryapp.domain.payment.domain;

import com.deliveryapp.domain.common.BaseEntity;
import com.deliveryapp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "method")
    private String method;

    @Column(name = "progress")
    private String progress;

    @Column(name = "payment_info")
    private String paymentInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Builder
    public Payment(String method, String progress, String paymentInfo, User user) {
        this.method = method;
        this.progress = progress;
        this.paymentInfo = paymentInfo;
        this.user = user;
    }
}

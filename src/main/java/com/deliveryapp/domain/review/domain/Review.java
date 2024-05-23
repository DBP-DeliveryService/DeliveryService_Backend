package com.deliveryapp.domain.review.domain;

import com.deliveryapp.domain.common.BaseEntity;
import com.deliveryapp.domain.order.domain.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review_content")
    private Integer reviewContent;

    @Column(name = "review_picture_url")
    private Integer reviewPictureUrl;

    @Column(name = "review_status")
    private Integer reviewStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}

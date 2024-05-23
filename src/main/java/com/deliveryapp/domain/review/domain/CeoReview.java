package com.deliveryapp.domain.review.domain;

import com.deliveryapp.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ceo_Review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CeoReview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "ceo_content")
    private String ceoContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
}

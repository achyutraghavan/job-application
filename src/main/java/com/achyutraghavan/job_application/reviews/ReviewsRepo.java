package com.achyutraghavan.job_application.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepo extends JpaRepository<Review, Long> {
}

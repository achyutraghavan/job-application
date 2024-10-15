package com.achyutraghavan.job_application.reviews;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
}

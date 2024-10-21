package com.achyutraghavan.job_application.reviews;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReviewById(Long reviewId);
    boolean updateReview(Long reviewId, Review review);
    boolean deleteReview(Long reviewId);
}

package com.achyutraghavan.job_application.reviews;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllReviews(Long companyId);
}

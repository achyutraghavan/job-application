package com.achyutraghavan.job_application.reviews.impl;

import com.achyutraghavan.job_application.reviews.Review;
import com.achyutraghavan.job_application.reviews.ReviewsRepo;
import com.achyutraghavan.job_application.reviews.ReviewsService;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewsServiceImpl implements ReviewsService {

    private ReviewsRepo reviewsRepo;

    public reviewsServiceImpl(ReviewsRepo reviewsRepo) {
        this.reviewsRepo = reviewsRepo;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews;
        reviews = reviewsRepo.findByCompanyId(companyId);
        return null;
    }
}

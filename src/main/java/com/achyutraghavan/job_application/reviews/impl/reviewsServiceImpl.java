package com.achyutraghavan.job_application.reviews.impl;

import com.achyutraghavan.job_application.company.CompanyService;
import com.achyutraghavan.job_application.reviews.Review;
import com.achyutraghavan.job_application.reviews.ReviewsRepo;
import com.achyutraghavan.job_application.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reviewsServiceImpl implements ReviewsService {

    private final ReviewsRepo reviewsRepo;

    public reviewsServiceImpl(ReviewsRepo reviewsRepo, CompanyService companyService) {
        this.reviewsRepo = reviewsRepo;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews;
        reviews = reviewsRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if (companyId != null) {
            review.setCompanyId(companyId);
            reviewsRepo.save(review);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewsRepo.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Optional<Review> reviewOptional = reviewsRepo.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review r = reviewOptional.get();
            r.setDescription(updatedReview.getDescription());
            r.setRating(updatedReview.getRating());
            r.setTitle(updatedReview.getTitle());
            r.setCompanyId(updatedReview.getCompanyId());
            reviewsRepo.save(r);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewsRepo.findById(reviewId).orElse(null);
        if (review!=null) {
            reviewsRepo.delete(review);
            return true;
        } else {
            return false;
        }
    }
}

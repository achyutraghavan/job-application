package com.achyutraghavan.job_application.reviews.impl;

import com.achyutraghavan.job_application.company.Company;
import com.achyutraghavan.job_application.company.CompanyService;
import com.achyutraghavan.job_application.reviews.Review;
import com.achyutraghavan.job_application.reviews.ReviewsRepo;
import com.achyutraghavan.job_application.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
public class reviewsServiceImpl implements ReviewsService {

    private final ReviewsRepo reviewsRepo;
    private final CompanyService companyService;

    public reviewsServiceImpl(ReviewsRepo reviewsRepo, CompanyService companyService) {
        this.reviewsRepo = reviewsRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews;
        reviews = reviewsRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewsRepo.save(review);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = getAllReviews(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }
}

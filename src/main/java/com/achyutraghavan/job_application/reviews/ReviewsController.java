package com.achyutraghavan.job_application.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewsService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean reviewAdded = reviewsService.addReview(companyId,review);
        return reviewAdded? new ResponseEntity<>("Review added successfully", HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review resReview = reviewsService.getReviewById(companyId, reviewId);
        return resReview != null? new ResponseEntity<>(resReview, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean reviewUpdated = reviewsService.updateReview(companyId, reviewId, review);
        return reviewUpdated ? new ResponseEntity<>("Review updated successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean reviewDeleted = reviewsService.deleteReview(companyId, reviewId);
        return reviewDeleted ? new ResponseEntity<>("Review deleted successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

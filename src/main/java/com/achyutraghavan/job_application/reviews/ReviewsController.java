package com.achyutraghavan.job_application.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewsService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean reviewAdded = reviewsService.addReview(companyId,review);
        return reviewAdded? new ResponseEntity<>("Review added successfully", HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Review resReview = reviewsService.getReviewById(reviewId);
        return resReview != null? new ResponseEntity<>(resReview, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        boolean reviewUpdated = reviewsService.updateReview(reviewId, review);
        return reviewUpdated ? new ResponseEntity<>("Review updated successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        boolean reviewDeleted = reviewsService.deleteReview(reviewId);
        return reviewDeleted ? new ResponseEntity<>("Review deleted successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

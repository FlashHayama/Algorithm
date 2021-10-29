#lang racket

(require rackunit rackunit/text-ui)

(define a 3)
(define b (+ a 1))

(run-tests
 (test-suite "Test ex 2.3"
   (check-equal? (= 2 3) #f)
   (check-equal? (= 3 3) #t)
   (check-equal? (= a b) #f)
   (check-equal? (not (or (= 3 4) (= 5 6))) #t)
   (check-equal? (+ 2 (if (> a b) a b)) 6)
 )
)
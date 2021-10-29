#lang racket

(require rackunit rackunit/text-ui)

(define a 3)
(define b (+ a 1))

(run-tests
 (test-suite "Test ex 2.3"
   (check-equal? 54 54)
   (check-equal? (+ 23 55) 78)
   (check-equal? (+ 23 44 99) 166)
   (check-equal? (+ 23 (- 55 44 33) (* 2 (/ 8 4))) 5)
   (check-equal? a 3)
   (check-equal? (/ 6 a) 2)
   (check-equal? (+ a b (* a b)) 19)
 )
)
#lang racket

(require rackunit rackunit/text-ui)

(define a 3)
(define b (+ a 1))

(run-tests
 (test-suite "Test ex 2.3"
   (check-equal? (if (= 1 1) "waaw" "brrr") "waaw")
   (check-equal? (if (= 4 4) 5 6) 5)
   (check-equal? (if (> a b) a b) b)
   (check-equal? (if (and (> b a) (< b (* a b))) b a) b)
   (check-equal? (+ 2 (if (> a b) a b)) 6)
   (check-equal? (* (cond ((> a b) a)
                          ((< a b) b)
                          (else -1))
                    (+ a 1)) 16)
 )
)

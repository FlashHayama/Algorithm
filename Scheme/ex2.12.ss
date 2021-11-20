#lang racket

(require rackunit rackunit/text-ui)

(let ((x 3))
  (let ((x (* x x))) (+ x x)))
(run-tests
 (test-suite "Test ex 2.12"
   (check-equal? (let ((x 3))
                   (let ((x (* x x))) (+ x x))) 18)
 )
)

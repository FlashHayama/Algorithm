#lang racket

(require racket/trace)

(define (fib x)
      (if (< x 2)
          1
          (+ (fib (- x 1)) (fib (- x 2)))))
(define (itfib x)
  (letrec ((while (lambda (y res1 res2)
                   (if (eq? y 1)
                       res2
                       (while (- y 1) res2 (+ res2 res1))))))
    (trace while)
    (while x 1 1)))

(itfib 6)

(trace fib)
(fib 6)
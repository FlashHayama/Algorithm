#lang racket

(define (fib n)
  (if (< n 2)
      (if (zero? n)
          0
          1
      )
      (+ (fib (- n 1)) (fib (- n 2)))
  )
)

(fib 1)
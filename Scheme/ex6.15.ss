#lang racket

(require racket/mpair)
(require compatibility/mlist)

(define (sum-vector v)
  (define l (vector-length v))
  (define (iter result i)
    (if (< i 0)
        result
        (begin
          (iter (+ result (vector-ref v i)) (- i 1))
        )
    )
  )
  (iter 0 (- l 1))
)

(sum-vector #(2 3 4 5 6))
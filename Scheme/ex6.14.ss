#lang racket

(require racket/mpair)
(require compatibility/mlist)

(define (fill-vector f n)
  (let
      (
       (vec (make-vector n))
      )
      (define (iter i)
        (if (>= i 0)
            (begin (vector-set! vec i (f (+ i 1)))
             (iter (- i 1)))
            (void)
        )
      )
    (iter (- n 1))
    vec
  )
)

(fill-vector (lambda (x) (* x x)) 5)
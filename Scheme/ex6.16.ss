#lang racket

(define (palyndrom lst)
  (let*
      (
       (len (length lst))
       (vec-len (- (* 2 len) 1))
       (vec (make-vector vec-len))
      )
    (define (iter i l)
      (if (eq? i len)
          (void)
          (begin
            (vector-set! vec i (car l))
            (vector-set! vec (- vec-len i 1) (car l))
          )
      )
    )
    (iter 0 lst)
    vec
  )
)
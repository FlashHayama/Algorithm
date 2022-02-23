#lang racket

(define (pell n)
  (cond
    ((eq? n 0) 0)
    ((eq? n 1) 1)
    (else (+ (* 2 (pell (- n 1))) (pell (- n 2))))
  )
)

(define (pellMemo n)
  (let
      (
       (h (make-hash))
      )
    (letrec
      (
        (pellValue
          (lambda (n)
            (hash-ref! h n (lambda ()))
          )
        )
      )
    )
  )
)

(pell 6)
#lang racket
(require rackunit rackunit/text-ui)

(define (exp1 b n)
  (if (eq? n 0)
      1
      (* b (exp1 b (- n 1)))
  )
)
(exp1 2 10)

(define (exp2 b n)
  (define (iter b n acc)
    (if (eq? n 0)
        acc
        (iter b (- n 1)(* b acc))
      )
     )
  (iter b n 1)
)
(exp2 2 10)

(run-tests
 (test-suite "Test exp"
   (check-equal? (exp2 2 10) 1024)
 )
)
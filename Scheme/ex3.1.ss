#lang racket

(require racket/trace)

(define (fact x)
  (if (= x 0)
      1
      (* x (fact (- x 1)))
      ))
(trace fact)
(fact 5)

(define (tFact x)
  (define (while counter result)
    (if (= counter 0)
        result
        (while (- counter 1) (* result counter))))
  (trace while)
  (while x 1))
(trace tFact)
(tFact 5)
#lang racket

(require racket/mpair)
(require compatibility/mlist)

(define (swap a b)
  (let ((temp a))
    (begin (set! a b)
           (set! b temp))))

(swap 5 9)

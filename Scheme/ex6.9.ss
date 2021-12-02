#lang racket

(require racket/mpair compatibility/mlist)

(define (mylength lst)
  (define (loop l acc)
    (if (or (eq? (mcdr l) '()) (eq? (mcdr l) lst))
        acc
        (loop (mcdr l) (+ acc 1))
    )
  )
  (loop lst 1)
)
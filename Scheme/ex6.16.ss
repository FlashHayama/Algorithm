#lang racket

(require racket/mpair)
(require compatibility/mlist)

(define (palyndrome lst)
  (let*
      (
       (l (length lst))
       (lvec (if (odd? l) (* l 2) (- (* l 2) 1)))
       (vec (make-vector lvec))
       (vec2 (list->vector lst))
      )
    lvec
  )
)

(palyndrome '(r a c e))
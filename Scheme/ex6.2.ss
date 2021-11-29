#lang racket

(require racket/mpair)
(require compatibility/mlist)

(define (maff l)
  (define (print v)
    (display v)
    (display " ")
  )
  (display "( ")
  (mmap print l)
  (display ")")
)

(define l (mlist 'allo 'a 'u112 'i))
(maff l)
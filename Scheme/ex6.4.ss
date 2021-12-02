#lang racket

(require racket/mpair compatibility/mlist)

(define (list-set! l i v)
  (define (loop l i)
    (cond
      ((null? l) (void))
      ((eq? i 0) (set-mcar! l v))
      (else (loop (mcdr l) (- i 1)))
    )
  )
  (if (and (integer? i) (>= i 0))
      (loop l i)
      (void)
  )
)

(define a-list (mlist 1 2 3 4 5))
(display a-list)(newline)
(list-set! a-list 3 "tom")
(display a-list) (newline)
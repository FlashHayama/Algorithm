#lang racket

(require racket/mpair compatibility/mlist)

(define (make-list v)
  (let*
      (
       (a (mcons v '()))
       (b (mcons a '()))
       (c (mcons b b))
      )
    c
  )
)

(define lst (make-list 3))
(display lst)(newline)


(define (addFirst l v)
  (let*
      (
       (a (mcons v '()))
       (b (mcons a (mcar l)))
      )
    (set-mcdr! (mcar (mcar l)) b)
    (set-mcar! l b)
    l
  )
)

(display (addFirst lst 2))(newline)
(display (addFirst lst 1))(newline)

(define (addLast l v)
  (let*
      (
       (a (mcons v (mcdr l)))
       (b (mcons a '()))
      )
    (set-mcdr! (mcdr l) b)
    (set-mcdr! l b)
    l
  )
)

(display (addLast lst 4))(newline)

(define (first l)
  (mcar (mcar (mcar l)))
)

(first lst)

(define (last l)
  (mcar (mcar (mcdr l)))
)

(last lst)

(define (value e)
  (mcar (mcar e))
)

(define (next e)
  (void)
)

(define (previous e)
  (void)
)

(define (first? e)
  (void)
)

(define (last? e)
  (void)
)
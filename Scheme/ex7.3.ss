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

(define (first l)
  (mcar l)
)

(define (last l)
  (mcdr l)
)

(define (value e)
  (mcar (mcar e))
)

(define (next e)
  (if (last? e)
      '()
      (mcdr e)
  )
)

(define (previous e)
  (if (first? e)
      '()
      (mcdr (mcar e))
  )
)

(define (first? e)
  (if (eq? (mcdr (mcar e)) '())
      #t
      #f
  )
)

(define (last? e)
  (if (eq? (mcdr e) '())
      #t
      #f
  )
)

(define (display-forward l)
  (define (loop acc)
    (if (last? acc)
        (begin
          (display (value acc))
          (newline)
        )
        (begin
          (display (value acc))
          (display " -> ")
          (loop (next acc))
        )
    )
  )
  (loop (first l))
)

(define (display-backward l)
  (define (loop acc)
    (if (first? acc)
        (begin
          (display (value acc))
          (newline)
        )
        (begin
          (display (value acc))
          (display " <- ")
          (loop (previous acc))
        )
    )
  )
  (loop (last l))
)

(define lst (make-list 3))
(display lst)(newline)

(display (addFirst lst 2))(newline)
(display (addFirst lst 1))(newline)

(display (addLast lst 4))(newline)

(display-forward lst)
(display-backward lst)
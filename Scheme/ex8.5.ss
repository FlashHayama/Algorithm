#lang racket

(require (lib "defmacro.ss"))

(define head car)
(define (tail stream)
  (force (cdr stream)))

(define-macro cons-stream
;; delay evaluation until needed
  (lambda (a b)
    '(cons ,a (delay ,b))))

(define (nth-stream n s)
  (if (eq? n 0)
      s
      (nth-stream (- n 1) s)
  )
)

(define (nth-value n s)
  (if (eq? n 0)
      (head s)
      (nth-value (- n 1) s)
  )
)
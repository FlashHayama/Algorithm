#lang racket

(define x 1)
(define y 2)
(define (f x y)
  (let ((x y) (y x))
    (begin
      (display x)
      (display y))))
(f 3 4)

(define (f2 x y)
  (let* ((x y) (y x))
    (begin
      (display x)
      (display y))))
(f2 3 4)
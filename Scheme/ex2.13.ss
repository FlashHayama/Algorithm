#lang racket

(let* ((x 1) (y (* 2 x)))
  (+ x y))

(letrec ((x 1) (y (* 2 x)))
  (+ x y))

(let ((x 1) (y (* 2 x)))
  (+ x y))
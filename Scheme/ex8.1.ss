#lang racket

(require (lib "defmacro.ss"))

(define-macro def
  (lambda x (cons define x))
)
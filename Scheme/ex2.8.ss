#lang racket

(define (celcius->fahrenheit t)
  (- (* (+ t 40) 1.8) 40)
)
(define (fahrenheit->celcius t)
  (- (/ (+ t 40) 1.8) 40)
)
(define (conversion unit temperature)
  (cond ((eq? unit "celcius") (fahrenheit->celcius temperature))
        ((eq? unit "fahrenheit") (celcius->fahrenheit temperature))
        (else (display "Unit incorect"))
  )
)

(conversion "celcius" 40)
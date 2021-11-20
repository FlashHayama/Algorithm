#lang racket

(define (test)
  (letrec
      ((pair? (lambda (n)
                (if (integer? n)
                    (if (= n 0)
                        #t
                        (impair? (- n 1)))
                    "Vous n'avez pas fourni un nombre entier")))
       (impair? (lambda (n)
                  (if (integer? n)
                      (if (= n 0)
                          #f
                          (pair? (- n 1)))
                      "Vous n'avez pas fourni un nombre entier"))))
    (begin
      (display (pair? 5))
      (display (impair? 5))
      (display (pair? 6))
      (display (impair? 6)))))
(test)
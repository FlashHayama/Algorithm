((lambda (y) 1) ((lambda (x) (x x)) (lambda (x) (x x)))

((lambda (y) 1)
 ((lambda (x)
    (lambda (t)(x x)t))
  (lambda (x)
    (lambda (t)(x x)t))))
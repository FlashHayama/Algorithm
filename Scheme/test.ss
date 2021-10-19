(let (
      (a 1)
      (b 2))
  (+ a b)
)

(let* (
      (a 1)
      (b a))
  (+ a b)
)

(((lambda (a)
   (lambda (b) (+ a b)))1)2)

((lambda (a b)
   (+ a b)) 1 2)

(letrec (
         (fac (lambda (n)
                (if (= n 0)
                    1
                    (+ n (fac (- n 1))))))
         )
  (fac 5)
)
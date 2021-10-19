(display "#test pair fonction#\n")
(define p (cons 1 2))
(cons 1 2)
(car p)
(cdr p)

(display "#test logic fonction#\n")
(and (= 2 2) (> 3 2))
(or (< 3 2) (<= 12 3))
(not #t)
(display "#test eq fonction#\n")
(eq? 'a 'a)
(eq? 'a 'b)
(display "#test symbol fonction#\n")
(symbol? 'a)
(symbol? 2)
(display "#test char fonction#\n")
(char? #\a)
(char? 'a)
(char=? #\a #\a)
(char<? #\a #\b)(char>? #\b #\a)

(list? (cons 1 '()))
(define l (cons 1 (cons 2 (cons 3 (cons 4 '())))))
l
(define l1 (list 1 2 3 4))
l1
(define l2 '(1 2 3 4))
l2
(list? l)(list? l1)(list? l2)
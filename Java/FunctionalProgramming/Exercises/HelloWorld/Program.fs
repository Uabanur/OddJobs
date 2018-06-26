let rec f = function
            | 0 -> 0
            | n -> n + f(n-1)

let rec sum = function
            | (m, 0) -> m
            | (m, n) -> m + n + sum(m, n-1)

let rec bin = function
            | (n, k) when k=0||n=k -> 1
            | (n, k) when n<>0&&k<>0&&n>k-> bin(n-1, k-1) + bin(n-1, k)
            | (_,_) -> failwith "Invalid input"

let rec multiplicity = function
                    | (_, []) -> 0
                    | (n, x::xs) when n=x-> 1 + multiplicity (n, xs)
                    | (n,x::xs) -> multiplicity (n, xs)

let rec mulC (n, list) = 
                match list with
                | [] -> []
                | x::xs -> n*x :: mulC(n, xs)

let rec addE = function 
            | (x, []) -> x
            | ([], y) -> y
            | (x::xs, y::ys) -> x+y::addE(xs, ys)


let mulX pol = 0::pol

let rec mul = function
            | ([], _) -> []
            | (x::xs, q) -> addE(mulC(x, q), mulX(mul(xs, q)))

let xer x = x + "*x"

let rec printer = function
                    | (_,[]) -> ""
                    | (n, x::xs) when x=0 -> printer(n+1, xs)
                    | (n, x::xs) when n=0 -> string(x) + " + " + printer(n+1, xs)
                    | (n,x0::x1::xs) -> string(x0) + "x^" + string(n) + " + " + printer(n+1, x1::xs)
                    | (n, x::xs) -> string(x) + "x^" + string(n)

let print x = printer (0, x)                


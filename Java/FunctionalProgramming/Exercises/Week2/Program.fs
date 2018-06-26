

let f = function
        | n when n % 5 = 0 -> false
        | n when n % 2 = 0 || n % 3 = 0 -> true 
        | _ -> false

let rec pow (s, n) = match n with
                      | 0 -> ""
                      | n -> s + pow(s , n-1)

let rec evenN n = [0..2..n]

let rec split ls = match ls with 
                    | [] -> ([],[])
                    | x::xs -> let (ls1, ls2) = split xs 
                               (x::ls2, ls1)

let rec zip tpl = match tpl with
                   | (x::xs, y::ys) -> (x,y)::zip(xs,ys)
                   | ([],[]) -> []
                   | _ -> failwith("Unequal lengths")

let rec sum p lst = match lst with
                    | []                -> 0
                    | x::xs when p x   -> x + sum p xs
                    | x::xs             -> sum p xs

let rec count (xs, x) = match xs with 
                         | h::tail when h < x -> count (tail, x)
                         | h::tail when x = h -> 1 + count (tail, x)
                         | _ -> 0

let rec insert (xs, x) = match xs with 
                          | []      -> [x]
                          | h::tail when h < x -> h::insert(tail, x)
                          | h::tail -> x::xs

let rec intersect (xs, ys) = match (xs, ys) with
                             | (x::xs, y::ys) when x=y  -> x::intersect(xs,ys)
                             | (x::xs, y::ys) when x<y  ->    intersect(xs,y::ys)
                             | (x::xs, y::ys)           ->    intersect(x::xs,ys)
                             |  _ -> []

let rec plus (lst1, lst2) = match (lst1, lst2) with
                            | ([],_)                    -> lst2
                            | (_,[])                    -> lst1
                            | (x::xs, y::ys) when x < y -> x::plus(xs,lst2)
                            | (x::xs, y::ys)            -> y::plus(lst1, ys)

let rec minus (lst1, lst2) = match (lst1, lst2) with 
                               | (x::xs, y::ys) when x=y ->    minus(xs, ys)
                               | (x::xs, y::ys) when x<y -> x::minus(xs, y::ys)
                               | (x::xs, y::ys)          ->    minus(x::xs, ys) 
                               | ([],_) -> []
                               | (_,[]) -> lst1

let rec mergeSort  = function 
                     | [x] -> [x]
                     | lst -> let (ls1, ls2) = split lst
                              plus (mergeSort ls1, mergeSort ls2)

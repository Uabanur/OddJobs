




let rec repeat str = function 
                | 0 -> ""
                | n -> str + repeat str (n-1)

let rec f s1 s2 n = match n with
                    | 0 -> ""
                    | 1 -> s1
                    | n -> s1 + "\n" + f s2 s1 (n-1)



let viz m n =  f (repeat "XO" m) (repeat "OX" m) n

let rec f i = function
                | [] -> []
                | x::xs -> (x+i)::f (i*i) xs

let rel = [(1, ["a"; "b"; "c"]); (4,["b"; "e"])]

let rec apply a = function 
                | (x,_)::tail when x<>a -> apply a tail
                | (x,rel)::tail when x=a -> rel @ (apply a tail)
                | _ -> []

let rec check e = function
                | [] -> false
                | x::xs when x=e -> true
                | x::xs -> check e xs



let inRelation x y rel = check y (apply x rel)

let rec insert x y rel = match rel with
                         | [] -> [(x, [y])]
                         | (k, tail)::rest when x=k -> (k,y::tail)::rest
                         | head::rest -> head::insert x y rest


let rec toRel = function 
            | [] -> []
            | (a, b)::rest -> insert a b (toRel rest)


let rec repeatList lst = function 
                            | 0 -> []
                            | n -> lst @ repeatList lst (n-1)


let rec merge (lst1, lst2) = match (lst1, lst2) with
                             | ([], _) -> lst2
                             | (_, []) -> lst1
                             | (x::xs, ys) -> x::merge(ys, xs)


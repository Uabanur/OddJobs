type Solution = 
            | TWO_ROOTS of float*float
            | ONE_ROOT of float
            | ZERO_ANSWERS

let solve (a,b,c) =  let d:float = b*b-4.0*a*c
                     match d with
                     | d when d<0.0 -> ZERO_ANSWERS
                     | d when d=0.0 -> ONE_ROOT(-b/(2.0*a))
                     | d            -> TWO_ROOTS((-b+sqrt(d))/(2.0*a), (-b-sqrt(d))/(2.0*a))



let rev xs = List.fold (fun xs x -> x::xs) [] xs

let revrev lsts = List.fold (fun lst elm -> (rev elm)::lst) [] lsts

let sum p xs = List.foldBack (fun x s -> x+s) (List.filter p xs) 0


let areNb m (c1, c2) = List.exists (fun (x1,x2) -> (x1=c1 && x2=c2) || (x1=c2 && x2=c1)) m

let canBeExtBy m col c = List.forall (fun c' -> not (areNb m (c, c'))) col


// NOPE
let rec extColouring m cols c =
        match cols with
        | []         -> [[c]]
        | col::cols' -> if canBeExtBy m col c
                        then (c::col)::cols'
                        else col::extColouring m cols' c


let countries m = List.distinct(List.foldBack (fun (x,y) akk -> x::y::akk) m [])

let colCntrs m = List.foldBack (fun c cols -> extColouring m cols c) (countries m) []


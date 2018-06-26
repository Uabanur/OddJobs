

let rec areNbBetter m c1 c2 = match m with
                         | (a1, a2)::rest when c1=a1 && c2=a2-> true
                         | (a1, a2)::rest when c1=a2 && c2=a1-> true
                         | _::rest -> areNbBetter rest c1 c2
                         | _ -> false


type Country    = string
type Map        = (Country * Country) list
type Colour     = Country list
type Colouring  = Colour list
let exMap:Map = [("a","b"); ("c","d"); ("d","a")]

let rec isMember x = function
                     | h::tail when x=h -> true
                     | _::tail -> isMember x tail
                     | _ -> false

let areNb m c1 c2 = isMember (c1,c2) m || isMember (c2,c1) m

let rec canBeExtBy m col c =
    match col with
    | []       -> true
    | c'::col' -> not(areNb m c' c) && canBeExtBy m col' c


let rec extColouring m cols c =
        match cols with
        | []         -> [[c]]
        | col::cols' -> if canBeExtBy m col c
                        then (c::col)::cols'
                        else col::extColouring m cols' c

let addElem x ys = if isMember x ys then ys else x::ys

let rec countries = function
                      | []           -> []
                      | (c1,c2)::m -> addElem c1 (addElem c2 (countries m))

let rec colCntrs m = function
      | []    -> []
      | c::cs -> extColouring m (colCntrs m cs) c

let colMap m = colCntrs m (countries m)

let colMap2 m = 
        let areNb2 c1 c2 = isMember (c1,c2) m || isMember (c2,c1) m

        let rec canBeExtBy2 col c =
            match col with
            | []       -> true
            | c'::col' -> not(areNb2 c' c) && canBeExtBy2 col' c

        let rec extColouring2 cols c =
             match cols with
             | []         -> [[c]]
             | col::cols' -> if canBeExtBy2 col c
                             then (c::col)::cols'
                             else col::extColouring2 cols' c

        let addElem2 x ys = if isMember x ys then ys else x::ys

        let rec countries2 = function
                              | []           -> []
                              | (c1,c2)::m -> addElem2 c1 (addElem2 c2 (countries2 m))

        let rec colCntrs2 = function
              | []    -> []
              | c::cs -> extColouring2 (colCntrs2 cs) c

        colCntrs2 (countries m)



type Person = {nr:string; sex:string; yob:int; toi:string list}

type Reg = Person list


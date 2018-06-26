
type Rule = String   
type Rules = [Rule]
type KB = [(Rule,Rules)]
type Pool = Rules

main = print (backwardCheck kb pool "br")
        where 
            kb = [
                 ("br", ["ho", "ju", "fo"]),
                 ("br", ["ho", "fo"]),
                 ("ho", ["co", "cr"]),
                 ("ho", ["te"]),
                 ("fo", ["to", "bu"]),
                 ("fo", ["eg"])
                 ]
            pool = [
                 "co",
                 "te",
                 "to",
                 "bu"
                 ]

backwardCheck :: KB -> Pool -> Rule -> Bool
backwardCheck kb pool r = elem r pool || 
                          or [not (null x) && and (map(backwardCheck kb pool) x) | x <- (dep r kb)]

dep :: Rule -> KB -> [Rules]
dep r kb = [snd x | x <- kb, fst x == r]

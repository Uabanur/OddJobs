
import Debug.Trace

type Rule = String   
type Rules = [Rule]
type KB = [(Rule,Rules)]
type Pool = Rules

main = print (forwardCheck kb pool "br")
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

forwardCheck :: KB -> Pool -> Rule -> Bool
forwardCheck kb pool r = trace ("Pool:" ++ (show pool)) (elem r pool) ||
                         let newPool = union pool [fst x | x <- kb, and [elem dep pool | dep <- snd x]]
                         in length newPool /= length pool && forwardCheck kb newPool r

union :: [String] -> [String] -> [String]
union list1 list2 = if null list1 then list2
                    else if elem (head list1) list2 
                         then union (tail list1) list2
                         else union (tail list1) ((head list1) : list2)
type Name = string
type Flow = int // can be assumed positive in below questions
type River = R of Name * Flow * Tributaries
and Tributaries = River list


//1 
let riv3:River = R("R3", 8, [])

let riv:River = R("R", 10, [
                           R("R1",  5, []);
                           R("R2", 15, [R("R4", 2, [])]);
                           riv3
                           ])

//2 function of type Name -> River -> bool
// Checks if a river with the given name exists in the river datastructure
let rec contains name (R(n, _, t)) = name = n || List.exists (contains name) t

// Testing contains function
let testContainsTrue = contains "R3" riv3 = true
let testContainsFalse = contains "R2" riv3 = false
let testContainsChildName = contains "R4" riv = true



//3 function of type River -> Name list
//  Returns a list of names corresponding to the rivers in the datastructure
let rec allNames (R(n, _, t)) = n::List.foldBack (fun r lst -> (allNames r)@lst) t []

// Testing allNames function
let testAllNamesSingleRiver = allNames riv3 = ["R3"]
let testAllNamesRiverTree = allNames riv = ["R";"R1";"R2";"R4";"R3"]


//4 function of type River -> Flow
//  Returns the net flow of the total river.
let rec totalFlow (R(_, f, t)) = List.foldBack (fun r sum -> totalFlow r + sum) t f

// Testing totalFlow function
let testTotalFlowSignleriver = totalFlow riv3 = 8
let testTotalFlowRiverTree = totalFlow riv = 40

//5 function of type River -> Name * Flow
// Searches the river datastructure for the largest flow, returns the corresponding name and flow of found river
let rec mainSource (R(n, f, t)) = let folder = fun r (sn,sf) -> let (sn',sf') = mainSource r 
                                                                if (sf' > sf) then (sn',sf') else (sn,sf) 
                                  List.foldBack folder t (n,f)

// Testing mainSource function
let testMainSourceSingleRiver = mainSource riv3 = let (R(n,f,_)) = riv3 in (n,f)
let testMainSourceRiverTree = mainSource riv = ("R2", 15)                                              


//6 auxillary function of type Name -> River -> River -> River
// The function inserts the river (t) as tributary of the river with the given name.
// If no river is found, the original river datastructure is returned.
let rec Insert name t (R(rn, rf, rt)) = if (name=rn) then (R(rn, rf, t::rt)) 
                                        else 
                                            let folder = fun r ts -> (Insert name t r)::ts
                                            R(rn, rf, List.foldBack folder rt [] )

// Testing Insert function
let testInsertNameExists = Insert "R4" (R("T", 2, [])) riv = (R("R", 10, [
                                                                           R("R1",  5, []);
                                                                           R("R2", 15, [R("R4", 2, [R("T",2,[])])]);
                                                                           riv3
                                                                           ]))
let testInsertNameDoesNotExist = Insert "No" (R("T",2, [])) riv = riv


//6 function of type Name -> River -> River -> River option
// If the given name does not exist in the given river datastructure, the function returns None
// Otherwise the function returns a new river option after inserting the tributary with 'Insert'.
let rec tryInsert name t r = if (contains name r) then Some(Insert name t r) else None

// Testing tryInsert function
let testTryInsertNameExists = tryInsert "R4" (R("T", 2, [])) riv = Some(R("R", 10, [
                                                                           R("R1",  5, []);
                                                                           R("R2", 15, [R("R4", 2, [R("T",2,[])])]);
                                                                           riv3
                                                                           ]))
let testTryInsertNameDoesNotExist = tryInsert "No" (R("T",2, [])) riv = None


// In order to verify that all tests evaluated to true, an combinating variable is defined: allTests
                    
                    //contains function
let allTests =      testContainsTrue            &&  testContainsFalse       &&  testContainsChildName   &&
                    
                    //allNames function
                    testAllNamesSingleRiver     &&  testAllNamesRiverTree                               &&

                    //totalFlow function
                    testTotalFlowSignleriver    &&  testTotalFlowRiverTree                              &&

                    //mainSource function
                    testMainSourceSingleRiver   &&  testMainSourceRiverTree                             &&

                    //Insert auxillary function
                    testInsertNameExists        &&  testInsertNameDoesNotExist                          &&

                    //tryInsert function
                    testTryInsertNameExists     &&  testTryInsertNameDoesNotExist


// Initial types
type Outcome    =   | S | F // S: for success and F: for failure
type Sample     =   Outcome list
type ProbTree   =   | Branch of string * float * ProbTree * ProbTree
                    | Leaf of string

// Test probability tree
let exp = Branch(">2",0.67, Branch(">3",0.5, Leaf "A", Leaf "B"), Branch(">3",0.5, Leaf "C", Leaf "D"))


// 1)
    // Checks if roof has a correct probability and calls recursively on subtrees. 
    // type: ProbTree -> bool
let rec probOK tree = match tree with
                          | Leaf _ -> true
                          | Branch(_,p,tl,tr) -> 0.0 <= p && p <= 1.0 && probOK tl && probOK tr

// Test on sample data
let probOKtest = probOK exp = true


// 2)
    //Type : Sample * ProbTree -> bool
let rec isSample (os:Sample, t:ProbTree) = 
                        match os, t with
                           | [], Leaf _ -> true
                           | _ , Leaf _ -> false
                           | [], Branch _ -> false
                           | head::rest, Branch(_,_,tl,tr) -> match head with 
                                                                      | S -> isSample (rest, tl)
                                                                      | F -> isSample (rest, tr)

// Test on sample data
let isSampleTest = isSample ([S;S], exp) = true

//3) 
    // Type and function for descriptions. 
type Description = (Outcome*string) list * float * string

    // Checks if sample is valid, returns exception if not.
let rec descriptionOf os t = if not(isSample (os,t)) 
                             then failwith "Sample is not correct"
                             else validDescriptionOf os t

    // Uses the fact, that sample is valid. Builds up description
and validDescriptionOf os t = match (os, t) with
                               | [], Leaf l -> ([],1.0,l)
                               | o::os', Branch(ds, p, tl, tr) -> 
                                                 match o with 
                                                       | S -> let (lst', p', l') = validDescriptionOf os' tl
                                                              ((o,ds)::lst',p*p',l')
                                                       | F -> let (lst', p', l') = validDescriptionOf os' tr
                                                              ((o,ds)::lst',(1.0-p)*p',l')
                               | _ -> failwith "unreachable error for inference completeness"

// Test on sample data
let descriptionOfTest = descriptionOf [S;S] exp = ([(S, ">2"); (S, ">3")], 0.335, "A")

// 4)
    // auxillary function for allDescriptions. Finds all possible samples for the probtree
let rec generateOsSet t = match t with  
                                | Leaf _ -> [[]]: Sample list
                                | Branch(sd, p, tl, tr) -> let samplesl = generateOsSet tl
                                                           let samplesr = generateOsSet tr
                                                           let folder (o:Outcome)  (s:Sample) (lst:Sample list) = (o::s)::lst 
                                                           (List.foldBack (folder S )  samplesl [] ) @ (List.foldBack (folder F ) samplesr [])

    //Uses foldback to generate a description of all samples found by the auxillary function and accumulate them in a set
let allDescriptions t = List.foldBack (fun s sset -> Set.add (descriptionOf s t) sset) (generateOsSet t) Set.empty


// 5) 
    //Adds all probabilities from found descriptions where the predicate is satisfied on the leaf's string.
let probabilityOf t p = Set.fold (fun sum (_,prob,s) -> if p s then sum+prob else sum) 0.0 (allDescriptions t)

//Testing allDescriptions and probabilityOf on sample data
let descANDprobTest = probabilityOf exp (fun r -> r="A" || r="B"|| r="C") = 0.835

// 6)
    //Calculating the probability of samples leading to leaves annotated with either "B" or "C" 
    //is done using the function probabilityOf given the predicate (fun s -> s="B" || s="C")
    //Since there is a 2/3 * 1/2 = 1/3 probability of a sample leading to "B" 
    //and a probability of 1/3 * 1/2 = 1/6 of a sample leading to "C"
    //The total probability of samples leading to either of them is 1/3 + 1/6 = 3/6 = 1/2.

let probforBorC = probabilityOf exp (fun s -> s="B"||s="C") = 0.5;;

    //We see that the test probforBorC evaluates to true, showing that probabilityOf can be used to evaluate
    //the probability of samples leading to leaves annotated with either "B" or "C".


let alltests = probOKtest && isSampleTest && descriptionOfTest && descANDprobTest && probforBorC
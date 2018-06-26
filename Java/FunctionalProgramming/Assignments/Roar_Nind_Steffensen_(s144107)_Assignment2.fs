
// First we define the initial types as outlined in the assignment
type CourseNo       = int
type Title          = string
type ECTS           = int
type CourseDesc     = Title * ECTS
type CourseBase     = Map<CourseNo, CourseDesc>




// The isValidCourseDesc function is implemented as type: CourseDesc -> bool
// The function checks if the etcs points in the descripting is a positive (assumed nonzero) multiple of 5.
let isValidCourseDesc (desc:CourseDesc) = match desc with (_, etcs) -> etcs > 0 && etcs % 5 = 0;

// Testing the isValidCourseDesc function
let testDescSmall               = ("Small Course", 5)   :CourseDesc

let testDescNegative            = ("Fail", -10)         :CourseDesc
let testDescNotMultipleOfFive   = ("Fail", 2)           :CourseDesc

let testVcdCorrect1             = isValidCourseDesc testDescSmall               = true
let testVcdNegative             = isValidCourseDesc testDescNegative            = false
let testVcdNotMultipleOfFive    = isValidCourseDesc testDescNotMultipleOfFive   = false




// The isValidCourseBase function is implemented using the higher-order function Map.forall.
// With the type: CourseBase -> bool
// The function evaluates if isValidCourseDesc is satisfied on all elements in the CourseBase.
let isValidCourseBase (cb:CourseBase) = Map.forall (fun key desc -> isValidCourseDesc desc) cb

// Testing the isValidCourseBase function
let testDescMedium1 = ("Medium Course", 10)             :CourseDesc
let testDescMedium2 = ("Another Medium Course", 10)     :CourseDesc
let testDescLarge1  = ("Large Course",  15)             :CourseDesc
let testDescLarge2  = ("Another Large Course", 15)      :CourseDesc
let testcb          = Map.ofList [(1,testDescSmall);
                                  (2,testDescMedium1);
                                  (3,testDescMedium2);
                                  (4,testDescLarge1);
                                  (5,testDescLarge2)]    :CourseBase

let testVcbCorrect  = isValidCourseBase testcb = true

let testVcbEmpty    = let cb = Map.empty
                      isValidCourseBase cb = true

let testVcbNegative = let cb = testcb.Add (4,testDescNegative)
                      isValidCourseBase cb = false

let testVcbNotMultipleOfFive = let cb = testcb.Add (4,testDescNotMultipleOfFive)
                               isValidCourseBase cb = false




// The next types of the assignment are then implemented
type Mandatory      = Set<CourseNo>
type Optional       = Set<CourseNo>
type CourseGroup    = Mandatory * Optional




// The disjoint function is implemented using the higher-order function Set.intersect
// With the type: Set<'a> -> Set<'a> -> bool
// The function evaluates if the two elements are disjoint by checking that the intersect is empty.
let disjoint s1 s2 = Set.intersect s1 s2 = Set.empty

// Testing the disjoint function
let testDjCorrect   = disjoint (Set.ofList [1;2;3]) (Set.ofList [4]) = true
let testDjWrong     = disjoint (Set.ofList [1;2;3]) (Set.ofList [3]) = false




// The sumECTS function is implemented using the higher-order function Set.foldBack
// With the type: Set<CourseNo> -> CourseBase -> int
// The function extracts the ects points of all course numbers in the set from the coursebase and returns the sum.
let sumECTS (cs:Set<CourseNo>) (cb:CourseBase) = Set.foldBack (fun key sum -> sum + snd (cb.Item key)) cs 0

// Testing the sumECTS function
let testSumECTS = sumECTS (Set.ofList [1;2;3]) testcb = 25




// The isValidCourseGroup function is implemented as follows
// With the type: CourseGroup -> CourseBase -> bool
// The function evaluates if the course group is valid by checking that:
                                //the sets of mandatory and optional courses are disjoint
                                //if the sum of mandatory ects points is equal to 45, there are no optional courses
                                //the sum of mandatory ects points is not larger than 45 points
                                //the total sum of mandatory and optional points is not smaller than 45 points.

let isValidCourseGroup (cg:CourseGroup) (cb:CourseBase) = 
                    match cg with man, opt -> 
                                  disjoint man opt &&
                                    let mansum = sumECTS man cb
                                    let optsum = sumECTS opt cb
                                    (if mansum = 45 then opt.IsEmpty else mansum < 45) &&
                                    mansum + optsum >= 45

// Testing the isValidCourseGroup function
let testcg          = ((Set.ofList [1;2]), (Set.ofList [4;5]))      :CourseGroup

let testVcgCorrect      = isValidCourseGroup testcg testcb = true

let testVcgTooLittle    = let cg = ((Set.ofList [1;2]), (Set.ofList [4]))
                          isValidCourseGroup cg testcb = false

let testVcgLarge        = let cg = ((Set.ofList [1;2]), (Set.ofList [3;4;5]))
                          isValidCourseGroup cg testcb = true

let testVcgNotDisjoint  = let cg = ((Set.ofList [1;2;4]), (Set.ofList [4]))
                          isValidCourseGroup cg testcb = false




// The next types of the assignment are then implemented
type BasicNaturalScience        = CourseGroup
type TechnologicalCore          = CourseGroup
type ProjectProfessionalSkill   = CourseGroup
type Elective                   = CourseNo -> bool
type FlagModel                  = BasicNaturalScience * TechnologicalCore * ProjectProfessionalSkill * Elective
type CoursePlan                 = Set<CourseNo>




// The isValid function is implemented using the higher-order function Set.union and Set.forall
// With the type: FlagModel -> CourseBase -> bool (Unfortunately, the subtypes of FlagModel are shown when evaluating)
// The function evaluates if the course groups in the flag model are valid, 
                        //if the coursegroups are disjoint 
                        //and that they all courses satisfy the elective predicate

let isValid (fm:FlagModel) (cb:CourseBase) = 
                match fm with bns, tc, pps, ep -> 
                                isValidCourseGroup bns cb &&
                                isValidCourseGroup tc cb  &&
                                isValidCourseGroup pps cb && 
                                let bnslst, tclst, ppslst = Set.union (fst bns) (snd bns), 
                                                            Set.union (fst tc ) (snd tc ),
                                                            Set.union (fst pps) (snd pps)
                                disjoint bnslst tclst  &&
                                disjoint tclst ppslst  &&
                                disjoint ppslst bnslst &&
                                Set.forall ep bnslst   &&
                                Set.forall ep tclst    &&
                                Set.forall ep ppslst

// Testing the isValid function

let fullcb = Map.ofList [(1, testDescSmall);
                         (2, testDescMedium1);
                         (3, testDescMedium2);
                         (4, testDescLarge1);
                         (5, testDescLarge2);
                         (6, ("#1 30 point course", 30));
                         (7, ("#2 30 point course", 30));
                         (8, ("#3 30 point course", 30));
                         (9, ("#4 30 point course", 30));
                         (10,("#1 45 point course", 45))]   :CourseBase

let bns = (Set.ofList [6]),(Set.ofList [4])  :CourseGroup
let tc  = (Set.ofList [7]),(Set.ofList [5])  :CourseGroup
let pps = (Set.ofList [10]),(Set.ofList [])  :CourseGroup

let testVcorrect       = isValid (bns,tc,pps,(fun c -> c <= 10)) fullcb                                 = true
let testVtooFewPoints  = isValid (bns,tc,((Set.ofList [1]),(Set.ofList [])), (fun _ -> true)) fullcb    = false
let testVNotdisjoint   = isValid (bns,tc,((Set.ofList [4]),(Set.ofList [])), (fun _ -> true)) fullcb    = false
let testVUnsatisfiedEp = isValid (bns,tc,pps, (fun c -> c<10)) fullcb                                   = false





// The checkPlan function is implemented using the higher-order function Set.forall and Set.union
// With the type: CoursePlan -> FlagModel -> CourseBase -> bool (Same problem with FlagModel subtypes)
// The function evaluates if the course plan is valid by checking that:
                                //the flagmodel is valid,
                                //the sum of ects points in the plan is 180
                                //all courses in the plan satisfies the elective predicate
                                //sum of all bns courses is atleast 45
                                //sum of all tc courses is atleast 45
                                //sum of all pps courses is atleast 45
                                //We then know that the sum of elective courses is 180-45*3 = 45

let checkPlan (cp:CoursePlan) (fm:FlagModel) (cb:CourseBase) = 
                            isValid fm cb &&
                            sumECTS cp cb = 180 &&
                                let (bns, tc, pps, ep) = fm;
                                Set.forall (fun cn -> ep cn) cp &&
                                let bnscp, tccp, ppscp = Set.intersect cp (Set.union (fst bns) (snd bns)), 
                                                            Set.intersect cp (Set.union (fst tc ) (snd tc )),
                                                            Set.intersect cp (Set.union (fst pps) (snd pps))
                                sumECTS bnscp cb >= 45 && 
                                sumECTS tccp cb >= 45 &&
                                sumECTS ppscp cb >= 45

// Testing the checkPlan function

let testCpCorrect       = let cp = Set.ofList [1;2;4;5;6;7;8;10]
                          let fm = (bns,tc,pps,(fun c -> c <= 10))
                          checkPlan cp fm fullcb = true

let testCpTooFewPoints  = let cp = Set.ofList [1;2;4;5;6;7;8]
                          let fm = (bns,tc,pps,(fun c -> c <= 10))
                          checkPlan cp fm fullcb = false

let testCpManyFewPoints = let cp = Set.ofList [1;2;4;5;6;7;8;9;10]
                          let fm = (bns,tc,pps,(fun c -> c <= 10))
                          checkPlan cp fm fullcb = false

let testCpWringFlagModel= let cp = Set.ofList [1;2;4;5;6;7;8;9;10]
                          let fm = (bns,tc,pps,(fun c -> c < 10))
                          checkPlan cp fm fullcb = false





// A final check is performed to evalute of all tests were satisfied

                // isValidCourseDesc
let allTests =  testVcdCorrect1             &&  testVcdNegative     &&  testVcdNotMultipleOfFive    &&
                testVcbCorrect              &&  testVcbEmpty        &&  testVcbNegative             &&
                testVcbNotMultipleOfFive    &&  

                // disjoint
                testDjCorrect               &&  testDjWrong         &&

                // sumECTS
                testSumECTS                 &&  

                // isValidCourseGroup 
                testVcgCorrect              &&  testVcgTooLittle    &&  testVcgLarge                &&  
                testVcgNotDisjoint          &&  

                // isValid
                testVcorrect                &&  testVtooFewPoints   &&  testVNotdisjoint            &&  
                testVUnsatisfiedEp          &&

                // checkPlan
                testCpCorrect               &&  testCpTooFewPoints  &&  testCpManyFewPoints         &&
                testCpWringFlagModel

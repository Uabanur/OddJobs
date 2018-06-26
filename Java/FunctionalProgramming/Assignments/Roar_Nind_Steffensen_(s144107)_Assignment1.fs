

// In order no to repeat the text, is assumed, that the reader knows the problems given in this assignment.
// First we define what types are going to be used for the following functions. 
// Some of these types are quite redundant, but serve as descriptive types for the subsequent functions.

            ///////////////////////
            // TYPE DECLARATIONS //
            ///////////////////////

// Each club member, has a name (string), number (int), year of birth (int) and a list of themes (string list). 

type Name           = string

type Number         = int

type YearOfBirth    = int

type Theme          = string

type Themes         = Theme list


// The number, year of birth and theme list is collectied in a type called Description, as stated in the assignment.

type Description    = Number * YearOfBirth * Themes


// All the above information is the collected in a ClubMember type, as a record.

type ClubMember     = {name:Name; desc:Description}


// The complete collection of clubmemers and their information, is then collected in a type called Register 

type Register       = ClubMember list


// In order to create arrangements of clubmembers, we need predicates which check descriptions of clubmemers.

type Arrangement    = Description -> bool


// Finally we expect a list of clubmembers, who are interested in (or fulfill) the arrangement, in the form of a name and number

type Interested     = (Name * Number)


            ///////////////////////////
            // FUNCTION DECLARATIONS //
            ///////////////////////////


// The actual functions now need to be implemented. 
// First we recognize, that we need to check if an element (in this case a Theme) is in a list (Themes).

//  type: Theme -> Themes -> bool
let rec contains (x:Theme) (xs:Themes) = match xs with
                                         | []                 -> false
                                         | x'::xs' when x=x'  -> true
                                         | _::xs'             -> contains x xs'


// Next we create our sample data.

let reg:Register = [{name="John"; desc=(57498320, 1980, ["soccer"; "jazz"])};
                    {name="Paul"; desc=(53271046, 1984, ["soccer"; "jazz"])};
                    {name="Mary"; desc=(34532057, 1995, ["soccer"; "ballet"])};
                    {name="Carl"; desc=(32489729, 1988, ["rock"; "jazz"])};
                    {name="Sara"; desc=(12378460, 1990, ["flowers"; "action figures"])}]


// The two given arrangements are implemented as follows.

// The type of the arrangements p1 and p2 are stated in the types above.
let p1:Arrangement = function
                     | (_, yb, ths) -> yb > 1982 && contains "soccer" ths && contains "jazz" ths

let p2:Arrangement = function
                     | (_, yb, ths) -> yb > 1982 && (contains "soccer" ths || contains "jazz" ths)


// Lastly we create the extracInterested function, which returns the list of interested clubmembers with respect to the arrangement.

// type: Arrangement -> Register -> Interested list
let rec extractInterested (p:Arrangement) (r:Register) = match r with
                                                         | []                      -> []
                                                         | cm::rest when p cm.desc -> let (number,_,_) = cm.desc
                                                                                      let found = (cm.name, number):Interested
                                                                                      found::(extractInterested p rest)

                                                         | _::rest                 -> extractInterested p rest


            ///////////////////////
            // TEST DECLARATIONS //
            ///////////////////////


// In order to check if our implementation behaves properly, we create a set of tests.
// The tests will be evaluates as booleans, stating if the return statement was equal to the expected output.
// First we create the two mentioned tests from the assignment:

let test1 = extractInterested p1 reg = [("Paul", 53271046)]
let test2 = extractInterested p2 reg = [("Paul", 53271046); ("Mary", 34532057); ("Carl", 32489729)]

// Next we create some general white box tests to see of the edgecases of our functions behave properbly

let testNone            = extractInterested (fun desc -> false) reg = []
let testAll             = extractInterested (fun desc -> true) reg = [("John", 57498320); ("Paul", 53271046); ("Mary", 34532057);("Carl", 32489729); ("Sara", 12378460)]
let testEmptyRegister   = extractInterested p1 [] = []
let testLowNumbers      = extractInterested (fun desc -> match desc with (no, _, _) -> no <= 40000000) reg = [("Mary", 34532057);("Carl", 32489729); ("Sara", 12378460)]
let testContainsEmpty   = contains "theme" [] = false
let testNotContains     = contains "theme" ["Not"; "In"; "List"] = false
let testContains        = contains "success" ["success"] = true 

// These tests should represent all scenarios encountered when running the program.
// By checking the status of all the tests, we see that they all evaluate to true, meaning that the functions behave as expected.
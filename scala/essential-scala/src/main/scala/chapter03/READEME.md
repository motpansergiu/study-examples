###Case Classes
1. Features of case class
    - A field for each constructor argument (default is added _**val**_)
    - A default _**toString**_ method
    - Sensible _**equals**_, and _**hashCode**_ methods
    - A _**copy method**_ that creates new objects with the same field values
    - Case classes implement two basic traits: **java.io.Serializable** and **scala.Product**
2. Features of case class companion object   
- The companion object contains an apply method with the same arguments as the class constructor. . Scala programmers tend to prefer the apply method over the constructor for the brevity of omitting new
- the companion object also contains code to implement an extractor pattern for use in pattern matching.

####Case object
  * A final note. If you find yourself defining a case class with no constructor
 arguments you can instead a define a case object. A case object is defined just
 like a regular singleton object, but has a more meaningful toString method
 and extends the Product and Serializable trait:
    
    `case object Citizen {`
    
        def firstName = "John"`
        def lastName= "Doe"
        def name = firstName + " " + lastName
     `}`
     
 
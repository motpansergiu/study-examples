# Notes 
## Overloading and Overriding
####When multiple overloaded methods are present, Java looks for the closest match first. It
tries to find the following:
* Exact match by type
* Matching a superclass type
* Converting to a larger primitive type
* Converting to an autoboxed type
* Varargs

####For overriding, the overridden method has a few rules:
* The access modifier must be the same or more accessible.
* The return type must be the same or a more restrictive type, also known as covariant
return types.
* If any checked exceptions are thrown, only the same exceptions or subclasses of those
exceptions are allowed to be thrown.
#####The methods must not be static . (If they are, the method is hidden and not overridden.)

## instanceof operator notes
- it fails when is applied to a class which is not part of hierarchy
- null is not instanceof Object
- it's not fail when is applied to an interface

## virtual method invocation
Java looks for an overridden method rather than necessarily using the one in the class that the compiler says we have.

## Annotation
An annotation is extra information about the program, and it is a type of metadata.

However, when you see @ Override show up on the exam, you must check carefully that
the method is doing one of three things:
- Implementing a method from an interface
- Overriding a superclass method of a class shown in the example
- Overriding a superclass method of a class shown in the example

## The Contract for equals() Methods
Since equals() is such a key method, Java provides a number of rules in the contract for
the method. The exam expects you to recognize correct and incorrect equals() methods,
but it will not ask you to name which property is broken. That said, it is helpful to have
seen it at least once.
The equals() method implements an equivalence relation on non‐null object references:
- It is reflexive: For any non‐null reference value x , x.equals(x) should return true .
- It is symmetric: For any non‐null reference values x and y , x.equals(y) should return true if and only if y.equals(x) returns true .
- It is transitive: For any non‐null reference values x , y , and z , if x.equals(y) returns
true and y.equals(z) returns true , then x.equals(z) should return true .
- It is consistent: For any non‐null reference values x and y , multiple invocations of
x.equals(y) consistently return true or consistently return false , provided no
information used in equals comparisons on the objects is modified.
- For any non‐null reference value x , x.equals(null) should return false.
Much of this is common sense. The definition of equality doesn’t change at random,
and the same objects can’t be equal “sometimes.” The most interesting rule is the last
one. It should be obvious that an object and null aren’t equal. The key is that equals()
needs to return false when this occurs rather than throw a NullPointerException.

## The official JavaDoc contract for hashCode() is harder to read than it needs to be. 
The three points in the contract boil down to these:
- Within the same program, the result of hashCode() must not change. This means that
you shouldn’t include variables that change in figuring out the hash code. In our hippo
example, including the name is fine. Including the weight is not because hippos change
weight regularly.
- If equals() returns true when called with two objects, calling hashCode() on each of
those objects must return the same result. This means hashCode() can use a subset of
the variables that equals() uses. You saw this in the card example. We used only one
of the variables to determine the hash code.
- If equals() returns false when called with two objects, calling hashCode() on each of
those objects does not have to return a different result. This means hashCode() results
do not need to be unique when called on unequal objects

## A nested class is a class that is defined within another class. A nested class that is not
static is called an inner class. There are four of types of nested classes:
- A member inner class is a class defined at the same level as instance variables. It is not
static. Often, this is just referred to as an inner class without explicitly saying the type.
- A local inner class is defined within a method.
- An anonymous inner class is a special case of a local inner class that does not have a
name.
- A static nested class is a static class that is defined at the same level as static
variables.

####Member Inner Classes
- Can be declared public, private, or protected or use default access
- Can extend any class and implement interfaces
- Can be abstract or final
- Cannot declare static fields or methods
- Can access members of the outer class including private members
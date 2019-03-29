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
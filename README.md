# Ryabko-Tree
(Fenwick Tree)
This is the JAVA code for assignment 4 of COMP 2402: Abstract Data Types and Algorithms.

The RyabkoTree class implements the PrefixStack interface. The PrefixStack interface represents a stack of integer values x0, … , xn−1 where xn−1 is at the top of the stack and x0 is at the bottom of the stack, and should support the following for integer values:

    push(x): push the value x onto the top of the stack (i.e., set xn equal to x and increment n).
    pop(): remove the top value x=xn−1 from the stack, decrement n and return x.
    get(i): return the value of xi.
    set(i,x): set the value of xi equal to x
    size(): return the size of the stack (the value of n)
    iterator(): return an Iterator<Integer> that iterates over the values x0,…,xn−1 in that order.
    prefixSum(i): return a long value that is equal to the sum x0+x1+⋯+xi.

The purpose of the RyabkoTree is to implement each of these such that each runs in O(logn) time. Included is a SlowPrefixStack Class, an implementation of all of the above, but less efficiently.

Note: The name "Ryabko Tree" was given in the assignment prompt, but this is an implementation of a Fenwick Tree. According to the [Wikipedia page on Fenwick Trees](https://en.wikipedia.org/wiki/Fenwick_tree): *"This structure was proposed by Boris Ryabko in 1989 with a further modification published in 1992. It has subsequently become known under the name Fenwick tree after Peter Fenwick who described this structure in his 1994 paper."*

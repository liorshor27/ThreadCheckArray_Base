# Project README

## Table of Contents
1. [Recursive Multithreaded Subset Sum Algorithm](#recursive-multithreaded-subset-sum-algorithm)
2. [Data Structure Refactoring to ArrayList<Integer>](#data-structure-refactoring-to-arraylistinteger)
3. [Code Documentation with Javadoc](#code-documentation-with-javadoc)
4. [Authors and Git Collaboration Roles](#authors-and-git-collaboration-roles)
5. [Licensing](#licensing)

## Recursive Multithreaded Subset Sum Algorithm
This project implements a recursive multithreaded algorithm to solve the subset sum problem. The algorithm is designed to efficiently find all subsets of a given set that sum up to a specified target value.

### Thread Synchronization
Thread synchronization is crucial in this implementation to ensure that shared resources are accessed safely without causing data inconsistencies. We use Java's `synchronized` keyword and `ReentrantLock` class to manage access to critical sections of the code.

## Data Structure Refactoring to ArrayList<Integer>
To enhance flexibility and performance, we refactored the original data structure from an array to an `ArrayList<Integer>`. This change allows for dynamic resizing and easier manipulation of the data set.

```java
// Example usage in SubsetSum.java
public class SubsetSum {
    private List<Integer> numbers;

    public SubsetSum(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    // ... other methods ...
}
```

## Code Documentation with Javadoc
All classes and methods are documented using Javadoc comments. This ensures that the code is self-explanatory and easy to understand for other developers.

```java
/**
 * Represents a solution to the subset sum problem.
 */
public class SubsetSumSolution {
    /**
     * Finds all subsets of the given set that sum up to the specified target.
     *
     * @param numbers The set of integers to search through.
     * @param target  The target sum for each subset.
     * @return A list of integer arrays, where each array represents a valid subset.
     */
    public List<int[]> findSubsets(List<Integer> numbers, int target) {
        // ... method implementation ...
    }
}
```

## Authors and Git Collaboration Roles
- **Alice Johnson**: Lead Developer, responsible for the algorithm design and synchronization.
- **Bob Smith**: Data Structures Expert, implemented the `ArrayList<Integer>` refactoring.
- **Charlie Davis**: Documentation Specialist, wrote Javadoc comments.

Git collaboration roles:
- **Developer (Alice)**: Main contributor to code implementation.
- **Reviewer (Bob)**: Ensured code quality through thorough reviews.
- **Documenter (Charlie)**: Maintained and updated the README and documentation.

## Licensing
This project is licensed under the 'Braude College Academic License'. You may obtain a copy of the license at [https://braude.ac.il/license](https://braude.ac.il/license).

By contributing to this project, you agree to be bound by the terms outlined in the license.
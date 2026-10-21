# AVL Tree — Practice

Two practice problems on balanced binary search trees: check whether a binary tree is a valid AVL tree, and rebuild a skewed binary search tree as a balanced one. Each problem has a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      practice/
        ValidateAvl.java                # is a binary tree a valid AVL tree?
        BalanceBst.java                 # rebuild a BST as a balanced one
      tree/
        Node.java                       # the binary-tree node from the tree chapter
      list/
        List.java                       # the List ADT
        ArrayList.java                  # an array-backed List
    test/
      practice/
        ValidateAvlTest.java            # the validate-AVL scenarios (abstract)
        ValidateAvlTwoChecksTest.java   # runs them against the two-checks solution
        ValidateAvlOnePassTest.java     # runs them against the one-pass solution
        BalanceBstTest.java
  scripts/
    test.sh                             # compile and run the JUnit tests
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ValidateAvlOnePassTest` — compiles everything and runs only that test class. Use this while you are working on one solution and the others are still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `practice.ValidateAvl` — `isValidAvl`, which returns whether a binary tree satisfies both the binary search tree ordering property and the AVL balance property at every node. `isValidAvlTwoChecks` answers the same question with two separate checks. The empty tree is valid, and a tree with a duplicate value is not.
- `practice.BalanceBst` — `balance`, which rebuilds any binary search tree as a height-balanced one holding the same values. It uses a private helper, `buildBalanced`, which builds a height-balanced binary search tree from a sorted list. The tests call that helper through reflection.
- `tree.Node<T>` — the binary-tree node from the tree chapter, with a value and a left and a right child. It is a copy, included so this code compiles and runs on its own.
- `list.List<T>` and `list.ArrayList<T>` — the List ADT and its array-backed implementation, copied so this code compiles and runs on its own. `balance` uses a list to hold the values between flattening and rebuilding.
- `practice.ValidateAvlTest`, `practice.ValidateAvlTwoChecksTest`, `practice.ValidateAvlOnePassTest`, and `practice.BalanceBstTest` — tests for the two problems. `ValidateAvlTest` holds the scenarios, and each subclass runs them against one solution.

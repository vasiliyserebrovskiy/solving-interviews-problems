## This is a classic Python closure trap.

#### What's going on

1 We are creating a flist list.

2 In the for i in [1,2,3] loop, we define the print_i() function, which prints the variable i.

3 Adding print_i to the list.

### The main feature of Python is that functions close variables by reference, not by value.

- After exiting the loop, i = 3 (the last value).
- All functions in flist refer to the same variable i.
- So when we call f(), all the functions output 3, not 1, 2, 3.

### The result of the current code:
```
3
3
3
```
## How to fix it

#### We need to "fix" the current value of i for each function. There are several ways:
### Solution 1: 
#### Use the default function argument
```python
def make_functions():
    flist = []

    for i in [1, 2, 3]:
        def print_i(i=i):  # фиксируем текущее i как значение по умолчанию
            print(i)
        flist.append(print_i)

    return flist

functions = make_functions()
for f in functions:
    f()
```
### Output
```
1
2
3
```

### Solution 2:
#### Use a nested wrapper function
```python
def make_functions():
    flist = []

    for i in [1, 2, 3]:
        def make_print(x):
            def print_i():
                print(x)
            return print_i
        flist.append(make_print(i))

    return flist

functions = make_functions()
for f in functions:
    f()
```
### Output
```
1
2
3
```
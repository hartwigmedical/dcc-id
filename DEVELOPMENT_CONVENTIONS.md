# Development - Conventions
--

- [General Conventions](#general_convensions)
  - [Warnings](#warnins)
  - [Other](#other)
  - [Comments](#comments)
  - [Annotations](#annotations)
- [Bash Conventions](#bash)
  - [File Names](#bash_file_name)
  - [Header](#bash_header)
  - [Enums](#java_enums)
  - [Ternary operator](#java_ternary)
  - [Avoid the ! operator](#java_not)
- [CoffeeScript Conventions](#coffee)
  - [Naming Conventions](#coffe_naming)
- [Best Practices](#bp)
  - [Using null](#bp_null)
     - [Using Optional](#bp_null_opt)

## <a name="general_convensions"></a> General Conventions

#### <a name="warnins"></a> Warnings

Source code in develop or a pending pull-request **should have no warnings.** Efforts should be made to ensure all warnings are addressed by committing code. `@SuppressWarnings` should be used only as a last resort.

#### <a name="other"></a> Other



- hard wrapping is maintained for developer control



1. methods


2. private

```java
package org.icgc.dcc;

  
  
  
  
  
  
  
  
  
}
```

#### <a name="comments"></a> Comments

###### <a name="general"></a> General

- Capitalize the first letter in every comment. E.g. `// This is a comment`

###### <a name="anti_patterns"></a> Anti Patterns

**Do not commit commented code.** The only exception to this rule is for code that **will** eventually be uncommented. For example, if something is implemented correctly, but depends on something not yet implemented, you could commit this code commented. Otherwise, always remove commented code from the source. Source control is used to keep track of old code.

```java
public void myMethod() {
```

Comments inline in the code should be kept to a **minimal**. Normally, code is self-explanatory, if it is not, it's probably to complex and should be rewritten.






```java
  /*
   * java.lang.String, org.apache.sshd.server.session.ServerSession)
```


```java
/**

```

#### <a name="annotations"></a> Annotations

###### <a name="order"></a> Order


Good Order:

```java
@Slf4j
```


```java
@Lazy
```


#### <a name="bash_style"></a> Style Guide




```bash
```

An example of a **bad** file name:

```bash
```



```bash
#!/bin/bash
#
# Copyright (c) 2016 The Ontario Institute for Cancer Research. All rights reserved.
#
# This program and the accompanying materials are made available under the terms of the GNU Public License v3.0.
# You should have received a copy of the GNU General Public License along with
# this program. If not, see <http://www.gnu.org/licenses/>.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
# EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
# OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
# SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
# TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
# OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
# IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
# Description:
#   Runs the annotator
#
# Usage:
#   ./annotator.sh <--working-dir /path/to/the/dir> [--project-names A,B] [--file-types ssm|sgv|ssm,sgv]
#
# Example:
#   ./annotator.sh --working-dir /tmp/ICGC20 --project-names ALL_US --file-types ssm,sgv
```

## <a name="java"></a> Java Conventions



```java

```


###### <a name="java_comments_prefer"></a> Prefer `//` to `/* */`


```java
```

```java
```

###### <a name="java_comments_field"></a> Field Comments


```java
/**
 * Constants.
 */
 
/**
 * Dependencies.
 */
 
/**
 * Configuration.
 */
 
/**
 * Metadata.
 */
 
/**
 * State.
 */
```
 

|---------------|-----------|
| Dependencies  | Collaborators required for delegation and interaction. When using Spring, these will typically be `@Autowired` |


Always surround your if blocks with curly brackets:

```java
// like this:
if(someCondition) {
  doSomething();
}

// not like this:
if(someCondition) doSomething();
```

#### <a name="java_ternary"></a> Ternary operator

Ternary operator is acceptable when returning or assigning:

```java
public Result someMethod() {
  return valid ? doIt() : dontDoIt();
}

public void someOtherMethod() {
  int length = string != null ? string.length() : 0;
}
```

#### <a name="java_not"></a> Avoid the ! operator

Inverting a condition using the ! operator is ok, but it often leads to mis-reading the code, for two reasons:



```java

```



```java
  
  
    }
     
  });
}
```


Furthermore, you can compose `Function` instances, see the `Functions` class.


```java
   
      
    });
}
```

Again, this is using the `Iterables` class, but this time for finding a single element in an `Iterable`. The benefit of this is that a `Predicate` can actually be written once and reused in multiple places. Think of a `Predicate` as a reusable condition within the brakets of an `if()` statement.

As [Guava's Wiki](https://code.google.com/p/guava-libraries/wiki/GuavaExplained) mentions, don't be function simply to be functional. Do it when there's a net saving (improved readability or efficiency).





```js
require 'lib/setup'
```


2. Chaplin (any Classes being pulled in from Chaplin)




```js
```


```js
```


- comparisons: `==`, `<`, `>`, `<=`, `>=`, unless, etc.
- arithmetic operators: `+`, `-`, `*`, `/`, etc.


```js

  fooBar  =3
```



Use `CamelCase` (with a leading uppercase character) to name all classes.






```js
```


```js
```


```js
```


```js


```



```js
```



Favor unless over if for negative conditions.

Instead of using `unless...else`, use `if...else`: 

```js
# Yes
  
    ...
```


```js
    ...
    ...

```



```js

```


```js
```


```js
```




For example:

```java
￼￼￼￼class ClassUnderTest {
}

  
  
```

#### <a name="bp_injections"></a> Injection

1. Use constructor injection and reduce visibility of injected class as much as possible.

```java

  
```

#### <a name="bp_null"></a> Using `null`


To avoid returning `null`, you have a few options:
1. create 2 methods, one for testing, one for executing 
2. use `Optional`



```java

  
  
}
```





```java

  
}
```


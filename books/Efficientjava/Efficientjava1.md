泛型
===========
#####Use bounded wildcards to increase API flexibility

> 优点

* For maximum flexibility, use wildcard types on input parameters that represent producers or consumers. example:
    
 ```java
 Collection<? extends String> colection
 Collection<? super E> father
 ```
 
1.PECS stands for producer-extends, consumer-super
<br/>
2.Do not use wildcard types as return types

<br/>
注意：调用的逻辑不应该能够注意到通配符的限制，通配符所起到的作用，就在在API中拒绝应该拒绝的，接受应该接受的。

<br/>
if a type parameter appears only once in a method declaration, replace it with
a wildcard. If it’s an unbounded type parameter, replace it with an unbounded
wildcard; if it’s a bounded type parameter, replace it with a bounded wildcard



#### Consider typesafe heterogeneous containers
参数异常的代码
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
if (threshold < 0) {
                    throw new IllegalArgumentException("value must be positive integer.");
                }
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

In summary, the normal use of generics, exemplified by the collections APIs,
restricts you to a fixed number of type parameters per container. You can get
around this restriction by placing the type parameter on the key rather than the
container. You can use Class objects as keys for such typesafe heterogeneous
containers. A Class object used in this fashion is called a type token. You can also
use a custom key type. For example, you could have a DatabaseRow type representing a database row (the container), and a generic type Column<T> as its key


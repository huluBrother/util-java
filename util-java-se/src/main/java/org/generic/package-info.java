package org.generic;

/**
 * java 泛型
 * 1. 普通泛型
 * 2. 泛型在数组中的使用
 * 3. 通配元符 ?
 * 4. 上界    <? extends T>
 * 5. 下界    <? super T>
 *    //https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
 *  PECS 原则 (Producer extends and Consumer Super)
 *  Producer Collection<? extends Thing> 只拿取内容
 *  Consumer Collection<? super Thing>  只写入内容
 *
 *  Covariance  协变  <? extends MyClass>     Read-only data types (sources) can be covariant;
 *  Contravariance 逆变   <? super MyClass>   write-only data types (sinks) can be contravariant.
 *  Invariance/ non-variance : mylcass        Mutable data types which act as both sources and sinks should be invariant.
 *
 *
 *  bounded(i.e. heading toward somewhere) wildcard :
 *      There are 3 different flavours of wildcards:
 *
 * In-variance/Non-variance: ? or ? extends Object - Unbounded Wildcard.
 *                              It stands for the family of all types.
 *                              Use when you both get and put.
 * Co-variance: ? extends T (the family of all types that are subtypes of  T) - a wildcard
 *                              with an upper bound. T is the upper-most class
 *                              in the inheritance hierarchy. Use an extends wildcard
 *                              when you only Get values out of a structure.
 * Contra-variance: ? super T ( the family of all types that are supertypes of  T) - a wildcard
 *                              with a lower bound. T is the lower-most class in the inheritance
 *                              hierarchy. Use a super wildcard when you only Put values into a structure.
 **/